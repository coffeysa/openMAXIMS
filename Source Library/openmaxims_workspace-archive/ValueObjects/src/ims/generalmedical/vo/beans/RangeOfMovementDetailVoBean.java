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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.generalmedical.vo.beans;

public class RangeOfMovementDetailVoBean extends ims.vo.ValueObjectBean
{
	public RangeOfMovementDetailVoBean()
	{
	}
	public RangeOfMovementDetailVoBean(ims.generalmedical.vo.RangeOfMovementDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.joint = vo.getJoint() == null ? null : (ims.core.vo.beans.MskJointVoBean)vo.getJoint().getBean();
		this.selectedmovements = vo.getSelectedMovements() == null ? null : vo.getSelectedMovements().getBeanCollection();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.group = vo.getGroup() == null ? null : (ims.core.vo.beans.MskGroupLiteVoBean)vo.getGroup().getBean();
		this.isjoint = vo.getIsJoint();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.RangeOfMovementDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.joint = vo.getJoint() == null ? null : (ims.core.vo.beans.MskJointVoBean)vo.getJoint().getBean(map);
		this.selectedmovements = vo.getSelectedMovements() == null ? null : vo.getSelectedMovements().getBeanCollection();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.group = vo.getGroup() == null ? null : (ims.core.vo.beans.MskGroupLiteVoBean)vo.getGroup().getBean(map);
		this.isjoint = vo.getIsJoint();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.generalmedical.vo.RangeOfMovementDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.RangeOfMovementDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.RangeOfMovementDetailVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.RangeOfMovementDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.RangeOfMovementDetailVo();
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
	public ims.core.vo.beans.MskJointVoBean getJoint()
	{
		return this.joint;
	}
	public void setJoint(ims.core.vo.beans.MskJointVoBean value)
	{
		this.joint = value;
	}
	public ims.core.vo.beans.MskJointMovementVoBean[] getSelectedMovements()
	{
		return this.selectedmovements;
	}
	public void setSelectedMovements(ims.core.vo.beans.MskJointMovementVoBean[] value)
	{
		this.selectedmovements = value;
	}
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public ims.core.vo.beans.MskGroupLiteVoBean getGroup()
	{
		return this.group;
	}
	public void setGroup(ims.core.vo.beans.MskGroupLiteVoBean value)
	{
		this.group = value;
	}
	public Boolean getIsJoint()
	{
		return this.isjoint;
	}
	public void setIsJoint(Boolean value)
	{
		this.isjoint = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.MskJointVoBean joint;
	private ims.core.vo.beans.MskJointMovementVoBean[] selectedmovements;
	private ims.vo.LookupInstanceBean laterality;
	private ims.core.vo.beans.MskGroupLiteVoBean group;
	private Boolean isjoint;
	private ims.vo.SysInfoBean sysinfo;
}