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

package ims.icp.forms.patienticp;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		ICP = new ICPContext(context);
		Core = new CoreContext(context);
		RefMan = new RefManContext(context);
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getHardcodedDataAddedIsNotNull()
		{
			return !cx_ICPHardcodedDataAdded.getValueIsNull(context);
		}
		public Boolean getHardcodedDataAdded()
		{
			return (Boolean)cx_ICPHardcodedDataAdded.getValue(context);
		}
		public void setHardcodedDataAdded(Boolean value)
		{
			cx_ICPHardcodedDataAdded.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPHardcodedDataAdded = new ims.framework.ContextVariable("ICP.HardcodedDataAdded", "_cv_ICP.HardcodedDataAdded");
		public boolean getICPListIsNotNull()
		{
			return !cx_ICPICPList.getValueIsNull(context);
		}
		public ims.icp.vo.ICPVoCollection getICPList()
		{
			return (ims.icp.vo.ICPVoCollection)cx_ICPICPList.getValue(context);
		}
		public void setICPList(ims.icp.vo.ICPVoCollection value)
		{
			cx_ICPICPList.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPICPList = new ims.framework.ContextVariable("ICP.ICPList", "_cv_ICP.ICPList");
		public boolean getEvaluationNoteIsNotNull()
		{
			return !cx_ICPEvaluationNote.getValueIsNull(context);
		}
		public ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo getEvaluationNote()
		{
			return (ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo)cx_ICPEvaluationNote.getValue(context);
		}
		public void setEvaluationNote(ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo value)
		{
			cx_ICPEvaluationNote.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPEvaluationNote = new ims.framework.ContextVariable("ICP.EvaluationNote", "_cv_ICP.EvaluationNote");
		public boolean getStagesIsNotNull()
		{
			return !cx_ICPStages.getValueIsNull(context);
		}
		public ims.icp.vo.ICPStageVoCollection getStages()
		{
			return (ims.icp.vo.ICPStageVoCollection)cx_ICPStages.getValue(context);
		}
		public void setStages(ims.icp.vo.ICPStageVoCollection value)
		{
			cx_ICPStages.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPStages = new ims.framework.ContextVariable("ICP.Stages", "_cv_ICP.Stages");
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
		public boolean getActionStatusIsNotNull()
		{
			return !cx_ICPActionStatus.getValueIsNull(context);
		}
		public ims.icp.vo.PatientICPActionStatusVo getActionStatus()
		{
			return (ims.icp.vo.PatientICPActionStatusVo)cx_ICPActionStatus.getValue(context);
		}
		public void setActionStatus(ims.icp.vo.PatientICPActionStatusVo value)
		{
			cx_ICPActionStatus.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPActionStatus = new ims.framework.ContextVariable("ICP.ActionStatus", "_cv_ICP.ActionStatus");
		public boolean getTypeToSelectIsNotNull()
		{
			return !cx_ICPTypeToSelect.getValueIsNull(context);
		}
		public String getTypeToSelect()
		{
			return (String)cx_ICPTypeToSelect.getValue(context);
		}
		public void setTypeToSelect(String value)
		{
			cx_ICPTypeToSelect.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPTypeToSelect = new ims.framework.ContextVariable("ICP.TypeToSelect", "_cv_ICP.TypeToSelect");
		public boolean getPatientCriticalEventIsNotNull()
		{
			return !cx_ICPPatientCriticalEvent.getValueIsNull(context);
		}
		public ims.icps.instantiation.vo.PatientCriticalEventsRefVo getPatientCriticalEvent()
		{
			return (ims.icps.instantiation.vo.PatientCriticalEventsRefVo)cx_ICPPatientCriticalEvent.getValue(context);
		}
		public void setPatientCriticalEvent(ims.icps.instantiation.vo.PatientCriticalEventsRefVo value)
		{
			cx_ICPPatientCriticalEvent.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPPatientCriticalEvent = new ims.framework.ContextVariable("ICP.PatientCriticalEvent", "_cv_ICP.PatientCriticalEvent");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");
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
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

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

	public ICPContext ICP;
	public CoreContext Core;
	public RefManContext RefMan;
}
