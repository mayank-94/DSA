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
class Cell{
	int x, y, dis;
	
	public Cell(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}

public class Min_Steps_ByKnight {

	public static void main(String[] args) {
		int n = 8;
		boolean[][] visited = new boolean[n+1][n+1];
		int dx[] = {-2, -2, 2, 2, -1, -1, 1, 1};
		int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
		int startRow = 0, startCol = 0, endRow = 1, endCol = 1;
		Queue<Cell> q = new LinkedList<>();
		q.add(new Cell(startRow, startCol, 0));
		visited[startRow][startCol] = true;
		
		while(!q.isEmpty()) {
			Cell t = q.poll();
			int x = t.x;
			int y = t.y;
			
			if(x == endRow && y == endCol) {
				System.out.println(t.dis);
				return;
			}
			
			for(int i=0; i<8; i++) {
				x = t.x + dx[i];
				y = t.y + dy[i];
				if(isValid(x, y, n) && !visited[x][y]) {
					visited[x][y] = true;
					q.add(new Cell(x, y, t.dis + 1));
				}
			}
		}
		
		System.out.println("No Path available!!");
	}
	
	public static boolean isValid(int x, int y, int n) {
		if(x>=0 && x<n && y>=0 && y<n) return true;
		return false;
	}
}
