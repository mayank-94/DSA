/**
 * 
 */
package data.structures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Continuous_Subarray_Sum_K {

	public static void main(String[] args) {
		int arr[] = {23, 2, 6, 4, 7};
		int k = 6;
		System.out.println(isPossible(arr, k));
		System.out.println(isPossibleOptimized(arr, k));
	}

	/**
	 * @param arr
	 * @param k
	 * @return
	 */
	//T - O(n)
	private static boolean isPossibleOptimized(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		map.put(0, -1);
		for(int i=0; i<n; i++) {
			sum = (sum + arr[i]) % k;
			Integer prev = map.get(sum);
			if(prev != null) {
				if(i - prev > 1) return true;
			}else map.put(sum, i);
		}
		return false;
	}

	/**
	 * @param arr
	 * @param k
	 * @return
	 */
	//T - O(n^2)
	private static boolean isPossible(int[] arr, int k) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += arr[j];
				if(sum % k == 0) return true;
			}
		}
		return false;
	}
}
