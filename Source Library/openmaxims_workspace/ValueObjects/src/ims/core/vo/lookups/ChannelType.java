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

public class ChannelType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ChannelType()
	{
		super();
	}
	public ChannelType(int id)
	{
		super(id, "", true);
	}
	public ChannelType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ChannelType(int id, String text, boolean active, ChannelType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ChannelType(int id, String text, boolean active, ChannelType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ChannelType(int id, String text, boolean active, ChannelType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ChannelType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ChannelType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ChannelType)super.getParentInstance();
	}
	public ChannelType getParent()
	{
		return (ChannelType)super.getParentInstance();
	}
	public void setParent(ChannelType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ChannelType[] typedChildren = new ChannelType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ChannelType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ChannelType)
		{
			super.addChild((ChannelType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ChannelType)
		{
			super.removeChild((ChannelType)child);
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
		ChannelTypeCollection result = new ChannelTypeCollection();
		result.add(GEN_PHONE);
		result.add(HOME_PHONE);
		result.add(WORK_PHONE);
		result.add(MOBILE);
		result.add(EMAIL);
		result.add(WEB);
		result.add(FAX);
		result.add(BLEEP);
		result.add(EMERGENCY);
		return result;
	}
	public static ChannelType[] getNegativeInstances()
	{
		ChannelType[] instances = new ChannelType[9];
		instances[0] = GEN_PHONE;
		instances[1] = HOME_PHONE;
		instances[2] = WORK_PHONE;
		instances[3] = MOBILE;
		instances[4] = EMAIL;
		instances[5] = WEB;
		instances[6] = FAX;
		instances[7] = BLEEP;
		instances[8] = EMERGENCY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[9];
		negativeInstances[0] = "GEN_PHONE";
		negativeInstances[1] = "HOME_PHONE";
		negativeInstances[2] = "WORK_PHONE";
		negativeInstances[3] = "MOBILE";
		negativeInstances[4] = "EMAIL";
		negativeInstances[5] = "WEB";
		negativeInstances[6] = "FAX";
		negativeInstances[7] = "BLEEP";
		negativeInstances[8] = "EMERGENCY";
		return negativeInstances;
	}
	public static ChannelType getNegativeInstance(String name)
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
	public static ChannelType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ChannelType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021149;
	public static final ChannelType GEN_PHONE = new ChannelType(-739, "General Phone Number", true, null, null, Color.Default);
	public static final ChannelType HOME_PHONE = new ChannelType(-740, "Home Phone Number", true, null, null, Color.Default);
	public static final ChannelType WORK_PHONE = new ChannelType(-741, "Work Phone Number", true, null, null, Color.Default);
	public static final ChannelType MOBILE = new ChannelType(-742, "Mobile Phone Number", true, null, null, Color.Default);
	public static final ChannelType EMAIL = new ChannelType(-743, "Email Address", true, null, null, Color.Default);
	public static final ChannelType WEB = new ChannelType(-744, "Web Address", true, null, null, Color.Default);
	public static final ChannelType FAX = new ChannelType(-745, "Fax Number", true, null, null, Color.Default);
	public static final ChannelType BLEEP = new ChannelType(-803, "Bleep", true, null, null, Color.Default);
	public static final ChannelType EMERGENCY = new ChannelType(-1583, "EMERGENCY", true, null, null, Color.Default);
}