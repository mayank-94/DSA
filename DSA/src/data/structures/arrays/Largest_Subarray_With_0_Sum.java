/**
 * 
 */
package data.structures.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Largest_Subarray_With_0_Sum {

	public static void main(String[] args) {
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		int n = arr.length;
		
		// T - O(n^2), S - O(1)
		System.out.println(largestSubArray(arr, n));
		
		//T - O(n), S - O(n)
		System.out.println(maxLen(arr, n));
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxLen(int[] arr, int n) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int maxLen = 0, sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += arr[i];			
			if(sum == 0)
				maxLen = i+1;
			Integer prev = hm.get(sum);
			if(prev != null)
				maxLen = Math.max(maxLen, i - prev);
			else
				hm.put(sum, i);
		}
		return maxLen;
	}

	/**
	 * @param arr
	 * @param i
	 * @return
	 */
	private static int largestSubArray(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += arr[j];
				
				if(sum == 0) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return max;
	}
}
