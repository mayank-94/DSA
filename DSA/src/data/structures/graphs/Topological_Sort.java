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
public class Topological_Sort {
	
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
		
		public void topologicalSort() {
			boolean[] visited = new boolean[v];
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i=0; i<v; i++) {
				if(visited[i] == false)
					topologicalUtil(i, visited, stack);
			}
			
			while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
		}

		/**
		 * @param i
		 * @param visited
		 */
		private void topologicalUtil(int i, boolean[] visited, Stack<Integer> stack) {
			visited[i] = true;
			for(int n : graph[i]) {
				if(!visited[n])
					topologicalUtil(n, visited, stack);
			}
			
			stack.push(i);
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        g.topologicalSort();
	}
}
