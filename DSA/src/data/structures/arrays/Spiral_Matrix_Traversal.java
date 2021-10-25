/**
 * 
 */
package data.structures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Spiral_Matrix_Traversal {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int top = 0, bottom = mat.length - 1, left = 0, right = mat[0].length - 1;
		int dir = 0;
		List<Integer> result = new ArrayList<Integer>();

		while (top <= bottom && left <= right) {
			switch (dir) {
			case 0:
				for (int i = left; i <= right; i++)
					result.add(mat[top][i]);
				top++;
				break;
			case 1:
				for (int i = top; i <= bottom; i++)
					result.add(mat[i][right]);
				right--;
				break;
			case 2:
				for (int i = right; i >= left; i--)
					result.add(mat[bottom][i]);
				bottom--;
				break;
			case 3:
				for (int i = bottom; i >= top; i--)
					result.add(mat[i][left]);
				left++;
				break;
			}
			dir = (dir + 1) % 4;
		}
		
		System.out.println(result);
	}
}
