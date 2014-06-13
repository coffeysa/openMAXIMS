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

package ims.clinical.vo.beans;

public class EDischargeSTHKSummaryListVoBean extends ims.vo.ValueObjectBean
{
	public EDischargeSTHKSummaryListVoBean()
	{
	}
	public EDischargeSTHKSummaryListVoBean(ims.clinical.vo.EDischargeSTHKSummaryListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextEdischargeListVoBean)vo.getCareContext().getBean();
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
		this.summarydetails = vo.getSummaryDetails() == null ? null : vo.getSummaryDetails().getBeanCollection();
		this.dischargedetails = vo.getDischargeDetails() == null ? null : (ims.clinical.vo.beans.DischargeDetailsListVoBean)vo.getDischargeDetails().getBean();
		this.ttastatus = vo.getTTAStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTTAStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.EDischargeSTHKSummaryListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextEdischargeListVoBean)vo.getCareContext().getBean(map);
		this.dischargeletterstatus = vo.getDischargeLetterStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeLetterStatus().getBean();
		this.summarydetails = vo.getSummaryDetails() == null ? null : vo.getSummaryDetails().getBeanCollection();
		this.dischargedetails = vo.getDischargeDetails() == null ? null : (ims.clinical.vo.beans.DischargeDetailsListVoBean)vo.getDischargeDetails().getBean(map);
		this.ttastatus = vo.getTTAStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTTAStatus().getBean();
	}

	public ims.clinical.vo.EDischargeSTHKSummaryListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.EDischargeSTHKSummaryListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.EDischargeSTHKSummaryListVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.EDischargeSTHKSummaryListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.EDischargeSTHKSummaryListVo();
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
	public ims.core.vo.beans.CareContextEdischargeListVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextEdischargeListVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getDischargeLetterStatus()
	{
		return this.dischargeletterstatus;
	}
	public void setDischargeLetterStatus(ims.vo.LookupInstanceBean value)
	{
		this.dischargeletterstatus = value;
	}
	public ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean[] getSummaryDetails()
	{
		return this.summarydetails;
	}
	public void setSummaryDetails(ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean[] value)
	{
		this.summarydetails = value;
	}
	public ims.clinical.vo.beans.DischargeDetailsListVoBean getDischargeDetails()
	{
		return this.dischargedetails;
	}
	public void setDischargeDetails(ims.clinical.vo.beans.DischargeDetailsListVoBean value)
	{
		this.dischargedetails = value;
	}
	public ims.vo.LookupInstanceBean getTTAStatus()
	{
		return this.ttastatus;
	}
	public void setTTAStatus(ims.vo.LookupInstanceBean value)
	{
		this.ttastatus = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.CareContextEdischargeListVoBean carecontext;
	private ims.vo.LookupInstanceBean dischargeletterstatus;
	private ims.clinical.vo.beans.EDischargeSTHKSummaryDetailVoBean[] summarydetails;
	private ims.clinical.vo.beans.DischargeDetailsListVoBean dischargedetails;
	private ims.vo.LookupInstanceBean ttastatus;
}