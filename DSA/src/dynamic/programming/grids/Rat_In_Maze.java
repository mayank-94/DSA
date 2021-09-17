/**
 * 
 */
package dynamic.programming.grids;

/**
 * @author mayankjain
 *
 */
public class Rat_In_Maze {
	static int m, n;

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		m = maze.length;
		n = maze[0].length;
		System.out.println(solveMaze(maze));
	}

	/**
	 * @param maze
	 * @return
	 */
	private static boolean solveMaze(int[][] maze) {
		int path[][] = new int[m][n];
		if(!mazeUtil(0, 0, path, maze)) {
			return false;		
		}
		print(path);
		return true;
	}

	/**
	 * @param path
	 */
	private static void print(int[][] path) {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param path
	 * @param maze
	 * @return
	 */
	private static boolean mazeUtil(int x, int y, int[][] path, int[][] maze) {
		if (x == m - 1 && y == n - 1 && maze[x][y] == 1) {
			path[x][y] = 1;
			return true;	
		}

		if (isValid(x, y, maze)) {
			if(path[x][y] == 1) return false;
			
			path[x][y] = 1;

			if(mazeUtil(x + 1, y, path, maze)) return true;
			
			if(mazeUtil(x, y + 1, path, maze)) return true;
			
			if(mazeUtil(x - 1, y, path, maze)) return true;
			
			if(mazeUtil(x, y - 1, path, maze)) return true;
			
			path[x][y] = 0;
			
			return false;
		}

		return false;
	}

	/**
	 * @param x
	 * @param y
	 * @param maze
	 * @return
	 */
	private static boolean isValid(int x, int y, int[][] maze) {
		if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 1)
			return true;

		return false;
	}
}
