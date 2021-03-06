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

package ims.core.forms.wardattender;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Scheduling = new SchedulingContext(context);
		RefMan = new RefManContext(context);
		ICP = new ICPContext(context);
		ChooseAndBook = new ChooseAndBookContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getWardAttenderSearchCriteriaIsNotNull()
		{
			return !cx_CoreWardAttenderSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.WardAttenderSearchCriteriaVo getWardAttenderSearchCriteria()
		{
			return (ims.core.vo.WardAttenderSearchCriteriaVo)cx_CoreWardAttenderSearchCriteria.getValue(context);
		}
		public void setWardAttenderSearchCriteria(ims.core.vo.WardAttenderSearchCriteriaVo value)
		{
			cx_CoreWardAttenderSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreWardAttenderSearchCriteria = new ims.framework.ContextVariable("Core.WardAttenderSearchCriteria", "_cvp_Core.WardAttenderSearchCriteria");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getSamlXmlIsNotNull()
		{
			return !cx_CoreSamlXml.getValueIsNull(context);
		}
		public String getSamlXml()
		{
			return (String)cx_CoreSamlXml.getValue(context);
		}
		public void setSamlXml(String value)
		{
			cx_CoreSamlXml.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSamlXml = new ims.framework.ContextVariable("Core.SamlXml", "_cv_Core.SamlXml");
		public boolean getWardViewPatientListWardIsNotNull()
		{
			return !cx_CoreWardViewPatientListWard.getValueIsNull(context);
		}
		public ims.core.resource.place.vo.LocationRefVo getWardViewPatientListWard()
		{
			return (ims.core.resource.place.vo.LocationRefVo)cx_CoreWardViewPatientListWard.getValue(context);
		}
		public void setWardViewPatientListWard(ims.core.resource.place.vo.LocationRefVo value)
		{
			cx_CoreWardViewPatientListWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreWardViewPatientListWard = new ims.framework.ContextVariable("Core.WardViewPatientListWard", "_cv_Core.WardViewPatientListWard");
		public boolean getCurrentInPatientListWardIsNotNull()
		{
			return !cx_CoreCurrentInPatientListWard.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getCurrentInPatientListWard()
		{
			return (ims.core.vo.LocationLiteVo)cx_CoreCurrentInPatientListWard.getValue(context);
		}
		public void setCurrentInPatientListWard(ims.core.vo.LocationLiteVo value)
		{
			cx_CoreCurrentInPatientListWard.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentInPatientListWard = new ims.framework.ContextVariable("Core.CurrentInPatientListWard", "_cv_Core.CurrentInPatientListWard");

		private ims.framework.Context context;
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBookingAppointmentIsNotNull()
		{
			return !cx_SchedulingBookingAppointment.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment()
		{
			return (ims.scheduling.vo.Booking_AppointmentVo)cx_SchedulingBookingAppointment.getValue(context);
		}
		public void setBookingAppointment(ims.scheduling.vo.Booking_AppointmentVo value)
		{
			cx_SchedulingBookingAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointment = new ims.framework.ContextVariable("Scheduling.BookingAppointment", "_cv_Scheduling.BookingAppointment");
		public boolean getApptCancelStatusIsNotNull()
		{
			return !cx_SchedulingApptCancelStatus.getValueIsNull(context);
		}
		public ims.scheduling.vo.Appointment_StatusVo getApptCancelStatus()
		{
			return (ims.scheduling.vo.Appointment_StatusVo)cx_SchedulingApptCancelStatus.getValue(context);
		}
		public void setApptCancelStatus(ims.scheduling.vo.Appointment_StatusVo value)
		{
			cx_SchedulingApptCancelStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingApptCancelStatus = new ims.framework.ContextVariable("Scheduling.ApptCancelStatus", "_cv_Scheduling.ApptCancelStatus");
		public boolean getLateArrivalRecordIsNotNull()
		{
			return !cx_SchedulingLateArrivalRecord.getValueIsNull(context);
		}
		public ims.scheduling.vo.LateTimeArrivalRecordVo getLateArrivalRecord()
		{
			return (ims.scheduling.vo.LateTimeArrivalRecordVo)cx_SchedulingLateArrivalRecord.getValue(context);
		}
		public void setLateArrivalRecord(ims.scheduling.vo.LateTimeArrivalRecordVo value)
		{
			cx_SchedulingLateArrivalRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingLateArrivalRecord = new ims.framework.ContextVariable("Scheduling.LateArrivalRecord", "_cv_Scheduling.LateArrivalRecord");
		public boolean getWardAttendanceIsNotNull()
		{
			return !cx_SchedulingWardAttendance.getValueIsNull(context);
		}
		public Boolean getWardAttendance()
		{
			return (Boolean)cx_SchedulingWardAttendance.getValue(context);
		}
		public void setWardAttendance(Boolean value)
		{
			cx_SchedulingWardAttendance.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingWardAttendance = new ims.framework.ContextVariable("Scheduling.WardAttendance", "_cv_Scheduling.WardAttendance");
		public boolean getBookingAppointmentRefIsNotNull()
		{
			return !cx_SchedulingBookingAppointmentRef.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getBookingAppointmentRef()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_SchedulingBookingAppointmentRef.getValue(context);
		}
		public void setBookingAppointmentRef(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_SchedulingBookingAppointmentRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointmentRef = new ims.framework.ContextVariable("Scheduling.BookingAppointmentRef", "_cv_Scheduling.BookingAppointmentRef");
		public boolean getBookingActivityIsNotNull()
		{
			return !cx_SchedulingBookingActivity.getValueIsNull(context);
		}
		public ims.core.resource.place.vo.ActivityRefVo getBookingActivity()
		{
			return (ims.core.resource.place.vo.ActivityRefVo)cx_SchedulingBookingActivity.getValue(context);
		}
		public void setBookingActivity(ims.core.resource.place.vo.ActivityRefVo value)
		{
			cx_SchedulingBookingActivity.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingActivity = new ims.framework.ContextVariable("Scheduling.BookingActivity", "_cv_Scheduling.BookingActivity");
		public boolean getBookingServiceIsNotNull()
		{
			return !cx_SchedulingBookingService.getValueIsNull(context);
		}
		public ims.core.clinical.vo.ServiceRefVo getBookingService()
		{
			return (ims.core.clinical.vo.ServiceRefVo)cx_SchedulingBookingService.getValue(context);
		}
		public void setBookingService(ims.core.clinical.vo.ServiceRefVo value)
		{
			cx_SchedulingBookingService.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingService = new ims.framework.ContextVariable("Scheduling.BookingService", "_cv_Scheduling.BookingService");
		public boolean getBookingSessionIsNotNull()
		{
			return !cx_SchedulingBookingSession.getValueIsNull(context);
		}
		public ims.scheduling.vo.Sch_SessionRefVo getBookingSession()
		{
			return (ims.scheduling.vo.Sch_SessionRefVo)cx_SchedulingBookingSession.getValue(context);
		}
		public void setBookingSession(ims.scheduling.vo.Sch_SessionRefVo value)
		{
			cx_SchedulingBookingSession.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingSession = new ims.framework.ContextVariable("Scheduling.BookingSession", "_cv_Scheduling.BookingSession");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getLinkedAppointmentsCollectionIsNotNull()
		{
			return !cx_RefManLinkedAppointmentsCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection getLinkedAppointmentsCollection()
		{
			return (ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection)cx_RefManLinkedAppointmentsCollection.getValue(context);
		}
		public void setLinkedAppointmentsCollection(ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection value)
		{
			cx_RefManLinkedAppointmentsCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManLinkedAppointmentsCollection = new ims.framework.ContextVariable("RefMan.LinkedAppointmentsCollection", "_cv_RefMan.LinkedAppointmentsCollection");
		public boolean getChosenTimeIsNotNull()
		{
			return !cx_RefManChosenTime.getValueIsNull(context);
		}
		public ims.framework.utils.Time getChosenTime()
		{
			return (ims.framework.utils.Time)cx_RefManChosenTime.getValue(context);
		}
		public void setChosenTime(ims.framework.utils.Time value)
		{
			cx_RefManChosenTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManChosenTime = new ims.framework.ContextVariable("RefMan.ChosenTime", "_cv_RefMan.ChosenTime");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");

		private ims.framework.Context context;
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientICPRecordIsNotNull()
		{
			return !cx_ICPPatientICPRecord.getValueIsNull(context);
		}
		public ims.icps.instantiation.vo.PatientICPRefVo getPatientICPRecord()
		{
			return (ims.icps.instantiation.vo.PatientICPRefVo)cx_ICPPatientICPRecord.getValue(context);
		}
		public void setPatientICPRecord(ims.icps.instantiation.vo.PatientICPRefVo value)
		{
			cx_ICPPatientICPRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPPatientICPRecord = new ims.framework.ContextVariable("ICP.PatientICPRecord", "_cv_ICP.PatientICPRecord");

		private ims.framework.Context context;
	}
	public final class ChooseAndBookContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ChooseAndBookContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getisCABApptIsNotNull()
		{
			return !cx_ChooseAndBookisCABAppt.getValueIsNull(context);
		}
		public Boolean getisCABAppt()
		{
			return (Boolean)cx_ChooseAndBookisCABAppt.getValue(context);
		}
		public void setisCABAppt(Boolean value)
		{
			cx_ChooseAndBookisCABAppt.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ChooseAndBookisCABAppt = new ims.framework.ContextVariable("ChooseAndBook.isCABAppt", "_cv_ChooseAndBook.isCABAppt");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public SchedulingContext Scheduling;
	public RefManContext RefMan;
	public ICPContext ICP;
	public ChooseAndBookContext ChooseAndBook;
}
