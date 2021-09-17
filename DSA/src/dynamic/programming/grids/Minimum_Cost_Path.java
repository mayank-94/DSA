/**
 * 
 */
package dynamic.programming.grids;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class Minimum_Cost_Path {
	static int m, n;
	
	public static void main(String[] args) {
		int[][] grid = { { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };
		
		m = grid.length;
		n = grid[0].length;
		System.out.println(minCostPath(grid, m, n));
	}

	/**
	 * @param grid
	 * @param x
	 * @param y
	 * @return
	 */
	private static int minCostPath(int[][] grid, int x, int y) {
		int t[][] = new int[x][y];
		boolean visited[][] = new boolean[x][y];
	
		PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		t[0][0] = grid[0][0];
		visited[0][0] = true;
		queue.add(new Cell(0, 0, t[0][0]));
		
		while(!queue.isEmpty()) {
			Cell q = queue.poll();
			
			if(isValid(q.row+1, q.col, visited)) {
				visited[q.row+1][q.col] = true;
				queue.add(new Cell(q.row+1, q.col, q.dist + grid[q.row+1][q.col]));
				t[q.row+1][q.col] = q.dist + grid[q.row+1][q.col];
			}
			
			if(isValid(q.row-1, q.col, visited)) {
				visited[q.row-1][q.col] = true;
				queue.add(new Cell(q.row-1, q.col, q.dist + grid[q.row-1][q.col]));
				t[q.row-1][q.col] = q.dist + grid[q.row-1][q.col];
			}
			
			if(isValid(q.row, q.col+1, visited)) {
				visited[q.row][q.col+1] = true;
				queue.add(new Cell(q.row, q.col+1, q.dist + grid[q.row][q.col+1]));
				t[q.row][q.col+1] = q.dist + grid[q.row][q.col+1];
			}
			
			if(isValid(q.row, q.col-1, visited)) {
				visited[q.row][q.col-1] = true;
				queue.add(new Cell(q.row, q.col-1, q.dist + grid[q.row][q.col-1]));
				t[q.row][q.col-1] = q.dist + grid[q.row][q.col-1];
			}
		}
		return t[m-1][n-1];
	}
	
	private static boolean isValid(int x, int y, boolean[][] visited) {
		if(x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == false) return true;
		
		return false;
	}
}

class Cell{
	int row, col, dist;
	
	public Cell(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}


