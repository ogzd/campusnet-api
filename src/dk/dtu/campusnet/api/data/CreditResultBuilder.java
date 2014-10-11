package dk.dtu.campusnet.api.data;

import java.util.Date;

public class CreditResultBuilder {
	
	private CreditResult creditResult;
	
	protected CreditResultBuilder() {
		creditResult = new CreditResult();
	}
	
	public CreditResultBuilder withECTSGiven(boolean ectsGiven) {
		creditResult.setEctsGiven(ectsGiven);
		return this;
	}
	
	public CreditResultBuilder withECTSPoints(float ectsPoints) {
		creditResult.setEctsPoints(ectsPoints);
		return this;
	}
	
	public CreditResultBuilder withGrade(String grade) {
		creditResult.setGrade(grade);
		return this;
	}
	
	public CreditResultBuilder withDate(Date date) {
		creditResult.setDate(date);
		return this;
	}
	
	public CreditResultBuilder withName(String name) {
		creditResult.setName(name);
		return this;
	}
	
	public CreditResult done() {
		return creditResult;
	}
}
