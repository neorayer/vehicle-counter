package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.AxleItem.Sensor;

/**
 * DataReader is used to read data from a java resource or file.
 */
public class DataReader {

	private Logger logger;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	List<String> read(InputStream in) {
		List<String> lines = new LinkedList<String>();
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.length() == 0)
					continue;
				lines.add(line);
			}
		}
		return lines;
	}

	List<String> readLinesFromResource(String name) throws IOException {
		try (InputStream in = ClassLoader.getSystemResourceAsStream(name)) {
			if (in == null)
				throw new IOException("Can not find resource named " + name);
			return read(in);
		}
	}
	
	List<String> readLinesFromFile(String fileName) throws IOException {
		try (InputStream in = new FileInputStream(fileName)) {
			return read(in);
		}
	}

	AxleItem parseLine(String line) {
		line = line.trim();
		String head = line.substring(0, 1);
		String tail = line.substring(1, line.length());
		Sensor sensor = head.equals("A") ? Sensor.A : Sensor.B;
		long millSeconds = Long.parseLong(tail);
		return new AxleItem(sensor, millSeconds);
	}

	public List<AxleItem> readDataFromResource(String name) throws IOException {
		// @formatter:off
		return  readLinesFromResource(name)
				.stream()
				.map((line) -> this.parseLine(line))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public List<AxleItem> readDataFromFile(String filePath) throws IOException {
		// @formatter:off
		return  readLinesFromFile(filePath)
				.stream()
				.map((line) -> this.parseLine(line))
				.collect(Collectors.toList());
		// @formatter:on
		}

}
