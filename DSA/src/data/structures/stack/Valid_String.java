/**
 * 
 */
package data.structures.stack;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class Valid_String {

	public static void main(String[] args) {
		String S = "((()))";

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			if(c == '(') stack.push(i);
			
			else {
				if(!stack.isEmpty()) stack.pop();
				
				if(!stack.isEmpty()) count = Math.max(count, i - stack.peek());
				
				else stack.push(i);
			}
		}

		System.out.println(count);
	}
}
