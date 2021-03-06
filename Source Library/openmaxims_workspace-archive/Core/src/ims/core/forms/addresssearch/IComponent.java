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

package ims.core.forms.addresssearch;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	/**
	* getAddress
	*/
	public ims.core.vo.PersonAddress getValue();

	/**
	* set address value
	*/
	public void setValue(ims.core.vo.PersonAddress address);

	/**
	* clear the display elements
	*/
	public void clearscreen();

	/**
	* set phone number visibility
	*/
	public void setPhoneVisible(Boolean value);

	public void setEnabled(Boolean enabled);

	public void setComponentEnabled(Boolean value);

	public void setTitle(String title);

	/**
	* verify PCT code for currently set postcode and return the correct PCT
	*/
	public String verifyPCT(String postCode);

	public void setHistoricAddressBtnVisible(Boolean value);

	public void setSearchControlsVisible(Boolean value);

	public void setRequireAdress(Boolean enable);
}
