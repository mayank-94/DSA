/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class SumOfNodes {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		int sum = sum(root);
		System.out.println("Sum of all Nodes : "+sum);
	}
	
	static int sum(Node root) {
		if(root == null)
			return 0;
		
		return root.data + sum(root.left) + sum(root.right);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
