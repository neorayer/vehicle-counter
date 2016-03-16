package gov.city.vehicleCounter;

public class DataPair {
	public enum Direction {
		N, S
	}

	private Direction direction;
	private DataItem frontAxleItem;
	private DataItem rearAxleItem;

	public DataPair(Direction direction, DataItem frontAxleItem, DataItem rearAxleItem) {
		super();
		this.direction = direction;
		this.frontAxleItem = frontAxleItem;
		this.rearAxleItem = rearAxleItem;
	}

	public DataPair() {
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public DataItem getFrontAxleItem() {
		return frontAxleItem;
	}

	public void setFrontAxleItem(DataItem frontAxleItem) {
		this.frontAxleItem = frontAxleItem;
	}

	public DataItem getRearAxleItem() {
		return rearAxleItem;
	}

	public void setRearAxleItem(DataItem rearAxleItem) {
		this.rearAxleItem = rearAxleItem;
	}




}
