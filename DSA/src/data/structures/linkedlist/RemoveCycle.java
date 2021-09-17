/**
 * 
 */
package data.structures.linkedlist;

/**
 * @author mayankjain
 *
 */
public class RemoveCycle {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		removeCycle(head);
		traverse(head);
	}
	
	private static void traverse(Node<Integer> result) {
		while(result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
		System.out.println();
	}
	
	private static void removeCycle(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				Node<Integer> slow2 = head, prev = null;;
				while(slow2 != slow) {
					prev = slow;
					slow = slow.next;
					slow2 = slow2.next;
				}
				prev.next = null;
			}
		}
	}
	
	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(1);
		head.next.next.next.next.next = head.next;
	}
}
