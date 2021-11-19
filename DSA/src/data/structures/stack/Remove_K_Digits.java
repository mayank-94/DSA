/**
 * 
 */
package data.structures.stack;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class Remove_K_Digits {

	public static void main(String[] args) {
		String num = "4132";
		int k = 2;
		
		Stack<Character> stack = new Stack<>();
        int i=0;
        for(i=0; i<num.length(); i++){
            char c = num.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && stack.peek() > c) {
            	stack.pop();
            	k--;
            }
            
            stack.push(c);
        }
        
        while(k > 0) {
        	stack.pop();
        	k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        
        sb = sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0') {
        	sb = sb.deleteCharAt(0);
        }
        System.out.println(sb.toString());
	}
}
