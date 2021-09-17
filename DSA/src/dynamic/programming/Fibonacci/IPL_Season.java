/**
 * 
 */
package dynamic.programming.Fibonacci;

/**
 * @author mayankjain
 *
 */
public class IPL_Season {
	public static void main(String[] args) {
		int arr[] = {10, 3, 5, 7, 3};
		int n = arr.length;
		int[] t = new int[n];
	    t[0] = arr[0];
	    t[1] = arr[0] + arr[1];
	    t[2] = Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
	    for(int i=3; i<n; i++) {
	    	t[i] = Math.max(t[i-1], Math.max(t[i-2] + arr[i], t[i-3] + arr[i] + arr[i-1]));
	    }
	    System.out.println(t[n-1]);
	}
}
