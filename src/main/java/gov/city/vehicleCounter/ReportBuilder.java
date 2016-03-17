package gov.city.vehicleCounter;

import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;
import gov.city.vehicleCounter.report.Report;

public interface ReportBuilder {

	void init(List<CarItem> carItems);

	long count();

	long count(Direction dir);

	long count(int day);

	long count(long timeBegin, long timeSpan);

	public long count(Direction dir, int day, long beginTime, long timeSpan);

	Report buildReport(long timeSpan);
}
