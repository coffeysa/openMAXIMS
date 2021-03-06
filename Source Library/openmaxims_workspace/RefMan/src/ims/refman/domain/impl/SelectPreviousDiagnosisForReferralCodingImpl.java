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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5332.26009)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseSelectPreviousDiagnosisForReferralCodingImpl;
import ims.RefMan.vo.domain.PatientDiagnosisForReferralCodingVoAssembler;
import ims.domain.DomainFactory;

import java.util.ArrayList;

public class SelectPreviousDiagnosisForReferralCodingImpl extends BaseSelectPreviousDiagnosisForReferralCodingImpl
{
	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.PatientDiagnosisForReferralCodingVoCollection listDiagnosis(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = "select patdiag from PatientDiagnosis as patdiag left join patdiag.episodeOfCare as epcare left join epcare.careSpell as carespell left join carespell.patient as pat where pat.id = :PatID and epcare.id <> :episodeOfCareId order by patdiag.diagnosedDate desc";

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		markers.add("episodeOfCareId");
		values.add(episodeOfCare.getID_EpisodeOfCare());
		
		markers.add("PatID");
		values.add(patient.getID_Patient());
		
		return PatientDiagnosisForReferralCodingVoAssembler.createPatientDiagnosisForReferralCodingVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values));
	}
}
