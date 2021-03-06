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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.admin.forms.alertpidbarconfiguration;

import ims.admin.forms.alertpidbarconfiguration.GenForm.GroupAlertPositionEnumeration;
import ims.admin.forms.alertpidbarconfiguration.GenForm.grdAlertsRow;
import ims.admin.vo.AlertPIDBarConfigVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.AlertType;
import ims.core.vo.lookups.AlertTypeCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Image;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setAlertPidBarConfig(domain.getAlertPIDBarConfig());
		form.getLocalContext().setCollAllerts(getAlertsCategories());
		populateScreenFromData(form.getLocalContext().getAlertPidBarConfig());
		//loadCategories(true);
		form.getLocalContext().setEditAlertPositionCategory(false);
		form.setMode(FormMode.VIEW);
	}
	
	private void populateScreenFromData(AlertPIDBarConfigVo alertPidBarConfig)
	{
		form.grdAlerts().getRows().clear();
		
		if (alertPidBarConfig==null)
			return;
		
		int countRows=0;
		
		if (alertPidBarConfig.getAlertCategoryPosition1IsNotNull())
		{
			addRow(1,form.getImages().Core.AlertCategory1_16,alertPidBarConfig.getAlertCategoryPosition1());
			countRows++;
		}
		
		if (alertPidBarConfig.getAlertCategoryPosition2IsNotNull())
		{
			addRow(2,form.getImages().Core.AlertCategory2_16,alertPidBarConfig.getAlertCategoryPosition2());
			countRows++;
		}
		
		if (alertPidBarConfig.getAlertCategoryPosition3IsNotNull())
		{
			addRow(3,form.getImages().Core.AlertCategory3_16,alertPidBarConfig.getAlertCategoryPosition3());
			countRows++;
		}
		
		if (alertPidBarConfig.getAlertCategoryPosition4IsNotNull())
		{
			addRow(4,form.getImages().Core.AlertCategory4_16,alertPidBarConfig.getAlertCategoryPosition4());
			countRows++;
		}
		
		populateAlertPositionDetails(form.grdAlerts().getSelectedRow());
		setRadioButton(countRows+1);
		
	}

	private void setRadioButton(int position)
	{
		switch (position)
		{
			case 1:
				form.GroupAlertPosition().setValue(GroupAlertPositionEnumeration.rdo1);
			break;

			case 2:
				form.GroupAlertPosition().setValue(GroupAlertPositionEnumeration.rdo2);
			break;
			
			case 3:
				form.GroupAlertPosition().setValue(GroupAlertPositionEnumeration.rdo3);
			break;
			
			case 4:
				form.GroupAlertPosition().setValue(GroupAlertPositionEnumeration.rdo4);
			break;
			
			case 5:
				form.GroupAlertPosition().setValue(GroupAlertPositionEnumeration.rdo5);
			break;
		}
	}

	private void addRow(int position, Image alertIcon, AlertType alertCategoryPosition)
	{
		grdAlertsRow row = form.grdAlerts().getRows().newRow();
		
		row.setColAlertPosition(position);
		
		if (alertIcon!=null)
		{
			row.setColAlertIcon(alertIcon);
		}
		
		if (alertCategoryPosition!=null)
		{
			row.setColAlertCategory(alertCategoryPosition.getText());
			row.setTooltipForColAlertCategory(alertCategoryPosition.getText());
		}
		
		row.setValue(alertCategoryPosition);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	private boolean save()
	{
		AlertPIDBarConfigVo alertPidBarConfig=populateDataFromScreen(form.getLocalContext().getAlertPidBarConfig());
		
		String[] errors = alertPidBarConfig.validate(getUIErrors());
		
		if (errors!=null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		if (alertPidBarConfig.getID_AlertPIDBarConfig()==null && domain.getAlertPIDBarConfig()!=null )
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		try
		{
			form.getLocalContext().setAlertPidBarConfig(domain.save(alertPidBarConfig));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		return true;
	}

	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		for (int i=0;i<form.grdAlerts().getRows().size();i++)
		{
			if (form.grdAlerts().getRows().get(i).getColAlertCategory()==null)
			{
				errors.add("Please select an Alert Category for all Alert Positions");
			}
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}

	private AlertPIDBarConfigVo populateDataFromScreen(AlertPIDBarConfigVo alertPidBarConfig)
	{
		if (alertPidBarConfig==null)
			alertPidBarConfig = new AlertPIDBarConfigVo();
		else
			alertPidBarConfig=(AlertPIDBarConfigVo)alertPidBarConfig.clone();

		alertPidBarConfig.setAlertCategoryPosition1(null);
		alertPidBarConfig.setAlertCategoryPosition2(null);
		alertPidBarConfig.setAlertCategoryPosition3(null);
		alertPidBarConfig.setAlertCategoryPosition4(null);
		
		for (int i=0;i<form.grdAlerts().getRows().size();i++)
		{
			if (i==0)
			{
				alertPidBarConfig.setAlertCategoryPosition1(form.grdAlerts().getRows().get(i).getValue());
			}
			if (i==1)
			{
				alertPidBarConfig.setAlertCategoryPosition2(form.grdAlerts().getRows().get(i).getValue());
			}
			if (i==2)
			{
				alertPidBarConfig.setAlertCategoryPosition3(form.grdAlerts().getRows().get(i).getValue());
			}
			if (i==3)
			{
				alertPidBarConfig.setAlertCategoryPosition4(form.grdAlerts().getRows().get(i).getValue());
			}
		}
		
		return alertPidBarConfig;
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		open();
	}
	
	@Override
	protected void onRadioButtonGroupAlertPositionValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		
		int nrAlertIconsSelected=getNrAlertIconsSelected();
		int rowsAlreadyAdded = form.grdAlerts().getRows().size();
		
		if (rowsAlreadyAdded==0)
		{
			for (int i=1;i<=nrAlertIconsSelected-1;i++)
			{
				addRow(i, null, null);
			}
		}
		else
		{
			if (rowsAlreadyAdded<nrAlertIconsSelected-1)
			{
				for (int i=rowsAlreadyAdded+1;i<=nrAlertIconsSelected-1;i++)
				{
					addRow(i, null, null);
				}
			}
			else
			{
				
				for (int i=rowsAlreadyAdded-1;i>=nrAlertIconsSelected-1;i--)
				{
					form.grdAlerts().getRows().remove(i);
				}
				
			}
		}
		
		if (form.grdAlerts().getSelectedRow()==null)
		{
			clearAlertPositionDetails();
		}
		
		updateControlsState();
	}
	
	private int getNrAlertIconsSelected()
	{
		if (GroupAlertPositionEnumeration.rdo1.equals(form.GroupAlertPosition().getValue()))
		{
			return 1;
		}
		else if (GroupAlertPositionEnumeration.rdo2.equals(form.GroupAlertPosition().getValue()))
		{
			return 2;
		}
		else if (GroupAlertPositionEnumeration.rdo3.equals(form.GroupAlertPosition().getValue()))
		{
			return 3;
		}
		else if (GroupAlertPositionEnumeration.rdo4.equals(form.GroupAlertPosition().getValue()))
		{
			return 4;
		}
		else if (GroupAlertPositionEnumeration.rdo5.equals(form.GroupAlertPosition().getValue()))
		{
			return 5;
		}
		return 0;
		
		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.AdminNamespace.AlertPIDBarConfigMenu.EDIT:
				form.getLocalContext().setEditAlertPositionCategory(true);
				
				AlertTypeCollection  collAlerts=excludeUsedAlertsFromColl(form.getLocalContext().getCollAllerts());
				populateAlertCategoryCombo(collAlerts);
				
				if (form.grdAlerts().getValue()!=null && !Boolean.TRUE.equals(form.grdAlerts().getValue().isActive()))
				{
					form.cmbAlertCategory().newRow(form.grdAlerts().getValue(), form.grdAlerts().getValue().getText(), Color.Red);
				}
				
				form.cmbAlertCategory().setValue(form.grdAlerts().getValue());
				
			break;
		}
		
		updateControlsState();
	}

	private AlertTypeCollection excludeUsedAlertsFromColl(AlertTypeCollection collAllerts)
	{
		if (collAllerts==null || collAllerts.size()==0)
			return null;
		AlertTypeCollection tempCollAlerts=(AlertTypeCollection)collAllerts.clone();
		for (int i=0;i<form.grdAlerts().getRows().size();i++)
		{
			if (form.grdAlerts().getSelectedRow()!=null && form.grdAlerts().getRows().get(i).getColAlertPosition()==form.grdAlerts().getSelectedRow().getColAlertPosition())
			{
				continue;
			}
			
			if (form.grdAlerts().getRows().get(i).getValue()!=null && form.grdAlerts().getRows().get(i).getValue() instanceof AlertType)
			{
				tempCollAlerts.remove(form.grdAlerts().getRows().get(i).getValue());
			}
		}
		
		return tempCollAlerts;
	}

	private void populateAlertCategoryCombo(AlertTypeCollection collAllerts)
	{
		form.cmbAlertCategory().clear();
		
		if(collAllerts == null)
			return;
		
		for(int i=0; i<collAllerts.size(); i++)
		{
			AlertType item = collAllerts.get(i);
			
			if(item.isActive())
				form.cmbAlertCategory().newRow(item, item.getText());
		}
	}

	private Image getAlertIconByPosition(Integer colAlertPosition)
	{
		if (colAlertPosition==1)
			return  form.getImages().Core.AlertCategory1_16;
		else if (colAlertPosition==2)
			return  form.getImages().Core.AlertCategory2_16;
		else if (colAlertPosition==3)
			return  form.getImages().Core.AlertCategory3_16;
		else 
			return  form.getImages().Core.AlertCategory4_16;
		
	}

	private AlertTypeCollection getAlertsCategories()
	{
		TreeNode[] coll = LookupHelper.getAlertType(domain.getLookupService()).getRootNodes();
		
		AlertTypeCollection alertCategoryColl = new AlertTypeCollection();
	
		for(int i=0; i<coll.length; i++)
		{
			AlertType item = (AlertType) coll[i];
			
			if(item.getParent()==null && Boolean.TRUE.equals(item.isActive()))
			{
				alertCategoryColl.add(item);
			}
		}
		
		return alertCategoryColl;
	}
	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		boolean isEditMode = FormMode.EDIT.equals(form.getMode());
		
		form.GroupAlertPosition().setEnabled(isEditMode);
		form.grdAlerts().setReadOnly(true);
		form.grdAlerts().setEnabled(!form.getLocalContext().getEditAlertPositionCategory());
		
		form.btnEdit().setVisible(!isEditMode);
		form.btnSave().setVisible(isEditMode);
		form.btnCancel().setVisible(isEditMode);
		
		boolean editAlertPostionCateg = Boolean.TRUE.equals(form.getLocalContext().getEditAlertPositionCategory());
		form.img1().setVisible(form.grdAlerts().getSelectedRow()!=null);
		form.cmbAlertCategory().setEnabled(editAlertPostionCateg);
		form.cmbAlertCategory().setRequired(editAlertPostionCateg);
		form.btnOk().setVisible(editAlertPostionCateg);
		form.btnCancel1().setVisible(editAlertPostionCateg);
		form.getContextMenus().Admin.getAlertPIDBarConfigMenuEDITItem().setVisible(isEditMode && form.grdAlerts().getSelectedRow()!=null);
	}

	@Override
	protected void onBtnOkClick() throws PresentationLogicException
	{
		if (form.cmbAlertCategory().getValue()==null)
		{
			engine.showMessage("Alert category is mandatory!");
			return;
		}
		
		updateRow(form.grdAlerts().getSelectedRow());
		form.getLocalContext().setEditAlertPositionCategory(false);
		updateControlsState();
	}

	private void updateRow(grdAlertsRow row)
	{
		if (row==null)
			return;
	
		row.setColAlertIcon(getAlertIconByPosition(row.getColAlertPosition()));
		row.setColAlertCategory(form.cmbAlertCategory().getValue().getText());
		row.setTooltipForColAlertCategory(form.cmbAlertCategory().getValue().getText());
		row.setValue(form.cmbAlertCategory().getValue());
	}

	@Override
	protected void onBtnCancel1Click() throws PresentationLogicException
	{
		form.getLocalContext().setEditAlertPositionCategory(false);
		updateControlsState();
	}

	@Override
	protected void onGrdAlertsSelectionChanged() throws PresentationLogicException
	{
		populateAlertPositionDetails(form.grdAlerts().getSelectedRow());
		updateControlsState();
		
	}

	private void populateAlertPositionDetails(grdAlertsRow selectedRow)
	{
		clearAlertPositionDetails();
	
		if (selectedRow==null)
			return;
		
		form.lblAlertPositionValue().setValue(selectedRow.getColAlertPosition().toString());
		form.img1().setValue(getAlertIconByPosition(selectedRow.getColAlertPosition()));
		if (selectedRow.getValue()!=null)
		{
			if (Boolean.TRUE.equals(form.grdAlerts().getValue().isActive()))
			{
				form.cmbAlertCategory().newRow(selectedRow.getValue(), selectedRow.getValue().getText());
			}
			else
			{
				form.cmbAlertCategory().newRow(selectedRow.getValue(), selectedRow.getValue().getText(), Color.Red);
			}
			
			form.cmbAlertCategory().setValue(selectedRow.getValue());
		}
	
	}

	private void clearAlertPositionDetails()
	{
		form.lblAlertPositionValue().setValue(null);
		form.img1().setValue(null);
		form.cmbAlertCategory().setValue(null);
	}
}
