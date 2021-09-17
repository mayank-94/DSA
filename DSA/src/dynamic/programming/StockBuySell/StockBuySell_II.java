/**
 * 
 */
package dynamic.programming.StockBuySell;

/**
 * @author mayankjain
 *
 */
public class StockBuySell_II {

	public static void main(String[] args) {
		int arr[] = {7,1,5,4,6,8};
		int n = arr.length;
		int profit = 0;
		for(int i=0; i<n-1; i++) {
			if(arr[i+1] > arr[i]) {
				System.out.println("Buy = "+arr[i]);
				System.out.println("Sell = "+arr[i+1]);
				profit = profit + arr[i+1] - arr[i];
			}
		}
		System.out.println("Profit = "+profit);
	}
}
