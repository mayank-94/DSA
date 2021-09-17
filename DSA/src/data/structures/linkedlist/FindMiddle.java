package data.structures.linkedlist;

public class FindMiddle {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		Node<Integer> midddle = findMiddle(head);
		System.out.println(midddle.data);
	}
	
	/*
	 *  Time Complexity - O(n)
	 *  Space Complexity - O(1)
	 */
	private static Node<Integer> findMiddle(Node<Integer> head){
		Node<Integer> slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(9);
		head.next.next.next.next.next = new Node<>(1);
	}
}
