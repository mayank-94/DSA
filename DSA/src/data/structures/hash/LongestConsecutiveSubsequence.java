/**
 * 
 */
package data.structures.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayankjain
 *
 */
public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		int nums[] = {100, 200, 2, 3, 1, 4};
		Set<Integer> set = new HashSet<Integer>();
		for(int x : nums) set.add(x);
		int len = 0;
		for(int i=0; i<nums.length; i++) {
			if(!set.contains(nums[i] - 1)) {
				int j = nums[i];
				
				while(set.contains(j))
					j++;
				
				len = Math.max(len, j - nums[i]);
			}
		}
		
		System.out.println(len);
	}
}
