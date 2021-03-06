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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.forms.additionaldetailsindemographicscc;
import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CaseNoteFolderVo;
import ims.core.vo.DemographicControlsConfigVo;
import ims.core.vo.DemographicControlsConfigVoCollection;
import ims.core.vo.Patient;
import ims.core.vo.PatientId;
import ims.core.vo.enums.AdditionalDetailsTab;
import ims.core.vo.lookups.HomeFolderLocation;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.UIEngine;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.ConfigurationException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IUploadDownloadUrlProvider;



public class Logic extends BaseLogic
{
	//wdev-19528
	private static final String HOME_CASE_FOLDER_LOCATION_DEMOGR 			= "DEM46";
	private static final String CASE_NOTE_FOLDER_LOCATION_DEMOGR 			= "DEM47";
	//------------------------------
	
	public void initialise()
	{
		form.getLocalContext().setAdditionalDetailsTab(null);
	}
	
	protected void onBtnOITRetrieveClick() throws PresentationLogicException
	{
		
		form.getLocalContext().setAdditionalDetailsTab(AdditionalDetailsTab.OITRETRIEVEBUTTON);
		form.fireCustomControlValueChanged();
		/*IUploadDownloadUrlProvider l_oit = engine.getUploadDownloadUrlProvider();
		if (l_oit != null)
		{			
			try
			{
				if(form.getGlobalContext().Core.getPatientShort() != null && form.getGlobalContext().Core.getPatientShort().getHospnum() != null)
					l_oit.download(engine, "?user_key_1=" + form.getGlobalContext().Core.getPatientShort().getHospnum().getIdValue());
				
				else
					engine.showMessage("Patient hospital number not assigned to identifier list.");
					
			}
			catch (ConfigurationException e)
			{
				throw new PresentationLogicException(e.getMessage());
			}
		}*/
		
		
	}
	
	protected void onBtnOITUploadClick() throws PresentationLogicException
	{
		form.getLocalContext().setAdditionalDetailsTab(AdditionalDetailsTab.OITUPLOADBUTTON);
		form.fireCustomControlValueChanged();
		
	}
	
	public void showHideOITControls(Boolean showhide)
	{
		form.lblUploadImages().setVisible(showhide);
		form.btnOITUpload().setVisible(showhide);
		form.lblRetrieveImages().setVisible(showhide);
		form.btnOITRetrieve().setVisible(showhide);
		form.hzl1().setVisible(showhide);
		form.hzl2().setVisible(showhide);
		
	}
	
		
	public void setvalue(Patient pat)
	{
		if( pat != null)
		{
			form.cmbHomeFolder().setValue(pat.getHomeFolderLocation());
			
			
		}
		
	}
	
	public Patient getvalue(Patient pat)
	{
		/*=if( pat != null)
		{
			pat.setPrefCommLanguage(form.cmbPreferedLanguage().getValue());
			//WDEV-15957
			if(Group1Enumeration.rdoYes.equals(form.Group1().getValue()))
				pat.setCopyPatientOnCorrespondence(Boolean.TRUE);
			else if(Group1Enumeration.rdoNo.equals(form.Group1().getValue()))
				pat.setCopyPatientOnCorrespondence(Boolean.FALSE);
			else
				pat.setCopyPatientOnCorrespondence(null);
			
			if(pat.getCopyPatientOnCorrespondenceIsNotNull())
				pat.setCopyPatientOnCorrespondenceDate(form.dteEffectiveFromDate().getValue());
			else
				pat.setCopyPatientOnCorrespondenceDate(null);
		}=*/
		
		return pat;
	}
	
	public void clearScreen()
	{
		form.cmbHomeFolder().setValue(null);
		
	}
	
	public Boolean validateData()
	{
		/*=
		//WDEV-15957
		if( Group1Enumeration.rdoYes.equals(form.Group1().getValue()) && form.dteEffectiveFromDate().getValue() == null)
		{
			engine.showMessage("The Effective From date field can not be null !");
			return false;
		}=*/
		
		return true;
	}
	
	public void uploadButtonAction(IUploadDownloadUrlProvider l_oit, UIEngine engineform)
	{
		if (l_oit != null)
		{			
			try
			{
				if (form.getGlobalContext().Core.getPatientShortIsNotNull() && form.getGlobalContext().Core.getPatientShort().getHospnum() != null)
				{
					if (ConfigFlag.UI.OIT_USERKEY6.getValue() == "")
					{
						engine.showMessage("Please setup OIT_USERKEY6 flag");
						return;
					}
					l_oit.upload(engineform, "?user_key_1=" + form.getGlobalContext().Core.getPatientShort().getHospnum().getIdValue() + "&user_key_6=" + ConfigFlag.UI.OIT_USERKEY6.getValue());
				}
				else
					engine.showMessage("Patient hospital number not assigned to identifier list.");
			}
			catch (ConfigurationException e)
			{
				engine.showMessage(e.getMessage());
			}
		}		
		
	}
	
