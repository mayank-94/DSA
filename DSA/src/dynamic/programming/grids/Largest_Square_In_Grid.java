/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class Largest_Square_In_Grid {

	public static void main(String[] args) {
		int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		System.out.println(largestSquare(M));
	}

	/**
	 * @param m
	 * @return
	 */
	private static int largestSquare(int[][] M) {
		int m = M.length;
		int n = M[0].length;
		int s[][] = new int[m][n];
		
		for(int i=0; i<m; i++)
			s[i][0] = M[i][0];
		
		for(int i=0; i<n; i++)
			s[0][i] = M[0][i];
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(M[i][j] == 1)
					s[i][j] = Math.min(s[i-1][j-1], Math.min(s[i-1][j], s[i][j-1])) + 1;
				else
					s[i][j] = 0;
 			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, s[i][j]);
			}
		}
		return max;
	}
}
