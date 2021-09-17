/**
 * 
 */
package dynamic.programming.miscelaneous;

public class MinimumPerfectSquaresProblem {
	
	public static void main(String[] args) {
		int n = 12;
		int minRecursive = recursive(n);
		System.out.println(minRecursive);
		
		int minDp = DP(n);
		System.out.println(minDp);
	}
	
	//TC - O(n) * sqrt(n)
	private static int DP(int n) {
		int t[] = new int[n+1];
		t[0] = 0;
		t[1] = 1;
		for(int i=2; i<n+1; i++) {
			t[i] = i;
			
			for(int j=1; j*j <= i; j++) {
				int sq = j*j;
				if(sq > i)
					break;
				else
					t[i] = Math.min(t[i], 1 + t[i-sq]);
			}
		}
		return t[n];
	}

	private static int recursive(int n) {
		if(n <= 3)
			return n;
		
		int min = n;
		for(int x=1; x<=n; x++) {
			int sq = x * x;
			if(sq > n)
				break;
			else
				min = Math.min(min, 1 + recursive(n - sq));
		}
		return min;
	}
}
