package data.structures.linkedlist;

public class ReturnCyclicNode {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		Node<Integer> cycle = detectCycle(head);
		System.out.println(cycle.data);
	}
	
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private static Node<Integer> detectCycle(Node<Integer> head) {
		Node<Integer> slow = head, fast = head, current = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				while(current != slow) {			
					current = current.next;
					slow = slow.next;
				}
				return current;
			}	
		}
		
		return null;
	}

	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(1);
		head.next.next.next.next.next = head;
	}
}
