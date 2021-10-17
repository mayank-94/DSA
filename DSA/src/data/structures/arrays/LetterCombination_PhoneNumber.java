/**
 * 
 */
package data.structures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
public class LetterCombination_PhoneNumber {

	public static void main(String[] args) {
		int[] numbers = {2, 3};
		List<String> answer = new ArrayList<>();
		String[] result
         = { "0",   "1",   "abc",  "def", "ghi",
             "jkl", "mno", "pqrs", "tuv", "wxyz" };
     
		combinations(numbers, result, answer);
		System.out.println(answer);
	}

	/**
	 * @param numbers
	 * @param result
	 * @param answer
	 */
	private static void combinations(int[] numbers, String[] result, List<String> answer) {
		int n = numbers.length;
		Queue<String> queue = new LinkedList<>();
		queue.add("");

		while (!queue.isEmpty()) {
			String s = queue.poll();
			if (s.length() == n)
				answer.add(s);

			else {
				String value = result[numbers[s.length()]];
				for (int i = 0; i < value.length(); i++) {
					queue.add(s + value.charAt(i));
				}
			}
		}
	}
}
