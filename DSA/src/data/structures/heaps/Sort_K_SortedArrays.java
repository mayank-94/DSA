/**
 * 
 */
package data.structures.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mayankjain02
 *
 */
class Node{
	int array, index, value;
	
	public Node(int array, int index, int value) {
		this.array = array;
		this.index = index;
		this.value = value;
	}

	@Override
	public String toString() {
		return array + " " + index + " " + value;
	}
}

public class Sort_K_SortedArrays {

	public static void main(String[] args) {
		int arr[][] = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a, b) -> a.value - b.value);
		
		for(int i=0; i<arr.length; i++) {
			minHeap.add(new Node(i, 0, arr[i][0]));
		}
		
		List<Integer> list = new ArrayList<Integer>();
		while(minHeap.size() > 0) {
			Node n = minHeap.poll();
			list.add(n.value);
			
			int nextIndex = n.index + 1;
			if(nextIndex < arr[n.array].length) {
				minHeap.add(new Node(n.array, nextIndex, arr[n.array][nextIndex]));
			}
		}
		
		System.out.println(list);
	}
}
