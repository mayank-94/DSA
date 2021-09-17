/**
 * 
 */
package data.structures.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
public class Count_Islands {
	static int m, n;
	
	static class Pair{
		int row, col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) {
		int mat[][] = 
			{   { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
		
		System.out.print(countIslands(mat));
	}

	/**
	 * @param mat
	 * @return
	 */
	private static int countIslands(int[][] mat) {
		m = mat.length;
		n = mat[0].length;
		int counter = 0;
		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false && mat[i][j] == 1) {
					bfs(mat, visited, i, j);
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * @param mat
	 * @param visited
	 * @param i
	 * @param j
	 */
	private static void bfs(int[][] mat, boolean[][] visited, int i, int j) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			if(isValid(p.row + 1, p.col, mat, visited)) {
				visited[p.row+1][p.col] = true;
				queue.add(new Pair(p.row+1, p.col));
			}
			
			if(isValid(p.row - 1, p.col, mat, visited)) {
				visited[p.row-1][p.col] = true;
				queue.add(new Pair(p.row-1, p.col));
			}
			
			if(isValid(p.row, p.col + 1, mat, visited)) {
				visited[p.row][p.col+1] = true;
				queue.add(new Pair(p.row, p.col+1));
			}
			
			if(isValid(p.row, p.col - 1, mat, visited)) {
				visited[p.row][p.col-1] = true;
				queue.add(new Pair(p.row, p.col-1));
			}
		}
	}

	/**
	 * @param row
	 * @param col
	 * @param mat
	 * @param visited
	 * @return
	 */
	private static boolean isValid(int row, int col, int[][] mat, boolean[][] visited) {
		if(row >= 0 && row < m && col >= 0 && col < n && 
				visited[row][col] == false && mat[row][col] == 1) return true;
		
		return false;
	}
}
