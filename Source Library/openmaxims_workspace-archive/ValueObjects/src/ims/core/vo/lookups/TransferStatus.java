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

public class TransferStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TransferStatus()
	{
		super();
	}
	public TransferStatus(int id)
	{
		super(id, "", true);
	}
	public TransferStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TransferStatus(int id, String text, boolean active, TransferStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TransferStatus(int id, String text, boolean active, TransferStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TransferStatus(int id, String text, boolean active, TransferStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TransferStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TransferStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TransferStatus)super.getParentInstance();
	}
	public TransferStatus getParent()
	{
		return (TransferStatus)super.getParentInstance();
	}
	public void setParent(TransferStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TransferStatus[] typedChildren = new TransferStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TransferStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TransferStatus)
		{
			super.addChild((TransferStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TransferStatus)
		{
			super.removeChild((TransferStatus)child);
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
		TransferStatusCollection result = new TransferStatusCollection();
		result.add(PENDING);
		result.add(TRANSFERRED);
		result.add(REJECTED);
		return result;
	}
	public static TransferStatus[] getNegativeInstances()
	{
		TransferStatus[] instances = new TransferStatus[3];
		instances[0] = PENDING;
		instances[1] = TRANSFERRED;
		instances[2] = REJECTED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PENDING";
		negativeInstances[1] = "TRANSFERRED";
		negativeInstances[2] = "REJECTED";
		return negativeInstances;
	}
	public static TransferStatus getNegativeInstance(String name)
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
	public static TransferStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TransferStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021232;
	public static final TransferStatus PENDING = new TransferStatus(-1624, "Pending", true, null, null, Color.Default);
	public static final TransferStatus TRANSFERRED = new TransferStatus(-1625, "Transferred", true, null, null, Color.Default);
	public static final TransferStatus REJECTED = new TransferStatus(-1626, "Rejected", true, null, null, Color.Default);
}