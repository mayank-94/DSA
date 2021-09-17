package dynamic.programming.miscelaneous;

/*
 * Given two strings s1 and s2. Convert s1 into s2 with minimum operations
 * 	1)Insert
 *  2)Delete
 *  3)Replace
 */
public class Edit_Distance_Problem {

	public static void main(String[] args) {
		String s1 = "geek";
		String s2 = "gesek";
		int m = s1.length();
		int n = s2.length();
		
		int minOperationsRecursive = recursive(s1, s2, m, n);
		System.out.println(minOperationsRecursive);
		
		int minOperationsDP = DP_Approach(s1, s2);
		System.out.println(minOperationsDP);
	}

	private static int DP_Approach(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int t[][] = new int[m+1][n+1];
		
		for(int i=0; i<m+1; i++)
			t[i][0] = i;
		
		for(int i=0; i<n+1; i++)
			t[0][i] = i;
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					t[i][j] = t[i-1][j-1];
				
				else
					t[i][j] = 1 + min(t[i-1][i], t[i][j-1], t[i-1][j-1]);
			}
		}
		return t[m][n];
	}

	private static int recursive(String s1, String s2, int m, int n) {
		if(s1.equals(s2))
			return 0;
		if(m == 0)
			return n;
		if(n == 0)
			return m;
		
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return recursive(s1, s2, m-1, n-1);
		
		return 1 + min(recursive(s1, s2, m, n - 1), // insertion at s1 = deletion at s2
				recursive(s1, s2, m - 1, n) , // deletion from s1
				recursive(s1, s2, m - 1, n - 1)); //replace
	}

	private static int min(int min1, int min2, int min3) {
		if(min1 < min2 && min1 < min3)
			return min1;
		
		else if(min2 < min1 && min2 < min3)
			return min2;
		
		else return min3;
	}
}
