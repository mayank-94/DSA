/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class CountAllNodes {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		int count = countNodes(root);
		System.out.println("Number of Nodes are : "+count);
	}
	
	// T-> O(n)
	private static int countNodes(Node root) {
		if(root == null) return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
