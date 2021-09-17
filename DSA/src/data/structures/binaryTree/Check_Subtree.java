/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class Check_Subtree {
	static Node tree1, tree2;
	
	public static void main(String[] args) {
		createTree1();
		createTree2();
		System.out.println(isSubtree(tree1, tree2));		
		
	}
	
	static boolean isSubtree(Node tree1, Node tree2) {
		if(tree2 == null) return true;
		if(tree1 == null) return false;
		
		if(isIdentical(tree1, tree2)) return true;
		
		return isSubtree(tree1.left, tree2) || isSubtree(tree1.right, tree2);
	}
	
	static boolean isIdentical(Node tree1, Node tree2) {
		if(tree2 == null && tree2 == null) return true;
		if(tree1 == null || tree2 == null) return false;
		
		if(tree1.data == tree2.data && 
				isIdentical(tree1.left, tree2.left) && 
				isIdentical(tree1.right, tree2.right))
		return true;
		
		return false;
	}
	
	static void createTree1() {
		tree1 = new Node(10);
		tree1.left = new Node(4);
		tree1.right = new Node(6);
		tree1.left.right = new Node(30);
	}
	
	static void createTree2() {
		tree2 = new Node(26);
		tree2.left = new Node(10);
		tree2.right = new Node(3);
		tree2.left.left = new Node(4);
		tree2.left.right = new Node(6);
		tree2.left.left.right = new Node(30);
		tree2.right.right = new Node(3);
	}
}
