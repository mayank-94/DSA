/**
 * 
 */
package data.structures.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author mayankjain
 * 
 */
public class Frequency_Sort {

	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 2, 2, 3, 5};
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int x : arr)
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> hm.get(a) == hm.get(b) ? 
                 b - a : hm.get(a) - hm.get(b));
		
		maxHeap.addAll(hm.keySet());
		
		while(maxHeap.size() > 0) {
			int key = maxHeap.poll();
			int value = hm.get(key);
			while(value > 0) {
				System.out.print(key+" ");
				value--;
			}
		}
	}
}
