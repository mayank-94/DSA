/**
 * 
 */
package dynamic.programming.miscelaneous;

/**
 * @author mayankjain
 *
 */
public class Count_Ways_ToPartition_Into_KSubsets {

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		int t[][] = new int[n+1][k+1];
		System.out.println(totalWays(n, k, t));
	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	// T - O(n*k)
	private static int totalWays(int n, int k, int t[][]) {
		if(n == 0 || k == 0 || k > n) return 0;
		
		if(n == k || k == 1) return 1;
		
		if(t[n][k] != 0) return t[n][k];
		
		return t[n][k] = k*totalWays(n - 1, k, t) + totalWays(n - 1, k - 1, t);
	}
}
