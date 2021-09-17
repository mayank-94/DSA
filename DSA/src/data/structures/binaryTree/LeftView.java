/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class LeftView {
	static Node root;
	static int maxLevel = 0;
	
	public static void main(String[] args) {
		createTree();
		leftView(root, 1);
	}
	
	static void leftView(Node root, int level) {
		if(root == null)
			return;
		
		if(maxLevel < level) {
			System.out.print(root.data+" ");
			maxLevel = level;
		}
		leftView(root.left, level+1);
		leftView(root.right, level+1);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}
}
