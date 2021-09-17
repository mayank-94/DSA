/**
 * 
 */
package data.structures.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author mayankjain02
 *
 */
public class LongestHappyString {

	public static void main(String[] args) {
		longestHappyString(1, 1, 7);
	}

	/**
	 * @param i
	 * @param j
	 * @param k
	 */
	private static void longestHappyString(int a, int b, int c) {
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		if(a!=0) hm.put('a', a);
		if(b!=0) hm.put('b', b);
		if(c!=0) hm.put('c', c);
		
		PriorityQueue<Character> heap = new PriorityQueue<>((x, y) -> hm.get(y) - hm.get(x));
		heap.addAll(hm.keySet());
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(heap.size() > 0) {
			char c1 = heap.poll();
			if(i >= 2 && sb.charAt(i-1) == c1 && sb.charAt(i-2) == c1) {
				if(heap.size() == 0) break;
				
				char c2 = heap.poll();
				sb.append(c2);
				i++;
				hm.put(c2, hm.get(c2) - 1);
				if(hm.get(c2) > 0)
					heap.add(c2);
			}
			
			sb.append(c1);
			i++;
			hm.put(c1, hm.get(c1) - 1);
			if(hm.get(c1) > 0)
				heap.add(c1);
		}
		
		System.out.println(sb.toString());
	}
}
