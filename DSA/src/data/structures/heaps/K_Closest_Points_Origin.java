/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain
 *
 */
public class K_Closest_Points_Origin {

	public static void main(String[] args) {
		int arr[][] = {{1, 3}, {-2, 2}, {0, 1}, {5, 8}};
		int k = 2;
		
		PriorityQueue<Distance> queue = new PriorityQueue<>((a, b) -> a.d - b.d);
		for(int i=0; i<arr.length; i++) {
			int d = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
			Point p = new Point(arr[i][0], arr[i][1]);
			queue.add(new Distance(d, p));
		}
		
		for(int i=0; i<k; i++) {
			Distance d = queue.poll();
			System.out.println(d.p);
		}
	}
}

class Distance{
	int d;
	Point p;
	
	public Distance(int d, Point p) {
		this.d = d;
		this.p = p;
	}
}

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}