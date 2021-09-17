/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class Unique_BST {

	public static void main(String[] args) {
		int n = 3;
		int []dp = new int[n+1];
		dp[0] = dp[1]  = 1;
		
		for(int i=2; i<n+1; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = dp[i] + dp[i-j] * dp[j-1];
			}
		}
		
		System.out.println(dp[n]);
	}
}
