package gov.city.vehicleCounter;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.DataItem.Sensor;

/**
 * Hello world!
 *
 */
public class App {
	
	
	
	public static void main(String[] args) {
		List<DataItem> items = new LinkedList<DataItem>();
		items.add(new DataItem(Sensor.A, 268981));
		items.add(new DataItem(Sensor.A, 269123));
		items.add(new DataItem(Sensor.A, 604957));
		items.add(new DataItem(Sensor.B, 604960));
		
	
		
		
		LocalTime beginTime = LocalTime.of(0, 0);
		LocalTime time = LocalTime.of(0, 4, 28);	
		long spanNano = time.toNanoOfDay() - beginTime.toNanoOfDay();
		long spanMill = spanNano / 1000000;
		System.out.println(spanMill);

		System.out.println("Hello World!");
	}
}
