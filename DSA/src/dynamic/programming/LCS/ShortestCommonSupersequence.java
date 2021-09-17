package dynamic.programming.LCS;

/*
 * String a = "AGGTAB", b = "GXTXAYB"
 * There can be many super sequences like AGGTABGXTXAYB, AGGXTABXAYB, AGGXTXAYB
 * 
 * We need to merge both strings and maintain sequence
 */
public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String a = "AGGTAB", b = "GXTXAYB";
		int x = a.length();
		int y = b.length();
		
		int t[][] = new int[x+1][y+1];
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<y+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<x+1; i++) {
			for(int j=1; j<y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		}
		
		System.out.println("Shortest Common Supersequence is "+ (x + y - t[x][y]));
	}
}
