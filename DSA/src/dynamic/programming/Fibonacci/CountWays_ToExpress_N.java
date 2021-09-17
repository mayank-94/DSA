package dynamic.programming.Fibonacci;

/*
 * Given a number N, count all the ways to express it as a sum of
 * 1, 3 & 4
 * 
 * Eg - N = 4
 *  1+1+1+1, 1+3, 3+1, 4
 *  total ways = 4
 */
public class CountWays_ToExpress_N {

	public static void main(String[] args) {
		int N = 4;
		int ways = recursive(N);
		System.out.println(ways);
		
		int waysDp = dp(N);
		System.out.println(waysDp);
	}
	
	private static int dp(int n) {
		int t[] = new int[n+1];
		t[0] = t[1] = t[2] = 1;
		t[3] = 2;
		for(int i=4; i<n+1; i++)
			t[i] = t[i-1] + t[i-3] + t[i-4];
		
		return t[n];
	}

	//Time complexity - O(3^n)
	private static int recursive(int n) {
		if(n == 1 || n == 2 || n == 0)
			return 1;
		
		if(n == 3)
			return 2;
		
		return recursive(n - 1) + recursive(n - 3) + recursive(n - 4);
	}
}
