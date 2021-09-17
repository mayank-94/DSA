package dynamic.programming.Knapsack;

/*
 * We are given an array, we have to assign a sign(+,-) before each element
 * such that the target sum will be  1.
 * 
 * arr = {1, 1, 2, 3} -> +1 -1 -2 + 3 = 4 - 3 = 1
 * 
 * We are supposed to return all the possible answers.
 * So the problem is reduced to Count_SubsetWith_Difference.
 */
public class TargetSum {
	public static void main(String[] args) {
		int arr[] = {1, 1, 2, 3};
		int targetSum = 1;
		int sum = 0;
		for(int x : arr)
			sum+= x;
		
		int n = arr.length;
		int s = (sum + targetSum) / 2;
		int t[][] = new int[n+1][s+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<s+1; j++) {
				if(i == 0)
					t[i][j] = 0;
				if(j == 0)
					t[i][j] = 1;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<s+1; j++) {
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		System.out.println(t[n][s]);
	}
}
