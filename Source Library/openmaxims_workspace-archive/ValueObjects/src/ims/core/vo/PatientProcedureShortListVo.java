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

package ims.core.vo;

/**
 * Linked to core.clinical.PatientProcedure business object (ID: 1003100017).
 */
public class PatientProcedureShortListVo extends ims.core.clinical.vo.PatientProcedureRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientProcedureShortListVo()
	{
	}
	public PatientProcedureShortListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientProcedureShortListVo(ims.core.vo.beans.PatientProcedureShortListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.sitetext = bean.getSiteText();
		this.proceduredescription = bean.getProcedureDescription();
		this.procedureurgency = bean.getProcedureUrgency() == null ? null : ims.core.vo.lookups.ProcedureUrgency.buildLookup(bean.getProcedureUrgency());
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.procdate = bean.getProcDate() == null ? null : bean.getProcDate().buildPartialDate();
		this.proctime = bean.getProcTime() == null ? null : bean.getProcTime().buildTime();
		this.procedureoutcome = bean.getProcedureOutcome() == null ? null : ims.clinical.vo.lookups.PatientProcedureOutcome.buildLookup(bean.getProcedureOutcome());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.cancelledreason = bean.getCancelledReason();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.plannedproc = bean.getPlannedProc() == null ? null : new ims.core.clinical.vo.PatientProcedureRefVo(new Integer(bean.getPlannedProc().getId()), bean.getPlannedProc().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.intraoperativerecord = bean.getIntraOperativeRecord() == null ? null : new ims.core.clinical.vo.IntraOperativeCareRecordRefVo(new Integer(bean.getIntraOperativeRecord().getId()), bean.getIntraOperativeRecord().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientProcedureShortListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.sitetext = bean.getSiteText();
		this.proceduredescription = bean.getProcedureDescription();
		this.procedureurgency = bean.getProcedureUrgency() == null ? null : ims.core.vo.lookups.ProcedureUrgency.buildLookup(bean.getProcedureUrgency());
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.procdate = bean.getProcDate() == null ? null : bean.getProcDate().buildPartialDate();
		this.proctime = bean.getProcTime() == null ? null : bean.getProcTime().buildTime();
		this.procedureoutcome = bean.getProcedureOutcome() == null ? null : ims.clinical.vo.lookups.PatientProcedureOutcome.buildLookup(bean.getProcedureOutcome());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.cancelledreason = bean.getCancelledReason();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.plannedproc = bean.getPlannedProc() == null ? null : new ims.core.clinical.vo.PatientProcedureRefVo(new Integer(bean.getPlannedProc().getId()), bean.getPlannedProc().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.intraoperativerecord = bean.getIntraOperativeRecord() == null ? null : new ims.core.clinical.vo.IntraOperativeCareRecordRefVo(new Integer(bean.getIntraOperativeRecord().getId()), bean.getIntraOperativeRecord().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientProcedureShortListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientProcedureShortListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientProcedureShortListVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("SITETEXT"))
			return getSiteText();
		if(fieldName.equals("PROCEDUREDESCRIPTION"))
			return getProcedureDescription();
		if(fieldName.equals("PROCEDUREURGENCY"))
			return getProcedureUrgency();
		if(fieldName.equals("PROCEDURESTATUS"))
			return getProcedureStatus();
		if(fieldName.equals("PROCDATE"))
			return getProcDate();
		if(fieldName.equals("PROCTIME"))
			return getProcTime();
		if(fieldName.equals("PROCEDUREOUTCOME"))
			return getProcedureOutcome();
		if(fieldName.equals("CANCELLEDDATE"))
			return getCancelledDate();
		if(fieldName.equals("CANCELLEDREASON"))
			return getCancelledReason();
		if(fieldName.equals("INFOSOURCE"))
			return getInfoSource();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("PLANNEDPROC"))
			return getPlannedProc();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("INTRAOPERATIVERECORD"))
			return getIntraOperativeRecord();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getSiteTextIsNotNull()
	{
		return this.sitetext != null;
	}
	public String getSiteText()
	{
		return this.sitetext;
	}
	public static int getSiteTextMaxLength()
	{
		return 255;
	}
	public void setSiteText(String value)
	{
		this.isValidated = false;
		this.sitetext = value;
	}
	public boolean getProcedureDescriptionIsNotNull()
	{
		return this.proceduredescription != null;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public static int getProcedureDescriptionMaxLength()
	{
		return 255;
	}
	public void setProcedureDescription(String value)
	{
		this.isValidated = false;
		this.proceduredescription = value;
	}
	public boolean getProcedureUrgencyIsNotNull()
	{
		return this.procedureurgency != null;
	}
	public ims.core.vo.lookups.ProcedureUrgency getProcedureUrgency()
	{
		return this.procedureurgency;
	}
	public void setProcedureUrgency(ims.core.vo.lookups.ProcedureUrgency value)
	{
		this.isValidated = false;
		this.procedureurgency = value;
	}
	public boolean getProcedureStatusIsNotNull()
	{
		return this.procedurestatus != null;
	}
	public ims.core.vo.lookups.PatientProcedureStatus getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.core.vo.lookups.PatientProcedureStatus value)
	{
		this.isValidated = false;
		this.procedurestatus = value;
	}
	public boolean getProcDateIsNotNull()
	{
		return this.procdate != null;
	}
	public ims.framework.utils.PartialDate getProcDate()
	{
		return this.procdate;
	}
	public void setProcDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.procdate = value;
	}
	public boolean getProcTimeIsNotNull()
	{
		return this.proctime != null;
	}
	public ims.framework.utils.Time getProcTime()
	{
		return this.proctime;
	}
	public void setProcTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.proctime = value;
	}
	public boolean getProcedureOutcomeIsNotNull()
	{
		return this.procedureoutcome != null;
	}
	public ims.clinical.vo.lookups.PatientProcedureOutcome getProcedureOutcome()
	{
		return this.procedureoutcome;
	}
	public void setProcedureOutcome(ims.clinical.vo.lookups.PatientProcedureOutcome value)
	{
		this.isValidated = false;
		this.procedureoutcome = value;
	}
	public boolean getCancelledDateIsNotNull()
	{
		return this.cancelleddate != null;
	}
	public ims.framework.utils.Date getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.cancelleddate = value;
	}
	public boolean getCancelledReasonIsNotNull()
	{
		return this.cancelledreason != null;
	}
	public String getCancelledReason()
	{
		return this.cancelledreason;
	}
	public static int getCancelledReasonMaxLength()
	{
		return 255;
	}
	public void setCancelledReason(String value)
	{
		this.isValidated = false;
		this.cancelledreason = value;
	}
	public boolean getInfoSourceIsNotNull()
	{
		return this.infosource != null;
	}
	public ims.core.vo.lookups.SourceofInformation getInfoSource()
	{
		return this.infosource;
	}
	public void setInfoSource(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.infosource = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getPlannedProcIsNotNull()
	{
		return this.plannedproc != null;
	}
	public ims.core.clinical.vo.PatientProcedureRefVo getPlannedProc()
	{
		return this.plannedproc;
	}
	public void setPlannedProc(ims.core.clinical.vo.PatientProcedureRefVo value)
	{
		this.isValidated = false;
		this.plannedproc = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getIntraOperativeRecordIsNotNull()
	{
		return this.intraoperativerecord != null;
	}
	public ims.core.clinical.vo.IntraOperativeCareRecordRefVo getIntraOperativeRecord()
	{
		return this.intraoperativerecord;
	}
	public void setIntraOperativeRecord(ims.core.clinical.vo.IntraOperativeCareRecordRefVo value)
	{
		this.isValidated = false;
		this.intraoperativerecord = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.procedure != null)
		{
			if(!this.procedure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.procedure != null)
		{
			String[] listOfOtherErrors = this.procedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sitetext != null)
			if(this.sitetext.length() > 255)
				listOfErrors.add("The length of the field [sitetext] in the value object [ims.core.vo.PatientProcedureShortListVo] is too big. It should be less or equal to 255");
		if(this.proceduredescription == null || this.proceduredescription.length() == 0)
			listOfErrors.add("ProcedureDescription is mandatory");
		else if(this.proceduredescription.length() > 255)
			listOfErrors.add("The length of the field [proceduredescription] in the value object [ims.core.vo.PatientProcedureShortListVo] is too big. It should be less or equal to 255");
		if(this.cancelledreason != null)
			if(this.cancelledreason.length() > 255)
				listOfErrors.add("The length of the field [cancelledreason] in the value object [ims.core.vo.PatientProcedureShortListVo] is too big. It should be less or equal to 255");
		if(this.infosource == null)
			listOfErrors.add("InfoSource is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientProcedureShortListVo clone = new PatientProcedureShortListVo(this.id, this.version);
		
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		clone.sitetext = this.sitetext;
		clone.proceduredescription = this.proceduredescription;
		if(this.procedureurgency == null)
			clone.procedureurgency = null;
		else
			clone.procedureurgency = (ims.core.vo.lookups.ProcedureUrgency)this.procedureurgency.clone();
		if(this.procedurestatus == null)
			clone.procedurestatus = null;
		else
			clone.procedurestatus = (ims.core.vo.lookups.PatientProcedureStatus)this.procedurestatus.clone();
		if(this.procdate == null)
			clone.procdate = null;
		else
			clone.procdate = (ims.framework.utils.PartialDate)this.procdate.clone();
		if(this.proctime == null)
			clone.proctime = null;
		else
			clone.proctime = (ims.framework.utils.Time)this.proctime.clone();
		if(this.procedureoutcome == null)
			clone.procedureoutcome = null;
		else
			clone.procedureoutcome = (ims.clinical.vo.lookups.PatientProcedureOutcome)this.procedureoutcome.clone();
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.Date)this.cancelleddate.clone();
		clone.cancelledreason = this.cancelledreason;
		if(this.infosource == null)
			clone.infosource = null;
		else
			clone.infosource = (ims.core.vo.lookups.SourceofInformation)this.infosource.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.plannedproc = this.plannedproc;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.intraoperativerecord = this.intraoperativerecord;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientProcedureShortListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientProcedureShortListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientProcedureShortListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientProcedureShortListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.procedure != null)
			count++;
		if(this.sitetext != null)
			count++;
		if(this.proceduredescription != null)
			count++;
		if(this.procedureurgency != null)
			count++;
		if(this.procedurestatus != null)
			count++;
		if(this.procdate != null)
			count++;
		if(this.proctime != null)
			count++;
		if(this.procedureoutcome != null)
			count++;
		if(this.cancelleddate != null)
			count++;
		if(this.cancelledreason != null)
			count++;
		if(this.infosource != null)
			count++;
		if(this.plannedproc != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.intraoperativerecord != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected String sitetext;
	protected String proceduredescription;
	protected ims.core.vo.lookups.ProcedureUrgency procedureurgency;
	protected ims.core.vo.lookups.PatientProcedureStatus procedurestatus;
	protected ims.framework.utils.PartialDate procdate;
	protected ims.framework.utils.Time proctime;
	protected ims.clinical.vo.lookups.PatientProcedureOutcome procedureoutcome;
	protected ims.framework.utils.Date cancelleddate;
	protected String cancelledreason;
	protected ims.core.vo.lookups.SourceofInformation infosource;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.clinical.vo.PatientProcedureRefVo plannedproc;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.clinical.vo.IntraOperativeCareRecordRefVo intraoperativerecord;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
