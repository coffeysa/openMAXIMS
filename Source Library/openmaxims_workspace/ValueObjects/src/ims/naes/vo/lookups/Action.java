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

package ims.naes.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class Action extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Action()
	{
		super();
	}
	public Action(int id)
	{
		super(id, "", true);
	}
	public Action(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Action(int id, String text, boolean active, Action parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Action(int id, String text, boolean active, Action parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Action(int id, String text, boolean active, Action parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Action buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Action(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Action)super.getParentInstance();
	}
	public Action getParent()
	{
		return (Action)super.getParentInstance();
	}
	public void setParent(Action parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Action[] typedChildren = new Action[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Action)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Action)
		{
			super.addChild((Action)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Action)
		{
			super.removeChild((Action)child);
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
		ActionCollection result = new ActionCollection();
		result.add(EYESIN);
		result.add(LABCOMP);
		result.add(SCLERACODEVERIFIED);
		result.add(EYESOUT);
		return result;
	}
	public static Action[] getNegativeInstances()
	{
		Action[] instances = new Action[4];
		instances[0] = EYESIN;
		instances[1] = LABCOMP;
		instances[2] = SCLERACODEVERIFIED;
		instances[3] = EYESOUT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "EYESIN";
		negativeInstances[1] = "LABCOMP";
		negativeInstances[2] = "SCLERACODEVERIFIED";
		negativeInstances[3] = "EYESOUT";
		return negativeInstances;
	}
	public static Action getNegativeInstance(String name)
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
	public static Action getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Action[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1351000;
	public static final Action EYESIN = new Action(-1613, "Eyes in", true, null, null, Color.Default);
	public static final Action LABCOMP = new Action(-1735, "Final Cure", true, null, null, Color.Default);
	public static final Action SCLERACODEVERIFIED = new Action(-1736, "Sclera Code Verified", true, null, null, Color.Default);
	public static final Action EYESOUT = new Action(-1737, "Eyes out", true, null, null, Color.Default);
}
