/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Rotate_Array_By_K {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4 ,5 ,6 ,7 ,8};
		int n = arr.length;
		int k = 2;
		rotateArray(arr, n - 1, k);
		
		for(int x : arr)
			System.out.print(x+" ");
	}

	/**
	 * @param arr
	 * @param n
	 * @param k
	 */
	private static void rotateArray(int[] arr, int n, int k) {
		if(k == 0) return;
		
		reverse(arr, 0, k - 1);
		reverse(arr, k, n);
		reverse(arr, 0, n);
	}

	/**
	 * @param arr
	 * @param i
	 * @param k
	 */
	private static void reverse(int[] arr, int low, int high) {
		int temp = 0;
		while(low <= high) {
			temp = arr[high];
			arr[high] = arr[low];
			arr[low] = temp;
			low++;
			high--;
		}
	}
}
