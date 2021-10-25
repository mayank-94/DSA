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
public class Course_Schedule_II {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int n = 3; 
		int[][] prerequisites =  {{0,2},{1,2},{2,0}}; // {{1,0},{2,0},{3,1},{3,2}};
		List<Integer> graph[] = new ArrayList[n];
		
		for(int i=0; i<n; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int[] edge : prerequisites)
			graph[edge[1]].add(edge[0]);
		
		boolean[] visited = new boolean[n];
		boolean[] rec = new boolean[n];
		Stack<Integer> stack = new Stack<Integer>();
		boolean cycle = false;
		for(int i=0; i<n; i++) {
			if(visited[i] == false)
				cycle = cycle || cycle(i, graph, stack, visited, rec);
		}
		
		int[] result = new int[stack.size()];
		n = stack.size();
		if(cycle) {
			return;
		}
		
        for(int i=0; i<n; i++)
            result[i] = stack.pop();
        
        for(int x : result)
        	System.out.print(x+" ");
	}

	/**
	 * @param i
	 * @param graph
	 * @param visited
	 * @param rec
	 * @return
	 */
	private static boolean cycle(int i, List<Integer>[] graph, Stack<Integer> stack, 
			boolean[] visited, boolean[] rec) {
		if(rec[i]) return true;
		if(visited[i]) return false;
		
		rec[i] = true;
		visited[i] = true;
		
		for(int n : graph[i]) {
			if(cycle(n, graph, stack, visited, rec)) return true;
		}
		stack.add(i);
		rec[i] = false;
		return false;
	}
}
