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

package ims.nursing.vo.beans;

public class CarePlanForCopyCarePlansVoBean extends ims.vo.ValueObjectBean
{
	public CarePlanForCopyCarePlansVoBean()
	{
	}
	public CarePlanForCopyCarePlansVoBean(ims.nursing.vo.CarePlanForCopyCarePlansVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.objective = vo.getObjective();
		this.interventions = vo.getInterventions() == null ? null : vo.getInterventions().getBeanCollection();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.nextevaluationtime = vo.getNextEvaluationTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getNextEvaluationTime().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.nursing.vo.beans.CarePlanTemplateBean)vo.getTemplate().getBean();
		this.careplanstatus = vo.getCarePlanStatus() == null ? null : vo.getCarePlanStatus().getBeanCollection();
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.CarePlanForCopyCarePlansVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.objective = vo.getObjective();
		this.interventions = vo.getInterventions() == null ? null : vo.getInterventions().getBeanCollection();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.nextevaluationtime = vo.getNextEvaluationTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getNextEvaluationTime().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.nursing.vo.beans.CarePlanTemplateBean)vo.getTemplate().getBean(map);
		this.careplanstatus = vo.getCarePlanStatus() == null ? null : vo.getCarePlanStatus().getBeanCollection();
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean(map);
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean(map);
	}

	public ims.nursing.vo.CarePlanForCopyCarePlansVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.CarePlanForCopyCarePlansVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.CarePlanForCopyCarePlansVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.CarePlanForCopyCarePlansVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.CarePlanForCopyCarePlansVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String value)
	{
		this.title = value;
	}
	public String getObjective()
	{
		return this.objective;
	}
	public void setObjective(String value)
	{
		this.objective = value;
	}
	public ims.nursing.vo.beans.CarePlanInterventionsBean[] getInterventions()
	{
		return this.interventions;
	}
	public void setInterventions(ims.nursing.vo.beans.CarePlanInterventionsBean[] value)
	{
		this.interventions = value;
	}
	public ims.framework.utils.beans.DateBean getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.beans.DateBean value)
	{
		this.nextevaluationdate = value;
	}
	public ims.framework.utils.beans.TimeBean getNextEvaluationTime()
	{
		return this.nextevaluationtime;
	}
	public void setNextEvaluationTime(ims.framework.utils.beans.TimeBean value)
	{
		this.nextevaluationtime = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.nursing.vo.beans.CarePlanTemplateBean value)
	{
		this.template = value;
	}
	public ims.nursing.vo.beans.CarePlanStatusBean[] getCarePlanStatus()
	{
		return this.careplanstatus;
	}
	public void setCarePlanStatus(ims.nursing.vo.beans.CarePlanStatusBean[] value)
	{
		this.careplanstatus = value;
	}
	public ims.nursing.vo.beans.CarePlanStatusBean getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.beans.CarePlanStatusBean value)
	{
		this.currentcareplanstatus = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.recordinginformation = value;
	}

	private Integer id;
	private int version;
	private String title;
	private String objective;
	private ims.nursing.vo.beans.CarePlanInterventionsBean[] interventions;
	private ims.framework.utils.beans.DateBean nextevaluationdate;
	private ims.framework.utils.beans.TimeBean nextevaluationtime;
	private ims.nursing.vo.beans.CarePlanTemplateBean template;
	private ims.nursing.vo.beans.CarePlanStatusBean[] careplanstatus;
	private ims.nursing.vo.beans.CarePlanStatusBean currentcareplanstatus;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.RecordingUserInformationVoBean recordinginformation;
}
