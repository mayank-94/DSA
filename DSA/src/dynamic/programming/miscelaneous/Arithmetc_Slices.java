/**
 * 
 */
package dynamic.programming.miscelaneous;


/**
 * @author mayankjain
 *
 */
public class Arithmetc_Slices {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6,7,8};
		int n = nums.length;
		int count = 0, sum = 0;
		for(int i=2; i<n; i++) {
			if(nums[i-2] - nums[i-1] == nums[i-1] - nums[i]) {
				count++;
				sum += count;
			}
			else {
				count = 0;
			}
		}
		System.out.println(sum);
		
	}
}
