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

package ims.correspondence.vo;


public class PatientDocumentErrorVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDocumentErrorVo()
	{
	}
	public PatientDocumentErrorVo(ims.correspondence.vo.beans.PatientDocumentErrorVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.documentname = bean.getDocumentName();
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
		this.error = bean.getError();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.PatientDocumentErrorVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.documentname = bean.getDocumentName();
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
		this.error = bean.getError();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.PatientDocumentErrorVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.PatientDocumentErrorVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.PatientDocumentErrorVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PersonName getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getDocumentNameIsNotNull()
	{
		return this.documentname != null;
	}
	public String getDocumentName()
	{
		return this.documentname;
	}
	public static int getDocumentNameMaxLength()
	{
		return 255;
	}
	public void setDocumentName(String value)
	{
		this.isValidated = false;
		this.documentname = value;
	}
	public boolean getDocumentDateIsNotNull()
	{
		return this.documentdate != null;
	}
	public ims.framework.utils.Date getDocumentDate()
	{
		return this.documentdate;
	}
	public void setDocumentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.documentdate = value;
	}
	public boolean getErrorIsNotNull()
	{
		return this.error != null;
	}
	public String getError()
	{
		return this.error;
	}
	public static int getErrorMaxLength()
	{
		return 255;
	}
	public void setError(String value)
	{
		this.isValidated = false;
		this.error = value;
	}
	public boolean getIdentifiersIsNotNull()
	{
		return this.identifiers != null;
	}
	public ims.core.vo.PatientIdCollection getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.identifiers = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	/**
	* Equals
	*/
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PatientDocumentErrorVo))
			return false;
	
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientDocumentErrorVo clone = new PatientDocumentErrorVo();
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PersonName)this.patient.clone();
		clone.documentname = this.documentname;
		if(this.documentdate == null)
			clone.documentdate = null;
		else
			clone.documentdate = (ims.framework.utils.Date)this.documentdate.clone();
		clone.error = this.error;
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
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
		if (!(PatientDocumentErrorVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDocumentErrorVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientDocumentErrorVo compareObj = (PatientDocumentErrorVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
		}
		if (retVal == 0)
		{
			if(this.getDocumentName() == null && compareObj.getDocumentName() != null)
				return -1;
			if(this.getDocumentName() != null && compareObj.getDocumentName() == null)
				return 1;
			if(this.getDocumentName() != null && compareObj.getDocumentName() != null)
			{
				if(caseInsensitive)
					retVal = this.getDocumentName().toLowerCase().compareTo(compareObj.getDocumentName().toLowerCase());
				else
					retVal = this.getDocumentName().compareTo(compareObj.getDocumentName());
			}
		}
		if (retVal == 0)
		{
			if(this.getDocumentDate() == null && compareObj.getDocumentDate() != null)
				return -1;
			if(this.getDocumentDate() != null && compareObj.getDocumentDate() == null)
				return 1;
			if(this.getDocumentDate() != null && compareObj.getDocumentDate() != null)
				retVal = this.getDocumentDate().compareTo(compareObj.getDocumentDate());
		}
		if (retVal == 0)
		{
			if(this.getError() == null && compareObj.getError() != null)
				return -1;
			if(this.getError() != null && compareObj.getError() == null)
				return 1;
			if(this.getError() != null && compareObj.getError() != null)
			{
				if(caseInsensitive)
					retVal = this.getError().toLowerCase().compareTo(compareObj.getError().toLowerCase());
				else
					retVal = this.getError().compareTo(compareObj.getError());
			}
		}
		if (retVal == 0)
		{
			if(this.getIdentifiers() == null && compareObj.getIdentifiers() != null)
				return -1;
			if(this.getIdentifiers() != null && compareObj.getIdentifiers() == null)
				return 1;
			if(this.getIdentifiers() != null && compareObj.getIdentifiers() != null)
				retVal = this.getIdentifiers().compareTo(compareObj.getIdentifiers());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.documentname != null)
			count++;
		if(this.documentdate != null)
			count++;
		if(this.error != null)
			count++;
		if(this.identifiers != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PersonName patient;
	protected String documentname;
	protected ims.framework.utils.Date documentdate;
	protected String error;
	protected ims.core.vo.PatientIdCollection identifiers;
	private boolean isValidated = false;
	private boolean isBusy = false;
}