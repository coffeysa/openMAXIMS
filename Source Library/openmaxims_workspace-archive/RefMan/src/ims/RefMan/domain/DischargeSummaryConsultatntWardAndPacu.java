// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface DischargeSummaryConsultatntWardAndPacu extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.DischargeSummaryPacuAndWardLiteVoCollection listDischargeSummaryCollection(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public ims.RefMan.vo.DischargeSummaryPacuAndWardVo getDischargeSummary(ims.RefMan.vo.DischargeSummaryPacuAndWardRefVo dischargeRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.DischargeSummaryPacuAndWardVo save(ims.RefMan.vo.DischargeSummaryPacuAndWardVo dischargeSummary) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.InpatientEpisodeVo getInpatientEpisode(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public ims.core.patient.vo.PatientRefVo getPatientRef(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public ims.core.admin.vo.CareContextRefVo getCareContextRef(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCareRef(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public void saveReport(ims.core.vo.PatientDocumentVo patientDocument, ims.RefMan.vo.CatsReferralRefVo referral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public String[] getSystemReportAndTemplate(Integer imsID);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo saveCatsReferral(ims.RefMan.vo.CatsReferralWizardVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.DischargeSummaryPacuAndWardVo saveDischargeSummaryWardAndPacuPlusCatsReferral(ims.RefMan.vo.DischargeSummaryPacuAndWardVo dischargeSummary, ims.RefMan.vo.CatsReferralWizardVo voCatsReferralWizard) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean hasInpatientEpisode(ims.core.patient.vo.PatientRefVo patient);
}
