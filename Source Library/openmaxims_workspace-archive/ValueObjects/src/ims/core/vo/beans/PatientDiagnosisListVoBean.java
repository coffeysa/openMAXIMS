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

package ims.core.vo.beans;

public class PatientDiagnosisListVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisListVoBean()
	{
	}
	public PatientDiagnosisListVoBean(ims.core.vo.PatientDiagnosisListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean();
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.iscomplication = vo.getIsComplication();
		this.dateresolved = vo.getDateResolved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResolved().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.dateonset = vo.getDateOnset() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnset().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
		this.sitetext = vo.getSiteText();
		this.ispmh = vo.getIsPMH();
		this.iscancerdiagnosis = vo.getIsCancerDiagnosis();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDiagnosisListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean(map);
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.iscomplication = vo.getIsComplication();
		this.dateresolved = vo.getDateResolved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateResolved().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.dateonset = vo.getDateOnset() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnset().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.diaglaterality = vo.getDiagLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiagLaterality().getBean();
		this.sitetext = vo.getSiteText();
		this.ispmh = vo.getIsPMH();
		this.iscancerdiagnosis = vo.getIsCancerDiagnosis();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
	}

	public ims.core.vo.PatientDiagnosisListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDiagnosisListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDiagnosisListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDiagnosisListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDiagnosisListVo();
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
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.diagnoseddate = value;
	}
	public ims.clinical.vo.beans.PatientDiagnosisStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.clinical.vo.beans.PatientDiagnosisStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.core.vo.beans.DiagLiteVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.DiagLiteVoBean value)
	{
		this.diagnosis = value;
	}
	public ims.core.vo.beans.CareContextLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextLiteVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIsComorbidity()
	{
		return this.iscomorbidity;
	}
	public void setIsComorbidity(Boolean value)
	{
		this.iscomorbidity = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public Boolean getIsComplication()
	{
		return this.iscomplication;
	}
	public void setIsComplication(Boolean value)
	{
		this.iscomplication = value;
	}
	public ims.framework.utils.beans.DateBean getDateResolved()
	{
		return this.dateresolved;
	}
	public void setDateResolved(ims.framework.utils.beans.DateBean value)
	{
		this.dateresolved = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.framework.utils.beans.DateBean getDateOnset()
	{
		return this.dateonset;
	}
	public void setDateOnset(ims.framework.utils.beans.DateBean value)
	{
		this.dateonset = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.LookupInstanceBean getDiagLaterality()
	{
		return this.diaglaterality;
	}
	public void setDiagLaterality(ims.vo.LookupInstanceBean value)
	{
		this.diaglaterality = value;
	}
	public String getSiteText()
	{
		return this.sitetext;
	}
	public void setSiteText(String value)
	{
		this.sitetext = value;
	}
	public Boolean getIsPMH()
	{
		return this.ispmh;
	}
	public void setIsPMH(Boolean value)
	{
		this.ispmh = value;
	}
	public Boolean getIsCancerDiagnosis()
	{
		return this.iscancerdiagnosis;
	}
	public void setIsCancerDiagnosis(Boolean value)
	{
		this.iscancerdiagnosis = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] getPrimaryForCareSpells()
	{
		return this.primaryforcarespells;
	}
	public void setPrimaryForCareSpells(ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] value)
	{
		this.primaryforcarespells = value;
	}

	private Integer id;
	private int version;
	private String diagnosisdescription;
	private ims.framework.utils.beans.PartialDateBean diagnoseddate;
	private ims.clinical.vo.beans.PatientDiagnosisStatusVoBean currentstatus;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.core.vo.beans.DiagLiteVoBean diagnosis;
	private ims.core.vo.beans.CareContextLiteVoBean carecontext;
	private Boolean iscomorbidity;
	private ims.vo.RefVoBean episodeofcare;
	private Boolean iscomplication;
	private ims.framework.utils.beans.DateBean dateresolved;
	private ims.vo.SysInfoBean sysinfo;
	private ims.framework.utils.beans.DateBean dateonset;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.vo.LookupInstanceBean diaglaterality;
	private String sitetext;
	private Boolean ispmh;
	private Boolean iscancerdiagnosis;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.core.vo.beans.CSPrimaryDiagnosisVoBean[] primaryforcarespells;
}
