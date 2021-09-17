package dynamic.programming.Fibonacci;

/*
 * Given the nth Stair and the possible steps that a person
 * can take. Find the total number of ways to reach the nth stairs 
 * with 1, 2 and 3 steps
 */
public class TotalWays_ToReach_NthStair {

	public static void main(String[] args) {
		int stair = 154;
		
		long t[] = new long[stair+1];
		t[0] = 1%1000000007;
		t[1] = 1%1000000007;
		t[2] = 2%1000000007;
		for(int i=3; i<stair+1; i++) {
			t[i] = t[i-3] + t[i-2] + t[i-1];
			t[i] = t[i] % 1000000007;
		}
		
		System.out.println(t[stair]);
	}
}