	public void retreiveButtonAction(IUploadDownloadUrlProvider l_oit, UIEngine engineform) 
	{
		
		if (l_oit != null)
		{			
			try
			{
				if(form.getGlobalContext().Core.getPatientShort() != null && form.getGlobalContext().Core.getPatientShort().getHospnum() != null)
					l_oit.download(engineform, "?user_key_1=" + form.getGlobalContext().Core.getPatientShort().getHospnum().getIdValue());
				else
					engine.showMessage("Patient hospital number not assigned to identifier list.");
					
			}
			catch (ConfigurationException e)
			{
				engine.showMessage(e.getMessage());
			}
		}
		
	}
	
	public void setAction(AdditionalDetailsTab action)
	{
		form.getLocalContext().setAdditionalDetailsTab(action);
		
	}
	
	public AdditionalDetailsTab getAction()
	{
		return form.getLocalContext().getAdditionalDetailsTab();
	}
	private void updateContolsState()
	{
						
		form.txtCaseNoteLocation().setEnabled(false);
		form.cmbHomeFolder().setEnabled(FormMode.EDIT.equals(form.getMode()));
	}
	
	protected void onFormModeChanged()
	{
		updateContolsState();
		
	}
	
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
	
	public void showHideCaseNoteControls(Boolean showhide)
	{
		form.lblHomeCaseFolderLocation().setVisible(showhide);
		form.cmbHomeFolder().setVisible(showhide);
		form.lblCaseNoteFolderLocation().setVisible(showhide);
		form.txtCaseNoteLocation().setVisible(showhide);
		form.btnFolderComment().setVisible(showhide);
		
	}
	
	protected void onBtnFolderCommentClick() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setCommentDialogString(form.txtCaseNoteComment().getValue());
		form.getGlobalContext().Core.setCommentDialogReadOnly(Boolean.TRUE);
		form.getGlobalContext().Core.setCommentDialogTitle("Case Note Folder Comment");

		engine.open(form.getForms().Core.CommentDialog);
		
	}
	
	public HomeFolderLocation getHomeCaseFolderLocation()
	{
		return form.cmbHomeFolder().getValue();
	}
	
	public void displayCaseNoteFolder(PatientId id)
	{
		//WDEV-13844 
		if (id == null) 
		{
			return;
		}
		//end 
		
		form.btnFolderComment().setVisible(false);

		CaseNoteFolderVo voCN = null;
		try 
		{
			voCN = domain.getCaseNoteFolderLocation(id.getValue());
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}

		if (voCN != null)
		{
			form.txtCaseNoteLocation().setValue(voCN.getLocation());
			form.txtCaseNoteComment().setValue(voCN.getComments());
			if (voCN.getCommentsIsNotNull())
				form.btnFolderComment().setVisible(true);
		}
	
		
	}

	//wdev-19528
	public void setConfigurableFields(DemographicControlsConfigVoCollection collfields)
	{
		if( collfields == null || collfields.size() == 0)
			return;
		
		for(int i = 0; i < collfields.size(); i++ )
		{
			DemographicControlsConfigVo tempVo = collfields.get(i); 
			if( tempVo != null )
			{
				
				if( HOME_CASE_FOLDER_LOCATION_DEMOGR.equals(tempVo.getControlIMSID()))
				{
					form.cmbHomeFolder().setRequired(tempVo.getIsMandatory());
				}
				else if( CASE_NOTE_FOLDER_LOCATION_DEMOGR.equals(tempVo.getControlIMSID()))
				{
					form.txtCaseNoteLocation().setRequired(tempVo.getIsMandatory());
				}
				
			}
		}
		
	}
	//wdev-19528
	public String[] getUIErrorsForConfigurableMode()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if( form.cmbHomeFolder().getVisible() && form.cmbHomeFolder().isRequired() && form.cmbHomeFolder().getValue() == null)
		{
			errors.add("Home Case Folder Location is mandatory.");
		}
		if( form.txtCaseNoteLocation().isVisible() && form.txtCaseNoteLocation().isRequired() && (form.txtCaseNoteLocation().getValue() == null || form.txtCaseNoteLocation().getValue() == ""))
		{
			errors.add("Case Note Folder Location is mandatory.");
		}
		
		if( errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
}
