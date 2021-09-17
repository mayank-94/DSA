/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class BoundaryTraversal {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		System.out.print(root.data+" ");
		printLeft(root.left);
		printLeaf(root.left);
		printLeaf(root.right);
		printRight(root.right);
	}
	
	static void printRight(Node root) {
		if(root == null) return;
		
		if(root.right != null) {
			printRight(root.right);
			System.out.print(root.data+" ");
		}else if(root.left != null) {
			printRight(root.left);
			System.out.print(root.data+" ");
		}
	}
	
	static void printLeft(Node root) {
		if(root == null) return;		
		if(root.left != null) {
			System.out.print(root.data+" ");
			printLeft(root.left);
		}
		
		else if(root.right != null) {
			System.out.print(root.data+" ");
			printLeft(root.right);
		}	
	}
	
	static void printLeaf(Node root) {
		if(root == null) return;
		
		printLeaf(root.left);
		if(root.left == null && root.right == null)
			System.out.print(root.data+" ");
		printLeaf(root.right);
	}
	
	static void createTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.right = new Node(3);
		root.right.left = new Node(8);
		root.left.right.left = new Node(15);
		root.right.left.right = new Node(11);
	}
}
