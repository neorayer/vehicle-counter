package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.List;

import gov.city.vehicleCounter.data.AxleItem;
import gov.city.vehicleCounter.data.CarItem;

/**
 * The interface to do the analyzation
 *
 */
public interface Analyzer {
	void analyze();

	void setAxleItems(List<AxleItem> items);

	List<CarItem> getCarItems();


}
