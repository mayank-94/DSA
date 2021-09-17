/**
 * 
 */
package binary.search;

/**
 * @author mayankjain
 *
 */
public class Find_Element_With_One_Occurrence {

	public static void main(String[] args) {
	    char[] arr = {'u', 'u', 'a', 'a', 'b', 'b', 'd', 'd', 'f', 'h', 'h'};
	    int n = arr.length;
	    
	    System.out.println(findElement(arr, 0, n-1));
	}

	private static char findElement(char[] arr, int low, int high) {
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if(low == high) return arr[low];
			
			if(mid % 2 == 0) {
				if(arr[mid] == arr[mid+1]) {
					low = mid+2;
				}else {
					high = mid;
				}
			}else {
				if(arr[mid] == arr[mid-1])
					low = mid + 1;
				else
					high = mid;
			}
		}
		
		return '0';
	}
}
