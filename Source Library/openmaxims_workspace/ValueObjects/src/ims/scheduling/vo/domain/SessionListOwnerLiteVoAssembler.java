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
package ims.scheduling.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class SessionListOwnerLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.scheduling.vo.SessionListOwnerLiteVo copy(ims.scheduling.vo.SessionListOwnerLiteVo valueObjectDest, ims.scheduling.vo.SessionListOwnerLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Session_ListOwner(valueObjectSrc.getID_Session_ListOwner());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Hcp
		valueObjectDest.setHcp(valueObjectSrc.getHcp());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSessionListOwnerLiteVoCollectionFromSession_ListOwner(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.scheduling.domain.objects.Session_ListOwner objects.
	 */
	public static ims.scheduling.vo.SessionListOwnerLiteVoCollection createSessionListOwnerLiteVoCollectionFromSession_ListOwner(java.util.Set domainObjectSet)	
	{
		return createSessionListOwnerLiteVoCollectionFromSession_ListOwner(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.scheduling.domain.objects.Session_ListOwner objects.
	 */
	public static ims.scheduling.vo.SessionListOwnerLiteVoCollection createSessionListOwnerLiteVoCollectionFromSession_ListOwner(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.scheduling.vo.SessionListOwnerLiteVoCollection voList = new ims.scheduling.vo.SessionListOwnerLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.scheduling.domain.objects.Session_ListOwner domainObject = (ims.scheduling.domain.objects.Session_ListOwner) iterator.next();
			ims.scheduling.vo.SessionListOwnerLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.scheduling.domain.objects.Session_ListOwner objects.
	 */
	public static ims.scheduling.vo.SessionListOwnerLiteVoCollection createSessionListOwnerLiteVoCollectionFromSession_ListOwner(java.util.List domainObjectList) 
	{
		return createSessionListOwnerLiteVoCollectionFromSession_ListOwner(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.scheduling.domain.objects.Session_ListOwner objects.
	 */
	public static ims.scheduling.vo.SessionListOwnerLiteVoCollection createSessionListOwnerLiteVoCollectionFromSession_ListOwner(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.scheduling.vo.SessionListOwnerLiteVoCollection voList = new ims.scheduling.vo.SessionListOwnerLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.scheduling.domain.objects.Session_ListOwner domainObject = (ims.scheduling.domain.objects.Session_ListOwner) domainObjectList.get(i);
			ims.scheduling.vo.SessionListOwnerLiteVo vo = create(map, domainObject);

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
	 * Create the ims.scheduling.domain.objects.Session_ListOwner set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSession_ListOwnerSet(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVoCollection voCollection) 
	 {
	 	return extractSession_ListOwnerSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSession_ListOwnerSet(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.scheduling.vo.SessionListOwnerLiteVo vo = voCollection.get(i);
			ims.scheduling.domain.objects.Session_ListOwner domainObject = SessionListOwnerLiteVoAssembler.extractSession_ListOwner(domainFactory, vo, domMap);

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
	 * Create the ims.scheduling.domain.objects.Session_ListOwner list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSession_ListOwnerList(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVoCollection voCollection) 
	 {
	 	return extractSession_ListOwnerList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSession_ListOwnerList(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.scheduling.vo.SessionListOwnerLiteVo vo = voCollection.get(i);
			ims.scheduling.domain.objects.Session_ListOwner domainObject = SessionListOwnerLiteVoAssembler.extractSession_ListOwner(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.scheduling.domain.objects.Session_ListOwner object.
	 * @param domainObject ims.scheduling.domain.objects.Session_ListOwner
	 */
	 public static ims.scheduling.vo.SessionListOwnerLiteVo create(ims.scheduling.domain.objects.Session_ListOwner domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.scheduling.domain.objects.Session_ListOwner object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.scheduling.vo.SessionListOwnerLiteVo create(DomainObjectMap map, ims.scheduling.domain.objects.Session_ListOwner domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.scheduling.vo.SessionListOwnerLiteVo valueObject = (ims.scheduling.vo.SessionListOwnerLiteVo) map.getValueObject(domainObject, ims.scheduling.vo.SessionListOwnerLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.scheduling.vo.SessionListOwnerLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.scheduling.domain.objects.Session_ListOwner
	 */
	 public static ims.scheduling.vo.SessionListOwnerLiteVo insert(ims.scheduling.vo.SessionListOwnerLiteVo valueObject, ims.scheduling.domain.objects.Session_ListOwner domainObject) 
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
	 * @param domainObject ims.scheduling.domain.objects.Session_ListOwner
	 */
	 public static ims.scheduling.vo.SessionListOwnerLiteVo insert(DomainObjectMap map, ims.scheduling.vo.SessionListOwnerLiteVo valueObject, ims.scheduling.domain.objects.Session_ListOwner domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Session_ListOwner(domainObject.getId());
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
			
		// Hcp
		valueObject.setHcp(ims.core.vo.domain.HcpMinVoAssembler.create(map, domainObject.getHcp()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.scheduling.domain.objects.Session_ListOwner extractSession_ListOwner(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVo valueObject) 
	{
		return 	extractSession_ListOwner(domainFactory, valueObject, new HashMap());
	}

	public static ims.scheduling.domain.objects.Session_ListOwner extractSession_ListOwner(ims.domain.ILightweightDomainFactory domainFactory, ims.scheduling.vo.SessionListOwnerLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Session_ListOwner();
		ims.scheduling.domain.objects.Session_ListOwner domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.scheduling.domain.objects.Session_ListOwner)domMap.get(valueObject);
			}
			// ims.scheduling.vo.SessionListOwnerLiteVo ID_Session_ListOwner field is unknown
			domainObject = new ims.scheduling.domain.objects.Session_ListOwner();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Session_ListOwner());
			if (domMap.get(key) != null)
			{
				return (ims.scheduling.domain.objects.Session_ListOwner)domMap.get(key);
			}
			domainObject = (ims.scheduling.domain.objects.Session_ListOwner) domainFactory.getDomainObject(ims.scheduling.domain.objects.Session_ListOwner.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Session_ListOwner());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value1 = null;
		if ( null != valueObject.getHcp() ) 
		{
			if (valueObject.getHcp().getBoId() == null)
			{
				if (domMap.get(valueObject.getHcp()) != null)
				{
					value1 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getHcp());
				}
			}
			else
			{
				value1 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getHcp().getBoId());
			}
		}
		domainObject.setHcp(value1);

		return domainObject;
	}

}
