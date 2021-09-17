/**
 * 
 */
package dynamic.programming.Kadane;

/**
 * @author mayankjain
 *
 */
public class Maximum_ProductSubarray {
	public static void main(String[] args) {
		int nums[] = {-3, -4, -2};
		int maxProd = nums[0], minProd = nums[0], ans = nums[0];
		
		for(int i=1; i<nums.length; i++){
			int choice1 = nums[i] * maxProd;
			int choice2 = nums[i] * minProd;
            maxProd = Math.max(nums[i], Math.max(choice1, choice2));
            minProd = Math.min(nums[i], Math.min(choice1, choice2));
            ans = Math.max(ans, maxProd);
        }
		
		System.out.println(ans);
	}
}
