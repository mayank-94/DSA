/**
 * 
 */
package dynamic.programming.StockBuySell;

/**
 * @author mayankjain
 *
 */
public class StockBuySell_III {

	public static void main(String[] args) {
		int arr[] = {7,1,5,4,6,8};
		int n = arr.length;
		
		int maxSellToday = 0;
		int minBuy = arr[0];
		int dpLeft[] = new int[n];
		for(int i=1; i<n; i++) {
			minBuy = Math.min(minBuy, arr[i]);
			maxSellToday = arr[i] - minBuy;
			dpLeft[i] = Math.max(dpLeft[i-1], maxSellToday);
		}
		
		int minBoughtToday = 0;
		int maxSell = arr[n-1];
		int dpRight[] = new int[n];
		for(int i=n-2; i>=0; i--) {
			maxSell = Math.max(maxSell, arr[i]);
			minBoughtToday = maxSell - arr[i];
			dpRight[i] = Math.max(dpRight[i+1], minBoughtToday);	
		}
		
		int profit = 0;
		for(int i=0; i<n; i++) {
			profit = Math.max(profit, dpLeft[i] + dpRight[i]);
		}
		
		System.out.println(profit);
	}
}
