package gov.city.vehicleCounter.report;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */

import java.util.ArrayList;
import java.util.List;

/**
 * DailyReport class is special save the data analytic result of daily
 *
 */
public class DailyReport {
	private int day;

	private long timeSpan;

	private List<ReportItem> items = new ArrayList<ReportItem>();

	public DailyReport(int day, long timeSpan) {
		this.day = day;
		this.timeSpan = timeSpan;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public long getTimeSpan() {
		return timeSpan;
	}

	public void setTimeSpan(long timeSpan) {
		this.timeSpan = timeSpan;
	}

	public List<ReportItem> getItems() {
		return this.items;
	}

	public void addItem(ReportItem reItem) {
		items.add(reItem);

	}

	public ReportItem getNorthPeak() {
		ReportItem peak = items.get(0);
		for (ReportItem item : items) {
			long v = item.getValueN();
			if (v > peak.getValueN()) {
				peak = item;
			}
		}
		return peak;
	}

	public ReportItem getSouthPeak() {
		ReportItem peak = items.get(0);
		for (ReportItem item : items) {
			long v = item.getValueS();
			if (v > peak.getValueS()) {
				peak = item;
			}
		}
		return peak;
	}

	public String getTitle() {
		return 	String.format("Day:%d   TimeSpan:%d minutes", getDay(), (int) (getTimeSpan() / 1000 / 60));
	}

}
