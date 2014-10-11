package dk.dtu.campusnet.api.data;

import java.util.Date;

public class CreditResult {

	private boolean ectsGiven;
	private float ectsPoints;
	private String grade;
	private Date date;
	private String name;
	
	protected CreditResult() {
		
	}
	
	public static CreditResultBuilder newBuilder() {
		return new CreditResultBuilder();
	}

	public boolean isEctsGiven() {
		return ectsGiven;
	}

	protected void setEctsGiven(boolean ectsGiven) {
		this.ectsGiven = ectsGiven;
	}

	public float getEctsPoints() {
		return ectsPoints;
	}

	protected void setEctsPoints(float ectsPoints) {
		this.ectsPoints = ectsPoints;
	}

	public String getGrade() {
		return grade;
	}

	protected void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return date;
	}

	protected void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}
