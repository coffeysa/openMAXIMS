//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3800.18244)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.nursing.forms.careplaneditaction;

import ims.configuration.gen.ConfigFlag;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	
	private void initialize() 
	{
		form.setMode(FormMode.EDIT);
		form.txtAction().setValue(form.getGlobalContext().Nursing.getCarePlanAction());
		form.txtAction().setFocus();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.txtAction().getValue() == null || form.txtAction().getValue().length() == 0)
		{
			engine.showErrors(new String[] {"Care Plan Action can not be empty."});
			return;
		}
		
		//WDEV-15030
		Integer x = new Integer(form.txtAction().getValue().length());
		Integer config = new Integer(ConfigFlag.UI.CAREPLAN_ACTION_TEXT_LENGTH.getValue());
		if (x.intValue() > config.intValue())
		{
			engine.showMessage("Care Plan Action can be no more than " + ConfigFlag.UI.CAREPLAN_ACTION_TEXT_LENGTH.getValue() + " characters");
			return;
		}
		
		
		form.getGlobalContext().Nursing.setCarePlanAction(form.txtAction().getValue());
		engine.close(DialogResult.OK);
	}
}
