package dk.dtu.campusnet.api.data;

public class PassedECTSSum {

	private float ectsFromExams;
	private float ectsFromCredits;
	private float ectsTotal;
	
	protected PassedECTSSum() {
		
	}
	
	public static PassedECTSSumBuilder newBuilder() {
		return new PassedECTSSumBuilder();
	}
	
	protected void setECTSFromExams(float ectsFromExams) {
		this.ectsFromExams = ectsFromExams;
	}
	
	protected void setECTSFromCredits(float ectsFromCredits) {
		this.ectsFromCredits = ectsFromCredits;
	}
	
	protected void setECTSTotal(float ectsTotal) {
		this.ectsTotal = ectsTotal;
	}
	
	public float getECTSFromExams() {
		return ectsFromExams;
	}
	
	public float getECTSFromCredits() {
		return ectsFromCredits;
	}
	
	public float getECTSTotal() {
		return ectsTotal;
	}
}
