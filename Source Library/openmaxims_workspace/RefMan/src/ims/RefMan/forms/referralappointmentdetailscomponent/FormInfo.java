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

package ims.RefMan.forms.referralappointmentdetailscomponent;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "RefMan";
	}
	public String getFormName()
	{
		return "ReferralAppointmentDetailsComponent";
	}
	public int getWidth()
	{
		return 864;
	}
	public int getHeight()
	{
		return 560;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_Scheduling.BookingAppointment", "_cv_Scheduling.BookingService", "_cv_Scheduling.BookingSession", "_cv_Scheduling.ApptCancelStatus", "_cv_OCRR.CurrentPathRadResult", "_cv_OCRR.ResultDisplayDate", "_cv_RefMan.SpecimenWorkListItems", "_cv_RefMan.EnterAppointmentDetails.ApptDate", "_cv_Scheduling.TheatreConsultant", "_cv_Scheduling.TheatreProcedure", "_cv_Scheduling.TheatreService", "_cv_Scheduling.TheatreAppointment", "_cv_Scheduling.BookingActivity", "_cv_RefMan.SpecimenWorkListItem", "_cv_Rotherham.BookedAppointments", "_cv_Scheduling.TheatreType", "_cv_OCRR.ReferralAppointmentDetailsOcsOrderVoCollection", "_cv_RefMan.OrderingHCP", "_cv_Scheduling.WardAttendance", "_cv_RefMan.CatsRefConsultationActivityRequired", "_cv_Scheduling.BookingListType", "_cv_Scheduling.BookingLocation", "_cv_Scheduling.BookingHospital", "_cv_Scheduling.BookingListOwner", "_cv_RefMan.TheatreBookingAppointment", "_cv_OCRR.PathologyResults.Order", "_cv_Core.SamlXml", "_cv_Rotherham.AppointmentToLink", "_cv_ChooseAndBook.isCABAppt", "_cv_Scheduling.BookingAppointmentRef", "_cv_RefMan.TCIOutcomeForPatientElectiveList", "_cv_Scheduling.FutureAppointmentRemoval", "_cv_Scheduling.PendingEmergencyTheatre", "_cv_Scheduling.PendingEmergencyTheatreRemoval", "_cv_RefMan.AppointmentSaved", "_cv_RefMan.PELProcedureDetailsForBooking", "_cv_Core.ImsReportId", "_cv_RefMan.PatientElectiveListAddLaterVo", "_cv_Scheduling.FutureAppointmentDetails", "_cv_Scheduling.ServiceFunctionRef", "_cv_RefMan.SelectedBookAppointmentForPrint", "_cv_Scheduling.BookingUrgency", "_cv_RefMan.PatientElectiveListRef", "_cv_RefMan.LinkedAppointmentsCollection", "_cv_Core.CommentDialogString", "_cv_Core.CommentDialogTitle" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.ReferralAppointmentDetailsComponent.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[0];
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
