package dynamic.programming.LPS;

public class PrintLongestPalindromicSubstring {
	public static void main(String[] args) {
		String a = "ayaxzfbjbkrxiri";
		int n = a.length(), start = 0, end = 0;
		boolean t[][] = new boolean[n][n];
		
		for(int i=0; i<n; i++)
			t[i][i] = true;
		
		for(int i=n-2; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(a.charAt(i) == a.charAt(j)) {
					if(t[i+1][j-1] || j-i == 1) {
						t[i][j] = true;
					}
					
					if(t[i][j] && j-i >= end-start) {
						start = i;
						end = j;
					}
				}
			}
		}
		
		System.out.println(a.substring(start, end+1));
	}
}
