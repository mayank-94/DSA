/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class Minimize_Cost_Rope {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int x : arr)
			minHeap.add(x);
		
		int cost = 0;
		while(minHeap.size() > 1) {
			int ct = 0, sum = 0;
			while(ct < 2) {
				int x = minHeap.poll();
				sum += x;
				ct++;
			}
			cost += sum;
			ct = 0;
			minHeap.add(sum);
		}
		
		System.out.println(cost);
	}
}
