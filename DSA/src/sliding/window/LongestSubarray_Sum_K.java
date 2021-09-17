/**
 * 
 */
package sliding.window;

/**
 * @author mayankjain
 *
 */
public class LongestSubarray_Sum_K {

	public static void main(String[] args) {
		int arr[] = {10, 5, 2, 7, 1, 9};
		int k = 15;
		int i=0, j=0, max=0, sum=0;
		int n = arr.length;
		while(j < n) {
			sum += arr[j];
			
			if(sum < k) j++;
			
			else if(sum == k) {
				max = Math.max(max, j-i+1);
				j++;
			}
			
			else {
				while(sum > k) {
					sum -= arr[i];
					i++;
				}
				
				if(sum == k) {
					max = Math.max(max, j-i+1);
				}
				j++;
			}
		}
		
		System.out.println(max);
	}
}
