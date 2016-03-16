package gov.city.vehicleCounter;

import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;

public class ReportBuilderImpl implements ReportBuilder {

	private List<CarItem> carItems;
	private List<List<CarItem>> carItemsOfDays;

	public void build(List<CarItem> carItems, List<List<CarItem>> carItemsOfDays) {
		this.carItems = carItems;
		this.carItemsOfDays = carItemsOfDays;
	}

	public long count(Direction dir, int day, long beginTime, long timeLong) {
		// @formatter:off
		return carItems.stream()
				.filter((item) -> item.isBelongTo(dir))
				.filter((item) -> item.isInDay(day))
				.filter((item)->item.isInPeriod(beginTime,timeLong))
				.count();
		// @formatter:on
	}

	public long count() {
		return carItems.size();
	}

	public long count(Direction dir) {
		return count(dir, -1, -1, -1);
	}

	public long countByDay(int day) {
		return count(Direction.ALL, day, -1, -1);
	}

	public long count(long timeBegin, long timeSpan) {
		return count(Direction.ALL, -1, timeBegin, timeSpan);
	}

}
