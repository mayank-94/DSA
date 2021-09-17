package data.structures.linkedlist;

public class RemoveDuplicateInSorted {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		traverse();
		removeDuplicate(head);
		traverse();
	}
	
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private static void removeDuplicate(Node<Integer> head) {
		while(head.next != null) {
			if(head.data == head.next.data) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
	}

	private static void createNode() {
		head = new Node<>(2);
		head.next = new Node<>(4);
		head.next.next = new Node<>(4);
		head.next.next.next = new Node<>(6);
		head.next.next.next.next = new Node<>(8);
	}
	
	private static void traverse() {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}
