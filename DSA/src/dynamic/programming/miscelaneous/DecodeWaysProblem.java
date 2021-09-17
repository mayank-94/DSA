/**
 * 
 */
package dynamic.programming.miscelaneous;

public class DecodeWaysProblem {

	public static void main(String[] args) {
		String s = "110";
		int n = s.length();
		int waysRecursive = recursiveWays(s, n);
		System.out.println(waysRecursive);
		
		int waysDP = DPWays(s, n);
		System.out.println(waysDP);
	}

	private static int DPWays(String s, int n) {
		int t[] = new int[n+1];
		t[0] = 1;
		t[1] = 1;
		
		if(s.charAt(0) == '0')
			return 0;
		
		for(int i=2; i<n+1; i++) {
			if(s.charAt(i-1) > '0')
				t[i] = t[i-1];
			
			if(s.charAt(i-2) == '1' || 
					(s.charAt(i-2) == '2' && s.charAt(i-1) < '7'))
				t[i] += t[i-2];
		}
		return t[n];
	}

	private static int recursiveWays(String s, int n) {
		if(s.charAt(0) == '0')
			return 0;
		
		if(n == 0 || n == 1)
			return 1;
		
		int count = 0;
		if(s.charAt(n-1) > '0')
			count = recursiveWays(s, n - 1);
		
		if(s.charAt(n - 2) == '1' || 
				(s.charAt(n - 2) == '2') && s.charAt(n-1) < '7')
			count += recursiveWays(s, n - 2);
				
		return count;
	}
}
