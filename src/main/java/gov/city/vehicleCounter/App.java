package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.report.Report;

/**
 * The entry of application.
 */
public class App {
	final long oneHourMilliSeconds = 1 * 60 * 60 * 1000;

	private BeanFactory factory = new SimpleBeanFactory();
	private DataReader dataReader;
	private Analyzer analyzer;
	private ReportBuilder reportBuilder;

	public void exec(String filePath) throws IOException {

		dataReader = factory.getDataReader();
		// List<AxleItem> items = dataReader.readDataFromResource(filePath);
		List<AxleItem> items = dataReader.readDataFromFile(filePath);
		analyzer = factory.getAnalyzer();
		analyzer.setAxleItems(items);
		analyzer.analyze();

		reportBuilder = factory.getReportBuilder();
		reportBuilder.init(analyzer.getCarItems());

		{
			Report report = reportBuilder.buildReport(Report.MS_DAY);
			report.output(System.out);
		}
		{
			Report report = reportBuilder.buildReport(Report.MS_HALF_DAY);
			report.output(System.out);
		}
		{
			Report report = reportBuilder.buildReport(Report.MS_HOUR);
			report.output(System.out);
		}
		{
			Report report = reportBuilder.buildReport(Report.MS_HALF_HOUR);
			report.output(System.out);
		}
		{
			Report report = reportBuilder.buildReport(Report.MS_20MIN);
			report.output(System.out);
		}
		{
			Report report = reportBuilder.buildReport(Report.MS_15MIN);
			report.output(System.out);
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: java gov.city.vehicleCounter.App filePath");
			return;
		}
		
		String filePath = args[0];
		File f = new File(filePath);
		if(!f.exists() || f.isDirectory()) { 
			System.out.println("Sorry, can not find the file: " + filePath);
			return;
		}
		new App().exec(filePath);
	}
}
