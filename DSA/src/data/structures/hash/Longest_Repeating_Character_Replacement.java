/**
 * 
 */
package data.structures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Longest_Repeating_Character_Replacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1, mostFreq = 0, windowSize = 0, start = 0;
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
			
			mostFreq = Math.max(mostFreq, freqMap.get(c));
			
			if(windowSize + 1 > mostFreq + k) {
				freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) - 1);
				start++;
			}else windowSize++;
		}
		
		System.out.println(windowSize);
	}
}
