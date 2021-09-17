package dynamic.programming.Knapsack;

/*
 * Given an array, count all the subsets such that the sum of their differences is is equal to 
 * the given difference.
 * 
 * s1 + s2 = sum
 * s1 - s2 = diff
 * 
 * 2*s1 = sum + diff
 * s1 = (sum + diff)/2
 * 
 * So the problem is reduced to Count_SubsetSumProblem
 */
public class Count_SubsetWith_Difference {
	public static void main(String[] args) {
		int arr[] = {1, 1, 2, 3};
		int n = arr.length;
		int diff = 1;
		
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		
		int s = (sum + diff) / 2;
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
