/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class TreeHeight {
	static Node root;

	public static void main(String[] args) {
		createTree();
		System.out.println("Height of tree : "+height(root));
	}
	
	static int height(Node root) {
		if(root == null) return 0;
		
		int lH = 1 + height(root.left);
		int rH = 1 + height(root.right);
		return Math.max(lH, rH);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
