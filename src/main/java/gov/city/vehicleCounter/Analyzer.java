package gov.city.vehicleCounter;

import java.util.List;

public interface Analyzer {

	void setDataReader(DataReader dReader);

	void analyze();

	void setDataItems(List<DataItem> items);

	List<DataPair> getPairs();

}
