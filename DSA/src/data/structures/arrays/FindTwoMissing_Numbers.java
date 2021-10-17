/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class FindTwoMissing_Numbers {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 6};
		int n = arr.length + 2;
		
		boolean[] flag = new boolean[n+1];
		for(int i=0; i<n-2; i++)
			flag[arr[i]] = true;
		
		for(int i=1; i<n+1; i++)
			if(flag[i] == false) {
				System.out.print(i+" ");
			}
	}
}
