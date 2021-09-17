/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class Sort_0_1_2 {

	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 0, 1, 2};
		int l=0, m=0, h=arr.length-1;
		
		while(m <= h) {
			if(arr[m] == 0) {
				int temp = arr[m];
				arr[m] = arr[l];
				arr[l] = temp;
				l++;
				m++;
			}else if(arr[m] == 1) {
				m++;
			}else {
				int temp = arr[h];
				arr[h] = arr[m];
				arr[m] = temp;
				h--;
			}
		}
		
		for(int x : arr) System.out.print(x+" ");
	}
}
