// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.bookappointment;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().RefMan.getCatsReferralIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Scheduling = new SchedulingForms();
			RefMan = new RefManForms();
		}
		public final class SchedulingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SchedulingForms()
			{
				PrintAppointment = new LocalFormName(114163);
				SessionSlotDialog = new LocalFormName(114164);
			}
			public final FormName PrintAppointment;
			public final FormName SessionSlotDialog;
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				ERODDialog = new LocalFormName(134216);
			}
			public final FormName ERODDialog;
		}

		public SchedulingForms Scheduling;
		public RefManForms RefMan;
	}
}
