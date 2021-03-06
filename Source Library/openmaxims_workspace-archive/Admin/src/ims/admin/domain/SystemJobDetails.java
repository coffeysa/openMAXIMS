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

package ims.admin.domain;

// Generated from form domain impl
public interface SystemJobDetails extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public void test();

	// Generated from form domain interface definition
	public ims.core.vo.PatientLiteVo getPatientByHospitalNo(String hospitalNo);

	// Generated from form domain interface definition
	public void savePatientDocument(ims.core.vo.PatientDocumentVo document, ims.core.vo.DocumentConversionVo oldDocument, ims.core.vo.ConversionDetailsVo conversionDetailsVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void save(ims.core.vo.ConversionDetailsVo job) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* saveSystemJobDetails
	*/
	public ims.admin.vo.ConfiguredJobVo saveSystemJobDetails(ims.admin.vo.ConfiguredJobVo jobDetails) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getSystemJobDetailsByImsId
	*/
	public ims.admin.vo.ConfiguredJobVo getSystemJobDetailsByImsId(Integer imsId);

	// Generated from form domain interface definition
	/**
	* listAvailableSystemJobs
	*/
	public ims.admin.vo.SystemJobVoCollection listAvailableSystemJobs();

	// Generated from form domain interface definition
	/**
	* getAppUsersShort
	*/
	public ims.admin.vo.AppUserShortVo getAppUsersShort(ims.core.configuration.vo.AppUserRefVo voRef);
}
