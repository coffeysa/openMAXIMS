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

package ims.core.vo;

/**
 * Linked to core.clinical.PatientCaseNoteRequest business object (ID: 1003100131).
 */
public class PatientCaseNoteRequestShortVo extends ims.core.vo.PatientCaseNoteRequestLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteRequestShortVo()
	{
	}
	public PatientCaseNoteRequestShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCaseNoteRequestShortVo(ims.core.vo.beans.PatientCaseNoteRequestShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.reasonforrequest = bean.getReasonForRequest() == null ? null : ims.core.vo.lookups.CaseNoteReasonForRequest.buildLookup(bean.getReasonForRequest());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
		this.casenote = bean.getCaseNote() == null ? null : bean.getCaseNote().buildVo();
		this.requestedforlocation = bean.getRequestedForLocation() == null ? null : bean.getRequestedForLocation().buildVo();
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.requestcomment = bean.getRequestComment() == null ? null : bean.getRequestComment().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCaseNoteRequestShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDateTime();
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.requiredbydate = bean.getRequiredByDate() == null ? null : bean.getRequiredByDate().buildDateTime();
		this.reasonforrequest = bean.getReasonForRequest() == null ? null : ims.core.vo.lookups.CaseNoteReasonForRequest.buildLookup(bean.getReasonForRequest());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
		this.casenote = bean.getCaseNote() == null ? null : bean.getCaseNote().buildVo(map);
		this.requestedforlocation = bean.getRequestedForLocation() == null ? null : bean.getRequestedForLocation().buildVo(map);
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.requestcomment = bean.getRequestComment() == null ? null : bean.getRequestComment().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCaseNoteRequestShortVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCaseNoteRequestShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCaseNoteRequestShortVoBean();
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
		if(fieldName.equals("CASENOTE"))
			return getCaseNote();
		if(fieldName.equals("REQUESTEDFORLOCATION"))
			return getRequestedForLocation();
		if(fieldName.equals("REQUESTEDBY"))
			return getRequestedBy();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REQUESTCOMMENT"))
			return getRequestComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCaseNoteIsNotNull()
	{
		return this.casenote != null;
	}
	public ims.core.vo.PatientCaseNoteTypeVo getCaseNote()
	{
		return this.casenote;
	}
	public void setCaseNote(ims.core.vo.PatientCaseNoteTypeVo value)
	{
		this.isValidated = false;
		this.casenote = value;
	}
	public boolean getRequestedForLocationIsNotNull()
	{
		return this.requestedforlocation != null;
	}
	public ims.core.vo.LocationLiteVo getRequestedForLocation()
	{
		return this.requestedforlocation;
	}
	public void setRequestedForLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.requestedforlocation = value;
	}
	public boolean getRequestedByIsNotNull()
	{
		return this.requestedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.requestedby = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getRequestCommentIsNotNull()
	{
		return this.requestcomment != null;
	}
	public ims.core.vo.PatientCaseNoteCommentSaveVo getRequestComment()
	{
		return this.requestcomment;
	}
	public void setRequestComment(ims.core.vo.PatientCaseNoteCommentSaveVo value)
	{
		this.isValidated = false;
		this.requestcomment = value;
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
		if(this.requestcomment != null)
		{
			if(!this.requestcomment.isValidated())
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
		if(this.creationdate == null)
			listOfErrors.add("CreationDate is mandatory");
		if(this.requeststatus == null)
			listOfErrors.add("RequestStatus is mandatory");
		if(this.requiredbydate == null)
			listOfErrors.add("RequiredByDate is mandatory");
		if(this.casenote == null)
			listOfErrors.add("CaseNote is mandatory");
		if(this.requestedforlocation == null)
			listOfErrors.add("RequestedForLocation is mandatory");
		if(this.requestedby == null)
			listOfErrors.add("RequestedBy is mandatory");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.requestcomment != null)
		{
			String[] listOfOtherErrors = this.requestcomment.validate();
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
	
		PatientCaseNoteRequestShortVo clone = new PatientCaseNoteRequestShortVo(this.id, this.version);
		
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.DateTime)this.creationdate.clone();
		if(this.requeststatus == null)
			clone.requeststatus = null;
		else
			clone.requeststatus = (ims.core.vo.lookups.CaseNoteRequestStatus)this.requeststatus.clone();
		if(this.requiredbydate == null)
			clone.requiredbydate = null;
		else
			clone.requiredbydate = (ims.framework.utils.DateTime)this.requiredbydate.clone();
		if(this.reasonforrequest == null)
			clone.reasonforrequest = null;
		else
			clone.reasonforrequest = (ims.core.vo.lookups.CaseNoteReasonForRequest)this.reasonforrequest.clone();
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.DateTime)this.cancelleddate.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.core.vo.lookups.CaseNoteRequestCancellationReason)this.cancellationreason.clone();
		if(this.casenote == null)
			clone.casenote = null;
		else
			clone.casenote = (ims.core.vo.PatientCaseNoteTypeVo)this.casenote.clone();
		if(this.requestedforlocation == null)
			clone.requestedforlocation = null;
		else
			clone.requestedforlocation = (ims.core.vo.LocationLiteVo)this.requestedforlocation.clone();
		if(this.requestedby == null)
			clone.requestedby = null;
		else
			clone.requestedby = (ims.core.vo.MemberOfStaffLiteVo)this.requestedby.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.requestcomment == null)
			clone.requestcomment = null;
		else
			clone.requestcomment = (ims.core.vo.PatientCaseNoteCommentSaveVo)this.requestcomment.clone();
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
		if (!(PatientCaseNoteRequestShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCaseNoteRequestShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCaseNoteRequestShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCaseNoteRequestShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.casenote != null)
			count++;
		if(this.requestedforlocation != null)
			count++;
		if(this.requestedby != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.requestcomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.core.vo.PatientCaseNoteTypeVo casenote;
	protected ims.core.vo.LocationLiteVo requestedforlocation;
	protected ims.core.vo.MemberOfStaffLiteVo requestedby;
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.core.vo.PatientCaseNoteCommentSaveVo requestcomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
