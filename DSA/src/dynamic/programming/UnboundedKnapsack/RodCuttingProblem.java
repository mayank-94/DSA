package dynamic.programming.UnboundedKnapsack;

/*
 * The aim is to maximize the profit.
 * 
 * It is basically unbounded knapsack, as we can cut rod in any length and as many times as we want
 */
public class RodCuttingProblem {
	public static void main(String[] args) {
		int len[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int length = 8; //this length will be the maximm element in len[]
		//Sometimes this length array will not be given, so it is self understood
		//that the price array will correspond to the length from 1->n
		
		int t[][] = new int[length+1][length+1];  //here size of array is same as length.
		for(int i=0; i<length+1; i++) {
			for(int j=0; j<length+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(len[i-1] <= j)
					t[i][j] = Math.max(price[i-1] + t[i][j-len[i-1]], t[i-1][j]);
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		System.out.println(t[length][length]);
	}
}
