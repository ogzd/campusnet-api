package dk.dtu.campusnet.api.data;

public class PassedECTSSumBuilder {

	private PassedECTSSum passedECTSSum;
	
	protected PassedECTSSumBuilder() {
		passedECTSSum = new PassedECTSSum();
	}
	
	public PassedECTSSumBuilder withECTSFromExams(float ectsFromExams) {
		passedECTSSum.setECTSFromExams(ectsFromExams);
		return this;
	}
	
	public PassedECTSSumBuilder withECTSFromCredits(float ectsFromCredits) {
		passedECTSSum.setECTSFromCredits(ectsFromCredits);
		return this;
	}
	
	public PassedECTSSumBuilder withECTSTotal(float ectsTotal) {
		passedECTSSum.setECTSTotal(ectsTotal);
		return this;
	}
	
	public PassedECTSSum done() {
		return passedECTSSum;
	}
}
