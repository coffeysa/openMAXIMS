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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.65 build 3176.28343)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.careuk.domain.objects.CatsReferral;
import ims.careuk.vo.CatsReferralListVo;
import ims.careuk.vo.CatsReferralRefVo;
import ims.careuk.vo.domain.CatsReferralListVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.base.impl.BaseUploadDocumentImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.PatientDocumentVoCollection;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.core.vo.enums.DocumentViewLevel;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class UploadDocumentImpl extends BaseUploadDocumentImpl
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public PatientDocumentVoCollection listPatientDocuments(PatientRefVo patient, CareContextRefVo context, DocumentCategory category, CatsReferralRefVo refVo, DocumentViewLevel level) 
	{		
		if(patient == null || 
				(patient != null && patient.getID_Patient() == null))
					throw new DomainRuntimeException("Cannot get PatientDocumentVoCollection for null PatientRefVo");
		
		if (level == null)
			throw new DomainRuntimeException("Document Store Level cannot be null");
		
		DomainFactory factory = getDomainFactory();
		String mainHql = ""; 
		String hql = "";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " where ";
		
		if (level.equals(DocumentViewLevel.REFERRAL))
		{
			if (refVo != null) 
			{
				mainHql = "select distinct pd from PatientDocument pd ";			
				mainHql += " left join pd.patient as p left join pd.currentDocumentStatus as ds left join ds.correspondenceStatus as cs ";
				mainHql += " where ( ( p.id = :idPatient " +
						"and ( cs.id not in (" + DocumentStatus.DRAFT.getID() + ", " + DocumentStatus.FOR_REVIEW.getID() + ", " + DocumentStatus.FOR_UPDATE.getID() + ") " +
						"or pd.currentDocumentStatus is null) )";
				
				markers.add("idPatient");
				values.add(patient.getID_Patient());
				
				mainHql += " and ( (pd.careContext.id = :idCareContext) ";
				markers.add("idCareContext");
				values.add(context.getID_CareContext());
	
				mainHql += " or ( pd.id in (select rd.id from CatsReferral catsref1 ";
				mainHql += " left join catsref1.referralDocuments as rd where catsref1.id = :idCatsRef ) ) ) )";

				markers.add("idCatsRef");
				values.add(refVo.getID_CatsReferral());
			}
			else 
			{
				return null;
			}
		}
		else if (level.equals(DocumentViewLevel.CARECONTEXT))
		{
			mainHql = "select pd from PatientDocument pd ";			
			mainHql +=(" left join pd.patient as p left join pd.currentDocumentStatus as ds left join ds.correspondenceStatus as cs ");
			hql += andStr + " p.id = :idPatient  and (cs.id not in (" + DocumentStatus.DRAFT.getID() + ", " + DocumentStatus.FOR_REVIEW.getID() + ", " + DocumentStatus.FOR_UPDATE.getID() + ") or pd.currentDocumentStatus is null) ";
			markers.add("idPatient");
			values.add(patient.getID_Patient());
			
			if (context != null)
			{
				andStr = " and ";
				hql += andStr + " pd.careContext.id = :idCareContext";
				markers.add("idCareContext");
				values.add(context.getID_CareContext());
			}			
		}
		else if (level.equals(DocumentViewLevel.PATIENT))
		{
			mainHql = "select pd from PatientDocument pd ";			
			mainHql +=(" left join pd.patient as p left join pd.currentDocumentStatus as ds left join ds.correspondenceStatus as cs ");
			hql += andStr + " p.id = :idPatient and (cs.id not in (" + DocumentStatus.DRAFT.getID() + ", " + DocumentStatus.FOR_REVIEW.getID() + ", " + DocumentStatus.FOR_UPDATE.getID() + ") or pd.currentDocumentStatus is null)  ";
			markers.add("idPatient");
			values.add(patient.getID_Patient());
		}
				
		mainHql += hql;
		List documents = factory.find(mainHql,markers,values);					
		return PatientDocumentVoAssembler.createPatientDocumentVoCollectionFromPatientDocument(documents);	
	}

	public MemberOfStaffLiteVo getMoS(MemberOfStaffRefVo refVo) 
	{
		if(refVo == null || 
				(refVo != null && refVo.getID_MemberOfStaff() == null))
					throw new DomainRuntimeException("Cannot get MemberOfStaffLiteVo for null MemberOfStaffRefVo");
		
		DomainFactory factory = getDomainFactory();		
		MemberOfStaff doMos = (MemberOfStaff) factory.getDomainObject(MemberOfStaff.class, refVo.getID_MemberOfStaff());
		return MemberOfStaffLiteVoAssembler.create(doMos);		
	}

	//wdev-12880
	public CatsReferralListVo getCatsReferral(CatsReferralRefVo catsRefVo) 
	{
		if( catsRefVo == null )
			throw new DomainRuntimeException("CatsReferral cannot be null");
		
		return CatsReferralListVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, catsRefVo.getID_CatsReferral()));
	}
}