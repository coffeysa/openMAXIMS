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
public class InvestigationIndexVo extends ims.ocrr.vo.InvestigationIndexShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InvestigationIndexVo()
	{
	}
	public InvestigationIndexVo(Integer id, int version)
	{
		super(id, version);
	}
	public InvestigationIndexVo(ims.ocrr.vo.beans.InvestigationIndexVoBean bean)
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
		this.investigations = ims.ocrr.vo.InvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.synonyms = ims.ocrr.vo.InvSynonymVoCollection.buildFromBeanCollection(bean.getSynonyms());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.showlast = bean.getShowLast();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.nointerface = bean.getNoInterface();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.InvestigationIndexVoBean bean)
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
		this.investigations = ims.ocrr.vo.InvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.synonyms = ims.ocrr.vo.InvSynonymVoCollection.buildFromBeanCollection(bean.getSynonyms());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.showlast = bean.getShowLast();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.nointerface = bean.getNoInterface();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.InvestigationIndexVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.InvestigationIndexVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.InvestigationIndexVoBean();
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
		if(fieldName.equals("INVESTIGATIONS"))
			return getInvestigations();
		if(fieldName.equals("SYNONYMS"))
			return getSynonyms();
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		if(fieldName.equals("SHOWLAST"))
			return getShowLast();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("NOINTERFACE"))
			return getNoInterface();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInvestigationsIsNotNull()
	{
		return this.investigations != null;
	}
	public ims.ocrr.vo.InvestigationVoCollection getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.InvestigationVoCollection value)
	{
		this.isValidated = false;
		this.investigations = value;
	}
	public boolean getSynonymsIsNotNull()
	{
		return this.synonyms != null;
	}
	public ims.ocrr.vo.InvSynonymVoCollection getSynonyms()
	{
		return this.synonyms;
	}
	public void setSynonyms(ims.ocrr.vo.InvSynonymVoCollection value)
	{
		this.isValidated = false;
		this.synonyms = value;
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
	}
	public boolean getShowLastIsNotNull()
	{
		return this.showlast != null;
	}
	public Boolean getShowLast()
	{
		return this.showlast;
	}
	public void setShowLast(Boolean value)
	{
		this.isValidated = false;
		this.showlast = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getNoInterfaceIsNotNull()
	{
		return this.nointerface != null;
	}
	public Boolean getNoInterface()
	{
		return this.nointerface;
	}
	public void setNoInterface(Boolean value)
	{
		this.isValidated = false;
		this.nointerface = value;
	}
	/**
	* getBusinessObjectId
	*/
		public Integer getBusinessObjectId()
		{
			return this.getBoId();
		}
	/**
	* getBusinessObjectName
	*/
	public String getBusinessObjectName()
		{
			return this.getBoClassName();
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
		if(this.investigations != null)
		{
			if(!this.investigations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.synonyms != null)
		{
			if(!this.synonyms.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activity != null)
		{
			if(!this.activity.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 200)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocrr.vo.InvestigationIndexVo] is too big. It should be less or equal to 200");
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.timeseriesinstructionsurl != null)
			if(this.timeseriesinstructionsurl.length() > 200)
				listOfErrors.add("The length of the field [timeseriesinstructionsurl] in the value object [ims.ocrr.vo.InvestigationIndexVo] is too big. It should be less or equal to 200");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.ocrr.vo.InvestigationIndexVo] is too big. It should be less or equal to 255");
		if(this.isprofile == null)
			listOfErrors.add("isProfile is mandatory");
		if(this.activestatus == null)
			listOfErrors.add("Active Status is mandatory");
		if(this.investigations != null)
		{
			String[] listOfOtherErrors = this.investigations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.synonyms != null)
		{
			String[] listOfOtherErrors = this.synonyms.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activity != null)
		{
			String[] listOfOtherErrors = this.activity.validate();
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
	
		InvestigationIndexVo clone = new InvestigationIndexVo(this.id, this.version);
		
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
		if(this.investigations == null)
			clone.investigations = null;
		else
			clone.investigations = (ims.ocrr.vo.InvestigationVoCollection)this.investigations.clone();
		if(this.synonyms == null)
			clone.synonyms = null;
		else
			clone.synonyms = (ims.ocrr.vo.InvSynonymVoCollection)this.synonyms.clone();
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		clone.showlast = this.showlast;
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityVo)this.activity.clone();
		clone.nointerface = this.nointerface;
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
		if (!(InvestigationIndexVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InvestigationIndexVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InvestigationIndexVo compareObj = (InvestigationIndexVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_InvestigationIndex() == null && compareObj.getID_InvestigationIndex() != null)
				return -1;
			if(this.getID_InvestigationIndex() != null && compareObj.getID_InvestigationIndex() == null)
				return 1;
			if(this.getID_InvestigationIndex() != null && compareObj.getID_InvestigationIndex() != null)
				retVal = this.getID_InvestigationIndex().compareTo(compareObj.getID_InvestigationIndex());
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
		if(this.investigations != null)
			count++;
		if(this.synonyms != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		if(this.showlast != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.nointerface != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.ocrr.vo.InvestigationVoCollection investigations;
	protected ims.ocrr.vo.InvSynonymVoCollection synonyms;
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	protected Boolean showlast;
	protected ims.core.vo.ActivityVo activity;
	protected Boolean nointerface;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
