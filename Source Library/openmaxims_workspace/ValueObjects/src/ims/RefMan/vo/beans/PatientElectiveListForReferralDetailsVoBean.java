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

public class PatientElectiveListForReferralDetailsVoBean extends ims.vo.ValueObjectBean
{
	public PatientElectiveListForReferralDetailsVoBean()
	{
	}
	public PatientElectiveListForReferralDetailsVoBean(ims.RefMan.vo.PatientElectiveListForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.electivelist = vo.getElectiveList() == null ? null : (ims.RefMan.vo.beans.PatientElectiveListConfigForReferralDetailsVoBean)vo.getElectiveList().getBean();
		this.dateonlist = vo.getDateOnList() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnList().getBean();
		this.electiveliststatus = vo.getElectiveListStatus() == null ? null : (ims.RefMan.vo.beans.ElectiveListStatusVoBean)vo.getElectiveListStatus().getBean();
		if(vo.getTCIHistory() != null)
		{
			this.tcihistory = new ims.vo.RefVoBean[vo.getTCIHistory().size()];
			for(int tcihistory_i = 0; tcihistory_i < vo.getTCIHistory().size(); tcihistory_i++)
			{
				this.tcihistory[tcihistory_i] = new ims.vo.RefVoBean(vo.getTCIHistory().get(tcihistory_i).getBoId(),vo.getTCIHistory().get(tcihistory_i).getBoVersion());
			}
		}
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.RefMan.vo.beans.ElectiveTCIForReferralDetailsVoBean)vo.getTCIDetails().getBean();
		this.primaryprocedure = vo.getPrimaryProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getPrimaryProcedure().getBean();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.preassessmentrequired = vo.getPreAssessmentRequired();
		this.fitforsurgery = vo.getFitForSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getFitForSurgery().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralforElectiveProceduresVoBean)vo.getReferral().getBean();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentLiteVoBean)vo.getTheatreAppointment().getBean();
		this.requiresvetting = vo.getRequiresVetting();
		this.proceduredescription = vo.getProcedureDescription();
		this.rule28daystatus = vo.getRule28DayStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getRule28DayStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.PatientElectiveListForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.electivelist = vo.getElectiveList() == null ? null : (ims.RefMan.vo.beans.PatientElectiveListConfigForReferralDetailsVoBean)vo.getElectiveList().getBean(map);
		this.dateonlist = vo.getDateOnList() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnList().getBean();
		this.electiveliststatus = vo.getElectiveListStatus() == null ? null : (ims.RefMan.vo.beans.ElectiveListStatusVoBean)vo.getElectiveListStatus().getBean(map);
		if(vo.getTCIHistory() != null)
		{
			this.tcihistory = new ims.vo.RefVoBean[vo.getTCIHistory().size()];
			for(int tcihistory_i = 0; tcihistory_i < vo.getTCIHistory().size(); tcihistory_i++)
			{
				this.tcihistory[tcihistory_i] = new ims.vo.RefVoBean(vo.getTCIHistory().get(tcihistory_i).getBoId(),vo.getTCIHistory().get(tcihistory_i).getBoVersion());
			}
		}
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.RefMan.vo.beans.ElectiveTCIForReferralDetailsVoBean)vo.getTCIDetails().getBean(map);
		this.primaryprocedure = vo.getPrimaryProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getPrimaryProcedure().getBean(map);
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.preassessmentrequired = vo.getPreAssessmentRequired();
		this.fitforsurgery = vo.getFitForSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getFitForSurgery().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralforElectiveProceduresVoBean)vo.getReferral().getBean(map);
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : (ims.scheduling.vo.beans.Booking_AppointmentLiteVoBean)vo.getTheatreAppointment().getBean(map);
		this.requiresvetting = vo.getRequiresVetting();
		this.proceduredescription = vo.getProcedureDescription();
		this.rule28daystatus = vo.getRule28DayStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getRule28DayStatus().getBean();
	}

	public ims.RefMan.vo.PatientElectiveListForReferralDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.PatientElectiveListForReferralDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.PatientElectiveListForReferralDetailsVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.PatientElectiveListForReferralDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.PatientElectiveListForReferralDetailsVo();
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
	public ims.RefMan.vo.beans.PatientElectiveListConfigForReferralDetailsVoBean getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.RefMan.vo.beans.PatientElectiveListConfigForReferralDetailsVoBean value)
	{
		this.electivelist = value;
	}
	public ims.framework.utils.beans.DateBean getDateOnList()
	{
		return this.dateonlist;
	}
	public void setDateOnList(ims.framework.utils.beans.DateBean value)
	{
		this.dateonlist = value;
	}
	public ims.RefMan.vo.beans.ElectiveListStatusVoBean getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.RefMan.vo.beans.ElectiveListStatusVoBean value)
	{
		this.electiveliststatus = value;
	}
	public ims.vo.RefVoBean[] getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.vo.RefVoBean[] value)
	{
		this.tcihistory = value;
	}
	public ims.RefMan.vo.beans.ElectiveTCIForReferralDetailsVoBean getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.RefMan.vo.beans.ElectiveTCIForReferralDetailsVoBean value)
	{
		this.tcidetails = value;
	}
	public ims.core.vo.beans.ProcedureLiteVoBean getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.primaryprocedure = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.vo.LookupInstanceBean value)
	{
		this.admissiontype = value;
	}
	public Boolean getPreAssessmentRequired()
	{
		return this.preassessmentrequired;
	}
	public void setPreAssessmentRequired(Boolean value)
	{
		this.preassessmentrequired = value;
	}
	public ims.vo.LookupInstanceBean getFitForSurgery()
	{
		return this.fitforsurgery;
	}
	public void setFitForSurgery(ims.vo.LookupInstanceBean value)
	{
		this.fitforsurgery = value;
	}
	public ims.RefMan.vo.beans.CatsReferralforElectiveProceduresVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.beans.CatsReferralforElectiveProceduresVoBean value)
	{
		this.referral = value;
	}
	public ims.scheduling.vo.beans.Booking_AppointmentLiteVoBean getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.scheduling.vo.beans.Booking_AppointmentLiteVoBean value)
	{
		this.theatreappointment = value;
	}
	public Boolean getRequiresVetting()
	{
		return this.requiresvetting;
	}
	public void setRequiresVetting(Boolean value)
	{
		this.requiresvetting = value;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public void setProcedureDescription(String value)
	{
		this.proceduredescription = value;
	}
	public ims.vo.LookupInstanceBean getRule28DayStatus()
	{
		return this.rule28daystatus;
	}
	public void setRule28DayStatus(ims.vo.LookupInstanceBean value)
	{
		this.rule28daystatus = value;
	}

	private Integer id;
	private int version;
	private ims.RefMan.vo.beans.PatientElectiveListConfigForReferralDetailsVoBean electivelist;
	private ims.framework.utils.beans.DateBean dateonlist;
	private ims.RefMan.vo.beans.ElectiveListStatusVoBean electiveliststatus;
	private ims.vo.RefVoBean[] tcihistory;
	private ims.RefMan.vo.beans.ElectiveTCIForReferralDetailsVoBean tcidetails;
	private ims.core.vo.beans.ProcedureLiteVoBean primaryprocedure;
	private ims.vo.LookupInstanceBean admissiontype;
	private Boolean preassessmentrequired;
	private ims.vo.LookupInstanceBean fitforsurgery;
	private ims.RefMan.vo.beans.CatsReferralforElectiveProceduresVoBean referral;
	private ims.scheduling.vo.beans.Booking_AppointmentLiteVoBean theatreappointment;
	private Boolean requiresvetting;
	private String proceduredescription;
	private ims.vo.LookupInstanceBean rule28daystatus;
}
