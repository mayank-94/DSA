package data.structures.linkedlist;

public class RearrangeOddEven {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		traverse(head);
		rearrange(head);
		traverse(head);
	}
	
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	private static void rearrange(Node<Integer> head) {
		Node<Integer> odd = head, even = head.next, evenHead = head.next;
		
		if(even == null || even.next == null)
			return;
		
		while(even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			
			odd = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
	}

	private static void traverse(Node<Integer> result) {
		while(result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
		System.out.println();
	}
	
	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(9);
		//head.next.next.next.next.next = new Node<>(1);
	}
}
