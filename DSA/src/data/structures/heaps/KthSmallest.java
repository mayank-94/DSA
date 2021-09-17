/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class KthSmallest {

	public static void main(String[] args) {
		int arr[] = {8, 6, 2, 4, 5, 10, 9, 7};
		int k = 3;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		for(int i=0; i<k; i++) maxHeap.add(arr[i]);
		
		for(int i=k; i<arr.length; i++) {
			if(arr[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}
		
		System.out.println(maxHeap.peek());
	}
}
