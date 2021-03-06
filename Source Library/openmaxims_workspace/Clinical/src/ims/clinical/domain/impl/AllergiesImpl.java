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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2393.21546)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseAllergiesImpl;
import ims.clinicaladmin.domain.CCIAdmin;
import ims.clinicaladmin.domain.impl.CCIAdminImpl;
import ims.clinicaladmin.vo.enums.CciType;
import ims.core.clinical.domain.objects.Allergen;
import ims.core.clinical.domain.objects.PatientAllergy;
import ims.core.clinical.domain.objects.PatientNoAllergyInfo;
import ims.core.clinical.vo.AllergenRefVo;
import ims.core.domain.Alerts;
import ims.core.domain.AllergenReactions;
import ims.core.domain.impl.AllergenReactionsImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.AllergenTypeReactionsCollection;
import ims.core.vo.AllergenVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.IfPatientAllergyVo;
import ims.core.vo.IfPatientAllergyVoCollection;
import ims.core.vo.PatientNoAllergyInfoVo;
import ims.core.vo.domain.IfPatientAllergyVoAssembler;
import ims.core.vo.domain.PatientAllergyAssembler;
import ims.core.vo.domain.PatientNoAllergyInfoVoAssembler;
import ims.core.vo.lookups.PatientAllergyStatus;
import ims.core.vo.lookups.SourceofInformation;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.ICciFull;

import java.util.ArrayList;
import java.util.List;

