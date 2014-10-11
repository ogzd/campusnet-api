package dk.dtu.campusnet.api.data;

import java.util.List;

public class EducationProgrammeBuilder {

	private EducationProgramme educationProgramme;
	
	protected EducationProgrammeBuilder() {
		educationProgramme = new EducationProgramme();
	}
	
	public EducationProgrammeBuilder withDisplayName(String displayName) {
		educationProgramme.setDisplayName(displayName);
		return this;
	}
	
	public EducationProgrammeBuilder withActive(boolean active) {
		educationProgramme.setActive(active);
		return this;
	}
	
	public EducationProgrammeBuilder withPassedECTSSum(PassedECTSSum passedECTSSum) {
		educationProgramme.setPassedECTSSum(passedECTSSum);
		return this;
	}
	
	public EducationProgrammeBuilder withExamResults(List<ExamResult> examResults) {
		educationProgramme.setExamResults(examResults);
		return this;
	}
	
	public EducationProgrammeBuilder withCreditResults(List<CreditResult> creditResults) {
		educationProgramme.setCreditResults(creditResults);
		return this;
	}
	
	public EducationProgramme done() {
		return educationProgramme;
	}
}
