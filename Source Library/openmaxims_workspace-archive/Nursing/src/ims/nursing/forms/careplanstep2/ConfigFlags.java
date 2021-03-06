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
package ims.nursing.forms.careplanstep2;

import java.io.Serializable;

public final class ConfigFlags extends ims.framework.FormConfigFlags implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final STALE_OBJECT_MESSAGEClass STALE_OBJECT_MESSAGE;
	public final CAREPLAN_CONFIRMED_BY_DETAILSClass CAREPLAN_CONFIRMED_BY_DETAILS;
	public final CONFIRM_FOR_STUDENT_NURSEClass CONFIRM_FOR_STUDENT_NURSE;
	public final CAREPLAN_ACTION_TEXT_LENGTHClass CAREPLAN_ACTION_TEXT_LENGTH;

	public ConfigFlags(ims.framework.ConfigFlag configFlags)
	{
		super(configFlags);

		STALE_OBJECT_MESSAGE = new STALE_OBJECT_MESSAGEClass(configFlags);
		CAREPLAN_CONFIRMED_BY_DETAILS = new CAREPLAN_CONFIRMED_BY_DETAILSClass(configFlags);
		CONFIRM_FOR_STUDENT_NURSE = new CONFIRM_FOR_STUDENT_NURSEClass(configFlags);
		CAREPLAN_ACTION_TEXT_LENGTH = new CAREPLAN_ACTION_TEXT_LENGTHClass(configFlags);
	}

	public final class STALE_OBJECT_MESSAGEClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public STALE_OBJECT_MESSAGEClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public String getValue()
		{
			return (String)configFlags.get("STALE_OBJECT_MESSAGE");
		}
	}
	public final class CAREPLAN_CONFIRMED_BY_DETAILSClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public CAREPLAN_CONFIRMED_BY_DETAILSClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public Boolean getValue()
		{
			return (Boolean)configFlags.get("CAREPLAN_CONFIRMED_BY_DETAILS");
		}
	}
	public final class CONFIRM_FOR_STUDENT_NURSEClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public CONFIRM_FOR_STUDENT_NURSEClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public Boolean getValue()
		{
			return (Boolean)configFlags.get("CONFIRM_FOR_STUDENT_NURSE");
		}
	}
	public final class CAREPLAN_ACTION_TEXT_LENGTHClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public CAREPLAN_ACTION_TEXT_LENGTHClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public Integer getValue()
		{
			return (Integer)configFlags.get("CAREPLAN_ACTION_TEXT_LENGTH");
		}
	}
}
