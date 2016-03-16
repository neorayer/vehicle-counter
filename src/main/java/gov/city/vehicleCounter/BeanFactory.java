package gov.city.vehicleCounter;

public interface BeanFactory {

	DataReader getDataReader();

	Analyzer getAnalyzer();

	ReportBuilder getReportBuilder();
}
