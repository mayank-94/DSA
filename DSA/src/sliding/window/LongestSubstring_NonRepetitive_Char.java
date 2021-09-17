/**
 * 
 */
package sliding.window;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayankjain
 *
 */
public class LongestSubstring_NonRepetitive_Char {

	public static void main(String[] args) {
		String str = "abbb";
		char[] arr = str.toCharArray();
		Set<Character> set = new HashSet<>();
		int i=0, j=0;
		int n = arr.length, max = Integer.MIN_VALUE;
		
		while(j<n) {
			if(!set.contains(arr[j])) {
				set.add(arr[j]);
				max = Math.max(max, set.size());
				j++;
			}else {
				set.remove(arr[i]);
				i++;
			}
		}
		
		System.out.println(max);
	}
}
