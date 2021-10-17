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
public class Flood_Fill_Problem {
	static class Pair{
	    int x, y;
	    
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1, newColor = 2;
				
		int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            
            if(isValid(x+1, y, m, n, visited, image, newColor) 
                    && image[x+1][y] == oldColor){
                image[x+1][y] = newColor;
                visited[x+1][y] = true;
                q.add(new Pair(x+1, y));
            }
            
            if(isValid(x-1, y, m, n, visited, image, newColor)
                    && image[x-1][y] == oldColor){
                image[x-1][y] = newColor;
                visited[x-1][y] = true;
                q.add(new Pair(x-1, y));
            }
            
            if(isValid(x, y+1, m, n, visited, image, newColor)
                    && image[x][y+1] == oldColor){
                image[x][y+1] = newColor;
                visited[x][y+1] = true;
                q.add(new Pair(x, y+1));
            }
            
            if(isValid(x, y-1, m, n, visited, image, newColor)
                    && image[x][y-1] == oldColor){
                image[x][y-1] = newColor;
                visited[x][y-1] = true;
                q.add(new Pair(x, y-1));
            }
        }
	}

	private static boolean isValid(int x, int y, int m, int n, boolean[][] visited, int[][] image, int newColor) {

		if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == false && image[x][y] != newColor)
			return true;

		return false;
	}
}
