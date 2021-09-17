/**
 * 
 */
package recursion;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class Delete_Middle_Of_Stack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(4);
		stack.push(6);
		
		int k = stack.size()/2 + 1;
		delete(stack, k);
		System.out.println(stack);
	}

	/**
	 * @param stack
	 * @param k
	 */
	private static void delete(Stack<Integer> stack, int k) {
		if(k == 1) {
			stack.pop();
			return;
		}
		
		int temp = stack.pop();
		delete(stack, k-1);
		stack.push(temp);
	}
}
