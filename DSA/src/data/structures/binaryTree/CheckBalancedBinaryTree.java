/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
class Height{
	int ht = 0;
}

public class CheckBalancedBinaryTree {
	static Node root;

	public static void main(String[] args) {
		createTree();
		
		//T -> O(n^2)
		System.out.println(isBalanced(root));
		
		//T -> O(n)
		System.out.println(isBalancedOptimized(root, new Height()));
	}
	
	static boolean isBalancedOptimized(Node root, Height height) {
		if(root == null) {
			height.ht = 0;
			return true;
		}
		
		Height lHeight = new Height(), rHeight = new Height();
		boolean l = isBalancedOptimized(root.left, lHeight);
		boolean r = isBalancedOptimized(root.right, rHeight);
		int lH = lHeight.ht, rH = rHeight.ht;
		height.ht = (lH > rH ? lH : rH) + 1;
		
		return Math.abs(lH - rH) <= 1 && l && r;
	}
	
	static boolean isBalanced(Node root) {
		if(root == null) return true;
		
		int lH = depth(root.left);
		int rH = depth(root.right);
		
		return Math.abs(lH - rH) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	static int depth(Node root) {
		if(root == null) return 0;
		
		int lH = depth(root.left) + 1;
		int rH = depth(root.right) + 1;
		return Math.max(lH, rH);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
	}
}
