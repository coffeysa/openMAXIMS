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
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cornel Ventuneac
 */
public class TriagePriorityKpConfigVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.TriagePriorityKpConfigVo copy(ims.emergency.vo.TriagePriorityKpConfigVo valueObjectDest, ims.emergency.vo.TriagePriorityKpConfigVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TriagePriorityKPConfig(valueObjectSrc.getID_TriagePriorityKPConfig());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// TriagePriority
		valueObjectDest.setTriagePriority(valueObjectSrc.getTriagePriority());
		// PriorityBreachWarningKPI
		valueObjectDest.setPriorityBreachWarningKPI(valueObjectSrc.getPriorityBreachWarningKPI());
		// PriorityBreachedKPI
		valueObjectDest.setPriorityBreachedKPI(valueObjectSrc.getPriorityBreachedKPI());
		// PriorityBreachWarningKPITextColour
		valueObjectDest.setPriorityBreachWarningKPITextColour(valueObjectSrc.getPriorityBreachWarningKPITextColour());
		// PriorityBreachWarningKPIFlashingText
		valueObjectDest.setPriorityBreachWarningKPIFlashingText(valueObjectSrc.getPriorityBreachWarningKPIFlashingText());
		// PriorityBreachWarningKPIFlashingTextColour
		valueObjectDest.setPriorityBreachWarningKPIFlashingTextColour(valueObjectSrc.getPriorityBreachWarningKPIFlashingTextColour());
		// PriorityBreachWarningKPIBackgroundColour
		valueObjectDest.setPriorityBreachWarningKPIBackgroundColour(valueObjectSrc.getPriorityBreachWarningKPIBackgroundColour());
		// PriorityBreachedKPIFlashingText
		valueObjectDest.setPriorityBreachedKPIFlashingText(valueObjectSrc.getPriorityBreachedKPIFlashingText());
		// PriorityBreachedKPIFlashingTextColour
		valueObjectDest.setPriorityBreachedKPIFlashingTextColour(valueObjectSrc.getPriorityBreachedKPIFlashingTextColour());
		// PriorityBreachedKPIBackgroundColour
		valueObjectDest.setPriorityBreachedKPIBackgroundColour(valueObjectSrc.getPriorityBreachedKPIBackgroundColour());
		// PriorityBreachKPITextColour
		valueObjectDest.setPriorityBreachKPITextColour(valueObjectSrc.getPriorityBreachKPITextColour());
		// DefaultRowColour
		valueObjectDest.setDefaultRowColour(valueObjectSrc.getDefaultRowColour());
		// DefaultFontColour
		valueObjectDest.setDefaultFontColour(valueObjectSrc.getDefaultFontColour());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TriagePriorityKPConfig objects.
	 */
	public static ims.emergency.vo.TriagePriorityKpConfigVoCollection createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(java.util.Set domainObjectSet)	
	{
		return createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TriagePriorityKPConfig objects.
	 */
	public static ims.emergency.vo.TriagePriorityKpConfigVoCollection createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.TriagePriorityKpConfigVoCollection voList = new ims.emergency.vo.TriagePriorityKpConfigVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject = (ims.emergency.configuration.domain.objects.TriagePriorityKPConfig) iterator.next();
			ims.emergency.vo.TriagePriorityKpConfigVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TriagePriorityKPConfig objects.
	 */
	public static ims.emergency.vo.TriagePriorityKpConfigVoCollection createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(java.util.List domainObjectList) 
	{
		return createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TriagePriorityKPConfig objects.
	 */
	public static ims.emergency.vo.TriagePriorityKpConfigVoCollection createTriagePriorityKpConfigVoCollectionFromTriagePriorityKPConfig(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.TriagePriorityKpConfigVoCollection voList = new ims.emergency.vo.TriagePriorityKpConfigVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject = (ims.emergency.configuration.domain.objects.TriagePriorityKPConfig) domainObjectList.get(i);
			ims.emergency.vo.TriagePriorityKpConfigVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.configuration.domain.objects.TriagePriorityKPConfig set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTriagePriorityKPConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVoCollection voCollection) 
	 {
	 	return extractTriagePriorityKPConfigSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTriagePriorityKPConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriagePriorityKpConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject = TriagePriorityKpConfigVoAssembler.extractTriagePriorityKPConfig(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.configuration.domain.objects.TriagePriorityKPConfig list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTriagePriorityKPConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVoCollection voCollection) 
	 {
	 	return extractTriagePriorityKPConfigList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTriagePriorityKPConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriagePriorityKpConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject = TriagePriorityKpConfigVoAssembler.extractTriagePriorityKPConfig(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.configuration.domain.objects.TriagePriorityKPConfig object.
	 * @param domainObject ims.emergency.configuration.domain.objects.TriagePriorityKPConfig
	 */
	 public static ims.emergency.vo.TriagePriorityKpConfigVo create(ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.configuration.domain.objects.TriagePriorityKPConfig object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.TriagePriorityKpConfigVo create(DomainObjectMap map, ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.TriagePriorityKpConfigVo valueObject = (ims.emergency.vo.TriagePriorityKpConfigVo) map.getValueObject(domainObject, ims.emergency.vo.TriagePriorityKpConfigVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.TriagePriorityKpConfigVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.configuration.domain.objects.TriagePriorityKPConfig
	 */
	 public static ims.emergency.vo.TriagePriorityKpConfigVo insert(ims.emergency.vo.TriagePriorityKpConfigVo valueObject, ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject) 
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
	 * @param domainObject ims.emergency.configuration.domain.objects.TriagePriorityKPConfig
	 */
	 public static ims.emergency.vo.TriagePriorityKpConfigVo insert(DomainObjectMap map, ims.emergency.vo.TriagePriorityKpConfigVo valueObject, ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TriagePriorityKPConfig(domainObject.getId());
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
			
		// TriagePriority
		ims.domain.lookups.LookupInstance instance1 = domainObject.getTriagePriority();
		if ( null != instance1 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance1.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance1.getImage().getImageId(), instance1.getImage().getImagePath());
			}
			color = instance1.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.TriagePriority voLookup1 = new ims.emergency.vo.lookups.TriagePriority(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.emergency.vo.lookups.TriagePriority parentVoLookup1 = voLookup1;
			ims.domain.lookups.LookupInstance parent1 = instance1.getParent();
			while (parent1 != null)
			{
				if (parent1.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent1.getImage().getImageId(), parent1.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent1.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup1.setParent(new ims.emergency.vo.lookups.TriagePriority(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setTriagePriority(voLookup1);
		}
				// PriorityBreachWarningKPI
		valueObject.setPriorityBreachWarningKPI(domainObject.getPriorityBreachWarningKPI());
		// PriorityBreachedKPI
		valueObject.setPriorityBreachedKPI(domainObject.getPriorityBreachedKPI());
		// PriorityBreachWarningKPITextColour
		valueObject.setPriorityBreachWarningKPITextColour(domainObject.getPriorityBreachWarningKPITextColour());
		// PriorityBreachWarningKPIFlashingText
		ims.domain.lookups.LookupInstance instance5 = domainObject.getPriorityBreachWarningKPIFlashingText();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.YesNo voLookup5 = new ims.core.vo.lookups.YesNo(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.core.vo.lookups.YesNo parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.core.vo.lookups.YesNo(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setPriorityBreachWarningKPIFlashingText(voLookup5);
		}
				// PriorityBreachWarningKPIFlashingTextColour
		valueObject.setPriorityBreachWarningKPIFlashingTextColour(domainObject.getPriorityBreachWarningKPIFlashingTextColour());
		// PriorityBreachWarningKPIBackgroundColour
		valueObject.setPriorityBreachWarningKPIBackgroundColour(domainObject.getPriorityBreachWarningKPIBackgroundColour());
		// PriorityBreachedKPIFlashingText
		ims.domain.lookups.LookupInstance instance8 = domainObject.getPriorityBreachedKPIFlashingText();
		if ( null != instance8 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance8.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance8.getImage().getImageId(), instance8.getImage().getImagePath());
			}
			color = instance8.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.YesNo voLookup8 = new ims.core.vo.lookups.YesNo(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.YesNo parentVoLookup8 = voLookup8;
			ims.domain.lookups.LookupInstance parent8 = instance8.getParent();
			while (parent8 != null)
			{
				if (parent8.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent8.getImage().getImageId(), parent8.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent8.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup8.setParent(new ims.core.vo.lookups.YesNo(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setPriorityBreachedKPIFlashingText(voLookup8);
		}
				// PriorityBreachedKPIFlashingTextColour
		valueObject.setPriorityBreachedKPIFlashingTextColour(domainObject.getPriorityBreachedKPIFlashingTextColour());
		// PriorityBreachedKPIBackgroundColour
		valueObject.setPriorityBreachedKPIBackgroundColour(domainObject.getPriorityBreachedKPIBackgroundColour());
		// PriorityBreachKPITextColour
		valueObject.setPriorityBreachKPITextColour(domainObject.getPriorityBreachKPITextColour());
		// DefaultRowColour
		valueObject.setDefaultRowColour(domainObject.getDefaultRowColour());
		// DefaultFontColour
		valueObject.setDefaultFontColour(domainObject.getDefaultFontColour());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.configuration.domain.objects.TriagePriorityKPConfig extractTriagePriorityKPConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVo valueObject) 
	{
		return 	extractTriagePriorityKPConfig(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.configuration.domain.objects.TriagePriorityKPConfig extractTriagePriorityKPConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriagePriorityKpConfigVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TriagePriorityKPConfig();
		ims.emergency.configuration.domain.objects.TriagePriorityKPConfig domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.configuration.domain.objects.TriagePriorityKPConfig)domMap.get(valueObject);
			}
			// ims.emergency.vo.TriagePriorityKpConfigVo ID_TriagePriorityKPConfig field is unknown
			domainObject = new ims.emergency.configuration.domain.objects.TriagePriorityKPConfig();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TriagePriorityKPConfig());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.configuration.domain.objects.TriagePriorityKPConfig)domMap.get(key);
			}
			domainObject = (ims.emergency.configuration.domain.objects.TriagePriorityKPConfig) domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.TriagePriorityKPConfig.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TriagePriorityKPConfig());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getTriagePriority() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getTriagePriority().getID());
		}
		domainObject.setTriagePriority(value1);
		domainObject.setPriorityBreachWarningKPI(valueObject.getPriorityBreachWarningKPI());
		domainObject.setPriorityBreachedKPI(valueObject.getPriorityBreachedKPI());
		domainObject.setPriorityBreachWarningKPITextColour(valueObject.getPriorityBreachWarningKPITextColour());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getPriorityBreachWarningKPIFlashingText() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getPriorityBreachWarningKPIFlashingText().getID());
		}
		domainObject.setPriorityBreachWarningKPIFlashingText(value5);
		domainObject.setPriorityBreachWarningKPIFlashingTextColour(valueObject.getPriorityBreachWarningKPIFlashingTextColour());
		domainObject.setPriorityBreachWarningKPIBackgroundColour(valueObject.getPriorityBreachWarningKPIBackgroundColour());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getPriorityBreachedKPIFlashingText() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getPriorityBreachedKPIFlashingText().getID());
		}
		domainObject.setPriorityBreachedKPIFlashingText(value8);
		domainObject.setPriorityBreachedKPIFlashingTextColour(valueObject.getPriorityBreachedKPIFlashingTextColour());
		domainObject.setPriorityBreachedKPIBackgroundColour(valueObject.getPriorityBreachedKPIBackgroundColour());
		domainObject.setPriorityBreachKPITextColour(valueObject.getPriorityBreachKPITextColour());
		domainObject.setDefaultRowColour(valueObject.getDefaultRowColour());
		domainObject.setDefaultFontColour(valueObject.getDefaultFontColour());

		return domainObject;
	}

}
