/**
 * 
 */
package data.structures.linkedlist;

/**
 * @author mayankjain
 *
 */
public class AddTwoNumbers {
	static Node<Integer> head1 = null, head2 = null, result = null;
	
	public static void main(String[] args) {
		head1 = createNode(head1);
		head2 = createNode(head2);
		System.out.print("Head1 : ");
		traverse(head1);
		
		System.out.print("Head2 : ");
		traverse(head2);
		
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		result = add(head1, head2);
		traverse(result);
	}
	
	private static Node<Integer> add(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> result = null, head = null;
		int carry = 0, sum = 0;
		while(head1 != null || head2 != null) {
			sum = carry + (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0);
			carry = sum > 9 ? 1 : 0;
			sum = sum % 10;
			result = new Node<>(sum);
			result.next = head;
			head = result;
			head1 = head1.next;
			head2 = head2.next;
		}
		if(carry > 0) {
			result = new Node<>(carry);
			result.next = head;
			head = result;
		}
		return head;
	}

	private static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> next = null, prev = null, current = head;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static Node<Integer> createNode(Node<Integer> head) {
		head = new Node<>(6);
		head.next = new Node<>(6);
		head.next.next = new Node<>(8);
		return head;
	}
	
	private static void traverse(Node<Integer> result) {
		while(result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
		System.out.println();
	}
}
