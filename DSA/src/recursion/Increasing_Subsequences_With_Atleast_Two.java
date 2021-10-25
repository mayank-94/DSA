/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mayankjain
 *
 */
public class Increasing_Subsequences_With_Atleast_Two {

	public static void main(String[] args) {
		int arr[] = {2, 3, 7};
		List<Integer> result = new ArrayList<Integer>();
		Set<List<Integer>> answer = new HashSet<List<Integer>>();
		
		subsequences(arr, 0, result, answer);
		System.out.println(answer);
	}

	/**
	 * @param arr
	 * @param start
	 * @param result
	 * @param answer
	 */
	private static void subsequences(int[] arr, int start, List<Integer> result, Set<List<Integer>> answer) {
		if(result.size() >= 2) {
			answer.add(new ArrayList<Integer>(result));
		}
		
		for(int i=start; i<arr.length; i++) {
			if(result.size() == 0 
					|| result.get(result.size() - 1) <= arr[i]) {
				result.add(arr[i]);
				subsequences(arr, i + 1, result, answer);
				result.remove(result.size() - 1);
			}
		}
	}
}
