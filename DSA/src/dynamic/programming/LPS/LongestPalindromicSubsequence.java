package dynamic.programming.LPS;

/*
 * String a = "agbcba"
 * Palindromes = abcba, bcb, b, a, etc
 * Longest palindromic subsequence = 5(abcba)
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		
		String a = "agbcba";
		String b = new StringBuilder(a).reverse().toString();
		int len1 = LCS_Approach(a, b, a.length());	
		System.out.println(len1);
		
		int len2 = Palindrome_Approach_Recursive(a, 0, a.length() - 1);
		System.out.println("Recursive approach : "+len2);
		
		//We will use the given string and traverse it from both sides simultaneously
		int len3 = Palindrome_Approach(a, a.length());
		System.out.println(len3);
	}
	
	//This is bottom up approach
	private static int Palindrome_Approach(String a, int n) {
		int t[][] = new int[n][n];
		
		//diagonals are palindrome in itself
		for(int i=0; i<n; i++) {
			t[i][i] = 1;
		}
		
		//As a.charAt(n-1) will be the last character, and it is already filled 1 in t.
		for(int i=n-2; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(a.charAt(i) == a.charAt(j))
					t[i][j] = 2 + t[i+1][j-1];
				
				else
					t[i][j] = Math.max(t[i+1][j], t[i][j-1]);
			}
		}
		
		return t[0][n-1];
	}

	private static int Palindrome_Approach_Recursive(String a, int start, int end) {
		if(start == end)
			return 1;
		
		if(a.charAt(start) == a.charAt(end))
			return 2 + Palindrome_Approach_Recursive(a, start + 1, end - 1);
		
		else
			return Math.max(Palindrome_Approach_Recursive(a, start + 1, end), 
					Palindrome_Approach_Recursive(a, start, end - 1));
	}

	private static int LCS_Approach(String a, String b, int length) {
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
		return t[x][x];
	}
}
