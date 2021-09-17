/**
 * 
 */
package sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mayankjain
 *
 */
public class MaximumNumber_Window_OfSize_K {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 6, 3, 2, 1, 9};
		int k=3;
		int n = arr.length;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i=0; i<k; i++) {
			while(deque.size() > 0 && arr[i] > deque.getLast())
				deque.removeLast();
			
			deque.addLast(arr[i]);
		}
		System.out.print(deque.getFirst()+" ");
		
		for(int i=k; i<n; i++) {
			while(deque.size() > 0 && arr[i] > deque.getLast())
				deque.removeLast();
			
			deque.addLast(arr[i]);
			if(deque.getFirst() == arr[i-k])
				deque.removeFirst();
			
			System.out.print(deque.getFirst()+" ");
		}
	}
}
