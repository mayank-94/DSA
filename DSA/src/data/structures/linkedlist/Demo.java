/**
 * 
 */
package data.structures.linkedlist;

/**
 * @author mayankjain
 *
 */
public class Demo {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		test(head);
	}
	
	/**
	 * @param head
	 */
	private static void test(Node<Integer> head) {
		if(head == null) return;
		System.out.println(head.data+" ");
		if(head.next!=null)
			test(head.next.next);
		System.out.println(head.data+" ");
	}

	private static void createNode() {
		head = new Node<>(1);
		head.next = new Node<>(2);
		head.next.next = new Node<>(3);
		head.next.next.next = new Node<>(4);
		head.next.next.next.next = new Node<>(5);
		head.next.next.next.next.next = new Node<>(6);
	}

}
