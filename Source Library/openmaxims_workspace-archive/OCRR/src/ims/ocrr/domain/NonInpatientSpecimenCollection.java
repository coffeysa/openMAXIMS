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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.domain;

// Generated from form domain impl
public interface NonInpatientSpecimenCollection extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list the WorkListItems returned by the search criteria
	*/
	public ims.ocrr.vo.SpecimenWorkListItemListVoCollection listWorkListItems(ims.ocrr.vo.lookups.SpecimenCollectionStatus specimenStatus, ims.ocrr.vo.lookups.SpecimenCollectionStatus secondSpecimenStatus, ims.framework.utils.Date fromDate, ims.framework.utils.Time fromTime, ims.framework.utils.Date toDate, ims.framework.utils.Time toTime);

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);

	// Generated from form domain interface definition
	/**
	* saveOrderSpecimen
	*/
	public ims.ocrr.vo.SpecimenWorkListItemListVo saveWorkListItem(ims.ocrr.vo.SpecimenWorkListItemListVo orderSpecimenVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* checks to see if there is at least one InvestigationIndex having phlebMayCollect = true for the current SpecimenWorkListItem
	*/
	public Boolean isAtLeastOneActivePhlebMayCollect(ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVo specimenWorkListItemRefVo);

	// Generated from form domain interface definition
	/**
	* get the PatientShort
	*/
	public ims.core.vo.PatientShort getPatient(ims.core.patient.vo.PatientRefVo patientRefVo);
}
