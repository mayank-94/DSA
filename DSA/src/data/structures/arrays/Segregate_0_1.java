/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Segregate_0_1 {

	public static void main(String[] args) {
		int arr[] = {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1};
		int i=0, j=arr.length-1;
		while(i<=j) {
			if(arr[i] == 0)
				i++;
			
			else if(arr[j] == 1)
				j--;
			
			else if(arr[i] == 1 && arr[j] == 0) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		for(int x : arr)
			System.out.print(x+" ");
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
