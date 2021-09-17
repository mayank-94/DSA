/**
 * 
 */
package dynamic.programming.LIS;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class Max_Sum_Increasing_Subsequence {
	public static void main(String[] args) {
		int nums[] = {27, 39, 22, 35, 3, 38, 48, 4, 19};
		int n = nums.length;
		int t[] = new int[n];
		
		for(int i=0; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j]) {
					if(max == 0)
						max = t[j];
					else if(t[j] > max)
						max = t[j];
				}
			}
			
			if(max == 0)
				t[i] = nums[i];
			else
				t[i] = max + nums[i];
		}
		
		System.out.println(Arrays.stream(t).max().getAsInt());
	}
}
