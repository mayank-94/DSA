/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Permutations_String {

	public static void main(String[] args) {
		String s = "ABC";
		int n = s.length();
		findPermutations(s, 0 ,n - 1);
	}

	/**
	 * @param s
	 * @param i
	 */
	private static void findPermutations(String s, int l, int r) {
		if(l == r) {
			System.out.print(s+" ");
		}
		else {
			for(int i=l; i<=r; i++) {
				s = swap(s, l, i);
				findPermutations(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	/**
	 * @param s
	 * @param l
	 * @param i
	 * @return
	 */
	private static String swap(String s, int l, int r) {
		char temp;
		char[] arr = s.toCharArray();
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		return String.valueOf(arr);
	}
}
