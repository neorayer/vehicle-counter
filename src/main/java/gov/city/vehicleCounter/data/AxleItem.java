package gov.city.vehicleCounter.data;

public class AxleItem {

	public enum Sensor {
		A, B
	}

	private Sensor axle;

	private long millSeconds;

	public AxleItem(Sensor axle, long millSeconds) {
		super();
		this.axle = axle;
		this.millSeconds = millSeconds;
	}

	public Sensor getSensor() {
		return axle;
	}

	public long getMillSeconds() {
		return millSeconds;
	}

}
