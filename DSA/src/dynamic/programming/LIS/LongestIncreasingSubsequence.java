/**
 * 
 */
package dynamic.programming.LIS;

/**
 * @author mayankjain
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int nums[] = {0,1,0,3,5,2};
		int n = nums.length;
		int t[] = new int[n];
		int maximum = 0;
		t[0] = 1;
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j] && t[j] > max)
					max = t[j];
			}
			
			t[i] = 1+max;
			maximum = Math.max(maximum, t[i]);
		}
		System.out.println(maximum);
	}
}
