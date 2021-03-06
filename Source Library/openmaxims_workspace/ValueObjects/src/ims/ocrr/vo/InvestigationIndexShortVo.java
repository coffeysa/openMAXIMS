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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.InvestigationIndex business object (ID: 1061100003).
 */
public class InvestigationIndexShortVo extends ims.ocrr.vo.InvestigationIndexLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InvestigationIndexShortVo()
	{
	}
	public InvestigationIndexShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvestigationIndexShortVo(ims.ocrr.vo.beans.InvestigationIndexShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.orderability = bean.getOrderability() == null ? null : ims.ocrr.vo.lookups.InvestigationOrderability.buildLookup(bean.getOrderability());
		this.securitylevel = bean.getSecurityLevel() == null ? null : bean.getSecurityLevel().buildVo();
		this.timeseriesinstructionsurl = bean.getTimeSeriesInstructionsURL();
		this.description = bean.getDescription();
		this.colour = bean.getColour() == null ? null : bean.getColour().buildColor();
		this.isprofile = bean.getIsProfile();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.genderspecific = bean.getGenderSpecific() == null ? null : ims.admin.vo.lookups.GenderSpecific.buildLookup(bean.getGenderSpecific());
		this.phlebmaycollect = bean.getPhlebMayCollect();
		this.requiressitespecifier = bean.getRequiresSiteSpecifier();
		this.sites = ims.ocrr.vo.lookups.SpecimenSiteCollection.buildFromBeanCollection(bean.getSites());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.InvestigationIndexShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.category = bean.getCategory() == null ? null : ims.ocrr.vo.lookups.Category.buildLookup(bean.getCategory());
		this.orderability = bean.getOrderability() == null ? null : ims.ocrr.vo.lookups.InvestigationOrderability.buildLookup(bean.getOrderability());
		this.securitylevel = bean.getSecurityLevel() == null ? null : bean.getSecurityLevel().buildVo(map);
		this.timeseriesinstructionsurl = bean.getTimeSeriesInstructionsURL();
		this.description = bean.getDescription();
		this.colour = bean.getColour() == null ? null : bean.getColour().buildColor();
		this.isprofile = bean.getIsProfile();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.genderspecific = bean.getGenderSpecific() == null ? null : ims.admin.vo.lookups.GenderSpecific.buildLookup(bean.getGenderSpecific());
		this.phlebmaycollect = bean.getPhlebMayCollect();
		this.requiressitespecifier = bean.getRequiresSiteSpecifier();
		this.sites = ims.ocrr.vo.lookups.SpecimenSiteCollection.buildFromBeanCollection(bean.getSites());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.InvestigationIndexShortVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.InvestigationIndexShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.InvestigationIndexShortVoBean();
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
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("COLOUR"))
			return getColour();
		if(fieldName.equals("ISPROFILE"))
			return getIsProfile();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("GENDERSPECIFIC"))
			return getGenderSpecific();
		if(fieldName.equals("PHLEBMAYCOLLECT"))
			return getPhlebMayCollect();
		if(fieldName.equals("REQUIRESSITESPECIFIER"))
			return getRequiresSiteSpecifier();
		if(fieldName.equals("SITES"))
			return getSites();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getColourIsNotNull()
	{
		return this.colour != null;
	}
	public ims.framework.utils.Color getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.colour = value;
	}
	public boolean getIsProfileIsNotNull()
	{
		return this.isprofile != null;
	}
	public Boolean getIsProfile()
	{
		return this.isprofile;
	}
	public void setIsProfile(Boolean value)
	{
		this.isValidated = false;
		this.isprofile = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getGenderSpecificIsNotNull()
	{
		return this.genderspecific != null;
	}
	public ims.admin.vo.lookups.GenderSpecific getGenderSpecific()
	{
		return this.genderspecific;
	}
	public void setGenderSpecific(ims.admin.vo.lookups.GenderSpecific value)
	{
		this.isValidated = false;
		this.genderspecific = value;
	}
	public boolean getPhlebMayCollectIsNotNull()
	{
		return this.phlebmaycollect != null;
	}
	public Boolean getPhlebMayCollect()
	{
		return this.phlebmaycollect;
	}
	public void setPhlebMayCollect(Boolean value)
	{
		this.isValidated = false;
		this.phlebmaycollect = value;
	}
	public boolean getRequiresSiteSpecifierIsNotNull()
	{
		return this.requiressitespecifier != null;
	}
	public Boolean getRequiresSiteSpecifier()
	{
		return this.requiressitespecifier;
	}
	public void setRequiresSiteSpecifier(Boolean value)
	{
		this.isValidated = false;
		this.requiressitespecifier = value;
	}
	public boolean getSitesIsNotNull()
	{
		return this.sites != null;
	}
	public ims.ocrr.vo.lookups.SpecimenSiteCollection getSites()
	{
		return this.sites;
	}
	public void setSites(ims.ocrr.vo.lookups.SpecimenSiteCollection value)
	{
		this.isValidated = false;
		this.sites = value;
	}
	/**
	* InvestigationIndexShortVoColorComparator (class definition)
	*/
	public static class InvestigationIndexShortVoColorComparator implements java.util.Comparator
	{
		private int direction = 1;
		public InvestigationIndexShortVoColorComparator()
		{
			this(ims.framework.enumerations.SortOrder.ASCENDING);
		}
		public InvestigationIndexShortVoColorComparator(ims.framework.enumerations.SortOrder order)
		{
			if (order == ims.framework.enumerations.SortOrder.DESCENDING)
			{
					direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			InvestigationIndexShortVo voObj1 = (InvestigationIndexShortVo)obj1;
			InvestigationIndexShortVo voObj2 = (InvestigationIndexShortVo)obj2;
			if(voObj1.getColourIsNotNull() && voObj2.getColourIsNotNull())
				return direction*(voObj1.getColour().compareTo(voObj2.getColour()));
			else
				return direction;
		}
		public boolean equals(Object obj)
		{
			return false;
		}	
	}
	/**
	* getColourComparator - retrieves a new instance of static class InvestigationIndexShortVoColorComparator
	*/
	public static InvestigationIndexShortVoColorComparator getColourComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new InvestigationIndexShortVo.InvestigationIndexShortVoColorComparator(sortOrder);
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
		else if(this.name.length() > 200)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocrr.vo.InvestigationIndexShortVo] is too big. It should be less or equal to 200");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.timeseriesinstructionsurl != null)
			if(this.timeseriesinstructionsurl.length() > 200)
				listOfErrors.add("The length of the field [timeseriesinstructionsurl] in the value object [ims.ocrr.vo.InvestigationIndexShortVo] is too big. It should be less or equal to 200");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.ocrr.vo.InvestigationIndexShortVo] is too big. It should be less or equal to 255");
		if(this.isprofile == null)
			listOfErrors.add("isProfile is mandatory");
		if(this.activestatus == null)
			listOfErrors.add("Active Status is mandatory");
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
	
		InvestigationIndexShortVo clone = new InvestigationIndexShortVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.ocrr.vo.lookups.Category)this.category.clone();
		if(this.orderability == null)
			clone.orderability = null;
		else
			clone.orderability = (ims.ocrr.vo.lookups.InvestigationOrderability)this.orderability.clone();
		if(this.securitylevel == null)
			clone.securitylevel = null;
		else
			clone.securitylevel = (ims.ocrr.vo.SecurityLevelConfigVo)this.securitylevel.clone();
		clone.timeseriesinstructionsurl = this.timeseriesinstructionsurl;
		clone.description = this.description;
		if(this.colour == null)
			clone.colour = null;
		else
			clone.colour = (ims.framework.utils.Color)this.colour.clone();
		clone.isprofile = this.isprofile;
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.genderspecific == null)
			clone.genderspecific = null;
		else
			clone.genderspecific = (ims.admin.vo.lookups.GenderSpecific)this.genderspecific.clone();
		clone.phlebmaycollect = this.phlebmaycollect;
		clone.requiressitespecifier = this.requiressitespecifier;
		if(this.sites == null)
			clone.sites = null;
		else
			clone.sites = (ims.ocrr.vo.lookups.SpecimenSiteCollection)this.sites.clone();
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
		if (!(InvestigationIndexShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvestigationIndexShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InvestigationIndexShortVo compareObj = (InvestigationIndexShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCategory() == null && compareObj.getCategory() != null)
				return -1;
			if(this.getCategory() != null && compareObj.getCategory() == null)
				return 1;
			if(this.getCategory() != null && compareObj.getCategory() != null)
				retVal = this.getCategory().compareTo(compareObj.getCategory());
		}
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.description != null)
			count++;
		if(this.colour != null)
			count++;
		if(this.isprofile != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.genderspecific != null)
			count++;
		if(this.phlebmaycollect != null)
			count++;
		if(this.requiressitespecifier != null)
			count++;
		if(this.sites != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 8;
	}
	protected String description;
	protected ims.framework.utils.Color colour;
	protected Boolean isprofile;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.admin.vo.lookups.GenderSpecific genderspecific;
	protected Boolean phlebmaycollect;
	protected Boolean requiressitespecifier;
	protected ims.ocrr.vo.lookups.SpecimenSiteCollection sites;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
