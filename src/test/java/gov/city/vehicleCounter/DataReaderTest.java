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
		assertEquals(lines.size(), 18);
		// test the first line
		assertEquals(lines.get(0), "A268981");
		// test the last line
		assertEquals(lines.get(17), "B582789");
	}

	public void testParseLine()  {
		AxleItem item = dataReader.parseLine("A268981");
		assertEquals(item.getSensor(), Sensor.A);
		assertEquals(item.getMillSeconds(), 268981);
	}
	
	public void testReadData() throws IOException {
		List<AxleItem> items = dataReader.readDataFromResource(sampleName);
		
		// test size
		assertEquals(items.size(), 18);
		
		// test first data
		{
			AxleItem item = items.get(0);
			assertEquals(item.getSensor(), Sensor.A);
			assertEquals(item.getMillSeconds(), 268981);
		}
		// test last data
		{
			AxleItem item = items.get(items.size() - 1);
			assertEquals(item.getSensor(), Sensor.B);
			assertEquals(item.getMillSeconds(), 582789);
		}
	}
}
