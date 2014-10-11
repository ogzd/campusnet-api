package dk.dtu.campusnet.api.data;

public class ExamResult {
	
	private String courseCode;
	private boolean ectsGiven;
	private float ectsPoints;
	private String grade;
	private String period;
	private int year;
	private String couseName;
	
	protected ExamResult() {
		
	}
	
	public static ExamResultBuilder newBuilder() {
		return new ExamResultBuilder();
	}

	public String getCourseCode() {
		return courseCode;
	}

	protected void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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

	public String getPeriod() {
		return period;
	}

	protected void setPeriod(String period) {
		this.period = period;
	}

	public int getYear() {
		return year;
	}

	protected void setYear(int year) {
		this.year = year;
	}

	public String getCouseName() {
		return couseName;
	}

	protected void setCouseName(String couseName) {
		this.couseName = couseName;
	}
	
}
