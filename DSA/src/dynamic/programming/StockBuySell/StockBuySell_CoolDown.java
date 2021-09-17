/**
 * 
 */
package dynamic.programming.StockBuySell;

/**
 * @author mayankjain
 *
 */
public class StockBuySell_CoolDown {

	public static void main(String[] args) {
		int []arr = {1, 2, 3, 0, 2};
		int n = arr.length;
		
		int oldBoughtState = -arr[0];
		int oldSellState = 0;
		int oldCoolState = 0;
		
		for(int i=1; i<n; i++) {
			int newBoughtState = 0, newSellState = 0, newCoolState = 0;
			
			newBoughtState = Math.max(oldBoughtState, oldCoolState - arr[i]);		
			newSellState = Math.max(oldSellState, oldBoughtState + arr[i]);			
			newCoolState = Math.max(oldCoolState, oldSellState);
			
			oldBoughtState = newBoughtState;
			oldCoolState = newCoolState;
			oldSellState = newSellState;
		}
		
		System.out.println(oldSellState);
	}
}
