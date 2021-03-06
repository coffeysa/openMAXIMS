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
package ims.pci.forms.familyrecords;

import java.io.Serializable;

public final class ConfigFlags extends ims.framework.FormConfigFlags implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final DEMOGRAPHICS_FORMClass DEMOGRAPHICS_FORM;

	public ConfigFlags(ims.framework.ConfigFlag configFlags)
	{
		super(configFlags);

		DEMOGRAPHICS_FORM = new DEMOGRAPHICS_FORMClass(configFlags);
	}

	public final class DEMOGRAPHICS_FORMClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public DEMOGRAPHICS_FORMClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public ims.framework.Form getValue()
		{
			return (ims.framework.Form)configFlags.get("DEMOGRAPHICS_FORM");
		}
	}
}
