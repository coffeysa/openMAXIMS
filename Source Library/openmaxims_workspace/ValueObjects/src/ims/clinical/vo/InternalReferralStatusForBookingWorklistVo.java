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

package ims.clinical.vo;

/**
 * Linked to clinical.ClinicalReferralStatus business object (ID: 1072100113).
 */
public class InternalReferralStatusForBookingWorklistVo extends ims.clinical.vo.ClinicalReferralStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InternalReferralStatusForBookingWorklistVo()
	{
	}
	public InternalReferralStatusForBookingWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public InternalReferralStatusForBookingWorklistVo(ims.clinical.vo.beans.InternalReferralStatusForBookingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.core.vo.lookups.InternalReferralStatus.buildLookup(bean.getReferralStatus());
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo();
		this.appointmentrequired = bean.getAppointmentRequired();
		this.appointmentbooked = bean.getAppointmentBooked();
		this.internalreferralstatuschangereason = bean.getInternalReferralStatusChangeReason() == null ? null : ims.clinical.vo.lookups.InternalReferralStatusChangeReason.buildLookup(bean.getInternalReferralStatusChangeReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.InternalReferralStatusForBookingWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.core.vo.lookups.InternalReferralStatus.buildLookup(bean.getReferralStatus());
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo(map);
		this.appointmentrequired = bean.getAppointmentRequired();
		this.appointmentbooked = bean.getAppointmentBooked();
		this.internalreferralstatuschangereason = bean.getInternalReferralStatusChangeReason() == null ? null : ims.clinical.vo.lookups.InternalReferralStatusChangeReason.buildLookup(bean.getInternalReferralStatusChangeReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.InternalReferralStatusForBookingWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.InternalReferralStatusForBookingWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.InternalReferralStatusForBookingWorklistVoBean();
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
		if(fieldName.equals("REFERRALSTATUS"))
			return getReferralStatus();
		if(fieldName.equals("RECORDINGINFO"))
			return getRecordingInfo();
		if(fieldName.equals("APPOINTMENTREQUIRED"))
			return getAppointmentRequired();
		if(fieldName.equals("APPOINTMENTBOOKED"))
			return getAppointmentBooked();
		if(fieldName.equals("INTERNALREFERRALSTATUSCHANGEREASON"))
			return getInternalReferralStatusChangeReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralStatusIsNotNull()
	{
		return this.referralstatus != null;
	}
	public ims.core.vo.lookups.InternalReferralStatus getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.core.vo.lookups.InternalReferralStatus value)
	{
		this.isValidated = false;
		this.referralstatus = value;
	}
	public boolean getRecordingInfoIsNotNull()
	{
		return this.recordinginfo != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInfo()
	{
		return this.recordinginfo;
	}
	public void setRecordingInfo(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginfo = value;
	}
	public boolean getAppointmentRequiredIsNotNull()
	{
		return this.appointmentrequired != null;
	}
	public Boolean getAppointmentRequired()
	{
		return this.appointmentrequired;
	}
	public void setAppointmentRequired(Boolean value)
	{
		this.isValidated = false;
		this.appointmentrequired = value;
	}
	public boolean getAppointmentBookedIsNotNull()
	{
		return this.appointmentbooked != null;
	}
	public Boolean getAppointmentBooked()
	{
		return this.appointmentbooked;
	}
	public void setAppointmentBooked(Boolean value)
	{
		this.isValidated = false;
		this.appointmentbooked = value;
	}
	public boolean getInternalReferralStatusChangeReasonIsNotNull()
	{
		return this.internalreferralstatuschangereason != null;
	}
	public ims.clinical.vo.lookups.InternalReferralStatusChangeReason getInternalReferralStatusChangeReason()
	{
		return this.internalreferralstatuschangereason;
	}
	public void setInternalReferralStatusChangeReason(ims.clinical.vo.lookups.InternalReferralStatusChangeReason value)
	{
		this.isValidated = false;
		this.internalreferralstatuschangereason = value;
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
		if(this.referralstatus == null)
			listOfErrors.add("ReferralStatus is mandatory");
		if(this.recordinginfo == null)
			listOfErrors.add("RecordingInfo is mandatory");
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
	
		InternalReferralStatusForBookingWorklistVo clone = new InternalReferralStatusForBookingWorklistVo(this.id, this.version);
		
		if(this.referralstatus == null)
			clone.referralstatus = null;
		else
			clone.referralstatus = (ims.core.vo.lookups.InternalReferralStatus)this.referralstatus.clone();
		if(this.recordinginfo == null)
			clone.recordinginfo = null;
		else
			clone.recordinginfo = (ims.core.vo.RecordingUserInformationVo)this.recordinginfo.clone();
		clone.appointmentrequired = this.appointmentrequired;
		clone.appointmentbooked = this.appointmentbooked;
		if(this.internalreferralstatuschangereason == null)
			clone.internalreferralstatuschangereason = null;
		else
			clone.internalreferralstatuschangereason = (ims.clinical.vo.lookups.InternalReferralStatusChangeReason)this.internalreferralstatuschangereason.clone();
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
		if (!(InternalReferralStatusForBookingWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InternalReferralStatusForBookingWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InternalReferralStatusForBookingWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InternalReferralStatusForBookingWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referralstatus != null)
			count++;
		if(this.recordinginfo != null)
			count++;
		if(this.appointmentrequired != null)
			count++;
		if(this.appointmentbooked != null)
			count++;
		if(this.internalreferralstatuschangereason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.InternalReferralStatus referralstatus;
	protected ims.core.vo.RecordingUserInformationVo recordinginfo;
	protected Boolean appointmentrequired;
	protected Boolean appointmentbooked;
	protected ims.clinical.vo.lookups.InternalReferralStatusChangeReason internalreferralstatuschangereason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
