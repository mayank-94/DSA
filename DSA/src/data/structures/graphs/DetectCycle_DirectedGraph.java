/**
 * 
 */
package data.structures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class DetectCycle_DirectedGraph {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		//g.addEdge(2, 0);
		g.addEdge(2, 3);
		//g.addEdge(3, 3);	
		System.out.println(dfs(g));
	}
	
	/**
	 * 
	 */
	private static boolean dfs(Graph g) {
		boolean[] visited = new boolean[g.v];
		boolean[] recStack = new boolean[g.v];
		
		for(int i=0; i<g.v; i++) {
			if(cyclic(i, visited, recStack, g)) return true;
		}
		
		return false;
	}

	/**
	 * @param i
	 * @param visited
	 * @param recStack
	 * @return
	 */
	private static boolean cyclic(int i, boolean[] visited, boolean[] recStack, Graph g) {
		if(recStack[i]) return true;
		
		if(visited[i]) return false;
		
		recStack[i] = true;
		visited[i] = true;
		for(int n : g.graph[i]) {
			if(cyclic(n, visited, recStack, g)) return true;
		}
		recStack[i] = false;
		
		return false;
	}

	static class Graph{
		int v;
		List<Integer> graph[];
		
		public Graph(int v) {
			this.v = v;
			this.graph = new ArrayList[v];
			
			for(int i=0; i<v; i++)
				graph[i] = new ArrayList<>();
		}
		
		public void addEdge(int u, int v) {
			graph[u].add(v);
		}
	}
}
