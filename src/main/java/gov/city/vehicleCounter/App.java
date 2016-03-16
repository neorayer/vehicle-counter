package gov.city.vehicleCounter;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.AxleItem.Sensor;

/**
 * Hello world!
 *
 */
public class App {
	
	
	
	public static void main(String[] args) {
		List<AxleItem> items = new LinkedList<AxleItem>();
		items.add(new AxleItem(Sensor.A, 268981));
		items.add(new AxleItem(Sensor.A, 269123));
		items.add(new AxleItem(Sensor.A, 604957));
		items.add(new AxleItem(Sensor.B, 604960));
		
	
		
		
		LocalTime beginTime = LocalTime.of(0, 0);
		LocalTime time = LocalTime.of(0, 4, 28);	
		long spanNano = time.toNanoOfDay() - beginTime.toNanoOfDay();
		long spanMill = spanNano / 1000000;
		System.out.println(spanMill);

		System.out.println("Hello World!");
	}
}
