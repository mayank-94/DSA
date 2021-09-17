/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class Sort_K_SortedArray {

	public static void main(String[] args) {
		int arr[] = {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			minHeap.add(arr[i]);
			if(minHeap.size() > k) {
				int x = minHeap.poll();
				System.out.print(x+" ");
			}
		}
		
		while(minHeap.size() > 0) {
			int x = minHeap.poll();
			System.out.print(x+" ");
		}
	}
}
