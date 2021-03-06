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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.66 build 3243.27592)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.baylayoutconfig;

import ims.core.vo.BayConfigVo;
import ims.core.vo.BayConfigVoCollection;
import ims.core.vo.FloorBedSpaceLayoutLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.WardBayConfigVo;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final int COLUMN_NAME = 1;
	private static final int COLUMN_FLOOR = 2;
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{		
		initialize();
		open();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	private void initialize()
	{
		form.cmbHospital().clear();
		LocationLiteVoCollection voCollHospital = domain.listActiveHospitalsLite();
		if(voCollHospital != null)
		{
			for(LocationLiteVo voHosp : voCollHospital)
				form.cmbHospital().newRow(voHosp, voHosp.getName());
		}
				
		initializeLayouts();
		initializeDynamicGrid();
	}
	
	private void initializeLayouts()
	{
		form.getLocalContext().setActiveLayouts(domain.listFloorBedLayouts());
	}
	
	private void initializeDynamicGrid() 
	{
		form.dyngrdLinks().clear();
		
		form.dyngrdLinks().setSelectable(true);
		
		DynamicGridColumn column = form.dyngrdLinks().getColumns().newColumn("Wards / Bays", COLUMN_NAME);
		column.setWidth(350);
		column = form.dyngrdLinks().getColumns().newColumn("Floor Layout", COLUMN_FLOOR);
		column.setWidth(-1);
	}
	
	private void open()
	{		
		form.setMode(FormMode.VIEW);
		form.dyngrdLinks().getRows().clear();
		cmbHospitalValueChanged();
	}
	
	private void addWard(LocationLiteVo ward) 
	{
		if(ward == null)
			return;
		
		DynamicGridRow row = form.dyngrdLinks().getRows().newRow();
		DynamicGridCell cellName = row.getCells().newCell(getNameColumn(), DynamicCellType.LABEL);
		cellName.setValue(ward.getName());	
		cellName.setIdentifier(ward);
		cellName.setBackColor(Color.Bisque);
		
		DynamicGridCell cellFloor = row.getCells().newCell(getFloorColumn(), DynamicCellType.LABEL);
		cellFloor.setValue("");		
		cellFloor.setBackColor(Color.Bisque);
				
		row.setSelectable(false);
		row.setExpanded(true);
		
		row.setExpandedImage(form.getImages().Admin.Location);
		row.setCollapsedImage(form.getImages().Admin.Location);
		row.setSelectedImage(form.getImages().Admin.Location);
			
		WardBayConfigVo voWardBayConfig = domain.getWardBayConfigByWard(ward);
		if(voWardBayConfig == null)
			voWardBayConfig = new WardBayConfigVo();
		
		row.setValue(voWardBayConfig);
		
		loadBays(voWardBayConfig, row);
	}
		
	private void loadBays(WardBayConfigVo voWardBayConfig, DynamicGridRow row)
	{		
		if(row == null || voWardBayConfig == null)
			throw new CodingRuntimeException("madatory parameters not present in method loadBays");
		
		BayConfigVoCollection bays = voWardBayConfig.getBays();
		if(bays != null)
		{
			for(int x = 0; x < bays.size(); x++)			
			{
			 //wdev-13964
			 if (bays.get(x).getIsActive())
			 {
				 addBay(row, bays.get(x)); 
			 }
								
			}
		}
	}
	
	private DynamicGridColumn getNameColumn() 
	{
		return form.dyngrdLinks().getColumns().getByIdentifier(COLUMN_NAME);		
	}
	
	private DynamicGridColumn getFloorColumn() 
	{
		return form.dyngrdLinks().getColumns().getByIdentifier(COLUMN_FLOOR);		
	}
	
	private DynamicGridRow addBay(DynamicGridRow parentRow, BayConfigVo bayConfigVo) 
	{
		if(parentRow == null || bayConfigVo == null)
			return null;
		
		DynamicGridRow row = parentRow.getRows().newRow();
		
		if(bayConfigVo.getBayIsNotNull())
		{
			DynamicGridCell cell = row.getCells().newCell(getNameColumn(), DynamicCellType.LABEL);
			cell.setValue(bayConfigVo.getBay().getName());
			cell.setIdentifier(bayConfigVo);
		}

		row.setExpandedImage(form.getImages().Admin.Location);
		row.setCollapsedImage(form.getImages().Admin.Location);
		row.setSelectable(false);
		
		if(bayConfigVo.getFloorBedSpaceLayoutIsNotNull())
		{
			DynamicGridCell floorCell = row.getCells().newCell(getFloorColumn(), DynamicCellType.LABEL);
	
			FloorBedSpaceLayoutLiteVo floorLayout = bayConfigVo.getFloorBedSpaceLayout(); 
			if(floorLayout != null)
			{
				floorCell.setValue(floorLayout.getName());
				floorCell.setIdentifier(floorLayout);	
			}
		}
		
		return row;
	}
	
	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException
	{
		cmbHospitalValueChanged();
		updateControlState();
	}
	
	private void cmbHospitalValueChanged()
	{
		form.dyngrdLinks().getRows().clear();
		if(form.cmbHospital().getValue() == null)
			return;
		
		LocationLiteVoCollection wards = domain.listActiveWardsForHospitalLite(form.cmbHospital().getValue());
		if(wards != null)
		{
			for(int x = 0; x < wards.size(); x++)
			{
				addWard(wards.get(x));
			}
		}
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.BayLayoutConfig.CONFIGURE_WARD:
			{
				form.setMode(FormMode.EDIT);
			}
				
			break;
			default:
		}
	}
	
	private WardBayConfigVo getWardBayConfig()
	{
		WardBayConfigVo voWardBayConfig = null; 
		DynamicGridRow row = form.dyngrdLinks().getSelectedRow();
		BayConfigVoCollection voCollBayConfig = new BayConfigVoCollection(); 
		if(row != null)
		{
			voWardBayConfig = (WardBayConfigVo) row.getValue();
			if(voWardBayConfig == null)
				voWardBayConfig = new WardBayConfigVo();
			
			voWardBayConfig.setWard((LocationLiteVo) row.getCells().get(getNameColumn()).getIdentifier());	
			
			for(int i=0;i<row.getRows().size();i++)
			{
				BayConfigVo voConfig = (BayConfigVo) row.getRows().get(i).getValue();
				voCollBayConfig.add(voConfig);
			}
		}
		return voWardBayConfig;
	}
	
	@Override
	protected void onDyngrdLinksRowSelectionChanged(DynamicGridRow row)
	{
		WardBayConfigVo voWardBayConfig = getWardBayConfig();
		form.getGlobalContext().STHK.setWardBayConfigVo(voWardBayConfig);
		engine.open(form.getForms().Core.WardBayConfigDialog);
	}
	
	private void updateControlState()
	{
		form.getContextMenus().Core.getBayLayoutConfigCONFIGURE_WARDItem().setVisible(form.getMode().equals(FormMode.VIEW) && form.cmbHospital().getValue() != null);
		for(int i=0;i<form.dyngrdLinks().getRows().size();i++)
		{
			DynamicGridRow lRow = form.dyngrdLinks().getRows().get(i);
			lRow.setSelectable(form.getMode().equals(FormMode.EDIT));
		}
		
		form.btnEdit().setVisible(form.getMode().equals(FormMode.VIEW) && form.cmbHospital().getValue() != null);
	}
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}
	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}
}
