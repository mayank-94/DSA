package data.structures.linkedlist;

public class DeleteWithoutHead {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		traverse(head);
		delete(head.next);
		traverse(head);
	}
	
	private static void delete(Node<Integer> node) {
		Node<Integer> temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp = null;
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
		head.next.next.next.next = new Node<>(1);
	}
}
