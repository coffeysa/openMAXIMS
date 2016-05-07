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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.core.forms.bedreadydetailsdialog;

import ims.core.vo.PendingTransferForBedReadyDetailsVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && !Boolean.TRUE.equals(form.getLocalContext().getReadOnlyMode()));
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise(args);
		open();
	}
	private void open()
	{
		if (form.getLocalContext().getSelectedPendingTransferIsNotNull())
			form.dtimBedReady().setValue(form.getLocalContext().getSelectedPendingTransfer().getBedAvailableDateTime());
		
	}
	private void initialise(Object[] args)
	{
		if (args != null && args.length > 0)
		{
			if (args.length >= 1 && args[0] instanceof PendingTransferForBedReadyDetailsVo)
				form.getLocalContext().setSelectedPendingTransfer((PendingTransferForBedReadyDetailsVo) args[0]);
			if (args.length >= 1 && args[0] instanceof Boolean)
				form.getLocalContext().setReadOnlyMode((Boolean) args[0]);
			
			form.setMode(args.length >= 2 && args[1] instanceof FormMode ? (FormMode)args[1] : FormMode.VIEW);			
		}
		if (form.getGlobalContext().Core.getADTPendingTransferIsNotNull())
			form.dtimBedReady().setValue(form.getGlobalContext().Core.getADTPendingTransfer().getBedAvailableDateTime());
			
		
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (validateUI())
		{	
			if (form.getGlobalContext().Core.getADTPendingTransferIsNotNull())
				form.getGlobalContext().Core.getADTPendingTransfer().setBedAvailableDateTime(form.dtimBedReady().getValue());
			else
			{	
				form.getGlobalContext().Core.setBedReadyDetails(populateDataFromScreen(form.getLocalContext().getSelectedPendingTransfer()));
			}
			engine.close(DialogResult.OK);
		}

	}
	private boolean validateUI()
	{
		if (form.dtimBedReady().getValue() != null && ((form.getLocalContext().getSelectedPendingTransferIsNotNull() && form.dtimBedReady().getValue().isLessThan(form.getLocalContext().getSelectedPendingTransfer().getTransferRequestDateTime())) || (form.getGlobalContext().Core.getADTPendingTransferIsNotNull() && form.dtimBedReady().getValue().isLessThan(form.getGlobalContext().Core.getADTPendingTransfer().getTransferRequestDateTime()))))
		{	
			engine.showErrors(new String[] { "Bed Available Date/Time must be the same or later than Transfer Request Date/Time."});
			return false;
		}
		return true;
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	private PendingTransferForBedReadyDetailsVo populateDataFromScreen(PendingTransferForBedReadyDetailsVo vo)
	{
		if (vo == null) 
			return null;
		vo.setBedAvailableDateTime(form.dtimBedReady().getValue());
		
		return vo;		
	}
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);		
	}
}