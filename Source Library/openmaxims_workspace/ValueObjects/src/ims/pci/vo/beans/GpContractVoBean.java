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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.pci.vo.beans;

public class GpContractVoBean extends ims.vo.ValueObjectBean
{
	public GpContractVoBean()
	{
	}
	public GpContractVoBean(ims.pci.vo.GpContractVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGP() == null ? null : (ims.core.vo.beans.GpLiteWithNameVoBean)vo.getGP().getBean();
		this.contractid = vo.getContractId();
		this.contractstartdate = vo.getContractStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getContractStartDate().getBean();
		this.contractenddate = vo.getContractEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getContractEndDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.GpContractVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGP() == null ? null : (ims.core.vo.beans.GpLiteWithNameVoBean)vo.getGP().getBean(map);
		this.contractid = vo.getContractId();
		this.contractstartdate = vo.getContractStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getContractStartDate().getBean();
		this.contractenddate = vo.getContractEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getContractEndDate().getBean();
	}

	public ims.pci.vo.GpContractVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.GpContractVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.GpContractVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.GpContractVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.GpContractVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.GpLiteWithNameVoBean getGP()
	{
		return this.gp;
	}
	public void setGP(ims.core.vo.beans.GpLiteWithNameVoBean value)
	{
		this.gp = value;
	}
	public String getContractId()
	{
		return this.contractid;
	}
	public void setContractId(String value)
	{
		this.contractid = value;
	}
	public ims.framework.utils.beans.DateBean getContractStartDate()
	{
		return this.contractstartdate;
	}
	public void setContractStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.contractstartdate = value;
	}
	public ims.framework.utils.beans.DateBean getContractEndDate()
	{
		return this.contractenddate;
	}
	public void setContractEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.contractenddate = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.GpLiteWithNameVoBean gp;
	private String contractid;
	private ims.framework.utils.beans.DateBean contractstartdate;
	private ims.framework.utils.beans.DateBean contractenddate;
}
