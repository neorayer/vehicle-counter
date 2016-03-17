package gov.city.vehicleCounter;

import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;
import gov.city.vehicleCounter.report.DailyReport;
import gov.city.vehicleCounter.report.Report;
import gov.city.vehicleCounter.report.ReportItem;

public class ReportBuilderImpl implements ReportBuilder {

	private List<CarItem> carItems;

	public void init(List<CarItem> carItems) {
		this.carItems = carItems;
	}

	public long count(Direction dir, int day, long beginTime, long timeSpan) {
		// @formatter:off
		return carItems.stream()
				.filter((item) -> item.isBelongTo(dir))
				.filter((item) -> item.isInDay(day))
				.filter((item)->item.isInPeriod(beginTime,timeSpan))
				.count();
		// @formatter:on
	}

	public long count() {
		return carItems.size();
	}

	public long count(Direction dir) {
		return count(dir, -1, -1, -1);
	}

	public long count(int day) {
		return count(Direction.ALL, day, -1, -1);
	}

	public long count(long timeBegin, long timeSpan) {
		return count(Direction.ALL, -1, timeBegin, timeSpan);
	}

	public Report buildReport(long timeSpan) {
		for (int i = 0; i < 5; i++) {
			DailyReport dReport = new DailyReport();
			int id = 0;
			for (long t = 0; t < Report.MS_DAY; t += timeSpan) {
				ReportItem reItem = new ReportItem();
				reItem.setId(id++);
				reItem.setBeginTime(t);
				reItem.setTimeSpan(timeSpan);
				reItem.set
				long c = count(Direction.N, i, t, timeSpan);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

}
