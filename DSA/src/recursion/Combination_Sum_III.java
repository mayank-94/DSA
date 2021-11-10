/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mayankjain
 *
 */
public class Combination_Sum_III {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(8, 1, 8, 6, 8);
		int sum = 12;
		Set<List<Integer>> answer = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		combinations(A, sum, 0, A.size() - 1, result, answer);
		System.out.println(answer);
	}

	/**
	 * @param A
	 * @param sum
	 * @param start
	 * @param end
	 * @param result
	 * @param answer
	 */
	private static void combinations(List<Integer> A, int sum, int start, int end, List<Integer> result,
			Set<List<Integer>> answer) {
		
		if(sum == 0) {
			answer.add(new ArrayList<Integer>(result));
			return;
		}
		
		for(int i=start; i<=end; i++) {
			if(A.get(i) <= sum && (result.size() == 0 || A.get(i) >= result.get(result.size() - 1))) {
				result.add(A.get(i));
				combinations(A, sum - A.get(i), start, end, result, answer);
				result.remove(result.size() - 1);
			}
		}
	}
}
