package dynamic.programming.LCS;

/*
 * String a = "abedfgh", b = "aedfhk"
 * Longest Common Substring = edf
 */
public class LongestCommonSubstring {
	public static void main(String[] args) {
		String a = "abedfgh";
		String b = "aedfhk";
		int lengthByRecursive = recursive(a, b, a.length(), b.length(), 0); 
		System.out.println(lengthByRecursive);
		
		int lengthByTopDown = topDown(a, b, a.length(), b.length());
		System.out.println(lengthByTopDown);
	}

	private static int topDown(String a, String b, int x, int y) {
		int t[][] = new int[x+1][y+1];
		int max = 0;
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<y+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<x+1; i++) {
			for(int j=1; j<y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					max = Math.max(max, t[i][j]);
				}
				else
					t[i][j] = 0;
			}
		}
		return max;
	}

	private static int recursive(String a, String b, int x, int y, int count) {
		if(x == 0 || y == 0)
			return count;
		
		if(a.charAt(x-1) == b.charAt(y-1))
			count = recursive(a, b, x-1, y-1, count + 1);
		
		count = Math.max(count, Math.max(recursive(a, b, x-1, y, 0), recursive(a, b, x, y-1, 0)));
		return count;
	}
}
