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

package ims.vo.interfaces;

/*
 * Methods to get and set the fields of a CCI
 */
public interface ICciFull extends Comparable, IGenericItem
{
	/*
	 * get the collection of Taxonomy mappings from the CCI
	 */
	 ims.core.vo.TaxonomyMapCollection getCciMappings();
	/*
	 * get the collection of keywords for this CCI
	 */
	 ims.core.vo.KeywordVoCollection getCciKeywords();
	/*
	 * setCciKeywords
	 */
	 void setCciKeywords(ims.core.vo.KeywordVoCollection cciKeywords);
	/*
	 * setCciMappings
	 */
	 void setCciMappings(ims.core.vo.TaxonomyMapCollection cciMappings);
	/*
	 * gets the allergen type. Is only applicable for allergens. 
	 */
	 ims.core.vo.lookups.AllergenType getCciAllergenType();
	/*
	 * sets the allergen type for the Cci. Only applicable for allergen vo. Otherwise does nothing. 
	 */
	 void setCciAllergenType(ims.core.vo.lookups.AllergenType cciAllergenType);
	/*
	 * calls the validate() method for the object
	 */
	 String[] validateCci();
	/*
	 * returns  Boolean indicating whether the object has been validated or not
	 */
	 Boolean isValidatedCci();
	/*
	 * setCciProcedureDuration in mIns
	 */
	 void setCciProcedureDuration(Integer duration);
	/*
	 * getCciProcedureDuration
	 */
	 Integer getCciProcedureDuration();
	/*
	 * setCciProcedureLOS
	 */
	 void setCciProcedureLOS(Integer intLOS);
	/*
	 * getCciProcedureLOS
	 */
	 Integer getCciProcedureLOS();
	/*
	 * getCciTCILagTime
	 */
	 Integer getCciTCILagTime();
	/*
	 * setCciTCILagTime
	 */
	 void setCciTCILagTime(Integer tciLagTime);
	/*
	 * gets the TreatmentInterventiontype. Is only applicable for TreatmentIntervention.
	 */
	 ims.clinical.vo.lookups.TreatmentInterventionType getCciTreatmentInterventionType();
	/*
	 * sets the TreatmentInterventiontype for the Cci. Only applicable for TreatmentInterventionvo. Otherwise does nothing. 
	 */
	 void setCciTreatmentInterventionType(ims.clinical.vo.lookups.TreatmentInterventionType cciTreatmentInterventionType);
	/*
	 * Getter method used for procedure configuration
	 */
	 ims.clinicaladmin.vo.lookups.CaseTypeProcedure getSurgeonCategory();
	/*
	 * Getter method used for procedure configuration
	 */
	 ims.clinicaladmin.vo.lookups.CaseTypeProcedure getAnaesthetistCategory();
	/*
	 * Getter method used for procedure configuration
	 */
	 ims.clinicaladmin.vo.lookups.CaseTypeProcedure getHospitalCategory();
	/*
	 * setter method used in procedure configuration
	 */
	 void setSurgeonCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category);
	/*
	 * setter method used in procedure configuration
	 */
	 void setAnaesthetistCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category);
	/*
	 * setter method used in procedure configuration
	 */
	 void setHospitalCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category);
}
