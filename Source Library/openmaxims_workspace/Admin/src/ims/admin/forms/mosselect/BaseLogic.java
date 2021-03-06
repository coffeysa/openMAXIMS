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

package ims.admin.forms.mosselect;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.MosSelect.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.MosSelect domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbStaffTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStaffType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.StaffType existingInstance = (ims.core.vo.lookups.StaffType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStaffTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.StaffType)
		{
			ims.core.vo.lookups.StaffType instance = (ims.core.vo.lookups.StaffType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStaffTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.StaffType existingInstance = (ims.core.vo.lookups.StaffType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStaffType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStaffTypeLookup()
	{
		this.form.cmbStaffType().clear();
		ims.core.vo.lookups.StaffTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getStaffType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStaffType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStaffTypeLookupValue(int id)
	{
		ims.core.vo.lookups.StaffType instance = ims.core.vo.lookups.LookupHelper.getStaffTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStaffType().setValue(instance);
	}
	protected final void defaultcmbStaffTypeLookupValue()
	{
		this.form.cmbStaffType().setValue((ims.core.vo.lookups.StaffType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.StaffType.class, engine.getFormName().getID(), ims.core.vo.lookups.StaffType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.MosSelect domain;
}
