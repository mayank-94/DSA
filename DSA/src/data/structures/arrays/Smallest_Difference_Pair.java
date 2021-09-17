/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Smallest_Difference_Pair {
	static int res[] = {-1, -1};
	
	public static void main(String[] args) {
        int A[] = {1, 2, 11, 5};     
        int B[] = {4, 12, 19, 23, 127, 235};
        
        int m = A.length;
        int n = B.length;
     
        System.out.println(findSmallestDifference(A, B, m, n));
        System.out.println(res[0]+" "+res[1]);
	}

	/**
	 * @param a
	 * @param b
	 * @param m
	 * @param n
	 * @return
	 */
	private static int findSmallestDifference(int[] a, int[] b, int m, int n) { 
		int i=0, j=0;
		int min = Integer.MAX_VALUE;
		
		while(i<m && j<n) {
			if(min > Math.abs(a[i] - b[j])) {
				min = Math.abs(a[i] - b[j]);
				res[0] = a[i];
				res[1] = b[j];
			}
			
			if(a[i] < b[j])
				i++;
			else j++;
		}
		return min;
	}
}
