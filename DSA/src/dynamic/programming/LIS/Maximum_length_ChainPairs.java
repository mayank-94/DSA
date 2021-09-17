/**
 * 
 */
package dynamic.programming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mayankjain
 *
 */
class Pair{
	int a;
	int b;
	
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class Maximum_length_ChainPairs {
	public static void main(String[] args) {
		
		int pairs[][] = {{1,2}, {2,3}, {3,4}};
		List<Pair> pair = new ArrayList<Pair>();
		for(int i=0; i<pairs.length; i++) {
			pair.add(new Pair(pairs[i][0], pairs[i][1]));
		}
		
		Collections.sort(pair, (x, y) -> x.a - y.a);
		int n = pair.size();
		int t[] = new int[n];
		t[0] = 1;
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(pair.get(i).a > pair.get(j).b && t[j] > max) {
					max = t[j];
				}
			}
			
			t[i] = 1 + max;
		}
		
		System.out.println(Arrays.stream(t).max().getAsInt());
	}
}
