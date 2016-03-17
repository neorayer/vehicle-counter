package gov.city.vehicleCounter.data;

/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */

/**
 * The Data item class to save car data, 
 * remember a can has TWO axles
 */
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

	/**
	 * put a axleItem into carItem
	 * 
	 * add the axle data items into car data.
	 * Some car data need 2 axle items and others need 4.
	 * the direction is judged by the sequence of the sensors:
	 * 
	 * Direction:
	 *  1. the 1st axle item of a car must start from A.
	 *  2. the direction will be N if the 2nd is A too, and
	 *  3. the direction will be S if the 2nd is B.
	 *  
	 * Axle items count:
	 *  the count of axle items of one car is:
	 *  2 - if the direction is N
	 *  4 - if the direction is S.
	 * 
	 * IsIntegrated:
	 *  So when carItem get the axleItem count equals as above number,
	 *  field isIntegrated will be true, and shouldn't received more axle 
	 *  item again.
	 * 
	 * @param axleItem
	 */
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

	/**
	 * compare if the time is early than items time
	 * @param item
	 * @return
	 */
	public boolean isEarlierThan(CarItem item) {
		return item == null || this.rearAxleItem.getMillSeconds() < item.getRearAxleItem().getMillSeconds();
	}

	/**
	 * if the direction is same or belong to dir
	 * @param dir
	 * @return
	 */
	public boolean isBelongTo(Direction dir) {
		return dir.equals(Direction.ALL) || this.direction.equals(dir);
	}

	/**
	 * if in the same day or no special day requirement.
	 * 
	 * @param day
	 * @return
	 */
	public boolean isInDay(int day) {
		return day < 0 || this.day == day;
	}

	/**
	 * if it is in a special timespan
	 * 
	 * @param beginTime
	 * @param timeSpan
	 * @return
	 */
	public boolean isInPeriod(long beginTime, long timeSpan) {
		long t = this.getRearAxleItem().getMillSeconds();

		if (beginTime < 0)
			return true;
		if (timeSpan < 0)
			return t >= beginTime;
		return t >= beginTime && t < beginTime + timeSpan;
	}

}
