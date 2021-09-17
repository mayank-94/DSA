/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 * LeetCode
 */
public class JumpGame_IV {
	static class Pair{
		int key;
		int value;
		
		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {10, -5, -2, 4, 0, 3};
		PriorityQueue<Pair> maxHeap = new PriorityQueue<JumpGame_IV.Pair>((a, b) -> b.value - a.value);
		int len = arr.length;
		int k = 3;
		maxHeap.add(new Pair(0, arr[0]));
		
		for(int i=1; i<len; i++) {
			Pair pair = maxHeap.peek();
			
			while(!maxHeap.isEmpty() && pair.key < i-k) {
				maxHeap.poll();
				pair = maxHeap.peek();
			}
			
			Pair p = new Pair(i, arr[i] + pair.value);
			if(i == len-1) {
				System.out.println(p.value);
				return;
			}
			
			maxHeap.add(p);
		}
		
		System.out.println(arr[0]);
	}
}
