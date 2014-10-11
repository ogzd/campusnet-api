package dk.dtu.campusnet.api.data;

import java.util.List;

public class EducationProgramme {

	private String displayName;
	private boolean active;
	private PassedECTSSum passedECTSSum;
	private List<ExamResult> examResults;
	private List<CreditResult> creditResults;
	
	protected EducationProgramme() {
		
	}
	
	public static EducationProgrammeBuilder newBuilder() {
		return new EducationProgrammeBuilder();
	}

	public String getDisplayName() {
		return displayName;
	}

	protected void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isActive() {
		return active;
	}

	protected void setActive(boolean active) {
		this.active = active;
	}

	public PassedECTSSum getPassedECTSSum() {
		return passedECTSSum;
	}

	protected void setPassedECTSSum(PassedECTSSum passedECTSSum) {
		this.passedECTSSum = passedECTSSum;
	}

	public List<ExamResult> getExamResults() {
		return examResults;
	}

	protected void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public List<CreditResult> getCreditResults() {
		return creditResults;
	}

	protected void setCreditResults(List<CreditResult> creditResults) {
		this.creditResults = creditResults;
	}
}
