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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1921.23961)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.userprofile;


import ims.core.configuration.vo.AppUserRefVo;
import ims.core.resource.people.vo.MedicRefVo;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.Specialty;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.core.vo.ClinicVo;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.vo.ClinicAccessVo;
import ims.correspondence.vo.ClinicAccessVoCollection;
import ims.correspondence.vo.ConsultantAccessVo;
import ims.correspondence.vo.ConsultantAccessVoCollection;
import ims.correspondence.vo.SpecialtyAccessVo;
import ims.correspondence.vo.SpecialtyAccessVoCollection;
import ims.correspondence.vo.UserAccessVo;
import ims.correspondence.vo.lookups.Access;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.userprofile.Handlers#onFormOpen()
	 */
	protected void onFormOpen() throws FormOpenException 
	{
		open();
	}

	/**
	 * 
	 */
	private void clear()
	{
		form.grdConsultant().getRows().clear();
		form.grdClinic().getRows().clear();
		form.grdSpecialty().getRows().clear();
	}
	

	/**
	 * 
	 */
	private void listClinics() 
	{	
		ClinicVoCollection voCollClinics = domain.listClinics();		
		if (voCollClinics != null)
		{		
			form.grdClinic().getRows().clear();						
			for (int i = 0; i < voCollClinics.size(); i++) 
			{
				GenForm.grdClinicRow clinicRow = form.grdClinic().getRows().newRow();				
				clinicRow.setcolClinic(voCollClinics.get(i).getClinicName());
				clinicRow.setValue(voCollClinics.get(i));
				clinicRow.setcolClinicImage(form.getImages().Admin.Location);				
			}
		}
	}

	/**
	 * 
	 */
	private void listConsultants() 
	{
		MedicLiteVoCollection voCollConsultants = domain.listConsultants();		
		if (voCollConsultants != null)
		{			
			form.grdConsultant().getRows().clear();			
			for (int i=0; i < voCollConsultants.size(); i++)
			{
				GenForm.grdConsultantRow consRow = form.grdConsultant().getRows().newRow();				
				consRow.setValue(voCollConsultants.get(i));
				consRow.setColConsultantImage(form.getImages().Admin.MemberOfStaff);
				consRow.setcolConsultant(voCollConsultants.get(i).getMos().getName().toShortForm());
			}
		}
	}
	

	/**
	 * 
	 */
	private void listSpecialties() 
	{
		SpecialtyCollection lkpCollSpecialties = LookupHelper.getSpecialty(domain.getLookupService());				
		if (lkpCollSpecialties != null)
		{
			form.grdSpecialty().getRows().clear();		
			for (int i = 0; i < lkpCollSpecialties.size(); i++) 
			{
				GenForm.grdSpecialtyRow specRow = form.grdSpecialty().getRows().newRow();
				specRow.setValue(lkpCollSpecialties.get(i));
				specRow.setcolSpecialtyImage(form.getImages().Admin.Service);
				specRow.setcolSpecialty(lkpCollSpecialties.get(i).getText());
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.userprofile.Handlers#onBtnCancelClick()
	 */
	protected void onBtnCancelClick() throws PresentationLogicException {
		open();
		form.setMode(FormMode.VIEW);		
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.userprofile.Handlers#onBtnSaveClick()
	 */
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if (save())
			open();		
	}
	
	private boolean save()
	{
		UserAccessVo voUserAccess = populateInstanceData();
		
		String[] arrErrors = voUserAccess.validate();		
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try {
			domain.saveUserAccess(voUserAccess);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (ForeignKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		
		return true;
		
	}

	private UserAccessVo populateInstanceData()
	{
		UserAccessVo voUserAccess = form.getLocalContext().getSelectedInstance();
		if (voUserAccess == null)
			voUserAccess = new UserAccessVo();
				
		voUserAccess.setConsultantAccess(populateConsultantAccessInstanceData());
		voUserAccess.setSpecialtyAccess(populateSpecialtyAccessInstanceData());
		voUserAccess.setClinicAccess(populateClinicAccessInstanceData());		
		
		return voUserAccess;
	}

	private ConsultantAccessVoCollection populateConsultantAccessInstanceData() 
	{
		ConsultantAccessVoCollection voCollConsultantAccess = new ConsultantAccessVoCollection();
		for (int i = 0; i < form.grdConsultant().getRows().size(); i++) 
		{
			if (form.grdConsultant().getRows().get(i).getcolAccess() != null)
			{
				if (form.grdConsultant().getRows().get(i).getValue() == null) 
					continue;

				ConsultantAccessVo voConsultantAccess = new ConsultantAccessVo();							
				if (form.grdConsultant().getRows().get(i).getValue() instanceof MedicLiteVo)
				{
					voConsultantAccess.setConsultant((MedicLiteVo) form.grdConsultant().getRows().get(i).getValue());
				}
				else if (form.grdConsultant().getRows().get(i).getValue() instanceof ConsultantAccessVo) 				
				{
					voConsultantAccess = (ConsultantAccessVo) form.grdConsultant().getRows().get(i).getValue();
				}
				
					
				voConsultantAccess.setAccessRight(form.grdConsultant().getRows().get(i).getcolAccess());
				voCollConsultantAccess.add(voConsultantAccess);			
			}			
		}
		
		return voCollConsultantAccess;
	}

	private SpecialtyAccessVoCollection populateSpecialtyAccessInstanceData() 
	{
		SpecialtyAccessVoCollection voCollSpecialtyAccess = new SpecialtyAccessVoCollection();
		for (int i = 0; i < form.grdSpecialty().getRows().size(); i++) 
		{
			if (form.grdSpecialty().getRows().get(i).getcolAccess() != null)
			{
				if (form.grdSpecialty().getRows().get(i).getValue() == null) 
					continue;
				
				SpecialtyAccessVo voSpecialtyAccess = new SpecialtyAccessVo();							
				if (form.grdSpecialty().getRows().get(i).getValue() instanceof Specialty)
					voSpecialtyAccess.setSpecialty((Specialty) form.grdSpecialty().getRows().get(i).getValue());
				else if (form.grdSpecialty().getRows().get(i).getValue() instanceof SpecialtyAccessVo) 				
					voSpecialtyAccess = (SpecialtyAccessVo) form.grdSpecialty().getRows().get(i).getValue();
				
				voSpecialtyAccess.setAccessRight(form.grdSpecialty().getRows().get(i).getcolAccess());
				voCollSpecialtyAccess.add(voSpecialtyAccess);			
			}			
		}
		
		return voCollSpecialtyAccess;
	}
	
	
	private ClinicAccessVoCollection populateClinicAccessInstanceData() 
	{
		ClinicAccessVoCollection voCollClinicAccess = new ClinicAccessVoCollection();
		for (int i = 0; i < form.grdClinic().getRows().size(); i++) 
		{
			if (form.grdClinic().getRows().get(i).getcolAccess() != null)
			{
				if (form.grdClinic().getRows().get(i).getcolAccess() != null)
				{
					ClinicAccessVo voClinicAccess = new ClinicAccessVo();							
					if (form.grdClinic().getRows().get(i).getValue() instanceof ClinicVo)
						voClinicAccess.setClinic((ClinicVo)form.grdClinic().getRows().get(i).getValue());
					else if (form.grdClinic().getRows().get(i).getValue() instanceof ClinicAccessVo) 				
						voClinicAccess = (ClinicAccessVo) form.grdClinic().getRows().get(i).getValue();

					voClinicAccess.setAccessRight(form.grdClinic().getRows().get(i).getcolAccess());
					voCollClinicAccess.add(voClinicAccess);			
				}			
			}			
		}
		
		return voCollClinicAccess;
	}
	
	
	
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		searchAppUser();
	}

	private void searchAppUser()
	{
		if (form.txtUserName().getValue() == "")
			engine.showMessage("Please enter a user name or part to search");
		else
		{
			form.grdUsers().getRows().clear();									
			AppUserShortVo voFilter = new AppUserShortVo();
			voFilter.setUsername(form.txtUserName().getValue());
			AppUserShortVoCollection voCollAppusers = domain.listAppUsers(voFilter);

			if ((voCollAppusers != null) && (voCollAppusers.size()>0))
			{
				for (int i=0;i<voCollAppusers.size();i++)
				{		
					GenForm.grdUsersRow userRow = form.grdUsers().getRows().newRow();
					userRow.setValue(voCollAppusers.get(i));
					userRow.setcolUserName(voCollAppusers.get(i).getUsername());
					userRow.setcolRealName(voCollAppusers.get(i).getUserRealName());
				}
			}
			else
				engine.showMessage("No users found for : " + form.txtUserName().getValue());
		}
	}
	
	/* (non-Javadoc)
	 * @see ims.dischargeletters.forms.userprofile.Handlers#onBtnUpdateClick()
	 */
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
	}
	

	protected void open()
	{
		if (form.grdUsers().getValue() != null)
			selectionChanged();
		
		form.setMode(FormMode.VIEW);
		form.txtUserName().setFocus();		
	}
	
	protected void onGrdAppUsersSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		selectionChanged();		
	}

	private void selectionChanged() 
	{
		AppUserShortVo voAppUser = form.grdUsers().getValue();		
		form.getLocalContext().setSelectedUser(voAppUser);
		
		clear();
		
		listConsultants();			
		listSpecialties();
		listClinics();		
		
		if (voAppUser != null)
		{
			UserAccessVo voUserAccess = domain.getUserAccessForUser(voAppUser.getID_AppUser());			
			if (voUserAccess == null)
			{
				voUserAccess = new UserAccessVo();
				AppUserRefVo voRefAppUser = new AppUserRefVo();
				voRefAppUser.setID_AppUser(voAppUser.getID_AppUser());
				voUserAccess.setAppUser(voRefAppUser);
			}
			
			overlayUserAccess(voUserAccess);
			form.getLocalContext().setSelectedInstance(voUserAccess);			
		}		

		updateControlsState();
	}

	
	
	private void overlayUserAccess(UserAccessVo voUserAccess) 
	{		
		if (voUserAccess.getConsultantAccessIsNotNull())
			overlayConsultantAccess(voUserAccess.getConsultantAccess());
		if (voUserAccess.getSpecialtyAccessIsNotNull())
			overlaySpecialtyAccess(voUserAccess.getSpecialtyAccess());
		if (voUserAccess.getClinicAccessIsNotNull())
			overlayClinicAccess(voUserAccess.getClinicAccess());
	}

	private void overlayClinicAccess(ClinicAccessVoCollection voCollClinicAccess)
	{
		for (int i = 0; voCollClinicAccess != null && i < voCollClinicAccess.size();i++) 
		{
			for (int j = 0; j < form.grdClinic().getRows().size(); j++) 
			{
				if (form.grdClinic().getRows().get(j).getValue() instanceof ClinicVo)
				{
					ClinicVo voClinic = (ClinicVo) form.grdClinic().getRows().get(j).getValue();
					if (voCollClinicAccess.get(i).getClinic().getID_Clinic().intValue()  == voClinic.getID_Clinic().intValue())
					{					
						form.grdClinic().getRows().get(j).setValue(voCollClinicAccess.get(i));												
						form.grdClinic().getRows().get(j).setcolAccess(voCollClinicAccess.get(i).getAccessRight());
						break;												
					}
				}
			}
		}
	}

	private void overlaySpecialtyAccess(SpecialtyAccessVoCollection voCollSpecialtyAccess) 
	{
		for (int i = 0; voCollSpecialtyAccess != null && i < voCollSpecialtyAccess.size();i++) 
		{
			for (int j = 0; j < form.grdSpecialty().getRows().size(); j++) 
			{				
				if (form.grdSpecialty().getRows().get(j).getValue() instanceof Specialty)
				{
					Specialty lkpSpecialty = (Specialty) form.grdSpecialty().getRows().get(j).getValue();
					if (voCollSpecialtyAccess.get(i).getSpecialty().getId() == lkpSpecialty.getId())
					{					
						form.grdSpecialty().getRows().get(j).setValue(voCollSpecialtyAccess.get(i));												
						form.grdSpecialty().getRows().get(j).setcolAccess(voCollSpecialtyAccess.get(i).getAccessRight());
						break;												
					}
				}
			}
		}

		
	}

	private void overlayConsultantAccess(ConsultantAccessVoCollection voCollConsultantAccess) 
	{
		for (int i = 0; voCollConsultantAccess != null && i < voCollConsultantAccess.size();i++) 
		{
			for (int j = 0; j < form.grdConsultant().getRows().size(); j++) 
			{
				if (form.grdConsultant().getRows().get(j).getValue() instanceof MedicLiteVo)
				{
					MedicLiteVo voMedicLite = (MedicLiteVo) form.grdConsultant().getRows().get(j).getValue();
					if (voCollConsultantAccess.get(i).getConsultant().getID_Hcp().equals(voMedicLite.getID_Hcp()))
					{					
						form.grdConsultant().getRows().get(j).setValue(voCollConsultantAccess.get(i));												
						form.grdConsultant().getRows().get(j).setcolAccess(voCollConsultantAccess.get(i).getAccessRight());
						break;												
					}
				}
			}
		}
	}

	protected void onFormModeChanged() 
	{
		updateControlsState();		
	}

	private void updateControlsState()
	{
		form.btnUpdate().setVisible(form.grdUsers().getValue() != null && form.getMode().equals(FormMode.VIEW));
		
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.grdUsers().setUnselectable(true);
			updateSelectionButtons();
		}
		else
			form.grdUsers().setUnselectable(false);
	}

	private void updateSelectionButtons()
	{
		form.imbSelectAllClinics().setEnabled(lookForClinicValue(Access.READWRITE));
		form.imbGrantROAllClinics().setEnabled(lookForClinicValue(Access.READONLY));
		form.imbClearClinics().setEnabled(true);
		
		form.imbSelectAllSpecialties().setEnabled(lookForSpecialtyValue(Access.READWRITE));			
		form.imbGrantROAllSpecialties().setEnabled(lookForSpecialtyValue(Access.READONLY));
		form.imbClearAllSpecialies().setEnabled(true);
		
		form.imbSelectAllConsultants().setEnabled(lookForConsultantValue(Access.READWRITE));
		form.imbGrantROAllConsultants().setEnabled(lookForConsultantValue(Access.READONLY));
		form.imbClearAllConsultants().setEnabled(true);
	}




	protected void onImbSelectAllConsultantsClick() throws PresentationLogicException
	{
		setAllConsultants(Boolean.TRUE);
		updateSelectionButtons();
	}

	protected void onImbSelectAllSpecialtiesClick() throws PresentationLogicException
	{
		setAllSpecialties(Boolean.TRUE);
		updateSelectionButtons();		
	}

	protected void onImbSelectAllClinicsClick() throws PresentationLogicException
	{
		setAllClinics(Boolean.TRUE);
		updateSelectionButtons();		
	}
	
	private void setAllConsultants(Boolean b)
	{
		for (int i=0; i < form.grdConsultant().getRows().size(); i++) 
			form.grdConsultant().getRows().get(i).setcolAccess(b == null ? null : b == Boolean.TRUE ? Access.READWRITE : Access.READONLY);						
	}
	
	private void setAllSpecialties(Boolean b)
	{
		for (int i=0; i < form.grdSpecialty().getRows().size(); i++) 
			form.grdSpecialty().getRows().get(i).setcolAccess(b == null ? null : b == Boolean.TRUE ? Access.READWRITE : Access.READONLY);				
	}
	
	private void setAllClinics(Boolean b)
	{
		for (int i=0; i < form.grdClinic().getRows().size(); i++) 
			form.grdClinic().getRows().get(i).setcolAccess(b == null ? null : b == Boolean.TRUE ? Access.READWRITE : Access.READONLY);				
	}
	
		
	private boolean lookForClinicValue(Access clinicAccess)
	{
		for (int i=0; i < form.grdClinic().getRows().size(); i++)
		{
			if (form.grdClinic().getRows().get(i).getcolAccess() != null && form.grdClinic().getRows().get(i).getcolAccess().equals(clinicAccess))
					return false;
		}		
		return true;
	}
		
	private boolean lookForSpecialtyValue(Access specialtyAccess)
	{
		for (int i=0; i < form.grdSpecialty().getRows().size(); i++)
		{
			if (form.grdSpecialty().getRows().get(i).getcolAccess() != null && form.grdSpecialty().getRows().get(i).getcolAccess().equals(specialtyAccess))
					return false;
		}		
		return true;
	}
	
	private boolean lookForConsultantValue(Access consultantAccess)
	{
		for (int i=0; i < form.grdConsultant().getRows().size(); i++)
		{
			if (form.grdConsultant().getRows().get(i).getcolAccess() != null && form.grdConsultant().getRows().get(i).getcolAccess().equals(consultantAccess))
					return false;
		}		
		return true;
	}
 
	protected void onImbClearAllConsultantsClick() throws PresentationLogicException 
	{
		setAllConsultants(null);
		updateSelectionButtons();		
	}

	protected void onImbClearAllSpecialiesClick() throws PresentationLogicException 
	{
		setAllSpecialties(null);
		updateSelectionButtons();		
	}

	protected void onImbClearClinicsClick() throws PresentationLogicException 
	{
		setAllClinics(null);
		updateSelectionButtons();		
	}

	protected void onImbGrantROAllConsultantsClick() throws PresentationLogicException 
	{
		setAllConsultants(Boolean.FALSE);
		updateSelectionButtons();		
	}

	protected void onImbGrantROAllSpecialtiesClick() throws PresentationLogicException 
	{
		setAllSpecialties(Boolean.FALSE);
		updateSelectionButtons();

	}

	protected void onImbGrantROAllClinicsClick() throws PresentationLogicException 
	{
		setAllClinics(Boolean.FALSE);
		updateSelectionButtons();

	}
}
