package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import ciic4020.project2.sortedlist.SortedList;
import ciic4020.project2.sortedlist.SortedArrayList;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Kevin Purcell
 * 
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Juan O. Lopez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V>
			extends AbstractMap.SimpleEntry<K, V>
			implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}
		
	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}
	
	/**
	 * This is the method responsible for counting the frequencies in the array list.
	 * It stores all the elements in dataSet into a sorted list as entries, ensuring that 
	 * the entries are sorted. The implementation is then nearly identical to the SequentialFD
	 * variation, except when checking if an entry is already present, the method only checks 
	 * until it finds an entry whose key is greater than the target key. It also copies all entries
	 * in the sorted list into results for returning.
	 * 
	 * @author Kevin Purcell
	 */

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		SortedList<ComparableEntry<E, Integer>> sortedlist = new SortedArrayList<ComparableEntry<E, Integer>>(1000);
		
		for (E e : dataSet) { 
			boolean entryFound = false; 
			int i = 0;
			while (i<sortedlist.size() && !entryFound && sortedlist.get(i).getKey().compareTo(e) <= 0) {
				ComparableEntry<E, Integer> entry = sortedlist.get(i); 
				if (entry.getKey().equals(e)) { 
					entry.setValue(entry.getValue()+1);
					entryFound = true; 
				}
				i++;
			}
			if (!entryFound) { 
				sortedlist.add(new ComparableEntry<E, Integer>(e, 1)); 
			}
		}
		for(int i = 0;i<sortedlist.size();i++) {
			results.add(sortedlist.get(i));
		}
	
		return results;
	}

}