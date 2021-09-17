/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class RightView {
	static Node root;
	static int maxLevel = 0;

	public static void main(String[] args) {
		createTree();
		rightView(root, 1);
	}

	private static void rightView(Node root, int level) {
		if(root == null) return;
		
		if(maxLevel < level) {
			System.out.print(root.data+" ");
			maxLevel = level;
		}
		rightView(root.right, level+1);
		rightView(root.left, level+1);
	}

	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}
}
