/**
 * 
 */
package dynamic.programming.Fibonacci;

/**
 * @author mayankjain
 * 
 * The array represents time in minutes for each day, find minimum time taken by nikhil such
 * that he can't skip more than 3 days in a row.
 * 
 * eg - 3,2,3,2,3,5,1,3
 * => 2+2+1 = 5
 *
 */
public class Minimum_Minutes_InSchool {
	public static void main(String[] args) {		
		int arr[] = {3, 2, 3, 2, 3, 5, 1, 3};
		int n = arr.length;
	    
	    int[] t = new int[n];
	    t[0] = arr[0];
	    t[1] = arr[1];
	    t[2] = arr[2];
	    for(int i=3; i<n; i++)
	        t[i] = Math.min(Math.min(t[i-1], t[i-2]), t[i-3]) + arr[i];
	    
	    System.out.println(Math.min(Math.min(t[n-1], t[n-2]), t[n-3]));	    
	}
}
