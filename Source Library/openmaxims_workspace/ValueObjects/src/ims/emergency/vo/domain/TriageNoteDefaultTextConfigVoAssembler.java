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
 * @author Bogdan Tofei
 */
public class TriageNoteDefaultTextConfigVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.TriageNoteDefaultTextConfigVo copy(ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObjectDest, ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TriageNoteDefaultTextConfig(valueObjectSrc.getID_TriageNoteDefaultTextConfig());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Problem
		valueObjectDest.setProblem(valueObjectSrc.getProblem());
		// DefaultTriageNote
		valueObjectDest.setDefaultTriageNote(valueObjectSrc.getDefaultTriageNote());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig objects.
	 */
	public static ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(java.util.Set domainObjectSet)	
	{
		return createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig objects.
	 */
	public static ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voList = new ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject = (ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig) iterator.next();
			ims.emergency.vo.TriageNoteDefaultTextConfigVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig objects.
	 */
	public static ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(java.util.List domainObjectList) 
	{
		return createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig objects.
	 */
	public static ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection createTriageNoteDefaultTextConfigVoCollectionFromTriageNoteDefaultTextConfig(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voList = new ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject = (ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig) domainObjectList.get(i);
			ims.emergency.vo.TriageNoteDefaultTextConfigVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTriageNoteDefaultTextConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voCollection) 
	 {
	 	return extractTriageNoteDefaultTextConfigSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTriageNoteDefaultTextConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageNoteDefaultTextConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject = TriageNoteDefaultTextConfigVoAssembler.extractTriageNoteDefaultTextConfig(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTriageNoteDefaultTextConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voCollection) 
	 {
	 	return extractTriageNoteDefaultTextConfigList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTriageNoteDefaultTextConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TriageNoteDefaultTextConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject = TriageNoteDefaultTextConfigVoAssembler.extractTriageNoteDefaultTextConfig(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig object.
	 * @param domainObject ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig
	 */
	 public static ims.emergency.vo.TriageNoteDefaultTextConfigVo create(ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.TriageNoteDefaultTextConfigVo create(DomainObjectMap map, ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObject = (ims.emergency.vo.TriageNoteDefaultTextConfigVo) map.getValueObject(domainObject, ims.emergency.vo.TriageNoteDefaultTextConfigVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.TriageNoteDefaultTextConfigVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig
	 */
	 public static ims.emergency.vo.TriageNoteDefaultTextConfigVo insert(ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObject, ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject) 
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
	 * @param domainObject ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig
	 */
	 public static ims.emergency.vo.TriageNoteDefaultTextConfigVo insert(DomainObjectMap map, ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObject, ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TriageNoteDefaultTextConfig(domainObject.getId());
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
			
		// Problem
		valueObject.setProblem(ims.clinical.vo.domain.ClinicalProblemVoAssembler.create(map, domainObject.getProblem()) );
		// DefaultTriageNote
		valueObject.setDefaultTriageNote(domainObject.getDefaultTriageNote());
		// Status
		ims.domain.lookups.LookupInstance instance3 = domainObject.getStatus();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup3 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setStatus(voLookup3);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig extractTriageNoteDefaultTextConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObject) 
	{
		return 	extractTriageNoteDefaultTextConfig(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig extractTriageNoteDefaultTextConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TriageNoteDefaultTextConfigVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TriageNoteDefaultTextConfig();
		ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig)domMap.get(valueObject);
			}
			// ims.emergency.vo.TriageNoteDefaultTextConfigVo ID_TriageNoteDefaultTextConfig field is unknown
			domainObject = new ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TriageNoteDefaultTextConfig());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig)domMap.get(key);
			}
			domainObject = (ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig) domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.TriageNoteDefaultTextConfig.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TriageNoteDefaultTextConfig());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.clinical.configuration.domain.objects.ClinicalProblem value1 = null;
		if ( null != valueObject.getProblem() ) 
		{
			if (valueObject.getProblem().getBoId() == null)
			{
				if (domMap.get(valueObject.getProblem()) != null)
				{
					value1 = (ims.clinical.configuration.domain.objects.ClinicalProblem)domMap.get(valueObject.getProblem());
				}
			}
			else
			{
				value1 = (ims.clinical.configuration.domain.objects.ClinicalProblem)domainFactory.getDomainObject(ims.clinical.configuration.domain.objects.ClinicalProblem.class, valueObject.getProblem().getBoId());
			}
		}
		domainObject.setProblem(value1);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDefaultTriageNote() != null && valueObject.getDefaultTriageNote().equals(""))
		{
			valueObject.setDefaultTriageNote(null);
		}
		domainObject.setDefaultTriageNote(valueObject.getDefaultTriageNote());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value3);

		return domainObject;
	}

}
