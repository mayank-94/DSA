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
public class Top_K_FrequestNumbers {
	public static void main(String[] args) {
		int [] nums = {6, 1, 1, 1, 2, 2, 3};
		int k=2;
		
		Map<Integer, Integer> hm = new HashMap<>();
        int res[] = new int[k];
        for(int x : nums){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        
        PriorityQueue<Pair> maxHeap = 
            new PriorityQueue<>((a,b) -> a.value == b.value ? 
                    (b.key - a.key) : (b.value - a.value));
            
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        for(int i=0; i<k; i++){
            int val = maxHeap.poll().key;
            res[i] = val;
        }
        
        for(int x : res) System.out.print(x+" ");
	}
}
