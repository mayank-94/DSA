/**
 * 
 */
package dynamic.programming.LCS;

/**
 * @author mayankjain
 *
 */
public class WildCardPatternMatching {

	public static void main(String[] args) {
		String str = "aa";
        String pattern = "a";
        int n = str.length();
        int m = pattern.length();
        boolean t[][] = new boolean[n+1][m+1];
        
        t[0][0] = true;
        for(int i=1; i<n+1; i++)
        	t[i][0] = false;
        
        for(int i=1; i<m+1; i++)
        	if(pattern.charAt(i-1) == '*') t[0][i] = t[0][i-1];
        
        for(int i=1; i<n+1; i++) {
        	for(int j=1; j<m+1; j++) {
        		if(pattern.charAt(j-1) == '*')
        			t[i][j] = t[i-1][j] || t[i][j-1];
        		
        		else if(pattern.charAt(j-1) == '?' || pattern.charAt(j-1) == str.charAt(i-1))
        			t[i][j] = t[i-1][j-1];
        		
        		else
        			t[i][j] = false;
        	}
        }
        
        System.out.println(t[n][m]);
	}
}
