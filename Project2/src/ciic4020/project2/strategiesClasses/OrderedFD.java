package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		dataSet.sort(null);
		for(int i = 0;i < dataSet.size();i+=0) {
			E e = dataSet.get(i);
			Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(e, 0); 
			while(i<dataSet.size() && dataSet.get(i).equals(e)) {
				entry.setValue(entry.getValue()+1);
				i++;
			}
			results.add(entry);
		}
		return results;
		
	}

}
