/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class LowestCommonAncestor {
	static Node root;

	public static void main(String[] args) {
		createTree();
		Node lca = lca(root, 4, 6);
		System.out.println(lca.data);
	}
	
	/**
	 * @param root2
	 * @return
	 */
	private static Node lca(Node root, int n1, int n2) {
		if(root == null) return null;
		
		if(root.data == n1 || root.data == n2) return root;
		
		Node leftLca = lca(root.left, n1, n2);
		Node rightLca = lca(root.right, n1, n2);
		
		if(leftLca != null && rightLca != null) return root;
		
		return leftLca != null ? leftLca : rightLca;
	}

	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}
}
