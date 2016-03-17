package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.logging.Logger;

/**
 * 
 * The simple implementation of BeanFactory interface.
 *
 */
public class SimpleBeanFactory implements BeanFactory{

	Logger logger = Logger.getAnonymousLogger();

	@Override
	public DataReader getDataReader() {
		DataReader reader=new DataReader();
		reader.setLogger(logger);
		return reader;
	}

	@Override
	public Analyzer getAnalyzer() {
		return new AnalyzerImpl();
	}

	@Override
	public ReportBuilder getReportBuilder() {
		return new ReportBuilderImpl();
	}
}
