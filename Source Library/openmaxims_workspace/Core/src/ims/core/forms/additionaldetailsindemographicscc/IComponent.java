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

package ims.core.forms.additionaldetailsindemographicscc;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	public void initialise();

	public void showHideOITControls(Boolean showhide);

	public void setvalue(ims.core.vo.Patient pat);

	public ims.core.vo.Patient getvalue(ims.core.vo.Patient pat);

	public void clearScreen();

	public Boolean validateData();

	public void uploadButtonAction(ims.framework.interfaces.IUploadDownloadUrlProvider l_oit, ims.framework.UIEngine engineform);

	public void retreiveButtonAction(ims.framework.interfaces.IUploadDownloadUrlProvider l_oit, ims.framework.UIEngine engineform);

	public void setAction(ims.core.vo.enums.AdditionalDetailsTab action);

	public ims.core.vo.enums.AdditionalDetailsTab getAction();

	public void showHideCaseNoteControls(Boolean showhide);

	public ims.core.vo.lookups.HomeFolderLocation getHomeCaseFolderLocation();

	public void displayCaseNoteFolder(ims.core.vo.PatientId id);

	public void setConfigurableFields(ims.core.vo.DemographicControlsConfigVoCollection collfields);

	public String[] getUIErrorsForConfigurableMode();
}
