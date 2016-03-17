package gov.city.vehicleCounter;
/**
 * 
 * @author Rui Zhou
 * @create 17/3/2016
 */
import java.util.List;

import gov.city.vehicleCounter.data.CarItem;
import gov.city.vehicleCounter.data.CarItem.Direction;
import gov.city.vehicleCounter.report.Report;

/**
 * ReportBuilder interface is used to define how to build complex of data analyzing report.
 *
 */
public interface ReportBuilder {

	void init(List<CarItem> carItems);

	/**
	 * count the total
	 * 
	 * @return
	 */
	long count();

	/**
	 * count by direction
	 * 
	 * @param dir
	 * @return
	 */
	long count(Direction dir);

	/**
	 * count by a special day
	 * 
	 * @param day
	 * @return
	 */
	long count(int day);

	/**
	 * count by a special time span
	 * 
	 * @param timeBegin
	 * @param timeSpan
	 * @return
	 */
	long count(long timeBegin, long timeSpan);

	/**
	 * count by multiple conditions
	 * 
	 * @param dir
	 * @param day
	 * @param beginTime
	 * @param timeSpan
	 * @return
	 */
	long count(Direction dir, int day, long beginTime, long timeSpan);

	/**
	 * Build a report 
	 * 
	 * @param timeSpan
	 * @return
	 */
	Report buildReport(long timeSpan);
}
