/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Pattern_Searching {

	public static void main(String[] args) {
		String text = "THIS IS A TEST TEXT";
		String pattern = "TEXT";
		int n = text.length();
		int m = pattern.length();
		
		for(int i=0; i<=n-m; i++) {
			int j;
			for(j=0; j<m; j++) {
				if(text.charAt(i+j) != pattern.charAt(j)) break;				
			}
			
			if(j == m) System.out.println("Found match at index "+i);
		}
	}
}
