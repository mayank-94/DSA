/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class KthLargest {

	public static void main(String[] args) {
		int arr[] = {8, 6, 2, 4, 5, 10, 9, 7};
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i=0; i<k; i++) {
			minHeap.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(arr[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		
		System.out.println(minHeap.peek());
	}
}
