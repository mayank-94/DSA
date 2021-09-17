/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class LongestPath_In_Matrix {
	static int m, n;
	
	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 9 },
                { 5, 3, 8 },
                { 4, 6, 7 } };
		
		m = mat.length;
		n = mat[0].length;
		int t[][] = new int[m][n];
		int max = -1;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(t[i][j] == 0)
					t[i][j] = findPath(i, j, t, mat);
				
				max = Math.max(max, t[i][j]);
			}
		}
		
		System.out.println(max);
	}

	/**
	 * @param i
	 * @param j
	 * @param t
	 * @param mat
	 * @return
	 */
	private static int findPath(int i, int j, int[][] t, int[][] mat) {
		if(i < 0 || i >= m || j < 0 || j >= n) return 0;
		
		if(t[i][j] != 0) return t[i][j];
		
		int x = 0, y = 0, z = 0, w = 0;
		
		if(i > 0 && (mat[i][j] + 1 == mat[i-1][j]))
			x = 1 + findPath(i -1 , j, t, mat);
		
		if(i < n - 1 && (mat[i][j] + 1 == mat[i+1][j]))
			y = 1 + findPath(i + 1, j, t, mat);
		
		if(j > 0 && (mat[i][j] + 1 == mat[i][j-1]))
			z = 1 + findPath(i, j - 1, t, mat);
		
		if(j < m - 1 && (mat[i][j] + 1 == mat[i][j+1]))
			w = 1 + findPath(i, j + 1, t, mat);
		
		return t[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
	}
}
