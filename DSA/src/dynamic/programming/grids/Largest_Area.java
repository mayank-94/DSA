/**
 * 
 */
package dynamic.programming.grids;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class Largest_Area {
	
	static class Pair{
		int index;
		int value;
		
		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int A[][] = {
	            { 0, 1, 1, 0 },
	            { 1, 1, 1, 1 },
	            { 1, 1, 1, 1 },
	            { 1, 1, 0, 0 },
	        };
		
		int m = A.length;
		int n = A[0].length;
		
		System.out.println(getMaxArea(A, m, n));
	}

	/**
	 * @param a
	 * @param m
	 * @param n
	 * @return
	 */
	private static int getMaxArea(int[][] a, int m, int n) {
		int result = getArea(a[0]);
		for(int i=1; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1)
					a[i][j] = a[i][j] + a[i-1][j];
			}
			
			result = Math.max(result, getArea(a[i]));
		}
		return result;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getArea(int[] arr) {
		int n = arr.length;
		int nslIndex[] = new int[n];
		findNSLIndex(arr, n, nslIndex);
		
		int nsrIndex[] = new int[n];
		findNSRIndex(arr, n, nsrIndex);
		
		int width[] = new int[n];
		for(int i=0; i<n; i++)
			width[i] = Math.abs(nslIndex[i] - nsrIndex[i]) - 1;
		
		int area[] = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			area[i] = width[i] * arr[i];
			max = Math.max(max, area[i]);
		}
		
		return max;
	}

	/**
	 * @param arr
	 * @param n
	 * @param nsrIndex
	 */
	private static void findNSRIndex(int[] arr, int n, int[] nsrIndex) {
		Stack<Pair> stack = new Stack<>();
		int top = n-1;
		for(int i=n-1; i>=0; i--) {
			if(stack.isEmpty()) {
				nsrIndex[top] = n;
			}else if(stack.peek().value < arr[i]) {
				nsrIndex[top] = stack.peek().index;
			}else {
				while(!stack.isEmpty() && stack.peek().value >= arr[i])
					stack.pop();
				if(stack.isEmpty())
					nsrIndex[top] = n;
				else
					nsrIndex[top] = stack.peek().index;
			}
			top--;
			stack.push(new Pair(i, arr[i]));
		}
	}

	/**
	 * @param arr
	 * @param n
	 * @param nslIndex
	 */
	private static void findNSLIndex(int[] arr, int n, int[] nslIndex) {
		Stack<Pair> stack = new Stack<>();
		int top = 0;
		for(int i=0; i<n; i++) {
			if(stack.isEmpty()) {
				nslIndex[top] = -1;
			}else if(stack.peek().value < arr[i]) {
				nslIndex[top] = stack.peek().index;
			}else {
				while(!stack.isEmpty() && stack.peek().value >= arr[i])
					stack.pop();
				
				if(stack.isEmpty()) nslIndex[top] = -1;
				else nslIndex[top] = stack.peek().index;
			}
			top++;
			stack.push(new Pair(i, arr[i]));
		}
	}
}
