/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Leader_In_Array {

	public static void main(String[] args) {
		int arr[] = {3, 9, 5, 4, 7, 4, 2};
		int leader = arr[arr.length-1];
		System.out.print(leader+" ");
		for(int i = arr.length - 2; i>=0; i--) {
			if(arr[i] > leader) {
				leader = arr[i];
				System.out.print(leader+" ");
			}
		}
	}
}
