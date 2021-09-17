/**
 * 
 */
package data.structures.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class MinimumDistance_BetweenNodes {
	static Node root;
	static List<Node> list1 = new ArrayList<Node>();
	static List<Node> list2 = new ArrayList<Node>();
	
	public static void main(String[] args) {
		createTree();
		Node lca = lca(root, 3, 5);
		int d1 = level(lca, 3, 0);
		int d2 = level(lca, 5, 0);
		
		System.out.println(d1+d2);
	}

	static int level(Node lca, int x, int level) {
		if(lca == null) return -1;
		
		if(lca.data == x) return level;
		
		int left = level(lca.left, x, level + 1);
		if(left == -1)
			return level(lca.right, x, level + 1);
		
		return left;
	}
	
	static Node lca(Node root, int a, int b) {
		if(root == null) return null;
		hasPath(root, a, list1);
		hasPath(root, b, list2);
		
		int i;
		for(i=0; i<list1.size() && i<list2.size(); i++)
			if(!list1.get(i).equals(list2.get(i)))
				break;
		
		return list1.get(i-1);
	}
	
	static boolean hasPath(Node root, int x, List<Node> list) {
		if(root == null) return false;
		
		list.add(root);
		if(root.data == x) return true;
		
		if(hasPath(root.left, x, list) || hasPath(root.right, x, list)) return true;
		
		list.remove(list.size() - 1);
		return false;
	}
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}
}
