/**
 * 
 */
package dynamic.programming.miscelaneous;

/**
 * @author mayankjain
 *
 */
public class Longest_Turbulence_Subarray {

	public static void main(String[] args) {
		int[] arr = {9,4,2,10,7,8,8,1,9};
		int n = arr.length;
		int len = 0, max = 0;
		
		for(int i=0; i<n; i++) {
			if(i>=2 && ((arr[i-2] < arr[i-1] && arr[i-1] > arr[i]) 
					|| (arr[i-2] > arr[i-1] && arr[i-1] < arr[i]))) {
				len++;
			}else if(i>=1 && arr[i-1] != arr[i]) {
				len = 2;
			}else {
				len = 1;
			}
			
			max = Math.max(max, len);
		}
		
		System.out.println(max);
	}
}
