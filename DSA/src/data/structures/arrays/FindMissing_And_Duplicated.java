/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class FindMissing_And_Duplicated {
	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 1, 5};
		int i = 0;
		while(i < arr.length) {
			if(arr[i] != arr[arr[i] - 1])
				swap(i, arr[i] - 1, arr);
			
			else i++;
		}
		
		for(int j=0; j<arr.length; j++) {
			if(arr[j] != j+1) {
				System.out.println("Duplicate number is "+arr[j]);
				System.out.println("Missing number is "+(j+1));
			}
		}
	}
	
	static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
