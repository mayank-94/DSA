/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class Min_Cost_Path {

	public static void main(String[] args) {
		int cost[][] = { {1, 2, 3},
                		{4, 8, 2},
                        {1, 5, 3} };
		int m = 2, n = 2;
		
		System.out.println(minCost(m, n, cost));
		System.out.println(minCostDp(m, n, cost));
	}

	/**
	 * @param m
	 * @param n
	 * @param cost
	 * @return
	 */
	// T - O(n^2), S - O(n^2)
	private static int minCostDp(int m, int n, int[][] cost) {
		int t[][] = new int[m+1][n+1];
		t[0][0] = cost[0][0];
		
		for(int i=1; i<m+1; i++) {
			t[i][0] = cost[i][0] + t[i-1][0];
		}
		
		for(int i=1; i<n+1; i++) {
			t[0][i] = cost[0][i] + t[0][i-1];
		}
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				t[i][j] = cost[i][j] + Math.min(Math.min(t[i-1][j], t[i][j-1]), t[i-1][j-1]);
			}
		}
		return t[m][n];
	}

	/**
	 * @param m
	 * @param n
	 * @param cost
	 * @return
	 */
	// T - O(3^n), S - O(1)
	private static int minCost(int m, int n, int[][] cost) {
		if(m < 0 || n < 0) return Integer.MAX_VALUE;
		
		if(m == 0 && n == 0) return cost[0][0];
		
		else return cost[m][n] + Math.min(Math.min(minCost(m - 1, n, cost), 
				minCost(m, n - 1, cost)), minCost(m - 1, n - 1, cost));
	}
}
