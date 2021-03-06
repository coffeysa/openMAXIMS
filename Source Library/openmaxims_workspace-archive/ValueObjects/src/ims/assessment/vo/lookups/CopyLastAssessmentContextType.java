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

package ims.assessment.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class CopyLastAssessmentContextType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public CopyLastAssessmentContextType()
	{
		super();
	}
	public CopyLastAssessmentContextType(int id)
	{
		super(id, "", true);
	}
	public CopyLastAssessmentContextType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public CopyLastAssessmentContextType(int id, String text, boolean active, CopyLastAssessmentContextType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public CopyLastAssessmentContextType(int id, String text, boolean active, CopyLastAssessmentContextType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public CopyLastAssessmentContextType(int id, String text, boolean active, CopyLastAssessmentContextType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static CopyLastAssessmentContextType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new CopyLastAssessmentContextType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (CopyLastAssessmentContextType)super.getParentInstance();
	}
	public CopyLastAssessmentContextType getParent()
	{
		return (CopyLastAssessmentContextType)super.getParentInstance();
	}
	public void setParent(CopyLastAssessmentContextType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		CopyLastAssessmentContextType[] typedChildren = new CopyLastAssessmentContextType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (CopyLastAssessmentContextType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof CopyLastAssessmentContextType)
		{
			super.addChild((CopyLastAssessmentContextType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof CopyLastAssessmentContextType)
		{
			super.removeChild((CopyLastAssessmentContextType)child);
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
		CopyLastAssessmentContextTypeCollection result = new CopyLastAssessmentContextTypeCollection();
		result.add(CARE_SPELL);
		result.add(EPISODEOFCARE);
		result.add(CARECONTEXT);
		result.add(PATIENT);
		return result;
	}
	public static CopyLastAssessmentContextType[] getNegativeInstances()
	{
		CopyLastAssessmentContextType[] instances = new CopyLastAssessmentContextType[4];
		instances[0] = CARE_SPELL;
		instances[1] = EPISODEOFCARE;
		instances[2] = CARECONTEXT;
		instances[3] = PATIENT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "CARE_SPELL";
		negativeInstances[1] = "EPISODEOFCARE";
		negativeInstances[2] = "CARECONTEXT";
		negativeInstances[3] = "PATIENT";
		return negativeInstances;
	}
	public static CopyLastAssessmentContextType getNegativeInstance(String name)
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
	public static CopyLastAssessmentContextType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		CopyLastAssessmentContextType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1271005;
	public static final CopyLastAssessmentContextType CARE_SPELL = new CopyLastAssessmentContextType(-1908, "Care Spell", true, null, null, Color.Default);
	public static final CopyLastAssessmentContextType EPISODEOFCARE = new CopyLastAssessmentContextType(-1909, "Episode of Care", true, null, null, Color.Default);
	public static final CopyLastAssessmentContextType CARECONTEXT = new CopyLastAssessmentContextType(-1910, "Care Context", true, null, null, Color.Default);
	public static final CopyLastAssessmentContextType PATIENT = new CopyLastAssessmentContextType(-2133, "Patient", true, null, null, Color.Default);
}
