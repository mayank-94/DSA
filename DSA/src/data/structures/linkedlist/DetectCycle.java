/**
 * 
 */
package data.structures.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mayankjain
 *
 */
public class DetectCycle {
	
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		boolean isCycle = detectCycle(head);
		System.out.println(isCycle);
		System.out.println(detectCycleUsingSet(head));
	}
	
	/*
	 *  Time Complexity - O(n)
	 *  Space Complexity - O(1)
	 */
	private static boolean detectCycle(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	/*
	 *  Time Complexity - O(n)
	 *  Space Complexity - O(n)
	 */
	private static boolean detectCycleUsingSet(Node<Integer> head) {
		Set<Node<Integer>> set = new HashSet<>();
		while(head != null) {
			if(!set.contains(head)) {
				set.add(head);
				head = head.next;
			}else {
				return true;
			}
		}
		return false;
	}
	
	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = head.next.next;
	}
}
