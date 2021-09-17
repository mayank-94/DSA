/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class Maximum_Sum_InGrid {

	public static void main(String[] args) {
		int Mat[][] = {{348, 391},
		          {618, 193}};
		int m = Mat.length;
		int n = Mat[0].length;
		int t[][] = new int[m][n];
		
		for(int i=0; i<n; i++) {
			t[0][i] = Mat[0][i];
		}
		int max = t[0][0];
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j > 0 && j < n-1)
					t[i][j] = Mat[i][j] + Math.max(t[i-1][j], Math.max(t[i-1][j-1], t[i-1][j+1]));
				
				//j = n-1
				else if(j == n-1)
					t[i][j] = Mat[i][j] + Math.max(t[i-1][j], t[i-1][j-1]);
				
				//j = 0
				else if(j == 0)
					t[i][j] = Mat[i][j] + Math.max(t[i-1][j], t[i-1][j+1]);
				
				max = Math.max(max, t[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
