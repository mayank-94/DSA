/**
 * 
 */
package binary.search;

/**
 * @author mayankjain
 *
 */
public class Peak_Element {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int n = 3;
		System.out.println(findPeak(arr, n));
	}

	private static int findPeak(int[] arr, int n) {
		int l = 0, h = n-1;
	       while(l <= h){
	           int m = l + (h - l)/2;
	           
	           if(m>0 && m<n-1){
	               if(arr[m] > arr[m+1] && arr[m] > arr[m-1])
	                    return arr[m];
	                    
	               else if(arr[m-1] > arr[m])  h = m - 1;
	               
	               else if(arr[m+1] > arr[m]) l = m + 1;
	           }
	           
	           if(m == 0){
	               if(arr[0] > arr[1]) return arr[0];
	               
	               else return arr[1];
	           }
	           
	           if(m == n-1){
	               if(arr[n-1] > arr[n-2]) return arr[n-1];
	               
	               else return arr[n-2];
	           }
	       }
	       
	       return -1;
	}
}
