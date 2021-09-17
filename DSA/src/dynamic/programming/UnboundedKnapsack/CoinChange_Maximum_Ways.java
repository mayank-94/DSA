package dynamic.programming.UnboundedKnapsack;

/*
 * Given certain denominations of coins and a Sum.
 * Form the sum and find out the maximum ways we can achieve the sum using
 * different denominations. Coins have infinate supply of each denomination
 */
public class CoinChange_Maximum_Ways {
	public static void main(String[] args) {
		int coin[] = {1, 2, 3};
		int sum = 5;
		
		int n = coin.length;
		int t[][] = new int[n+1][sum+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i == 0)
					t[i][j] = 0;
				if(j == 0)
					t[i][j] = 1;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(coin[i-1]<=j)
					t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		System.out.println("Maximum ways are : "+t[n][sum]);
	}
}
