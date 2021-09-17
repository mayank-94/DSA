/**
 * 
 */
package data.structures.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Root_To_NodePath {
	static Node root;
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		createTree();
		printNodeToRoot(root, 5, result);
		System.out.println(result);
	}
	
	private static boolean printNodeToRoot(Node root, int x, List<Integer> result) {
		if(root == null) return false;
		
		result.add(root.data);
		if(root.data == x) return true;
		
		if(printNodeToRoot(root.left, x, result) ||
				printNodeToRoot(root.right, x, result)) return true;
		
		result.remove(result.size() - 1);
		return false;
	}

	static void createTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}
}
