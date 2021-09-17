package dynamic.programming.LCS;

/*
 * We are given two strings, a & b. We need to find if
 * "a" is a subsequence of "b" ?
 * 
 * a = axy
 * b = abexzy;
 */
public class SequencepatternMatching {
	public static void main(String[] args) {
		String a = "axy", b = "adxcpy";
		int x = a.length(), y = b.length();
		
		int t[][] = new int[x+1][y+1];
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<y+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		if(x == t[x][y])
			System.out.println(true);
		else
			System.out.println(false);
	}
}
