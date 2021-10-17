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
public class All_Paths_FromStartToEnd {

	public static void main(String[] args) {
		int[][] graph = {{1, 2}, {3}, {3}, {}};
		int len = graph.length;
		boolean[] visited = new boolean[len];
		List<Integer> result = new ArrayList<>();
		dfs(graph, 0, len-1, visited, result);
	}

	/**
	 * @param graph
	 * @param src
	 * @param target
	 * @param visited
	 * @param result
	 */
	private static void dfs(int[][] graph, int src, int target, boolean[] visited, List<Integer> result) {
		if(src == target) {
			result.add(src);
			System.out.println(result);
			result.remove(new Integer(src));
			return;
		}
		
		visited[src] = true;
		result.add(src);
		for(int n : graph[src]) {
			if(!visited[n])
				dfs(graph, n, target, visited, result);
		}
		visited[src] = false;
		result.remove(new Integer(src));
	}
}
