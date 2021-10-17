/**
 * 
 */
package data.structures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
public class Reorder_Routes {

	public static void main(String[] args) {
		int[][] connections = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
		int n = 6;
		@SuppressWarnings("unchecked")
		List<Edge> []graph = new ArrayList[n];
		
		for(int i=0; i<n; i++)
			graph[i] = new ArrayList<>();
		
		for(int []edge : connections) {
			int u = edge[0];
			int v = edge[1];
			graph[u].add(new Edge(u, v, 1));
			graph[v].add(new Edge(v, u, 0));
		}
		
		int cost = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		boolean[] visited = new boolean[n];
		visited[0] = true;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(Edge edge : graph[v]) {
				if(visited[edge.v] == false) {
					visited[edge.v] = true;
					q.add(edge.v);
					cost+=edge.w;
				}
			}
		}
		System.out.println(cost);
	}

	static class Edge{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}
