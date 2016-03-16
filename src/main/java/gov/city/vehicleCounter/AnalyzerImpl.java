package gov.city.vehicleCounter;

import java.util.LinkedList;
import java.util.List;

public class AnalyzerImpl implements Analyzer {
	private List<DataItem> items = new LinkedList<DataItem>();
	private List<DataPair> pairs = new LinkedList<DataPair>();

	public void setDataReader(DataReader dReader) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void analyze() {
		DataPair pair = new DataPair();
		for (DataItem item: this.items) {
			if (pair.getFrontAxleItem() == null) {
				pair.setFrontAxleItem(item);
			}
			
			
		}
		this.items.stream().forEach((item) -> System.out.println(item));
		
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();

	}

	public void setDataItems(List<DataItem> items) {
		this.items.clear();
		this.items.addAll(items);
	}

	public List<DataPair> getPairs() {
		return this.pairs;
	}

}
