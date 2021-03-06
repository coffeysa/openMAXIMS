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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.nursing.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Neil McAnaspie
 */
public class InterventionChartHeaderVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.nursing.vo.InterventionChartHeaderVo copy(ims.nursing.vo.InterventionChartHeaderVo valueObjectDest, ims.nursing.vo.InterventionChartHeaderVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_InterventionChart(valueObjectSrc.getID_InterventionChart());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringHCP
		valueObjectDest.setAuthoringHCP(valueObjectSrc.getAuthoringHCP());
		// AuthoringDateTime
		valueObjectDest.setAuthoringDateTime(valueObjectSrc.getAuthoringDateTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createInterventionChartHeaderVoCollectionFromInterventionChart(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.nursing.domain.objects.InterventionChart objects.
	 */
	public static ims.nursing.vo.InterventionChartHeaderVoCollection createInterventionChartHeaderVoCollectionFromInterventionChart(java.util.Set domainObjectSet)	
	{
		return createInterventionChartHeaderVoCollectionFromInterventionChart(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.nursing.domain.objects.InterventionChart objects.
	 */
	public static ims.nursing.vo.InterventionChartHeaderVoCollection createInterventionChartHeaderVoCollectionFromInterventionChart(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.nursing.vo.InterventionChartHeaderVoCollection voList = new ims.nursing.vo.InterventionChartHeaderVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.nursing.domain.objects.InterventionChart domainObject = (ims.nursing.domain.objects.InterventionChart) iterator.next();
			ims.nursing.vo.InterventionChartHeaderVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.nursing.domain.objects.InterventionChart objects.
	 */
	public static ims.nursing.vo.InterventionChartHeaderVoCollection createInterventionChartHeaderVoCollectionFromInterventionChart(java.util.List domainObjectList) 
	{
		return createInterventionChartHeaderVoCollectionFromInterventionChart(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.nursing.domain.objects.InterventionChart objects.
	 */
	public static ims.nursing.vo.InterventionChartHeaderVoCollection createInterventionChartHeaderVoCollectionFromInterventionChart(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.nursing.vo.InterventionChartHeaderVoCollection voList = new ims.nursing.vo.InterventionChartHeaderVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.nursing.domain.objects.InterventionChart domainObject = (ims.nursing.domain.objects.InterventionChart) domainObjectList.get(i);
			ims.nursing.vo.InterventionChartHeaderVo vo = create(map, domainObject);

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
	 * Create the ims.nursing.domain.objects.InterventionChart set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractInterventionChartSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVoCollection voCollection) 
	 {
	 	return extractInterventionChartSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractInterventionChartSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.InterventionChartHeaderVo vo = voCollection.get(i);
			ims.nursing.domain.objects.InterventionChart domainObject = InterventionChartHeaderVoAssembler.extractInterventionChart(domainFactory, vo, domMap);

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
	 * Create the ims.nursing.domain.objects.InterventionChart list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractInterventionChartList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVoCollection voCollection) 
	 {
	 	return extractInterventionChartList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractInterventionChartList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.InterventionChartHeaderVo vo = voCollection.get(i);
			ims.nursing.domain.objects.InterventionChart domainObject = InterventionChartHeaderVoAssembler.extractInterventionChart(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.nursing.domain.objects.InterventionChart object.
	 * @param domainObject ims.nursing.domain.objects.InterventionChart
	 */
	 public static ims.nursing.vo.InterventionChartHeaderVo create(ims.nursing.domain.objects.InterventionChart domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.nursing.domain.objects.InterventionChart object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.nursing.vo.InterventionChartHeaderVo create(DomainObjectMap map, ims.nursing.domain.objects.InterventionChart domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.nursing.vo.InterventionChartHeaderVo valueObject = (ims.nursing.vo.InterventionChartHeaderVo) map.getValueObject(domainObject, ims.nursing.vo.InterventionChartHeaderVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.nursing.vo.InterventionChartHeaderVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.nursing.domain.objects.InterventionChart
	 */
	 public static ims.nursing.vo.InterventionChartHeaderVo insert(ims.nursing.vo.InterventionChartHeaderVo valueObject, ims.nursing.domain.objects.InterventionChart domainObject) 
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
	 * @param domainObject ims.nursing.domain.objects.InterventionChart
	 */
	 public static ims.nursing.vo.InterventionChartHeaderVo insert(DomainObjectMap map, ims.nursing.vo.InterventionChartHeaderVo valueObject, ims.nursing.domain.objects.InterventionChart domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_InterventionChart(domainObject.getId());
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
			
		// AuthoringHCP
		valueObject.setAuthoringHCP(ims.core.vo.domain.HcpAssembler.create(map, domainObject.getAuthoringHCP()) );
		// AuthoringDateTime
		java.util.Date AuthoringDateTime = domainObject.getAuthoringDateTime();
		if ( null != AuthoringDateTime ) 
		{
			valueObject.setAuthoringDateTime(new ims.framework.utils.DateTime(AuthoringDateTime) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.nursing.domain.objects.InterventionChart extractInterventionChart(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVo valueObject) 
	{
		return 	extractInterventionChart(domainFactory, valueObject, new HashMap());
	}

	public static ims.nursing.domain.objects.InterventionChart extractInterventionChart(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.InterventionChartHeaderVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_InterventionChart();
		ims.nursing.domain.objects.InterventionChart domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.nursing.domain.objects.InterventionChart)domMap.get(valueObject);
			}
			// ims.nursing.vo.InterventionChartHeaderVo ID_InterventionChart field is unknown
			domainObject = new ims.nursing.domain.objects.InterventionChart();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_InterventionChart());
			if (domMap.get(key) != null)
			{
				return (ims.nursing.domain.objects.InterventionChart)domMap.get(key);
			}
			domainObject = (ims.nursing.domain.objects.InterventionChart) domainFactory.getDomainObject(ims.nursing.domain.objects.InterventionChart.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_InterventionChart());

		domainObject.setAuthoringHCP(ims.core.vo.domain.HcpAssembler.extractHcp(domainFactory, valueObject.getAuthoringHCP(), domMap));
		ims.framework.utils.DateTime dateTime2 = valueObject.getAuthoringDateTime();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setAuthoringDateTime(value2);

		return domainObject;
	}

}
