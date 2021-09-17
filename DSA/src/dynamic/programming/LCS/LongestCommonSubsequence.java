package dynamic.programming.LCS;

/*
 * String a = "adghp", b = "aghmns"
 * Longest Common Subsequence = agh 
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String a = "ABEDH", b = "ABCD";
		int lengthByRecursive = recursive(a, b, a.length(), b.length());
		System.out.println(lengthByRecursive);
		
		int lengthTopDown = topDown(a, b, a.length(), b.length());
		System.out.println(lengthTopDown);
	}

	private static int topDown(String a, String b, int x, int y) {
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
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		return t[x][y];
	}

	private static int recursive(String a, String b, int x, int y) {
		if(x == 0 || y == 0)
			return 0;
		
		if(a.charAt(x-1) == b.charAt(y-1))
			return 1 + recursive(a, b, x - 1, y - 1);
		
		else
			return Math.max(recursive(a, b, x-1, y), 
					recursive(a, b, x, y-1));
	}
}
