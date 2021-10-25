/**
 * 
 */
package dynamic.programming.miscelaneous;

/**
 * @author mayankjain
 *
 */
public class Jump_Game_II {

	public static void main(String[] args) {
		int arr[] = {2, 3, 1, 1, 4};
		int n = arr.length;
		int t[] = new int[n];
		
		t[0] = 0;
		for(int i=1; i<n; i++) {
			t[i] = Integer.MAX_VALUE;
			for(int j=0; j<i; j++) {
				if(i <= j + arr[j] && t[j] != Integer.MAX_VALUE) {
					t[i] = Math.min(t[i], 1 + t[j]);
					break;
				}
			}
		}
		System.out.println(t[n-1]);
	}
}
