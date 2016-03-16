package gov.city.vehicleCounter;

import java.io.IOException;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.AxleItem.Sensor;
import junit.framework.TestCase;

public class DataReaderTest extends TestCase {
	private BeanFactory factory = new SimpleBeanFactory();
	private DataReader dataReader;
	final private String sampleName = "gov/city/vehicleCounter/sample-data.txt";

	protected void setUp() throws Exception {
		super.setUp();
		dataReader = factory.getDataReader();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testReadLines() throws IOException {
		List<String> lines = dataReader.readLinesFromResource(sampleName);
		// test the size
		assertEquals(18, lines.size());
		// test the first line
		assertEquals("A268981", lines.get(0));
		// test the last line
		assertEquals("B582789", lines.get(17));
	}

	public void testParseLine() {
		AxleItem item = dataReader.parseLine("A268981");
		assertEquals(Sensor.A, item.getSensor());
		assertEquals(268981, item.getMillSeconds());
	}

	public void testReadData() throws IOException {
		List<AxleItem> items = dataReader.readDataFromResource(sampleName);

		// test size
		assertEquals(18, items.size());

		// test first data
		{
			AxleItem item = items.get(0);
			assertEquals(Sensor.A, item.getSensor());
			assertEquals(268981, item.getMillSeconds());
		}
		// test last data
		{
			AxleItem item = items.get(items.size() - 1);
			assertEquals(Sensor.B, item.getSensor());
			assertEquals(582789, item.getMillSeconds());
		}
	}
}
