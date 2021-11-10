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
public class Rotten_Oranges {
	static int m, n;
	
	static class Element{
		int x, y;
		
		public Element(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		
		m = arr.length;
		n = arr[0].length;
		int ans = rotOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int rotOranges(int[][] arr) {
		Queue<Element> queue = new LinkedList<>();
		int fresh = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 2) {
					queue.add(new Element(i, j));
				}else if(arr[i][j] == 1) {
					fresh++;
				}
			}
		}
		
		if(fresh == 0) return 0;
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		int t = 1, count = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size > 0) {
				Element e = queue.poll();
				int x;
				int y;
				
				for(int i=0; i<4; i++) {
					x = e.x + dx[i];
					y = e.y + dy[i];
					
					if(isValid(x, y) && arr[x][y] == 1) {
						arr[x][y] = 2;
						queue.add(new Element(x, y));
						count++;
					}
				}
				size--;
			}
			
			if(count == fresh) break;
			t++;
		}
		return count == fresh ? t : -1;
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isValid(int x, int y) {
		if(x >= 0 && x < m && y >= 0 && y < n) return true;
		return false;
	}
}
