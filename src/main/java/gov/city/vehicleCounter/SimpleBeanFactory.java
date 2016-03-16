package gov.city.vehicleCounter;

import java.util.logging.Logger;

public class SimpleBeanFactory implements BeanFactory{

	Logger logger = Logger.getAnonymousLogger();

	public DataReader getDataReader() {
		DataReader reader=new DataReader();
		reader.setLogger(logger);
		return reader;
	}

	public Analyzer getAnalyzer() {
		return new AnalyzerImpl();
	}

	public ReportBuilder getReportBuilder() {
		return new ReportBuilderImpl();
	}
}
