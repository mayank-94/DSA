package dynamic.programming.Knapsack;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array, divide it into two subsets such that we get the minimum sum difference
 * between the two subsets.
 * 
 * S1 - S2 = Minimum -> our aim
 * 
 * We know, S1 + S2 = Sum (array sum)
 * so S1 and S2 will range 0 -> Sum (as one partition can be empty set)
 * 
 * so, S2 = Sum - S1
 * 
 * S1 - Sum + S1 -> minimize
 * abs(2S1 - Sum) -> minimize
 */
public class MinimumSubsetSumDifference {
	public static void main(String[] args) {
		int arr[] = {1, 6, 11, 5};
		
		int n = arr.length;
		int sum = 0;
		for(int x : arr)
			sum += x;
		
		boolean t[][] = new boolean[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i == 0)
					t[i][j] = false;
				
				if(j == 0)
					t[i][j] = true;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<(sum+1)/2; i++) {
			if(t[n][i] == true)
				list.add(i);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<list.size(); i++) {
			min = Math.min(min, Math.abs(2*list.get(i) - sum));
		}
		
		System.out.println(min);		
	}
}
