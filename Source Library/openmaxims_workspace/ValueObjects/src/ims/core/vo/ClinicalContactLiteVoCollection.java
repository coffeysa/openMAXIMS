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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.Clinical Contact business object (ID: 1004100003).
 */
public class ClinicalContactLiteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ClinicalContactLiteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ClinicalContactLiteVo> col = new ArrayList<ClinicalContactLiteVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.domain.objects.ClinicalContact";
	}
	public boolean add(ClinicalContactLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ClinicalContactLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(ClinicalContactLiteVo instance)
	{
		return col.indexOf(instance);
	}
	public ClinicalContactLiteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ClinicalContactLiteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ClinicalContactLiteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ClinicalContactLiteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ClinicalContactLiteVoCollection clone = new ClinicalContactLiteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ClinicalContactLiteVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public ClinicalContactLiteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ClinicalContactLiteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ClinicalContactLiteVoCollection sort(SortOrder order)
	{
		return sort(new ClinicalContactLiteVoComparator(order));
	}
	public ClinicalContactLiteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ClinicalContactLiteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ClinicalContactLiteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.vo.ClinicalContactRefVoCollection toRefVoCollection()
	{
		ims.core.admin.vo.ClinicalContactRefVoCollection result = new ims.core.admin.vo.ClinicalContactRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ClinicalContactLiteVo[] toArray()
	{
		ClinicalContactLiteVo[] arr = new ClinicalContactLiteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ClinicalContactLiteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ClinicalContactLiteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ClinicalContactLiteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ClinicalContactLiteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ClinicalContactLiteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ClinicalContactLiteVo voObj1 = (ClinicalContactLiteVo)obj1;
			ClinicalContactLiteVo voObj2 = (ClinicalContactLiteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.ClinicalContactLiteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.ClinicalContactLiteVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.ClinicalContactLiteVoBean[] result = new ims.core.vo.beans.ClinicalContactLiteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ClinicalContactLiteVo vo = ((ClinicalContactLiteVo)col.get(i));
			result[i] = (ims.core.vo.beans.ClinicalContactLiteVoBean)vo.getBean();
		}
		return result;
	}
	public static ClinicalContactLiteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ClinicalContactLiteVoCollection coll = new ClinicalContactLiteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.ClinicalContactLiteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ClinicalContactLiteVoCollection buildFromBeanCollection(ims.core.vo.beans.ClinicalContactLiteVoBean[] beans)
	{
		ClinicalContactLiteVoCollection coll = new ClinicalContactLiteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
