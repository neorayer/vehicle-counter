package gov.city.vehicleCounter.report;

public class ReportItem {
	private int id;

	private long beginTime;

	private long timeSpan;

	private long valueN = 0;

	private long valueS = 0;

	// public ReportItem(int id, long beginTime, long timeSpan, long value) {
	// super();
	// this.id = id;
	// this.beginTime = beginTime;
	// this.timeSpan = timeSpan;
	// this.value = value;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public void setTimeSpan(long timeSpan) {
		this.timeSpan = timeSpan;
	}

	public long getTimeSpan() {
		return timeSpan;
	}

	public long getValueN() {
		return valueN;
	}

	public long getValueS() {
		return valueS;
	}

}
