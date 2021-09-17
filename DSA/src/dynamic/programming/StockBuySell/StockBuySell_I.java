/**
 * 
 */
package dynamic.programming.StockBuySell;

/**
 * @author mayankjain
 *
 */
public class StockBuySell_I {
	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
		int profit = 0;
		
		// T-> O(n^2)
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				profit = Math.max(profit, arr[j] - arr[i]);
			}
		}
		System.out.println(profit);
		
		// T-> O(n)
		int max = 0, min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i] - min);
		}
		System.out.println(max);
	}
}
