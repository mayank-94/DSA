/**
 * 
 */
package dynamic.programming.Kadane;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class MaximumSumSubarray {

	public static void main(String[] args) {
		int [] arr = {-2, -3, 4, -1, -2, 5};
		int currentMax = arr[0], max = arr[0];
		
		// T->O(n), S->O(1)
		for(int i=1; i<arr.length; i++) {
			if(currentMax < 0)
				currentMax = arr[i];
			
			else
				currentMax += arr[i];
			
			max = Math.max(max, currentMax);
		}
		
		System.out.println(max);
		
		
		// T->O(n), S->O(n)
		int t[] = new int[arr.length];
		t[0] = arr[0];
		for(int i=1; i<arr.length; i++) {
			t[i] = Math.max(arr[i], t[i-1] + arr[i]);
		}
		System.out.println(Arrays.stream(t).max().getAsInt());
	}
}