public class AllergiesImpl extends BaseAllergiesImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* lists patient allergies, filtering by patient and active status
	*/
	public ims.core.vo.PatientAllergyCollection listPatientAllergies(ims.core.vo.PatientShort patient, Boolean active)
	{	
		if(patient == null)
			throw new CodingRuntimeException("Mandatory parameter - Patient not supplied");
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientAllergy patAlrg ");
		hql.append(" where patAlrg.patient.id = :patient");
		names.add("patient");
		values.add(patient.getID_Patient());
		
		if (active.equals(Boolean.TRUE))
		{
			hql.append (" and patAlrg.isCurrentlyActiveAllergy = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		List list = factory.find(hql.toString(), names,values);
		return(PatientAllergyAssembler.createPatientAllergyCollectionFromPatientAllergy(list).sort());
		
	}
	
	
	private List<PatientAllergy> listPatientAllergies(PatientRefVo patient, Boolean active)
	{	
		if(patient == null)
			throw new CodingRuntimeException("Mandatory parameter - Patient not supplied");
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientAllergy patAlrg ");
		hql.append(" where patAlrg.patient.id = :patient");
		names.add("patient");
		values.add(patient.getID_Patient());
		
		if (active.equals(Boolean.TRUE))
		{
			hql.append (" and patAlrg.isCurrentlyActiveAllergy = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		return factory.find(hql.toString(), names,values);
	}
	

	/**
	* saves a patient allergy
	*/
	public ims.core.vo.PatientAllergy savePatientAllergy(ims.core.vo.PatientAllergy voPatientAllergy) throws ims.domain.exceptions.StaleObjectException, DomainInterfaceException, UniqueKeyViolationException
	{
		if (!voPatientAllergy.isValidated())
			throw new CodingRuntimeException("Patient Allergy has not been validated");
		if(voPatientAllergy == null)
			throw new CodingRuntimeException("Cannot save null PatientAllergyVo");
		if(!voPatientAllergy.isValidated())
			throw new CodingRuntimeException("PatientAllergy is not validated");
		
		DomainFactory factory = getDomainFactory();
		
		//Check the allergy and save it
		if(voPatientAllergy.getAllergenIsNotNull() && voPatientAllergy.getAllergen().getID_Allergen() == null)
		{
			voPatientAllergy.setAllergen(saveAllergy(voPatientAllergy.getAllergen()));
		}		
		PatientAllergy doPatientAllergy = PatientAllergyAssembler.extractPatientAllergy(factory, voPatientAllergy);
			
		factory.save(doPatientAllergy);

		//if the allergy has a PAS mapping of "ALLE" then insert an ALERT of this type.
		
		if (voPatientAllergy.getAllergenIsNotNull()
			&& voPatientAllergy.getAllergen().getTaxonomyMapIsNotNull()
			&& voPatientAllergy.getAllergen().getTaxonomyMap().size() > 0)
		{
			for ( int i = 0 ; i < voPatientAllergy.getAllergen().getTaxonomyMap().size() ; i++)
			{
				if (voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyCodeIsNotNull()
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyCode().equals("ALLE")
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyNameIsNotNull()
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyName().getText().equals("PAS"))
				{
					Alerts impl = (Alerts) getDomainImpl(ims.core.domain.impl.AlertsImpl.class);
					impl.saveHeartsAlert(voPatientAllergy.getPatient(), "ALLE", voPatientAllergy.getIsCurrentlyActiveAllergy());
				}
			}
		}

		return (PatientAllergyAssembler.create(doPatientAllergy));		
	}
	
	public ims.core.vo.PatientAllergy savePatientAllergy(ims.core.vo.PatientAllergy voPatientAllergy, PatientNoAllergyInfoVo patientNoAllergyInfo) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException, DomainInterfaceException
	{
		if (!voPatientAllergy.isValidated())
			throw new CodingRuntimeException("Patient Allergy has not been validated");
		if (!patientNoAllergyInfo.isValidated())
			throw new CodingRuntimeException("PatientNoAllergyInfoVo has not been validated");
		if(voPatientAllergy == null)
			throw new CodingRuntimeException("Cannot save null PatientAllergyVo");
		if (patientNoAllergyInfo == null)
			throw new CodingRuntimeException("Cannot save null PatientNoAllergyInfoVo");
		
		DomainFactory factory = getDomainFactory();
		
		//Check the allergy and save it
		if(voPatientAllergy.getAllergenIsNotNull() && voPatientAllergy.getAllergen().getID_Allergen() == null)
		{
			voPatientAllergy.setAllergen(saveAllergy(voPatientAllergy.getAllergen()));
		}		
		PatientAllergy doPatientAllergy = PatientAllergyAssembler.extractPatientAllergy(factory, voPatientAllergy);
		
		if (!voPatientAllergy.getID_PatientAllergyIsNotNull())
		{
			//Check the PatientNoAllergyInfo
			String hqlQuery = "select p1_1.allergyStatus from PatientNoAllergyInfo as p1_1 where (p1_1.patient.id = :Patient_id and p1_1.isRIE is null )";
			List<?> list = factory.find(hqlQuery,"Patient_id",voPatientAllergy.getPatient().getID_Patient());
			//If there is no PatientNoAllergiesInfo record, or the record exists and the status is NOKNOWNALLERGIES
			if ((list == null || list.size() == 0) || (getDomLookup(PatientAllergyStatus.NOKNOWNALLERGIES).equals(list.get(0))))
			{

				savePatientNoAllergyInfo(patientNoAllergyInfo);
			}
			
		}
			
		factory.save(doPatientAllergy);
		
		//if the allergy has a PAS mapping of "ALLE" then insert an ALERT of this type.
		
		if (voPatientAllergy.getAllergenIsNotNull()
			&& voPatientAllergy.getAllergen().getTaxonomyMapIsNotNull()
			&& voPatientAllergy.getAllergen().getTaxonomyMap().size() > 0)
		{
			for ( int i = 0 ; i < voPatientAllergy.getAllergen().getTaxonomyMap().size() ; i++)
			{
				if (voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyCodeIsNotNull()
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyCode().equals("ALLE")
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyNameIsNotNull()
					&& voPatientAllergy.getAllergen().getTaxonomyMap().get(i).getTaxonomyName().getText().equals("PAS"))
				{
					Alerts impl = (Alerts) getDomainImpl(ims.core.domain.impl.AlertsImpl.class);
					impl.saveHeartsAlert(voPatientAllergy.getPatient(), "ALLE", voPatientAllergy.getIsCurrentlyActiveAllergy());
				}
			}
		}
		
		return (PatientAllergyAssembler.create(doPatientAllergy));		
	}	
	
	private AllergenVo saveAllergy(AllergenVo voAllergen) throws StaleObjectException, UniqueKeyViolationException, DomainInterfaceException
	{
		CCIAdmin cciAdmin = (CCIAdmin) getDomainImpl(CCIAdminImpl.class);
		return (AllergenVo)cciAdmin.saveCci((ICciFull)voAllergen, CciType.ALLERGEN);
	}

	public HcpCollection listHcps(HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

	public AllergenTypeReactionsCollection listAllergenTypeReactions(ims.core.vo.lookups.AllergenType voAllergenType)
	{
		AllergenReactions allergenReactionsImpl = (AllergenReactions)getDomainImpl(AllergenReactionsImpl.class);		
		return allergenReactionsImpl.listAllergenTypeReactions(voAllergenType).sort();		
	}

	/**
	 * Returns a single PatientAllergy based on a given PatientAllergy id Integer. 
	 * 
	 * @param Integer patientAllergyID
	 * @return PatientAllergy
	 * @author mmccarthy
	 */
	public ims.core.vo.PatientAllergy getpatientAllergy(Integer patientAllergyID)
	{
		DomainFactory factory = getDomainFactory();
		return PatientAllergyAssembler.create((PatientAllergy)factory.getDomainObject((PatientAllergy.class), patientAllergyID.intValue()));
	}

	public PatientNoAllergyInfoVo getPatientNoAllergyInfo(PatientRefVo patientRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		PatientNoAllergyInfo patientNoAllergyInfo = PatientNoAllergyInfo.getPatientNoAllergyInfoFromPatient(factory, patientRefVo.getID_Patient());
		return PatientNoAllergyInfoVoAssembler.create(patientNoAllergyInfo);
	}
	
	public PatientNoAllergyInfoVo savePatientNoAllergyInfo(PatientNoAllergyInfoVo patientNoAllergyInfo) throws StaleObjectException, UniqueKeyViolationException 
	{
		if(!patientNoAllergyInfo.isValidated())
		{
			throw new CodingRuntimeException("PatientNoAllergyInfoVo Value Object Alert has not been validated");
		}
		
		DomainFactory factory = getDomainFactory();
		PatientNoAllergyInfo doPatientNoAllergyInfo = PatientNoAllergyInfoVoAssembler.extractPatientNoAllergyInfo(factory, patientNoAllergyInfo);
			
		try
		{
			factory.save(doPatientNoAllergyInfo);
		} 
		catch(UnqViolationUncheckedException e)
		{		
			PatientNoAllergyInfo noAllergyInfo = PatientNoAllergyInfo.getPatientNoAllergyInfoFromPatient(factory, patientNoAllergyInfo.getPatient().getID_Patient());
			if (noAllergyInfo != null && noAllergyInfo.getId() != null && !(noAllergyInfo.getId().equals(patientNoAllergyInfo.getID_PatientNoAllergyInfo())))
			{
				throw new UniqueKeyViolationException("A No Known Allergy record already exists for this patient. Duplicates not allowed.", e);					
			}

			throw (e);
		}
		return (PatientNoAllergyInfoVoAssembler.create(doPatientNoAllergyInfo));		
	}

	public Boolean saveHeartsAlert(PatientRefVo patientRefVo, String pasMapping, Boolean isActive) throws DomainInterfaceException, StaleObjectException
	{
		Alerts impl = (Alerts) getDomainImpl(ims.core.domain.impl.AlertsImpl.class);
		return impl.saveHeartsAlert(patientRefVo, pasMapping, isActive);
	}

	public AllergenRefVo getAllergenForTaxonomy(TaxonomyType taxonomyType,String mapping)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from Allergen alle join alle.taxonomyMap as tm where tm.taxonomyName = :taxType  and tm.taxonomyCode = :extId ";

		List alleList = factory.find(hql,new String[]{"taxType", "extId"}, new Object[]{getDomLookup(taxonomyType),mapping});

		if (alleList != null && alleList.size() == 1)
		{
			
			Allergen allergenDom = (Allergen)alleList.get(0);
			
			AllergenRefVo allRef = new AllergenRefVo(allergenDom.getId(),allergenDom.getVersion()); 
			return allRef;
		}
		else if (alleList != null && alleList.size() > 1)
		{
			throw new DomainRuntimeException("Non unique hit on Allergen by TaxonomyType " + taxonomyType.getText() + " and code " + mapping);
		}
		else
			return null;
	}

	public Boolean updatePASAllergies(PatientRefVo patient,IfPatientAllergyVoCollection allergiesFromMsg) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		if(patient==null||allergiesFromMsg==null) //http://jira/browse/WDEV-17335
			return null;
		
		List<PatientAllergy> currentAllergies = listPatientAllergies(patient, false);
		
		if(allergiesFromMsg.size()==0) //set all allergies that have PAS as sourrce of information set them to be not currently active
		{
			inactivatePASAllergies(currentAllergies,factory);
		}
		else
		{
			for (IfPatientAllergyVo msgAllergy : allergiesFromMsg)
			{
				PatientAllergy alle = getFromList(currentAllergies,msgAllergy);
				if(alle==null)
				{
					alle =  IfPatientAllergyVoAssembler.extractPatientAllergy(factory, msgAllergy);
					alle.setPatient((Patient)factory.getDomainObject(Patient.class, patient.getID_Patient()));
					alle.setAllergenDescription(alle.getAllergen().getAllergenName());
					factory.save(alle);
					
				}
				else if(alle.isIsCurrentlyActiveAllergy()==null //if it is null or different in the BO
						||(alle.isIsCurrentlyActiveAllergy()!=null
						&&msgAllergy.getIsCurrentlyActiveAllergyIsNotNull()
						&&(!alle.isIsCurrentlyActiveAllergy().equals(msgAllergy.getIsCurrentlyActiveAllergy()))))
				{
					alle.setIsCurrentlyActiveAllergy(msgAllergy.getIsCurrentlyActiveAllergy());
					factory.save(alle);
				}
					
			}
			updatePatientNoAllergyInfo(patient); //http://jira/browse/WDEV-17262
		}
		return null;
	}
	
	//http://jira/browse/WDEV-17262
	private void updatePatientNoAllergyInfo (PatientRefVo patient) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		String hql = new String("from PatientNoAllergyInfo alleInfo where alleInfo.patient.id = :patient");
		List<?> list = factory.find(hql,new String[]{ "patient"},new Object[]{patient.getBoId()});
		if (list!=null||list.isEmpty())
		{
			for (Object object : list)
			{
				PatientNoAllergyInfo alleInfo =(PatientNoAllergyInfo)object;
				if(alleInfo.getAllergyStatus()==null
						||alleInfo.getAllergyStatus().equals(getDomLookup(PatientAllergyStatus.NOKNOWNALLERGIES)))
				{
					alleInfo.setAllergyStatus(getDomLookup(PatientAllergyStatus.HASALLERGIES));
					factory.save(alleInfo);
				}
			}
		}

	}
	
	

	
	private void inactivatePASAllergies(List<PatientAllergy> currentAllergies,DomainFactory factory) throws StaleObjectException
	{
		for (PatientAllergy patientAllergy : currentAllergies)
		{
			if(patientAllergy!=null
					&&patientAllergy.getSourceofInformation()!=null
					&&patientAllergy.getSourceofInformation().equals(getDomLookup(SourceofInformation.PAS))
					&&patientAllergy.isIsCurrentlyActiveAllergy())
			{
				patientAllergy.setIsCurrentlyActiveAllergy(Boolean.FALSE);
				factory.save(patientAllergy);
			}
		}
	}
	
	private PatientAllergy getFromList(List<PatientAllergy> currentAllergies,IfPatientAllergyVo allergyFromMsg)
	{
		for (PatientAllergy patientAllergy : currentAllergies)
		{
		if(patientAllergy!=null
				&&patientAllergy.getAllergen()!=null
				&&patientAllergy.getAllergen().getId()!=null
				&&patientAllergy.getSourceofInformation()!=null
				&&allergyFromMsg!=null
				&&allergyFromMsg.getAllergen()!=null
				&&allergyFromMsg.getAllergen().getBoId()!=null
				&&allergyFromMsg.getSourceofInformation()!=null
				
				&&patientAllergy.getAllergen().getId().equals(allergyFromMsg.getAllergen().getBoId())
				&&patientAllergy.getSourceofInformation().getId()==allergyFromMsg.getSourceofInformation().getID())
				{
					return patientAllergy;
				}
		}
		
		return null;
	}

}
