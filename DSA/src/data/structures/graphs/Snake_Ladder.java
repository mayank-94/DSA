/**
 * 
 */
package data.structures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
public class Snake_Ladder {

	public static void main(String[] args) {
		int n = 8;
		int arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 17, 4, 19, 7, 27, 1, 21, 9};
		int[] moves = new int[30];
		Arrays.fill(moves, -1);
		for(int i=0; i<2*n-1; i=i+2) {
			moves[arr[i] -1] = arr[i+1] - 1;
		}
		
		getMinThrows(moves, 30);
	}

	/**
	 * @param moves
	 * @param v
	 */
	private static void getMinThrows(int[] moves, int v) {
		boolean[] visited = new boolean[v];
		Queue<Entry> q = new LinkedList<>();
		Entry e = new Entry();
		e.vertex = 0;
		e.distance = 0;
		
		q.add(e);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			e = q.poll();
			int vertex = e.vertex;
			
			if(vertex == v - 1) break;
			for(int j = vertex+1; j<=(vertex+6) && j<v; j++) {
				
				if(visited[j] == false) {
					visited[j] = true;
					
					Entry entry = new Entry();
					entry.distance = e.distance+1;
					
					if(moves[j] != -1) {
						entry.vertex = moves[j];
					}else {
						entry.vertex = j;
					}
					
					q.add(entry);					
				}
			}
		}
		System.out.println(e.distance);
	}
	
	static class Entry{
		int vertex;
		int distance;
	}
}
