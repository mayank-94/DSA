/**
 * 
 */
package data.structures.stack;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class NextSmaller_Right {

	public static void main(String[] args) {
		int arr[] = {6, 2, 5, 4, 5, 1, 6};
		int n = arr.length;
		int nsr[] = new int[n];
		int top = n-1;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=n-1; i>=0; i--) {
			if(stack.isEmpty()) {
				nsr[top] = -1;
			}else if(stack.peek() < arr[i]) {
				nsr[top] = stack.peek();
			}else {
				while(!stack.isEmpty() && stack.peek() > arr[i])
					stack.pop();
				
				if(stack.isEmpty())
					nsr[top] = -1;
				else nsr[top] = stack.peek();
			}
			top--;
			stack.push(arr[i]);
		}
		
		for(int x : nsr)
			System.out.print(x+" ");
	}
}
