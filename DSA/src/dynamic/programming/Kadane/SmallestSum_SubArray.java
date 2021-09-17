/**
 * 
 */
package dynamic.programming.Kadane;

/**
 * @author mayankjain
 *
 */
public class SmallestSum_SubArray {
	public static void main(String[] args) {
		int arr[] = {3, -4, 2, -3, -1, 7, -5};
		int currentSum = arr[0];
		int minSum = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(currentSum > 0)
				currentSum = arr[i];
			
			else
				currentSum += arr[i];
			
			minSum = Math.min(minSum, currentSum);
		}
		
		System.out.println(minSum);
	}
}
