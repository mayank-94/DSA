/**
 * 
 */
package dynamic.programming.miscelaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class TotalWaysTo_ReachDestination {

	public static void main(String[] args) {
		int [][]roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		int n = 7;
		@SuppressWarnings("unchecked")
		List<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        
        for(int edge[] : roads){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            
            graph[u].add(new Edge(u, v, time));
            graph[v].add(new Edge(v, u, time));
        }
        
        boolean[] visited = new boolean[n];
        int[] costs = new int[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        queue.add(new Pair(0, 0));
        costs[0] = 0;
        ways[0] = 1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            
            if(p.wt > costs[p.vertex] || visited[p.vertex]) continue;
            
            for(Edge edge : graph[p.vertex]){
                if(costs[p.vertex] + edge.time < costs[edge.v]){
                    costs[edge.v] = edge.time + costs[p.vertex];
                    ways[edge.v] = ways[p.vertex];
                    queue.add(new Pair(edge.v, costs[edge.v]));
                }else if(costs[p.vertex] + edge.time == costs[edge.v]){
                    ways[edge.v] = ways[edge.v] + ways[p.vertex];
                }
            }
        }
        System.out.println(ways[n-1]);
	}
	
	static class Pair{
	    int vertex, wt;
	    
	    public Pair(int vertex, int wt){
	        this.vertex = vertex;
	        this.wt = wt;
	    }
	}

	static class Edge{
	    int u, v, time;
	    
	    public Edge(int u, int v, int time){
	        this.u = u;
	        this.v = v;
	        this.time = time;
	    }
	}
}
