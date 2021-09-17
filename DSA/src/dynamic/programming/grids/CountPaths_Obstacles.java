/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class CountPaths_Obstacles {

	public static void main(String[] args) {
		int[][] A = { { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 } };
		
		System.out.println(countPaths(A, A.length - 1, A[0].length - 1));
		System.out.println(countPathsDP(A, A.length, A[0].length));
	}

	/**
	 * @param a
	 * @param m
	 * @param n
	 * @return
	 */
	private static int countPathsDP(int[][] a, int m, int n) {
		int t[][] = new int[m][n];
		
		if(a[0][0] == 0) t[0][0] = 1;
		
		for(int i=1; i<m; i++)
			if(a[i][0] == 0) t[i][0] = t[i-1][0];
		
		for(int i=1; i<n; i++)
			if(a[0][i] == 0) t[0][i] = t[0][i-1];
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(a[i][j] == 0)
					t[i][j] = t[i-1][j] + t[i][j-1];
			}
		}
		return t[m-1][n-1];
	}

	/**
	 * @param a
	 * @param m
	 * @param n
	 * @return
	 */
	private static int countPaths(int[][] a, int m, int n) {
		if((m == 0 || n == 0) && a[m][n] != 1) return 1;
		
		else if(a[m][n] == 1) return 0;
		
		else {
			return countPaths(a, m - 1, n) + countPaths(a, m, n - 1);
		}
	}
}
