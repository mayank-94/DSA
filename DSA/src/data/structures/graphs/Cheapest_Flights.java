/**
 * 
 */
package data.structures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class Cheapest_Flights {
	
	static class Pair{
		int v;
		int wt;
		int dist;
		
		public Pair(int v, int wt, int dist){
			this.v = v;
			this.wt = wt;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		int n = 3, flights[][] = {{0,1,100},{1,2,100},{0,2,500}}, src = 0, dst = 2, k = 1;
		
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}
	
	@SuppressWarnings("unchecked")
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair> []graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            graph[u].add(new Pair(v, wt, 0));
            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0, -1));
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            if(p.dist > k || stop[p.v] < p.dist) continue;
            
            stop[p.v] = p.dist;
            if(p.v == dst) return p.wt;

            for(Pair nbr : graph[p.v]){
                pq.add(new Pair(nbr.v, p.wt + nbr.wt, p.dist + 1));
                
            }
            
        }
        return -1;
	}
}
