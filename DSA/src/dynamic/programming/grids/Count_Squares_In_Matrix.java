/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class Count_Squares_In_Matrix {

	public static void main(String[] args) {
		int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int m = matrix.length;
		int n = matrix[0].length;
		int t[][] = new int[m][n];
		int count = 0;
		
		for(int i=0; i<m; i++) {
			t[i][0] = matrix[i][0];
			count += matrix[i][0];
		}
		
		for(int i=1; i<n; i++) {
			t[0][i] = matrix[0][i];
			count += matrix[0][i];
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == 1) {
					t[i][j] = 1 + Math.min(t[i-1][j-1], Math.min(t[i-1][j], t[i][j-1]));
					count+=t[i][j];
				}
			}
		}
		
		System.out.println(count);
	}
}
