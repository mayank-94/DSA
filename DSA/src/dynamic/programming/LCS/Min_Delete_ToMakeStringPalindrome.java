package dynamic.programming.LCS;

/*
 * String a = "agbcba"
 * 
 * Longest common palindrome = 5(abcba)
 * 
 */
public class Min_Delete_ToMakeStringPalindrome {
	public static void main(String[] args) {
		String a = "agbcdeba";
		String b = new StringBuilder(a).reverse().toString();
		
		int x = a.length();
		int t[][] = new int[x+1][x+1];
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<x+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<x+1; i++) {
			for(int j=1; j<x+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		System.out.println("Minimum deletions to make a string palindrome = "+(x - t[x][x]));
	}
}
