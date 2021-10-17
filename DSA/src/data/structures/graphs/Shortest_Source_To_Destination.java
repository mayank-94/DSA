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
public class Shortest_Source_To_Destination {
	
	static class Item{
	    int x, y, w;
	    
	    public Item(int x, int y, int w){
	        this.x = x;
	        this.y = y;
	        this.w = w;
	    }
	}
	
	public static void main(String[] args) {
		int N = 8, M = 7, X = 0, Y = 2;
		int A[][] = {
				{0, 0, 1, 1, 0, 0, 1},
				{1, 0, 1, 0, 1, 0, 1},
				{1, 1, 1, 1, 1, 0, 1},
				{0, 1, 0, 1, 0, 1, 1},
				{1, 0, 0, 1, 0, 1, 0},
				{1, 1, 0, 1, 1, 1, 1},
				{1, 1, 1, 0, 0, 1, 0},
				{0, 1, 1, 1, 1, 0, 1}
		};
		
		boolean[][] visited = new boolean[N][M];
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(0, 0, 0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Item it = q.poll();
            if(it.x == X && it.y == Y){
            	System.out.println(it.w);
                return;
            }
            
            int x = it.x;
            int y = it.y;
            int w = it.w;
            
            if(isValid(x+1, y, N, M, visited, A)){
                visited[x+1][y] = true;
                q.add(new Item(x+1, y, w+1));
            }
            
            if(isValid(x-1, y, N, M, visited, A)){
                visited[x-1][y] = true;
                q.add(new Item(x-1, y, w+1));
            }
            
            if(isValid(x, y+1, N, M, visited, A)){
                visited[x][y+1] = true;
                q.add(new Item(x, y+1, w+1));
            }
            
            if(isValid(x, y-1, N, M, visited, A)){
                visited[x][y-1] = true;
                q.add(new Item(x, y-1, w+1));
            }
            
        }
        
        System.out.println(-1);
	}
	
	private static boolean isValid(int x, int y, int n, int m, 
            boolean[][] visited, int[][] A){
        
        if(x>=0 && x<n && y>=0 && y<m && 
                visited[x][y] == false && A[x][y] == 1) return true;
                
        return false;
    }
}
