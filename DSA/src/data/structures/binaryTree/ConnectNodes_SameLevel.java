/**
 * 
 */
package data.structures.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mayankjain
 *
 */
class MyNode {
	int data;
	MyNode left, right, nextRight;

	MyNode(int item){
	   data = item;
	   left = right = nextRight = null;
	}
}

public class ConnectNodes_SameLevel {
	static MyNode root;
	
	public static void main(String[] args) {
		createTree();
		connect(root);
	}
	
	static void connect(MyNode root) {
		if(root == null) return;
		Queue<MyNode> q = new LinkedList<MyNode>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			MyNode n = q.poll();
			if(n != null) {
				n.nextRight = q.peek();
				
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}else if(!q.isEmpty()) {
				q.add(null);
			}
		}
	}
	
	static void createTree(){
		root = new MyNode(1);
		root.left = new MyNode(2);
		root.right = new MyNode(3);
	}
}
