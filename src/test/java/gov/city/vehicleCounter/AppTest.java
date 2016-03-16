package gov.city.vehicleCounter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);

		DataReader dReader = BeanFactory.getDataReader();
		Analyzer analyzer = BeanFactory.getAnalyzer();
		analyzer.setDataReader(dReader);
		analyzer.analyze();
		ReportBuilder reportBuilder = BeanFactory.getReportBuilder();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
}
