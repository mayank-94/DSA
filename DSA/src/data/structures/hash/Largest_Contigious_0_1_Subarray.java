/**
 * 
 */
package data.structures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Largest_Contigious_0_1_Subarray {

	public static void main(String[] args) {
		int arr[] = {0, 0, 1, 1, 0, 1, 1, 1, 0};
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i] == 0 ? -1 : arr[i];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0, sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(sum == 0) maxLen = i+1;
			Integer prev = map.get(sum);
			if(prev!=null) {
				maxLen = Math.max(maxLen, i-prev);
			}else {
				map.put(sum, i);
			}
		}
		
		System.out.println(maxLen);
	}
}
