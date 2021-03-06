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

public class SpecimenWorkListitemCustomVoBean extends ims.vo.ValueObjectBean
{
	public SpecimenWorkListitemCustomVoBean()
	{
	}
	public SpecimenWorkListitemCustomVoBean(ims.ocrr.vo.SpecimenWorkListitemCustomVo vo)
	{
		this.worklistitemid = vo.getWorkListitemId();
		this.instructionstocollector = vo.getInstructionsToCollector();
		this.serviceid = vo.getServiceId();
		this.servicename = vo.getServiceName();
		this.investigation = vo.getInvestigation();
		this.patientid = vo.getPatientId();
		this.patientsurname = vo.getPatientSurname();
		this.patientforename = vo.getPatientForename();
		this.wardid = vo.getWardId();
		this.ward = vo.getWard();
		this.containerquantity = vo.getContainerQuantity();
		this.adultcontainer = vo.getAdultContainer();
		this.collectionstatus = vo.getCollectionStatus();
		this.collector = vo.getCollector();
		this.collectiondatetime = vo.getCollectionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollectionDateTime().getBean();
		this.collectioncomments = vo.getCollectionComments();
		this.collectingmos = vo.getCollectingMos();
		this.specimencontainerid = vo.getSpecimenContainerId();
		this.paediatriccontainer = vo.getPaediatricContainer();
		this.paediatriccontainerid = vo.getPaediatricContainerId();
		this.adultvolume = vo.getAdultVolume();
		this.paediatricvolume = vo.getPaediatricVolume();
		this.dftnooflabelsets = vo.getDftNoOfLabelSets();
		this.containeradultvolume = vo.getContainerAdultVolume();
		this.containerpaediatricvolume = vo.getContainerPaediatricVolume();
		this.orderspecimenid = vo.getOrderSpecimenId();
		this.placerordnum = vo.getPlacerOrdNum();
		this.orderinvestigationid = vo.getOrderInvestigationId();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.SpecimenWorkListitemCustomVo vo)
	{
		this.worklistitemid = vo.getWorkListitemId();
		this.instructionstocollector = vo.getInstructionsToCollector();
		this.serviceid = vo.getServiceId();
		this.servicename = vo.getServiceName();
		this.investigation = vo.getInvestigation();
		this.patientid = vo.getPatientId();
		this.patientsurname = vo.getPatientSurname();
		this.patientforename = vo.getPatientForename();
		this.wardid = vo.getWardId();
		this.ward = vo.getWard();
		this.containerquantity = vo.getContainerQuantity();
		this.adultcontainer = vo.getAdultContainer();
		this.collectionstatus = vo.getCollectionStatus();
		this.collector = vo.getCollector();
		this.collectiondatetime = vo.getCollectionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollectionDateTime().getBean();
		this.collectioncomments = vo.getCollectionComments();
		this.collectingmos = vo.getCollectingMos();
		this.specimencontainerid = vo.getSpecimenContainerId();
		this.paediatriccontainer = vo.getPaediatricContainer();
		this.paediatriccontainerid = vo.getPaediatricContainerId();
		this.adultvolume = vo.getAdultVolume();
		this.paediatricvolume = vo.getPaediatricVolume();
		this.dftnooflabelsets = vo.getDftNoOfLabelSets();
		this.containeradultvolume = vo.getContainerAdultVolume();
		this.containerpaediatricvolume = vo.getContainerPaediatricVolume();
		this.orderspecimenid = vo.getOrderSpecimenId();
		this.placerordnum = vo.getPlacerOrdNum();
		this.orderinvestigationid = vo.getOrderInvestigationId();
	}

