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
public class Root_To_Leaf_Paths {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<>();
		printPaths(root, list, result);
		System.out.println(result);
	}
	
	/**
	 * @param root
	 */
	private static boolean printPaths(Node root, List<Integer> list, List<List<Integer>> result) {
		if(root == null) return false;
		
		list.add(root.data);
		if(root.left == null && root.right == null) {
			List<Integer> temp = new ArrayList<>();
			for(int x : list) temp.add(x);
			result.add(temp);
		}
		
		if(printPaths(root.left, list, result) || printPaths(root.right, list, result))
			return true;
		
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
