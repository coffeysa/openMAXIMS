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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.65 build 3225.30788)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ReferralOutcomeComponent;
import ims.RefMan.domain.ReferralWizard;
import ims.RefMan.domain.base.impl.BaseOnwardReferralRejectionImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class OnwardReferralRejectionImpl extends BaseOnwardReferralRejectionImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.ReferralOutcomeVo getReferralOutcome(ims.RefMan.vo.CatsReferralRefVo voCATSRef)
	{
		ReferralOutcomeComponent impl = (ReferralOutcomeComponent) getDomainImpl(ReferralOutcomeComponentImpl.class);
		
		return impl.getReferralOutcome(voCATSRef);
	}

	public ims.RefMan.vo.ReferralOutcomeVo saveCurrentOnwardReferral(ims.RefMan.vo.ReferralOutcomeVo referralOutcome) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		ReferralOutcomeComponent impl = (ReferralOutcomeComponent) getDomainImpl(ReferralOutcomeComponentImpl.class);
		
		return impl.saveReferralOutcome(referralOutcome);
	}

	public CatsReferralWizardVo getCatsReferral(CatsReferralRefVo catsReferral) 
	{
		if(catsReferral == null || (catsReferral != null && !catsReferral.getID_CatsReferralIsNotNull()))
			throw new CodingRuntimeException("Cannot get CatsReferral on null CatsReferralRef.");
		
		return CatsReferralWizardVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, catsReferral.getID_CatsReferral()));
	}

	public CatsReferralWizardVo saveCatsReferral(CatsReferralWizardVo catsReferral) throws DomainInterfaceException, StaleObjectException 
	{
		ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
		
		return impl.saveCatsReferral(catsReferral);
	}
}
