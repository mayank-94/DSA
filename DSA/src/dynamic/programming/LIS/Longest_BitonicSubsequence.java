/**
 * 
 */
package dynamic.programming.LIS;

/**
 * @author mayankjain
 *
 */
public class Longest_BitonicSubsequence {
	public static void main(String[] args) {
		int nums[] = {100,92,89,77,74,66,64,66,64};  //[100,92,89,77,74,66,64,66,64]
		
		int n = nums.length;
        int[] lis = new int[n];
        lis[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && lis[j] > max)
                    max = lis[j];
            }
            lis[i] = 1 + max;
        }
        
        int[] lds = new int[n];
        lds[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            int max = 0;
            for(int j=n-1; j>i; j--){
                if(nums[i] > nums[j] && lds[j] > max)
                    max = lds[j];
            }
            lds[i] = 1 + max;
        }
        
        int max = lis[0] + lds[0] - 1;
        for(int i=1; i<n; i++){
            max = Math.max(max, lis[i] + lds[i] - 1);
        }
        
        System.out.println(max);
	}
}
