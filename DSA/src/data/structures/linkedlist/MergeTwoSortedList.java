package data.structures.linkedlist;

public class MergeTwoSortedList {
	static Node<Integer> list1, list2;
	
	public static void main(String[] args) {
		createList1();
		createList2();
		
		Node<Integer> result = merge(list1, list2);
		traverse(result);		
	}
	
	private static void traverse(Node<Integer> result) {
		while(result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
	}

	private static Node<Integer> merge(Node<Integer> list1, Node<Integer> list2) {
		if(list1 == null)
			return list2;
		
		if(list2 == null)
			return list1;
		
		Node<Integer> result = null;
		if(list1.data < list2.data) {
			result = list1;
			result.next = merge(list1.next, list2);
		}else {
			result = list2;
			result.next = merge(list1, list2.next);
		}
		
		return result;
	}

	private static void createList1() {
		list1 = new Node<>(3);
		list1.next = new Node<>(6);
		list1.next.next = new Node<>(7);
	}
	
	private static void createList2() {
		list2 = new Node<>(1);
		list2.next = new Node<>(4);
		list2.next.next = new Node<>(8);
	}
}
