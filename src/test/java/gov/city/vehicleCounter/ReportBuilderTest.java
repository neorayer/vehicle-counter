package gov.city.vehicleCounter;

/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem.Direction;
import gov.city.vehicleCounter.report.DailyReport;
import gov.city.vehicleCounter.report.Report;
import junit.framework.TestCase;

/**
 * To test ReportBuilder class
 */

public class ReportBuilderTest extends TestCase {
	final private String sampleName = "gov/city/vehicleCounter/sample-data.txt";
	final long oneHourMilliSeconds = 1 * 60 * 60 * 1000;

	private BeanFactory factory = new SimpleBeanFactory();
	private DataReader dataReader;
	private Analyzer analyzer;
	private ReportBuilder reportBuilder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dataReader = factory.getDataReader();
		List<AxleItem> items = dataReader.readDataFromResource(sampleName);
		analyzer = factory.getAnalyzer();
		analyzer.setAxleItems(items);
		analyzer.analyze();

		reportBuilder = factory.getReportBuilder();
		reportBuilder.init(analyzer.getCarItems());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testTotalCount() {
		assertEquals(5, reportBuilder.count());
	}

	public void testCountByDirection() {
		assertEquals(1, reportBuilder.count(Direction.N));
		assertEquals(4, reportBuilder.count(Direction.S));
	}

	public void testCountByPeriod() {
		assertEquals(4, reportBuilder.count(0, oneHourMilliSeconds));
		assertEquals(1, reportBuilder.count(23 * oneHourMilliSeconds, oneHourMilliSeconds));
	}

	public void testCountByDay() {
		// total of day
		assertEquals(4, reportBuilder.count(0));
		assertEquals(1, reportBuilder.count(1));

		// direction of 1st day
		assertEquals(1, reportBuilder.count(Direction.N, 0, -1, -1));
		assertEquals(3, reportBuilder.count(Direction.S, 0, -1, -1));

		// direction of 2nd day
		assertEquals(0, reportBuilder.count(Direction.N, 1, -1, -1));
		assertEquals(1, reportBuilder.count(Direction.S, 1, -1, -1));

		// period 0:00 - 1:00am of 1st day
		assertEquals(1, reportBuilder.count(Direction.N, 0, 0, oneHourMilliSeconds));
		assertEquals(2, reportBuilder.count(Direction.S, 0, 0, oneHourMilliSeconds));

		// period 23:00 - 24:00 of 1st day
		assertEquals(0, reportBuilder.count(Direction.N, 0, 23 * oneHourMilliSeconds, oneHourMilliSeconds));
		assertEquals(1, reportBuilder.count(Direction.S, 0, 23 * oneHourMilliSeconds, oneHourMilliSeconds));

		// period 0:00 - 1:00am of 2nd day
		assertEquals(0, reportBuilder.count(Direction.N, 1, 0, oneHourMilliSeconds));
		assertEquals(1, reportBuilder.count(Direction.S, 1, 0, oneHourMilliSeconds));

	}

	public void testReport() {
		Report report = reportBuilder.buildReport(Report.MS_HOUR);
		List<DailyReport> dailyReports = report.getDailyReports();

		// it should get 5 days daily reports
		assertEquals(5, dailyReports.size());

	}

}
