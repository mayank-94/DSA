/**
 * 
 */
package data.structures.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
public class LevelOrder_Traversal {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		levelTraversal(root);
	}
	
	static void levelTraversal(Node root) {
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node != null)
				System.out.print(node.data+" ");
			
			if(node.left != null)
				queue.add(node.left);
			
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}
}
