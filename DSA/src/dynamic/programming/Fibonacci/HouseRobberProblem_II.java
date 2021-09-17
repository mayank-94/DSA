/**
 * 
 */
package dynamic.programming.Fibonacci;

/**
 * Houses are arranged in circle this time
 * 
 * @author mayankjain
 *
 */
public class HouseRobberProblem_II {

	public static void main(String[] args) {
		int nums[] = {1, 2, 3, 1};
		int n = nums.length;
		int maxProfit = Math.max(dp(nums, 0, n-2), dp(nums, 1, n-1));
		System.out.println(maxProfit);
	}

	private static int dp(int[] nums, int low, int high) {
		int n = nums.length;
		int t[] = new int[n];
		t[low] = nums[low];
		t[low+1] = Math.max(nums[low], nums[low+1]);
		
		for(int i=low+2; i<high+1; i++) {
			t[i] = Math.max(nums[i] + t[i-2], t[i-1]);			
		}
		
		return t[high];
	}
}
