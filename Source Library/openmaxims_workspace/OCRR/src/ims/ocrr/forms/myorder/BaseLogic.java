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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.forms.myorder;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ocrr.domain.MyOrder.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ocrr.domain.MyOrder domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.ocrr.vo.lookups.AuthorisationOrderStatusCollection.class, ims.ocrr.vo.lookups.AuthorisationOrderStatus.class, 1161048, false) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'AuthorisationOrderStatus' (ID: 1161048) must have at least one instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	protected final void oncmbOrderCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabGenDetails().cmbOrderCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderCategory existingInstance = (ims.ocrr.vo.lookups.OrderCategory)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOrderCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.OrderCategory)
		{
			ims.ocrr.vo.lookups.OrderCategory instance = (ims.ocrr.vo.lookups.OrderCategory)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOrderCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderCategory existingInstance = (ims.ocrr.vo.lookups.OrderCategory)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabGenDetails().cmbOrderCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOrderCategoryLookup()
	{
		this.form.lyrDetails().tabGenDetails().cmbOrderCategory().clear();
		ims.ocrr.vo.lookups.OrderCategoryCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getOrderCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabGenDetails().cmbOrderCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOrderCategoryLookupValue(int id)
	{
		ims.ocrr.vo.lookups.OrderCategory instance = ims.ocrr.vo.lookups.LookupHelper.getOrderCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabGenDetails().cmbOrderCategory().setValue(instance);
	}
	protected final void defaultcmbOrderCategoryLookupValue()
	{
		this.form.lyrDetails().tabGenDetails().cmbOrderCategory().setValue((ims.ocrr.vo.lookups.OrderCategory)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.OrderCategory.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.OrderCategory.TYPE_ID));
	}
	protected final void oncmbPriorityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabGenDetails().cmbPriority().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderPriority existingInstance = (ims.ocrr.vo.lookups.OrderPriority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPriorityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.OrderPriority)
		{
			ims.ocrr.vo.lookups.OrderPriority instance = (ims.ocrr.vo.lookups.OrderPriority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPriorityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderPriority existingInstance = (ims.ocrr.vo.lookups.OrderPriority)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabGenDetails().cmbPriority().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPriorityLookup()
	{
		this.form.lyrDetails().tabGenDetails().cmbPriority().clear();
		ims.ocrr.vo.lookups.OrderPriorityCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getOrderPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabGenDetails().cmbPriority().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPriorityLookupValue(int id)
	{
		ims.ocrr.vo.lookups.OrderPriority instance = ims.ocrr.vo.lookups.LookupHelper.getOrderPriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabGenDetails().cmbPriority().setValue(instance);
	}
	protected final void defaultcmbPriorityLookupValue()
	{
		this.form.lyrDetails().tabGenDetails().cmbPriority().setValue((ims.ocrr.vo.lookups.OrderPriority)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.OrderPriority.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.OrderPriority.TYPE_ID));
	}
	protected final void oncmbPatMobilityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabRadDetails().cmbPatMobility().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderPatMobility existingInstance = (ims.ocrr.vo.lookups.OrderPatMobility)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatMobilityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.OrderPatMobility)
		{
			ims.ocrr.vo.lookups.OrderPatMobility instance = (ims.ocrr.vo.lookups.OrderPatMobility)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatMobilityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OrderPatMobility existingInstance = (ims.ocrr.vo.lookups.OrderPatMobility)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabRadDetails().cmbPatMobility().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatMobilityLookup()
	{
		this.form.lyrDetails().tabRadDetails().cmbPatMobility().clear();
		ims.ocrr.vo.lookups.OrderPatMobilityCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getOrderPatMobility(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabRadDetails().cmbPatMobility().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatMobilityLookupValue(int id)
	{
		ims.ocrr.vo.lookups.OrderPatMobility instance = ims.ocrr.vo.lookups.LookupHelper.getOrderPatMobilityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabRadDetails().cmbPatMobility().setValue(instance);
	}
	protected final void defaultcmbPatMobilityLookupValue()
	{
		this.form.lyrDetails().tabRadDetails().cmbPatMobility().setValue((ims.ocrr.vo.lookups.OrderPatMobility)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.OrderPatMobility.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.OrderPatMobility.TYPE_ID));
	}
	protected final void oncmbDurationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OutPatientDuration existingInstance = (ims.ocrr.vo.lookups.OutPatientDuration)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDurationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.OutPatientDuration)
		{
			ims.ocrr.vo.lookups.OutPatientDuration instance = (ims.ocrr.vo.lookups.OutPatientDuration)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDurationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.OutPatientDuration existingInstance = (ims.ocrr.vo.lookups.OutPatientDuration)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDurationLookup()
	{
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().clear();
		ims.ocrr.vo.lookups.OutPatientDurationCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getOutPatientDuration(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDurationLookupValue(int id)
	{
		ims.ocrr.vo.lookups.OutPatientDuration instance = ims.ocrr.vo.lookups.LookupHelper.getOutPatientDurationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().setValue(instance);
	}
	protected final void defaultcmbDurationLookupValue()
	{
		this.form.lyrDetails().tabPathDetails().lyrPathology().tabPhlebotomy().cmbDuration().setValue((ims.ocrr.vo.lookups.OutPatientDuration)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.OutPatientDuration.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.OutPatientDuration.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ocrr.domain.MyOrder domain;
}