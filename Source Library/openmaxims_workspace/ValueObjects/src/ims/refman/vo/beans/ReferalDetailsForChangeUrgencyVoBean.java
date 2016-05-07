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

package ims.RefMan.vo.beans;

public class ReferalDetailsForChangeUrgencyVoBean extends ims.vo.ValueObjectBean
{
	public ReferalDetailsForChangeUrgencyVoBean()
	{
	}
	public ReferalDetailsForChangeUrgencyVoBean(ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referrertype = vo.getReferrerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferrerType().getBean();
		this.end18ww = vo.getEnd18WW() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEnd18WW().getBean();
		this.datereferralreceived = vo.getDateReferralReceived() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateReferralReceived().getBean();
	}

	public ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo();
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
	public ims.vo.LookupInstanceBean getReferrerType()
	{
		return this.referrertype;
	}
	public void setReferrerType(ims.vo.LookupInstanceBean value)
	{
		this.referrertype = value;
	}
	public ims.framework.utils.beans.DateBean getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.beans.DateBean value)
	{
		this.end18ww = value;
	}
	public ims.framework.utils.beans.DateBean getDateReferralReceived()
	{
		return this.datereferralreceived;
	}
	public void setDateReferralReceived(ims.framework.utils.beans.DateBean value)
	{
		this.datereferralreceived = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean referrertype;
	private ims.framework.utils.beans.DateBean end18ww;
	private ims.framework.utils.beans.DateBean datereferralreceived;
}