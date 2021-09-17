package dynamic.programming.UnboundedKnapsack;

/*
 * Multiple occurrences of same item is allowed.
 * 
 */
public class Unbounded_Knapsack {
	public static void main(String[] args) {
		int wt[] = {1, 3, 4, 2};
		int val[] = {1, 4, 5, 7};
		int n = wt.length; //lengths of wt and val will be same
		int W = 7;
		
		int t[][] = new int[n+1][W+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(wt[i-1] <= j)
					t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		System.out.println(t[n][W]);
	}
}	
