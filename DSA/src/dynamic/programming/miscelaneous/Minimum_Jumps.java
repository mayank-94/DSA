/**
 * 
 */
package dynamic.programming.miscelaneous;

/**
 * @author mayankjain
 *
 */
public class Minimum_Jumps {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		if (arr[0] == 0)
			return;

		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(jump);
				return;
			}

			maxReach = Math.max(maxReach, i + arr[i]);
			step--;

			if (step == 0) {
				jump++;

				if (i >= maxReach)
					return;

				step = maxReach - i;
			}
		}
	}
}
