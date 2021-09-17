package data.structures.linkedlist;

import java.util.Objects;

public class ReturnNthNodeFromEnd {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		Node<Integer> nthNode = findNthNode(head, 3);		
		if(Objects.nonNull(nthNode))
			System.out.println(nthNode.data);
	}
	
	private static Node<Integer> findNthNode(Node<Integer> head, int n) {
		if(head == null) return null;
		Node<Integer> firstPointer = head;
		while(n-- > 0) {
			firstPointer = firstPointer.next;
		}
		
		if(firstPointer == null) {
			Node<Integer> temp = head;
			head = head.next;
			return temp;
		}
		Node<Integer> secondPointer = head;
		while(firstPointer != null && secondPointer != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		return secondPointer;
	}

	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(1);
	}
}
