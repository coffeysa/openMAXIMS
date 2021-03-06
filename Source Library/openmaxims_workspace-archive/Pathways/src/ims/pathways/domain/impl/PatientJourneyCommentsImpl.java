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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.pathways.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.pathways.domain.base.impl.BasePatientJourneyCommentsImpl;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.domain.PatientJourneyCommentsVoAssembler;

public class PatientJourneyCommentsImpl extends BasePatientJourneyCommentsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* save
	 * @throws StaleObjectException 
	*/
	public ims.pathways.vo.PatientJourneyCommentsVo save(ims.pathways.vo.PatientJourneyCommentsVo record) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		PatientPathwayJourney domainRecord = PatientJourneyCommentsVoAssembler.extractPatientPathwayJourney(factory, record);		
		factory.save(domainRecord);
		
		return record;
	}
}
