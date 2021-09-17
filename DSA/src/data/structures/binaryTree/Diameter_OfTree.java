/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain02
 *
 */
class A{
	int ht;
}

public class Diameter_OfTree {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		A a = new A();
		diameter(root, a);
		System.out.println(a.ht);
		System.out.println(diam(root, a));
	}
	
	static int diam(Node root, A ht) {
		if(root == null) { 
			ht.ht = 0;
			return 0;
		}
		
		A lH = new A(), rH = new A();
		int ld = diam(root.left, lH);
		int rd = diam(root.right, rH);
		int lHeight = lH.ht, rHeight = rH.ht; 
		ht.ht = Math.max(lHeight, rHeight) + 1;
		
		return Math.max(Math.max(ld, rd), lHeight + rHeight + 1);
	}
	
	// T -> O(n)
	static int diameter(Node root, A a) {
		if(root == null) return 0;
		
		int lH = diameter(root.left, a);
		int rH = diameter(root.right, a);
		
		a.ht = Math.max(a.ht, lH + rH + 1);
		return 1 + Math.max(lH, rH);
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}

}
