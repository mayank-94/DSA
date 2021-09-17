/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class CountPaths_InMatrix {

	public static void main(String[] args) {
		int m = 3, n = 3;
		System.out.println(totalPaths(m, n));
		System.out.println(totalPathsDP(m, n));
	}

	/**
	 * @param m
	 * @param n
	 * @return
	 */
	private static int totalPathsDP(int m, int n) {
		int t[][] = new int[m][n];
		
		for(int i=0; i<m; i++)
			t[i][0] = 1;
		for(int i=0; i<n; i++)
			t[0][i] = 1;
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				t[i][j] = t[i-1][j] + t[i][j-1];
			}
		}
		return t[m-1][n-1];
	}

	/**
	 * @param m
	 * @param n
	 * @return
	 */
	// T - O(2^n)
	private static int totalPaths(int m, int n) {
		if(m == 1 || n == 1) return 1;
		
		return totalPaths(m - 1, n) + totalPaths(m, n - 1);
	}
}
