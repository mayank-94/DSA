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
public class Count_Anagrams {
	
	//T -> O(n)
	//S -> O(n)
	public static void main(String[] args) {
		String pat = "for", txt = "forxxorfxdofr";
		int len = pat.length();
		int count = 0;
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		Map<Character, Integer> pMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<len; i++)
			pMap.put(pat.charAt(i), pMap.getOrDefault(pat.charAt(i), 0) + 1);
		
		for(int i=0; i<len; i++)
			tMap.put(txt.charAt(i), tMap.getOrDefault(txt.charAt(i), 0) + 1);
		
		if(tMap.equals(pMap)) count++;
		for(int i=len; i<txt.length(); i++) {
			tMap.put(txt.charAt(i), tMap.getOrDefault(txt.charAt(i), 0) + 1);
			
			if(tMap.get(txt.charAt(i-len)) == 1)
				tMap.remove(txt.charAt(i-len));
			else
				tMap.put(txt.charAt(i-len), tMap.get(txt.charAt(i-len)) - 1);
			
			if(tMap.equals(pMap)) count++;
		}
		
		System.out.println(count);
	}
}
