/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Combination_Sum {

	public static void main(String[] args) {
		int arr[] = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		combinations(0, target, arr, result, answer);
		System.out.println(answer);
	}

	/**
	 * @param start
	 * @param target
	 * @param arr
	 * @param result
	 * @param answer
	 */
	private static void combinations(int start, int target, int[] arr, List<Integer> result, List<List<Integer>> answer) {
		if(target < 0) return;
		
		if(target == 0) {
			answer.add(new ArrayList<Integer>(result));
		}
		
		for(int i=start; i<arr.length; i++) {
			if(arr[i] <= target) {
				result.add(arr[i]);
				combinations(i, target - arr[i], arr, result, answer);
				result.remove(result.size() - 1);
			}
		}
	}
}
