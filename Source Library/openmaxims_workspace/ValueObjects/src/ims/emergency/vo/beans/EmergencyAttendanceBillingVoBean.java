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

package ims.emergency.vo.beans;

public class EmergencyAttendanceBillingVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceBillingVoBean()
	{
	}
	public EmergencyAttendanceBillingVoBean(ims.emergency.vo.EmergencyAttendanceBillingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.emergencyattendence = vo.getEmergencyAttendence() == null ? null : new ims.vo.RefVoBean(vo.getEmergencyAttendence().getBoId(), vo.getEmergencyAttendence().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.ispatientexempt = vo.getIsPatientExempt() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsPatientExempt().getBean();
		this.exemptionreason = vo.getExemptionReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getExemptionReason().getBean();
		this.exemptionreasonother = vo.getExemptionReasonOther();
		this.paymentmade = vo.getPaymentMade() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentMade().getBean();
		this.paymenttype = vo.getPaymentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentType().getBean();
		this.reasonfornonpayment = vo.getReasonForNonPayment() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForNonPayment().getBean();
		this.paymentrefunded = vo.getPaymentRefunded() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentRefunded().getBean();
		this.invoiceamount = vo.getInvoiceAmount() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvoiceAmount().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceBillingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.emergencyattendence = vo.getEmergencyAttendence() == null ? null : new ims.vo.RefVoBean(vo.getEmergencyAttendence().getBoId(), vo.getEmergencyAttendence().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.ispatientexempt = vo.getIsPatientExempt() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsPatientExempt().getBean();
		this.exemptionreason = vo.getExemptionReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getExemptionReason().getBean();
		this.exemptionreasonother = vo.getExemptionReasonOther();
		this.paymentmade = vo.getPaymentMade() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentMade().getBean();
		this.paymenttype = vo.getPaymentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentType().getBean();
		this.reasonfornonpayment = vo.getReasonForNonPayment() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForNonPayment().getBean();
		this.paymentrefunded = vo.getPaymentRefunded() == null ? null : (ims.vo.LookupInstanceBean)vo.getPaymentRefunded().getBean();
		this.invoiceamount = vo.getInvoiceAmount() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvoiceAmount().getBean();
	}

	public ims.emergency.vo.EmergencyAttendanceBillingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceBillingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceBillingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceBillingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceBillingVo();
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
	public ims.vo.RefVoBean getEmergencyAttendence()
	{
		return this.emergencyattendence;
	}
	public void setEmergencyAttendence(ims.vo.RefVoBean value)
	{
		this.emergencyattendence = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.LookupInstanceBean getIsPatientExempt()
	{
		return this.ispatientexempt;
	}
	public void setIsPatientExempt(ims.vo.LookupInstanceBean value)
	{
		this.ispatientexempt = value;
	}
	public ims.vo.LookupInstanceBean getExemptionReason()
	{
		return this.exemptionreason;
	}
	public void setExemptionReason(ims.vo.LookupInstanceBean value)
	{
		this.exemptionreason = value;
	}
	public String getExemptionReasonOther()
	{
		return this.exemptionreasonother;
	}
	public void setExemptionReasonOther(String value)
	{
		this.exemptionreasonother = value;
	}
	public ims.vo.LookupInstanceBean getPaymentMade()
	{
		return this.paymentmade;
	}
	public void setPaymentMade(ims.vo.LookupInstanceBean value)
	{
		this.paymentmade = value;
	}
	public ims.vo.LookupInstanceBean getPaymentType()
	{
		return this.paymenttype;
	}
	public void setPaymentType(ims.vo.LookupInstanceBean value)
	{
		this.paymenttype = value;
	}
	public ims.vo.LookupInstanceBean getReasonForNonPayment()
	{
		return this.reasonfornonpayment;
	}
	public void setReasonForNonPayment(ims.vo.LookupInstanceBean value)
	{
		this.reasonfornonpayment = value;
	}
	public ims.vo.LookupInstanceBean getPaymentRefunded()
	{
		return this.paymentrefunded;
	}
	public void setPaymentRefunded(ims.vo.LookupInstanceBean value)
	{
		this.paymentrefunded = value;
	}
	public ims.vo.LookupInstanceBean getInvoiceAmount()
	{
		return this.invoiceamount;
	}
	public void setInvoiceAmount(ims.vo.LookupInstanceBean value)
	{
		this.invoiceamount = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean emergencyattendence;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean attendance;
	private ims.vo.LookupInstanceBean ispatientexempt;
	private ims.vo.LookupInstanceBean exemptionreason;
	private String exemptionreasonother;
	private ims.vo.LookupInstanceBean paymentmade;
	private ims.vo.LookupInstanceBean paymenttype;
	private ims.vo.LookupInstanceBean reasonfornonpayment;
	private ims.vo.LookupInstanceBean paymentrefunded;
	private ims.vo.LookupInstanceBean invoiceamount;
}
