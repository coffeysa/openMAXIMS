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

package ims.RefMan.vo.beans;

public class TransportBookingDisplayVoBean extends ims.vo.ValueObjectBean
{
	public TransportBookingDisplayVoBean()
	{
	}
	public TransportBookingDisplayVoBean(ims.RefMan.vo.TransportBookingDisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datebooked = vo.getDateBooked() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateBooked().getBean();
		this.bookingreference = vo.getBookingReference();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.TransportBookingDisplayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datebooked = vo.getDateBooked() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateBooked().getBean();
		this.bookingreference = vo.getBookingReference();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
	}

	public ims.RefMan.vo.TransportBookingDisplayVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.TransportBookingDisplayVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.TransportBookingDisplayVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.TransportBookingDisplayVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.TransportBookingDisplayVo();
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
	public ims.framework.utils.beans.DateBean getDateBooked()
	{
		return this.datebooked;
	}
	public void setDateBooked(ims.framework.utils.beans.DateBean value)
	{
		this.datebooked = value;
	}
	public String getBookingReference()
	{
		return this.bookingreference;
	}
	public void setBookingReference(String value)
	{
		this.bookingreference = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.scheduling.vo.beans.Booking_AppointmentTransportVoBean[] getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.scheduling.vo.beans.Booking_AppointmentTransportVoBean[] value)
	{
		this.appointments = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean datebooked;
	private String bookingreference;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.RefVoBean carecontext;
	private ims.scheduling.vo.beans.Booking_AppointmentTransportVoBean[] appointments;
}
