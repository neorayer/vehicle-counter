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

	public void exec(String filePath, String timeSpanType) throws IOException {
		// build the beans
		dataReader = factory.getDataReader();
		reportBuilder = factory.getReportBuilder();
		analyzer = factory.getAnalyzer();

		// do analyze
		List<AxleItem> items = dataReader.readDataFromFile(filePath);
		analyzer.setAxleItems(items);
		analyzer.analyze();

		// get report!
		reportBuilder.init(analyzer.getCarItems());

		boolean isAll = timeSpanType == null;

		if (isAll || timeSpanType.equals("day")) {
			Report report = reportBuilder.buildReport(Report.MS_DAY);
			report.output(System.out);
		}
		if (isAll || timeSpanType.equals("hd")) {
			Report report = reportBuilder.buildReport(Report.MS_HALF_DAY);
			report.output(System.out);
		}
		if (isAll || timeSpanType.equals("hour")) {
			Report report = reportBuilder.buildReport(Report.MS_HOUR);
			report.output(System.out);
		}
		if (isAll || timeSpanType.equals("30")) {
			Report report = reportBuilder.buildReport(Report.MS_HALF_HOUR);
			report.output(System.out);
		}
		if (isAll || timeSpanType.equals("20")) {
			Report report = reportBuilder.buildReport(Report.MS_20MIN);
			report.output(System.out);
		}
		if (isAll || timeSpanType.equals("15")) {
			Report report = reportBuilder.buildReport(Report.MS_15MIN);
			report.output(System.out);
		}
	}

	private static void outputUsage() {
		System.out.println("Usage: java -cp CLASSPATH gov.city.vehicleCounter.App dataFilePath [timespan]");
		System.out.println("");
		System.out.println("This is a simple command line tools to analyze the data file of 'vehicle counter' sensors");
		System.out.println("");
		System.out.println("Timespan:");
		System.out.println("\tday - Timespan is 24 hours, you can get the report of day");
		System.out.println("\thd - Timespan is 12 hours, you can get the report of morning & evening");
		System.out.println("\thour - Timespan is 1 hour, you can get the report of hours");
		System.out.println("\t30 - Timespan is 30 minutes, you can get the report of half hour");
		System.out.println("\t20 - Timespan is 20 minutes, you can get the report of 20 minutes");
		System.out.println("\t15 - Timespan is 15 minutes, you can get the report of 15 minutes");
		System.out.println("\t[empty] - A set of reports including all above");
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1 || args[0].equals("-h")) {
			outputUsage();
			return;
		}

		String filePath = args[0];

		// check if data file exists
		File f = new File(filePath);
		if (!f.exists() || f.isDirectory()) {
			System.out.println("Sorry, can not find the file: " + filePath);
			return;
		}

		String timeSpanArg = args.length >= 2 ? args[1] : null;
		new App().exec(filePath, timeSpanArg);
	}
}
