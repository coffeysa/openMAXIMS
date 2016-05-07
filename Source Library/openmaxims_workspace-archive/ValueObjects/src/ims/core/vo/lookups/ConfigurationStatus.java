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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ConfigurationStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ConfigurationStatus()
	{
		super();
	}
	public ConfigurationStatus(int id)
	{
		super(id, "", true);
	}
	public ConfigurationStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ConfigurationStatus(int id, String text, boolean active, ConfigurationStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ConfigurationStatus(int id, String text, boolean active, ConfigurationStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ConfigurationStatus(int id, String text, boolean active, ConfigurationStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ConfigurationStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ConfigurationStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ConfigurationStatus)super.getParentInstance();
	}
	public ConfigurationStatus getParent()
	{
		return (ConfigurationStatus)super.getParentInstance();
	}
	public void setParent(ConfigurationStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ConfigurationStatus[] typedChildren = new ConfigurationStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ConfigurationStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ConfigurationStatus)
		{
			super.addChild((ConfigurationStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ConfigurationStatus)
		{
			super.removeChild((ConfigurationStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		ConfigurationStatusCollection result = new ConfigurationStatusCollection();
		result.add(PREACTIVE);
		result.add(ACTIVE);
		result.add(SUPERCEEDED);
		return result;
	}
	public static ConfigurationStatus[] getNegativeInstances()
	{
		ConfigurationStatus[] instances = new ConfigurationStatus[3];
		instances[0] = PREACTIVE;
		instances[1] = ACTIVE;
		instances[2] = SUPERCEEDED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PREACTIVE";
		negativeInstances[1] = "ACTIVE";
		negativeInstances[2] = "SUPERCEEDED";
		return negativeInstances;
	}
	public static ConfigurationStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static ConfigurationStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ConfigurationStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021113;
	public static final ConfigurationStatus PREACTIVE = new ConfigurationStatus(-301, "PreActive", true, null, null, Color.Default);
	public static final ConfigurationStatus ACTIVE = new ConfigurationStatus(-302, "Active", true, null, null, Color.Default);
	public static final ConfigurationStatus SUPERCEEDED = new ConfigurationStatus(-303, "Superceded", true, null, null, Color.Default);
}