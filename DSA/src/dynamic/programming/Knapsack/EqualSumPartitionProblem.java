package dynamic.programming.Knapsack;

/*
 * Given an array, determine whether it can be partitioned into two equal sum subsets
 * 
 */
public class EqualSumPartitionProblem {
	public static void main(String[] args) {
		int arr[] = {1, 5, 11, 7};	
		int sum = 0;
		for (int x : arr) 
			sum += x;
		
		if(sum % 2 != 0) {
			System.out.println("Equal sum partition does not exist");
			return;
		}
		sum = sum/2;
		
		int n = arr.length;
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
		
		System.out.println(t[n][sum]);
	}
}
