package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */

/**
 * A simple abstract bean factory interface.
 *
 */
public interface BeanFactory {

	DataReader getDataReader();

	Analyzer getAnalyzer();

	ReportBuilder getReportBuilder();
}
