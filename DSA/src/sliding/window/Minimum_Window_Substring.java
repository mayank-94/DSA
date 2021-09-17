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
public class Minimum_Window_Substring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		for(int i=0; i<t.length(); i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		int required = tMap.size();
		int left=0, right=0, expected=0;
		int arr[] = {-1, 0, 0};
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();
		
		while(right < s.length()) {
			char c = s.charAt(right);
			sMap.put(c, sMap.getOrDefault(c, 0) + 1);
			
			if(tMap.containsKey(c) && tMap.get(c).intValue() == sMap.get(c).intValue()) 
				expected++;
			
			while(left <= right && expected == required) {
				if(arr[0] == -1 || arr[0] > right - left + 1) {
					arr[0] = right - left + 1;
					arr[1] = left;
					arr[2] = right;
				}
				
				c = s.charAt(left);
				
				if(tMap.containsKey(c) && tMap.get(c).intValue() == sMap.get(c).intValue())
					expected--;
				
				sMap.put(c, sMap.get(c) - 1);
				left++;
			}
			right++;
		}
		
		String res = s.substring(arr[1], arr[2]+1);
		System.out.println(res);
	}
}
