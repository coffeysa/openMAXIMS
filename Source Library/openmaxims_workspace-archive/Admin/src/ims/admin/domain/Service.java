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
public interface Service extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list services
	*/
	public ims.core.vo.ServiceVoCollection listService(ims.core.vo.ServiceShortVo filter);

	// Generated from form domain interface definition
	/**
	* save a service and associated functions/activities
	*/
	public ims.core.vo.ServiceVo saveService(ims.core.vo.ServiceVo voService) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* list activities for a service
	*/
	public ims.core.vo.ServiceActivityVoCollection listServiceActivity(ims.core.vo.ServiceShortVo voService);

	// Generated from form domain interface definition
	/**
	* list functions for an activity
	*/
	public ims.core.vo.ServiceFunctionVoCollection listServiceFunction(ims.core.vo.ServiceShortVo voService);

	// Generated from form domain interface definition
	/**
	* save service functions
	*/
	public ims.core.vo.ServiceFunctionVoCollection saveServiceFunction(ims.core.vo.ServiceFunctionVoCollection vocollServiceFunction, ims.core.vo.ServiceFunctionVoCollection voCollServiceFunctionDelete) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* remove a service function
	*/
	public void removeServiceFunction(ims.core.vo.ServiceFunctionVo voServiceFunction) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* list all active services into a specalitylistvo collection
	*/
	public ims.core.vo.SpecialtyListVoCollection listService(Boolean bActive);

	// Generated from form domain interface definition
	/**
	* list all services in supplied int array
	*/
	public ims.core.vo.ServiceVoCollection listService(Integer[] nServiceIds);

	// Generated from form domain interface definition
	/**
	* list activity
	*/
	public ims.core.vo.ActivityVoCollection listActivity(String nameFilter, ims.core.vo.lookups.ActivityType activityType, Boolean bActive) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* save service activity associations
	*/
	public ims.core.vo.ServiceActivityVoCollection saveServiceActivity(ims.core.vo.ServiceActivityVoCollection voCollServiceActivity, ims.core.vo.ServiceActivityVoCollection voCollServiceActivityDelete) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public void removeServiceActivity(ims.core.vo.ServiceActivityVo voServiceActivity) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceActivityVo getServiceActivity(ims.core.clinical.vo.ServiceRefVo serviceRefVo, ims.core.resource.place.vo.ActivityRefVo activityRefVo);

	// Generated from form domain interface definition
	public String checkLSALinks(ims.core.vo.ServiceActivityVo voServiceActivity) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* Get a ProceduteVo for an ActivityVo
	*/
	public ims.core.vo.ProcedureVo getProcedureForActivity(ims.core.resource.place.vo.ActivityRefVo activityRefVo);

	// Generated from form domain interface definition
	/**
	* isServiceActivityUnique
	*/
	public String isServiceActivityUnique(ims.core.vo.TaxonomyMapCollection map, ims.core.vo.ServiceVo voService);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVo getServiceById(ims.core.vo.ServiceVo voService);

	// Generated from form domain interface definition
	/**
	* listActiveServiceLiteByName
	*/
	public ims.core.vo.ServiceLiteVoCollection listActiveServiceLiteByNameAndCategories(String name, ims.core.vo.lookups.ServiceCategoryCollection categoryCollection);

	// Generated from form domain interface definition
	/**
	* listActiveServiceLiteByName
	*/
	public ims.core.vo.ServiceLiteVoCollection listActiveServiceLiteByName(String name);

	// Generated from form domain interface definition
	/**
	* list services
	*/
	public ims.core.vo.ServiceLiteVoCollection listServiceLite(ims.core.vo.ServiceShortVo filter);
}
