package gov.city.vehicleCounter;

import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.AxleItem.Sensor;
import junit.framework.TestCase;

public class AnalyzerTest extends TestCase {
	private List<AxleItem> axleItems = new LinkedList<AxleItem>();
	private BeanFactory factory = new SimpleBeanFactory();
	private Analyzer analyzer;

	protected void setUp() throws Exception {
		super.setUp();
		axleItems.add(new AxleItem(Sensor.A, 268981));
		axleItems.add(new AxleItem(Sensor.A, 269123));

		axleItems.add(new AxleItem(Sensor.A, 604957));
		axleItems.add(new AxleItem(Sensor.B, 604960));
		axleItems.add(new AxleItem(Sensor.A, 605128));
		axleItems.add(new AxleItem(Sensor.B, 605132));
		
		axleItems.add(new AxleItem(Sensor.A, 86328771));
		axleItems.add(new AxleItem(Sensor.B, 86328774));
		axleItems.add(new AxleItem(Sensor.A, 86328899));
		axleItems.add(new AxleItem(Sensor.B, 86328902));
		
		axleItems.add(new AxleItem(Sensor.A, 582668));
		axleItems.add(new AxleItem(Sensor.B, 582671));
		axleItems.add(new AxleItem(Sensor.A, 582787));
		axleItems.add(new AxleItem(Sensor.B, 582789));
		
		analyzer = factory.getAnalyzer();
		analyzer.setAxleItems(axleItems);
		analyzer.analyze();
	}

	public void testFromItemsAxleToCarItems() {
		List<CarItem> carItems = analyzer.getCarItems();

		{
			CarItem item = carItems.get(0);
			assertEquals(item.getFrontAxleItem().getSensor(), Sensor.A);
			assertEquals(item.getFrontAxleItem().getMillSeconds(), 268981);
			assertEquals(item.getRearAxleItem().getSensor(), Sensor.A);
			assertEquals(item.getRearAxleItem().getMillSeconds(), 269123);
			assertEquals(item.getDirection(), CarItem.Direction.N);
		}

		{
			CarItem item = carItems.get(1);
			assertEquals(item.getFrontAxleItem().getSensor(), Sensor.A);
			assertEquals(item.getFrontAxleItem().getMillSeconds(), 604957);
			assertEquals(item.getRearAxleItem().getSensor(), Sensor.A);
			assertEquals(item.getRearAxleItem().getMillSeconds(), 605128);
			assertEquals(item.getDirection(), CarItem.Direction.S);
		}
	}
	
	public void testSeparateByDays() {
		List<List<CarItem>> carItemsOfDays = analyzer.getCarItemsOfDays();
		assertEquals(carItemsOfDays.size(), 5);
	}

}
