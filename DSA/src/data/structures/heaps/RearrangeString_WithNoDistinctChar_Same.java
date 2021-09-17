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
public class RearrangeString_WithNoDistinctChar_Same {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<str.length(); i++){
		    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) +1);
		}
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->
		                    map.get(b) - map.get(a));
		
		maxHeap.addAll(map.keySet());
        while(maxHeap.size() > 1){
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            
            sb.append(first).append(second);
            map.put(first, map.get(first) -1);
            map.put(second, map.get(second) -1);
            
            if(map.get(first) > 0)
                maxHeap.add(first);
                
            if(map.get(second) > 0)
                maxHeap.add(second);
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.poll();
            if(map.get(last) > 1) return;
            
            else sb.append(last);
        }
        System.out.println(sb.toString());
	}
}
