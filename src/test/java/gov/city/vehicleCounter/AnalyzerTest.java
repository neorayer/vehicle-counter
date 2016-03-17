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
			assertEquals(Sensor.A, item.getFrontAxleItem().getSensor());
			assertEquals(268981, item.getFrontAxleItem().getMillSeconds());
			assertEquals(Sensor.A, item.getRearAxleItem().getSensor());
			assertEquals(269123, item.getRearAxleItem().getMillSeconds());
			assertEquals(CarItem.Direction.N, item.getDirection());
		}

		{
			CarItem item = carItems.get(1);
			assertEquals(Sensor.A, item.getFrontAxleItem().getSensor());
			assertEquals(604957, item.getFrontAxleItem().getMillSeconds());
			assertEquals(Sensor.A, item.getRearAxleItem().getSensor());
			assertEquals(605128, item.getRearAxleItem().getMillSeconds());
			assertEquals(CarItem.Direction.S, item.getDirection());
		}
	}

	public void testSeparateByDays() {
		List<CarItem> items = analyzer.getCarItems();

		// test the 1st day
		{
			// test the 2nd car
			CarItem item = items.get(1);
			assertEquals(Sensor.A, item.getFrontAxleItem().getSensor());
			assertEquals(604957, item.getFrontAxleItem().getMillSeconds());
			assertEquals(Sensor.A, item.getRearAxleItem().getSensor());
			assertEquals(605128, item.getRearAxleItem().getMillSeconds());
			// test day
			assertEquals(0, item.getDay());
		}

		// test the 2nd day
		{
			// test the 1st car
			CarItem item = items.get(4);
			assertEquals(Sensor.A, item.getFrontAxleItem().getSensor());
			assertEquals(582668, item.getFrontAxleItem().getMillSeconds());
			assertEquals(Sensor.A, item.getRearAxleItem().getSensor());
			assertEquals(582787, item.getRearAxleItem().getMillSeconds());
			// test day
			assertEquals(item.getDay(), 1);
		}
	}

}
