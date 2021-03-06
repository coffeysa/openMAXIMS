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

public class VTERiskAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public VTERiskAssessmentVoBean()
	{
	}
	public VTERiskAssessmentVoBean(ims.clinical.vo.VTERiskAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.completedby = vo.getCompletedBy() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getCompletedBy().getBean();
		this.notexpectedreducedmobility = vo.getNotExpectedReducedMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getNotExpectedReducedMobility().getBean();
		this.activecancer = vo.getActiveCancer() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveCancer().getBean();
		this.ageoversixty = vo.getAgeOverSixty() == null ? null : (ims.vo.LookupInstanceBean)vo.getAgeOverSixty().getBean();
		this.dehydration = vo.getDehydration() == null ? null : (ims.vo.LookupInstanceBean)vo.getDehydration().getBean();
		this.knownthrombophilias = vo.getKnownThrombophilias() == null ? null : (ims.vo.LookupInstanceBean)vo.getKnownThrombophilias().getBean();
		this.obesity = vo.getObesity() == null ? null : (ims.vo.LookupInstanceBean)vo.getObesity().getBean();
		this.significantmorbidities = vo.getSignificantMorbidities() == null ? null : (ims.vo.LookupInstanceBean)vo.getSignificantMorbidities().getBean();
		this.historyofvte = vo.getHistoryOfVTE() == null ? null : (ims.vo.LookupInstanceBean)vo.getHistoryOfVTE().getBean();
		this.useofhrt = vo.getUseOfHRT() == null ? null : (ims.vo.LookupInstanceBean)vo.getUseOfHRT().getBean();
		this.useofostogren = vo.getUseOfOstogren() == null ? null : (ims.vo.LookupInstanceBean)vo.getUseOfOstogren().getBean();
		this.varicoseveins = vo.getVaricoseVeins() == null ? null : (ims.vo.LookupInstanceBean)vo.getVaricoseVeins().getBean();
		this.pregnancy = vo.getPregnancy() == null ? null : (ims.vo.LookupInstanceBean)vo.getPregnancy().getBean();
		this.reducedmobility = vo.getReducedMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getReducedMobility().getBean();
		this.criticalcareadmission = vo.getCriticalCareAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getCriticalCareAdmission().getBean();
		this.hipkneereplacement = vo.getHipKneeReplacement() == null ? null : (ims.vo.LookupInstanceBean)vo.getHipKneeReplacement().getBean();
		this.hipfracture = vo.getHipFracture() == null ? null : (ims.vo.LookupInstanceBean)vo.getHipFracture().getBean();
		this.anaestheticandsurgery = vo.getAnaestheticAndSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticAndSurgery().getBean();
		this.acutesurgicaladmission = vo.getAcuteSurgicalAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteSurgicalAdmission().getBean();
		this.surgerysignificantmobilityreduction = vo.getSurgerySignificantMobilityReduction() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgerySignificantMobilityReduction().getBean();
		this.activebleeding = vo.getActiveBleeding() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveBleeding().getBean();
		this.acquiredbleeding = vo.getAcquiredBleeding() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcquiredBleeding().getBean();
		this.concurrentanticoagulants = vo.getConcurrentAnticoagulants() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentAnticoagulants().getBean();
		this.uncontrolledhypertension = vo.getUncontrolledHypertension() == null ? null : (ims.vo.LookupInstanceBean)vo.getUncontrolledHypertension().getBean();
		this.thrombocytopenia = vo.getThrombocytopenia() == null ? null : (ims.vo.LookupInstanceBean)vo.getThrombocytopenia().getBean();
		this.acutestroke = vo.getAcuteStroke() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteStroke().getBean();
		this.untreatedbleedingdisorder = vo.getUntreatedBleedingDisorder() == null ? null : (ims.vo.LookupInstanceBean)vo.getUntreatedBleedingDisorder().getBean();
		this.neurospinaleyesurgery = vo.getNeuroSpinalEyeSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeuroSpinalEyeSurgery().getBean();
		this.otherprocedurewithhighbleedingrisk = vo.getOtherProcedureWithHighBleedingRisk() == null ? null : (ims.vo.LookupInstanceBean)vo.getOtherProcedureWithHighBleedingRisk().getBean();
		this.lumbarpuncturewithinnext12hrs = vo.getLumbarPunctureWithinNext12hrs() == null ? null : (ims.vo.LookupInstanceBean)vo.getLumbarPunctureWithinNext12hrs().getBean();
		this.lumbarpunctureprevious4hrs = vo.getLumbarPuncturePrevious4hrs() == null ? null : (ims.vo.LookupInstanceBean)vo.getLumbarPuncturePrevious4hrs().getBean();
		this.riskgroup = vo.getRiskGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getRiskGroup().getBean();
		this.prophylaxisoffered = vo.getProphylaxisOffered() == null ? null : (ims.vo.LookupInstanceBean)vo.getProphylaxisOffered().getBean();
		this.surgerylowerlimbpelvis60mins = vo.getSurgeryLowerLimbPelvis60mins() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgeryLowerLimbPelvis60mins().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.VTERiskAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean(map);
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.completedby = vo.getCompletedBy() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getCompletedBy().getBean(map);
		this.notexpectedreducedmobility = vo.getNotExpectedReducedMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getNotExpectedReducedMobility().getBean();
		this.activecancer = vo.getActiveCancer() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveCancer().getBean();
		this.ageoversixty = vo.getAgeOverSixty() == null ? null : (ims.vo.LookupInstanceBean)vo.getAgeOverSixty().getBean();
		this.dehydration = vo.getDehydration() == null ? null : (ims.vo.LookupInstanceBean)vo.getDehydration().getBean();
		this.knownthrombophilias = vo.getKnownThrombophilias() == null ? null : (ims.vo.LookupInstanceBean)vo.getKnownThrombophilias().getBean();
		this.obesity = vo.getObesity() == null ? null : (ims.vo.LookupInstanceBean)vo.getObesity().getBean();
		this.significantmorbidities = vo.getSignificantMorbidities() == null ? null : (ims.vo.LookupInstanceBean)vo.getSignificantMorbidities().getBean();
		this.historyofvte = vo.getHistoryOfVTE() == null ? null : (ims.vo.LookupInstanceBean)vo.getHistoryOfVTE().getBean();
		this.useofhrt = vo.getUseOfHRT() == null ? null : (ims.vo.LookupInstanceBean)vo.getUseOfHRT().getBean();
		this.useofostogren = vo.getUseOfOstogren() == null ? null : (ims.vo.LookupInstanceBean)vo.getUseOfOstogren().getBean();
		this.varicoseveins = vo.getVaricoseVeins() == null ? null : (ims.vo.LookupInstanceBean)vo.getVaricoseVeins().getBean();
		this.pregnancy = vo.getPregnancy() == null ? null : (ims.vo.LookupInstanceBean)vo.getPregnancy().getBean();
		this.reducedmobility = vo.getReducedMobility() == null ? null : (ims.vo.LookupInstanceBean)vo.getReducedMobility().getBean();
		this.criticalcareadmission = vo.getCriticalCareAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getCriticalCareAdmission().getBean();
		this.hipkneereplacement = vo.getHipKneeReplacement() == null ? null : (ims.vo.LookupInstanceBean)vo.getHipKneeReplacement().getBean();
		this.hipfracture = vo.getHipFracture() == null ? null : (ims.vo.LookupInstanceBean)vo.getHipFracture().getBean();
		this.anaestheticandsurgery = vo.getAnaestheticAndSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticAndSurgery().getBean();
		this.acutesurgicaladmission = vo.getAcuteSurgicalAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteSurgicalAdmission().getBean();
		this.surgerysignificantmobilityreduction = vo.getSurgerySignificantMobilityReduction() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgerySignificantMobilityReduction().getBean();
		this.activebleeding = vo.getActiveBleeding() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveBleeding().getBean();
		this.acquiredbleeding = vo.getAcquiredBleeding() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcquiredBleeding().getBean();
		this.concurrentanticoagulants = vo.getConcurrentAnticoagulants() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentAnticoagulants().getBean();
		this.uncontrolledhypertension = vo.getUncontrolledHypertension() == null ? null : (ims.vo.LookupInstanceBean)vo.getUncontrolledHypertension().getBean();
		this.thrombocytopenia = vo.getThrombocytopenia() == null ? null : (ims.vo.LookupInstanceBean)vo.getThrombocytopenia().getBean();
		this.acutestroke = vo.getAcuteStroke() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteStroke().getBean();
		this.untreatedbleedingdisorder = vo.getUntreatedBleedingDisorder() == null ? null : (ims.vo.LookupInstanceBean)vo.getUntreatedBleedingDisorder().getBean();
		this.neurospinaleyesurgery = vo.getNeuroSpinalEyeSurgery() == null ? null : (ims.vo.LookupInstanceBean)vo.getNeuroSpinalEyeSurgery().getBean();
		this.otherprocedurewithhighbleedingrisk = vo.getOtherProcedureWithHighBleedingRisk() == null ? null : (ims.vo.LookupInstanceBean)vo.getOtherProcedureWithHighBleedingRisk().getBean();
		this.lumbarpuncturewithinnext12hrs = vo.getLumbarPunctureWithinNext12hrs() == null ? null : (ims.vo.LookupInstanceBean)vo.getLumbarPunctureWithinNext12hrs().getBean();
		this.lumbarpunctureprevious4hrs = vo.getLumbarPuncturePrevious4hrs() == null ? null : (ims.vo.LookupInstanceBean)vo.getLumbarPuncturePrevious4hrs().getBean();
		this.riskgroup = vo.getRiskGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getRiskGroup().getBean();
		this.prophylaxisoffered = vo.getProphylaxisOffered() == null ? null : (ims.vo.LookupInstanceBean)vo.getProphylaxisOffered().getBean();
		this.surgerylowerlimbpelvis60mins = vo.getSurgeryLowerLimbPelvis60mins() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgeryLowerLimbPelvis60mins().getBean();
	}

	public ims.clinical.vo.VTERiskAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.VTERiskAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.VTERiskAssessmentVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.VTERiskAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.VTERiskAssessmentVo();
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
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.recordinginformation = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatus = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getCompletedBy()
	{
		return this.completedby;
	}
	public void setCompletedBy(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.completedby = value;
	}
	public ims.vo.LookupInstanceBean getNotExpectedReducedMobility()
	{
		return this.notexpectedreducedmobility;
	}
	public void setNotExpectedReducedMobility(ims.vo.LookupInstanceBean value)
	{
		this.notexpectedreducedmobility = value;
	}
	public ims.vo.LookupInstanceBean getActiveCancer()
	{
		return this.activecancer;
	}
	public void setActiveCancer(ims.vo.LookupInstanceBean value)
	{
		this.activecancer = value;
	}
	public ims.vo.LookupInstanceBean getAgeOverSixty()
	{
		return this.ageoversixty;
	}
	public void setAgeOverSixty(ims.vo.LookupInstanceBean value)
	{
		this.ageoversixty = value;
	}
	public ims.vo.LookupInstanceBean getDehydration()
	{
		return this.dehydration;
	}
	public void setDehydration(ims.vo.LookupInstanceBean value)
	{
		this.dehydration = value;
	}
	public ims.vo.LookupInstanceBean getKnownThrombophilias()
	{
		return this.knownthrombophilias;
	}
	public void setKnownThrombophilias(ims.vo.LookupInstanceBean value)
	{
		this.knownthrombophilias = value;
	}
	public ims.vo.LookupInstanceBean getObesity()
	{
		return this.obesity;
	}
	public void setObesity(ims.vo.LookupInstanceBean value)
	{
		this.obesity = value;
	}
	public ims.vo.LookupInstanceBean getSignificantMorbidities()
	{
		return this.significantmorbidities;
	}
	public void setSignificantMorbidities(ims.vo.LookupInstanceBean value)
	{
		this.significantmorbidities = value;
	}
	public ims.vo.LookupInstanceBean getHistoryOfVTE()
	{
		return this.historyofvte;
	}
	public void setHistoryOfVTE(ims.vo.LookupInstanceBean value)
	{
		this.historyofvte = value;
	}
	public ims.vo.LookupInstanceBean getUseOfHRT()
	{
		return this.useofhrt;
	}
	public void setUseOfHRT(ims.vo.LookupInstanceBean value)
	{
		this.useofhrt = value;
	}
	public ims.vo.LookupInstanceBean getUseOfOstogren()
	{
		return this.useofostogren;
	}
	public void setUseOfOstogren(ims.vo.LookupInstanceBean value)
	{
		this.useofostogren = value;
	}
	public ims.vo.LookupInstanceBean getVaricoseVeins()
	{
		return this.varicoseveins;
	}
	public void setVaricoseVeins(ims.vo.LookupInstanceBean value)
	{
		this.varicoseveins = value;
	}
	public ims.vo.LookupInstanceBean getPregnancy()
	{
		return this.pregnancy;
	}
	public void setPregnancy(ims.vo.LookupInstanceBean value)
	{
		this.pregnancy = value;
	}
	public ims.vo.LookupInstanceBean getReducedMobility()
	{
		return this.reducedmobility;
	}
	public void setReducedMobility(ims.vo.LookupInstanceBean value)
	{
		this.reducedmobility = value;
	}
	public ims.vo.LookupInstanceBean getCriticalCareAdmission()
	{
		return this.criticalcareadmission;
	}
	public void setCriticalCareAdmission(ims.vo.LookupInstanceBean value)
	{
		this.criticalcareadmission = value;
	}
	public ims.vo.LookupInstanceBean getHipKneeReplacement()
	{
		return this.hipkneereplacement;
	}
	public void setHipKneeReplacement(ims.vo.LookupInstanceBean value)
	{
		this.hipkneereplacement = value;
	}
	public ims.vo.LookupInstanceBean getHipFracture()
	{
		return this.hipfracture;
	}
	public void setHipFracture(ims.vo.LookupInstanceBean value)
	{
		this.hipfracture = value;
	}
	public ims.vo.LookupInstanceBean getAnaestheticAndSurgery()
	{
		return this.anaestheticandsurgery;
	}
	public void setAnaestheticAndSurgery(ims.vo.LookupInstanceBean value)
	{
		this.anaestheticandsurgery = value;
	}
	public ims.vo.LookupInstanceBean getAcuteSurgicalAdmission()
	{
		return this.acutesurgicaladmission;
	}
	public void setAcuteSurgicalAdmission(ims.vo.LookupInstanceBean value)
	{
		this.acutesurgicaladmission = value;
	}
	public ims.vo.LookupInstanceBean getSurgerySignificantMobilityReduction()
	{
		return this.surgerysignificantmobilityreduction;
	}
	public void setSurgerySignificantMobilityReduction(ims.vo.LookupInstanceBean value)
	{
		this.surgerysignificantmobilityreduction = value;
	}
	public ims.vo.LookupInstanceBean getActiveBleeding()
	{
		return this.activebleeding;
	}
	public void setActiveBleeding(ims.vo.LookupInstanceBean value)
	{
		this.activebleeding = value;
	}
	public ims.vo.LookupInstanceBean getAcquiredBleeding()
	{
		return this.acquiredbleeding;
	}
	public void setAcquiredBleeding(ims.vo.LookupInstanceBean value)
	{
		this.acquiredbleeding = value;
	}
	public ims.vo.LookupInstanceBean getConcurrentAnticoagulants()
	{
		return this.concurrentanticoagulants;
	}
	public void setConcurrentAnticoagulants(ims.vo.LookupInstanceBean value)
	{
		this.concurrentanticoagulants = value;
	}
	public ims.vo.LookupInstanceBean getUncontrolledHypertension()
	{
		return this.uncontrolledhypertension;
	}
	public void setUncontrolledHypertension(ims.vo.LookupInstanceBean value)
	{
		this.uncontrolledhypertension = value;
	}
	public ims.vo.LookupInstanceBean getThrombocytopenia()
	{
		return this.thrombocytopenia;
	}
	public void setThrombocytopenia(ims.vo.LookupInstanceBean value)
	{
		this.thrombocytopenia = value;
	}
	public ims.vo.LookupInstanceBean getAcuteStroke()
	{
		return this.acutestroke;
	}
	public void setAcuteStroke(ims.vo.LookupInstanceBean value)
	{
		this.acutestroke = value;
	}
	public ims.vo.LookupInstanceBean getUntreatedBleedingDisorder()
	{
		return this.untreatedbleedingdisorder;
	}
	public void setUntreatedBleedingDisorder(ims.vo.LookupInstanceBean value)
	{
		this.untreatedbleedingdisorder = value;
	}
	public ims.vo.LookupInstanceBean getNeuroSpinalEyeSurgery()
	{
		return this.neurospinaleyesurgery;
	}
	public void setNeuroSpinalEyeSurgery(ims.vo.LookupInstanceBean value)
	{
		this.neurospinaleyesurgery = value;
	}
	public ims.vo.LookupInstanceBean getOtherProcedureWithHighBleedingRisk()
	{
		return this.otherprocedurewithhighbleedingrisk;
	}
	public void setOtherProcedureWithHighBleedingRisk(ims.vo.LookupInstanceBean value)
	{
		this.otherprocedurewithhighbleedingrisk = value;
	}
	public ims.vo.LookupInstanceBean getLumbarPunctureWithinNext12hrs()
	{
		return this.lumbarpuncturewithinnext12hrs;
	}
	public void setLumbarPunctureWithinNext12hrs(ims.vo.LookupInstanceBean value)
	{
		this.lumbarpuncturewithinnext12hrs = value;
	}
	public ims.vo.LookupInstanceBean getLumbarPuncturePrevious4hrs()
	{
		return this.lumbarpunctureprevious4hrs;
	}
	public void setLumbarPuncturePrevious4hrs(ims.vo.LookupInstanceBean value)
	{
		this.lumbarpunctureprevious4hrs = value;
	}
	public ims.vo.LookupInstanceBean getRiskGroup()
	{
		return this.riskgroup;
	}
	public void setRiskGroup(ims.vo.LookupInstanceBean value)
	{
		this.riskgroup = value;
	}
	public ims.vo.LookupInstanceBean getProphylaxisOffered()
	{
		return this.prophylaxisoffered;
	}
	public void setProphylaxisOffered(ims.vo.LookupInstanceBean value)
	{
		this.prophylaxisoffered = value;
	}
	public ims.vo.LookupInstanceBean getSurgeryLowerLimbPelvis60mins()
	{
		return this.surgerylowerlimbpelvis60mins;
	}
	public void setSurgeryLowerLimbPelvis60mins(ims.vo.LookupInstanceBean value)
	{
		this.surgerylowerlimbpelvis60mins = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.RecordingUserInformationVoBean recordinginformation;
	private ims.vo.LookupInstanceBean vteassessmentstatus;
	private ims.core.vo.beans.RecordingUserInformationVoBean completedby;
	private ims.vo.LookupInstanceBean notexpectedreducedmobility;
	private ims.vo.LookupInstanceBean activecancer;
	private ims.vo.LookupInstanceBean ageoversixty;
	private ims.vo.LookupInstanceBean dehydration;
	private ims.vo.LookupInstanceBean knownthrombophilias;
	private ims.vo.LookupInstanceBean obesity;
	private ims.vo.LookupInstanceBean significantmorbidities;
	private ims.vo.LookupInstanceBean historyofvte;
	private ims.vo.LookupInstanceBean useofhrt;
	private ims.vo.LookupInstanceBean useofostogren;
	private ims.vo.LookupInstanceBean varicoseveins;
	private ims.vo.LookupInstanceBean pregnancy;
	private ims.vo.LookupInstanceBean reducedmobility;
	private ims.vo.LookupInstanceBean criticalcareadmission;
	private ims.vo.LookupInstanceBean hipkneereplacement;
	private ims.vo.LookupInstanceBean hipfracture;
	private ims.vo.LookupInstanceBean anaestheticandsurgery;
	private ims.vo.LookupInstanceBean acutesurgicaladmission;
	private ims.vo.LookupInstanceBean surgerysignificantmobilityreduction;
	private ims.vo.LookupInstanceBean activebleeding;
	private ims.vo.LookupInstanceBean acquiredbleeding;
	private ims.vo.LookupInstanceBean concurrentanticoagulants;
	private ims.vo.LookupInstanceBean uncontrolledhypertension;
	private ims.vo.LookupInstanceBean thrombocytopenia;
	private ims.vo.LookupInstanceBean acutestroke;
	private ims.vo.LookupInstanceBean untreatedbleedingdisorder;
	private ims.vo.LookupInstanceBean neurospinaleyesurgery;
	private ims.vo.LookupInstanceBean otherprocedurewithhighbleedingrisk;
	private ims.vo.LookupInstanceBean lumbarpuncturewithinnext12hrs;
	private ims.vo.LookupInstanceBean lumbarpunctureprevious4hrs;
	private ims.vo.LookupInstanceBean riskgroup;
	private ims.vo.LookupInstanceBean prophylaxisoffered;
	private ims.vo.LookupInstanceBean surgerylowerlimbpelvis60mins;
}
