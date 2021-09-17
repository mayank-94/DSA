/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain
 *
 */
class MyCharNode {
	char data;
	MyCharNode left, right;
	
	MyCharNode(char data){
		this.data = data;
		left = right = null;
	}
}

public class ConstructTree_InOrder_PreOrder {
	static MyCharNode root;
	static int index = 0;
	
	public static void main(String[] args) {
		char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
		char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
		int len = in.length;
		
		root = buildTree(in, pre, 0, len-1);
		inOrder(root);
	}
	
	static void inOrder(MyCharNode root) {
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	private static MyCharNode buildTree(char[] in, char[] pre, int start, int end) {
		if(start > end) return null;
		
		MyCharNode node = new MyCharNode(pre[index++]);
		if(start == end) return node;
		int index = search(in, start, end, node.data);
		
		node.left = buildTree(in, pre, start, index-1);
		node.right = buildTree(in, pre, index+1, end);
		
		return node;
	}

	private static int search(char[] in, int start, int end, int data) {
		int i;
		for(i=start; i<=end; i++) {
			if(data == in[i])
				break;
		}
		return i;
	}
}
