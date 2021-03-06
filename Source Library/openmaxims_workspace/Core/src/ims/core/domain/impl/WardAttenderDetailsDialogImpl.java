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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.base.impl.BaseWardAttenderDetailsDialogImpl;
import ims.core.vo.WardAttenderOutcomeVo;
import ims.core.vo.domain.WardAttenderOutcomeVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.Booking_AppointmentRefVo;

public class WardAttenderDetailsDialogImpl extends BaseWardAttenderDetailsDialogImpl
{

	private static final long serialVersionUID = 1L;

	public WardAttenderOutcomeVo getAppointment(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null || appointment.getID_Booking_Appointment() == null)
			return null;
		
		return WardAttenderOutcomeVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(Booking_Appointment.class, appointment.getID_Booking_Appointment()));
	}

	public void saveBookingAppointment(WardAttenderOutcomeVo appointment) throws StaleObjectException
	{
		if (appointment == null)
			throw new CodingRuntimeException("Appointment is null in method saveBookingAppointment");
		
		if (!appointment.isValidated())
			throw new CodingRuntimeException("Appointment has not been validated in method saveBookingAppointment");
		
		DomainFactory factory = getDomainFactory();
		
		Booking_Appointment doAppointment = WardAttenderOutcomeVoAssembler.extractBooking_Appointment(factory, appointment);
		factory.save(doAppointment);
	}

}
