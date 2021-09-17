/**
 * 
 */
package data.structures.arrays;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class Merge_Without_Space {
	
	public static void main(String[] args) {
		int A[] = new int[] { 1, 5, 9, 10, 15, 20 };
	    int B[] = new int[] { 2, 3, 8, 13 };
	    
	    int m = A.length, n = B.length;
	    
	    int i=0, j=0, k=m-1;
	    int temp = 0;
	    while(j < n && i <= k) {
	    	if(A[i] < B[i]) i++;
	    	
	    	else {
	    		temp = B[j];
	    		B[j] = A[k];
	    		A[k] = temp;
	    		k--;
	    		j++;
	    	}
	    }
	    Arrays.sort(A);
	    Arrays.sort(B);
	    
	    for(int x : A)
	    	System.out.print(x+" ");
	    for(int x : B)
	    	System.out.print(x+" ");
	}
}
