package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Hashtable;
import java.util.Map;

/**
 * This class implements the Map strategy to count frequencies in an ArrayList.
 * @author Kevin Purcell
 * 
 * @param <E> The type of the elements whose frequencies are being counted.
 */

public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}
	
	/**
	 * This is the method responsible for counting the frequencies in the array list.
	 * It stores all elements in dataSet into a hash table containing the element as 
	 * the key and frequency as the value. The class will check if the key is already
	 * present in the list and increment its value by 1 or add a new entry if the 
	 * key is not already present. Once done, all the entries in the hash table are 
	 * then copied into results.
	 * 
	 * @author Kevin Purcell
	 */

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		Hashtable<E, Integer> hashtable = new Hashtable<E, Integer>();
		for(E e : dataSet) {
			if(hashtable.containsKey(e)) {
				hashtable.replace(e, hashtable.get(e).intValue()+1);
			}else {
				hashtable.put(e, 1);
			}
		}
		for(Map.Entry<E, Integer> entry : hashtable.entrySet()) {
			results.add(entry);
		}
		return results;
	}

}
