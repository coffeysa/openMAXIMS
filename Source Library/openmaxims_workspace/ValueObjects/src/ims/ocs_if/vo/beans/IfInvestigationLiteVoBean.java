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

package ims.ocs_if.vo.beans;

public class IfInvestigationLiteVoBean extends ims.vo.ValueObjectBean
{
	public IfInvestigationLiteVoBean()
	{
	}
	public IfInvestigationLiteVoBean(ims.ocs_if.vo.IfInvestigationLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providerinvcode = vo.getProviderInvCode();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.separateorder = vo.getSeparateOrder();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocs_if.vo.beans.IfInvIdxLiteVoBean)vo.getInvestigationIndex().getBean();
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsVoBean)vo.getPathInvDetails().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfInvestigationLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providerinvcode = vo.getProviderInvCode();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.separateorder = vo.getSeparateOrder();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocs_if.vo.beans.IfInvIdxLiteVoBean)vo.getInvestigationIndex().getBean(map);
		this.pathinvdetails = vo.getPathInvDetails() == null ? null : (ims.ocrr.vo.beans.PathInvDetailsVoBean)vo.getPathInvDetails().getBean(map);
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
	}

	public ims.ocs_if.vo.IfInvestigationLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfInvestigationLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfInvestigationLiteVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfInvestigationLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfInvestigationLiteVo();
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
	public String getProviderInvCode()
	{
		return this.providerinvcode;
	}
	public void setProviderInvCode(String value)
	{
		this.providerinvcode = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public Boolean getSeparateOrder()
	{
		return this.separateorder;
	}
	public void setSeparateOrder(Boolean value)
	{
		this.separateorder = value;
	}
	public ims.ocs_if.vo.beans.IfInvIdxLiteVoBean getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocs_if.vo.beans.IfInvIdxLiteVoBean value)
	{
		this.investigationindex = value;
	}
	public ims.ocrr.vo.beans.PathInvDetailsVoBean getPathInvDetails()
	{
		return this.pathinvdetails;
	}
	public void setPathInvDetails(ims.ocrr.vo.beans.PathInvDetailsVoBean value)
	{
		this.pathinvdetails = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}

	private Integer id;
	private int version;
	private String providerinvcode;
	private ims.vo.LookupInstanceBean activestatus;
	private Boolean separateorder;
	private ims.ocs_if.vo.beans.IfInvIdxLiteVoBean investigationindex;
	private ims.ocrr.vo.beans.PathInvDetailsVoBean pathinvdetails;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean eventtype;
}
