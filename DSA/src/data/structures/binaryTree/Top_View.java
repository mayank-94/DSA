/**
 * 
 */
package data.structures.binaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author mayankjain
 *
 */
public class Top_View {
	static TreeNode root;
	
	public static void main(String[] args) {
		createTree();
		topView(root);
	}
	
	static void topView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int h = node.ht;
			
			if(!map.containsKey(h)) 
				map.put(h, node.data);
			
			if(node.left != null) {
				node.left.ht = h - 1;
				queue.add(node.left);
			}
			
			if(node.right != null) {
				node.right.ht = h + 1;
				queue.add(node.right);
			}
		}
		
		map.values().forEach(x -> System.out.print(x+" "));
	}
	
	static void createTree(){
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
	}
}
