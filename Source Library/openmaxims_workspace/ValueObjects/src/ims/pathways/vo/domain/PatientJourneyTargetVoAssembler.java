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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:23
 *
 */
package ims.pathways.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class PatientJourneyTargetVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.pathways.vo.PatientJourneyTargetVo copy(ims.pathways.vo.PatientJourneyTargetVo valueObjectDest, ims.pathways.vo.PatientJourneyTargetVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatientJourneyTarget(valueObjectSrc.getID_PatientJourneyTarget());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// PathwayTarget
		valueObjectDest.setPathwayTarget(valueObjectSrc.getPathwayTarget());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
		// PathwayJourney
		valueObjectDest.setPathwayJourney(valueObjectSrc.getPathwayJourney());
		// WeekNumber
		valueObjectDest.setWeekNumber(valueObjectSrc.getWeekNumber());
		// TargetDate
		valueObjectDest.setTargetDate(valueObjectSrc.getTargetDate());
		// TargetCalFromDate
		valueObjectDest.setTargetCalFromDate(valueObjectSrc.getTargetCalFromDate());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.pathways.domain.objects.PatientJourneyTarget objects.
	 */
	public static ims.pathways.vo.PatientJourneyTargetVoCollection createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(java.util.Set domainObjectSet)	
	{
		return createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.pathways.domain.objects.PatientJourneyTarget objects.
	 */
	public static ims.pathways.vo.PatientJourneyTargetVoCollection createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.pathways.vo.PatientJourneyTargetVoCollection voList = new ims.pathways.vo.PatientJourneyTargetVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.pathways.domain.objects.PatientJourneyTarget domainObject = (ims.pathways.domain.objects.PatientJourneyTarget) iterator.next();
			ims.pathways.vo.PatientJourneyTargetVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.pathways.domain.objects.PatientJourneyTarget objects.
	 */
	public static ims.pathways.vo.PatientJourneyTargetVoCollection createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(java.util.List domainObjectList) 
	{
		return createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.pathways.domain.objects.PatientJourneyTarget objects.
	 */
	public static ims.pathways.vo.PatientJourneyTargetVoCollection createPatientJourneyTargetVoCollectionFromPatientJourneyTarget(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.pathways.vo.PatientJourneyTargetVoCollection voList = new ims.pathways.vo.PatientJourneyTargetVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.pathways.domain.objects.PatientJourneyTarget domainObject = (ims.pathways.domain.objects.PatientJourneyTarget) domainObjectList.get(i);
			ims.pathways.vo.PatientJourneyTargetVo vo = create(map, domainObject);

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
	 * Create the ims.pathways.domain.objects.PatientJourneyTarget set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatientJourneyTargetSet(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVoCollection voCollection) 
	 {
	 	return extractPatientJourneyTargetSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatientJourneyTargetSet(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.pathways.vo.PatientJourneyTargetVo vo = voCollection.get(i);
			ims.pathways.domain.objects.PatientJourneyTarget domainObject = PatientJourneyTargetVoAssembler.extractPatientJourneyTarget(domainFactory, vo, domMap);

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
	 * Create the ims.pathways.domain.objects.PatientJourneyTarget list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatientJourneyTargetList(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVoCollection voCollection) 
	 {
	 	return extractPatientJourneyTargetList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatientJourneyTargetList(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.pathways.vo.PatientJourneyTargetVo vo = voCollection.get(i);
			ims.pathways.domain.objects.PatientJourneyTarget domainObject = PatientJourneyTargetVoAssembler.extractPatientJourneyTarget(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.pathways.domain.objects.PatientJourneyTarget object.
	 * @param domainObject ims.pathways.domain.objects.PatientJourneyTarget
	 */
	 public static ims.pathways.vo.PatientJourneyTargetVo create(ims.pathways.domain.objects.PatientJourneyTarget domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.pathways.domain.objects.PatientJourneyTarget object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.pathways.vo.PatientJourneyTargetVo create(DomainObjectMap map, ims.pathways.domain.objects.PatientJourneyTarget domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.pathways.vo.PatientJourneyTargetVo valueObject = (ims.pathways.vo.PatientJourneyTargetVo) map.getValueObject(domainObject, ims.pathways.vo.PatientJourneyTargetVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.pathways.vo.PatientJourneyTargetVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.pathways.domain.objects.PatientJourneyTarget
	 */
	 public static ims.pathways.vo.PatientJourneyTargetVo insert(ims.pathways.vo.PatientJourneyTargetVo valueObject, ims.pathways.domain.objects.PatientJourneyTarget domainObject) 
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
	 * @param domainObject ims.pathways.domain.objects.PatientJourneyTarget
	 */
	 public static ims.pathways.vo.PatientJourneyTargetVo insert(DomainObjectMap map, ims.pathways.vo.PatientJourneyTargetVo valueObject, ims.pathways.domain.objects.PatientJourneyTarget domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatientJourneyTarget(domainObject.getId());
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
			
		// PathwayTarget
		valueObject.setPathwayTarget(ims.pathways.vo.domain.PathwayTargetShortVoAssembler.create(map, domainObject.getPathwayTarget()) );
		// CurrentStatus
		valueObject.setCurrentStatus(ims.pathways.vo.domain.JourneyTargetStatusVoAssembler.create(map, domainObject.getCurrentStatus()) );
		// PathwayJourney
		valueObject.setPathwayJourney(ims.pathways.vo.domain.PatientJourneyVoAssembler.create(map, domainObject.getPathwayJourney()) );
		// WeekNumber
		valueObject.setWeekNumber(domainObject.getWeekNumber());
		// TargetDate
		java.util.Date TargetDate = domainObject.getTargetDate();
		if ( null != TargetDate ) 
		{
			valueObject.setTargetDate(new ims.framework.utils.Date(TargetDate) );
		}
		// TargetCalFromDate
		java.util.Date TargetCalFromDate = domainObject.getTargetCalFromDate();
		if ( null != TargetCalFromDate ) 
		{
			valueObject.setTargetCalFromDate(new ims.framework.utils.Date(TargetCalFromDate) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.pathways.domain.objects.PatientJourneyTarget extractPatientJourneyTarget(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVo valueObject) 
	{
		return 	extractPatientJourneyTarget(domainFactory, valueObject, new HashMap());
	}

	public static ims.pathways.domain.objects.PatientJourneyTarget extractPatientJourneyTarget(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.PatientJourneyTargetVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatientJourneyTarget();
		ims.pathways.domain.objects.PatientJourneyTarget domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.pathways.domain.objects.PatientJourneyTarget)domMap.get(valueObject);
			}
			// ims.pathways.vo.PatientJourneyTargetVo ID_PatientJourneyTarget field is unknown
			domainObject = new ims.pathways.domain.objects.PatientJourneyTarget();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatientJourneyTarget());
			if (domMap.get(key) != null)
			{
				return (ims.pathways.domain.objects.PatientJourneyTarget)domMap.get(key);
			}
			domainObject = (ims.pathways.domain.objects.PatientJourneyTarget) domainFactory.getDomainObject(ims.pathways.domain.objects.PatientJourneyTarget.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatientJourneyTarget());

		domainObject.setPathwayTarget(ims.pathways.vo.domain.PathwayTargetShortVoAssembler.extractPathwayTarget(domainFactory, valueObject.getPathwayTarget(), domMap));
		domainObject.setCurrentStatus(ims.pathways.vo.domain.JourneyTargetStatusVoAssembler.extractJourneyTargetStatus(domainFactory, valueObject.getCurrentStatus(), domMap));
		domainObject.setPathwayJourney(ims.pathways.vo.domain.PatientJourneyVoAssembler.extractPatientPathwayJourney(domainFactory, valueObject.getPathwayJourney(), domMap));
		domainObject.setWeekNumber(valueObject.getWeekNumber());
		java.util.Date value5 = null;
		ims.framework.utils.Date date5 = valueObject.getTargetDate();		
		if ( date5 != null ) 
		{
			value5 = date5.getDate();
		}
		domainObject.setTargetDate(value5);
		java.util.Date value6 = null;
		ims.framework.utils.Date date6 = valueObject.getTargetCalFromDate();		
		if ( date6 != null ) 
		{
			value6 = date6.getDate();
		}
		domainObject.setTargetCalFromDate(value6);

		return domainObject;
	}

}
