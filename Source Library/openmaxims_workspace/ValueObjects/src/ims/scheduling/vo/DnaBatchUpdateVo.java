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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.DnaBactchJob business object (ID: 1090100007).
 */
public class DnaBatchUpdateVo extends ims.scheduling.vo.DnaBactchJobRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DnaBatchUpdateVo()
	{
	}
	public DnaBatchUpdateVo(Integer id, int version)
	{
		super(id, version);
	}
	public DnaBatchUpdateVo(ims.scheduling.vo.beans.DnaBatchUpdateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.triggerfrecuency = bean.getTriggerFrecuency();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.numappointmentsupdated = bean.getNumAppointmentsUpdated();
		this.printagentto = bean.getPrintAgentTo();
		this.jobdetail = bean.getJobDetail();
		this.cron = bean.getCron();
		this.cronfebruary = bean.getCronFebruary();
		this.issimplecron = bean.getIsSimpleCron();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.DnaBatchUpdateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.triggerfrecuency = bean.getTriggerFrecuency();
		this.lastrun = bean.getLastRun() == null ? null : bean.getLastRun().buildDateTime();
		this.nextrun = bean.getNextRun() == null ? null : bean.getNextRun().buildDateTime();
		this.numappointmentsupdated = bean.getNumAppointmentsUpdated();
		this.printagentto = bean.getPrintAgentTo();
		this.jobdetail = bean.getJobDetail();
		this.cron = bean.getCron();
		this.cronfebruary = bean.getCronFebruary();
		this.issimplecron = bean.getIsSimpleCron();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.DnaBatchUpdateVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.DnaBatchUpdateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.DnaBatchUpdateVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("TRIGGERFRECUENCY"))
			return getTriggerFrecuency();
		if(fieldName.equals("LASTRUN"))
			return getLastRun();
		if(fieldName.equals("NEXTRUN"))
			return getNextRun();
		if(fieldName.equals("NUMAPPOINTMENTSUPDATED"))
			return getNumAppointmentsUpdated();
		if(fieldName.equals("PRINTAGENTTO"))
			return getPrintAgentTo();
		if(fieldName.equals("JOBDETAIL"))
			return getJobDetail();
		if(fieldName.equals("CRON"))
			return getCron();
		if(fieldName.equals("CRONFEBRUARY"))
			return getCronFebruary();
		if(fieldName.equals("ISSIMPLECRON"))
			return getIsSimpleCron();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 50;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.Date getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.creationdate = value;
	}
	public boolean getTriggerFrecuencyIsNotNull()
	{
		return this.triggerfrecuency != null;
	}
	public String getTriggerFrecuency()
	{
		return this.triggerfrecuency;
	}
	public static int getTriggerFrecuencyMaxLength()
	{
		return 255;
	}
	public void setTriggerFrecuency(String value)
	{
		this.isValidated = false;
		this.triggerfrecuency = value;
	}
	public boolean getLastRunIsNotNull()
	{
		return this.lastrun != null;
	}
	public ims.framework.utils.DateTime getLastRun()
	{
		return this.lastrun;
	}
	public void setLastRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastrun = value;
	}
	public boolean getNextRunIsNotNull()
	{
		return this.nextrun != null;
	}
	public ims.framework.utils.DateTime getNextRun()
	{
		return this.nextrun;
	}
	public void setNextRun(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.nextrun = value;
	}
	public boolean getNumAppointmentsUpdatedIsNotNull()
	{
		return this.numappointmentsupdated != null;
	}
	public Integer getNumAppointmentsUpdated()
	{
		return this.numappointmentsupdated;
	}
	public void setNumAppointmentsUpdated(Integer value)
	{
		this.isValidated = false;
		this.numappointmentsupdated = value;
	}
	public boolean getPrintAgentToIsNotNull()
	{
		return this.printagentto != null;
	}
	public String getPrintAgentTo()
	{
		return this.printagentto;
	}
	public static int getPrintAgentToMaxLength()
	{
		return 500;
	}
	public void setPrintAgentTo(String value)
	{
		this.isValidated = false;
		this.printagentto = value;
	}
	public boolean getJobDetailIsNotNull()
	{
		return this.jobdetail != null;
	}
	public String getJobDetail()
	{
		return this.jobdetail;
	}
	public static int getJobDetailMaxLength()
	{
		return 10000;
	}
	public void setJobDetail(String value)
	{
		this.isValidated = false;
		this.jobdetail = value;
	}
	public boolean getCronIsNotNull()
	{
		return this.cron != null;
	}
	public String getCron()
	{
		return this.cron;
	}
	public static int getCronMaxLength()
	{
		return 10000;
	}
	public void setCron(String value)
	{
		this.isValidated = false;
		this.cron = value;
	}
	public boolean getCronFebruaryIsNotNull()
	{
		return this.cronfebruary != null;
	}
	public String getCronFebruary()
	{
		return this.cronfebruary;
	}
	public static int getCronFebruaryMaxLength()
	{
		return 10000;
	}
	public void setCronFebruary(String value)
	{
		this.isValidated = false;
		this.cronfebruary = value;
	}
	public boolean getIsSimpleCronIsNotNull()
	{
		return this.issimplecron != null;
	}
	public Boolean getIsSimpleCron()
	{
		return this.issimplecron;
	}
	public void setIsSimpleCron(Boolean value)
	{
		this.isValidated = false;
		this.issimplecron = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.DnaBatchUpdateVo] is too big. It should be less or equal to 50");
		if(this.triggerfrecuency == null || this.triggerfrecuency.length() == 0)
			listOfErrors.add("TriggerFrecuency is mandatory");
		else if(this.triggerfrecuency.length() > 255)
			listOfErrors.add("The length of the field [triggerfrecuency] in the value object [ims.scheduling.vo.DnaBatchUpdateVo] is too big. It should be less or equal to 255");
		if(this.nextrun == null)
			listOfErrors.add("NextRun is mandatory");
		if(this.printagentto != null)
			if(this.printagentto.length() > 500)
				listOfErrors.add("The length of the field [printagentto] in the value object [ims.scheduling.vo.DnaBatchUpdateVo] is too big. It should be less or equal to 500");
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
	
		DnaBatchUpdateVo clone = new DnaBatchUpdateVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.Date)this.creationdate.clone();
		clone.triggerfrecuency = this.triggerfrecuency;
		if(this.lastrun == null)
			clone.lastrun = null;
		else
			clone.lastrun = (ims.framework.utils.DateTime)this.lastrun.clone();
		if(this.nextrun == null)
			clone.nextrun = null;
		else
			clone.nextrun = (ims.framework.utils.DateTime)this.nextrun.clone();
		clone.numappointmentsupdated = this.numappointmentsupdated;
		clone.printagentto = this.printagentto;
		clone.jobdetail = this.jobdetail;
		clone.cron = this.cron;
		clone.cronfebruary = this.cronfebruary;
		clone.issimplecron = this.issimplecron;
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
		if (!(DnaBatchUpdateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DnaBatchUpdateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DnaBatchUpdateVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DnaBatchUpdateVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.creationdate != null)
			count++;
		if(this.triggerfrecuency != null)
			count++;
		if(this.lastrun != null)
			count++;
		if(this.nextrun != null)
			count++;
		if(this.numappointmentsupdated != null)
			count++;
		if(this.printagentto != null)
			count++;
		if(this.jobdetail != null)
			count++;
		if(this.cron != null)
			count++;
		if(this.cronfebruary != null)
			count++;
		if(this.issimplecron != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected String name;
	protected ims.framework.utils.Date creationdate;
	protected String triggerfrecuency;
	protected ims.framework.utils.DateTime lastrun;
	protected ims.framework.utils.DateTime nextrun;
	protected Integer numappointmentsupdated;
	protected String printagentto;
	protected String jobdetail;
	protected String cron;
	protected String cronfebruary;
	protected Boolean issimplecron;
	private boolean isValidated = false;
	private boolean isBusy = false;
}