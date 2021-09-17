package dynamic.programming.Fibonacci;

public class HouseRobberProblem {

	public static void main(String[] args) {
		int nums[] = {2, 1, 1, 2};
		int n = nums.length;
		int money = rob(nums, n);
		System.out.println(money);
		
		int moneyDp = rob_DP(nums, n);
		System.out.println(moneyDp);
	}

	private static int rob_DP(int[] nums, int n) {
		int t[] = new int[n+1];
		t[0] = 0;
		t[1] = nums[0];
		for(int i=2; i<n+1; i++)
			t[i] = Math.max(nums[i-1] + t[i-2], t[i-1]);
		
		return t[n];
	}

	private static int rob(int[] nums, int n) {
		if(n == 0)
			return 0;
		
		if(n == 1)	
			return nums[n-1];
		
		return Math.max(nums[n-1] + rob(nums, n-2), 
				rob(nums, n-1));
	}
	
	
}
