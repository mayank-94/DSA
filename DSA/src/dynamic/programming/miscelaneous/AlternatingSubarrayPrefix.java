/**
 * 
 */
package dynamic.programming.miscelaneous;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class AlternatingSubarrayPrefix {

	public static void main(String[] args) {
		int arr[] = {-5, -3, 2, -2, -3, 1};
		int n = arr.length;
		int len[] = new int[n];
		Arrays.fill(len, 1);
		
		//T- O(n^2)
		for(int i=0; i<n; i++) {
			for(int j=i; j<n-1; j++) {
				if(arr[j] * arr[j+1] < 0) {
					len[i]++;
				}else {
					break;
				}
			}
		}
		Arrays.stream(len).forEach(x -> System.out.print(x+" "));
		System.out.println();
		Arrays.fill(len, 1);
		
		//T- O(n)
		dp(arr, n, len);
		Arrays.stream(len).forEach(x -> System.out.print(x+" "));
	}

	private static void dp(int[] arr, int n, int[] len) {
		len[n-1] = 1;
		for(int i=n-2; i>=0; i--) {
			if(arr[i] * arr[i+1] < 0)
				len[i] = 1 + len[i+1];
			else
				len[i] = 1;
		}
	}

	@SuppressWarnings("unused")
	private static void recursive(int[] arr, int n, int [] len) {
		if(n == 1) {
			return;
		}
		
		if((arr[n-1] > 0 && arr[n-2] < 0) || (arr[n-1] < 0 && arr[n-2] > 0)) {
			len[n-2] = len[n-1] + 1;
			recursive(arr, n-1, len);
		}else {
			recursive(arr, n-1, len);
		}
	}
}
