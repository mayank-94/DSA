/**
 * 
 */
package data.structures.linkedlist;

/**
 * @author mayankjain
 *
 */
public class ReverseLinkedList {
	
	static Node<Double> head;
	
	public static void main(String[] args) {
		createNode();
		traverse();
		reverse();
		traverse();
	}
	
	private static void reverse() {
		Node<Double> prev = null, next = null, current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	private static void traverse() {
		Node<Double> temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private static void createNode() {
		head = new Node<>(5.0);
		head.next = new Node<>(2.0);
		head.next.next = new Node<>(8.0);
		head.next.next.next = new Node<>(3.0);
	}

}
