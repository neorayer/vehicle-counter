package gov.city.vehicleCounter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem;

public class AnalyzerImpl implements Analyzer {
	private List<AxleItem> axleItems = new LinkedList<AxleItem>();
	private List<CarItem> carItems = new LinkedList<CarItem>();

	public void setDataReader(DataReader dReader) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void setAxleItems(List<AxleItem> items) {
		this.axleItems.clear();
		this.axleItems.addAll(items);
	}

	public List<CarItem> getCarItems() {
		return this.carItems;
	}


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

	public void analyze() {
		fromAxleItemsToCarItems();
		separateCarItemsByDay();
	}

}
