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

package ims.scheduling.vo.beans;

public class Sch_ProfileVoBean extends ims.vo.ValueObjectBean
{
	public Sch_ProfileVoBean()
	{
	}
	public Sch_ProfileVoBean(ims.scheduling.vo.Sch_ProfileVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.prfcategory = vo.getPrfCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrfCategory().getBean();
		this.prftype = vo.getPrftype() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrftype().getBean();
		this.efffrm = vo.getEffFrm() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffFrm().getBean();
		this.effto = vo.getEffTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffTo().getBean();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean();
		this.lastactualgendate = vo.getLastActualGenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastActualGenDate().getBean();
		this.lastgendate = vo.getLastGenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastGenDate().getBean();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getSchLocation().getBean();
		this.isfixed = vo.getIsFixed();
		this.isundercontract = vo.getIsUnderContract();
		this.intervaltype = vo.getIntervalType() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntervalType().getBean();
		this.intervalsize = vo.getIntervalSize();
		this.isschmon = vo.getIsSchMon();
		this.isschtue = vo.getIsSchTue();
		this.isschwed = vo.getIsSchWed();
		this.isschthur = vo.getIsSchThur();
		this.isschfri = vo.getIsSchFri();
		this.isschsat = vo.getIsSchSat();
		this.isschsun = vo.getIsSchSun();
		this.isfirstinstance = vo.getIsFirstInstance();
		this.issecondinstance = vo.getIsSecondInstance();
		this.isthirdinstance = vo.getIsThirdInstance();
		this.isfourthinstance = vo.getIsFourthInstance();
		this.isfifthinstance = vo.getIsFifthInstance();
		this.minint = vo.getMinInt();
		this.roundatttime = vo.getRoundAttTime();
		this.lastappinterval = vo.getLastAppInterval();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.maxnoappts = vo.getMaxNoAppts();
		this.bookingrights = vo.getBookingRights() == null ? null : vo.getBookingRights().getBeanCollection();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.exclusiondates = vo.getExclusionDates() == null ? null : vo.getExclusionDates().getBeanCollection();
		this.exclusiontimes = vo.getExclusionTimes() == null ? null : vo.getExclusionTimes().getBeanCollection();
		this.consmediatype = vo.getConsMediaType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsMediaType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.Sch_ProfileVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.prfcategory = vo.getPrfCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrfCategory().getBean();
		this.prftype = vo.getPrftype() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrftype().getBean();
		this.efffrm = vo.getEffFrm() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffFrm().getBean();
		this.effto = vo.getEffTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffTo().getBean();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean(map);
		this.lastactualgendate = vo.getLastActualGenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastActualGenDate().getBean();
		this.lastgendate = vo.getLastGenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastGenDate().getBean();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getSchLocation().getBean(map);
		this.isfixed = vo.getIsFixed();
		this.isundercontract = vo.getIsUnderContract();
		this.intervaltype = vo.getIntervalType() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntervalType().getBean();
		this.intervalsize = vo.getIntervalSize();
		this.isschmon = vo.getIsSchMon();
		this.isschtue = vo.getIsSchTue();
		this.isschwed = vo.getIsSchWed();
		this.isschthur = vo.getIsSchThur();
		this.isschfri = vo.getIsSchFri();
		this.isschsat = vo.getIsSchSat();
		this.isschsun = vo.getIsSchSun();
		this.isfirstinstance = vo.getIsFirstInstance();
		this.issecondinstance = vo.getIsSecondInstance();
		this.isthirdinstance = vo.getIsThirdInstance();
		this.isfourthinstance = vo.getIsFourthInstance();
		this.isfifthinstance = vo.getIsFifthInstance();
		this.minint = vo.getMinInt();
		this.roundatttime = vo.getRoundAttTime();
		this.lastappinterval = vo.getLastAppInterval();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.maxnoappts = vo.getMaxNoAppts();
		this.bookingrights = vo.getBookingRights() == null ? null : vo.getBookingRights().getBeanCollection();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.exclusiondates = vo.getExclusionDates() == null ? null : vo.getExclusionDates().getBeanCollection();
		this.exclusiontimes = vo.getExclusionTimes() == null ? null : vo.getExclusionTimes().getBeanCollection();
		this.consmediatype = vo.getConsMediaType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsMediaType().getBean();
	}

