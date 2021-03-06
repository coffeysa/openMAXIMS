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

package ims.ocrr.vo.beans;

public class SpecimenWorkListItemVoBean extends ims.vo.ValueObjectBean
{
	public SpecimenWorkListItemVoBean()
	{
	}
	public SpecimenWorkListItemVoBean(ims.ocrr.vo.SpecimenWorkListItemVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimen = vo.getSpecimen() == null ? null : new ims.vo.RefVoBean(vo.getSpecimen().getBoId(), vo.getSpecimen().getBoVersion());
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.datetocollect = vo.getDateToCollect() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateToCollect().getBean();
		this.roundtocollect = vo.getRoundToCollect() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoundToCollect().getBean();
		this.timetocollect = vo.getTimeToCollect() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeToCollect().getBean();
		this.collectionstatus = vo.getCollectionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCollectionStatus().getBean();
		this.dftorderinvestigation = vo.getDFTOrderInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getDFTOrderInvestigation().getBoId(), vo.getDFTOrderInvestigation().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.SpecimenWorkListItemVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimen = vo.getSpecimen() == null ? null : new ims.vo.RefVoBean(vo.getSpecimen().getBoId(), vo.getSpecimen().getBoVersion());
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.datetocollect = vo.getDateToCollect() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateToCollect().getBean();
		this.roundtocollect = vo.getRoundToCollect() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoundToCollect().getBean();
		this.timetocollect = vo.getTimeToCollect() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeToCollect().getBean();
		this.collectionstatus = vo.getCollectionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCollectionStatus().getBean();
		this.dftorderinvestigation = vo.getDFTOrderInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getDFTOrderInvestigation().getBoId(), vo.getDFTOrderInvestigation().getBoVersion());
	}

	public ims.ocrr.vo.SpecimenWorkListItemVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.SpecimenWorkListItemVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.SpecimenWorkListItemVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.SpecimenWorkListItemVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.SpecimenWorkListItemVo();
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
	public ims.vo.RefVoBean getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.vo.RefVoBean value)
	{
		this.specimen = value;
	}
	public ims.vo.LookupInstanceBean getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.vo.LookupInstanceBean value)
	{
		this.listtype = value;
	}
	public ims.framework.utils.beans.DateBean getDateToCollect()
	{
		return this.datetocollect;
	}
	public void setDateToCollect(ims.framework.utils.beans.DateBean value)
	{
		this.datetocollect = value;
	}
	public ims.vo.LookupInstanceBean getRoundToCollect()
	{
		return this.roundtocollect;
	}
	public void setRoundToCollect(ims.vo.LookupInstanceBean value)
	{
		this.roundtocollect = value;
	}
	public ims.framework.utils.beans.TimeBean getTimeToCollect()
	{
		return this.timetocollect;
	}
	public void setTimeToCollect(ims.framework.utils.beans.TimeBean value)
	{
		this.timetocollect = value;
	}
	public ims.vo.LookupInstanceBean getCollectionStatus()
	{
		return this.collectionstatus;
	}
	public void setCollectionStatus(ims.vo.LookupInstanceBean value)
	{
		this.collectionstatus = value;
	}
	public ims.vo.RefVoBean getDFTOrderInvestigation()
	{
		return this.dftorderinvestigation;
	}
	public void setDFTOrderInvestigation(ims.vo.RefVoBean value)
	{
		this.dftorderinvestigation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean specimen;
	private ims.vo.LookupInstanceBean listtype;
	private ims.framework.utils.beans.DateBean datetocollect;
	private ims.vo.LookupInstanceBean roundtocollect;
	private ims.framework.utils.beans.TimeBean timetocollect;
	private ims.vo.LookupInstanceBean collectionstatus;
	private ims.vo.RefVoBean dftorderinvestigation;
}
