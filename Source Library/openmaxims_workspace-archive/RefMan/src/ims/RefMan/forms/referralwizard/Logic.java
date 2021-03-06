// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.62 build 3121.18691)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.referralwizard;

import ims.RefMan.forms.referralwizard.GenForm.lyrPageLayer.tabPayorContainer.Group1Enumeration;
import ims.RefMan.vo.CatsReferralStatusVo;
import ims.RefMan.vo.CatsReferralStatusVoCollection;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.enums.CALLINGFORM;
import ims.RefMan.vo.lookups.AdditionalInvestigationAppointmentsStatus;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareContextVoCollection;
import ims.core.vo.CareSpellVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.EpisodeofCareVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.ServiceVo;
import ims.core.vo.enums.DocumentViewLevel;
import ims.core.vo.enums.PatientSearchEvent;
import ims.core.vo.enums.UploadDocumentStoreLevel;
import ims.core.vo.lookups.CareSpelltoEpisodeRelationship;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.ReferralManagementContractType;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.LayerBridge;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
		updateControlState();
		manageTabs();
	}
	@Override
	protected void onFormModeChanged() 
	{
		form.lyrPage().tabPageReferral().ccReferralDetails().setMode(form.getMode());
		form.lyrPage().tabPageDemographics().ccDemographics().setMode(form.getMode());
		updateControlState();
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
		clearInstanceControls();
		if(form.getGlobalContext().Core.getPatientShortIsNotNull())
			form.getGlobalContext().Core.setPatientShort(null);
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editInstance();
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{	
		if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue() &&
				(form.lyrPage().tabPageReferral().isVisible() || form.lyrPage().tabPayor().isVisible() || form.lyrPage().tabContractDetails().isVisible()))
		{
			if (form.lyrPage().tabPageReferral().isVisible())
			{
				form.lyrPage().showtabPayor();
				
				form.lyrPage().settabPageDemographicsEnabled(true);
				form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
				
				form.lyrPage().settabPageReferralEnabled(true);
				form.lyrPage().tabPageReferral().setHeaderEnabled(true);
				
				if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue())
				{
					form.lyrPage().settabPayorEnabled(true);
					form.lyrPage().tabPayor().setHeaderEnabled(true);
				
					form.lyrPage().settabContractDetailsEnabled(false);
					form.lyrPage().tabContractDetails().setHeaderEnabled(false);
				}
				
				form.lyrPage().settabPageLetterEnabled(false);
				form.lyrPage().tabPageLetter().setHeaderEnabled(false);
				
				form.btnSave().setText("Next");			
			}		
			else if (form.lyrPage().tabPayor().isVisible())
			{
				form.lyrPage().showtabContractDetails();
				
				form.lyrPage().settabPageDemographicsEnabled(true);
				form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
				
				form.lyrPage().settabPageReferralEnabled(true);
				form.lyrPage().tabPageReferral().setHeaderEnabled(true);
				
				if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue())
				{
					form.lyrPage().settabPayorEnabled(true);
					form.lyrPage().tabPayor().setHeaderEnabled(true);
					
					form.lyrPage().settabContractDetailsEnabled(true);
					form.lyrPage().tabContractDetails().setHeaderEnabled(true);
				}
				
				form.lyrPage().settabPageLetterEnabled(false);
				form.lyrPage().tabPageLetter().setHeaderEnabled(false);
				
				form.btnSave().setText("Next");
			}			
			else if (form.lyrPage().tabContractDetails().isVisible())
			{
				form.lyrPage().showtabPageLetter();
				
				form.lyrPage().settabPageDemographicsEnabled(true);
				form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
				
				form.lyrPage().settabPageReferralEnabled(true);
				form.lyrPage().tabPageReferral().setHeaderEnabled(true);
				
				if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue())
				{
					form.lyrPage().settabPayorEnabled(true);
					form.lyrPage().tabPayor().setHeaderEnabled(true);
				
					form.lyrPage().settabContractDetailsEnabled(true);
					form.lyrPage().tabContractDetails().setHeaderEnabled(true);
				}
				
				form.lyrPage().settabPageLetterEnabled(true);
				form.lyrPage().tabPageLetter().setHeaderEnabled(true);						
				
				onlyrPageTabChanged((form.lyrPage().tabPageLetter()));
			}
			
			if (save())
			{
				open();	
				manageTabs();		
			}
			
			if (form.lyrPage().tabPageLetter().isVisible()) 
				form.btnSave().setText("Save");
			else
				form.btnSave().setText("Next");
			return;
		}	
		
		if (form.lyrPage().tabPagePatientSearch().isVisible() //wdev-7905
			&& ( (form.getGlobalContext().Core.getPatientShort() == null
					&& ! form.getLocalContext().getbDemographicsSaved())
				|| (form.getGlobalContext().Core.getPatientShort() != null
					&& form.getLocalContext().getbDemographicsSaved()))
			&& form.getGlobalContext().RefMan.getCatsReferral() == null
			)
		{
			form.getLocalContext().setbDemographicsSaved(Boolean.FALSE);

			form.lyrPage().settabPageDemographicsEnabled(true);
			form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
			form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
			form.lyrPage().showtabPageDemographics();

			return;
		}
		
		if ( ! form.getLocalContext().getbDemographicsSaved() 
			&& ( (form.getGlobalContext().Core.getPatientShort() == null)
				|| (form.getGlobalContext().Core.getPatientShortIsNotNull()
						&& form.getGlobalContext().RefMan.getCatsReferral() == null)) 
				|| form.lyrPage().tabPageDemographics().isVisible())
		{
			Boolean bReturn = form.lyrPage().tabPageDemographics().ccDemographics().savePatientDemographics();
			
			if (form.getGlobalContext().Core.getPatientShortIsNotNull() && bReturn)
			{
				form.getLocalContext().setbDemographicsSaved(Boolean.TRUE); 
				form.lyrPage().tabPageReferral().ccReferralDetails().setPatientsGp(domain.getPatientsGp(form.getGlobalContext().Core.getPatientShort().getID_Patient()));
				manageTabs();
				form.lyrPage().showtabPageReferral();
			}
			else
			{
				form.getLocalContext().setbDemographicsSaved(Boolean.FALSE);

				form.lyrPage().settabPageDemographicsEnabled(true);
				form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
				form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
				form.lyrPage().showtabPageDemographics();
			}

			
			return;
		}
		
		if (form.getGlobalContext().RefMan.getCatsReferral() == null)
		{
			if (save())
			{
				open();		
				if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue())
				{
					if(isDialog())
					{
						engine.close(DialogResult.OK);
					}
					
					return;
				}
				
				
				manageTabs();				
				form.lyrPage().showtabPageLetter();
			}			
			return;
		}
		
		if(save())		
		{
			if(isDialog())
				engine.close(DialogResult.OK);
			else
				open();		
			
			updateControlState();
			manageTabs();
		}
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{		
		cancel();
		
	}	
	

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		open();
	}
	
	private void initialize()
	{
		form.lyrPage().tabPagePatientSearch().ccPatientSearch().initialize(true);
		form.lyrPage().tabPageReferral().ccReferralDetails().initialize(CALLINGFORM.REFERRALWIZARD);
		//form.lyrPage().tabPageLetter().ccUploadDoc().initialize();
		form.lyrPage().tabPageDemographics().ccDemographics().initialize();
		
		form.getLocalContext().setbDemographicsSaved(Boolean.FALSE);
		
		form.getGlobalContext().RefMan.setCatsReferralWizard(null);

		form.lyrPage().tabPageReferral().ccReferralDetails().setCreationMode(Boolean.TRUE);
	}
	
	public void open() throws FormOpenException
	{
		if(isDialog())
			form.setMode(FormMode.EDIT);
		else
			form.setMode(FormMode.VIEW);

		
		if(form.getGlobalContext().RefMan.getCatsReferralIsNotNull())
		{
			CatsReferralWizardVo record = domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral());
			form.getLocalContext().setRecord(record);
			
			if(record != null)
				populateScreenFromData(form.getLocalContext().getRecord());
		}	
		else if(form.getGlobalContext().Core.getPatientShortIsNotNull())
		{
			Patient patVo = null;
			try 
			{
				patVo = domain.getPatient(form.getGlobalContext().Core.getPatientShort());
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.toString());
				return;
			}
			form.getLocalContext().setRecord(new CatsReferralWizardVo());
				
				
			if(patVo != null)
				populateScreenFromData(patVo);
		}	
		else
		{		
			clearInstanceControls();
		}
	}
	
	private void populateScreenFromData(Patient patVo) 
	{
		clearInstanceControls();
		if(patVo == null)
			return;
		
		form.lyrPage().tabPageReferral().ccReferralDetails().setValue(null, null);
		form.lyrPage().tabPageDemographics().ccDemographics().setValue(patVo);
	}

	private void populateScreenFromData(CatsReferralWizardVo record) 
	{
		clearInstanceControls();
		if(record == null)
			return;
		
		form.lyrPage().tabPageReferral().ccReferralDetails().setValue(record.getReferralDetails(), record);
		form.lyrPage().tabPageDemographics().ccDemographics().setValue(record.getPatient());
	}

	private void clearInstanceControls()
	{
		form.lyrPage().tabPageReferral().ccReferralDetails().setValue(null, null);
		form.lyrPage().tabPageDemographics().ccDemographics().setValue(null);	
		form.lyrPage().tabPagePatientSearch().ccPatientSearch().clear();
	}
	
	private boolean isDialog()
	{
		if(engine.isDialog())
			return true;
		return false;
	}
	
	private void newInstance()
	{
		form.setMode(FormMode.EDIT);
		
		manageTabs();
		
	}
	
	private void manageTabs()
	{
		if (form.getGlobalContext().Core.getPatientShort() == null)
		{
			form.lyrPage().showtabPagePatientSearch();
	
			form.lyrPage().settabPageDemographicsEnabled(false);
			form.lyrPage().tabPageDemographics().setHeaderEnabled(false);
			
			form.lyrPage().settabPageReferralEnabled(false);
			form.lyrPage().tabPageReferral().setHeaderEnabled(false);
			
			if (ConfigFlag.GEN.SHOW_REFERRAL_DETAILS_BILLING_TABS.getValue())
			{
				form.lyrPage().settabPayorEnabled(false);
				form.lyrPage().tabPayor().setHeaderEnabled(false);
			
				form.lyrPage().settabContractDetailsEnabled(false);
				form.lyrPage().tabContractDetails().setHeaderEnabled(false);
			}
			else
			{
				form.lyrPage().tabPayor().setHeaderVisible(false);
				form.lyrPage().tabContractDetails().setHeaderVisible(false);
			}
			
			form.lyrPage().settabPageLetterEnabled(false);
			form.lyrPage().tabPageLetter().setHeaderEnabled(false);
			
			form.btnSave().setText("Next");
		}
		else if (form.getGlobalContext().Core.getPatientShortIsNotNull()
				&& form.getGlobalContext().RefMan.getCatsReferral() == null)
		{
			
			form.lyrPage().settabPageDemographicsEnabled(true);
			form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
			form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
			
			form.lyrPage().settabPageReferralEnabled(true);
			form.lyrPage().tabPageReferral().setHeaderEnabled(true);
			form.lyrPage().tabPageReferral().ccReferralDetails().setMode(FormMode.EDIT);
			form.lyrPage().tabPageReferral().ccReferralDetails().setValue(null, null);
			
			form.lyrPage().settabPageLetterEnabled(false);
			form.lyrPage().tabPageLetter().setHeaderEnabled(false);
			
			form.btnSave().setText("Next");
		}
		else
		{
			form.lyrPage().settabPageDemographicsEnabled(true);
			form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
			form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
			
			form.lyrPage().settabPageReferralEnabled(true);
			form.lyrPage().tabPageReferral().setHeaderEnabled(true);
			
			form.lyrPage().settabPageLetterEnabled(true);
			form.lyrPage().tabPageLetter().setHeaderEnabled(true);
			form.lyrPage().tabPageLetter().ccUploadDoc().setMode(FormMode.EDIT);
			tabUploadChange();
			
			form.btnSave().setText("Save");
		}
	}

	private void editInstance()
	{
		form.setMode(FormMode.EDIT);
		manageTabs();
	}
	
	private boolean save() throws FormOpenException
	{
		CatsReferralWizardVo record = populateDataFromScreen(form.getLocalContext().getRecord());
				
		//The Upload Component may have saved Cats Referral, time stamp and latest data needed. 
		if (form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull())
			record = form.getGlobalContext().RefMan.getCatsReferralWizard();
		
		if (record.getPatient() == null)
		{
			engine.showMessage("No Patient data was found. Is the Patient saved correctly on the demographics tab?", "No Patient Data", MessageButtons.OK, MessageIcon.ERROR);
			return false;
		}
		
		String[] errors = record.getPatient().validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		errors = validateUIRules(errors);
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		HcpLiteVo voHCPLite = null;
		if (domain.getHcpUser() != null)
		{
			Hcp hcpVo = (Hcp) domain.getHcpUser();
			voHCPLite = domain.getHcpLiteById(hcpVo);
		}
		
		if (record.getCareContext() == null)
		{
			CareSpellVo voCareSpell = populateCareSpellDataFromScreen(voHCPLite);
			
			if(voCareSpell == null)
				return false;
			
			String[] arrErrors = voCareSpell.validate();
			if(arrErrors != null)
			{
				engine.showErrors(arrErrors);
				return false;
			}
			try 
			{
				//wdev-12682
				record = domain.saveCareSpellAndReferralDetails(record, voCareSpell, form.getGlobalContext().RefMan.getReferralContractTypeForPatientIsNotNull() && form.getGlobalContext().RefMan.getReferralContractTypeForPatient().equals(ReferralManagementContractType.DIAGNOSTIC));
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open();		
				return false;
			}
			catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				open();		
				return false;
			}
		} 
		else
		{	
			errors = record.validate();
			if(errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			
			try 
			{
				record = domain.saveCatsReferral(record);
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				open();		
				return false;
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open();		
				return false;
			}
		}
		
		form.getLocalContext().setRecord(record);		
		form.lyrPage().tabPageReferral().ccReferralDetails().setValue(record.getReferralDetails(), record);
		form.getGlobalContext().RefMan.setCatsReferral(record);
		form.getGlobalContext().RefMan.setReferralContractTypeForPatient(record.getContractIsNotNull() ? record.getContract().getContractType() : null);
		form.getGlobalContext().RefMan.setCatsReferralWizard(record);
		
		//WDEV-14160
		if(record != null && record.getCareContextIsNotNull())
		{
			form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContext(record.getCareContext()));
		}
		
		return true;
	}
	
	private String[] validateUIRules(String[] errors2) 
	{
		String[] errors = form.lyrPage().tabPageReferral().ccReferralDetails().validate(errors2);
		
		return errors;
	}
	
	private CareSpellVo populateCareSpellDataFromScreen(HcpLiteVo voHCPLite)
	{
		CareSpellVo voCareSpell = populateCareSpellInstanceData();
		
		EpisodeofCareVo voEpisodeOfCare = populateEpisodeOfCare(voCareSpell, voHCPLite);
		
		populateCareContext(voEpisodeOfCare);
		
		return voCareSpell;
	}
	

	private CatsReferralWizardVo populateDataFromScreen(CatsReferralWizardVo record) 
	{
		boolean bSetAwaiting = false;
		if(record == null)
		{
			record = new CatsReferralWizardVo();

			record.setIsCAB(Boolean.FALSE);
			record.setAdditionalInvApptsStatus(AdditionalInvestigationAppointmentsStatus.NONE);
			record.setHasAppointments(Boolean.FALSE);
			record.setHasDocuments(Boolean.FALSE);
			record.setHasInvestigations(Boolean.FALSE);
			record.setHasReferralLetter(Boolean.FALSE);
			record.setHasConsultationDetails(Boolean.FALSE);
			
			bSetAwaiting = true;
		}
		
		
		record.setPatient(form.lyrPage().tabPageDemographics().ccDemographics().getValue());
		record.setReferralDetails(form.lyrPage().tabPageReferral().ccReferralDetails().getValue());
		record.setReferralCategory(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull()?form.getGlobalContext().RefMan.getCatsReferralWizard().getReferralCategory():null);

		if (bSetAwaiting)
		{
			//wdev-10020
			// GlobalContext.RefMan.CatsReferralWizard used to get the Awaiting info etc......clear it once used as this GC is used by the documents tab also
			record.setIsAwaitingClinicalInfo(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getIsAwaitingClinicalInfo() : null);
			record.setAwaitingClinicalInfo(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getAwaitingClinicalInfo() : null);
			record.setContract(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getContract() : null);
			// WDEV-18478 
			record.setUrgency(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getUrgency() : null);
			//WDEV-18452 
			record.setConsUpgradeDate(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getConsUpgradeDate() : null);
			//wdev-13647
			if(Boolean.TRUE.equals(ConfigFlag.UI.REFERRAL_DETAILS_DISPLAY_NEAREST_TREATMENT_CENTRE.getValue()))
			{
				record.setNearestTreatmentCentre(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() ? form.getGlobalContext().RefMan.getCatsReferralWizard().getNearestTreatmentCentre():null);
			}
			//-----------
			form.getGlobalContext().RefMan.setReferralContractTypeForPatient(form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() && form.getGlobalContext().RefMan.getCatsReferralWizard().getContractIsNotNull()? form.getGlobalContext().RefMan.getCatsReferralWizard().getContract().getContractType() : null);
			
			if (form.getGlobalContext().RefMan.getCatsReferralWizardIsNotNull() && form.getGlobalContext().RefMan.getCatsReferralWizard().getID_CatsReferral() == null)
				form.getGlobalContext().RefMan.setCatsReferralWizard(null);//clear it out
		}
	
		form.getLocalContext().setSelectedReferralService(record.getReferralDetails().getService());
		
		if (record.getReferralDetails().getID_ReferralLetterDetails() == null)
		{
			CatsReferralStatusVo voStatus = new CatsReferralStatusVo();
			
			voStatus.setAuthoringUser((MemberOfStaffRefVo)domain.getMosUser());
			voStatus.setStatusDateTime(new DateTime());
			
			voStatus.setReferralStatus(ReferralApptStatus.REFERRAL_RECEIVED);
			
			record.setCurrentStatus(voStatus);
			
			record.setStatusHistory(new CatsReferralStatusVoCollection());
			record.getStatusHistory().add(voStatus);
		}
		
		//WDEV-18395
		record.setRTTClockImpact(form.lyrPage().tabPageReferral().ccReferralDetails().getRTTClockImpact());
		record.setPathwayID(form.lyrPage().tabPageReferral().ccReferralDetails().getPathwayID());
		//WDEV-18395

		//wdev-18432
		if (form.getGlobalContext().RefMan.getReferralTransferIsNotNull())
		{
			record.setPathwayID(form.getGlobalContext().RefMan.getReferralTransfer().getPathwayID());
			record.setReferralTransfer(form.getGlobalContext().RefMan.getReferralTransfer());
		}
		return record;
	}
	
	private void cancel() throws FormOpenException
	{
		if(isDialog())
			engine.close(DialogResult.CANCEL);
		else
		{
			open();
			updateControlState();
		}
	}
	
	private void updateControlState()
	{
		if(form.getMode() == FormMode.VIEW)
		{	
			form.btnNew().setVisible(true);
			form.btnNew().setEnabled(form.getLocalContext().getRecord() == null);
			form.btnEdit().setVisible(form.getLocalContext().getRecord() != null);
			if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			{
				form.btnEdit().setEnabled(true);
				form.btnEdit().setVisible(true);
			}
		}
		
	}
	
	@Override
	protected void onlyrPageTabChanged(LayerBridge tab)
	{
		if (tab.equals(form.lyrPage().tabPageLetter()))
			tabUploadChange();
	}

	private void tabUploadChange()
	{
		try 
		{			
			form.lyrPage().tabPageLetter().ccUploadDoc().initialize(DocumentCategory.GPLETTER, UploadDocumentStoreLevel.REFERRAL,DocumentViewLevel.REFERRAL);
			//form.getGlobalContext().RefMan.setCatsReferralWizard(form.getLocalContext().getRecord());
			//ADDED FOR WDEV-7474 GlobalContext CatsRefferralWizard could be saved by upload document and you
			//must be sure that the CatsRefferalWizard has the latest version
			//form.getGlobalContext().RefMan.setCatsReferralWizard(domain.getCatsReferral(form.getLocalContext().getRecord()));
		}
		catch (RuntimeException e)
		{
			engine.showMessage(e.toString());				
		}
	}

	private CareSpellVo populateCareSpellInstanceData()
	{
		CareSpellVo voCareSpell = new CareSpellVo();
		
		voCareSpell.setStartDate(new Date());
		voCareSpell.setEndDate(null);
		voCareSpell.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return voCareSpell;
	}
	
	private void populateEpisodeOfCareInstanceData(EpisodeofCareVo voEpisodeOfCare, HcpLiteVo voHCPLite)
	{
		if(voEpisodeOfCare == null)
			voEpisodeOfCare = new EpisodeofCareVo();
		
		voEpisodeOfCare.setRelationship(CareSpelltoEpisodeRelationship.PRIMARY);
		
		ServiceVo voServ = new ServiceVo();
		voServ.setID_Service(form.getLocalContext().getSelectedReferralService().getID_Service());
		voServ = domain.getServiceById(voServ);
		voEpisodeOfCare.setSpecialty(voServ != null && voServ.getSpecialtyIsNotNull()? voServ.getSpecialty() : Specialty.DAD);
		voEpisodeOfCare.setResponsibleHCP(voHCPLite);
		voEpisodeOfCare.setStartDate(new Date());
		voEpisodeOfCare.setEndDate(null);
	}
	

	private EpisodeofCareVo populateEpisodeOfCare(CareSpellVo voCareSpell, HcpLiteVo voHCPLite)
	{
		EpisodeofCareVo voEpisodeOfCare = new EpisodeofCareVo();
		populateEpisodeOfCareInstanceData(voEpisodeOfCare, voHCPLite);
		voEpisodeOfCare.setCareSpell(voCareSpell);

		if(voCareSpell.getEpisodes() == null)
			voCareSpell.setEpisodes(new  EpisodeofCareVoCollection());
		
		voCareSpell.getEpisodes().add(voEpisodeOfCare);
		
		return voEpisodeOfCare;
	}

	private CareContextVo populateCareContextInstanceData(CareContextVo voCareContext)
	{
		if(voCareContext == null)
			voCareContext = new CareContextVo();
			
		voCareContext.setContext(ContextType.OUTPATIENT);
		voCareContext.setStartDateTime(new DateTime());
		voCareContext.setEndDateTime(null);
		voCareContext.setLocationType(null);	
		voCareContext.setPasEvent(null);
		
		return voCareContext;
	}
	

	private CareContextVo populateCareContext(EpisodeofCareVo voEpisodeOfCare)
	{
		CareContextVo voCareContext = new CareContextVo();
		populateCareContextInstanceData(voCareContext);
		voCareContext.setEpisodeOfCare(voEpisodeOfCare);
		if(voEpisodeOfCare.getCareContexts() == null)
			voEpisodeOfCare.setCareContexts(new CareContextVoCollection());
			
		voEpisodeOfCare.getCareContexts().add(voCareContext);
		
		return voCareContext;
	}
	
	@Override
	protected void onCcPatientSearchValueChanged() throws PresentationLogicException 
	{
		if(form.lyrPage().tabPagePatientSearch().ccPatientSearch().getEvent() != PatientSearchEvent.NONE)
		{
			form.getGlobalContext().RefMan.setCatsReferral(null);
			form.getGlobalContext().RefMan.setReferralContractTypeForPatient(null);//wdev-12682
			form.getGlobalContext().Core.setPatientShort(null);	
			form.getLocalContext().setbDemographicsSaved(false);
			form.lyrPage().tabPageReferral().ccReferralDetails().setValue(null, null);
			form.lyrPage().tabPageReferral().ccReferralDetails().setInitializedBooleanToFalse();
			
			manageTabs();

			PatientShort patient = null;
			if(form.lyrPage().tabPagePatientSearch().ccPatientSearch().getEvent().equals(PatientSearchEvent.PATIENT_SELECTED))
			{
				patient = form.lyrPage().tabPagePatientSearch().ccPatientSearch().getSelectedPatient();
				form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
			}
			else if(form.lyrPage().tabPagePatientSearch().ccPatientSearch().getEvent().equals(PatientSearchEvent.NEW_PATIENT))
			{
				form.getGlobalContext().Core.setPatientShort(null);
				form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
				form.lyrPage().tabPageDemographics().ccDemographics().displayDemographics();
			}
			
			form.lyrPage().showtabPageDemographics();
			form.lyrPage().settabPageDemographicsEnabled(true);
			form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
			form.lyrPage().tabPageDemographics().ccDemographics().setValue(patient);
			form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
		}
	}
	@Override
	protected void onCcDemographicsValueChanged() throws PresentationLogicException 
	{
		if (form.lyrPage().tabPageDemographics().ccDemographics().getPDSPatientEdited())
		{
			if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			{
				form.getLocalContext().setbDemographicsSaved(Boolean.TRUE); 
				manageTabs();
				form.lyrPage().showtabPageReferral();
			}
			else
			{
				form.getLocalContext().setbDemographicsSaved(Boolean.FALSE);
	
				form.lyrPage().settabPageDemographicsEnabled(true);
				form.lyrPage().tabPageDemographics().setHeaderEnabled(true);
				form.lyrPage().tabPageDemographics().ccDemographics().setMode(FormMode.EDIT);
				form.lyrPage().showtabPageDemographics();
			}
		}
		
		return;
	}
	@Override
	protected void onRadioButtonGroup1ValueChanged() throws PresentationLogicException 
	{	
		if (form.lyrPage().tabPayor().Group1().getValue().equals(Group1Enumeration.rdoInsurance))
		{
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderVisible(true);
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderEnabled(true);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().showtabInsuranceDetails();
		}
		else if (form.lyrPage().tabPayor().Group1().getValue().equals(Group1Enumeration.rdo3rdParty))
		{
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderVisible(true);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderEnabled(true);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().showtab3rdParty();
		}
		else if (form.lyrPage().tabPayor().Group1().getValue().equals(Group1Enumeration.rdoSelfPay))
		{
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderVisible(true);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderEnabled(true);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().showtabSelfPay();
		}
		else if (form.lyrPage().tabPayor().Group1().getValue().equals(Group1Enumeration.rdoNHS))
		{
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabInsuranceDetails().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tab3rdParty().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderVisible(false);
			form.lyrPage().tabPayor().lyr1().tabSelfPay().setHeaderEnabled(false);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderVisible(true);
			form.lyrPage().tabPayor().lyr1().tabNHS().setHeaderEnabled(true);
			form.lyrPage().tabPayor().lyr1().showtabNHS();
		}
	}
 }
