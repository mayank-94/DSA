/**
 * 
 */
package data.structures.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author mayankjain
 *
 */

class Obj{
    Node node;
    int ht;
    
    Obj(Node node, int ht){
        this.node = node;
        this.ht = ht;
    }
}

public class VerticalTraversal {
	static Node root;

	public static void main(String[] args) {
		createTree();
		verticalView(root);
	}

	static void verticalView(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Obj> queue = new LinkedList<>();
		queue.add(new Obj(root, 0));
		ArrayList<Integer> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			Obj objNode = queue.poll();
			int hd = objNode.ht;

		    map.computeIfAbsent(hd, x -> new ArrayList<>()).add(objNode.node.data);
		    map.put(hd, map.get(hd));
		    
		    if(objNode.node.left != null) {
		    	hd = objNode.ht - 1;
		    	queue.add(new Obj(objNode.node.left, hd));
		    }
		    
		    if(objNode.node.right != null) {
		    	hd = objNode.ht + 1;
		    	queue.add(new Obj(objNode.node.right, hd));
		    }
		}
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> result = entry.getValue();
			for(int x : result)
				list.add(x);
		}
		
		//list = (ArrayList<Integer>) map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(list);
	}

	static void createTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
	}
}
