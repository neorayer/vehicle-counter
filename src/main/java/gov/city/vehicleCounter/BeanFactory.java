package gov.city.vehicleCounter;

public class BeanFactory {

	public static DataReader getDataReader() {
		throw new UnsupportedOperationException();
	}

	public static Analyzer getAnalyzer() {
		return new AnalyzerImpl();
	}

	public static ReportBuilder getReportBuilder() {
		throw new UnsupportedOperationException();
	}
}
