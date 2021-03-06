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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseHCGCcImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.domain.objects.HCGTestItem;
import ims.emergency.domain.objects.HCGTests;
import ims.emergency.vo.HCGTestItemRefVo;
import ims.emergency.vo.HCGTestItemVo;
import ims.emergency.vo.HCGTestsRefVo;
import ims.emergency.vo.HCGTestsVo;
import ims.emergency.vo.domain.HCGTestItemVoAssembler;
import ims.emergency.vo.domain.HCGTestsVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class HCGCcImpl extends BaseHCGCcImpl
{

	private static final long serialVersionUID = 1L;

	public HCGTestsVo getHCGbyCareContext(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get HCG on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("from HCGTests as hcg where hcg.careContext.id = :careContextID ");

		List<?> list = factory.find(hql.toString(), new String[] { "careContextID" }, new Object[] { careContextRef.getID_CareContext() });

		if (list == null || list.size() == 0)
			return null;

		return HCGTestsVoAssembler.create((HCGTests) list.get(0));
	}

	public HCGTestItemVo saveItem(HCGTestItemVo hcgItemToSave) throws StaleObjectException
	{
		if (hcgItemToSave == null)
			throw new CodingRuntimeException("Cannot save null HCGItem ");

		if (!hcgItemToSave.isValidated())
			throw new DomainRuntimeException("HCGItem Not Validated.");

		DomainFactory factory = getDomainFactory();
		HCGTestItem domainHCGItem = HCGTestItemVoAssembler.extractHCGTestItem(factory, hcgItemToSave);

		factory.save(domainHCGItem);

		return HCGTestItemVoAssembler.create(domainHCGItem);
	}

	public HCGTestsVo save(HCGTestsVo hcgToSave) throws StaleObjectException, UniqueKeyViolationException
	{
		if (hcgToSave == null)
			throw new CodingRuntimeException("Cannot save null HCGTest ");

		if (!hcgToSave.isValidated())
			throw new DomainRuntimeException("HCGTest Not Validated.");

		DomainFactory factory = getDomainFactory();
		HCGTests domainHCG = HCGTestsVoAssembler.extractHCGTests(factory, hcgToSave);

		factory.save(domainHCG);

		return HCGTestsVoAssembler.create(domainHCG);
	}

	public HCGTestItemVo getHCGItem(HCGTestItemRefVo hcgItemRef)
	{
		if (hcgItemRef == null || hcgItemRef.getID_HCGTestItem() == null)
		{
			throw new CodingRuntimeException("Cannot get HCGItem on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		HCGTestItem domainHCGItem = (HCGTestItem) factory.getDomainObject(HCGTestItem.class, hcgItemRef.getID_HCGTestItem());

		return HCGTestItemVoAssembler.create(domainHCGItem);
	}

	public Boolean isStale(HCGTestItemRefVo hcgItemRef)
	{
		if(hcgItemRef == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		List<?> appts = factory.find("select hcgItem.id from HCGTestItem as hcgItem where hcgItem.id = :hcgItemId and hcgItem.version > :hcgItemVersion", new String[] {"hcgItemId", "hcgItemVersion"}, new Object[] {hcgItemRef.getID_HCGTestItem(), hcgItemRef.getVersion_HCGTestItem()});
		
		if(appts != null && appts.size() > 0)
			return true;
		
		return false;
	}

	public HCGTestsVo getHCG(HCGTestsRefVo hcgRef)
	{
		if (hcgRef == null || hcgRef.getID_HCGTests() == null)
		{
			throw new CodingRuntimeException("Cannot get HCGTest on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		HCGTests domainHCGTest = (HCGTests) factory.getDomainObject(HCGTests.class, hcgRef.getID_HCGTests());

		return HCGTestsVoAssembler.create(domainHCGTest);
	}

}
