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
public class Maximim_Width {
	static Node root;
	
	public static void main(String[] args) {
		createTree();
		System.out.println(getMaxWidth(root));
	}
	
	static int getMaxWidth(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()){
            int width = q.size();
            max = Math.max(max, width);
            while(width > 0){
                Node n = q.poll();
                
                if(n.left!=null) q.add(n.left);
                
                if(n.right!=null) q.add(n.right);
                
                width--;
            }
        }
        
        return max;
    }
	
	static void createTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
	}
}
