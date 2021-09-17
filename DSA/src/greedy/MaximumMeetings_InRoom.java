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
public class MaximumMeetings_InRoom {

	public static void main(String[] args) {
		int s[] = {1, 3, 0, 5, 8, 5};
		int f[] = {2, 4, 5, 6, 9, 9};
		int n = s.length;
		List<Meeting> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(new Meeting(s[i], f[i], i));
		
		Collections.sort(list, (a, b) -> a.end - b.end);
		//System.out.println(list);
		int k=0;
		System.out.print(k+" ");
		
		for(int i=1; i<n; i++) {
			if(list.get(i).start >= list.get(k).end) {
				k = i;
				System.out.print(k+" ");
			}
		}
	}
}

class Meeting{
	int start, end, pos;
	
	public Meeting(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + ", " + pos + "]";
	}
}
