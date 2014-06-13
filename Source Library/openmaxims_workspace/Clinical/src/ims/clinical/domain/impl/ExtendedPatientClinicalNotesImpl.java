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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3853.21665)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.clinical.domain.ClinicalNoteDrawing;
import ims.clinical.domain.ExtendedClinicalNotes;
import ims.clinical.domain.base.impl.BaseExtendedPatientClinicalNotesImpl;
import ims.clinical.vo.ExtendedClinicalNotesFilterVo;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.ClinicalContact;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.clinical.domain.objects.ClinicalNotes;
import ims.core.clinical.vo.ClinicalNotesRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalNotesShortVoCollection;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.ClinicalContactShortVoAssembler;
import ims.core.vo.domain.ClinicalNotesShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class ExtendedPatientClinicalNotesImpl extends BaseExtendedPatientClinicalNotesImpl
{

	private static final long serialVersionUID = 1L;

	public ClinicalNotesShortVoCollection listClinicalNote(ExtendedClinicalNotesFilterVo filter)
	{
		DomainFactory factory = getDomainFactory();
			
		if(filter == null)	
			return ClinicalNotesShortVoAssembler.createClinicalNotesShortVoCollectionFromClinicalNotes(factory.listDomainObjects(ClinicalNotes.class));

		return ClinicalNotesShortVoAssembler.createClinicalNotesShortVoCollectionFromClinicalNotes(listDomClinicalNotes(factory, filter));		
		
	}
	
	private List listDomClinicalNotes(DomainFactory factory, ims.clinical.vo.ExtendedClinicalNotesFilterVo filter)
	{
		String hql = " from ClinicalNotes note "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(filter.getDateFromIsNotNull())
		{
			condStr.append(andStr + " note.recordingDateTime >= :dateFrom");
 			markers.add("dateFrom");
			values.add(filter.getDateFrom().getJavaDate());
			andStr = " and ";	
		}
		if(filter.getDateToIsNotNull())
		{
			condStr.append(andStr + " note.recordingDateTime < :dateTo");
 			markers.add("dateTo");
			values.add(filter.getDateTo().getJavaDate());
			andStr = " and ";	
		}
		if(filter.getDisciplineIsNotNull())
		{
			condStr.append(andStr + " note.discipline = :discipline");
 			markers.add("discipline");
			values.add(getDomLookup(filter.getDiscipline()));
			andStr = " and ";	
		}
		if(filter.getCareContextIsNotNull())
		{
			condStr.append(andStr + " note.careContext.id = :ccId");
 			markers.add("ccId");
			values.add(filter.getCareContext().getID_CareContext());
			andStr = " and ";	
		}
		if(filter.getPatientIsNotNull() && filter.getPatient().getID_PatientIsNotNull())
		{
			condStr.append(andStr + " note.careContext.episodeOfCare.careSpell.patient.id = :patientId");
 			markers.add("patientId");
			values.add(filter.getPatient().getID_Patient());
			andStr = " and ";	
		}
		if(filter.getStatusIsNotNull())
		{
			condStr.append(andStr + " note.currentStatus.status = :status");
 			markers.add("status");
			values.add(getDomLookup(filter.getStatus()));
			andStr = " and ";	
		}
		if(filter.getAuthoringHCPIsNotNull())
		{
			condStr.append(andStr + " note.authoringInformation.authoringHcp.id = :authHcpId");
 			markers.add("authHcpId");
			values.add(filter.getAuthoringHCP().getID_Hcp());
			andStr = " and ";				
		}
		if(filter.getRecordingUserIsNotNull())
		{
			condStr.append(andStr + " note.recordingUser.id = :recHcpId");
 			markers.add("recHcpId");
			values.add(filter.getRecordingUser().getID_MemberOfStaff());
			andStr = " and ";				
		}
		if(filter.getNoteClassificationIsNotNull())
		{
			condStr.append(andStr + " note.noteClassification = :noteClass");
 			markers.add("noteClass");
			values.add(getDomLookup(filter.getNoteClassification()));
			andStr = " and ";				
		}	

		if(filter.getForReviewIsNotNull())
		{
			condStr.append(andStr + " note.forReview = :forrev");
 			markers.add("forrev");
			values.add(filter.getForReview());
			andStr = " and ";		
			
			condStr.append(andStr + " note.reviewingDateTime = null");
 			andStr = " and ";		
			condStr.append(andStr + " note.reviewingHCP = null");
 			andStr = " and ";		
		}
		if(filter.getForReviewDisciplineIsNotNull())
		{
			condStr.append(andStr + " note.forReviewDiscipline = :reviewDisp");
 			markers.add("reviewDisp");
			values.add(getDomLookup(filter.getForReviewDiscipline()));
			andStr = " and ";				
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		hql += " order by note.recordingDateTime desc";
		
		return factory.find(hql,markers,values);
	}
	
	public ClinicalNotesVo getClinicalNotesForContact(ClinicalContactRefVo clincontactRefId) 
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return impl.getClinicalNotesForContact(clincontactRefId);
	}

	public ims.core.vo.ClinicalNotesVo getClinicalNote(ClinicalNotesRefVo clinicalNoteRefVo)
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return impl.getClinicalNotes(clinicalNoteRefVo.getID_ClinicalNotes());

	}

	public ClinicalContactShortVo getCurrentClinicalContact(ClinicalContactRefVo clinContactRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		ClinicalContact doCC = (ClinicalContact) factory.getDomainObject(ClinicalContact.class, clinContactRefVo.getID_ClinicalContact());
		return (ClinicalContactShortVoAssembler.create(doCC));
	}

	public CareContextShortVo getCurrentCareContext(CareContextRefVo careContextRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		CareContext doCC = (CareContext) factory.getDomainObject(CareContext.class, careContextRefVo.getID_CareContext());
		return (CareContextShortVoAssembler.create(doCC));
	}

	public MemberOfStaffVo getMemberOfStaff(MemberOfStaffShortVo mos)
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdmin.getMemberOfStaff(mos);
	}

	public ClinicalNotesVo getClinicalNotesForCareContext(CareContextRefVo careContextRefVo) 
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		CareContextShortVo voCCShort = new CareContextShortVo();
		voCCShort.setID_CareContext(careContextRefVo.getID_CareContext());
		return impl.getClinicalNotesForCareContext(voCCShort);
	}

	public CareContextShortVoCollection listCareContexts(PatientRefVo patientRefVo) 
	{
		String hql = " from CareContext cc "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		DomainFactory factory = getDomainFactory();

		condStr.append(andStr + " cc.episodeOfCare.careSpell.patient.id = :patId");
 		markers.add("patId");
		values.add(patientRefVo.getID_Patient());
		andStr = " and ";	

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		hql += " order by cc.startDateTime desc";
		
		List list = factory.find(hql,markers,values);
	
		
		if(list != null && list.size() > 0)	
			return CareContextShortVoAssembler.createCareContextShortVoCollectionFromCareContext(list);

		return null;		
	}

	public ClinicalNotesVo saveClinicalNotes(ClinicalNotesVo clinicalNotesVo) throws DomainInterfaceException, StaleObjectException 
	{
		ExtendedClinicalNotes impl = (ExtendedClinicalNotes)getDomainImpl(ExtendedClinicalNotesImpl.class);
		return impl.saveClinicalNotes(clinicalNotesVo);
	}

	public String[] getReportAndTemplate(Integer reportID) 
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
			
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {reportID});
			
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
				
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
			
		return result;
	}

	//WDEV-15239
	public Boolean isStale(ClinicalNotesRefVo clinicalNote)
	{
		if (clinicalNote == null || clinicalNote.getID_ClinicalNotes() == null)
		{
			throw new CodingRuntimeException("Cannot get ClinicalNotesVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		ClinicalNotes domainClinicalNote = (ClinicalNotes) factory.getDomainObject(ClinicalNotes.class, clinicalNote.getID_ClinicalNotes());

		if (domainClinicalNote == null)
		{
			return true;
		}

		if (domainClinicalNote.getVersion() > clinicalNote.getVersion_ClinicalNotes())
		{
			return true;
		}

		return false;
	}
}