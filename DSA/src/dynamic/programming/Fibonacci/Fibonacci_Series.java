package dynamic.programming.Fibonacci;

/*
 * Fibonacci series = 0, 1, 1, 2, 3, 5, 8, 13....
 * 
 * We realize that fibonacci is an overlapping problem, so we can use DP
 */
public class Fibonacci_Series {

	public static void main(String[] args) {
		int n = 0;
		int fib = fibonacciRecursive(n);
		System.out.println(fib);
		
		int fibDP = fibonacciDP(n);
		System.out.println(fibDP);
	}
	
	/*
	 * Time complexity - O(n)
	 */
	private static int fibonacciDP(int n) {
		int t[] = new int[n+1];
		t[0] = 0;
		t[1] = 1;
		for(int i=2; i<n+1; i++)
			t[i] = t[i-1] + t[i-2];
		
		return t[n];
	}

	/*
	 * Time complexity - 2^n
	 */
	private static int fibonacciRecursive(int n) {
		if(n < 2)
			return n;
		
		return fibonacciRecursive(n - 1) + 
				fibonacciRecursive(n - 2);
	}
}
