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

package ims.emergency.vo.beans;

public class TrackingSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public TrackingSearchCriteriaVoBean()
	{
	}
	public TrackingSearchCriteriaVoBean(ims.emergency.vo.TrackingSearchCriteriaVo vo)
	{
		this.viewalled = vo.getViewAllED();
		this.trackingarea = vo.getTrackingArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaForTrackingVoBean)vo.getTrackingArea().getBean();
		this.viewtype = vo.getViewType();
		this.displaytype = vo.getDisplayType();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingSearchCriteriaVo vo)
	{
		this.viewalled = vo.getViewAllED();
		this.trackingarea = vo.getTrackingArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaForTrackingVoBean)vo.getTrackingArea().getBean(map);
		this.viewtype = vo.getViewType();
		this.displaytype = vo.getDisplayType();
	}

	public ims.emergency.vo.TrackingSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Boolean getViewAllED()
	{
		return this.viewalled;
	}
	public void setViewAllED(Boolean value)
	{
		this.viewalled = value;
	}
	public ims.emergency.vo.beans.TrackingAreaForTrackingVoBean getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.emergency.vo.beans.TrackingAreaForTrackingVoBean value)
	{
		this.trackingarea = value;
	}
	public Integer getViewType()
	{
		return this.viewtype;
	}
	public void setViewType(Integer value)
	{
		this.viewtype = value;
	}
	public Integer getDisplayType()
	{
		return this.displaytype;
	}
	public void setDisplayType(Integer value)
	{
		this.displaytype = value;
	}

	private Boolean viewalled;
	private ims.emergency.vo.beans.TrackingAreaForTrackingVoBean trackingarea;
	private Integer viewtype;
	private Integer displaytype;
}
