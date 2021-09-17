/**
 * 
 */
package data.structures.stack;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class MinimumElementInStack {
	static int min;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		int arr[] = {8, 10, 6, 9, 3};
		for(int i=0; i<arr.length; i++) {
			push(arr[i]);
		}
		
		System.out.println("Minimum = " +minimum());
		System.out.println("Popped = "+pop());
		System.out.println("Minimum = " +minimum());
		System.out.println("Popped = "+pop());
		System.out.println("Minimum = " +minimum());
		System.out.println("Popped = "+pop());
		System.out.println("Minimum = " +minimum());
	}	
	
	private static int pop() {
		if(stack.isEmpty()) return -1;
		
		int x = stack.pop();
		if(x > min) return x;
		
		else {
			int y = min;
			min = 2 * y - x;
			return y;
		}
	}

	/**
	 * @return
	 */
	private static int minimum() {
		return min;
	}

	/**
	 * @param i
	 */
	private static void push(int x) {
		if(stack.isEmpty()) {
			min = x;
			stack.push(x);
		}
		
		else if(x > min) stack.push(x);
		
		else {
			stack.push(2 * x - min);
			min = x;
		}
	}
}
