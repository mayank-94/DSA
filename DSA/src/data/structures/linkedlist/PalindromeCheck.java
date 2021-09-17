package data.structures.linkedlist;

public class PalindromeCheck {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		System.out.println(checkPalindrome(head));
	}
	
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private static boolean checkPalindrome(Node<Integer> head) {
		Node<Integer> slow = head, fast = head, prev = null, next = null;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;

			next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;	
		}
		Node<Integer> firstHalf = prev, secondHalf = null;
		if(fast != null) {
			secondHalf = slow.next;
		}else {
			secondHalf = slow;
		}
		
		while(firstHalf != null && secondHalf != null) {
			if(firstHalf.data != secondHalf.data)
				return false;
			
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}
		return true;
	}
	
	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(2);
		head.next.next.next.next = new Node<>(5);
	}
}
