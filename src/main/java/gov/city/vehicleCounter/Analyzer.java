package gov.city.vehicleCounter;

import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem;

public interface Analyzer {

	void setDataReader(DataReader dReader);

	void analyze();

	void setAxleItems(List<AxleItem> items);

	List<CarItem> getCarItems();


}
