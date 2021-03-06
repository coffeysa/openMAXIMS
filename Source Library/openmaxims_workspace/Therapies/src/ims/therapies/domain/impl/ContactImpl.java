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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.therapies.domain.impl;

import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.domain.objects.Nurse;
import ims.core.resource.people.domain.objects.Therapist;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.domain.HcpAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.NurseVoAssembler;
import ims.core.vo.domain.TherapistVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.oncology.domain.objects.ContactTypesByDiscipline;
import ims.oncology.vo.domain.ContactTypesByDisciplineVoAssembler;
import ims.therapies.domain.base.impl.BaseContactImpl;
import ims.therapies.domain.objects.Contact;
import ims.therapies.vo.ContactRefVo;
import ims.therapies.vo.ContactSearchCriteriaVo;
import ims.therapies.vo.TherapiesContactVo;
import ims.therapies.vo.TherapiesContactVoCollection;
import ims.therapies.vo.domain.TherapiesContactVoAssembler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactImpl extends BaseContactImpl
{

	private static final long serialVersionUID = 1L;

	public TherapiesContactVo saveContact(TherapiesContactVo contact) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if(contact == null)
			throw new CodingRuntimeException("Cannot save null Contact");
		
		if (!contact.isValidated())
			throw new CodingRuntimeException("Contact has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		Contact doContact = TherapiesContactVoAssembler.extractContact(factory, contact);
		factory.save(doContact);
		
		return TherapiesContactVoAssembler.create(doContact);
	}

	public TherapiesContactVoCollection listContacts(ContactSearchCriteriaVo searchCriteria)
	{
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from Contact cc where ");
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		
		if (searchCriteria.getCareContext() != null)
		{
			condStr.append(andStr + " cc.careContext.id = :CC_ID");
			names.add("CC_ID");
			values.add(searchCriteria.getCareContext().getID_CareContext());
			andStr = " and ";
		}
		
		if (searchCriteria.getEpisodeOfCare() != null)
		{
			condStr.append(andStr + " cc.episodeOfCare.id = :EP_ID");
			names.add("EP_ID");
			values.add(searchCriteria.getEpisodeOfCare().getID_EpisodeOfCare());
			andStr = " and ";
		}
		
		if (searchCriteria.getHcpLite() != null)
		{
			condStr.append(andStr + " cc.contactHCP.id = :cHCP");
			names.add("cHCP");
			values.add(searchCriteria.getHcpLite().getID_Hcp());
			andStr = " and ";
		}
	
		if (searchCriteria.getHCPDiscipline() != null)
		{
			condStr.append(andStr + " cc.hCPDiscipline = :cDISP");
			names.add("cDISP");
			values.add(getDomLookup(searchCriteria.getHCPDiscipline()));
			andStr = " and ";
		}
	
		if (searchCriteria.getDateFrom() != null && searchCriteria.getDateTo() != null )
		{
			condStr.append(andStr + " ( cc.contactDateTime between :fromDate and :toDate )");
			names.add("fromDate");
			values.add(new DateTime(searchCriteria.getDateFrom(), new Time("00:00:00")).getJavaDate() );
			names.add("toDate");
			values.add(new DateTime(searchCriteria.getDateTo(), new Time("23:59:59")).getJavaDate() );
			andStr = " and ";
		}
		else if (searchCriteria.getDateFrom() != null && searchCriteria.getDateTo() == null)
		{
			condStr.append(andStr + " ( cc.contactDateTime >= :fromDate) ");
			names.add("fromDate");
			values.add(new DateTime(searchCriteria.getDateFrom(), new Time("00:00:00")).getJavaDate() );
			andStr = " and ";
			
		}
		else if (searchCriteria.getDateFrom() == null && searchCriteria.getDateTo() != null)
		{
			condStr.append(andStr + " ( cc.contactDateTime <= :toDate) ) ");
			names.add("toDate");
			values.add(new DateTime(searchCriteria.getDateTo(), new Time("23:59:59")).getJavaDate() );
			andStr = " and ";
		}
		
		hql.append(condStr.toString() + " order by contactDateTime asc");

		List list = factory.find(hql.toString(), names,values);
		return TherapiesContactVoAssembler.createTherapiesContactVoCollectionFromContact(list);
	}

	public ims.oncology.vo.ContactTypesByDisciplineVo loadDisciplineContacts(ims.vo.LookupInstVo hcpDisp)
	{
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from ContactTypesByDiscipline cd where cd.discipline = :disp ");
		names.add("disp");
		values.add(getDomLookup(hcpDisp));
		
		List list = factory.find(hql.toString(), names,values);
		
		if (list.size() > 0)
			return ContactTypesByDisciplineVoAssembler.create((ContactTypesByDiscipline)list.get(0));
		
		return null;
	}

	public ims.core.vo.Hcp getHCP(ims.core.resource.people.vo.HcpRefVo hcpRefVo)
	{
		DomainFactory factory = getDomainFactory();
		Hcp doHcp = (Hcp) factory.getDomainObject(Hcp.class, hcpRefVo.getID_Hcp());

		if (Medic.class.isAssignableFrom(doHcp.getClass()))
			return MedicVoAssembler.create((Medic) doHcp);
		else if (doHcp instanceof Therapist)
			return TherapistVoAssembler.create((Therapist)doHcp);
		else if (doHcp instanceof Nurse)
			return NurseVoAssembler.create((Nurse) doHcp);

		return HcpAssembler.create(doHcp);	
	}

	public TherapiesContactVo getContact(ContactRefVo contractRef)
	{
		DomainFactory factory = getDomainFactory();
		return TherapiesContactVoAssembler.create((Contact)factory.getDomainObject((Contact.class), contractRef.getID_Contact()));
	}

	public HcpLiteVo getResponsibleHcpForPasEvent(PASEventRefVo pasEvent)
	{
		if (pasEvent == null || pasEvent.getID_PASEvent() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();

		String hql = " select medic from PASEvent as pasEv left join pasEv.consultant as medic where pasEv.id = :pasEventID";

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();
		
		markers.add("pasEventID");
		values.add(pasEvent.getID_PASEvent());
		
		List <?> list = factory.find(hql, markers, values);
		
		if (list == null || list.size() == 0)
			return null;
		
		return HcpLiteVoAssembler.create((Hcp)list.get(0));
	}
}
