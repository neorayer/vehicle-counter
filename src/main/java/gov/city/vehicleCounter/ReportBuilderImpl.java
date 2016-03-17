package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;
import gov.city.vehicleCounter.report.DailyReport;
import gov.city.vehicleCounter.report.Report;
import gov.city.vehicleCounter.report.ReportItem;
/**
 * ReportBuilderImpl is to implement ReportBuilder interface. 
 * It is used to build complex of data analyzing report.
 *
 */

public class ReportBuilderImpl implements ReportBuilder {

	private List<CarItem> carItems;

	@Override
	public void init(List<CarItem> carItems) {
		this.carItems = carItems;
	}

	@Override
	public long count(Direction dir, int day, long beginTime, long timeSpan) {
		// @formatter:off
		return carItems.stream()
				.filter((item) -> item.isBelongTo(dir))
				.filter((item) -> item.isInDay(day))
				.filter((item)->item.isInPeriod(beginTime,timeSpan))
				.count();
		// @formatter:on
	}

	@Override
	public long count() {
		return carItems.size();
	}

	@Override
	public long count(Direction dir) {
		return count(dir, -1, -1, -1);
	}

	@Override
	public long count(int day) {
		return count(Direction.ALL, day, -1, -1);
	}

	@Override
	public long count(long timeBegin, long timeSpan) {
		return count(Direction.ALL, -1, timeBegin, timeSpan);
	}

	@Override
	public Report buildReport(long timeSpan) {
		Report report = new Report(timeSpan);

		for (int i = 0; i < 5; i++) {
			DailyReport dReport = new DailyReport(i, timeSpan);
			int id = 0;
			for (long t = 0; t < Report.MS_DAY; t += timeSpan) {
				ReportItem reItem = new ReportItem();
				reItem.setId(id++);
				reItem.setBeginTime(t);
				reItem.setTimeSpan(timeSpan);
				reItem.setValueN(count(Direction.N, i, t, timeSpan));
				reItem.setValueS(count(Direction.S, i, t, timeSpan));
				dReport.addItem(reItem);
			}
			report.addDailyReport(dReport);
		}
		return report;
	}

}
