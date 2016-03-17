package gov.city.vehicleCounter.report;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.time.LocalTime;

/**
 * ReportItem is one item of a report
 */
public class ReportItem {
	private int id;

	private long beginTime;

	private long timeSpan;

	private long valueN = 0;

	private long valueS = 0;

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

	public long getTimeSpan() {
		return timeSpan;
	}

	public void setTimeSpan(long timeSpan) {
		this.timeSpan = timeSpan;
	}

	public long getValueN() {
		return valueN;
	}

	public void setValueN(long valueN) {
		this.valueN = valueN;
	}

	public long getValueS() {
		return valueS;
	}

	public void setValueS(long valueS) {
		this.valueS = valueS;
	}

	@Override
	public String toString() {
		LocalTime time = LocalTime.ofSecondOfDay(beginTime / 1000);
		return String.format("%d:%d\t%d\t%d", time.getHour(), time.getMinute(), valueN, valueS);
	}

}
