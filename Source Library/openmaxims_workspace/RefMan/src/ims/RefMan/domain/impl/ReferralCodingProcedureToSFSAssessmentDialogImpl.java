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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseReferralCodingProcedureToSFSAssessmentDialogImpl;
import ims.RefMan.domain.objects.SuitableForSurgeryAssessment;
import ims.RefMan.vo.domain.SuitableForSurgeryAssessmentLiteVoAssembler;
import ims.core.clinical.domain.objects.PatientProcedure;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.vo.PatientProcedureLiteVo;
import ims.core.vo.domain.PatientProcedureLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.exceptions.CodingRuntimeException;

public class ReferralCodingProcedureToSFSAssessmentDialogImpl extends BaseReferralCodingProcedureToSFSAssessmentDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo saveAssessment(ims.RefMan.vo.SuitableForSurgeryAssessmentLiteVo assessment) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if (assessment == null)
			throw new DomainInterfaceException("Can not save an empty assessment");
			
		if (!assessment.isValidated())
			throw new CodingRuntimeException("Logical Error - Validate VO before saving");

		DomainFactory factory = getDomainFactory();
		
		SuitableForSurgeryAssessment assessmentDOM = SuitableForSurgeryAssessmentLiteVoAssembler.extractSuitableForSurgeryAssessment(factory, assessment);
		factory.save(assessmentDOM);
		return SuitableForSurgeryAssessmentLiteVoAssembler.create(assessmentDOM);
	}

	public PatientProcedureLiteVo getProcedureLiteVo(PatientProcedureRefVo procRefVo)
	{
		DomainFactory factory = getDomainFactory();
		PatientProcedure proc = (PatientProcedure) factory.getDomainObject(PatientProcedure.class, procRefVo.getID_PatientProcedure());
		return (PatientProcedureLiteVoAssembler.create(proc));
	}
}
