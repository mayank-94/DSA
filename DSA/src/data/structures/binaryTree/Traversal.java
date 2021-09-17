/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class Traversal {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		System.out.print("InOrder : ");
		inOrder(root);
		System.out.println();
		System.out.print("PreOrder : ");
		preOrder(root);
		System.out.println();
		System.out.print("PostOrder : ");
		postOrder(root);
	}
	
	//left, root, right
	static void inOrder(Node root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	//root, left, right
	static void preOrder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//left, right, root
	static void postOrder(Node root) {
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
