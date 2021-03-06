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
 * Generated on 12/10/2015, 13:25
 *
 */
package ims.ocrr.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Florin Blindu
 */
public class ClinicalResultListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.ocrr.vo.ClinicalResultListVo copy(ims.ocrr.vo.ClinicalResultListVo valueObjectDest, ims.ocrr.vo.ClinicalResultListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_OrderInvestigation(valueObjectSrc.getID_OrderInvestigation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Investigation
		valueObjectDest.setInvestigation(valueObjectSrc.getInvestigation());
		// OrderDetails
		valueObjectDest.setOrderDetails(valueObjectSrc.getOrderDetails());
		// RepDateTime
		valueObjectDest.setRepDateTime(valueObjectSrc.getRepDateTime());
		// RepTimeSupplied
		valueObjectDest.setRepTimeSupplied(valueObjectSrc.getRepTimeSupplied());
		// DisplayDateTime
		valueObjectDest.setDisplayDateTime(valueObjectSrc.getDisplayDateTime());
		// DisplayFlag
		valueObjectDest.setDisplayFlag(valueObjectSrc.getDisplayFlag());
		// ResultDemographics
		valueObjectDest.setResultDemographics(valueObjectSrc.getResultDemographics());
		// ResultStatus
		valueObjectDest.setResultStatus(valueObjectSrc.getResultStatus());
		// OrdInvCurrentStatus
		valueObjectDest.setOrdInvCurrentStatus(valueObjectSrc.getOrdInvCurrentStatus());
		// OrdInvXOStatusHistory
		valueObjectDest.setOrdInvXOStatusHistory(valueObjectSrc.getOrdInvXOStatusHistory());
		// ResultConclusionComments
		valueObjectDest.setResultConclusionComments(valueObjectSrc.getResultConclusionComments());
		// ResultDetails
		valueObjectDest.setResultDetails(valueObjectSrc.getResultDetails());
		// AllocatedHCPforReview
		valueObjectDest.setAllocatedHCPforReview(valueObjectSrc.getAllocatedHCPforReview());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createClinicalResultListVoCollectionFromOrderInvestigation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.ClinicalResultListVoCollection createClinicalResultListVoCollectionFromOrderInvestigation(java.util.Set domainObjectSet)	
	{
		return createClinicalResultListVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.ClinicalResultListVoCollection createClinicalResultListVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.ocrr.vo.ClinicalResultListVoCollection voList = new ims.ocrr.vo.ClinicalResultListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) iterator.next();
			ims.ocrr.vo.ClinicalResultListVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.ClinicalResultListVoCollection createClinicalResultListVoCollectionFromOrderInvestigation(java.util.List domainObjectList) 
	{
		return createClinicalResultListVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.ClinicalResultListVoCollection createClinicalResultListVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.ocrr.vo.ClinicalResultListVoCollection voList = new ims.ocrr.vo.ClinicalResultListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainObjectList.get(i);
			ims.ocrr.vo.ClinicalResultListVo vo = create(map, domainObject);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.ClinicalResultListVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = ClinicalResultListVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.ClinicalResultListVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = ClinicalResultListVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.ClinicalResultListVo create(ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.ocrr.vo.ClinicalResultListVo create(DomainObjectMap map, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.ocrr.vo.ClinicalResultListVo valueObject = (ims.ocrr.vo.ClinicalResultListVo) map.getValueObject(domainObject, ims.ocrr.vo.ClinicalResultListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.ocrr.vo.ClinicalResultListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.ClinicalResultListVo insert(ims.ocrr.vo.ClinicalResultListVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
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
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.ClinicalResultListVo insert(DomainObjectMap map, ims.ocrr.vo.ClinicalResultListVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_OrderInvestigation(domainObject.getId());
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
			
		// Investigation
		valueObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.create(map, domainObject.getInvestigation()) );
		// OrderDetails
		valueObject.setOrderDetails(ims.ocrr.vo.domain.OcsOrderShortVoAssembler.create(map, domainObject.getOrderDetails()) );
		// RepDateTime
		java.util.Date RepDateTime = domainObject.getRepDateTime();
		if ( null != RepDateTime ) 
		{
			valueObject.setRepDateTime(new ims.framework.utils.DateTime(RepDateTime) );
		}
		// RepTimeSupplied
		valueObject.setRepTimeSupplied( domainObject.isRepTimeSupplied() );
		// DisplayDateTime
		java.util.Date DisplayDateTime = domainObject.getDisplayDateTime();
		if ( null != DisplayDateTime ) 
		{
			valueObject.setDisplayDateTime(new ims.framework.utils.DateTime(DisplayDateTime) );
		}
		// DisplayFlag
		ims.domain.lookups.LookupInstance instance6 = domainObject.getDisplayFlag();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.OcsDisplayFlag voLookup6 = new ims.ocrr.vo.lookups.OcsDisplayFlag(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.ocrr.vo.lookups.OcsDisplayFlag parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.ocrr.vo.lookups.OcsDisplayFlag(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setDisplayFlag(voLookup6);
		}
				// ResultDemographics
		valueObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.create(map, domainObject.getResultDemographics()) );
		// ResultStatus
		ims.domain.lookups.LookupInstance instance8 = domainObject.getResultStatus();
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

			ims.ocrr.vo.lookups.ResultStatus voLookup8 = new ims.ocrr.vo.lookups.ResultStatus(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.ocrr.vo.lookups.ResultStatus parentVoLookup8 = voLookup8;
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
								parentVoLookup8.setParent(new ims.ocrr.vo.lookups.ResultStatus(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setResultStatus(voLookup8);
		}
				// OrdInvCurrentStatus
		valueObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusClinicalVoAssembler.create(map, domainObject.getOrdInvCurrentStatus()) );
		// OrdInvXOStatusHistory
		valueObject.setOrdInvXOStatusHistory(ims.ocrr.vo.domain.OrdInvXOStatusHistoryLiteVoAssembler.createOrdInvXOStatusHistoryLiteVoCollectionFromOrderedInvestigationStatus(map, domainObject.getOrdInvXOStatusHistory()) );
		// ResultConclusionComments
		valueObject.setResultConclusionComments(ims.ocrr.vo.domain.ResultCommentsLiteVoAssembler.createResultCommentsLiteVoCollectionFromResultConclusionAndActionComment(map, domainObject.getResultConclusionComments()) );
		// ResultDetails
		valueObject.setResultDetails(ims.ocrr.vo.domain.ResultDetailsForClinicalResultListVoAssembler.create(map, domainObject.getResultDetails()) );
		// AllocatedHCPforReview
		valueObject.setAllocatedHCPforReview(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getAllocatedHCPforReview()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVo valueObject) 
	{
		return 	extractOrderInvestigation(domainFactory, valueObject, new HashMap());
	}

	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.ClinicalResultListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_OrderInvestigation();
		ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(valueObject);
			}
			// ims.ocrr.vo.ClinicalResultListVo ID_OrderInvestigation field is unknown
			domainObject = new ims.ocrr.orderingresults.domain.objects.OrderInvestigation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_OrderInvestigation());
			if (domMap.get(key) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(key);
			}
			domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainFactory.getDomainObject(ims.ocrr.orderingresults.domain.objects.OrderInvestigation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_OrderInvestigation());

		domainObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.extractInvestigation(domainFactory, valueObject.getInvestigation(), domMap));
		domainObject.setOrderDetails(ims.ocrr.vo.domain.OcsOrderShortVoAssembler.extractOcsOrderSession(domainFactory, valueObject.getOrderDetails(), domMap));
		ims.framework.utils.DateTime dateTime3 = valueObject.getRepDateTime();
		java.util.Date value3 = null;
		if ( dateTime3 != null ) 
		{
			value3 = dateTime3.getJavaDate();
		}
		domainObject.setRepDateTime(value3);
		domainObject.setRepTimeSupplied(valueObject.getRepTimeSupplied());
		ims.framework.utils.DateTime dateTime5 = valueObject.getDisplayDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setDisplayDateTime(value5);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getDisplayFlag() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getDisplayFlag().getID());
		}
		domainObject.setDisplayFlag(value6);
		domainObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.extractMinDemographics(domainFactory, valueObject.getResultDemographics(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getResultStatus() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getResultStatus().getID());
		}
		domainObject.setResultStatus(value8);
		domainObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusClinicalVoAssembler.extractOrderedInvestigationStatus(domainFactory, valueObject.getOrdInvCurrentStatus(), domMap));

		// SaveAsRefVO treated as RefValueObject
		ims.ocrr.orderingresults.vo.OrderedInvestigationStatusRefVoCollection refCollection10 = new ims.ocrr.orderingresults.vo.OrderedInvestigationStatusRefVoCollection();
		if (valueObject.getOrdInvXOStatusHistory() != null)
		{
			for (int i10=0; i10<valueObject.getOrdInvXOStatusHistory().size(); i10++)
			{
				ims.ocrr.orderingresults.vo.OrderedInvestigationStatusRefVo ref10 = (ims.ocrr.orderingresults.vo.OrderedInvestigationStatusRefVo)valueObject.getOrdInvXOStatusHistory().get(i10);
				refCollection10.add(ref10);
			}
		}
		int size10 = (null == refCollection10) ? 0 : refCollection10.size();		
		java.util.List domainOrdInvXOStatusHistory10 = domainObject.getOrdInvXOStatusHistory();
		if (domainOrdInvXOStatusHistory10 == null)
		{
			domainOrdInvXOStatusHistory10 = new java.util.ArrayList();
		}
		for(int i=0; i < size10; i++) 
		{
			ims.ocrr.orderingresults.vo.OrderedInvestigationStatusRefVo vo = refCollection10.get(i);			
			ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus)domainFactory.getDomainObject( ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus.class, vo.getBoId());
				}
			}

			int domIdx = domainOrdInvXOStatusHistory10.indexOf(dom);
			if (domIdx == -1)
			{
				domainOrdInvXOStatusHistory10.add(i, dom);
			}
			else if (i != domIdx && i < domainOrdInvXOStatusHistory10.size())
			{
				Object tmp = domainOrdInvXOStatusHistory10.get(i);
				domainOrdInvXOStatusHistory10.set(i, domainOrdInvXOStatusHistory10.get(domIdx));
				domainOrdInvXOStatusHistory10.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i10 = domainOrdInvXOStatusHistory10.size();
		while (i10 > size10)
		{
			domainOrdInvXOStatusHistory10.remove(i10-1);
			i10 = domainOrdInvXOStatusHistory10.size();
		}
		
		domainObject.setOrdInvXOStatusHistory(domainOrdInvXOStatusHistory10);		

		// SaveAsRefVO treated as RefValueObject
		ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVoCollection refCollection11 = new ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVoCollection();
		if (valueObject.getResultConclusionComments() != null)
		{
			for (int i11=0; i11<valueObject.getResultConclusionComments().size(); i11++)
			{
				ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVo ref11 = (ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVo)valueObject.getResultConclusionComments().get(i11);
				refCollection11.add(ref11);
			}
		}
		int size11 = (null == refCollection11) ? 0 : refCollection11.size();		
		java.util.List domainResultConclusionComments11 = domainObject.getResultConclusionComments();
		if (domainResultConclusionComments11 == null)
		{
			domainResultConclusionComments11 = new java.util.ArrayList();
		}
		for(int i=0; i < size11; i++) 
		{
			ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVo vo = refCollection11.get(i);			
			ims.ocrr.orderingresults.domain.objects.ResultConclusionAndActionComment dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.ocrr.orderingresults.domain.objects.ResultConclusionAndActionComment)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.ocrr.orderingresults.domain.objects.ResultConclusionAndActionComment)domainFactory.getDomainObject( ims.ocrr.orderingresults.domain.objects.ResultConclusionAndActionComment.class, vo.getBoId());
				}
			}

			int domIdx = domainResultConclusionComments11.indexOf(dom);
			if (domIdx == -1)
			{
				domainResultConclusionComments11.add(i, dom);
			}
			else if (i != domIdx && i < domainResultConclusionComments11.size())
			{
				Object tmp = domainResultConclusionComments11.get(i);
				domainResultConclusionComments11.set(i, domainResultConclusionComments11.get(domIdx));
				domainResultConclusionComments11.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i11 = domainResultConclusionComments11.size();
		while (i11 > size11)
		{
			domainResultConclusionComments11.remove(i11-1);
			i11 = domainResultConclusionComments11.size();
		}
		
		domainObject.setResultConclusionComments(domainResultConclusionComments11);		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.ocrr.orderingresults.domain.objects.ResultDetails value12 = null;
		if ( null != valueObject.getResultDetails() ) 
		{
			if (valueObject.getResultDetails().getBoId() == null)
			{
				if (domMap.get(valueObject.getResultDetails()) != null)
				{
					value12 = (ims.ocrr.orderingresults.domain.objects.ResultDetails)domMap.get(valueObject.getResultDetails());
				}
			}
			else
			{
				value12 = (ims.ocrr.orderingresults.domain.objects.ResultDetails)domainFactory.getDomainObject(ims.ocrr.orderingresults.domain.objects.ResultDetails.class, valueObject.getResultDetails().getBoId());
			}
		}
		domainObject.setResultDetails(value12);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value13 = null;
		if ( null != valueObject.getAllocatedHCPforReview() ) 
		{
			if (valueObject.getAllocatedHCPforReview().getBoId() == null)
			{
				if (domMap.get(valueObject.getAllocatedHCPforReview()) != null)
				{
					value13 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getAllocatedHCPforReview());
				}
			}
			else
			{
				value13 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getAllocatedHCPforReview().getBoId());
			}
		}
		domainObject.setAllocatedHCPforReview(value13);

		return domainObject;
	}

}
