package ciic4020.project2.experimentClasses;

import java.io.FileNotFoundException;


import ciic4020.project2.strategiesClasses.*;

/**
 * 
 * @author pedroirivera-vega
 *
 */
public class ExperimentalTrials {

	public static void main(String[] args) {
		// Parm1: initial size
		// Parm2: trials per size
		// Parm3: incremental steps (size)
		// Parm4: last size to consider
		ExperimentController ec = new ExperimentController(50, 200, 50, 1000); 
		
		/**/
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SequentialFD<Integer>())); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SortedListFD<Integer>())); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new OrderedFD<Integer>())); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new MapFD<Integer>())); 
		/**/
		
		/**
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new BubbleSort<Integer>(new IntegerComparator1()))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new HeapSort<Integer>(new IntegerComparator1()))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SelectionSort<Integer>(new IntegerComparator1()))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new QuickSort<Integer>(new IntegerComparator1()))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new MergeSort<Integer>(new IntegerComparator1()))); 
		**/


		ec.run();    // run the experiments on all the strategies added to the controller object (ec)
		
		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

}