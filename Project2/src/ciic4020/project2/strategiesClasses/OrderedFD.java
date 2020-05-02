package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Kevin Purcell
 * 
 * @param <E> The type of the elements whose frequencies are being counted.
 */

public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * This is the method responsible for counting the frequencies in the array list.
	 * It sorts the dataSet before beginning the count. Once sorted, it loops through
	 * the dataSet, creating an entry and then comparing that entry's key to the
	 * subsequent values in the list. While the value is equal to the entry's key,  
	 * it increments the entry's value and moves onto the next iteration. Otherwise, 
	 * the entry is added to results and the loop continues. The loop ends when all
	 * elements have been counted and then the method returns results.
	 * 
	 * @author Kevin Purcell
	 */
	
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
