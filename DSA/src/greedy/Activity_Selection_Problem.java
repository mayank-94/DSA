/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Activity_Selection_Problem {

	public static void main(String[] args) {
		int start[] = { 1, 3, 2, 5 };
		int end[] = { 2, 4, 3, 6 };
		int n = start.length;
		int count = 0;
		List<Activity> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(new Activity(start[i], end[i]));

		Collections.sort(list, (a, b) -> a.end - b.end);
	    System.out.println(list);
		int k = 0;
		count++;
		for (int i = 1; i < n; i++) {
			if (list.get(i).start >= list.get(k).end) {
				count++;
				k = i;
			}
		}

		System.out.println(count);
	}
}

class Activity {
	int start;
	int end;

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
	}
}
