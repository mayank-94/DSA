/**
 * 
 */
package dynamic.programming.miscelaneous;

/**
 * @author mayankjain
 *
 */
public class Jump_Game {

	public static void main(String[] args) {
		int arr[] = {2, 3, 1, 1, 4};
		System.out.println(isPossible(arr));
	}

	/**
	 * @param arr
	 * @return
	 */
	private static boolean isPossible(int[] arr) {
		int n = arr.length;
		int []t = new int[n];
		t[0] = arr[0];
		for(int i=1; i<n-1; i++) {
			if(t[i-1] < i) return false;
			
			t[i] = Math.max(t[i-1], arr[i]+i);
			
			if(t[i] >= n-1) return true;
		}
		return t[n-2] >= n-1 ? true : false;
	}
}
