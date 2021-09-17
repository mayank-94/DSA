/**
 * 
 */
package dynamic.programming.StockBuySell;

/**
 * @author mayankjain
 *
 */
public class StockBuySell_IV {

	public static void main(String[] args) {
		int []prices = {9, 6, 7, 6, 3, 8};
		int n = prices.length;
		int k = 3;
		
		int dp[][] = new int[k+1][n];
		for(int t=1; t<k+1; t++) {
			for(int d=1; d<n; d++) {
				int max = dp[t][d-1];
				
				for(int pd=0; pd<d; pd++) {
					int profitPastDay = dp[t-1][pd];
					int profitTthTransaction = prices[d] - prices[pd];
					
					if(profitPastDay + profitTthTransaction > max)
						max = profitPastDay + profitTthTransaction;
				}
				
				dp[t][d] = max;
			}
		}
		
		System.out.println(dp[k][n-1]);
	}
}
