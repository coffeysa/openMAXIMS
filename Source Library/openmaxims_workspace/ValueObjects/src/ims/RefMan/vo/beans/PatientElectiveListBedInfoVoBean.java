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

public class PatientElectiveListBedInfoVoBean extends ims.vo.ValueObjectBean
{
	public PatientElectiveListBedInfoVoBean()
	{
	}
	public PatientElectiveListBedInfoVoBean(ims.RefMan.vo.PatientElectiveListBedInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.RefMan.vo.beans.TCIForBedInfoVoBean)vo.getTCIDetails().getBean();
		this.referral = vo.getReferral() == null ? null : new ims.vo.RefVoBean(vo.getReferral().getBoId(), vo.getReferral().getBoVersion());
		this.comments = vo.getComments();
		this.preassessmentoutcome = vo.getPreAssessmentOutcome() == null ? null : (ims.RefMan.vo.beans.PreAssessmentOutcomeCommentsForPatElListVoBean)vo.getPreAssessmentOutcome().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.PatientElectiveListBedInfoVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.RefMan.vo.beans.TCIForBedInfoVoBean)vo.getTCIDetails().getBean(map);
		this.referral = vo.getReferral() == null ? null : new ims.vo.RefVoBean(vo.getReferral().getBoId(), vo.getReferral().getBoVersion());
		this.comments = vo.getComments();
		this.preassessmentoutcome = vo.getPreAssessmentOutcome() == null ? null : (ims.RefMan.vo.beans.PreAssessmentOutcomeCommentsForPatElListVoBean)vo.getPreAssessmentOutcome().getBean(map);
	}

	public ims.RefMan.vo.PatientElectiveListBedInfoVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.PatientElectiveListBedInfoVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.PatientElectiveListBedInfoVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.PatientElectiveListBedInfoVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.PatientElectiveListBedInfoVo();
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
	public ims.core.vo.beans.PatientLite_IdentifiersVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLite_IdentifiersVoBean value)
	{
		this.patient = value;
	}
	public ims.RefMan.vo.beans.TCIForBedInfoVoBean getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.RefMan.vo.beans.TCIForBedInfoVoBean value)
	{
		this.tcidetails = value;
	}
	public ims.vo.RefVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.vo.RefVoBean value)
	{
		this.referral = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.RefMan.vo.beans.PreAssessmentOutcomeCommentsForPatElListVoBean getPreAssessmentOutcome()
	{
		return this.preassessmentoutcome;
	}
	public void setPreAssessmentOutcome(ims.RefMan.vo.beans.PreAssessmentOutcomeCommentsForPatElListVoBean value)
	{
		this.preassessmentoutcome = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.RefMan.vo.beans.TCIForBedInfoVoBean tcidetails;
	private ims.vo.RefVoBean referral;
	private String comments;
	private ims.RefMan.vo.beans.PreAssessmentOutcomeCommentsForPatElListVoBean preassessmentoutcome;
}