	public ims.ocrr.vo.SpecimenWorkListitemCustomVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.SpecimenWorkListitemCustomVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.SpecimenWorkListitemCustomVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.SpecimenWorkListitemCustomVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.SpecimenWorkListitemCustomVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getWorkListitemId()
	{
		return this.worklistitemid;
	}
	public void setWorkListitemId(Integer value)
	{
		this.worklistitemid = value;
	}
	public String getInstructionsToCollector()
	{
		return this.instructionstocollector;
	}
	public void setInstructionsToCollector(String value)
	{
		this.instructionstocollector = value;
	}
	public Integer getServiceId()
	{
		return this.serviceid;
	}
	public void setServiceId(Integer value)
	{
		this.serviceid = value;
	}
	public String getServiceName()
	{
		return this.servicename;
	}
	public void setServiceName(String value)
	{
		this.servicename = value;
	}
	public String getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(String value)
	{
		this.investigation = value;
	}
	public Integer getPatientId()
	{
		return this.patientid;
	}
	public void setPatientId(Integer value)
	{
		this.patientid = value;
	}
	public String getPatientSurname()
	{
		return this.patientsurname;
	}
	public void setPatientSurname(String value)
	{
		this.patientsurname = value;
	}
	public String getPatientForename()
	{
		return this.patientforename;
	}
	public void setPatientForename(String value)
	{
		this.patientforename = value;
	}
	public Integer getWardId()
	{
		return this.wardid;
	}
	public void setWardId(Integer value)
	{
		this.wardid = value;
	}
	public String getWard()
	{
		return this.ward;
	}
	public void setWard(String value)
	{
		this.ward = value;
	}
	public Integer getContainerQuantity()
	{
		return this.containerquantity;
	}
	public void setContainerQuantity(Integer value)
	{
		this.containerquantity = value;
	}
	public String getAdultContainer()
	{
		return this.adultcontainer;
	}
	public void setAdultContainer(String value)
	{
		this.adultcontainer = value;
	}
	public Integer getCollectionStatus()
	{
		return this.collectionstatus;
	}
	public void setCollectionStatus(Integer value)
	{
		this.collectionstatus = value;
	}
	public String getCollector()
	{
		return this.collector;
	}
	public void setCollector(String value)
	{
		this.collector = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCollectionDateTime()
	{
		return this.collectiondatetime;
	}
	public void setCollectionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.collectiondatetime = value;
	}
	public String getCollectionComments()
	{
		return this.collectioncomments;
	}
	public void setCollectionComments(String value)
	{
		this.collectioncomments = value;
	}
	public Integer getCollectingMos()
	{
		return this.collectingmos;
	}
	public void setCollectingMos(Integer value)
	{
		this.collectingmos = value;
	}
	public Integer getSpecimenContainerId()
	{
		return this.specimencontainerid;
	}
	public void setSpecimenContainerId(Integer value)
	{
		this.specimencontainerid = value;
	}
	public String getPaediatricContainer()
	{
		return this.paediatriccontainer;
	}
	public void setPaediatricContainer(String value)
	{
		this.paediatriccontainer = value;
	}
	public Integer getPaediatricContainerId()
	{
		return this.paediatriccontainerid;
	}
	public void setPaediatricContainerId(Integer value)
	{
		this.paediatriccontainerid = value;
	}
	public Float getAdultVolume()
	{
		return this.adultvolume;
	}
	public void setAdultVolume(Float value)
	{
		this.adultvolume = value;
	}
	public Float getPaediatricVolume()
	{
		return this.paediatricvolume;
	}
	public void setPaediatricVolume(Float value)
	{
		this.paediatricvolume = value;
	}
	public Integer getDftNoOfLabelSets()
	{
		return this.dftnooflabelsets;
	}
	public void setDftNoOfLabelSets(Integer value)
	{
		this.dftnooflabelsets = value;
	}
	public Float getContainerAdultVolume()
	{
		return this.containeradultvolume;
	}
	public void setContainerAdultVolume(Float value)
	{
		this.containeradultvolume = value;
	}
	public Float getContainerPaediatricVolume()
	{
		return this.containerpaediatricvolume;
	}
	public void setContainerPaediatricVolume(Float value)
	{
		this.containerpaediatricvolume = value;
	}
	public Integer getOrderSpecimenId()
	{
		return this.orderspecimenid;
	}
	public void setOrderSpecimenId(Integer value)
	{
		this.orderspecimenid = value;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public void setPlacerOrdNum(String value)
	{
		this.placerordnum = value;
	}
	public Integer getOrderInvestigationId()
	{
		return this.orderinvestigationid;
	}
	public void setOrderInvestigationId(Integer value)
	{
		this.orderinvestigationid = value;
	}

	private Integer worklistitemid;
	private String instructionstocollector;
	private Integer serviceid;
	private String servicename;
	private String investigation;
	private Integer patientid;
	private String patientsurname;
	private String patientforename;
	private Integer wardid;
	private String ward;
	private Integer containerquantity;
	private String adultcontainer;
	private Integer collectionstatus;
	private String collector;
	private ims.framework.utils.beans.DateTimeBean collectiondatetime;
	private String collectioncomments;
	private Integer collectingmos;
	private Integer specimencontainerid;
	private String paediatriccontainer;
	private Integer paediatriccontainerid;
	private Float adultvolume;
	private Float paediatricvolume;
	private Integer dftnooflabelsets;
	private Float containeradultvolume;
	private Float containerpaediatricvolume;
	private Integer orderspecimenid;
	private String placerordnum;
	private Integer orderinvestigationid;
}
