package dynamic.programming.LPS;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String a = "cebec";
		String b = new StringBuilder(a).reverse().toString();
		int len1 = LCS_Approach(a, b);
		System.out.println(len1);
		
		int len2 = palindrome_Approach_recursive(a, 0, a.length()-1);
		System.out.println("Recursive solution : "+len2);	
		
		int len3 = palindrome_Approach(a, a.length());
		System.out.println(len3);
	}
	
	private static int palindrome_Approach(String a, int n) {
		boolean t[][] = new boolean[n][n];
		int max = 1; //every char is a palindrome in itself;
		
		for(int i=0; i<n; i++)
			t[i][i] = true;
		
		for(int i=n-2; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(a.charAt(i) == a.charAt(j)) {
					if(t[i+1][j-1] || j-i == 1) {
						t[i][j] = true;
						max = Math.max(max, j-i+1);
					}
				}
			}
		}
		return max;
	}

	//If start and end matches, the substring between them should also be a palindrome
	private static int palindrome_Approach_recursive(String a, int start, int end) {
		if(start == end)
			return 1;
		
		if(a.charAt(start) == a.charAt(end)) {
			int lpsRemaining = end - start - 1;
			
			if(lpsRemaining == palindrome_Approach_recursive(a, start + 1, end - 1)) {
				return 2 + lpsRemaining;
			}
		}
		
		return Math.max(palindrome_Approach_recursive(a, start + 1, end), 
					palindrome_Approach_recursive(a, start, end - 1));
	}

	private static int LCS_Approach(String a, String b) {
		int x = a.length();
		int t[][] = new int[x+1][x+1];
		int max = -1;
		
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<x+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					max = Math.max(max, t[i][j]);
				}
				
				else
					t[i][j] = 0;
			}
		}
		return max;
	}
}
