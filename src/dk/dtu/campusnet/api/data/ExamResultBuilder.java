package dk.dtu.campusnet.api.data;

public class ExamResultBuilder {

	private ExamResult examResult;
	
	protected ExamResultBuilder() {
		examResult = new ExamResult();
	}
	
	public ExamResultBuilder withCourseCode(String courseCode) {
		examResult.setCourseCode(courseCode);
		return this;
	}
	
	public ExamResultBuilder withECTSGiven(boolean ectsGiven) {
		examResult.setEctsGiven(ectsGiven);
		return this;
	}
	
	public ExamResultBuilder withECTSPoints(float ectsPoints) {
		examResult.setEctsPoints(ectsPoints);
		return this;
	}
	
	public ExamResultBuilder withGrade(String grade) {
		examResult.setGrade(grade);
		return this;
	}
	
	public ExamResultBuilder withPeriod(String period) {
		examResult.setPeriod(period);
		return this;
	}
	
	public ExamResultBuilder withYear(int year) {
		examResult.setYear(year);
		return this;
	}
	
	public ExamResultBuilder withCourseName(String courseName) {
		examResult.setCouseName(courseName);
		return this;
	}
	
	public ExamResult done() {
		return examResult;
	}
}
