package dynamic.programming.mcm;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String str = "nitiadea";
		int len = str.length();
		int i=0, j=len-1;
		int t[][] = new int[len+1][len+1];
		
		int min = partitions(str, i, j);
		System.out.println(min);
		
		int minMemoize = partitionsMemoization(str, i, j, t);
		System.out.println(minMemoize);
	}
	
	private static int partitionsMemoization(String str, int i, int j, int t[][]) {
		if(i >= j) return 0;
		
		if(isPalindrome(str, i, j)) return 0;
		
		if(t[i][j] != 0) return t[i][j];
		
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int left = 0, right = 0;
			if(t[i][k] != 0) left = t[i][k];
			else left = partitionsMemoization(str, i, k, t);
			
			if(t[k+1][j] != 0) right = t[k+1][j];
			else right = partitionsMemoization(str, k + 1, j, t);
			
			int temp = left + right + 1;
			min = Math.min(min, temp);
		}
		return min;
	}

	//recursive
	//If a string is already palindrome, then minimum partitions are 0
	private static int partitions(String str, int i, int j) {
		//if i==j, str is of 1 length, so partitions required are 0
		if(i >= j)
			return 0;
		
		if(isPalindrome(str, i, j)) return 0;
		
		int result = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp = partitions(str, i, k) + partitions(str, k+1, j) + 1;
			result = Math.min(result, temp);
		}
		return result;
	}

	private static boolean isPalindrome(String str, int i, int j) {
		while(i < j) {
			if(str.charAt(i) != str.charAt(j))
				return false;
			
			i++;
			j--;
		}
		return true;
	}
}
