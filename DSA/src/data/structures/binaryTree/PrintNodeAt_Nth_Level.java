/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
public class PrintNodeAt_Nth_Level {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		printAtLevel(root, 2);
	}
	
	static void printAtLevel(Node root, int level) {
		if(root == null) return;
		
		if(level == 1)
			System.out.print(root.data+" ");
		
		printAtLevel(root.left, level - 1);
		printAtLevel(root.right, level - 1);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
