/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Equilibrium_Point {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 5, 6, 2};
		int leftSum = 0;
		for(int x : arr)
			leftSum += x;
		
		int rightSum = 0;
		for(int x : arr) {
			leftSum -= x;
			if(leftSum == rightSum) break;
			rightSum += x;
		}
	}
}
