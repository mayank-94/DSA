/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Closest_Pair_SortedArray {

	public static void main(String[] args) {
		int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        printClosest(ar1, ar2, m, n, x);
	}

	private static void printClosest(int[] A, int[] B, int m, int n, int x) {
		int i=0, j=n-1, min=Integer.MAX_VALUE;
		int res[] = {-1, -1};
		
		while(i < m && j >= 0) {
			if(min > Math.abs(A[i] + B[j] - x)) {
				min = Math.abs(A[i] + B[j] - x);
				res[0] = A[i];
				res[1] = B[j];
			}
			
			if(A[i] + B[j] > x) j--;
			
			else i++;
		}
		
		System.out.println(min);
		System.out.println(res[0] +" "+ res[1]);
	}
}
