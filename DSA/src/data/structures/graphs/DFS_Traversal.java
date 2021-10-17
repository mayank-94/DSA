/**
 * 
 */
package data.structures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class DFS_Traversal {

	static class Graph{
		private int v;
		private List<Integer> graph[];
		
		public Graph(int v) {
			this.v = v;
			this.graph = new ArrayList[v];
			for(int i=0; i<v; i++) {
				graph[i] = new ArrayList<Integer>();
			}
		}
		
		public void addEdge(int u, int v) {
			graph[u].add(v);
		}
		
		public void dfs() {
			boolean visited[] = new boolean[v];
			
			for(int i=0; i<v; i++) {
				if(visited[i] == false)
					dfsUtil(i, visited);
			}
		}

		/**
		 * @param graph
		 * @param visited
		 */
		private void dfsUtil(int vertex, boolean[] visited) {
			visited[vertex] = true;
			System.out.print(vertex+" ");
			
			for(int v : graph[vertex]) {
				if(visited[v] == false)
					dfsUtil(v, visited);
			}
		}
		
		public void dfsStack(int vertex) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean[] visited = new boolean[v];
			stack.push(vertex);
			while(!stack.isEmpty()) {
				int v = stack.pop();
				System.out.print(v+" ");
				for(int n : graph[v]) {
					if(visited[n] == false) {
						visited[n] = true;
						stack.push(n);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.dfs();
		System.out.println();
		g.dfsStack(0);
	}
}
