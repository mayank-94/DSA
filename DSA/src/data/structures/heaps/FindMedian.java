/**
 * 
 */
package data.structures.heaps;

import java.util.PriorityQueue;

/**
 * @author mayankjain02
 *
 */
public class FindMedian {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

	public static void main(String[] args) {
		int x = 1;
		while (x <= 2) {
			addNum(x);
			System.out.println(findMedian());
			x++;
		}
	}

	public static double findMedian() {
		if (minHeap.size() == maxHeap.size())
			return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;

		else if (minHeap.size() > maxHeap.size())
			return (minHeap.peek());

		else// if()
			return (maxHeap.peek());

	}

	public static void addNum(int num) {
		if (maxHeap.isEmpty() || num < maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);

		if (maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());

		else if (minHeap.size() > maxHeap.size() + 1)
			maxHeap.add(minHeap.poll());
	}
}