	public ims.scheduling.vo.Sch_ProfileVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.Sch_ProfileVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.Sch_ProfileVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.Sch_ProfileVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.Sch_ProfileVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.vo.LookupInstanceBean getPrfCategory()
	{
		return this.prfcategory;
	}
	public void setPrfCategory(ims.vo.LookupInstanceBean value)
	{
		this.prfcategory = value;
	}
	public ims.vo.LookupInstanceBean getPrftype()
	{
		return this.prftype;
	}
	public void setPrftype(ims.vo.LookupInstanceBean value)
	{
		this.prftype = value;
	}
	public ims.framework.utils.beans.DateBean getEffFrm()
	{
		return this.efffrm;
	}
	public void setEffFrm(ims.framework.utils.beans.DateBean value)
	{
		this.efffrm = value;
	}
	public ims.framework.utils.beans.DateBean getEffTo()
	{
		return this.effto;
	}
	public void setEffTo(ims.framework.utils.beans.DateBean value)
	{
		this.effto = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.service = value;
	}
	public ims.framework.utils.beans.DateBean getLastActualGenDate()
	{
		return this.lastactualgendate;
	}
	public void setLastActualGenDate(ims.framework.utils.beans.DateBean value)
	{
		this.lastactualgendate = value;
	}
	public ims.framework.utils.beans.DateBean getLastGenDate()
	{
		return this.lastgendate;
	}
	public void setLastGenDate(ims.framework.utils.beans.DateBean value)
	{
		this.lastgendate = value;
	}
	public ims.core.vo.beans.LocShortVoBean getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.beans.LocShortVoBean value)
	{
		this.schlocation = value;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isfixed = value;
	}
	public Boolean getIsUnderContract()
	{
		return this.isundercontract;
	}
	public void setIsUnderContract(Boolean value)
	{
		this.isundercontract = value;
	}
	public ims.vo.LookupInstanceBean getIntervalType()
	{
		return this.intervaltype;
	}
	public void setIntervalType(ims.vo.LookupInstanceBean value)
	{
		this.intervaltype = value;
	}
	public Integer getIntervalSize()
	{
		return this.intervalsize;
	}
	public void setIntervalSize(Integer value)
	{
		this.intervalsize = value;
	}
	public Boolean getIsSchMon()
	{
		return this.isschmon;
	}
	public void setIsSchMon(Boolean value)
	{
		this.isschmon = value;
	}
	public Boolean getIsSchTue()
	{
		return this.isschtue;
	}
	public void setIsSchTue(Boolean value)
	{
		this.isschtue = value;
	}
	public Boolean getIsSchWed()
	{
		return this.isschwed;
	}
	public void setIsSchWed(Boolean value)
	{
		this.isschwed = value;
	}
	public Boolean getIsSchThur()
	{
		return this.isschthur;
	}
	public void setIsSchThur(Boolean value)
	{
		this.isschthur = value;
	}
	public Boolean getIsSchFri()
	{
		return this.isschfri;
	}
	public void setIsSchFri(Boolean value)
	{
		this.isschfri = value;
	}
	public Boolean getIsSchSat()
	{
		return this.isschsat;
	}
	public void setIsSchSat(Boolean value)
	{
		this.isschsat = value;
	}
	public Boolean getIsSchSun()
	{
		return this.isschsun;
	}
	public void setIsSchSun(Boolean value)
	{
		this.isschsun = value;
	}
	public Boolean getIsFirstInstance()
	{
		return this.isfirstinstance;
	}
	public void setIsFirstInstance(Boolean value)
	{
		this.isfirstinstance = value;
	}
	public Boolean getIsSecondInstance()
	{
		return this.issecondinstance;
	}
	public void setIsSecondInstance(Boolean value)
	{
		this.issecondinstance = value;
	}
	public Boolean getIsThirdInstance()
	{
		return this.isthirdinstance;
	}
	public void setIsThirdInstance(Boolean value)
	{
		this.isthirdinstance = value;
	}
	public Boolean getIsFourthInstance()
	{
		return this.isfourthinstance;
	}
	public void setIsFourthInstance(Boolean value)
	{
		this.isfourthinstance = value;
	}
	public Boolean getIsFifthInstance()
	{
		return this.isfifthinstance;
	}
	public void setIsFifthInstance(Boolean value)
	{
		this.isfifthinstance = value;
	}
	public Integer getMinInt()
	{
		return this.minint;
	}
	public void setMinInt(Integer value)
	{
		this.minint = value;
	}
	public Integer getRoundAttTime()
	{
		return this.roundatttime;
	}
	public void setRoundAttTime(Integer value)
	{
		this.roundatttime = value;
	}
	public Integer getLastAppInterval()
	{
		return this.lastappinterval;
	}
	public void setLastAppInterval(Integer value)
	{
		this.lastappinterval = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.beans.TimeBean value)
	{
		this.starttm = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.beans.TimeBean value)
	{
		this.endtm = value;
	}
	public ims.vo.LookupInstanceBean getPASClinic()
	{
		return this.pasclinic;
	}
	public void setPASClinic(ims.vo.LookupInstanceBean value)
	{
		this.pasclinic = value;
	}
	public Integer getMaxNoAppts()
	{
		return this.maxnoappts;
	}
	public void setMaxNoAppts(Integer value)
	{
		this.maxnoappts = value;
	}
	public ims.scheduling.vo.beans.Profile_BookRightsVoBean[] getBookingRights()
	{
		return this.bookingrights;
	}
	public void setBookingRights(ims.scheduling.vo.beans.Profile_BookRightsVoBean[] value)
	{
		this.bookingrights = value;
	}
	public ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] value)
	{
		this.listowners = value;
	}
	public ims.scheduling.vo.beans.Profile_Exc_DateVoBean[] getExclusionDates()
	{
		return this.exclusiondates;
	}
	public void setExclusionDates(ims.scheduling.vo.beans.Profile_Exc_DateVoBean[] value)
	{
		this.exclusiondates = value;
	}
	public ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] getExclusionTimes()
	{
		return this.exclusiontimes;
	}
	public void setExclusionTimes(ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] value)
	{
		this.exclusiontimes = value;
	}
	public ims.vo.LookupInstanceBean getConsMediaType()
	{
		return this.consmediatype;
	}
	public void setConsMediaType(ims.vo.LookupInstanceBean value)
	{
		this.consmediatype = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private ims.vo.LookupInstanceBean prfcategory;
	private ims.vo.LookupInstanceBean prftype;
	private ims.framework.utils.beans.DateBean efffrm;
	private ims.framework.utils.beans.DateBean effto;
	private Boolean isactive;
	private ims.core.vo.beans.ServiceShortVoBean service;
	private ims.framework.utils.beans.DateBean lastactualgendate;
	private ims.framework.utils.beans.DateBean lastgendate;
	private ims.core.vo.beans.LocShortVoBean schlocation;
	private Boolean isfixed;
	private Boolean isundercontract;
	private ims.vo.LookupInstanceBean intervaltype;
	private Integer intervalsize;
	private Boolean isschmon;
	private Boolean isschtue;
	private Boolean isschwed;
	private Boolean isschthur;
	private Boolean isschfri;
	private Boolean isschsat;
	private Boolean isschsun;
	private Boolean isfirstinstance;
	private Boolean issecondinstance;
	private Boolean isthirdinstance;
	private Boolean isfourthinstance;
	private Boolean isfifthinstance;
	private Integer minint;
	private Integer roundatttime;
	private Integer lastappinterval;
	private ims.framework.utils.beans.TimeBean starttm;
	private ims.framework.utils.beans.TimeBean endtm;
	private ims.vo.LookupInstanceBean pasclinic;
	private Integer maxnoappts;
	private ims.scheduling.vo.beans.Profile_BookRightsVoBean[] bookingrights;
	private ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] listowners;
	private ims.scheduling.vo.beans.Profile_Exc_DateVoBean[] exclusiondates;
	private ims.scheduling.vo.beans.Profile_Exc_TimeVoBean[] exclusiontimes;
	private ims.vo.LookupInstanceBean consmediatype;
}
