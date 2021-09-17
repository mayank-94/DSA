/**
 * 
 */
package dynamic.programming.grids;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
class Item{
	int row, col, dist;
	
	public Item(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

public class Shortest_Distance {
	static int m, n;

	public static void main(String[] args) {
		char[][] grid = { { '0', '*', '0', 's' },
                { '*', '0', '*', '*' },
                { '0', '*', '*', '*' },
                { 'd', '*', '*', '*' } };
		
		System.out.println(minDistance(grid));
	}

	/**
	 * @param grid
	 * @return
	 */
	private static int minDistance(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		Item source = new Item(0, 0, 0);
		
		firstloop:
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 's') {
					source.row = i;
					source.col = j;
					break firstloop;
				}
			}
		}
		
		Queue<Item> queue = new LinkedList<Item>();
		queue.add(source);
		boolean[][] visited = new boolean[m][n];
		visited[source.row][source.col] = true;
		while(!queue.isEmpty()) {
			Item q = queue.poll();
			
			if(grid[q.row][q.col] == 'd') {
				return q.dist;
			}
			
			//moving down
			if(isValid(q.row + 1, q.col, grid, visited)) {
				queue.add(new Item(q.row + 1, q.col, q.dist + 1));
				visited[q.row + 1][q.col] = true;
			}
			
			//moving up
			if(isValid(q.row - 1, q.col, grid, visited)) {
				queue.add(new Item(q.row - 1, q.col, q.dist + 1));
				visited[q.row - 1][q.col] = true;
			}
			
			//moving right
			if(isValid(q.row, q.col + 1, grid, visited)) {
				queue.add(new Item(q.row, q.col + 1, q.dist + 1));
				visited[q.row][q.col + 1] = true;
			}
			
			//moving left
			if(isValid(q.row, q.col - 1, grid, visited)) {
				queue.add(new Item(q.row, q.col - 1, q.dist + 1));
				visited[q.row][q.col - 1] = true;
			}
		}
		return -1;
	}

	/**
	 * @param row
	 * @param col
	 * @param grid
	 * @param visited
	 * @return
	 */
	private static boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
		if(row >= 0 && row < m && col >= 0 && col < n && 
				grid[row][col] != '0' && visited[row][col] == false)
			return true;
		
		return false;
	}
}
