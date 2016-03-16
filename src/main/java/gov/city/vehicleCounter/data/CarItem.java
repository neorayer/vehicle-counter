package gov.city.vehicleCounter.data;

public class CarItem {
	public enum Direction {
		N, S
	}

	private Direction direction;
	private AxleItem frontAxleItem;
	private AxleItem rearAxleItem;
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

}
