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

package ims.clinical.vo.beans;

public class ContextFilterVoBean extends ims.vo.ValueObjectBean
{
	public ContextFilterVoBean()
	{
	}
	public ContextFilterVoBean(ims.clinical.vo.ContextFilterVo vo)
	{
		this.context = vo.getContext();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.ContextFilterVo vo)
	{
		this.context = vo.getContext();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
	}

	public ims.clinical.vo.ContextFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.ContextFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.ContextFilterVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.ContextFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.ContextFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getContext()
	{
		return this.context;
	}
	public void setContext(Integer value)
	{
		this.context = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}

	private Integer context;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
}
