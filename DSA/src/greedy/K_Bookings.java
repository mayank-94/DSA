/**
 * 
 */
package greedy;

import java.util.Arrays;

/**
 * @author mayankjain
 *
 */
public class K_Bookings {

	public static void main(String[] args) {
		int arrival[] = { 1, 3, 5 };
	    int departure[] = { 2, 6, 8 };
	    int k = 1;
	    int n = arrival.length;
	    int j = 0;
	    Pair[] pairs = new Pair[n*2];
	    for(int i=0; i<n; i++) {
	    	pairs[i+j] = new Pair(arrival[i], 1);
	    	pairs[i+j+1] = new Pair(departure[i], 0);
	    	j++;
	    }
	    
	    Arrays.sort(pairs, (a, b) -> a.x - b.x);
	    int counter = 0;
	    int max = Integer.MIN_VALUE;
	    for(int i=0; i<n*2; i++) {
	    	if(pairs[i].y == 1) {
	    		counter++;
	    		max = Math.max(max, counter);
	    	}else {
	    		counter--;
	    	}
	    }
	    
	    System.out.println(k >= max);	    
	}
}

class Pair{
	int x, y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
