package data.structures.linkedlist;

public class ReverseInKGroup {
	static Node<Integer> head;
	
	public static void main(String[] args) {
		createNode();
		Node<Integer> result = reverseInGroup(head, 2);
		traverse(result);
	}
	
	private static Node<Integer> reverseInGroup(Node<Integer> head, int k) {
		int length = getLength(head);
		Node<Integer> result = reverse(head, k, length);
		return result;
	}
	
	 private static Node<Integer> reverse(Node<Integer> head, int k, int length){
	        int count = 0;
	        Node<Integer> prev = null, next = null, current = head;
	        
	        while(current != null && count < k && k <= length){
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	            
	            count++;
	        }
	        if(next != null && (length - k) >= k){
	            head.next = reverse(next, k, length - k);
	        }else {
	        	head.next = next;
	        }        	       
	        return prev;
	    }
	
	private static int getLength(Node<Integer> head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

	private static void createNode() {
		head = new Node<>(5);
		head.next = new Node<>(2);
		head.next.next = new Node<>(8);
		head.next.next.next = new Node<>(3);
		head.next.next.next.next = new Node<>(1);
	}
	
	private static void traverse(Node<Integer> result) {
		while(result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
		System.out.println();
	}
}
