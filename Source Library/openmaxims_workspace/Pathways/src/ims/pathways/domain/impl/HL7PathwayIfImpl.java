//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.domain.impl;

import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ContractServiceLocationsConfigVo;
import ims.RefMan.vo.domain.ContractServiceLocationsConfigVoAssembler;
import ims.core.admin.domain.objects.Referral;
import ims.core.clinical.domain.objects.TaxonomyMap;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.configuration.domain.objects.ContractServiceLocationsConfig;
import ims.core.configuration.vo.ContractConfigRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.HL7ReferralVo;
import ims.core.vo.ReferralLiteVo;
import ims.core.vo.domain.HL7ReferralVoAssembler;
import ims.core.vo.domain.ReferralLiteVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;
import ims.domain.lookups.Lookup;
import ims.domain.lookups.LookupInstance;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.pathways.configuration.domain.objects.Event;
import ims.pathways.configuration.domain.objects.EventTarget;
import ims.pathways.configuration.domain.objects.ExternalEventMapping;
import ims.pathways.configuration.domain.objects.Pathway;
import ims.pathways.configuration.domain.objects.PathwayTarget;
import ims.pathways.configuration.domain.objects.RTTEvent;
import ims.pathways.configuration.domain.objects.Target;
import ims.pathways.configuration.vo.TargetRefVo;
import ims.pathways.domain.CreateNewPathway;
import ims.pathways.domain.base.impl.BaseHL7PathwayIfImpl;
import ims.pathways.domain.objects.JourneyTargetStatus;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PatientEvent;
import ims.pathways.domain.objects.PatientJourneyStatus;
import ims.pathways.domain.objects.PatientJourneyTarget;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.domain.objects.PauseDetails;
import ims.pathways.vo.EventVo;
import ims.pathways.vo.ExternalEventMappingVo;
import ims.pathways.vo.PathwayLiteVo;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.PatientJourneyTargetRefVo;
import ims.pathways.vo.PatientJourneyVo;
import ims.pathways.vo.PatientPathwayJourneyRefVo;
import ims.pathways.vo.RTTEventVo;
import ims.pathways.vo.domain.EventVoAssembler;
import ims.pathways.vo.domain.ExternalEventMappingVoAssembler;
import ims.pathways.vo.domain.PathwayLiteVoAssembler;
import ims.pathways.vo.domain.PatientEventVoAssembler;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTEventVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.pathways.vo.lookups.JourneyCountType;
import ims.pathways.vo.lookups.JourneyStatus;
import ims.pathways.vo.lookups.PathwaysDetail;
import ims.pathways.vo.lookups.PathwaysGroup;
import ims.pathways.vo.lookups.PatientTargetStatus;
import ims.pathways.vo.lookups.RTTAction;
import ims.pathways.vo.lookups.TargetDateCalculation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class HL7PathwayIfImpl extends BaseHL7PathwayIfImpl implements ims.core.helper.IPathwayPatientEventHelper
{

	private static final long serialVersionUID = 1L;
	
	// Fixed RTT Event Types that require action
	private static final String PAUSE_PATHWAY="PA";
	private static final String UNPAUSE_PATHWAY="PU";
	public static final String AMEND_CLOCK_START="AS";
	

	/**
	* This method will retrieve the Event based on the External Event information passed in
	 * @throws DomainInterfaceException 
	*/
	public EventVo getEventByExternalMappings(ims.pathways.configuration.vo.ExternalEventMappingRefVo externalEvent) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" select ev.event from EventExternalEventMapping ev where ev.externalEventMapping.id = :eventMap and ev.status.id =:status and ev.event.status.id = :status");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("eventMap");
		labels.add("status");
		values.add(externalEvent.getID_ExternalEventMapping());
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching event by ExtMappings");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return EventVoAssembler.create((Event) lst.get(0));
		}
		
		return null;
	}
	
	

	/**
	* Gets the event based on the RTT values passed in
	 * @throws DomainInterfaceException 
	*/
	public ims.pathways.vo.EventVo getEventByRttValues(ims.pathways.configuration.vo.RTTEventRefVo rttEvent) throws DomainInterfaceException
	{
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer(" select ev.event from EventRTTEvent ev where ev.status.id = :status and ev.rTTEvent.id = :rttEvent and ev.event.status.id = :status");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("status");
		labels.add("rttEvent");
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		values.add(rttEvent.getID_RTTEvent());
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching event by RttValues ");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return EventVoAssembler.create((Event) lst.get(0));
		}
		
		return null;
	}
	
	
	
	/**
	* Gets the event based on the RTT values passed in
	 * @throws DomainInterfaceException 
	*/
	public ims.pathways.vo.EventVo getEventByTaxonomyMap(TaxonomyType taxType, String value) throws DomainInterfaceException
	{
		if (taxType == null || value == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer(" select ev from Event ev join ev.taxonomyMaps tx where ev.status.id = :status and tx.taxonomyName = :taxType and tx.taxonomyCode = :taxCode");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("status");
		labels.add("taxType");
		labels.add("taxCode");
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		values.add(getDomLookup(taxType));
		values.add(value);
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching event by Taxonomy ");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return EventVoAssembler.create((Event) lst.get(0));
		}
		
		return null;
	}

	
	/**
	* Gets the event based on the RTT values passed in
	 * @throws DomainInterfaceException 
	*/
	public TargetRefVo getTargetByTaxonomyMap(TaxonomyType taxType, String value) throws DomainInterfaceException
	{
		if (taxType == null || value == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" select tg from Target tg join tg.taxonomyMaps tx where tg.status.id = :status and tx.taxonomyName = :taxType and tx.taxonomyCode = :taxCode");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("status");
		labels.add("taxType");
		labels.add("taxCode");
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		values.add(getDomLookup(taxType));
		values.add(value);
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching Target by Taxonomy ");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			Target domTarget = (Target) lst.get(0);
			return new TargetRefVo(domTarget.getId(), domTarget.getVersion());
		}
		
		return null;
	}
	
	public PatientJourneyVo getPatientJourney(ReferralLiteVo referral) throws DomainInterfaceException
	{
		return PatientJourneyVoAssembler.create(PatientPathwayJourney.getPatientPathwayJourneyFromExtReferralKey(getDomainFactory(), referral.getExtReferralKey()));
	}
	
	private PatientJourneyStatus createPatientJourneyStatus(LookupInstance toStat)
	{
		PatientJourneyStatus stat = new PatientJourneyStatus();
		stat.setDateTime(new Date());
		stat.setStatus(toStat);
		return stat;
	}
	
	private JourneyTargetStatus createJourneyTargetStatus(LookupInstance toStat)
	{
		JourneyTargetStatus tStat = new JourneyTargetStatus();
		tStat.setDate(new Date());
		tStat.setChangedBy("HL7Interface");
		tStat.setStatus(toStat);
		return tStat;
	}

	public PatientJourneyVo createPatientJourney(PatientJourneyVo patJourney, ReferralLiteVo referral, Specialty specialty, HcpRefVo consultant,Boolean non18week) throws StaleObjectException, DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		
		// wdev-3822  Only validate specialty when creating a new journey
		if (specialty == null && !patJourney.getID_PatientPathwayJourneyIsNotNull())
			throw new DomainInterfaceException("Patient Journey cannot be created as specialty has not been provided/mapped");
		
		PatientPathwayJourney domJourney = PatientJourneyVoAssembler.extractPatientPathwayJourney(factory, patJourney);
		
		if(referral != null)
			domJourney.setReferral(ReferralLiteVoAssembler.extractReferral(factory, referral));
		
		// Find the Pathway for this journey
		Pathway domPth = domJourney.getPathway();
		if(specialty != null)
		{
			// wdev-6362
			if (non18week != null && non18week.booleanValue())
			{
				domPth = findPseudoPathway(factory, specialty);
				if (domPth == null)
					throw new DomainInterfaceException("Pseudo Pathway not found - cannot create Patient Journey");
			}
			else
			{
				domPth = findDefaultPathway(factory, specialty, consultant);
				if (domPth == null && !Specialty.EMERGENCY.equals(specialty)) // WDEV-18703 
					domPth = findDefaultPathway(factory, Specialty.EMERGENCY, consultant);
			}
			if (domPth == null)
				throw new DomainInterfaceException("Default Pathway not found - cannot create Patient Journey");

			domJourney.setPathway(domPth);
		}

		// Setup Status
		PatientJourneyStatus stat = createPatientJourneyStatus(getDomLookup(JourneyStatus.STARTCLOCK));
		domJourney.setCurrentStatus(stat);
		domJourney.getStatusHistory().add(stat);
		
		/*
		// If journey target end date is null, we need to calculate it from the pathway value of weeks
		if (domJourney.getTargetEndDate() == null)
		{
			domJourney.setTargetEndDate(addValueToDate(domJourney.getStartDate(), domPth.getNumWeeksDays(), domPth.getJourneyCountType(), domJourney.getCurrentClock()));
		}
		*/
		
		// We need to figure out which Patient Targets to instantiate
		List lst = factory.find(" from PathwayTarget pt where pt.pathway = :pathway and pt.status.id = :status", new String[]{"pathway", "status"}, new Object[]{domPth, PreActiveActiveInactiveStatus.ACTIVE.getId()});
		if (lst != null && lst.size() > 0)
		{
			Iterator it = lst.iterator();
			while (it.hasNext())
			{
				PathwayTarget domPt = (PathwayTarget) it.next();
				

				// wdev-8754 - If this target is already set in the journey for the current clock
				// do not re-create.  This could happen when changing pathway types
				// Only do this on change of pathway type i.e not a completely new domJourney record
				if (domJourney.getId() != null && domJourney.getCurrentClock() != null && isTargetForCurrentClock(factory, domJourney, domPt.getTarget(), domJourney.getCurrentClock().getId()))
					continue;

				
				PatientJourneyTarget domJournTarg = new PatientJourneyTarget();
				domJournTarg.setPathwayTarget(domPt);

				JourneyTargetStatus tStat=null;
				if (domPt.isActivateTarget())
				{
					tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.INSCOPE));
					// wdev-4091 only set clock when being brought into scope
					domJournTarg.setJourneyClock(domJourney.getCurrentClock());
				}
				else
					tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.NOTINSCOPE));
				
				domJournTarg.setCurrentStatus(tStat);
				domJournTarg.getStatusHistory().add(tStat);
				domJournTarg.setWeekNumber(calculateWeekNum(domPt.getTargetPeriod(), domPt.getPathway().getJourneyCountType()));
				domJournTarg.setPathwayJourney(domJourney);
				
				domJournTarg.setTargetDate(addValueToDate(domJourney.getStartDate(), domPt.getTargetPeriod(), domPt.getPathway().getJourneyCountType(), domJourney.getCurrentClock()));
				domJournTarg.setTargetCalFromDate(domJourney.getStartDate());
				domJourney.getPatientTargets().add(domJournTarg);
			}
		}
		
		factory.save(domJourney);
		
		return PatientJourneyVoAssembler.create(domJourney);
	}
	
	private Pathway findPseudoPathway(DomainFactory factory, Specialty specialty) throws DomainInterfaceException
	{
		// Specialty is mandatory - cannot find pathway without it
		if (specialty == null)
			throw new DomainInterfaceException("Specialty is mandatory in search of pathway - cannot continue");
		
		StringBuffer hql = new StringBuffer();
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		hql.append(" from Pathway pw where pw.specialty.id = :specialty and pw.status.id = :status and pw.isNon18Week is true");
		labels.add("specialty");
		labels.add("status");
		values.add(specialty.getId());
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			// Throw Exception if more than Pathway found matching search criteria
			throw new DomainInterfaceException("Duplicate Pathway Data found - cannot continue");
		}
		else if (lst != null && lst.size() == 1)
		{
			return (Pathway) lst.get(0);
		}
		
		return null;
	}

	/**
	 * WDEV-6362
	 * Calculate the Week Numbe for the target, based on the journeyCountType if weeks, simply
	 * return the targetPeriod, if days, divide by 7
	 * @param targetPeriod
	 * @param journeyCountType
	 * @return
	 */
	private Integer calculateWeekNum(Integer targetPeriod, LookupInstance journeyCountType)
	{
		if (journeyCountType == null || journeyCountType.getId() == JourneyCountType.WEEKS.getId())
			return targetPeriod;
		else
			return targetPeriod/7;
	}

	public static final Date addValueToDate(Date fromValue, int numVal, LookupInstance timeType, PathwayClock clock)
	{
		return addValueToDate(fromValue, numVal, timeType, clock, null, null);
	}
	
	public static final Date addValueToDate(Date fromValue, int numVal, LookupInstance timeType, PathwayClock clock, Date currentTarget, Date targetCalculatedFrom)
	{
		Calendar targetCal =  Calendar.getInstance();
		
		// wdev-6508 - if recalculating dates, use the calculatedFrom value if updating an existing
		// target in case the target was based on an event date and not pathway start
		if (targetCalculatedFrom != null)
			targetCal.setTime(targetCalculatedFrom);
		else
			targetCal.setTime(fromValue);
		
		if (timeType == null || timeType.getId() == JourneyCountType.WEEKS.getId())
			numVal *= 7;
		targetCal.add(Calendar.DATE, numVal);
		targetCal.add(Calendar.DATE, -1);   // wdev-3990 
		
		// wdev-6362
		// When calculating the time to add to the to value, we need to cater for any pause dates within the pathwayclock
		if (clock != null && clock.getPauseDetails() != null)
		{
			int daysToAdd=0;
			for (int i=0; i<clock.getPauseDetails().size(); i++)
			{
				PauseDetails domPause= (PauseDetails) clock.getPauseDetails().get(i);
				// Only add pause details to calculations if from date after the pause date
				if (domPause.getPauseStart() != null && domPause.getPauseStop() != null && (currentTarget == null || domPause.getPauseStart().before(currentTarget)))
				{
					daysToAdd += calculateTimeDiff(domPause.getPauseStart(), domPause.getPauseStop(), new LookupInstance(JourneyCountType.DAYS.getId(), new Lookup(JourneyCountType.TYPE_ID, "Journey Count Desc", ""), JourneyCountType.DAYS.isActive(), JourneyCountType.DAYS.getText()) );
				}
			}
			if (daysToAdd > 0)
				targetCal.add(Calendar.DATE, daysToAdd); 
		}
		
		return targetCal.getTime();
	}
	
	
	public static final int calculateTimeDiff(Date targetDate, Date achievedDate, LookupInstance timeType)
	{
		Long targetTime = targetDate.getTime();
		Long achievedTime = achievedDate.getTime();
		Long datediff = achievedTime - targetTime;
		
		if (timeType == null || timeType.getId() == JourneyCountType.WEEKS.getId())
		{
			// 	Need to convert the datediff milliseconds to weeks
			Long weekDiff = ((((datediff / 1000)/*seconds*/ / 3600)/*hours*/ /24) /*days*/ / 7) /*week*/;
			return weekDiff.intValue();
		}
		else
		{
			// 	Need to convert the datediff milliseconds to days
			Long dayDiff = (((datediff / 1000)/*seconds*/ / 3600)/*hours*/ /24) /*days*/;
			return dayDiff.intValue();
		}
	}
	
	private Pathway findDefaultPathway(DomainFactory factory, Specialty specialty, HcpRefVo consultant) throws DomainInterfaceException
	{
		// Specialty is mandatory - cannot find pathway without it
		if (specialty == null)
			throw new DomainInterfaceException("Specialty is mandatory in search of pathway - cannot continue");
		
		StringBuffer hql = new StringBuffer();
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		hql.append(" from Pathway pw where pw.specialty.id = :specialty and pw.status.id = :status");
		labels.add("specialty");
		labels.add("status");
		values.add(specialty.getId());
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		
		if (consultant != null)
		{
			hql.append(" and pw.consultant.id = :consultant");
			labels.add("consultant");
			values.add(consultant.getID_Hcp());
		}
		else
		{
			hql.append(" and pw.isDefault is true");
		}
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			// Throw Exception if more than Pathway found matching search criteria
			throw new DomainInterfaceException("Duplicate Pathway Data found - cannot continue");
		}
		else if (lst != null && lst.size() == 1)
		{
			return (Pathway) lst.get(0);
		}
		
		
		// If the default pathway was not found and the consultant is set, try looking for a default pathway without it
		if (consultant == null)
			return null;  // As have already checked for default for specialty
		
		hql = new StringBuffer();
		labels = new ArrayList<String>();
		values = new ArrayList<Object>();

		hql.append(" from Pathway pw where pw.specialty.id = :specialty and pw.status.id = :status and pw.isDefault is true");
		labels.add("specialty");
		labels.add("status");
		values.add(specialty.getId());
		values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			// Throw Exception if more than Pathway found matching search criteria
			throw new DomainInterfaceException("Duplicate Pathway Data found - cannot continue");
		}
		else if (lst != null && lst.size() == 1)
		{
			return (Pathway) lst.get(0);
		}
		
		// No default pathway found either.
		return null;
	}

	/**
	 * WDEV-23784 - Pass the referral into the main method when available to prevent unnecessary queries
	 * @param patientEvent
	 * @param referral
	 * @return
	 * @throws StaleObjectException
	 * @throws DomainInterfaceException
	 */
	public PatientEventVo instantiatePatientEvent(PatientEventVo patientEvent, CatsReferralRefVo catsReferral) throws StaleObjectException, DomainInterfaceException
	{
		return instantiatePatientEvent(patientEvent, null, null, catsReferral);//WDEV-19700
	}

	public PatientEventVo instantiatePatientEvent(PatientEventVo patientEvent) throws StaleObjectException, DomainInterfaceException
	{
		return instantiatePatientEvent(patientEvent, null, null);//WDEV-19700
	}

	//WDEV-19700
	public PatientEventVo instantiatePatientEvent(PatientEventVo patientEvent, String eventTargetPASMappingValue) throws DomainInterfaceException, StaleObjectException //WDEV-19700
	{
		return instantiatePatientEvent(patientEvent, null, null, null);
	}
	
	// WDEV-20947 - We only start clock if the associated referral is subject to RTTClock
	public PatientEventVo instantiatePatientEvent(PatientEventVo patientEvent, String eventTargetPASMappingValue, Boolean rttClockImpact) throws DomainInterfaceException, StaleObjectException //WDEV-19700
	{
		return instantiatePatientEvent(patientEvent, eventTargetPASMappingValue, rttClockImpact, null);	
	}
	
	public PatientEventVo instantiatePatientEvent(PatientEventVo patientEvent, String eventTargetPASMappingValue, Boolean rttClockImpact, CatsReferralRefVo catsReferral) throws DomainInterfaceException, StaleObjectException //WDEV-19700
	{
		DomainFactory factory = getDomainFactory();
		
		
		if (patientEvent.getActionCodeIsNotNull() && patientEvent.getActionCode().equals("DE"))
		{
			// We want to update the status of a previous event/target to Cancelled
			// If the externalEventId is null, we cannot identify the event to cancel,
			// so we reject the message
			if (!patientEvent.getExternalEventIdIsNotNull())
				throw new DomainInterfaceException("ExternalEventId is null, the event to cancel cannot be identified");
			
			List lst = factory.find(" from PatientEvent pe where pe.externalEventId = :externalEvent", "externalEvent", patientEvent.getExternalEventId());
			if (lst == null || lst.size() == 0)
			{
				throw new DomainInterfaceException("PatientEvent not found with this external event id - " + patientEvent.getExternalEventId());
			}
			else if (lst != null && lst.size() > 1)
			{
				throw new DomainInterfaceException("More than one PatientEvent has been found matching this externalEventId - " + patientEvent.getExternalEventId());
			}
			else
			{
				PatientEvent prevDomPatientEvent = (PatientEvent) lst.get(0);
				prevDomPatientEvent.setEventStatus(getDomLookup(EventStatus.RIE));
				factory.save(prevDomPatientEvent);
				return PatientEventVoAssembler.create(prevDomPatientEvent);
			}
		}

		PatientEvent domPatientEvent = PatientEventVoAssembler.extractPatientEvent(factory, patientEvent);
		
		if (domPatientEvent.getEventStatus() == null)
			domPatientEvent.setEventStatus(getDomLookup(EventStatus.ACTIVE));
		
		
		// wdev-6263 - If this is a pause or unpause event, we want to clear the scheduled date from the
		// PatientEvent, as it was populated for the pause details only
		// wdev-7264 - Similar for AmendClockStart items, the new date is temporarily held within ScheduledDate
		Date workDate=null;
		if (domPatientEvent.getRttExternalEvent() != null && 
				(domPatientEvent.getRttExternalEvent().getPASCode().equals(PAUSE_PATHWAY) ||
				domPatientEvent.getRttExternalEvent().getPASCode().equals(UNPAUSE_PATHWAY) ||
				domPatientEvent.getRttExternalEvent().getPASCode().equals(AMEND_CLOCK_START)))
		{
			workDate = domPatientEvent.getScheduledDate();
			domPatientEvent.setScheduledDate(null);
		}
			
		/*
		//	wdev-3833 If journey target end date is null, we need to calculate it from the pathway value of weeks
		if (domPatientEvent.getJourney() != null && domPatientEvent.getJourney().getTargetEndDate() == null)
		{
			domPatientEvent.getJourney().setTargetEndDate(addValueToDate(domPatientEvent.getJourney().getStartDate(), domPatientEvent.getJourney().getPathway().getNumWeeksDays(), domPatientEvent.getJourney().getPathway().getJourneyCountType(), domPatientEvent.getJourney().getCurrentClock()));
		}
		*/
		
		// wdev-4087 - This logic was moved up so that when the undo stop clock occurs, other targets
		// will be updated if required
		// wdev-3808 If this event is link to an RTT Event with a code of Z, it means undo stop clock
		// We want to remove the end value of the current clock
		boolean undoStopClockEvent=false;  // wdev-6919
		if (domPatientEvent.getRttExternalEvent() != null && domPatientEvent.getRttExternalEvent().getPASCode().equalsIgnoreCase("Z"))
		{
			undoStopClockEvent=true;  // wdev-6919
			domPatientEvent.getJourney().getCurrentClock().setStopDate(null);	
			
			// When stopping a clock, we update all non achieved,cancelled PatientJourneyTargets to CLOCK_STOPPED
			Iterator it = domPatientEvent.getJourney().getPatientTargets().iterator();
			while (it.hasNext())
			{
				PatientJourneyTarget domPjt = (PatientJourneyTarget) it.next();
				
				// Only modified targets associated with the current clock  wdev-4091
				if (domPjt.getJourneyClock() == null || domPatientEvent.getJourney().getCurrentClock().getId() != domPjt.getJourneyClock().getId())
					continue;

				if (domPjt.getCurrentStatus().getStatus().getId() == PatientTargetStatus.CLOCKSTOP.getId())
				{
					JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.INSCOPE));
					domPjt.setCurrentStatus(tStat);
					domPjt.getStatusHistory().add(tStat);
				}
			}
		}
		
		// wdev-7917
		// If this is a CPT CO (change to original referral date, we should update the referral OriginalReferralDate)
		if (domPatientEvent.getExternalEvent() != null && domPatientEvent.getExternalEvent().getGroup().getId() == PathwaysGroup.CPT.getId() &&
				domPatientEvent.getExternalEvent().getDetail().getId() == PathwaysDetail.CO.getId())
		{
			domPatientEvent.getJourney().getReferral().setOriginalReferralDate(domPatientEvent.getEventDateTime());
		}
		// If this is a CPT ADT (change referral date, we should update the referral ReferralReceivedDate)
		if (domPatientEvent.getExternalEvent() != null && domPatientEvent.getExternalEvent().getGroup().getId() == PathwaysGroup.CPT.getId() &&
				domPatientEvent.getExternalEvent().getDetail().getId() == PathwaysDetail.RDA.getId())
		{
			domPatientEvent.getJourney().getReferral().setReferralReceivedDate(domPatientEvent.getEventDateTime());
		}
	
		
		// Create a new clock if so required
		if(domPatientEvent != null && domPatientEvent.getEvent() != null && Boolean.TRUE.equals(domPatientEvent.getEvent().isStartsClock()))
		{
			// WDEV-20947 Only create a new clock if journey subject to RTT
			if(domPatientEvent.getJourney() != null && (rttClockImpact == null || rttClockImpact.booleanValue() == true) && (domPatientEvent.getJourney().getCurrentClock() == null || (domPatientEvent.getJourney().getCurrentClock() != null && domPatientEvent.getJourney().getCurrentClock().getStopDate() != null)))
			{
				PathwayClock newClock = createNewClock(domPatientEvent);
				
				domPatientEvent.getJourney().setCurrentClock(newClock);
				
				if(domPatientEvent.getJourney().getClockHistory() == null)
					domPatientEvent.getJourney().setClockHistory(new java.util.HashSet());
				
				domPatientEvent.getJourney().getClockHistory().add(newClock);
				
//				if(domPatientEvent.getPatientTarget() != null)
//				{
//					domPatientEvent.getPatientTarget().setJourneyClock(newClock);
//				}
			}
		}
		
		// wdev-4059 We are only interested updating targets if there is a current clock i.e. not stopped
		// WDEV-20947 we want to update targets if referral not subject to RTT regardless of whether a clock exists or not
		if (domPatientEvent.getJourney() != null && ((rttClockImpact != null && rttClockImpact.booleanValue() == false) || (domPatientEvent.getJourney().getCurrentClock() != null && domPatientEvent.getJourney().getCurrentClock().getStopDate() == null)))
		{
			CatsReferral domReferral=null;
			// WDEV-23784
			// If the catsReferral is passed into this method, use it, otherwise query for it.
			if (catsReferral != null)
			{
				domReferral = (CatsReferral) factory.getDomainObject(CatsReferral.class, catsReferral.getID_CatsReferral());
			}
			else  // WDEV-23784 end
			{
				//WDEV-21693
				domReferral = getCatsReferralForJourney(domPatientEvent.getJourney());
			}
			
			if (domReferral != null && domReferral.getJourney() != null && domReferral.getJourney().getCurrentClock() != null && domReferral.getJourney().getCurrentClock().getId() != null)// WDEV-22277 - add domReferral.getJourney().getCurrentClock().getId() != null
				getDomainFactory().refresh(domReferral.getJourney().getCurrentClock());
			
			// Set the PatientJourneyTarget and get the EventTarget so that
			// we will know what to do with the Journey or Target status
			Set domEventTargList = getEventTarget(factory, domPatientEvent);
			if (domEventTargList != null && domEventTargList.size() > 0)
			{
				ArrayList newPjt = new ArrayList();
				Iterator it = domEventTargList.iterator();
				while (it.hasNext())
				{
					EventTarget domEventTarg = (EventTarget) it.next();
			
					if (domEventTarg != null && domEventTarg.getSetJourneyTargetStatusTo() != null)
					{
						// WDEV-15589 First iterate through the PJTs to see if the target exists for the current
						// pathway.  If one found, break and use this for target instantiation, otherwise
						// use one in the journey itself
						PatientJourneyTarget pjtPathwayTarget=null;
						Iterator patTargetPathwayIt = domPatientEvent.getJourney().getPatientTargets().iterator();
						while (patTargetPathwayIt.hasNext())
						{
							PatientJourneyTarget domPjt = (PatientJourneyTarget) patTargetPathwayIt.next();
							if (domPjt.getPathwayTarget().getTarget().getId() == domEventTarg.getTarget().getId() &&
									domPjt.getPathwayTarget().getPathway().getId() == domPatientEvent.getJourney().getPathway().getId())
							{
								pjtPathwayTarget = domPjt;
								break;
							}
						}
						
						// wdev-3811 We have to figure out which patient target we have to update as there is currently
						// only one associated with the event, we need to loop through the journey targets
						Iterator patTargetIt = domPatientEvent.getJourney().getPatientTargets().iterator();
						while (patTargetIt.hasNext())
						{
							PatientJourneyTarget domPjt = (PatientJourneyTarget) patTargetIt.next();
							
							// WDEV-15589
							if (pjtPathwayTarget != null)
								domPjt = pjtPathwayTarget;
							
							//WDEV-19700
							if (eventTargetPASMappingValue!=null && !targetHasSamePASMapping(domPjt,eventTargetPASMappingValue))
							{
								break;
							}
							
							if (domPjt.getPathwayTarget().getTarget().getId() == domEventTarg.getTarget().getId())
							{
								
								// wdev-3824 Only update target status if it is currently not not-in-scope unless setting in in scope
								if (domPjt.getCurrentStatus().getStatus().getId() != PatientTargetStatus.NOTINSCOPE.getId() ||
										// wdev-6919 domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.INSCOPE.getId() ||
										(domEventTarg.isSetToInScope() != null && domEventTarg.isSetToInScope() == true))  // wdev-4026
								{
									// wdev-4091 We only want to update the target if it's clock is null, or
									// is the same as the journey's current clock
									if (domPjt.getJourneyClock() != null && domPjt.getJourneyClock().getId() != domPatientEvent.getJourney().getCurrentClock().getId())
									{
										// WDEV-7244 check db to see if dompjt at all for current clock, if not, create a new one
									if (!isPatientJourneyTargForClock(factory, domPjt, domPatientEvent.getJourney().getCurrentClock().getId()))
										{
											// Ensure not already in the newPjt list by checking each PathwayTarget
											int i;
											for (i=0; i<newPjt.size(); i++)
											{
												PatientJourneyTarget newVal = (PatientJourneyTarget) newPjt.get(i);
												if (newVal.getPathwayTarget().getId().equals(domPjt.getPathwayTarget().getId()))
													break;
											}
											if (i<newPjt.size())
												continue;
											
											// wdev-8852 Only create new if setting to in-scope  
											if (domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.INSCOPE.getId() ||
												(domEventTarg.isSetToInScope() != null && domEventTarg.isSetToInScope() == true)) 
											{										
												PatientJourneyTarget domTarg =createPJTForClock(domPjt, domPatientEvent, domEventTarg);
												domPatientEvent.setPatientTarget(domTarg);
												newPjt.add(domTarg);
											}
										}
										
										continue;  // Loop as we don't want to update this target
									}
									
									
									// wdev-4140 can only go from Achieved to eventCancelled, so continue if this is not the case for achieved
									if (domPjt.getCurrentStatus().getStatus().getId() == PatientTargetStatus.TARGETACHIEVED.getId() 
											&& domEventTarg.getSetJourneyTargetStatusTo().getId() != PatientTargetStatus.EVENTCANCELLED.getId() 
											&&	domEventTarg.getSetJourneyTargetStatusTo().getId() != PatientTargetStatus.RECALCULATE_ONLY.getId() // wdev-8695
											&& !undoStopClockEvent)  // wdev-6919  If undoStopClock, can go from achieved back to inscope if configured that way
										continue;
									
									domPatientEvent.setPatientTarget(domPjt);
									// wdev-4091 - Calculate targetDate and set clock if bringing into scope
									if (domPjt.getJourneyClock() == null && (rttClockImpact == null || rttClockImpact.booleanValue() == true)) // WDEV-20947  // wdev-6919, do not recalculate targetDates
									{
										// wdev-6508 - check if this target should be calculated from startPathway or eventInstantiation
										if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.INSTANTIATING_EVENT.getId())
										{
											Date calculationDate=calculationDate=domPatientEvent.getEventDateTime();
											if (domPatientEvent.getScheduledDate() != null)
												calculationDate=domPatientEvent.getScheduledDate();
											
											domPjt.setTargetDate(addValueToDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPjt.getPathwayJourney().getCurrentClock(), null, calculationDate));
											domPjt.setTargetCalFromDate(calculationDate);
										}
										else
										{
											domPjt.setTargetDate(addValueToDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPjt.getPathwayJourney().getCurrentClock()));
											domPjt.setTargetCalFromDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate());
										}
										
										domPjt.setJourneyClock(domPjt.getPathwayJourney().getCurrentClock());
									}
									else
									{
										// wdev-8695 - if the status to set to is RECALCULATE_ONLY, then we don't
										// want to create a new status for the target
										if (domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.RECALCULATE_ONLY.getId())
										{
											if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.INSTANTIATING_EVENT.getId())
											{
												Date calculationDate=calculationDate=domPatientEvent.getEventDateTime();
												if (domPatientEvent.getScheduledDate() != null)
													calculationDate=domPatientEvent.getScheduledDate();
												
												domPjt.setTargetDate(addValueToDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPjt.getPathwayJourney().getCurrentClock(), null, calculationDate));
												domPjt.setTargetCalFromDate(calculationDate);
											}
											else
											{
												domPjt.setTargetDate(addValueToDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPjt.getPathwayJourney().getCurrentClock()));
												domPjt.setTargetCalFromDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate());
											}
											continue;
										}
									}
									
									JourneyTargetStatus newStat = createJourneyTargetStatus(domEventTarg.getSetJourneyTargetStatusTo());
	
									// wdev-4028 - If current status is Achieved and setting to In-scope, Scheduled or cancelled,
									// clear out the achieved date and achieved week Variance
									if (newStat.getStatus().getId() == PatientTargetStatus.INSCOPE.getId() 
											|| newStat.getStatus().getId() == PatientTargetStatus.EVENTSCHEDULED.getId()
											|| newStat.getStatus().getId() == PatientTargetStatus.EVENTCANCELLED.getId())  // wdev-4107
									{
										JourneyTargetStatus curStat = domPjt.getCurrentStatus();
										if (curStat != null && curStat.getStatus().getId() == PatientTargetStatus.TARGETACHIEVED.getId())
										{
											domPjt.setAchievedDate(null);
											domPjt.setAchievedVariance(null);
										}
									}
									// wdev-4028 - If current status is Scheduled and setting to In-scope or event cancelled, clear out the scheduled date
									if (newStat.getStatus().getId() == PatientTargetStatus.INSCOPE.getId() ||
										newStat.getStatus().getId() == PatientTargetStatus.EVENTCANCELLED.getId())
									{
										JourneyTargetStatus curStat = domPjt.getCurrentStatus();
	
										if (curStat != null && curStat.getStatus().getId() == PatientTargetStatus.EVENTSCHEDULED.getId())
										{
											domPjt.setScheduledDate(null);
										}
									}
									
									// wdev-7329
									// If going back to a NOT_IN_SCOPE status, clear out the clock and target date details
									if (newStat.getStatus().getId() == PatientTargetStatus.NOTINSCOPE.getId())
									{
										domPjt.setAchievedDate(null);
										domPjt.setAchievedVariance(null);
										domPjt.setJourneyClock(null);
										
										// WDEV-20416 - If taking a target out of scope check if 31 or 62 day as may need to reset values in CatsReferral
										updateCatsReferralTargetDates(factory, domPatientEvent.getJourney(), domPjt, false);
									}
									else
									{
										//WDEV-23399
										Date eventDateTime = domPatientEvent.getEventDateTime();
										PatientPathwayJourney domJourney = domPjt.getPathwayJourney();
										if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.INSTANTIATING_EVENT.getId())
						    			{
						    				// Recalculate the target date from the event date	
											if (domJourney.getCurrentClock() != null)//WDEV-23831
												domPjt.setTargetDate(addValueToDate(domJourney.getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod().intValue(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domJourney.getCurrentClock(), null, eventDateTime));
											
						    				domPjt.setTargetCalFromDate(domPatientEvent.getEventDateTime());
						    			}
						    			else
						    			{
						    				// Recalculate the target date from the start date of the current clock
						    				domPjt.setTargetDate(addValueToDate(domJourney.getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domJourney.getCurrentClock()));
						    				domPjt.setTargetCalFromDate(domJourney.getCurrentClock().getStartDate());
						    			}
										
										// WDEV-20416
										// If this is a 31 or 62 day target we need to update the CatsReferral details
										updateCatsReferralTargetDates(factory, domPatientEvent.getJourney(), domPjt, true);
									}
									
									domPjt.setCurrentStatus(newStat);
									domPjt.getStatusHistory().add(newStat);
					
									// 	If setting the JourneyTargetStatus to achieved, then set the achieved date in the target
									if (domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.TARGETACHIEVED.getId()
											&& domPjt.getAchievedDate() == null) // wdev-4140 - only set achieved date it null
									{
										domPjt.setAchievedDate(domPatientEvent.getEventDateTime());
										
										// wdev-3845 We need to calculate the achievedWeekVariance based on the difference
										// between targetEndDate and AchievedDate
										
										domPjt.setAchievedVariance(calculateTimeDiff(domPjt.getTargetDate(), domPjt.getAchievedDate(), domPjt.getPathwayJourney().getPathway().getJourneyCountType()));
										
									}
									// 	If setting the JourneyTargetStatus to eventCancelled, then we set the flag that this target has cancelled items
									else if (domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.EVENTCANCELLED.getId())
									{
										domPjt.setHasCancelledEvents(true);
									}
									// 	If setting the JourneyTargetStatus to eventScheduled, then we set the scheduledDateTime within the status to that in the PatientEvent
									else if (domEventTarg.getSetJourneyTargetStatusTo().getId() == PatientTargetStatus.EVENTSCHEDULED.getId())
									{
										domPjt.getCurrentStatus().setDate(domPatientEvent.getScheduledDate());
										// wdev-3845 - set the Scheduled DAte is the patient journey target too
										domPjt.setScheduledDate(domPatientEvent.getScheduledDate());
									}
									
									
									// wdev-3911 - only bring targets into scope if updating the target status itself
									// See if we need to bring some more targets into scope
									if (domEventTarg != null && domEventTarg.getActivateTargets() != null)
									{
										Iterator ita = domEventTarg.getActivateTargets().iterator();
										while (ita.hasNext())
										{
											Target activateTarget = (Target) ita.next();
											bringTargetIntoScope(factory, activateTarget, domPatientEvent);
										}
									}
	
								}
								break;  // Break from this loop
							}
						}
					}  // Update Patient Journey Target Status
					if (newPjt.size() > 0)  // wdev-7244
						domPatientEvent.getJourney().getPatientTargets().addAll(newPjt);
				}
			}  // There are event targets
		}  // The current clock has not stopped
		
		// If the configured event associated with this event is an RTT event, we
		// check the action code.  If the action code has a value of 4 - stop clock
		// of if the event is marked as stopping a clock we set the stop date on the current clock
		if (domPatientEvent.getJourney() != null && (domPatientEvent.getJourney().getCurrentClock() != null)
				&& ((domPatientEvent.getRttExternalEvent() != null && domPatientEvent.getRttExternalEvent().getAction() != null && domPatientEvent.getRttExternalEvent().getAction().getId() == RTTAction.FOUR.getId()) ||
					(domPatientEvent.getEvent() != null && domPatientEvent.getEvent().isStopsClock() != null && domPatientEvent.getEvent().isStopsClock().booleanValue())) ) // wdev-3752
		{
			if (domPatientEvent.getJourney().getCurrentClock().getStopDate() == null) //WDEV-18446
				domPatientEvent.getJourney().getCurrentClock().setStopDate(domPatientEvent.getEventDateTime());
			
			// When stopping a clock, we update all non achieved,cancelled PatientJourneyTargets to CLOCK_STOPPED
			Iterator it = domPatientEvent.getJourney().getPatientTargets().iterator();
			while (it.hasNext())
			{
				PatientJourneyTarget domPjt = (PatientJourneyTarget) it.next();

				// Only modified targets associated with the current clock
				if (domPatientEvent.getJourney() != null && domPatientEvent.getJourney().getCurrentClock() != null && 
						domPjt.getJourneyClock() != null && domPatientEvent.getJourney().getCurrentClock().getId() != domPjt.getJourneyClock().getId())
					continue;
					
				if (domPjt.getCurrentStatus().getStatus().getId() != PatientTargetStatus.EVENTCANCELLED.getId() &&
						domPjt.getCurrentStatus().getStatus().getId() != PatientTargetStatus.TARGETACHIEVED.getId() &&
						domPjt.getCurrentStatus().getStatus().getId() != PatientTargetStatus.NOTINSCOPE.getId())
				{
					JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.CLOCKSTOP));
					// This used to be domPatientEvent.getPatientTarget - though I think that is incorrect as it
					// is the full journey targets that need to be updated.
					domPjt.setCurrentStatus(tStat);
					domPjt.getStatusHistory().add(tStat);
				}
			}
		}
			
		// WDEV-6362 - If this is an rtt event of type Pause, we want to set the pause date
		if (domPatientEvent.getRttExternalEvent() != null && domPatientEvent.getRttExternalEvent().getPASCode().equals(PAUSE_PATHWAY))
		{
			// The Pause details are held against the current clock
			PatientJourneyStatus stat = createPatientJourneyStatus(getDomLookup(JourneyStatus.PAUSE));
			domPatientEvent.getJourney().setCurrentStatus(stat);
			domPatientEvent.getJourney().getStatusHistory().add(stat);

			if (domPatientEvent.getJourney().getCurrentClock() != null)
			{
				PathwayClock curClock = domPatientEvent.getJourney().getCurrentClock();
				// If there is already a pause start and end date, we create another set of pause details
				//	If there is already a pause start date without an end date, we will update the start date
				// If none, create a new one
				// 	WDEV-18227
				PauseDetails currentPause = curClock.getCurrentPause();
				
				//remove current pause from history only if current pause will be updated
				if(currentPause != null && curClock.getPauseDetails() != null && currentPause.getPauseStop() == null)
				{
					for(int i=0; i<curClock.getPauseDetails().size(); i++)
					{
						PauseDetails pause = (PauseDetails) curClock.getPauseDetails().get(i);
						
						if(currentPause.equals(pause))
						{
							curClock.getPauseDetails().remove(i);
							break;
						}
					}
				}
				
				//create a new pause if current is null or PauseStop is not null
				if(currentPause == null || currentPause.getPauseStop() != null)
				{
					currentPause = new PauseDetails();
				}
				
				currentPause.setPauseStart(workDate);
				
				if(curClock.getPauseDetails() == null)
				{
					curClock.setPauseDetails(new ArrayList());
				}
				
				curClock.getPauseDetails().add(currentPause);	
			}
		}
		
		// WDEV-6362 - If this is an rtt event of type UnPause, we want to set the unpause date and recalculate the target dates
		if (domPatientEvent.getRttExternalEvent() != null && domPatientEvent.getRttExternalEvent().getPASCode().equals(UNPAUSE_PATHWAY))
		{
			PatientJourneyStatus stat = createPatientJourneyStatus(getDomLookup(JourneyStatus.UNPAUSE));
			domPatientEvent.getJourney().setCurrentStatus(stat);
			domPatientEvent.getJourney().getStatusHistory().add(stat);

			// The Pause details are held against the current clock
			if (domPatientEvent.getJourney().getCurrentClock() != null)
			{
				PathwayClock curClock = domPatientEvent.getJourney().getCurrentClock();
				// If there is already a pause start and end date, we create another set of pause details
				//	If there is already a pause start date without an end date, we will update the start date
				// If none, create a new one
				// 	WDEV-18227
				PauseDetails currentPause = curClock.getCurrentPause();
				
				//remove current pause from history only if current pause will be updated
				if(currentPause != null && curClock.getPauseDetails() != null && currentPause.getPauseStop() == null)
				{
					for(int i=0; i<curClock.getPauseDetails().size(); i++)
					{
						PauseDetails pause = (PauseDetails) curClock.getPauseDetails().get(i);
						
						if(currentPause.equals(pause))
						{
							curClock.getPauseDetails().remove(i);
							break;
						}
					}
				}
				
				//update pauseStop only if this date is null
				if(currentPause != null && currentPause.getPauseStop() == null)
				{
					currentPause.setPauseStop(workDate);
					
					if(curClock.getPauseDetails() == null)
					{
						curClock.setPauseDetails(new ArrayList());
					}
					
					curClock.getPauseDetails().add(currentPause);
					
					// Recalculate target dates
					recalculateTargetDates(null, domPatientEvent.getJourney(), null);
				}
			}
		}
					
		// wdev-6362 - If amending clock start, we need to recalculate the target dates for all current targets, and also
		// recalculate the journey target end date
		if (domPatientEvent.getRttExternalEvent() != null && domPatientEvent.getRttExternalEvent().getPASCode().equals(AMEND_CLOCK_START))
		{
			amendClockStart(domPatientEvent, workDate);
		}
		
		// This event may end a Pathway, if so, we want to set the status to ended and set endedon date (wdev-3752)
		if (domPatientEvent.getEvent() != null && domPatientEvent.getEvent().isEndsPathway() != null && domPatientEvent.getEvent().isEndsPathway().booleanValue() && domPatientEvent.getJourney() != null)
		{
			//WDEV-18788 WDEV-18446
			if (domPatientEvent.getJourney().getCurrentClock() != null && domPatientEvent.getJourney().getCurrentClock().getStopDate() == null)
				domPatientEvent.getJourney().getCurrentClock().setStopDate(domPatientEvent.getEventDateTime()); // Stop the current clock too
			
			domPatientEvent.getJourney().setEndedOnDate(domPatientEvent.getEventDateTime());
			PatientJourneyStatus stat = createPatientJourneyStatus(getDomLookup(JourneyStatus.ENDPATHWAYJOURNEY));
			domPatientEvent.getJourney().setCurrentStatus(stat);
			domPatientEvent.getJourney().getStatusHistory().add(stat);
		}
	
		
		// Add this event to it's associated target event list
		if (domPatientEvent.getPatientTarget() != null)
		{
			domPatientEvent.getPatientTarget().getEvents().add(domPatientEvent);
		}
		
		factory.save(domPatientEvent);
		
		if (domPatientEvent.getJourney() != null && domPatientEvent.getJourney().getCurrentClock() != null)
		{
			factory.refresh(domPatientEvent.getJourney().getCurrentClock());
		}
		
		return PatientEventVoAssembler.create(domPatientEvent);
	}



	private PathwayClock createNewClock(PatientEvent domPatientEvent)
	{
		int X = getNumberOfClocks(domPatientEvent.getJourney().getClockHistory());

		PathwayClock newClock = new PathwayClock();
		newClock.setExtClockId("MAXIMS_" + X);
		newClock.setExtClockName("MaximsClock_" + X);
		newClock.setStartDate(domPatientEvent.getEventDateTime()); // WDEV-23949
		newClock.setTargetClockEnd(getTargetClockEnd(newClock.getStartDate(), getCatsReferralForJourney(domPatientEvent.getJourney())));
		return newClock;
	}
	
	private CatsReferral getCatsReferralForJourney(PatientPathwayJourney journey)
	{
		if (journey == null)
			return null;
		
		String sql="select referral from CatsReferral as referral left join referral.journey as journey where journey.id = :journeyID" ;
		
		List <?>  referrals = getDomainFactory().find(sql,new String[]{"journeyID"}, new Object[]{journey.getId()}) ;
		
		if (referrals != null && referrals.size() > 0 && referrals.get(0) instanceof CatsReferral)
			return (CatsReferral) referrals.get(0);
		
		return null;
	}



	private Date getTargetClockEnd(Date date, CatsReferral referral)
	{
		ims.framework.utils.Date startDate = new ims.framework.utils.Date(date);

		int daysToRttBreachDate = 0;

		if (referral != null && referral.getReferralDetails() != null)
		{
			ContractConfigRefVo contractRefVo = referral.getContract() != null ? new ContractConfigRefVo(referral.getContract().getId(), referral.getContract().getVersion()) : null;
			ServiceRefVo serviceRefVo = referral.getReferralDetails().getService() != null ? new ServiceRefVo(referral.getReferralDetails().getService().getId(), referral.getReferralDetails().getService().getVersion()) : null;
			
			ContractServiceLocationsConfigVo contrServiceLocationConf = getContractServiceLocConf(contractRefVo, serviceRefVo);

			if (contrServiceLocationConf != null && contrServiceLocationConf.getDaysToRTTBreachDate() != null)
			{
				daysToRttBreachDate = contrServiceLocationConf.getDaysToRTTBreachDate();
			}
			else if (referral.getContract() != null)
			{
				daysToRttBreachDate = referral.getContract().getDaysToRTTBreachDate();
			}
		}
		
		return startDate.addDay(daysToRttBreachDate).getDate();
	}
	
	private ContractServiceLocationsConfigVo getContractServiceLocConf(ContractConfigRefVo contractRef, ServiceRefVo serviceRef)
	{
		if (contractRef == null || serviceRef == null)
		{
			return null;
		}
		
		String sql="select serviceLoc from ContractConfig as contractConf left join contractConf.serviceLocations as serviceLoc where contractConf.id = :ContractID and serviceLoc.service.id = :ServiceID" ;
		
		List <?>  listServiceLoc=getDomainFactory().find(sql,new String[]{"ContractID", "ServiceID"}, new Object[]{contractRef.getID_ContractConfig(), serviceRef.getID_Service()}) ;
		
		if (listServiceLoc != null && listServiceLoc.size() > 0)
			return ContractServiceLocationsConfigVoAssembler.create((ContractServiceLocationsConfig)listServiceLoc.get(0));
		
		return null;
	}
	
	private int getNumberOfClocks(Set clockHistory)
	{
		int X = 0;

		if(clockHistory == null || clockHistory.size() == 0)
			return ++X;

		Iterator iterator = clockHistory.iterator();
		while(iterator.hasNext()) 
		{
			X++;
			iterator.next();
		}

		return ++X;
	}

	//WDEV-19700
	private boolean targetHasSamePASMapping(PatientJourneyTarget domPjt, String eventTargetPASMappingValue)
	{
		for (int i=0;domPjt.getPathwayTarget()!=null && domPjt.getPathwayTarget().getTarget()!=null && domPjt.getPathwayTarget().getTarget().getTaxonomyMaps()!=null && i<domPjt.getPathwayTarget().getTarget().getTaxonomyMaps().size(); i++)
		{
			TaxonomyMap taxMap = (TaxonomyMap)domPjt.getPathwayTarget().getTarget().getTaxonomyMaps().get(i);
			if (taxMap!=null && TaxonomyType.PAS.getID()==taxMap.getTaxonomyName().getId() && taxMap.getTaxonomyCode().equals(eventTargetPASMappingValue.toString()))
			{
				return true;
			}
		}
		
		return false;
	}



	/**
	 * wdev-7244
	 * createPJTForClock
	 * If a PatientJourneyTarget was not found for the current clock, patient, journey and pathwaytarget, this method
	 * will be called to create a new PJT for the current clock.  The PatientEvent will also be associated with this new PJT.
	 * This allows multiple targets to be displayed within the same journey.
	 * @param domPjt
	 * @param domPatientEvent
	 * @param domEventTarg
	 * @return
	 */
	private PatientJourneyTarget createPJTForClock(PatientJourneyTarget domPjt, PatientEvent domPatientEvent, EventTarget domEventTarg)
	{
		PatientJourneyTarget domJournTarg = new PatientJourneyTarget();
		domJournTarg.setPathwayTarget(domPjt.getPathwayTarget());
		
		JourneyTargetStatus newStat= createJourneyTargetStatus(domEventTarg.getSetJourneyTargetStatusTo());
		domJournTarg.setCurrentStatus(newStat);
		domJournTarg.getStatusHistory().add(newStat);
		domJournTarg.setWeekNumber(calculateWeekNum(domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType()));
		domJournTarg.setPathwayJourney(domPatientEvent.getJourney());
		domJournTarg.setJourneyClock(domPatientEvent.getJourney().getCurrentClock());
		domJournTarg.setTargetDate(addValueToDate(domPatientEvent.getJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPatientEvent.getJourney().getCurrentClock()));
		domJournTarg.setTargetCalFromDate(domPatientEvent.getJourney().getStartDate());
		return domJournTarg;
	}


	/**
	 * wdev-7244
	 * isPatientJourneyTargForClock
	 * Check to see if there is a PatientJourneyTarget record for the current clock, journey, patient and pathwaytarget
	 * if none found, and in this method, it means it wants to update the status of a target, so it will return false
	 * and another method will create a new PJT.
	 * @param factory
	 * @param domPjt
	 * @param clock
	 * @return
	 */
	private boolean isPatientJourneyTargForClock(DomainFactory factory, PatientJourneyTarget domPjt, Integer clock)
	{
		String hql = " select count(*) from PatientJourneyTarget pjt where pjt.journeyClock.id = :clock " +
		      " and pjt.pathwayJourney = :journey and pjt.pathwayJourney.patient = :patient " +
		      " and pjt.pathwayTarget = :pathwayTarget";
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("clock");
		labels.add("journey");
		labels.add("patient");
		labels.add("pathwayTarget");
		values.add(clock);
		values.add(domPjt.getPathwayJourney());
		values.add(domPjt.getPathwayJourney().getPatient());
		values.add(domPjt.getPathwayTarget());
	
		List lst = factory.find(hql, labels, values);
		if (lst == null || lst.size() == 0)
			return false;
		Long res = (Long) lst.get(0);
		if (res == 0)
			return false;
		
		return true;
	}
	
	/**
	 * wdev-8754
	 * isTargetForCurrentClock
	 * As opposed to the isPatientJourneyTargForClock method, this method checks whether the target
	 * is current for the current clock in the current journey.  It doesn't check for the PathwayTarget,
	 * the reason for this is because the target may be for a different pathway, but still within journey
	 * and same clock.
	 */
	private boolean isTargetForCurrentClock(DomainFactory factory, PatientPathwayJourney journey, Target target, Integer clock)
	{
		String hql = " select count(*) from PatientJourneyTarget pjt where pjt.journeyClock.id = :clock " +
		      " and pjt.pathwayJourney = :journey and pjt.pathwayTarget.target = :target";
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("clock");
		labels.add("journey");
		labels.add("target");
		values.add(clock);
		values.add(journey);
		values.add(target);
	
		List lst = factory.find(hql, labels, values);
		if (lst == null || lst.size() == 0)
			return false;
		Long res = (Long) lst.get(0);
		if (res == 0)
			return false;
		
		return true;
	}

	

	/**
	 * wdev-6362
	 * amendClockStart
	 * This method is called when an Amend Clock Start RTT event is received.  It needs
	 * to recalculate the target dates based the new clock start, for the current clock only.
	 * @param domPatientEvent
	 * @param newStartClockDate 
	 */
	private void amendClockStart(PatientEvent domPatientEvent, Date newStartClockDate) 
	{
		domPatientEvent.getJourney().getCurrentClock().setStartDate(newStartClockDate);  // wdev-7264 use this new parameter as from PTH-4
		
		// Get all current in-scope targets
		Iterator it = domPatientEvent.getJourney().getPatientTargets().iterator();
		while (it.hasNext())
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) it.next();
			
			// Recalculate for the current clock only   wdev-6672
			if (domPjt.getJourneyClock() == null || !(domPjt.getJourneyClock().getId().equals(domPatientEvent.getJourney().getCurrentClock().getId())))
				continue;
			
			// wdev-8781 - we only want to calculate those targets who's dates are calculated from clock start not instantiating event
			if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.PATHWAY_START.getId())
			{
				domPjt.setTargetDate(addValueToDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPjt.getPathwayJourney().getCurrentClock()));
				domPjt.setTargetCalFromDate(domPjt.getPathwayJourney().getCurrentClock().getStartDate());
			}
		}
		
		// Recalculate the TargetEndDate of the Journey
		domPatientEvent.getJourney().getCurrentClock().setTargetClockEnd(getTargetClockEnd(domPatientEvent.getJourney().getCurrentClock().getStartDate(), getCatsReferralForJourney(domPatientEvent.getJourney())));
		//domPatientEvent.getJourney().setTargetEndDate(addValueToDate(domPatientEvent.getJourney().getStartDate(), domPatientEvent.getJourney().getPathway().getNumWeeksDays(), domPatientEvent.getJourney().getPathway().getJourneyCountType(), domPatientEvent.getJourney().getCurrentClock()));
	}

	/**
	 * wdev-6362
	 * recalculateTargetDates
	 * This method is called when an unpause event is received.  It needs
	 * to recalculate the target dates based on the difference between the paused
	 * and unpaused dates
	 * @param journey
	 * @param originalReferralReceivedDate 
	 */
	private void recalculateTargetDates(DomainFactory factory, PatientPathwayJourney journey, ims.framework.utils.Date originalReferralReceivedDate) 
	{
		// Get all current in-scope targets
		Iterator it = journey.getPatientTargets().iterator();
		while (it.hasNext())
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) it.next();

			// WDEV-21128 If target calculated from is equal to the originalReferralReceivedDate, update it too
			if (domPjt.getTargetCalFromDate() != null && originalReferralReceivedDate != null &&  domPjt.getTargetCalFromDate().equals(originalReferralReceivedDate.getDate()))
				domPjt.setTargetCalFromDate(journey.getStartDate());
			
			domPjt.setTargetDate(addValueToDate(journey.getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), journey.getCurrentClock(), domPjt.getTargetDate(), domPjt.getTargetCalFromDate()));

			if (domPjt.getTargetCalFromDate() == null && journey.getCurrentClock() != null)
				domPjt.setTargetCalFromDate(journey.getCurrentClock().getStartDate());
			else if (domPjt.getTargetCalFromDate() == null)
				domPjt.setTargetCalFromDate(journey.getStartDate());
			
			
			if (factory != null)
			{
				try {
					factory.save(domPjt);
				} catch (StaleObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			// WDEV-22995
			/*
			 * Update the CatsReferral target date (either 31 or 62 day target)
			 */
			try
			{
				updateCatsReferralTargetDate(factory, journey, domPjt);
			}
			catch (StaleObjectException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //WDEV-22995
		}
	}

	/**
	 * WDEV-21128
	 * When the Referral Received Date on a CatsReferral is updated, we need to recalculate the clock start, target end date and all targets' target achieved dates 
	 * @throws StaleObjectException 
	 */
	public void updateJourneyFromReferralDateChange(PatientPathwayJourneyRefVo journey, ims.framework.utils.Date originalReferralReceivedDate, ims.framework.utils.Date newReferralReceivedDate) throws StaleObjectException 
	{
		if (journey == null)
			return;
		
		if (newReferralReceivedDate.compareTo(originalReferralReceivedDate) == 0) //WDEV-23202 
			return;
		
		DomainFactory factory = getDomainFactory();
		
		PatientPathwayJourney domJourney = (PatientPathwayJourney)factory.getDomainObject(PatientPathwayJourney.class, journey.getID_PatientPathwayJourney());
		if (domJourney != null)
		{
			// Reset the start date of the journey
			domJourney.setStartDate(newReferralReceivedDate.getDate());
			
			boolean clockFound=false;
			// Find the clock that matches the original referral received date
			if (domJourney.getCurrentClock() != null)
			{
				PathwayClock domClock = domJourney.getCurrentClock();
				//WDEV-23202 
				if (!Boolean.TRUE.equals(domClock.getIsRIE()) & originalReferralReceivedDate.getDate().equals(domClock.getStartDate())) //WDEV-23202 
				{
					domClock.setStartDate(newReferralReceivedDate.getDate());
					domClock.setTargetClockEnd(getTargetClockEnd(newReferralReceivedDate.getDate(), getCatsReferralForJourney(domJourney)));
					factory.save(domClock);
					clockFound=true;
				}
			}
			
			if (!clockFound)
			{
				// Check the history of clocks
				if (domJourney.getClockHistory() != null)
				{
					Iterator it = domJourney.getClockHistory().iterator();
					while (it.hasNext())
					{
						PathwayClock domClock = (PathwayClock) it.next();
						
						if (Boolean.TRUE.equals(domClock.getIsRIE())) //WDEV-23202
							continue;
						
						if (originalReferralReceivedDate.getDate().equals(domClock.getStartDate())) //WDEV-23202 
						{
							domClock.setStartDate(newReferralReceivedDate.getDate());
							domClock.setTargetClockEnd(getTargetClockEnd(newReferralReceivedDate.getDate(), getCatsReferralForJourney(domJourney)));
							factory.save(domClock);
							break;
						}
					}
				}
			}
			
			// Targets now need to be updated based on this date
			recalculateTargetDates(factory, domJourney, originalReferralReceivedDate);

		}
	}
	
	/**
	 * bringTargetIntoScope
	 * This method will update the status of the PatientJourneyTarget to in-scope 
	 * @param activateTarget
	 * @param domPatientEvent
	 * @throws DomainInterfaceException 
	 * @throws StaleObjectException 
	 */
	private void bringTargetIntoScope(DomainFactory factory, Target activateTarget, PatientEvent domPatientEvent) throws DomainInterfaceException, StaleObjectException
	{
		StringBuffer hql = new StringBuffer();
		hql.append(" select pjt from PatientJourneyTarget pjt join pjt.pathwayJourney jour where jour.id = :patientJourney and pjt.pathwayTarget.target = :target");
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		labels.add("patientJourney");
		values.add(domPatientEvent.getJourney().getId());
		labels.add("target");
		values.add(activateTarget);
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("More than one PatientJourneyTarget found for PatientEvent and Target - cannot bring Target into scope");
		}
		else if (lst != null && lst.size() == 1)
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) lst.get(0);
			JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.INSCOPE));
			domPjt.setCurrentStatus(tStat);
			domPjt.getStatusHistory().add(tStat);
			
			// wdev-6508 - If the target is configured to calculate target date from instantiated event, we need to pass that into calculation
			if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.INSTANTIATING_EVENT.getId())
			{
				// Recalculate the target date from the start date of the current clock
				Date calculationDate=domPatientEvent.getEventDateTime();
				if (domPatientEvent.getScheduledDate() != null)
					calculationDate = domPatientEvent.getScheduledDate();
				domPjt.setTargetDate(addValueToDate(domPatientEvent.getJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPatientEvent.getJourney().getCurrentClock(), null, calculationDate));
				domPjt.setTargetCalFromDate(calculationDate);
				
			}
			else
			{
				// Recalculate the target date from the start date of the current clock
				domPjt.setTargetDate(addValueToDate(domPatientEvent.getJourney().getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domPatientEvent.getJourney().getCurrentClock()));
				domPjt.setTargetCalFromDate(domPatientEvent.getJourney().getCurrentClock().getStartDate());
			}
			
			
			domPjt.setJourneyClock(domPatientEvent.getJourney().getCurrentClock());
			factory.save(domPjt);
			
			// WDEV-20416
			// If this is a 31 or 62 day target we need to update the CatsReferral details
			updateCatsReferralTargetDates(factory, domPatientEvent.getJourney(), domPjt, true);
		}
	}
	

	/**
	 * WDEV-20416
	 * This method will update the CatsReferral with 31 and 62 day target information if these are targets of that type.
	 * @param factory - DomainFactory
	 * @param journey - Patient Journey currently being updated
	 * @param domPjt - Patient Journey Target being instantiated
	 * @param setInscope - indicator whether this target is being set to inscope or out of scope.
	 * @throws StaleObjectException 
	 */
	private void updateCatsReferralTargetDates(DomainFactory factory, PatientPathwayJourney journey, PatientJourneyTarget domPjt, boolean setInscope) throws StaleObjectException 
	{
		// First check if this is of type 31 or 62 day target
		boolean target31Day =false;
		boolean target62Day = false;
		
		if (domPjt == null || domPjt.getPathwayTarget() == null)
			return;
		
		Target domTarget = domPjt.getPathwayTarget().getTarget();
		if (domTarget != null)
		{
			Iterator<TaxonomyMap> it = domTarget.getTaxonomyMaps().iterator();
			while (it.hasNext())
			{
				TaxonomyMap domMap = it.next();
				if (domMap != null && domMap.getTaxonomyCode() != null && domMap.getTaxonomyCode().equals("31D") 
						&& domMap.getTaxonomyName() != null && domMap.getTaxonomyName().getId() == TaxonomyType.PAS.getId())
				{
					target31Day=true;
				}
				else if (domMap != null && domMap.getTaxonomyCode() != null && domMap.getTaxonomyCode().equals("62D") 
						&& domMap.getTaxonomyName() != null && domMap.getTaxonomyName().getId() == TaxonomyType.PAS.getId())
				{
					target62Day=true;
				}
				
			}
		}
		
		if (target31Day || target62Day)
		{
			// Get the CatsReferral for this journey
			StringBuffer hql = new StringBuffer(" select ref from CatsReferral ref where ref.journey = :journey");
			
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>();
			labels.add("journey");
			values.add(journey);
						
			List lst = factory.find(hql.toString(), labels, values);
			if (lst != null && lst.size() > 0)
			{
				CatsReferral domRef = (CatsReferral) lst.get(0);
				if (domRef != null && target31Day)
				{
					if (setInscope)
						domRef.setCurrent31TargetDate(domPjt.getTargetDate());
					else
						domRef.setCurrent31TargetDate(null);
					
					factory.save(domRef);
				}
				else if (domRef != null && target62Day)
				{
					if (setInscope)
						domRef.setCurrent62TargetDate(domPjt.getTargetDate());
					else
						domRef.setCurrent62TargetDate(null);
					
					factory.save(domRef);
				}
			}
		}
	}

	
	
	
	public Boolean bringTargetIntoScopeWithoutEvent(PatientPathwayJourney journey, PathwayTarget pathwayTarget, Target target, DateTime eventDateTime, Integer targetPeriod) throws DomainInterfaceException, StaleObjectException
	{
		// If the journey is null - then there is logical error in implementation
		if (journey == null)
			throw new CodingRuntimeException("Cannot bring into scope a target to a null journey.");
		
		if (journey.getId() != null)
		{
			TargetRefVo activateTarget = new TargetRefVo(target.getId(), target.getVersion());
			PatientPathwayJourneyRefVo journeyRef = new PatientPathwayJourneyRefVo(journey.getId(), journey.getVersion());

			Boolean result = bringTargetIntoScopeWithoutEvent(activateTarget, journeyRef, eventDateTime.getDate());

			if (Boolean.TRUE.equals(result))
				return true;
		}
		
		if (pathwayTarget == null)
		{
			PathwayTarget configuredTarget = getConfiguredTarget(journey, target);
			
			pathwayTarget = configuredTarget;
			
//			if (configuredTarget != null)
//			{
//				pathwayTarget = new PathwayTarget();
//				
//				pathwayTarget.setPathway(configuredTarget.getPathway());
//				pathwayTarget.setTarget(configuredTarget.getTarget());
//				pathwayTarget.setTargetPeriod(configuredTarget.getTargetPeriod());
//				pathwayTarget.setStatus(configuredTarget.getStatus());
//				pathwayTarget.setActivateTarget(configuredTarget.isActivateTarget());
//				pathwayTarget.setWarningIndicatorPeriod(configuredTarget.getWarningIndicatorPeriod());
//			}
		}
		
		
		if (targetExistsForClock(target, journey.getCurrentClock()))
		{
			// Journey target already present for the current clock - do not create a new one
			return true;
		}

		
		PatientJourneyTarget domPatientJourneyTarget = createNewPatientJourneyTarget(pathwayTarget, target, journey, journey.getCurrentClock(), targetPeriod);
		journey.getPatientTargets().add(domPatientJourneyTarget);
		
		getDomainFactory().save(journey);
		
		updateCatsReferralTargetDates(getDomainFactory(), journey, domPatientJourneyTarget, true);
		
		return true;
	}
	
	

	
	private boolean targetExistsForClock(Target target, PathwayClock clock)
	{
		if (clock == null)
			return false;
		
		StringBuilder query = new StringBuilder("SELECT COUNT (patientTarget) ");
		query.append(" FROM PatientJourneyTarget AS patientTarget LEFT JOIN patientTarget.pathwayTarget AS pathwayTarget ");
		query.append(" LEFT JOIN pathwayTarget.target AS target ");
		query.append(" LEFT JOIN patientTarget.journeyClock AS clock ");
		query.append(" WHERE ");
		query.append(" clock.id = :CLOCK AND target.id = :TARGET ");
		
		long existingTargets = getDomainFactory().countWithHQL(query.toString(), new String[] {"CLOCK", "TARGET"}, new Object[] {clock.getId(), target.getId()});
		
		return existingTargets > 0;
	}



	private PathwayTarget getConfiguredTarget(PatientPathwayJourney journey, Target target) throws DomainInterfaceException
	{
		if (journey == null || journey.getId() == null)
			return null;
		
		if (target == null || target.getId() == null)
			return null;
		
		
				
		// Get a Pathway Target (configured for this Pathway Journey) if one exists
		StringBuilder query = new StringBuilder("SELECT DISTINCT(pathwayTarget) ");
		query.append(" FROM PathwayTarget AS pathwayTarget LEFT JOIN pathwayTarget.target AS target ");
		query.append(" LEFT JOIN pathwayTarget.pathway AS pathway ");
		query.append(" WHERE ");
		query.append(" pathway.id = :PATHWAY AND target.id = :TARGET ");

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		
		paramNames.add("PATHWAY");		paramValues.add(journey.getPathway().getId());
		paramNames.add("TARGET");		paramValues.add(target.getId());
		
		
		List<?> configuredTargets = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		if (configuredTargets != null && configuredTargets.size() > 1)
		{
			throw new DomainInterfaceException("More than one PatientJourneyTarget found for PatientEvent and Target - cannot bring Target into scope");
		}
		
		if (configuredTargets == null || configuredTargets.size() == 0)
			return null;
		
		return (PathwayTarget) configuredTargets.get(0);
	}



	private PatientJourneyTarget createNewPatientJourneyTarget(PathwayTarget pathwayTarget, Target target, PatientPathwayJourney journey, PathwayClock clock, Integer targetPeriod) throws DomainInterfaceException
	{
		Date eventDateTime = clock != null ? clock.getStartDate() : new Date();
		
		PatientJourneyTarget patientJourneyTarget = new PatientJourneyTarget();
		
		if (pathwayTarget == null)
			pathwayTarget = createPathwayTarget(target, journey.getPathway(), targetPeriod);
		
		patientJourneyTarget.setPathwayTarget(pathwayTarget);
		patientJourneyTarget.setWeekNumber(calculateWeekNum(pathwayTarget.getTargetPeriod(), pathwayTarget.getPathway().getJourneyCountType()));
		
		patientJourneyTarget.setTargetDate(addValueToDate(eventDateTime, pathwayTarget.getTargetPeriod(), pathwayTarget.getPathway().getJourneyCountType(), clock));
		patientJourneyTarget.setTargetCalFromDate(eventDateTime);
		
		JourneyTargetStatus inScopeStatus = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.INSCOPE));
		patientJourneyTarget.setCurrentStatus(inScopeStatus);
		patientJourneyTarget.getStatusHistory().add(inScopeStatus);
		
		patientJourneyTarget.setJourneyClock(clock);
		
		patientJourneyTarget.setPathwayJourney(journey);
		
		return patientJourneyTarget;
	}
	

	/**
	 * WDEV-18474
	 * bringTargetIntoScopeWithoutEvent
	 * This method will update the status of the PatientJourneyTarget to in-scope 
	 * @param activateTarget
	 * @param domJourney
	 * @param eventDateTime
	 * @throws DomainInterfaceException 
	 * @throws StaleObjectException 
	 */
	public Boolean bringTargetIntoScopeWithoutEvent(TargetRefVo activateTarget, PatientPathwayJourneyRefVo journey, ims.framework.utils.Date eventDateTime) throws DomainInterfaceException, StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append(" SELECT pjt FROM PatientJourneyTarget pjt JOIN pjt.pathwayJourney jour WHERE jour.id = :patientJourney AND pjt.pathwayTarget.target.id = :target AND pjt.journeyClock is null ");
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		labels.add("patientJourney");
		values.add(journey.getID_PatientPathwayJourney());
		labels.add("target");
		values.add(activateTarget.getID_Target());
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("More than one PatientJourneyTarget found for PatientEvent and Target - cannot bring Target into scope");
		}
		else if (lst != null && lst.size() == 1)
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) lst.get(0);
			JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.INSCOPE));
			domPjt.setCurrentStatus(tStat);
			domPjt.getStatusHistory().add(tStat);
			
			PatientPathwayJourney domJourney = (PatientPathwayJourney)factory.getDomainObject(PatientPathwayJourney.class, journey.getID_PatientPathwayJourney());
			// wdev-6508 - If the target is configured to calculate target date from instantiated event, we need to pass that into calculation
			if (domJourney.getCurrentClock()!=null) //WDEV-19976
			{
				if (domPjt.getPathwayTarget().getTarget().getTargetDateCalculation() != null && domPjt.getPathwayTarget().getTarget().getTargetDateCalculation().getId() == TargetDateCalculation.INSTANTIATING_EVENT.getId())
    			{
    				// Recalculate the target date from the start date of the current clock
    				domPjt.setTargetDate(addValueToDate(domJourney.getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod().intValue(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domJourney.getCurrentClock(), null, eventDateTime.getDate()));
    				domPjt.setTargetCalFromDate(eventDateTime.getDate());
    			}
    			else
    			{
    				// Recalculate the target date from the start date of the current clock
    				domPjt.setTargetDate(addValueToDate(domJourney.getCurrentClock().getStartDate(), domPjt.getPathwayTarget().getTargetPeriod(), domPjt.getPathwayTarget().getPathway().getJourneyCountType(), domJourney.getCurrentClock()));
    				domPjt.setTargetCalFromDate(domJourney.getCurrentClock().getStartDate());
    			}
    			
				domPjt.setJourneyClock(domJourney.getCurrentClock());
			}
			factory.save(domPjt);

			// WDEV-20416
			// If this is a 31 or 62 day target we need to update the CatsReferral details
			updateCatsReferralTargetDates(factory, domJourney, domPjt, true);
			
			return true;
		}
		
		return false;
	}



	private PathwayTarget createPathwayTarget(Target target, Pathway pathway, Integer targetPeriod) throws DomainInterfaceException
	{
		if (target == null)
			throw new DomainInterfaceException("Cannot create Pathway Target based with no Target specified.");
		
		if (pathway == null)
			throw new DomainInterfaceException("Cannot create Pathway Target with no Pathway specified.");
		
		if (targetPeriod == null)
			throw new DomainInterfaceException("Cannot create Pathway Target with no Target Period specified.");
		
		PathwayTarget pathwayTarget = new PathwayTarget();
		
		pathwayTarget.setPathway(pathway);
		pathwayTarget.setTarget(target);
		pathwayTarget.setTargetPeriod(targetPeriod);
		pathwayTarget.setStatus(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		pathwayTarget.setActivateTarget(Boolean.FALSE);
		
		return pathwayTarget;
	}



	/**
	 * WDEV-20416
	 * takeTargetOutOfScopeWithoutEvent
	 * This method will update the status of the PatientJourneyTarget to not in-scope 
	 * @param activateTarget
	 * @param domJourney
	 * @param eventDateTime
	 * @throws DomainInterfaceException 
	 * @throws StaleObjectException 
	 */
	public void takeTargetOutOfScopeWithoutEvent(TargetRefVo activateTarget, PatientPathwayJourneyRefVo journey) throws DomainInterfaceException, StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append(" select pjt from PatientJourneyTarget pjt join pjt.pathwayJourney jour where jour.id = :patientJourney and pjt.pathwayTarget.target.id = :target");
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		labels.add("patientJourney");
		values.add(journey.getID_PatientPathwayJourney());
		labels.add("target");
		values.add(activateTarget.getID_Target());
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("More than one PatientJourneyTarget found for PatientEvent and Target - cannot take Target out of scope");
		}
		else if (lst != null && lst.size() == 1)
		{
			PatientJourneyTarget domPjt = (PatientJourneyTarget) lst.get(0);
			
			takeTargetOutOfScopeWithoutEvent(new PatientJourneyTargetRefVo(domPjt.getId(), domPjt.getVersion()), journey);
		}
	}
	
	
	public void takeTargetOutOfScopeWithoutEvent(PatientJourneyTargetRefVo target, PatientPathwayJourneyRefVo journey) throws DomainInterfaceException, StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		
		PatientJourneyTarget domPjt = (PatientJourneyTarget) factory.getDomainObject(PatientJourneyTarget.class, target.getID_PatientJourneyTarget());
		JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.NOTINSCOPE));
		domPjt.setCurrentStatus(tStat);
		domPjt.getStatusHistory().add(tStat);
		
		// WDEV-20636
		factory.save(domPjt);
		super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.INFORMATION, "Target " + domPjt.getPathwayTarget().getTarget().getName() + " (" + domPjt.getId() + ") set to not-in-scope");
		
		PatientPathwayJourney domJourney = (PatientPathwayJourney)factory.getDomainObject(PatientPathwayJourney.class, journey.getID_PatientPathwayJourney());

		// WDEV-20416
		// If this is a 31 or 62 day target we need to update the CatsReferral details
		updateCatsReferralTargetDates(factory, domJourney, domPjt, false);
	}

	
	/**
	 * getEventTarget
	 * This method will set the PatientJourneyTarget value for the PatientEvent
	 * and will also return the EventTarget for this current event.
	 * @param domEvent
	 * @return
	 * @throws DomainInterfaceException 
	 */
	private Set getEventTarget(DomainFactory factory, PatientEvent domPatientEvent) throws DomainInterfaceException
	{
		// If this event is not associated with a patient journey
		// there is no need to continue
		if (domPatientEvent.getJourney() == null)
			return null;
		
		StringBuffer hql = new StringBuffer();
		StringBuffer whereClause = new StringBuffer();
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		
		// We may aleady have the PathwayTarget if called from
		// within worklist, so check before doing the query again
		List pthTargets = null;
		if(domPatientEvent.getPatientTarget() != null && domPatientEvent.getPatientTarget().getPathwayTarget() != null)
		{
			pthTargets = new ArrayList();
			pthTargets.add(domPatientEvent.getPatientTarget().getPathwayTarget());
		}
			
		
		if(pthTargets == null)
		{
			whereClause.append(" where pth.pathwayTarget.pathway = :pathway and pth.pathwayTarget.status.id = :status and pth.status.id = :status");
			labels.add("pathway");
			labels.add("status");
			values.add(domPatientEvent.getJourney().getPathway());
			values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
		
			if (domPatientEvent.getRttExternalEvent() != null)
			{
				hql.append(" select pth.pathwayTarget from PathwayTargetRTTEvent pth ");
				whereClause.append(" and pth.rTTEvent.id = :rttMap");
				labels.add("rttMap");
				values.add(domPatientEvent.getRttExternalEvent().getId());
			}
			else if (domPatientEvent.getExternalEvent() != null)
			{
				hql.append(" select pth.pathwayTarget from PathwayTargetExternalEventMapping pth ");
				whereClause.append(" and pth.externalEventMapping.id = :extMap ");
				labels.add("extMap");
				values.add(domPatientEvent.getExternalEvent().getId());
			}	
			else
				return getInternalEventTargets(domPatientEvent);

				
			hql.append(whereClause);
			pthTargets = factory.find(hql.toString(), labels, values);
		}
		
		
		if (pthTargets != null && pthTargets.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate PathwayTargets found for the pathway and mappings");
		}
		else if (pthTargets != null && pthTargets.size() == 1)
		{
			// We have the PathwayTarget, we want to find the PatientJourneyTarget for this to set within PatientEvent
			// wdev-4116 Include journey as part of the query
			PathwayTarget domPt = (PathwayTarget) pthTargets.get(0);
			List lst = factory.find(" from PatientJourneyTarget pjt where pjt.pathwayJourney.patient = :patient " +
					"and  pjt.pathwayTarget = :pthTarget and pjt.pathwayJourney = :journey", 
					new String[]{"patient", "pthTarget", "journey"}, new Object[]{domPatientEvent.getPatient(), domPt, domPatientEvent.getJourney()}, 500);
			
			
			// If none found, check to see if the target exists for another pathway in the history for this one...
			if (lst != null && lst.size() == 0)
			{
				lst = factory.find(" from PatientJourneyTarget pjt where pjt.pathwayJourney.patient = :patient " +
						"and  pjt.pathwayTarget.target = :pthTarget and pjt.pathwayJourney = :journey", 
						new String[]{"patient", "pthTarget", "journey"}, new Object[]{domPatientEvent.getPatient(), domPt.getTarget(), domPatientEvent.getJourney()}, 500);
				
			}
			
			if (lst != null && lst.size() > 0)
			{
				PatientJourneyTarget domPjt = (PatientJourneyTarget) lst.get(0);
				domPatientEvent.setPatientTarget(domPjt);

				// We have set the Patient Target, we now want to get the EventTarget
				// to decide whether the Journey or Target status need to be changed
				labels = new ArrayList<String>();
				values = new ArrayList<Object>();
				labels.add("target");
				values.add(domPt.getTarget());
				labels.add("event");
				values.add(domPatientEvent.getEvent());
				labels.add("status");
				values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
				
				List eventTargetList = factory.find(" from EventTarget evt where evt.target = :target and evt.event = :event and evt.status = :status", labels, values);
				if (eventTargetList == null || eventTargetList.size() == 0)
					return null;  // TODO Some problem occurred if EventTarget not found?
				
				
				// wdev-3811 - We have the first item from EventTarget based on the single mapping in the PathwayTargetRTTEvent
				// or EventExternalEventMapping.  We now have to go to EventTarget for all targets associated with this event
				// that are part of this pathway journey
				lst = factory.find(" from EventTarget evt where evt.event = :event and evt.status = :status " +
						" and evt.target in (select pt.target from PathwayTarget pt where pt.pathway = :pathway and pt.status = :status) ",
						new String[]{"event", "status", "pathway"}, new Object[]{domPatientEvent.getEvent(), getDomLookup(PreActiveActiveInactiveStatus.ACTIVE), domPt.getPathway()});
				if (lst != null && lst.size() > 0)
					eventTargetList.addAll(lst);
				
				return new HashSet(eventTargetList);  // Converted to set to avoid duplicates as the first one will have been included in the original query
			}
			
		}
		
		return null;
	}

	private Set getInternalEventTargets(PatientEvent domPatientEvent)
	{				
		
		List lst = getDomainFactory().find(" from EventTarget evt where evt.event = :event and evt.status = :status " +
				" and evt.target in (select pt.target from PathwayTarget pt where pt.pathway = :pathway and pt.status = :status) ",
				new String[]{"event", "status", "pathway"}, new Object[]{domPatientEvent.getEvent(), getDomLookup(PreActiveActiveInactiveStatus.ACTIVE), domPatientEvent.getJourney().getPathway()});
		if (lst != null && lst.size() > 0)
			return new HashSet(lst);
		
		return null;
	}

	public ExternalEventMappingVo getExternalEventMappings(ExternalEventMappingVo extMap) throws DomainInterfaceException 
	{
		// Mandatory items are provider system, detail and group
		if (!extMap.getProviderSystemIsNotNull() ||
				!extMap.getGroupIsNotNull() ||
				!extMap.getDetailIsNotNull())
		{
			throw new DomainInterfaceException("ProviderSystem, Group and Detail are mandatory items");
		}
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer(" from ExternalEventMapping evm where evm.providerSystem.id = :providerSystem and evm.group.id = :group and evm.detail.id = :detail");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("providerSystem");
		labels.add("detail");
		labels.add("group");
		values.add(extMap.getProviderSystem().getID_ProviderSystem());
		values.add(extMap.getDetail().getId());
		values.add(extMap.getGroup().getId());
		
		
		if (extMap.getSpecialtyIsNotNull())
		{
			hql.append(" and evm.specialty.id = :specialty");
			labels.add("specialty");
			values.add(extMap.getSpecialty().getId());
		}
		
		if (extMap.getConsultantIsNotNull())
		{
			hql.append(" and evm.consultant.id = :consultant"); 
			labels.add("consultant");
			values.add(extMap.getConsultant().getID_Hcp());
		}
		else
		{
			hql.append(" and evm.consultant is null");
		}
		
		if (extMap.getClinicCodeIsNotNull())
		{
			hql.append(" and (evm.clinicCode = :clinic or evm.clinicCode is null)");
			labels.add("clinic");
			values.add(extMap.getClinicCode());
		}
		else
		{
			hql.append(" and evm.clinicCode is null");
		}
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching ExtMappings");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return ExternalEventMappingVoAssembler.create((ExternalEventMapping) lst.get(0));
		}
		
		
		// If no Event found, and the consultant has been specified, we want to search with a null
		// consultant.  We can't include it in the original search as it may then return two records
		// thus throwing a Duplicate Data message
		if (!extMap.getConsultantIsNotNull())
			return null;
		
		
		hql = new StringBuffer(" from ExternalEventMapping evm where evm.providerSystem.id = :providerSystem and evm.group.id = :group and evm.detail.id = :detail and evm.consultant is null");
		labels = new ArrayList<String>();
		values = new ArrayList<Object>();
		labels.add("providerSystem");
		labels.add("detail");
		labels.add("group");
		values.add(extMap.getProviderSystem().getID_ProviderSystem());
		values.add(extMap.getDetail().getId());
		values.add(extMap.getGroup().getId());
		
		if (extMap.getSpecialtyIsNotNull())
		{
			hql.append(" and evm.specialty.id = :specialty");
			labels.add("specialty");
			values.add(extMap.getSpecialty().getId());
		}
		
		if (extMap.getClinicCodeIsNotNull())
		{
			hql.append(" and (evm.clinicCode = :clinic or evm.clinicCode is null)");
			labels.add("clinic");
			values.add(extMap.getClinicCode());
		}
		else
		{
			hql.append(" and evm.clinicCode is null");
		}
		
		lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching ExtMappings");
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return ExternalEventMappingVoAssembler.create((ExternalEventMapping) lst.get(0));
		}
		
		
		// No Event found for non-consultant either
		return null;

	}

	public RTTEventVo getRttMapping(RTTEventVo rttEvent) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer(" from RTTEvent ev where ev.providerSystem.id = :providerSystem ");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("providerSystem");
		values.add(rttEvent.getProviderSystem().getID_ProviderSystem());

		if (rttEvent.getPASCodeIsNotNull())
		{
			labels.add("pasCode");
			values.add(rttEvent.getPASCode());
			hql.append(" and ev.pASCode = :pasCode");
		}
		else if (rttEvent.getNationalCodeIsNotNull())
		{
			hql.append(" and ev.nationalCode = :nationalCode");
			labels.add("nationalCode");
			values.add(rttEvent.getNationalCode());
		}
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("Duplicate data found when searching event by RttValues - PASCODE=" + rttEvent.getPASCode());
		}
		else if (lst != null && lst.size() == 1)
		{
			// Unique, so only one should be found??
			return RTTEventVoAssembler.create((RTTEvent) lst.get(0));
		}
		
		return null;

	}

	/**
	* This method will cancel the given patient journey i.e. it will set the status as ended
	* and update all patient journey targets to ended
	*/
	public void endPatientJourney(PatientPathwayJourneyRefVo journey) throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		
		PatientPathwayJourney domJourney = (PatientPathwayJourney) factory.getDomainObject(PatientPathwayJourney.class, journey.getBoId());
		PatientJourneyStatus stat = createPatientJourneyStatus(getDomLookup(JourneyStatus.ENDPATHWAYJOURNEY));
		domJourney.setCurrentStatus(stat);
		domJourney.getStatusHistory().add(stat);
		domJourney.setEndedOnDate(new Date());
		
		// For All PatientJourneyTargets, we want to set their status to cancelled and set the cancelledDate
		Iterator it = domJourney.getPatientTargets().iterator();
		while (it.hasNext())
		{
			PatientJourneyTarget domPatTarget = (PatientJourneyTarget) it.next();
			domPatTarget.setCancelledDate(new Date());
			JourneyTargetStatus tStat = createJourneyTargetStatus(getDomLookup(PatientTargetStatus.NOTINSCOPE));  // TODO - What should this status be set to?
			domPatTarget.setCurrentStatus(tStat);
			domPatTarget.getStatusHistory().add(tStat);
		}
		
		// wdev-4597
		// When ending a Patient Journey, we need to stop the clock too
		if (domJourney.getCurrentClock() != null && domJourney.getCurrentClock().getStopDate() == null)
			domJourney.getCurrentClock().setStopDate(new Date());
		
		factory.save(domJourney);
	
	}

	/**
	* This is called if an appointment cancel or rearrange has been called.  
	* The previous event will have it's status changed to the status passed to this method
	*/
	
	public void updatePatientEvent(PatientRefVo patient, String clinicCode, DateTime scheduledDateTime, EventStatus status) throws DomainInterfaceException, StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		
		// We need to find the PatientEvent by patient, clinicCode and scheduledDateTime
				
		IMSCriteria crit= new IMSCriteria(PatientEvent.class, factory);
		crit.equal("patient.id", patient.getID_Patient());
		crit.equal("clinicCode", clinicCode);
		crit.equal("scheduledDate", scheduledDateTime.getJavaDate());
		
		List lst=crit.find();
		// If more than one item found, there is a problem somewhere
		// so we throw an error
		if (lst == null || lst.size() == 0)
		{
			// There could have been a time of zero - wdev-4119
			DateTime newDate = new DateTime(scheduledDateTime.getDate());
			newDate.setDateTime(scheduledDateTime.getDate(), new Time(0, 0));
			
			crit= new IMSCriteria(PatientEvent.class, factory);
			
			crit.equal("patient.id", patient.getID_Patient());
			crit.equal("clinicCode", clinicCode);
			crit.equal("scheduledDate", newDate.getJavaDate());
		
			lst=crit.find();
			
		}
		if (lst != null && lst.size() > 0)
		{
			for (int i=0; i<lst.size(); i++)
			{
				PatientEvent domPatEvent = (PatientEvent) lst.get(i);
				domPatEvent.setEventStatus(getDomLookup(status));
				factory.save(domPatEvent);
			}
		}
	}

	/**
	 * wdev-7919
	 * These methods were added as part of handling changing pathway type
	 * through messages
	 */
	public PathwayLiteVo findDefaultPathway(Specialty specialty) throws DomainInterfaceException 
	{
	
		return PathwayLiteVoAssembler.create(findDefaultPathway(getDomainFactory(), specialty, null));
	}

	public PathwayLiteVo findPseudoPathway(Specialty specialty) throws DomainInterfaceException 
	{
		
		return PathwayLiteVoAssembler.create(findPseudoPathway(getDomainFactory(), specialty));
	}

	public PatientJourneyVo updatePatientJourney(PatientJourneyVo patientJourney, PathwayLiteVo pathway) throws DomainInterfaceException, StaleObjectException
	{
		CreateNewPathway newImpl = (CreateNewPathway) getDomainImpl(CreateNewPathwayImpl.class);
		return newImpl.updatePatientJourney(patientJourney, pathway, null);
		
	}

	// WDEV-11723 
	public HL7ReferralVo getReferralByPatientAndRKEY(PatientRefVo patient,String referralKey) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer(" from Referral ref where ref.patient.id = :patient and ref.extReferralKey =:refKey");
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		labels.add("patient");
		labels.add("refKey");
		values.add(patient.getID_Patient());
		values.add(referralKey);
		
		List lst = factory.find(hql.toString(), labels, values);
		if (lst != null && lst.size() == 1)
		{
			return HL7ReferralVoAssembler.create((Referral) lst.get(0));
		}
		
		if (lst != null && lst.size() > 1)
		{
			throw new DomainInterfaceException("More than one referral found for this patient and referral key");
		}
		return null;
	}

	// WDEV-11723 
	public HL7ReferralVo saveReferral(HL7ReferralVo referral) throws StaleObjectException 
	{
		if (!referral.isValidated())
			throw new CodingRuntimeException("Referral has not been validated!");
		
		DomainFactory factory = getDomainFactory();
		
		Referral refBo = HL7ReferralVoAssembler.extractReferral(factory, referral);
		factory.save(refBo);
		
		return HL7ReferralVoAssembler.create(refBo);
		
	}
	
	
	/**
	 * WDEV-22995
	 * This method will update the CatsReferral with either 31 or 62 day target information if these patient journey target is of that type and a target dat exists.
	 * @param factory 					- DomainFactory
	 * @param patientPathwayJourney 	- Patient Journey currently being updated
	 * @param patientJourneyTarget 		- Patient Journey Target being updated
	 * @throws StaleObjectException 
	 */
	private void updateCatsReferralTargetDate(DomainFactory factory, PatientPathwayJourney patientPathwayJourney, PatientJourneyTarget patientJourneyTarget) throws StaleObjectException 
	{
		// First check if this is of type 31 or 62 day target
		boolean target31Day = false;
		boolean target62Day = false;
		
		if (patientJourneyTarget == null || patientJourneyTarget.getPathwayTarget() == null)
			return;
		
		Target domTarget = patientJourneyTarget.getPathwayTarget().getTarget();
		if (domTarget != null)
		{
			Iterator<TaxonomyMap> it = domTarget.getTaxonomyMaps().iterator();
			while (it.hasNext())
			{
				TaxonomyMap domMap = it.next();
				// Determine if this Patient Pathway Journey has a 31 day or 62 day Pathway Target type
				if (domMap != null 
						&& domMap.getTaxonomyCode() != null
						&& domMap.getTaxonomyCode().equals("31D") 
						&& domMap.getTaxonomyName() != null 
						&& domMap.getTaxonomyName().getId() == TaxonomyType.PAS.getId())
				{
					target31Day=true;
				}
				else if (domMap != null 
						&& domMap.getTaxonomyCode() != null 
						&& domMap.getTaxonomyCode().equals("62D") 
						&& domMap.getTaxonomyName() != null 
						&& domMap.getTaxonomyName().getId() == TaxonomyType.PAS.getId())
				{
					target62Day=true;
				}
			}
		}
		
		if (target31Day || target62Day)
		{
			// Get the CatsReferral for this Patient Pathway Journey
			StringBuffer hql = new StringBuffer(" select ref from CatsReferral ref where ref.journey = :journey");
						
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>();
			labels.add("journey");
			values.add(patientPathwayJourney);
									
			List catsReferralList = factory.find(hql.toString(), labels, values);
			if (catsReferralList != null 
					&& catsReferralList.size() > 0)
			{
				CatsReferral catsReferral = (CatsReferral) catsReferralList.get(0);
				
				if (target31Day 
						&& catsReferral != null 
						&& catsReferral.getCurrent31TargetDate() != null)
				{
					catsReferral.setCurrent31TargetDate(patientJourneyTarget.getTargetDate());
					factory.save(catsReferral);
				}
				
				if (target62Day 
						&& catsReferral != null 
						&& catsReferral.getCurrent62TargetDate() != null)
				{
					catsReferral.setCurrent62TargetDate(patientJourneyTarget.getTargetDate());
					factory.save(catsReferral);
				}
			}
		}
	} //WDEV-22995
	
}
