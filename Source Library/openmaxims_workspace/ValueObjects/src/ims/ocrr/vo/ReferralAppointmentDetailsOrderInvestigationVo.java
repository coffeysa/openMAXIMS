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
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class ReferralAppointmentDetailsOrderInvestigationVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralAppointmentDetailsOrderInvestigationVo()
	{
	}
	public ReferralAppointmentDetailsOrderInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralAppointmentDetailsOrderInvestigationVo(ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specimen = ims.ocrr.vo.OrderSpecimenLiteVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaytimesupplied = bean.getDisplayTimeSupplied();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.fillerordnum = bean.getFillerOrdNum();
		this.performedlocation = bean.getPerformedLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getPerformedLocation().getId()), bean.getPerformedLocation().getVersion());
		this.investigationdatetime = bean.getInvestigationDateTime() == null ? null : bean.getInvestigationDateTime().buildDateTime();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specimen = ims.ocrr.vo.OrderSpecimenLiteVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaytimesupplied = bean.getDisplayTimeSupplied();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvstatushistory = ims.ocrr.vo.OrderedInvestigationStatusVoCollection.buildFromBeanCollection(bean.getOrdInvStatusHistory());
		this.fillerordnum = bean.getFillerOrdNum();
		this.performedlocation = bean.getPerformedLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getPerformedLocation().getId()), bean.getPerformedLocation().getVersion());
		this.investigationdatetime = bean.getInvestigationDateTime() == null ? null : bean.getInvestigationDateTime().buildDateTime();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean();
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
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("REPTIMESUPPLIED"))
			return getRepTimeSupplied();
		if(fieldName.equals("DISPLAYTIMESUPPLIED"))
			return getDisplayTimeSupplied();
		if(fieldName.equals("DISPLAYFLAG"))
			return getDisplayFlag();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("ORDINVSTATUSHISTORY"))
			return getOrdInvStatusHistory();
		if(fieldName.equals("FILLERORDNUM"))
			return getFillerOrdNum();
		if(fieldName.equals("PERFORMEDLOCATION"))
			return getPerformedLocation();
		if(fieldName.equals("INVESTIGATIONDATETIME"))
			return getInvestigationDateTime();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("RESULTSORTDATE"))
			return getResultSortDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.OrderSpecimenLiteVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.OrderSpecimenLiteVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.DateTime getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
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
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationListVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationListVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.OrderedInvestigationStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getRepDateTimeIsNotNull()
	{
		return this.repdatetime != null;
	}
	public ims.framework.utils.DateTime getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.repdatetime = value;
	}
	public boolean getRepTimeSuppliedIsNotNull()
	{
		return this.reptimesupplied != null;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.reptimesupplied = value;
	}
	public boolean getDisplayTimeSuppliedIsNotNull()
	{
		return this.displaytimesupplied != null;
	}
	public Boolean getDisplayTimeSupplied()
	{
		return this.displaytimesupplied;
	}
	public void setDisplayTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.displaytimesupplied = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public ims.ocrr.vo.lookups.OcsDisplayFlag getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.ocrr.vo.lookups.OcsDisplayFlag value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getResultStatusIsNotNull()
	{
		return this.resultstatus != null;
	}
	public ims.ocrr.vo.lookups.ResultStatus getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.ocrr.vo.lookups.ResultStatus value)
	{
		this.isValidated = false;
		this.resultstatus = value;
	}
	public boolean getOrdInvStatusHistoryIsNotNull()
	{
		return this.ordinvstatushistory != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVoCollection getOrdInvStatusHistory()
	{
		return this.ordinvstatushistory;
	}
	public void setOrdInvStatusHistory(ims.ocrr.vo.OrderedInvestigationStatusVoCollection value)
	{
		this.isValidated = false;
		this.ordinvstatushistory = value;
	}
	public boolean getFillerOrdNumIsNotNull()
	{
		return this.fillerordnum != null;
	}
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public static int getFillerOrdNumMaxLength()
	{
		return 20;
	}
	public void setFillerOrdNum(String value)
	{
		this.isValidated = false;
		this.fillerordnum = value;
	}
	public boolean getPerformedLocationIsNotNull()
	{
		return this.performedlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getPerformedLocation()
	{
		return this.performedlocation;
	}
	public void setPerformedLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.performedlocation = value;
	}
	public boolean getInvestigationDateTimeIsNotNull()
	{
		return this.investigationdatetime != null;
	}
	public ims.framework.utils.DateTime getInvestigationDateTime()
	{
		return this.investigationdatetime;
	}
	public void setInvestigationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.investigationdatetime = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForReferralAppointmentDetailsOrderInvestigationVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForReferralAppointmentDetailsOrderInvestigationVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
	}
	public boolean getResultSortDateIsNotNull()
	{
		return this.resultsortdate != null;
	}
	public ims.framework.utils.DateTime getResultSortDate()
	{
		return this.resultsortdate;
	}
	public void setResultSortDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.resultsortdate = value;
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
		if(this.specimen != null)
		{
			if(!this.specimen.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvstatushistory != null)
		{
			if(!this.ordinvstatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdetails != null)
		{
			if(!this.resultdetails.isValidated())
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
		if(this.specimen != null)
		{
			String[] listOfOtherErrors = this.specimen.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.ordinvcurrentstatus != null)
		{
			String[] listOfOtherErrors = this.ordinvcurrentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.displaytimesupplied == null)
			listOfErrors.add("DisplayTimeSupplied is mandatory");
		if(this.displayflag == null)
			listOfErrors.add("DisplayFlag is mandatory");
		if(this.ordinvstatushistory != null)
		{
			String[] listOfOtherErrors = this.ordinvstatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.fillerordnum != null)
			if(this.fillerordnum.length() > 20)
				listOfErrors.add("The length of the field [fillerordnum] in the value object [ims.ocrr.vo.ReferralAppointmentDetailsOrderInvestigationVo] is too big. It should be less or equal to 20");
		if(this.resultdetails != null)
		{
			String[] listOfOtherErrors = this.resultdetails.validate();
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
	
		ReferralAppointmentDetailsOrderInvestigationVo clone = new ReferralAppointmentDetailsOrderInvestigationVo(this.id, this.version);
		
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.OrderSpecimenLiteVoCollection)this.specimen.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.DateTime)this.appointmentdate.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationListVo)this.investigation.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		clone.orderdetails = this.orderdetails;
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		clone.reptimesupplied = this.reptimesupplied;
		clone.displaytimesupplied = this.displaytimesupplied;
		if(this.displayflag == null)
			clone.displayflag = null;
		else
			clone.displayflag = (ims.ocrr.vo.lookups.OcsDisplayFlag)this.displayflag.clone();
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.ordinvstatushistory == null)
			clone.ordinvstatushistory = null;
		else
			clone.ordinvstatushistory = (ims.ocrr.vo.OrderedInvestigationStatusVoCollection)this.ordinvstatushistory.clone();
		clone.fillerordnum = this.fillerordnum;
		clone.performedlocation = this.performedlocation;
		if(this.investigationdatetime == null)
			clone.investigationdatetime = null;
		else
			clone.investigationdatetime = (ims.framework.utils.DateTime)this.investigationdatetime.clone();
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForReferralAppointmentDetailsOrderInvestigationVo)this.resultdetails.clone();
		if(this.resultsortdate == null)
			clone.resultsortdate = null;
		else
			clone.resultsortdate = (ims.framework.utils.DateTime)this.resultsortdate.clone();
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
		if (!(ReferralAppointmentDetailsOrderInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralAppointmentDetailsOrderInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralAppointmentDetailsOrderInvestigationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralAppointmentDetailsOrderInvestigationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.specimen != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.reptimesupplied != null)
			count++;
		if(this.displaytimesupplied != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.ordinvstatushistory != null)
			count++;
		if(this.fillerordnum != null)
			count++;
		if(this.performedlocation != null)
			count++;
		if(this.investigationdatetime != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.resultsortdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 18;
	}
	protected ims.ocrr.vo.OrderSpecimenLiteVoCollection specimen;
	protected ims.framework.utils.DateTime appointmentdate;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.ocrr.vo.InvestigationListVo investigation;
	protected ims.ocrr.vo.OrderedInvestigationStatusVo ordinvcurrentstatus;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderdetails;
	protected ims.framework.utils.DateTime repdatetime;
	protected Boolean reptimesupplied;
	protected Boolean displaytimesupplied;
	protected ims.ocrr.vo.lookups.OcsDisplayFlag displayflag;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.ocrr.vo.OrderedInvestigationStatusVoCollection ordinvstatushistory;
	protected String fillerordnum;
	protected ims.core.resource.place.vo.LocationRefVo performedlocation;
	protected ims.framework.utils.DateTime investigationdatetime;
	protected ims.ocrr.vo.ResultDetailsForReferralAppointmentDetailsOrderInvestigationVo resultdetails;
	protected ims.framework.utils.DateTime resultsortdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
