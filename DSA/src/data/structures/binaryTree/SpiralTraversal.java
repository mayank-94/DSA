/**
 * 
 */
package data.structures.binaryTree;

import java.util.Stack;

/**
 * @author mayankjain
 *
 */
public class SpiralTraversal {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		spiral(root);
	}
	
	static void spiral(Node root) {
		if(root == null)
			return;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node n = s1.pop();
				System.out.print(n.data+" ");
				
				if(n.right!=null) s2.push(n.right);
				if(n.left!=null) s2.push(n.left);
			}
			
			while(!s2.isEmpty()) {
				Node n = s2.pop();
				System.out.print(n.data+" ");
				
				if(n.left!=null) s1.push(n.left);
				if(n.right!=null) s1.push(n.right);
			}
		}
	}
	
	static void createTree(){
		root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(5);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		root.right.left.left = new Node(15);
		root.left.left.right = new Node(18);
	}
}
