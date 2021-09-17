package dynamic.programming.mcm;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = {40, 20, 30, 10, 30};
		int n = arr.length;
		int i=1, j=n-1;
		int dp[][] = new int[n+1][n+1];
		int min = solve(arr, i, j, dp);
		System.out.println(min);
	}
	
	//memoization
	private static int solve(int[] arr, int i, int j, int[][] dp) {
		if(i >= j)
			return 0;
		
		if(dp[i][j] != 0)
			return dp[i][j];
		
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp = solve(arr, i, k, dp) + solve(arr, k+1, j, dp)
							+ (arr[i-1] * arr[k] * arr[j]);
			
			min = Math.min(min, temp);
		}
		return dp[i][j] = min;
	}

	//recursive
	public static int solve(int[] arr, int i, int j) {
		if(i >= j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int ways = solve(arr, i, k) + solve(arr, k+1, j) +
					(arr[i-1] * arr[k] * arr[j]);
			min = Math.min(min, ways);
		}
		return min;
	}
}
