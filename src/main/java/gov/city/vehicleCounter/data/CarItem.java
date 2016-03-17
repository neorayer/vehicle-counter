package gov.city.vehicleCounter.data;

import gov.city.vehicleCounter.data.CarItem.Direction;

public class CarItem {
	public enum Direction {
		ALL, N, S
	}

	private Direction direction;
	private AxleItem frontAxleItem;
	private AxleItem rearAxleItem;
	private int day = -1;

	private int axleItemCount = 0;
	private boolean isIntegrated = false;

	public CarItem() {
	}

	public Direction getDirection() {
		return direction;
	}

	public AxleItem getFrontAxleItem() {
		return frontAxleItem;
	}

	public AxleItem getRearAxleItem() {
		return rearAxleItem;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		System.out.println(day);

		return this.day;
	}

	public boolean isIntegrated() {
		return isIntegrated;
	}

	public void addAxleItem(AxleItem axleItem) {
		axleItemCount++;
		String state = axleItem.getSensor() + "-" + axleItemCount;
		switch (state) {
		case "A-1":
			this.frontAxleItem = axleItem;
			break;
		case "A-2":
			this.rearAxleItem = axleItem;
			this.direction = Direction.N;
			this.isIntegrated = true;
			break;
		case "A-3":
			this.rearAxleItem = axleItem;
			break;
		case "B-2":
			this.direction = Direction.S;
			break;
		case "B-4":
			this.isIntegrated = true;
			break;
		default:
			throw new RuntimeException("Dirty Data");
		}
	}

	public boolean isEarlierThan(CarItem item) {
		return item == null || this.rearAxleItem.getMillSeconds() < item.getRearAxleItem().getMillSeconds();
	}

	public boolean isBelongTo(Direction dir) {
		return dir.equals(Direction.ALL) || this.direction.equals(dir);
	}

	public boolean isInDay(int day) {
		return day < 0 || this.day == day;
	}

	public boolean isInPeriod(long beginTime, long timeSpan) {
		long t = this.getRearAxleItem().getMillSeconds();

		if (beginTime < 0)
			return true;
		if (timeSpan < 0)
			return t >= beginTime;
		return t >= beginTime && t < beginTime + timeSpan;
	}

}
