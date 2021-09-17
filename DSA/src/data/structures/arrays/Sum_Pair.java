/**
 * 
 */
package data.structures.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayankjain02
 *
 */
public class Sum_Pair {

	public static void main(String[] args) {
		int arr[] = {1, 4, 45, 6, 10, 8};
		System.out.println(keypair(arr, arr.length, 16));
	}

	public static boolean keypair(int[] arr, int N, int X) {
		Set<Integer> hash = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (hash.contains(X - arr[i]))
				return true;

			else
				hash.add(arr[i]);
		}

		return false;
	}
}
