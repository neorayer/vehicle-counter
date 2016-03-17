package gov.city.vehicleCounter.report;

import java.util.LinkedList;
import java.util.List;

public class Report {
	public final static long MS_DAY = 24 * 60 * 60 * 1000;
	public final static long MS_HOUR = 60 * 60 * 1000;
	public static long MS_HALF_HOUR = 30 * 60 * 1000;
	public static long MS_20MIN = 20 * 60 * 1000;
	public static long MS_15MIN = 15 * 60 * 1000;

	private List<DailyReport> dailyReports = new LinkedList<DailyReport>();

	private DailyReport averageReport = new DailyReport();

	public List<DailyReport> getDailyReports() {
		return dailyReports;
	}

	public DailyReport getAverageReport() {
		return averageReport;
	}

}
