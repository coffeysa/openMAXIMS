// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.printcorrespondencenotedialog;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdReportTypesGridButtonClicked(int column, GenForm.grdReportTypesRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdReportTypesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdReportTypesGridCheckBoxClicked(int column, GenForm.grdReportTypesRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormOpen();
			}
		});
		this.form.btnPreview().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPreviewClick();
			}
		});
		this.form.grdReportTypes().setGridButtonClickedEvent(new GridButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdReportTypesGridButtonClicked(column, new GenForm.grdReportTypesRow(row));
			}
		});
		this.form.grdReportTypes().setGridAnswerBoxValueChangedEvent(new GridAnswerBoxValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, int index) throws ims.framework.exceptions.PresentationLogicException
			{
				switch(column)
				{
				}
			}
		});
		this.form.grdReportTypes().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdReportTypesSelectionChanged();
			}
		});
		this.form.grdReportTypes().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdReportTypesGridCheckBoxClicked(column, new GenForm.grdReportTypesRow(row), isChecked);
			}
		});
		this.form.btnPrint().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPrintClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}