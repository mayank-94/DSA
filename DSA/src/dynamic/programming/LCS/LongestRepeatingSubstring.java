/**
 * 
 */
package dynamic.programming.LCS;

/**
 * @author mayankjain
 *
 */
public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		String a = "banana";
		String b = a;
		int n = a.length();
		int t[][] = new int[n+1][n+1];
		int start = 0, end = 0;
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i == 0 || j == 0) t[i][j] = 0;
				
				else if(a.charAt(i-1) == b.charAt(j-1) && i!=j) {
					t[i][j] = 1 + t[i-1][j-1];
					
					if(t[i][j] > start) {
						start = t[i][j];
						end = j;
					}
				}
				
				else t[i][j] = 0;
			}
		}
		
		System.out.println(a.substring(end-start, end));
	}
}
