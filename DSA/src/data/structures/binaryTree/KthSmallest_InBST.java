/**
 * 
 */
package data.structures.binaryTree;

/**
 * @author mayankjain02
 *
 */
public class KthSmallest_InBST {
	static Node root;
	
	static class Height{
	    int ht;
	    int data;
	}
	
	public static void main(String[] args) {
		createTree();
		System.out.println(KthSmallestElement(root, 1));
	}
	
	public static int KthSmallestElement(Node root, int K) {
        Height ht = new Height();
        bstSearch(root, K, ht);
        if(ht.ht == K) return ht.data;
        
        else return -1;
    }
	
	private static void bstSearch(Node root, int k, Height ht){
        if(root == null || ht.ht > k) return;
        
        bstSearch(root.left, k, ht);
        ht.ht++;
        if(ht.ht == k){
            ht.data = root.data;
            return;
        }
        bstSearch(root.right, k, ht);
    }
	
	static void createTree(){
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		root.right.right = new Node(4);
	}

}
