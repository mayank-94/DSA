/**
 * 
 */
package data.structures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Minimum_Swaps_Sort {

	public static void main(String[] args) {
		int nums[] = {2, 8, 5, 4};
		int n = nums.length;
		
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i=0; i<n; i++) {
			hm.put(nums[i], i);
		}
		
		Arrays.sort(nums);
		int res = 0;
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) {
			if(visited[i] || hm.get(nums[i]) == i) continue;
			
			int j=i, cycles=0;
			while(!visited[j]) {
				visited[j] = true;
				
				j = hm.get(nums[j]);
				cycles++;
			}
			
			if(cycles > 0)
				res += cycles - 1;
		}
		
		System.out.println(res);
	}
}
