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

package ims.oncology.vo.beans;

public class InternalReferralVoBean extends ims.vo.ValueObjectBean
{
	public InternalReferralVoBean()
	{
	}
	public InternalReferralVoBean(ims.oncology.vo.InternalReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.internalreferraloutcome = vo.getInternalReferralOutcome() == null ? null : (ims.oncology.vo.beans.InternalReferralOutcomeVoBean)vo.getInternalReferralOutcome().getBean();
		this.referraldate = vo.getReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.referralsource = vo.getReferralSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralSource().getBean();
		this.referredby = vo.getReferredBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferredBy().getBean();
		this.diagnosistext = vo.getDiagnosisText();
		this.planneddischargedate = vo.getPlannedDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPlannedDischargeDate().getBean();
		this.treatmentstartdate = vo.getTreatmentStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTreatmentStartDate().getBean();
		this.treatmentenddate = vo.getTreatmentEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTreatmentEndDate().getBean();
		this.comments = vo.getComments();
		this.referralreason = vo.getReferralReason() == null ? null : vo.getReferralReason().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeOfCareForInternalReferralVoBean)vo.getEpisodeOfCare().getBean();
		this.referralseen = vo.getReferralSeen();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.InternalReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.internalreferraloutcome = vo.getInternalReferralOutcome() == null ? null : (ims.oncology.vo.beans.InternalReferralOutcomeVoBean)vo.getInternalReferralOutcome().getBean(map);
		this.referraldate = vo.getReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.referralsource = vo.getReferralSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralSource().getBean();
		this.referredby = vo.getReferredBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReferredBy().getBean(map);
		this.diagnosistext = vo.getDiagnosisText();
		this.planneddischargedate = vo.getPlannedDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPlannedDischargeDate().getBean();
		this.treatmentstartdate = vo.getTreatmentStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTreatmentStartDate().getBean();
		this.treatmentenddate = vo.getTreatmentEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTreatmentEndDate().getBean();
		this.comments = vo.getComments();
		this.referralreason = vo.getReferralReason() == null ? null : vo.getReferralReason().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : (ims.core.vo.beans.EpisodeOfCareForInternalReferralVoBean)vo.getEpisodeOfCare().getBean(map);
		this.referralseen = vo.getReferralSeen();
	}

	public ims.oncology.vo.InternalReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.InternalReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.InternalReferralVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.InternalReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.InternalReferralVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.oncology.vo.beans.InternalReferralOutcomeVoBean getInternalReferralOutcome()
	{
		return this.internalreferraloutcome;
	}
	public void setInternalReferralOutcome(ims.oncology.vo.beans.InternalReferralOutcomeVoBean value)
	{
		this.internalreferraloutcome = value;
	}
	public ims.framework.utils.beans.DateBean getReferralDate()
	{
		return this.referraldate;
	}
	public void setReferralDate(ims.framework.utils.beans.DateBean value)
	{
		this.referraldate = value;
	}
	public ims.vo.LookupInstanceBean getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.vo.LookupInstanceBean value)
	{
		this.referraltype = value;
	}
	public ims.vo.LookupInstanceBean getReferralSource()
	{
		return this.referralsource;
	}
	public void setReferralSource(ims.vo.LookupInstanceBean value)
	{
		this.referralsource = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReferredBy()
	{
		return this.referredby;
	}
	public void setReferredBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.referredby = value;
	}
	public String getDiagnosisText()
	{
		return this.diagnosistext;
	}
	public void setDiagnosisText(String value)
	{
		this.diagnosistext = value;
	}
	public ims.framework.utils.beans.DateBean getPlannedDischargeDate()
	{
		return this.planneddischargedate;
	}
	public void setPlannedDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.planneddischargedate = value;
	}
	public ims.framework.utils.beans.DateBean getTreatmentStartDate()
	{
		return this.treatmentstartdate;
	}
	public void setTreatmentStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.treatmentstartdate = value;
	}
	public ims.framework.utils.beans.DateBean getTreatmentEndDate()
	{
		return this.treatmentenddate;
	}
	public void setTreatmentEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.treatmentenddate = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public java.util.Collection getReferralReason()
	{
		return this.referralreason;
	}
	public void setReferralReason(java.util.Collection value)
	{
		this.referralreason = value;
	}
	public void addReferralReason(java.util.Collection value)
	{
		if(this.referralreason == null)
			this.referralreason = new java.util.ArrayList();
		this.referralreason.add(value);
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.EpisodeOfCareForInternalReferralVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.beans.EpisodeOfCareForInternalReferralVoBean value)
	{
		this.episodeofcare = value;
	}
	public Boolean getReferralSeen()
	{
		return this.referralseen;
	}
	public void setReferralSeen(Boolean value)
	{
		this.referralseen = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private ims.oncology.vo.beans.InternalReferralOutcomeVoBean internalreferraloutcome;
	private ims.framework.utils.beans.DateBean referraldate;
	private ims.vo.LookupInstanceBean referraltype;
	private ims.vo.LookupInstanceBean referralsource;
	private ims.core.vo.beans.HcpLiteVoBean referredby;
	private String diagnosistext;
	private ims.framework.utils.beans.DateBean planneddischargedate;
	private ims.framework.utils.beans.DateBean treatmentstartdate;
	private ims.framework.utils.beans.DateBean treatmentenddate;
	private String comments;
	private java.util.Collection referralreason;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.EpisodeOfCareForInternalReferralVoBean episodeofcare;
	private Boolean referralseen;
}
