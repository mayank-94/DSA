/**
 * 
 */
package data.structures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class Dijkstra_Algorithm {
	
	class Edge{
		int u;
		int v;
		int wt;
		
		Edge(int u, int v, int wt){
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
	}
	
	int v;
	List<Edge> neighbours[];
	
	@SuppressWarnings("unchecked")
	public Dijkstra_Algorithm(int v) {
		this.v = v;
		this.neighbours = new ArrayList[v];
		for(int i=0; i<v; i++)
			neighbours[i] = new ArrayList<>();
	}
	
	void addEdge(int src, int dst, int wt) {
		neighbours[src].add(new Edge(src, dst, wt));
		neighbours[dst].add(new Edge(dst, src, wt));
	}
	
	public static void main(String[] args) {
		Dijkstra_Algorithm graph = new Dijkstra_Algorithm(7);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 3, 40);
		graph.addEdge(1, 2, 10);
		graph.addEdge(2, 3, 10);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 3);
		graph.addEdge(5, 6, 3);
		graph.addEdge(4, 6, 8);
		
		int src = 0;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a, b) -> a.totalWt - b.totalWt);
		boolean[] visited = new boolean[graph.v];
		queue.add(new Pair(src, src+"", 0));
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			if(visited[pair.v] == true) continue;
			
			visited[pair.v] = true;
			System.out.println(pair.v+" via "+pair.path+" @ "+pair.totalWt);
			
			for(Edge e : graph.neighbours[pair.v]) {
				if(visited[e.v] == false)
					queue.add(new Pair(e.v, pair.path+e.v, pair.totalWt+e.wt));
			}
		}
	}
}

class Pair{
	int v;
	String path;
	int totalWt;
	
	Pair(int v, String path, int totalWt){
		this.v = v;
		this.path = path;
		this.totalWt = totalWt;
	}
}
