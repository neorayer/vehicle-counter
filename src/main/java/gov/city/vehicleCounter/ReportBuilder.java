package gov.city.vehicleCounter;

import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;

public interface ReportBuilder {

	void build(List<CarItem> carItems, List<List<CarItem>> carItemsOfDays);

	long count();

	long count(Direction dir);

	long countByDay(int day);

	long count(long timeBegin, long timeSpan);

	public long count(Direction dir, int day, long beginTime, long timeLong);
}
