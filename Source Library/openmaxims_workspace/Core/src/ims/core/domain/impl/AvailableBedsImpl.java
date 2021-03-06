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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.66 build 3261.22124)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.domain.objects.BedSpaceState;
import ims.core.domain.WardView;
import ims.core.domain.base.impl.BaseAvailableBedsImpl;
import ims.core.layout.vo.BedSpaceRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.AvailableBedsVo;
import ims.core.vo.BedSpaceStateLiteVo;
import ims.core.vo.BedSpaceStateLiteVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.BedSpaceStateLiteVoAssembler;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvailableBedsImpl extends BaseAvailableBedsImpl
{

	private static final long serialVersionUID = 1L;

	public BedSpaceStateLiteVoCollection listAvailableBeds(AvailableBedsVo bedDetails)
	{
		if (bedDetails == null)
			throw new CodingRuntimeException("Invalid bedDetails filter");


		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();
		LocationLiteVoCollection wards = null;

		StringBuffer sb = new StringBuffer();
		String andStr = "";

		String hql = ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS") ? "SELECT bss, wc.wardStatus from BedSpaceState as bss, WardBayConfig as wc left join wc.ward as wcward " : "from BedSpaceState as bss"; 

		//WDEV-18064
		sb.append(andStr + "bss.bay.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);
		andStr = " and ";
		
		if (bedDetails.getBedStatusIsNotNull())
		{
			sb.append(andStr + "bss.currentBedStatus.bedStatus = :bedstat");
			markers.add("bedstat");
			values.add(getDomLookup(bedDetails.getBedStatus()));
			andStr = " and ";
		}
	
		if (bedDetails.getWardIsNotNull())
		{
			sb.append(andStr + " bss.ward.id = :ward");
			markers.add("ward");
			values.add(bedDetails.getWard().getID_Location());
			andStr = " and ";
		}
		else if (bedDetails.getHospitalIsNotNull())
		{
			wards = listWards(bedDetails.getHospital().getID_Location(), null);
			if (wards.size() > 0)
			{	
				sb.append(andStr + " (bss.ward.id in " + getWardIds(wards));
				sb.append(" OR ");
			}
			sb.append((wards.size() > 0 ? "" : andStr) + " bss.ward.parentLocation.id = :hosp" + (wards.size() > 0 ? ")" : ""));
			markers.add("hosp");
			values.add(bedDetails.getHospital().getID_Location());
			andStr = " and ";
		}
			
		if (bedDetails.getWardTypeIsNotNull())
		{
			sb.append(andStr + " bss.bedSpace.wardType = :wardT");
			markers.add("wardT");
			values.add(getDomLookup(bedDetails.getWardType()));
			andStr = " and ";
		}
			
		if (bedDetails.getBedTypeIsNotNull())
		{
			sb.append(andStr + " bss.bedSpace.bedSpaceType = :bst");
			markers.add("bst");
			values.add(getDomLookup(bedDetails.getBedType()));
			andStr = " and ";
		}

		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		//WDEV-8096 - the following code will only show beds etc that are in active floorlayout records
		//WDEV-21488 - query for hierarchical location levels 
		String extra = "";
		extra += " and bss.bedSpace.id in (" + "select bedSpace.id from BayConfig as bayConf left join bayConf.bay as bay left join bayConf.floorBedSpaceLayout as fbsl left join fbsl.bedSpaces as bedSpace where fbsl.status = :activeStatus"; 
		if (bedDetails.getWardIsNotNull() || bedDetails.getHospitalIsNotNull())
		{				
			if (bedDetails.getWardIsNotNull())
			{
				extra += " and bay.parentLocation.id = :idWard";
				markers.add("idWard");
				values.add(bedDetails.getWard().getID());
			}
			else if (bedDetails.getHospitalIsNotNull())
			{				
				if (wards == null || wards.size() == 0)
				{
					markers.add("idHosp");
					values.add(bedDetails.getHospital().getID_Location());
				}
				//WDEV-22223
				extra += (wards != null && wards.size() > 0 ? " and (" : "") +  (wards != null && wards.size() > 0 ?  "bay.parentLocation.id IN " +  getWardIds(wards) : " OR bay.parentLocation.parentLocation.id = :idHosp") + ")";
			}
		}
		extra += ")";
				
		sb.append(extra);
		markers.add("activeStatus");
		values.add(getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		if (ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS")) //WDEV-20328
		{
			sb.append(andStr + "bss.ward.id = wcward.id");
		}
		sb.append(" ORDER BY bss.ward.name" );
		
		if(andStr == " and ")
			hql += " where ";
		
		hql += sb.toString();
		//WDEV-20328
		if (ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS")) //WDEV-20328
		{
			List<?> results = getDomainFactory().find(hql.toString(), markers, values);
			BedSpaceStateLiteVoCollection collResults = new BedSpaceStateLiteVoCollection();
			if (results == null || results.isEmpty())
				return null;
			for (int i = 0; i<results.size();i++)
			{
				if (results.get(i) instanceof Object[])
				{
					Object[] ret = (Object[]) results.get(i);
					BedSpaceStateLiteVo vo = new BedSpaceStateLiteVo();
					if (ret[0] instanceof BedSpaceState)
					{	
						vo = BedSpaceStateLiteVoAssembler.create((BedSpaceState) ret[0]);
					}
					if (ret[1] instanceof LookupInstance)
					{	
						vo.setWardStatus(ims.core.vo.lookups.LookupHelper.getWardBayStatusInstance(getLookupService(), ((LookupInstance) ret[1]).getId()));
					}
					collResults.add(vo);					
				}					
			}
			return collResults;
		}
		return BedSpaceStateLiteVoAssembler.createBedSpaceStateLiteVoCollectionFromBedSpaceState(getDomainFactory().find(hql.toString(), markers, values));
	}
	private String getWardIds(LocationLiteVoCollection wards)
	{
		if (wards == null || wards.size() == 0)
			return "";
		
		StringBuilder idList = new StringBuilder();
		idList.append("(");
		for (int i=0; i<wards.size();i++)
		{
			if (wards.get(i) == null)
				continue;
			idList.append(wards.get(i).getID_Location().toString()).append(i == wards.size() - 1 ? ")": ", ");			
		}
		
		return idList.toString();
	}
	public LocationLiteVoCollection listActiveHospitalsLite() 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();		
	}

	public LocationLiteVoCollection listWards(Integer hospitalID, String searchName) 
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocationRefVo voRef = new LocationRefVo();
		voRef.setID_Location(hospitalID);
		return implLoc.listActiveWardsForHospitalByNameLite(voRef, searchName);
	}

	public BedSpaceStateLiteVo getBedSpaceState(BedSpaceRefVo bed) 
	{
		if(bed == null )
			throw new DomainRuntimeException("Invalid BedRefVo");

		DomainFactory factory = getDomainFactory();
		BedSpaceState domBed = (BedSpaceState) factory.getDomainObject(BedSpaceState.class, bed.getID_BedSpace());
		return BedSpaceStateLiteVoAssembler.create(domBed);
	}

	public LocMostVo getLocation(LocationRefVo voLocRef) 
	{
		DomainFactory factory = getDomainFactory();
		return LocMostVoAssembler.create((Location) factory.getDomainObject(Location.class, voLocRef.getID_Location()));
	}

	public BedSpaceStateLiteVo getBedSpaceState(BedSpaceStateLiteVo bed) 
	{
		if(bed == null )
			throw new DomainRuntimeException("Invalid BedRefVo");

		DomainFactory factory = getDomainFactory();
		BedSpaceState domBed = (BedSpaceState) factory.getDomainObject(BedSpaceState.class, bed.getID_BedSpaceState());
		return BedSpaceStateLiteVoAssembler.create(domBed);
	}

	public BedSpaceStateLiteVo saveBedSpaceState(BedSpaceStateLiteVo voBSS) throws DomainInterfaceException, StaleObjectException 
	{
		if (!voBSS.isValidated())
			throw new CodingRuntimeException("BedSpaceStateLiteVo Record has not been validated");
		if(voBSS == null)
			throw new CodingRuntimeException("Cannot save null BedSpaceStateLiteVo");
		
		DomainFactory factory = getDomainFactory();
		
		BedSpaceState doBSS = BedSpaceStateLiteVoAssembler.extractBedSpaceState(factory, voBSS);
		factory.save(doBSS);
		return (BedSpaceStateLiteVoAssembler.create(doBSS));		
	}

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;		
	}
	
	//WDEV-20707
	public LocationLiteVo getCurrentHospital(ILocation location) 
	{
		WardView impl = (WardView)getDomainImpl(WardViewImpl.class);
		return impl.getCurrentHospital(location);
	}
}
