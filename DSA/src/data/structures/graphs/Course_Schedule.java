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
public class Course_Schedule {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int n = 4; 
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		List<Integer> graph[] = new ArrayList[n];
		
		for(int i=0; i<n; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int[] edge : prerequisites)
			graph[edge[1]].add(edge[0]);
		
		boolean[] visited = new boolean[n];
		boolean[] rec = new boolean[n];
		for(int i=0; i<n; i++) {
			if(cycle(i, graph, visited, rec)) {
				System.out.println(false);
				return;
			}
		}
		
		System.out.println(true);
	}

	/**
	 * @param i
	 * @param graph
	 * @param visited
	 * @param rec
	 * @return
	 */
	private static boolean cycle(int i, List<Integer>[] graph, boolean[] visited, boolean[] rec) {
		if(rec[i]) return true;
		if(visited[i]) return false;
		
		rec[i] = true;
		visited[i] = true;
		
		for(int n : graph[i]) {
			if(cycle(n, graph, visited, rec)) return true;
		}
		rec[i] = false;
		return false;
	}
}
