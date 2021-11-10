/**
 * 
 */
package data.structures.stack;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class Remove_All_Occurrences_String {
	
	public static void main(String[] args) {
		String s = "abdc", p = "abc";
		Stack<Character> stack = new Stack<>();
		int idx = p.length() - 1;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			stack.push(c);
			
			while(idx >= 0 && !stack.isEmpty() && stack.peek() == p.charAt(idx)) {
				stack.pop();
				idx--;
			}
			
			while(idx >= 0 && idx + 1 < p.length()) {
				stack.push(p.charAt(idx+1));
				idx++;
			}
			
			idx = p.length() - 1;
		}
		
		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
	}
}
