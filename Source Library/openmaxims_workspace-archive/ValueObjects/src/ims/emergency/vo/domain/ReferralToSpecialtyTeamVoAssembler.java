//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Bogdan Tofei
 */
public class ReferralToSpecialtyTeamVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.ReferralToSpecialtyTeamVo copy(ims.emergency.vo.ReferralToSpecialtyTeamVo valueObjectDest, ims.emergency.vo.ReferralToSpecialtyTeamVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralToSpecTeam(valueObjectSrc.getID_ReferralToSpecTeam());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Patient
		valueObjectDest.setPatient(valueObjectSrc.getPatient());
		// Episode
		valueObjectDest.setEpisode(valueObjectSrc.getEpisode());
		// Attendance
		valueObjectDest.setAttendance(valueObjectSrc.getAttendance());
		// TrackingArea
		valueObjectDest.setTrackingArea(valueObjectSrc.getTrackingArea());
		// TeamConsultant
		valueObjectDest.setTeamConsultant(valueObjectSrc.getTeamConsultant());
		// Specialty
		valueObjectDest.setSpecialty(valueObjectSrc.getSpecialty());
		// ReferredDateTime
		valueObjectDest.setReferredDateTime(valueObjectSrc.getReferredDateTime());
		// SeenDateTime
		valueObjectDest.setSeenDateTime(valueObjectSrc.getSeenDateTime());
		// CompletionDateTime
		valueObjectDest.setCompletionDateTime(valueObjectSrc.getCompletionDateTime());
		// ReferredBy
		valueObjectDest.setReferredBy(valueObjectSrc.getReferredBy());
		// Comments
		valueObjectDest.setComments(valueObjectSrc.getComments());
		// SystemInformation
		valueObjectDest.setSystemInformation(valueObjectSrc.getSystemInformation());
		// NotAccepted
		valueObjectDest.setNotAccepted(valueObjectSrc.getNotAccepted());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.ReferralToSpecTeam objects.
	 */
	public static ims.emergency.vo.ReferralToSpecialtyTeamVoCollection createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(java.util.Set domainObjectSet)	
	{
		return createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.domain.objects.ReferralToSpecTeam objects.
	 */
	public static ims.emergency.vo.ReferralToSpecialtyTeamVoCollection createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voList = new ims.emergency.vo.ReferralToSpecialtyTeamVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.domain.objects.ReferralToSpecTeam domainObject = (ims.emergency.domain.objects.ReferralToSpecTeam) iterator.next();
			ims.emergency.vo.ReferralToSpecialtyTeamVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.emergency.domain.objects.ReferralToSpecTeam objects.
	 */
	public static ims.emergency.vo.ReferralToSpecialtyTeamVoCollection createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(java.util.List domainObjectList) 
	{
		return createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.domain.objects.ReferralToSpecTeam objects.
	 */
	public static ims.emergency.vo.ReferralToSpecialtyTeamVoCollection createReferralToSpecialtyTeamVoCollectionFromReferralToSpecTeam(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voList = new ims.emergency.vo.ReferralToSpecialtyTeamVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.domain.objects.ReferralToSpecTeam domainObject = (ims.emergency.domain.objects.ReferralToSpecTeam) domainObjectList.get(i);
			ims.emergency.vo.ReferralToSpecialtyTeamVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.emergency.domain.objects.ReferralToSpecTeam set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralToSpecTeamSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voCollection) 
	 {
	 	return extractReferralToSpecTeamSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralToSpecTeamSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.ReferralToSpecialtyTeamVo vo = voCollection.get(i);
			ims.emergency.domain.objects.ReferralToSpecTeam domainObject = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.emergency.domain.objects.ReferralToSpecTeam list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralToSpecTeamList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voCollection) 
	 {
	 	return extractReferralToSpecTeamList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralToSpecTeamList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.ReferralToSpecialtyTeamVo vo = voCollection.get(i);
			ims.emergency.domain.objects.ReferralToSpecTeam domainObject = ReferralToSpecialtyTeamVoAssembler.extractReferralToSpecTeam(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.emergency.domain.objects.ReferralToSpecTeam object.
	 * @param domainObject ims.emergency.domain.objects.ReferralToSpecTeam
	 */
	 public static ims.emergency.vo.ReferralToSpecialtyTeamVo create(ims.emergency.domain.objects.ReferralToSpecTeam domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.domain.objects.ReferralToSpecTeam object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.ReferralToSpecialtyTeamVo create(DomainObjectMap map, ims.emergency.domain.objects.ReferralToSpecTeam domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.ReferralToSpecialtyTeamVo valueObject = (ims.emergency.vo.ReferralToSpecialtyTeamVo) map.getValueObject(domainObject, ims.emergency.vo.ReferralToSpecialtyTeamVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.ReferralToSpecialtyTeamVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.domain.objects.ReferralToSpecTeam
	 */
	 public static ims.emergency.vo.ReferralToSpecialtyTeamVo insert(ims.emergency.vo.ReferralToSpecialtyTeamVo valueObject, ims.emergency.domain.objects.ReferralToSpecTeam domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.domain.objects.ReferralToSpecTeam
	 */
	 public static ims.emergency.vo.ReferralToSpecialtyTeamVo insert(DomainObjectMap map, ims.emergency.vo.ReferralToSpecialtyTeamVo valueObject, ims.emergency.domain.objects.ReferralToSpecTeam domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralToSpecTeam(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// Patient
		if (domainObject.getPatient() != null)
		{
			if(domainObject.getPatient() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPatient();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(id, -1));				
			}
			else
			{
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(domainObject.getPatient().getId(), domainObject.getPatient().getVersion()));
			}
		}
		// Episode
		if (domainObject.getEpisode() != null)
		{
			if(domainObject.getEpisode() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getEpisode();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setEpisode(new ims.core.admin.vo.EpisodeOfCareRefVo(id, -1));				
			}
			else
			{
				valueObject.setEpisode(new ims.core.admin.vo.EpisodeOfCareRefVo(domainObject.getEpisode().getId(), domainObject.getEpisode().getVersion()));
			}
		}
		// Attendance
		if (domainObject.getAttendance() != null)
		{
			if(domainObject.getAttendance() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getAttendance();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setAttendance(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setAttendance(new ims.core.admin.vo.CareContextRefVo(domainObject.getAttendance().getId(), domainObject.getAttendance().getVersion()));
			}
		}
		// TrackingArea
		if (domainObject.getTrackingArea() != null)
		{
			if(domainObject.getTrackingArea() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getTrackingArea();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setTrackingArea(new ims.emergency.configuration.vo.TrackingAreaRefVo(id, -1));				
			}
			else
			{
				valueObject.setTrackingArea(new ims.emergency.configuration.vo.TrackingAreaRefVo(domainObject.getTrackingArea().getId(), domainObject.getTrackingArea().getVersion()));
			}
		}
		// TeamConsultant
		ims.domain.lookups.LookupInstance instance5 = domainObject.getTeamConsultant();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam voLookup5 = new ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setTeamConsultant(voLookup5);
		}
				// Specialty
		ims.domain.lookups.LookupInstance instance6 = domainObject.getSpecialty();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.Specialty voLookup6 = new ims.core.vo.lookups.Specialty(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.core.vo.lookups.Specialty parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.core.vo.lookups.Specialty(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setSpecialty(voLookup6);
		}
				// ReferredDateTime
		java.util.Date ReferredDateTime = domainObject.getReferredDateTime();
		if ( null != ReferredDateTime ) 
		{
			valueObject.setReferredDateTime(new ims.framework.utils.DateTime(ReferredDateTime) );
		}
		// SeenDateTime
		java.util.Date SeenDateTime = domainObject.getSeenDateTime();
		if ( null != SeenDateTime ) 
		{
			valueObject.setSeenDateTime(new ims.framework.utils.DateTime(SeenDateTime) );
		}
		// CompletionDateTime
		java.util.Date CompletionDateTime = domainObject.getCompletionDateTime();
		if ( null != CompletionDateTime ) 
		{
			valueObject.setCompletionDateTime(new ims.framework.utils.DateTime(CompletionDateTime) );
		}
		// ReferredBy
		valueObject.setReferredBy(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getReferredBy()) );
		// Comments
		valueObject.setComments(ims.emergency.vo.domain.AttendanceClinicalNotesVoAssembler.createAttendanceClinicalNotesVoCollectionFromAttendanceClinicalNotes(map, domainObject.getComments()) );
		// SystemInformation
		// set system information
		valueObject.setSystemInformation(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
		// NotAccepted
		valueObject.setNotAccepted( domainObject.isNotAccepted() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.domain.objects.ReferralToSpecTeam extractReferralToSpecTeam(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVo valueObject) 
	{
		return 	extractReferralToSpecTeam(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.domain.objects.ReferralToSpecTeam extractReferralToSpecTeam(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.ReferralToSpecialtyTeamVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralToSpecTeam();
		ims.emergency.domain.objects.ReferralToSpecTeam domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.domain.objects.ReferralToSpecTeam)domMap.get(valueObject);
			}
			// ims.emergency.vo.ReferralToSpecialtyTeamVo ID_ReferralToSpecTeam field is unknown
			domainObject = new ims.emergency.domain.objects.ReferralToSpecTeam();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralToSpecTeam());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.domain.objects.ReferralToSpecTeam)domMap.get(key);
			}
			domainObject = (ims.emergency.domain.objects.ReferralToSpecTeam) domainFactory.getDomainObject(ims.emergency.domain.objects.ReferralToSpecTeam.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralToSpecTeam());

		ims.core.patient.domain.objects.Patient value1 = null;
		if ( null != valueObject.getPatient() ) 
		{
			if (valueObject.getPatient().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatient()) != null)
				{
					value1 = (ims.core.patient.domain.objects.Patient)domMap.get(valueObject.getPatient());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getPatient();	
			}
			else
			{
				value1 = (ims.core.patient.domain.objects.Patient)domainFactory.getDomainObject(ims.core.patient.domain.objects.Patient.class, valueObject.getPatient().getBoId());
			}
		}
		domainObject.setPatient(value1);
		ims.core.admin.domain.objects.EpisodeOfCare value2 = null;
		if ( null != valueObject.getEpisode() ) 
		{
			if (valueObject.getEpisode().getBoId() == null)
			{
				if (domMap.get(valueObject.getEpisode()) != null)
				{
					value2 = (ims.core.admin.domain.objects.EpisodeOfCare)domMap.get(valueObject.getEpisode());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getEpisode();	
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.EpisodeOfCare)domainFactory.getDomainObject(ims.core.admin.domain.objects.EpisodeOfCare.class, valueObject.getEpisode().getBoId());
			}
		}
		domainObject.setEpisode(value2);
		ims.core.admin.domain.objects.CareContext value3 = null;
		if ( null != valueObject.getAttendance() ) 
		{
			if (valueObject.getAttendance().getBoId() == null)
			{
				if (domMap.get(valueObject.getAttendance()) != null)
				{
					value3 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getAttendance());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getAttendance();	
			}
			else
			{
				value3 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getAttendance().getBoId());
			}
		}
		domainObject.setAttendance(value3);
		ims.emergency.configuration.domain.objects.TrackingArea value4 = null;
		if ( null != valueObject.getTrackingArea() ) 
		{
			if (valueObject.getTrackingArea().getBoId() == null)
			{
				if (domMap.get(valueObject.getTrackingArea()) != null)
				{
					value4 = (ims.emergency.configuration.domain.objects.TrackingArea)domMap.get(valueObject.getTrackingArea());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value4 = domainObject.getTrackingArea();	
			}
			else
			{
				value4 = (ims.emergency.configuration.domain.objects.TrackingArea)domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.TrackingArea.class, valueObject.getTrackingArea().getBoId());
			}
		}
		domainObject.setTrackingArea(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getTeamConsultant() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getTeamConsultant().getID());
		}
		domainObject.setTeamConsultant(value5);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getSpecialty() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getSpecialty().getID());
		}
		domainObject.setSpecialty(value6);
		ims.framework.utils.DateTime dateTime7 = valueObject.getReferredDateTime();
		java.util.Date value7 = null;
		if ( dateTime7 != null ) 
		{
			value7 = dateTime7.getJavaDate();
		}
		domainObject.setReferredDateTime(value7);
		ims.framework.utils.DateTime dateTime8 = valueObject.getSeenDateTime();
		java.util.Date value8 = null;
		if ( dateTime8 != null ) 
		{
			value8 = dateTime8.getJavaDate();
		}
		domainObject.setSeenDateTime(value8);
		ims.framework.utils.DateTime dateTime9 = valueObject.getCompletionDateTime();
		java.util.Date value9 = null;
		if ( dateTime9 != null ) 
		{
			value9 = dateTime9.getJavaDate();
		}
		domainObject.setCompletionDateTime(value9);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value10 = null;
		if ( null != valueObject.getReferredBy() ) 
		{
			if (valueObject.getReferredBy().getBoId() == null)
			{
				if (domMap.get(valueObject.getReferredBy()) != null)
				{
					value10 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getReferredBy());
				}
			}
			else
			{
				value10 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getReferredBy().getBoId());
			}
		}
		domainObject.setReferredBy(value10);
		domainObject.setComments(ims.emergency.vo.domain.AttendanceClinicalNotesVoAssembler.extractAttendanceClinicalNotesList(domainFactory, valueObject.getComments(), domainObject.getComments(), domMap));		
		domainObject.setNotAccepted(valueObject.getNotAccepted());

		return domainObject;
	}

}
