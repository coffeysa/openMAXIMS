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

package ims.ocrr.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.Configuration.OrderEntryTemplateComponent business object (ID: 1061100006).
 */
public class OrderEntryTemplateComponentShortVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<OrderEntryTemplateComponentShortVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderEntryTemplateComponentShortVo> col = new ArrayList<OrderEntryTemplateComponentShortVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.configuration.domain.objects.OrderEntryTemplateComponent";
	}
	public boolean add(OrderEntryTemplateComponentShortVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OrderEntryTemplateComponentShortVo value)
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
	public int indexOf(OrderEntryTemplateComponentShortVo instance)
	{
		return col.indexOf(instance);
	}
	public OrderEntryTemplateComponentShortVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OrderEntryTemplateComponentShortVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OrderEntryTemplateComponentShortVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OrderEntryTemplateComponentShortVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OrderEntryTemplateComponentShortVoCollection clone = new OrderEntryTemplateComponentShortVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OrderEntryTemplateComponentShortVo)this.col.get(x).clone());
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
	public OrderEntryTemplateComponentShortVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OrderEntryTemplateComponentShortVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public OrderEntryTemplateComponentShortVoCollection sort(SortOrder order)
	{
		return sort(new OrderEntryTemplateComponentShortVoComparator(order));
	}
	public OrderEntryTemplateComponentShortVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new OrderEntryTemplateComponentShortVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public OrderEntryTemplateComponentShortVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.configuration.vo.OrderEntryTemplateComponentRefVoCollection toRefVoCollection()
	{
		ims.ocrr.configuration.vo.OrderEntryTemplateComponentRefVoCollection result = new ims.ocrr.configuration.vo.OrderEntryTemplateComponentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public OrderEntryTemplateComponentShortVo[] toArray()
	{
		OrderEntryTemplateComponentShortVo[] arr = new OrderEntryTemplateComponentShortVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<OrderEntryTemplateComponentShortVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OrderEntryTemplateComponentShortVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public OrderEntryTemplateComponentShortVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OrderEntryTemplateComponentShortVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public OrderEntryTemplateComponentShortVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			OrderEntryTemplateComponentShortVo voObj1 = (OrderEntryTemplateComponentShortVo)obj1;
			OrderEntryTemplateComponentShortVo voObj2 = (OrderEntryTemplateComponentShortVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean[] result = new ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			OrderEntryTemplateComponentShortVo vo = ((OrderEntryTemplateComponentShortVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean)vo.getBean();
		}
		return result;
	}
	public static OrderEntryTemplateComponentShortVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		OrderEntryTemplateComponentShortVoCollection coll = new OrderEntryTemplateComponentShortVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static OrderEntryTemplateComponentShortVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.OrderEntryTemplateComponentShortVoBean[] beans)
	{
		OrderEntryTemplateComponentShortVoCollection coll = new OrderEntryTemplateComponentShortVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
