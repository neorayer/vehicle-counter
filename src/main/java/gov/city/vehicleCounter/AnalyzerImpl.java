package gov.city.vehicleCounter;

/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem;

/**
 * AnalyzerImpl class is the implementation of interface Analyzer.
 *
 */
public class AnalyzerImpl implements Analyzer {
	private List<AxleItem> axleItems = new LinkedList<AxleItem>();
	private List<CarItem> carItems = new LinkedList<CarItem>();

	@Override
	public void setAxleItems(List<AxleItem> items) {
		this.axleItems.clear();
		this.axleItems.addAll(items);
	}

	@Override
	public List<CarItem> getCarItems() {
		return this.carItems;
	}

	/**
	 * analyze the axle data into car data.
	 * Some car data need 2 axle items and others need 4.
	 */
	void fromAxleItemsToCarItems() {
		carItems.clear();

		CarItem carItem = new CarItem();
		for (AxleItem axleItem : this.axleItems) {
			carItem.addAxleItem(axleItem);
			if (carItem.isIntegrated()) {
				this.carItems.add(carItem);
				carItem = new CarItem();
			}
		}
	}


	/**
	 * Sepreate the car data day by day.
	 */
	private void separateCarItemsByDay() {
		CarItem lastItem = null;
		int day = -1;
		for (CarItem item : this.carItems) {
			if (item.isEarlierThan(lastItem)) {
				day++;
			}
			item.setDay(day);
			lastItem = item;
		}
	}

	@Override
	public void analyze() {
		fromAxleItemsToCarItems();
		separateCarItemsByDay();
	}

}
