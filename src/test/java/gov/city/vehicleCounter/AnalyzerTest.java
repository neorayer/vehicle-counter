package gov.city.vehicleCounter;

import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.DataItem.Sensor;
import junit.framework.TestCase;

public class AnalyzerTest extends TestCase {

	public void testFindDataPairOfOneCar() {
		List<DataItem> items = new LinkedList<DataItem>();
		items.add(new DataItem(Sensor.A, 268981));
		items.add(new DataItem(Sensor.A, 269123));

		items.add(new DataItem(Sensor.A, 604957));
		items.add(new DataItem(Sensor.B, 604960));
		items.add(new DataItem(Sensor.A, 605128));
		items.add(new DataItem(Sensor.B, 605132));

		Analyzer analyzer = BeanFactory.getAnalyzer();
		analyzer.setDataItems(items);
		analyzer.analyze();

		List<DataPair> pairs = analyzer.getPairs();
		
		DataPair pair0 = pairs.get(0);
		assertEquals(pair0.getFrontAxleItem().getAxle(), Sensor.A);
		assertEquals(pair0.getFrontAxleItem().getMillSeconds(), 268981);
		assertEquals(pair0.getRearAxleItem().getAxle(), Sensor.A);
		assertEquals(pair0.getRearAxleItem().getMillSeconds(), 269123);
		assertEquals(pair0.getDirection(), DataPair.Direction.N);

		DataPair pair1 = pairs.get(1);
		assertEquals(pair1.getFrontAxleItem().getAxle(), Sensor.A);
		assertEquals(pair1.getFrontAxleItem().getMillSeconds(), 604957);
		assertEquals(pair1.getRearAxleItem().getAxle(), Sensor.B);
		assertEquals(pair1.getRearAxleItem().getMillSeconds(), 605132);
		assertEquals(pair1.getDirection(), DataPair.Direction.S);

	}
}
