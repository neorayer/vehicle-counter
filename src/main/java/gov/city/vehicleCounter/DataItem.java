package gov.city.vehicleCounter;

public class DataItem {

	public enum Sensor {
		A, B
	}

	private Sensor axle;

	private long millSeconds;

	public DataItem(Sensor axle, long millSeconds) {
		super();
		this.axle = axle;
		this.millSeconds = millSeconds;
	}

	public Sensor getAxle() {
		return axle;
	}

	public long getMillSeconds() {
		return millSeconds;
	}

}
