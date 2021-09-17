/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Fractional_Knapsack {

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
        
        double maxValue = getMaxValue(wt, val, capacity);
        System.out.println(maxValue);
	}

	/**
	 * @param wt
	 * @param val
	 * @param capacity
	 * @return
	 */
	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		List<Item> list = new ArrayList<Item>();
		for(int i=0; i<wt.length; i++)
			list.add(new Item(wt[i], val[i], i));
		
		Collections.sort(list, (a, b) -> b.cost.compareTo(a.cost));
		double totalValue = 0;
		
		for(Item item : list) {
			if(item.wt <= capacity) {
				capacity -= item.wt;
				totalValue += item.val;
			}else {
				double fraction = (double) capacity / (double) item.wt;
				totalValue += fraction * item.val;
				capacity = (int) (capacity - item.wt * fraction);
				break;
			}
		}
		return totalValue;
	}
}

class Item{
	int wt, val, index;
	Double cost;
	
	Item(int wt, int val, int index){
		this.wt = wt;
		this.val = val;
		this.index = index;
		cost = new Double((double) val / (double) wt);
	}
}
