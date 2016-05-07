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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceForTimeAmendmentsVo extends ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceForTimeAmendmentsVo()
	{
	}
	public EmergencyAttendanceForTimeAmendmentsVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceForTimeAmendmentsVo(ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.customid = bean.getCustomID();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.triagedatetime = bean.getTriageDateTime() == null ? null : bean.getTriageDateTime().buildDateTime();
		this.ambulancearrivaldatetime = bean.getAmbulanceArrivalDateTime() == null ? null : bean.getAmbulanceArrivalDateTime().buildDateTime();
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.expectedarrivaldatetime = bean.getExpectedArrivalDateTime() == null ? null : bean.getExpectedArrivalDateTime().buildDateTime();
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
		this.endofregistrationdatetime = bean.getEndOfRegistrationDateTime() == null ? null : bean.getEndOfRegistrationDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.customid = bean.getCustomID();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.triagedatetime = bean.getTriageDateTime() == null ? null : bean.getTriageDateTime().buildDateTime();
		this.ambulancearrivaldatetime = bean.getAmbulanceArrivalDateTime() == null ? null : bean.getAmbulanceArrivalDateTime().buildDateTime();
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.expectedarrivaldatetime = bean.getExpectedArrivalDateTime() == null ? null : bean.getExpectedArrivalDateTime().buildDateTime();
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
		this.endofregistrationdatetime = bean.getEndOfRegistrationDateTime() == null ? null : bean.getEndOfRegistrationDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsVoBean();
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
		if(fieldName.equals("ARRIVALDATETIME"))
			return getArrivalDateTime();
		if(fieldName.equals("TRIAGEDATETIME"))
			return getTriageDateTime();
		if(fieldName.equals("AMBULANCEARRIVALDATETIME"))
			return getAmbulanceArrivalDateTime();
		if(fieldName.equals("CONCLUSIONDATETIME"))
			return getConclusionDateTime();
		if(fieldName.equals("EXPECTEDARRIVALDATETIME"))
			return getExpectedArrivalDateTime();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("ENDOFREGISTRATIONDATETIME"))
			return getEndOfRegistrationDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getArrivalDateTimeIsNotNull()
	{
		return this.arrivaldatetime != null;
	}
	public ims.framework.utils.DateTime getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.arrivaldatetime = value;
	}
	public boolean getTriageDateTimeIsNotNull()
	{
		return this.triagedatetime != null;
	}
	public ims.framework.utils.DateTime getTriageDateTime()
	{
		return this.triagedatetime;
	}
	public void setTriageDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.triagedatetime = value;
	}
	public boolean getAmbulanceArrivalDateTimeIsNotNull()
	{
		return this.ambulancearrivaldatetime != null;
	}
	public ims.framework.utils.DateTime getAmbulanceArrivalDateTime()
	{
		return this.ambulancearrivaldatetime;
	}
	public void setAmbulanceArrivalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.ambulancearrivaldatetime = value;
	}
	public boolean getConclusionDateTimeIsNotNull()
	{
		return this.conclusiondatetime != null;
	}
	public ims.framework.utils.DateTime getConclusionDateTime()
	{
		return this.conclusiondatetime;
	}
	public void setConclusionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.conclusiondatetime = value;
	}
	public boolean getExpectedArrivalDateTimeIsNotNull()
	{
		return this.expectedarrivaldatetime != null;
	}
	public ims.framework.utils.DateTime getExpectedArrivalDateTime()
	{
		return this.expectedarrivaldatetime;
	}
	public void setExpectedArrivalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.expectedarrivaldatetime = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.emergency.vo.lookups.AttendanceOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.emergency.vo.lookups.AttendanceOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
	}
	public boolean getEndOfRegistrationDateTimeIsNotNull()
	{
		return this.endofregistrationdatetime != null;
	}
	public ims.framework.utils.DateTime getEndOfRegistrationDateTime()
	{
		return this.endofregistrationdatetime;
	}
	public void setEndOfRegistrationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.endofregistrationdatetime = value;
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
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.customid != null)
			if(this.customid.length() > 20)
				listOfErrors.add("The length of the field [customid] in the value object [ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsVo] is too big. It should be less or equal to 20");
		if(this.arrivaldatetime == null)
			listOfErrors.add("ArrivalDateTime is mandatory");
		if(this.endofregistrationdatetime == null)
			listOfErrors.add("EndOfRegistrationDateTime is mandatory");
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
	
		EmergencyAttendanceForTimeAmendmentsVo clone = new EmergencyAttendanceForTimeAmendmentsVo(this.id, this.version);
		
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.carecontext = this.carecontext;
		clone.customid = this.customid;
		if(this.arrivaldatetime == null)
			clone.arrivaldatetime = null;
		else
			clone.arrivaldatetime = (ims.framework.utils.DateTime)this.arrivaldatetime.clone();
		if(this.triagedatetime == null)
			clone.triagedatetime = null;
		else
			clone.triagedatetime = (ims.framework.utils.DateTime)this.triagedatetime.clone();
		if(this.ambulancearrivaldatetime == null)
			clone.ambulancearrivaldatetime = null;
		else
			clone.ambulancearrivaldatetime = (ims.framework.utils.DateTime)this.ambulancearrivaldatetime.clone();
		if(this.conclusiondatetime == null)
			clone.conclusiondatetime = null;
		else
			clone.conclusiondatetime = (ims.framework.utils.DateTime)this.conclusiondatetime.clone();
		if(this.expectedarrivaldatetime == null)
			clone.expectedarrivaldatetime = null;
		else
			clone.expectedarrivaldatetime = (ims.framework.utils.DateTime)this.expectedarrivaldatetime.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.emergency.vo.lookups.AttendanceOutcome)this.outcome.clone();
		if(this.endofregistrationdatetime == null)
			clone.endofregistrationdatetime = null;
		else
			clone.endofregistrationdatetime = (ims.framework.utils.DateTime)this.endofregistrationdatetime.clone();
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
		if (!(EmergencyAttendanceForTimeAmendmentsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceForTimeAmendmentsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceForTimeAmendmentsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceForTimeAmendmentsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.arrivaldatetime != null)
			count++;
		if(this.triagedatetime != null)
			count++;
		if(this.ambulancearrivaldatetime != null)
			count++;
		if(this.conclusiondatetime != null)
			count++;
		if(this.expectedarrivaldatetime != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.endofregistrationdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.framework.utils.DateTime arrivaldatetime;
	protected ims.framework.utils.DateTime triagedatetime;
	protected ims.framework.utils.DateTime ambulancearrivaldatetime;
	protected ims.framework.utils.DateTime conclusiondatetime;
	protected ims.framework.utils.DateTime expectedarrivaldatetime;
	protected ims.emergency.vo.lookups.AttendanceOutcome outcome;
	protected ims.framework.utils.DateTime endofregistrationdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}