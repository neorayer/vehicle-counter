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

	long count();

	long count(Direction dir);

	long count(int day);

	long count(long timeBegin, long timeSpan);

	public long count(Direction dir, int day, long beginTime, long timeSpan);

	Report buildReport(long timeSpan);
}
