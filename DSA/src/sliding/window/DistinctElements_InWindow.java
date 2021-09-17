/**
 * 
 */
package sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class DistinctElements_InWindow {

	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
		int k = 3;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<k; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		
		System.out.print(hm.size()+" ");
		for(int i=k; i<arr.length; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
			
			if(hm.get(arr[i-k]) == 1)
				hm.remove(arr[i]);
			else
				hm.put(arr[i], hm.get(arr[i-k]) - 1);
			
			System.out.print(hm.size()+" ");
		}
	}
}
