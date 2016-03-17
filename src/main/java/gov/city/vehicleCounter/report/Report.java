package gov.city.vehicleCounter.report;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Report class is for save the analytic result of special timeSpan and day.
 * It includes multiple daily reports.
 *
 */
public class Report {
	public final static long MS_DAY = 24 * 60 * 60 * 1000;
	public final static long MS_HALF_DAY = 14 * 60 * 60 * 1000;
	public final static long MS_HOUR = 60 * 60 * 1000;
	public static long MS_HALF_HOUR = 30 * 60 * 1000;
	public static long MS_20MIN = 20 * 60 * 1000;
	public static long MS_15MIN = 15 * 60 * 1000;

	private long timeSpan;

	private List<DailyReport> dailyReports = new LinkedList<DailyReport>();

	public Report(long timeSpan) {
		this.timeSpan = timeSpan;
	}

	public long getTimeSpan() {
		return timeSpan;
	}

	public void setTimeSpan(long timeSpan) {
		this.timeSpan = timeSpan;
	}

	public List<DailyReport> getDailyReports() {
		return dailyReports;
	}

	public void addDailyReport(DailyReport dReport) {
		dailyReports.add(dReport);
	}

	/**
	 * Build a average report for all the days and return it back.
	 * @return
	 */
	public DailyReport getAverageReport() {
		DailyReport avgReport = new DailyReport(-1, timeSpan);

		int id = 0;
		for (long t = 0; t < Report.MS_DAY; t += timeSpan) {
			ReportItem reItem = new ReportItem();
			reItem.setId(id);
			reItem.setBeginTime(t);
			reItem.setTimeSpan(timeSpan);
			long sumN = 0;
			long sumS = 0;
			for (DailyReport dp : dailyReports) {
				ReportItem item = dp.getItems().get(id);
				sumN += item.getValueN();
				sumS += item.getValueS();
			}
			reItem.setValueN(sumN / dailyReports.size());
			reItem.setValueN(sumS / dailyReports.size());

			avgReport.addItem(reItem);
			id++;
		}

		return avgReport;
	}

	/**
	 * output a special daily report to a printStream
	 * @param out
	 * @param dp
	 */
	public void output(PrintStream out, DailyReport dp) {
		out.println(dp.getTitle());
		out.println("=================");
		for (ReportItem item : dp.getItems()) {
			out.println(item);
		}
		out.println("-----------------");
		out.println("North Peak time: " + dp.getNorthPeak().toString());
		out.println("Sorth Peak time: " + dp.getSouthPeak().toString());
		out.println();
		out.println();
	}

	/**
	 * output all the reports to a printstream.
	 * @param out
	 */
	public void output(PrintStream out) {
		// output dailyReports
		for (DailyReport dp : dailyReports) {
			output(out, dp);
		}

		// output dailyReports
		out.println("**************************************");
		out.println("Average Report of 5 days");
		output(out, this.getAverageReport());

	}

}
