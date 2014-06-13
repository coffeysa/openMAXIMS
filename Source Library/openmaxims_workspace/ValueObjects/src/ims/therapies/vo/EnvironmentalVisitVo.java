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

package ims.therapies.vo;

/**
 * Linked to therapies.homeAndEnvironmentalVisit.EnvironmentalVisit business object (ID: 1019100096).
 */
public class EnvironmentalVisitVo extends ims.therapies.homeandenvironmentalvisit.vo.EnvironmentalVisitRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EnvironmentalVisitVo()
	{
	}
	public EnvironmentalVisitVo(Integer id, int version)
	{
		super(id, version);
	}
	public EnvironmentalVisitVo(ims.therapies.vo.beans.EnvironmentalVisitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.visitdate = bean.getVisitDate() == null ? null : bean.getVisitDate().buildDate();
		this.therapistpresent = bean.getTherapistPresent() == null ? null : bean.getTherapistPresent().buildVo();
		this.otherspresent = bean.getOthersPresent();
		this.occupation = bean.getOccupation();
		this.jobrole = bean.getJobRole();
		this.location = bean.getLocation() == null ? null : ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation.buildLookup(bean.getLocation());
		this.rooms = ims.therapies.vo.RoomDetailsVoCollection.buildFromBeanCollection(bean.getRooms());
		this.housedetails = bean.getHouseDetails() == null ? null : bean.getHouseDetails().buildVo();
		this.visitsummary = bean.getVisitSummary() == null ? null : bean.getVisitSummary().buildVo();
		this.visitassessmentdetails = ims.therapies.vo.VisitAssessmentComponentVoCollection.buildFromBeanCollection(bean.getVisitAssessmentDetails());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.EnvironmentalVisitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.visitdate = bean.getVisitDate() == null ? null : bean.getVisitDate().buildDate();
		this.therapistpresent = bean.getTherapistPresent() == null ? null : bean.getTherapistPresent().buildVo(map);
		this.otherspresent = bean.getOthersPresent();
		this.occupation = bean.getOccupation();
		this.jobrole = bean.getJobRole();
		this.location = bean.getLocation() == null ? null : ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation.buildLookup(bean.getLocation());
		this.rooms = ims.therapies.vo.RoomDetailsVoCollection.buildFromBeanCollection(bean.getRooms());
		this.housedetails = bean.getHouseDetails() == null ? null : bean.getHouseDetails().buildVo(map);
		this.visitsummary = bean.getVisitSummary() == null ? null : bean.getVisitSummary().buildVo(map);
		this.visitassessmentdetails = ims.therapies.vo.VisitAssessmentComponentVoCollection.buildFromBeanCollection(bean.getVisitAssessmentDetails());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.EnvironmentalVisitVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.EnvironmentalVisitVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.EnvironmentalVisitVoBean();
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
		if(fieldName.equals("VISITDATE"))
			return getVisitDate();
		if(fieldName.equals("THERAPISTPRESENT"))
			return getTherapistPresent();
		if(fieldName.equals("OTHERSPRESENT"))
			return getOthersPresent();
		if(fieldName.equals("OCCUPATION"))
			return getOccupation();
		if(fieldName.equals("JOBROLE"))
			return getJobRole();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("ROOMS"))
			return getRooms();
		if(fieldName.equals("HOUSEDETAILS"))
			return getHouseDetails();
		if(fieldName.equals("VISITSUMMARY"))
			return getVisitSummary();
		if(fieldName.equals("VISITASSESSMENTDETAILS"))
			return getVisitAssessmentDetails();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getVisitDateIsNotNull()
	{
		return this.visitdate != null;
	}
	public ims.framework.utils.Date getVisitDate()
	{
		return this.visitdate;
	}
	public void setVisitDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.visitdate = value;
	}
	public boolean getTherapistPresentIsNotNull()
	{
		return this.therapistpresent != null;
	}
	public ims.core.vo.Hcp getTherapistPresent()
	{
		return this.therapistpresent;
	}
	public void setTherapistPresent(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.therapistpresent = value;
	}
	public boolean getOthersPresentIsNotNull()
	{
		return this.otherspresent != null;
	}
	public String getOthersPresent()
	{
		return this.otherspresent;
	}
	public static int getOthersPresentMaxLength()
	{
		return 1000;
	}
	public void setOthersPresent(String value)
	{
		this.isValidated = false;
		this.otherspresent = value;
	}
	public boolean getOccupationIsNotNull()
	{
		return this.occupation != null;
	}
	public String getOccupation()
	{
		return this.occupation;
	}
	public static int getOccupationMaxLength()
	{
		return 100;
	}
	public void setOccupation(String value)
	{
		this.isValidated = false;
		this.occupation = value;
	}
	public boolean getJobRoleIsNotNull()
	{
		return this.jobrole != null;
	}
	public String getJobRole()
	{
		return this.jobrole;
	}
	public static int getJobRoleMaxLength()
	{
		return 150;
	}
	public void setJobRole(String value)
	{
		this.isValidated = false;
		this.jobrole = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getRoomsIsNotNull()
	{
		return this.rooms != null;
	}
	public ims.therapies.vo.RoomDetailsVoCollection getRooms()
	{
		return this.rooms;
	}
	public void setRooms(ims.therapies.vo.RoomDetailsVoCollection value)
	{
		this.isValidated = false;
		this.rooms = value;
	}
	public boolean getHouseDetailsIsNotNull()
	{
		return this.housedetails != null;
	}
	public ims.therapies.vo.HomeDetailsVo getHouseDetails()
	{
		return this.housedetails;
	}
	public void setHouseDetails(ims.therapies.vo.HomeDetailsVo value)
	{
		this.isValidated = false;
		this.housedetails = value;
	}
	public boolean getVisitSummaryIsNotNull()
	{
		return this.visitsummary != null;
	}
	public ims.therapies.vo.VisitSummaryVo getVisitSummary()
	{
		return this.visitsummary;
	}
	public void setVisitSummary(ims.therapies.vo.VisitSummaryVo value)
	{
		this.isValidated = false;
		this.visitsummary = value;
	}
	public boolean getVisitAssessmentDetailsIsNotNull()
	{
		return this.visitassessmentdetails != null;
	}
	public ims.therapies.vo.VisitAssessmentComponentVoCollection getVisitAssessmentDetails()
	{
		return this.visitassessmentdetails;
	}
	public void setVisitAssessmentDetails(ims.therapies.vo.VisitAssessmentComponentVoCollection value)
	{
		this.isValidated = false;
		this.visitassessmentdetails = value;
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
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(this.therapistpresent != null)
		{
			if(!this.therapistpresent.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.rooms != null)
		{
			if(!this.rooms.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.housedetails != null)
		{
			if(!this.housedetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.visitsummary != null)
		{
			if(!this.visitsummary.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.visitassessmentdetails != null)
		{
			if(!this.visitassessmentdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.visitdate == null)
			listOfErrors.add("VisitDate is mandatory");
		if(this.therapistpresent != null)
		{
			String[] listOfOtherErrors = this.therapistpresent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.otherspresent != null)
			if(this.otherspresent.length() > 1000)
				listOfErrors.add("The field OthersPresent is too long. Please reduce it");
		if(this.occupation != null)
			if(this.occupation.length() > 100)
				listOfErrors.add("The length of the field [occupation] in the value object [ims.therapies.vo.EnvironmentalVisitVo] is too big. It should be less or equal to 100");
		if(this.jobrole != null)
			if(this.jobrole.length() > 150)
				listOfErrors.add("The length of the field [jobrole] in the value object [ims.therapies.vo.EnvironmentalVisitVo] is too big. It should be less or equal to 150");
		if(this.rooms != null)
		{
			String[] listOfOtherErrors = this.rooms.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.housedetails != null)
		{
			String[] listOfOtherErrors = this.housedetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.visitsummary != null)
		{
			String[] listOfOtherErrors = this.visitsummary.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.visitassessmentdetails != null)
		{
			String[] listOfOtherErrors = this.visitassessmentdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringcp == null)
			listOfErrors.add("AuthoringCP is mandatory");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		EnvironmentalVisitVo clone = new EnvironmentalVisitVo(this.id, this.version);
		
		if(this.visitdate == null)
			clone.visitdate = null;
		else
			clone.visitdate = (ims.framework.utils.Date)this.visitdate.clone();
		if(this.therapistpresent == null)
			clone.therapistpresent = null;
		else
			clone.therapistpresent = (ims.core.vo.Hcp)this.therapistpresent.clone();
		clone.otherspresent = this.otherspresent;
		clone.occupation = this.occupation;
		clone.jobrole = this.jobrole;
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation)this.location.clone();
		if(this.rooms == null)
			clone.rooms = null;
		else
			clone.rooms = (ims.therapies.vo.RoomDetailsVoCollection)this.rooms.clone();
		if(this.housedetails == null)
			clone.housedetails = null;
		else
			clone.housedetails = (ims.therapies.vo.HomeDetailsVo)this.housedetails.clone();
		if(this.visitsummary == null)
			clone.visitsummary = null;
		else
			clone.visitsummary = (ims.therapies.vo.VisitSummaryVo)this.visitsummary.clone();
		if(this.visitassessmentdetails == null)
			clone.visitassessmentdetails = null;
		else
			clone.visitassessmentdetails = (ims.therapies.vo.VisitAssessmentComponentVoCollection)this.visitassessmentdetails.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		clone.carecontext = this.carecontext;
		clone.clinicalcontact = this.clinicalcontact;
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
		if (!(EnvironmentalVisitVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EnvironmentalVisitVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EnvironmentalVisitVo compareObj = (EnvironmentalVisitVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_EnvironmentalVisit() == null && compareObj.getID_EnvironmentalVisit() != null)
				return -1;
			if(this.getID_EnvironmentalVisit() != null && compareObj.getID_EnvironmentalVisit() == null)
				return 1;
			if(this.getID_EnvironmentalVisit() != null && compareObj.getID_EnvironmentalVisit() != null)
				retVal = this.getID_EnvironmentalVisit().compareTo(compareObj.getID_EnvironmentalVisit());
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
		if(this.visitdate != null)
			count++;
		if(this.therapistpresent != null)
			count++;
		if(this.otherspresent != null)
			count++;
		if(this.occupation != null)
			count++;
		if(this.jobrole != null)
			count++;
		if(this.location != null)
			count++;
		if(this.rooms != null)
			count++;
		if(this.housedetails != null)
			count++;
		if(this.visitsummary != null)
			count++;
		if(this.visitassessmentdetails != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.framework.utils.Date visitdate;
	protected ims.core.vo.Hcp therapistpresent;
	protected String otherspresent;
	protected String occupation;
	protected String jobrole;
	protected ims.spinalinjuries.vo.lookups.EnvironmentalVisitLocation location;
	protected ims.therapies.vo.RoomDetailsVoCollection rooms;
	protected ims.therapies.vo.HomeDetailsVo housedetails;
	protected ims.therapies.vo.VisitSummaryVo visitsummary;
	protected ims.therapies.vo.VisitAssessmentComponentVoCollection visitassessmentdetails;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	private boolean isValidated = false;
	private boolean isBusy = false;
}