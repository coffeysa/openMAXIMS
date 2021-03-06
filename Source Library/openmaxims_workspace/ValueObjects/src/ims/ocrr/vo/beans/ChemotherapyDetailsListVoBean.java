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

package ims.ocrr.vo.beans;

public class ChemotherapyDetailsListVoBean extends ims.vo.ValueObjectBean
{
	public ChemotherapyDetailsListVoBean()
	{
	}
	public ChemotherapyDetailsListVoBean(ims.ocrr.vo.ChemotherapyDetailsListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean();
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.ChemotherapyDetailsListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean(map);
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
	}

	public ims.ocrr.vo.ChemotherapyDetailsListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.ChemotherapyDetailsListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.ChemotherapyDetailsListVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.ChemotherapyDetailsListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.ChemotherapyDetailsListVo();
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
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.treatingconsultant = value;
	}
	public ims.vo.LookupInstanceBean getRegimenAcronym()
	{
		return this.regimenacronym;
	}
	public void setRegimenAcronym(ims.vo.LookupInstanceBean value)
	{
		this.regimenacronym = value;
	}
	public ims.vo.LookupInstanceBean getCancerTreatementIntent()
	{
		return this.cancertreatementintent;
	}
	public void setCancerTreatementIntent(ims.vo.LookupInstanceBean value)
	{
		this.cancertreatementintent = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentResponse()
	{
		return this.treatmentresponse;
	}
	public void setTreatmentResponse(ims.vo.LookupInstanceBean value)
	{
		this.treatmentresponse = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.core.vo.beans.HcpLiteVoBean treatingconsultant;
	private ims.vo.LookupInstanceBean regimenacronym;
	private ims.vo.LookupInstanceBean cancertreatementintent;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.vo.LookupInstanceBean treatmentresponse;
}
