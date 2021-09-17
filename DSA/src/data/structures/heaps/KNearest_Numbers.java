/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
class Pair{
	int key;
	int value;
	
	public Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return key + " " + value;
	}
}

public class KNearest_Numbers {

	public static void main(String[] args) {
		int arr[] = {10, 2, 14, 7, 4, 6};
		int k = 3;
		int x = 5;
		
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((a, b) -> b.value - a.value);
		for(int i=0; i<k; i++) {
			maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
		}
		
		for(int i=k; i<arr.length; i++) {
			if(Math.abs(arr[i] - x) < maxHeap.peek().value) {
				maxHeap.poll();
				maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
			}
		}
		
		while(maxHeap.size() > 0)
			System.out.print(maxHeap.poll().key+" ");
	}	
}
