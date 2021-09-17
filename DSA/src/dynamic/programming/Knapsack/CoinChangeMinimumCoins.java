package dynamic.programming.Knapsack;

public class CoinChangeMinimumCoins {

	public static void main(String[] args) {
		
		int coins[] = new int[]{25, 10, 5};
		int sum = 30;
		int n = coins.length;
		int t[][] = new int[n+1][sum+1];
		int i = 0, j = 0;
		for(i=0; i<n+1; i++) {
			for(j=0; j<sum+1; j++) {
				if(i == 0)
					t[i][j] = Integer.MAX_VALUE - 1;
				if(j == 0)
					t[i][j] = 0;
			}
		}
		
		for(i=1, j=1; j<sum+1; j++) {
			if(j % coins[0] == 0)
				t[i][j] = j / coins[0];
			else
				t[i][j] = Integer.MAX_VALUE - 1;
		}
		
		for(i=2; i<n+1; i++) {
			for(j=1; j<sum+1; j++) {
				if(coins[i-1] <= j)
					t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		System.out.println(t[n][sum]);
	}
}