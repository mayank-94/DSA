/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class LongestZigZagPath {
	static Node root;
	static int max = 0;
	
	public static void main(String[] args) {
		createTree();
		longestZigZag(root, true);
		System.out.println(max);
	}
	
	/**
	 * @param root
	 * @return
	 */
	private static int longestZigZag(Node root, boolean rightDirection) {
		if(root == null) return 0;
		
		int left = longestZigZag(root.left, false);
		int right = longestZigZag(root.right, true);
		
		max = Math.max(max, Math.max(left, right));
		return rightDirection ? left + 1 : right + 1;
	}

	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(9);
		root.left.right = new Node(5);
		root.left.right.left = new Node(4);
	}
}
