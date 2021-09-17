package dynamic.programming.LCS;

/*
 * String a = AABEBCDD
 * 
 * Longest repeating subsequence = ABD as this sequence is repeated twice
 */
public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String a = "aabebcd";
		String b = a;
		int x = a.length();

		int t[][] = new int[x+1][x+1];
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<x+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(a.charAt(i-1) == b.charAt(j-1) && i!=j)
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		System.out.println(t[x][x]);
	}
}
