/**
 * 
 */
package data.structures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author mayankjain
 *
 */
public class First_NonRepetitive_Char {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(firstNonRep(str));
		System.out.println(str.charAt(firstNonRep_II(str)));
	}

	/**
	 * @param str
	 * @return
	 */
	private static int firstNonRep_II(String str) {
		Map<Character, Counter> hm = new HashMap<Character, Counter>(256);
		for(int i=0; i<str.length(); i++) {
			if(!hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), new Counter(1, i));
			}else {
				hm.get(str.charAt(i)).count++;
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(Entry<Character, Counter> entry : hm.entrySet()) {
			int c = entry.getValue().count;
			int index = entry.getValue().index;
			if(c == 1 && result > index) result = index;
		}
		return result;
	}

	/**
	 * @param str
	 * @return
	 */
	// S - O(n), T - O(n), but it is two pass approack
	// for a very large input, we would traverse string twice
	private static char firstNonRep(String str) {
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for(char c : str.toCharArray())
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		
		for(char c : str.toCharArray())
			if(hm.get(c) == 1) return c;
		
		return 0;
	}
}

class Counter{
	int count, index;
	
	public Counter(int count, int index) {
		this.count = count;
		this.index = index;
	}
}
