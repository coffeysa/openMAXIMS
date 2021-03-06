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

package ims.coe.vo;

/**
 * Linked to clinical.Discharge Assessment business object (ID: 1017100003).
 */
public class DischargeAssessment extends ims.clinical.vo.DischargeAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeAssessment()
	{
	}
	public DischargeAssessment(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeAssessment(ims.coe.vo.beans.DischargeAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo();
		this.functionalandsupport = ims.coe.vo.DischargeFunctionalCollection.buildFromBeanCollection(bean.getFunctionalAndSupport());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.DischargeAssessmentBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo(map);
		this.functionalandsupport = ims.coe.vo.DischargeFunctionalCollection.buildFromBeanCollection(bean.getFunctionalAndSupport());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.DischargeAssessmentBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.DischargeAssessmentBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.DischargeAssessmentBean();
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
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("HCP"))
			return getHCP();
		if(fieldName.equals("FUNCTIONALANDSUPPORT"))
			return getFunctionalAndSupport();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
	}
	public boolean getHCPIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.HcpLiteVo getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getFunctionalAndSupportIsNotNull()
	{
		return this.functionalandsupport != null;
	}
	public ims.coe.vo.DischargeFunctionalCollection getFunctionalAndSupport()
	{
		return this.functionalandsupport;
	}
	public void setFunctionalAndSupport(ims.coe.vo.DischargeFunctionalCollection value)
	{
		this.isValidated = false;
		this.functionalandsupport = value;
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
		if(this.hcp != null)
		{
			if(!this.hcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.functionalandsupport != null)
		{
			if(!this.functionalandsupport.isValidated())
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
		if(this.hcp != null)
		{
			String[] listOfOtherErrors = this.hcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.functionalandsupport != null)
		{
			String[] listOfOtherErrors = this.functionalandsupport.validate();
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
	
		DischargeAssessment clone = new DischargeAssessment(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.HcpLiteVo)this.hcp.clone();
		if(this.functionalandsupport == null)
			clone.functionalandsupport = null;
		else
			clone.functionalandsupport = (ims.coe.vo.DischargeFunctionalCollection)this.functionalandsupport.clone();
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
		if (!(DischargeAssessment.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeAssessment object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DischargeAssessment compareObj = (DischargeAssessment)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_DischargeAssessment() == null && compareObj.getID_DischargeAssessment() != null)
				return -1;
			if(this.getID_DischargeAssessment() != null && compareObj.getID_DischargeAssessment() == null)
				return 1;
			if(this.getID_DischargeAssessment() != null && compareObj.getID_DischargeAssessment() != null)
				retVal = this.getID_DischargeAssessment().compareTo(compareObj.getID_DischargeAssessment());
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
		if(this.datetime != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.functionalandsupport != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime datetime;
	protected ims.core.vo.HcpLiteVo hcp;
	protected ims.coe.vo.DischargeFunctionalCollection functionalandsupport;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
