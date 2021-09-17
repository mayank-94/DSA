package dynamic.programming.Knapsack;

/*
 *  O-1 Kanpsack : We are given certain weights with their respective values. We are given 
 *  a knapsack with the maximum capacity. We have to maximize the profit considering we can't 
 *  exceed the maximum weight given. 
 *  
 *  With o-1 knapsack, we can either choose an item or can't.
 */
public class Kanpsack_0_1 {
	public static void main(String[] args) {
		
		int wt[] = {1, 3, 4, 5};
		int val[] = {1, 4, 5, 7};
		int x = wt.length; //lengths of wt and val will be same
		int W = 7;
		int maxProfitRecursive = recursive(wt, val, W, x);	// TC - O(2^n)
		System.out.println(maxProfitRecursive);
		
		int maxProfit_DP = knapsack_Dp(wt, val, x, W); // TC - O(n^2)
		System.out.println(maxProfit_DP);
	}

	private static int knapsack_Dp(int[] wt, int[] val, int x, int w) {
		int t[][] = new int[x+1][w+1]; //rows represent x(number of items), columns represent w(weight)
		
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<w+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(wt[i-1] <= j)
					t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[x][w];
	}

	private static int recursive(int[] wt, int[] val, int W, int x) {
		if(x == 0 || W == 0)
			return 0;
		
		if(wt[x-1] <= W)
			return Math.max(val[x-1] + recursive(wt, val, W - wt[x-1], x - 1),
					recursive(wt, val, W, x-1));
		
		else
			return recursive(wt, val, W, x-1);
			
	}
}
