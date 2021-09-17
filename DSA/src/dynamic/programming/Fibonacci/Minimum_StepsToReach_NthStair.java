package dynamic.programming.Fibonacci;

/*
 * We are given nth stair, and the possible steps we can take are 1, 2, 3
 * Find minimum steps to reach the nth stair
 */
public class Minimum_StepsToReach_NthStair {

	public static void main(String[] args) {
		int n = 7;
		int t[] = new int[n+1];
		t[0] = 0;
		t[1] = 1;
		t[2] = 1;
		
		for(int i=3; i<n+1; i++) {
			t[i] = 1 + Math.min(t[i-1], Math.min(t[i-2], t[i-3]));
		}
		
		System.out.println(t[n]);
	}
}
