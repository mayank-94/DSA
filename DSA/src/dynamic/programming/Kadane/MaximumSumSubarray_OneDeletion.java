/**
 * 
 */
package dynamic.programming.Kadane;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class MaximumSumSubarray_OneDeletion {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, -4, 5};
		int n = arr.length;
		
		int[] forward = new int[n];
		int totalMax = arr[0];
		forward[0] = arr[0];
		for(int i=1; i<n; i++) {
			forward[i] = Math.max(arr[i] + forward[i-1], arr[i]);
			totalMax = Math.max(totalMax, forward[i]);
		}
		Arrays.stream(forward).forEach(x -> System.out.print(x+" "));
		System.out.println();
		int[] backward = new int[n];
		backward[n-1] = arr[n-1];
		for(int i=n-2; i>=0; i--) {
			backward[i] = Math.max(arr[i] + backward[i+1], arr[i]);
		}
		Arrays.stream(backward).forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		int max = totalMax;
		for(int i=1; i<n-1; i++) {
			max = Math.max(forward[i-1] + backward[i+1], max);
		}
		System.out.println(max);
	}
}
