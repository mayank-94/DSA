package data.structures.binaryTree;
class TreeNode{
	int ht;
	int data;
	TreeNode left, right;
	
	TreeNode(int data){
		this.data = data;
		this.left = this.right = null;
		this.ht = 0;
	}
}