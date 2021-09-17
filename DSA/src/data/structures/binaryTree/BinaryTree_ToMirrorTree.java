/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class BinaryTree_ToMirrorTree {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		inOrder(root);
		mirror(root);
		System.out.println();
		inOrder(root);
	}
	
	static void mirror(Node root) {
		if(root == null)
			return;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirror(root.left);
		mirror(root.right);
	}
	
	static void inOrder(Node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
	}
}
