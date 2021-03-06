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

public class ClientPCIScheduleProfileVoBean extends ims.vo.ValueObjectBean
{
	public ClientPCIScheduleProfileVoBean()
	{
	}
	public ClientPCIScheduleProfileVoBean(ims.pci.vo.ClientPCIScheduleProfileVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.schedule = vo.getSchedule() == null ? null : (ims.pci.vo.beans.ScheduleConfigurationVoBean)vo.getSchedule().getBean();
		this.selectedby = vo.getSelectedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getSelectedBy().getBean();
		this.datecreated = vo.getDateCreated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateCreated().getBean();
		this.isdeleted = vo.getIsDeleted();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.ClientPCIScheduleProfileVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.schedule = vo.getSchedule() == null ? null : (ims.pci.vo.beans.ScheduleConfigurationVoBean)vo.getSchedule().getBean(map);
		this.selectedby = vo.getSelectedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getSelectedBy().getBean(map);
		this.datecreated = vo.getDateCreated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateCreated().getBean();
		this.isdeleted = vo.getIsDeleted();
	}

	public ims.pci.vo.ClientPCIScheduleProfileVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.ClientPCIScheduleProfileVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.ClientPCIScheduleProfileVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.ClientPCIScheduleProfileVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.ClientPCIScheduleProfileVo();
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
	public ims.pci.vo.beans.ScheduleConfigurationVoBean getSchedule()
	{
		return this.schedule;
	}
	public void setSchedule(ims.pci.vo.beans.ScheduleConfigurationVoBean value)
	{
		this.schedule = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getSelectedBy()
	{
		return this.selectedby;
	}
	public void setSelectedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.selectedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateCreated()
	{
		return this.datecreated;
	}
	public void setDateCreated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datecreated = value;
	}
	public Boolean getIsDeleted()
	{
		return this.isdeleted;
	}
	public void setIsDeleted(Boolean value)
	{
		this.isdeleted = value;
	}

	private Integer id;
	private int version;
	private ims.pci.vo.beans.ScheduleConfigurationVoBean schedule;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean selectedby;
	private ims.framework.utils.beans.DateTimeBean datecreated;
	private Boolean isdeleted;
}
