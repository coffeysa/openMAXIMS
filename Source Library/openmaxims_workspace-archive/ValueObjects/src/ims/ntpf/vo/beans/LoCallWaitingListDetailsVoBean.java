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

package ims.ntpf.vo.beans;

public class LoCallWaitingListDetailsVoBean extends ims.vo.ValueObjectBean
{
	public LoCallWaitingListDetailsVoBean()
	{
	}
	public LoCallWaitingListDetailsVoBean(ims.ntpf.vo.LoCallWaitingListDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.currentstatusreason = vo.getCurrentStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatusReason().getBean();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ActivityVoBean)vo.getProcedure().getBean();
		this.proceduretext = vo.getProcedureText();
		this.assoclocall = vo.getAssocLocall() == null ? null : new ims.vo.RefVoBean(vo.getAssocLocall().getBoId(), vo.getAssocLocall().getBoVersion());
		this.assoccase = vo.getAssocCase() == null ? null : new ims.vo.RefVoBean(vo.getAssocCase().getBoId(), vo.getAssocCase().getBoVersion());
		this.speciality = vo.getSpeciality() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getSpeciality().getBean();
		this.referringhospital = vo.getReferringHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getReferringHospital().getBean();
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getReferringConsultant().getBean();
		this.referringconsultanttext = vo.getReferringConsultantText();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.waitinglisttype = vo.getWaitingListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWaitingListType().getBean();
		this.waitinglistdate = vo.getWaitingListDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getWaitingListDate().getBean();
		this.waitinglistmonthinterval = vo.getWaitingListMonthInterval();
		this.waitinglistlengthqualifier = vo.getWaitingListLengthQualifier() == null ? null : (ims.vo.LookupInstanceBean)vo.getWaitingListLengthQualifier().getBean();
		this.faxto = vo.getFaxTo() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getFaxTo().getBean();
		this.faxdate = vo.getFaxDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFaxDate().getBean();
		this.liaisonquery = vo.getLiaisonQuery();
		this.islinkedtocase = vo.getIsLinkedtoCase();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.mrn = vo.getMrn();
		this.episodenumber = vo.getEpisodeNumber();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ntpf.vo.LoCallWaitingListDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatus().getBean();
		this.currentstatusreason = vo.getCurrentStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCurrentStatusReason().getBean();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ActivityVoBean)vo.getProcedure().getBean(map);
		this.proceduretext = vo.getProcedureText();
		this.assoclocall = vo.getAssocLocall() == null ? null : new ims.vo.RefVoBean(vo.getAssocLocall().getBoId(), vo.getAssocLocall().getBoVersion());
		this.assoccase = vo.getAssocCase() == null ? null : new ims.vo.RefVoBean(vo.getAssocCase().getBoId(), vo.getAssocCase().getBoVersion());
		this.speciality = vo.getSpeciality() == null ? null : (ims.core.vo.beans.ServiceVoBean)vo.getSpeciality().getBean(map);
		this.referringhospital = vo.getReferringHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getReferringHospital().getBean(map);
		this.referringconsultant = vo.getReferringConsultant() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getReferringConsultant().getBean(map);
		this.referringconsultanttext = vo.getReferringConsultantText();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.waitinglisttype = vo.getWaitingListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWaitingListType().getBean();
		this.waitinglistdate = vo.getWaitingListDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getWaitingListDate().getBean();
		this.waitinglistmonthinterval = vo.getWaitingListMonthInterval();
		this.waitinglistlengthqualifier = vo.getWaitingListLengthQualifier() == null ? null : (ims.vo.LookupInstanceBean)vo.getWaitingListLengthQualifier().getBean();
		this.faxto = vo.getFaxTo() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getFaxTo().getBean(map);
		this.faxdate = vo.getFaxDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFaxDate().getBean();
		this.liaisonquery = vo.getLiaisonQuery();
		this.islinkedtocase = vo.getIsLinkedtoCase();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.mrn = vo.getMrn();
		this.episodenumber = vo.getEpisodeNumber();
	}

	public ims.ntpf.vo.LoCallWaitingListDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ntpf.vo.LoCallWaitingListDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ntpf.vo.LoCallWaitingListDetailsVo vo = null;
		if(map != null)
			vo = (ims.ntpf.vo.LoCallWaitingListDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ntpf.vo.LoCallWaitingListDetailsVo();
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
	public ims.ntpf.vo.beans.LoCallStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.ntpf.vo.beans.LoCallStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.vo.LookupInstanceBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.vo.LookupInstanceBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.LookupInstanceBean getCurrentStatusReason()
	{
		return this.currentstatusreason;
	}
	public void setCurrentStatusReason(ims.vo.LookupInstanceBean value)
	{
		this.currentstatusreason = value;
	}
	public ims.core.vo.beans.ActivityVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ActivityVoBean value)
	{
		this.procedure = value;
	}
	public String getProcedureText()
	{
		return this.proceduretext;
	}
	public void setProcedureText(String value)
	{
		this.proceduretext = value;
	}
	public ims.vo.RefVoBean getAssocLocall()
	{
		return this.assoclocall;
	}
	public void setAssocLocall(ims.vo.RefVoBean value)
	{
		this.assoclocall = value;
	}
	public ims.vo.RefVoBean getAssocCase()
	{
		return this.assoccase;
	}
	public void setAssocCase(ims.vo.RefVoBean value)
	{
		this.assoccase = value;
	}
	public ims.core.vo.beans.ServiceVoBean getSpeciality()
	{
		return this.speciality;
	}
	public void setSpeciality(ims.core.vo.beans.ServiceVoBean value)
	{
		this.speciality = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getReferringHospital()
	{
		return this.referringhospital;
	}
	public void setReferringHospital(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.referringhospital = value;
	}
	public ims.core.vo.beans.MedicVoBean getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.beans.MedicVoBean value)
	{
		this.referringconsultant = value;
	}
	public String getReferringConsultantText()
	{
		return this.referringconsultanttext;
	}
	public void setReferringConsultantText(String value)
	{
		this.referringconsultanttext = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getWaitingListType()
	{
		return this.waitinglisttype;
	}
	public void setWaitingListType(ims.vo.LookupInstanceBean value)
	{
		this.waitinglisttype = value;
	}
	public ims.framework.utils.beans.DateBean getWaitingListDate()
	{
		return this.waitinglistdate;
	}
	public void setWaitingListDate(ims.framework.utils.beans.DateBean value)
	{
		this.waitinglistdate = value;
	}
	public Integer getWaitingListMonthInterval()
	{
		return this.waitinglistmonthinterval;
	}
	public void setWaitingListMonthInterval(Integer value)
	{
		this.waitinglistmonthinterval = value;
	}
	public ims.vo.LookupInstanceBean getWaitingListLengthQualifier()
	{
		return this.waitinglistlengthqualifier;
	}
	public void setWaitingListLengthQualifier(ims.vo.LookupInstanceBean value)
	{
		this.waitinglistlengthqualifier = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getFaxTo()
	{
		return this.faxto;
	}
	public void setFaxTo(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.faxto = value;
	}
	public ims.framework.utils.beans.DateBean getFaxDate()
	{
		return this.faxdate;
	}
	public void setFaxDate(ims.framework.utils.beans.DateBean value)
	{
		this.faxdate = value;
	}
	public String getLiaisonQuery()
	{
		return this.liaisonquery;
	}
	public void setLiaisonQuery(String value)
	{
		this.liaisonquery = value;
	}
	public Boolean getIsLinkedtoCase()
	{
		return this.islinkedtocase;
	}
	public void setIsLinkedtoCase(Boolean value)
	{
		this.islinkedtocase = value;
	}
	public ims.vo.RefVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.vo.RefVoBean value)
	{
		this.hospital = value;
	}
	public String getMrn()
	{
		return this.mrn;
	}
	public void setMrn(String value)
	{
		this.mrn = value;
	}
	public String getEpisodeNumber()
	{
		return this.episodenumber;
	}
	public void setEpisodeNumber(String value)
	{
		this.episodenumber = value;
	}

	private Integer id;
	private int version;
	private ims.ntpf.vo.beans.LoCallStatusVoBean[] statushistory;
	private ims.vo.LookupInstanceBean currentstatus;
	private ims.vo.LookupInstanceBean currentstatusreason;
	private ims.core.vo.beans.ActivityVoBean procedure;
	private String proceduretext;
	private ims.vo.RefVoBean assoclocall;
	private ims.vo.RefVoBean assoccase;
	private ims.core.vo.beans.ServiceVoBean speciality;
	private ims.core.vo.beans.LocationLiteVoBean referringhospital;
	private ims.core.vo.beans.MedicVoBean referringconsultant;
	private String referringconsultanttext;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean waitinglisttype;
	private ims.framework.utils.beans.DateBean waitinglistdate;
	private Integer waitinglistmonthinterval;
	private ims.vo.LookupInstanceBean waitinglistlengthqualifier;
	private ims.core.vo.beans.MemberOfStaffShortVoBean faxto;
	private ims.framework.utils.beans.DateBean faxdate;
	private String liaisonquery;
	private Boolean islinkedtocase;
	private ims.vo.RefVoBean hospital;
	private String mrn;
	private String episodenumber;
}