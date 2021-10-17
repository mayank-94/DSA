/**
 * 
 */
package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class TimedHashMap {

	public static void main(String[] args) {
		TimeMap tm = new TimeMap();
		tm.set("foo", "bar", 1);
		//System.out.println(tm.get("foo", 1));
		//System.out.println(tm.get("foo", 3));
		tm.set("foo", "bar2", 4);
		tm.set("foo", "bar3", 5);
		tm.set("foo", "bar4", 6);
		System.out.println(tm.get("foo", 7));
	}
}

class Timestamp{
	int time;
	String value;
	
	public Timestamp(int time, String value) {
		this.time = time;
		this.value = value;
	}
}

class TimeMap{
	Map<String, ArrayList<Timestamp>> tm;
	
	public TimeMap() {
		tm = new HashMap<>();
	}
	
	//O(1)
	public void set(String key, String value, int timestamp) {
		tm.computeIfAbsent(key, x -> new ArrayList<>());
		tm.get(key).add(new Timestamp(timestamp, value));
	}
	
	//O(logn)
	public String get(String key, int timestamp) {
		if(!tm.containsKey(key)) return "";
		int index = binarySearch(tm.get(key), timestamp);
		return tm.get(key).get(index).value;
	}

	private int binarySearch(ArrayList<Timestamp> arrayList, int timestamp) {
		int l = 0, r = arrayList.size() - 1, idx = -1;
		while(l <= r) {
			int m = l + (r - l )/2;
			int x = arrayList.get(m).time;
			if(x == timestamp) return m;
			
			else if(x > timestamp) r = m - 1;
			
			else {
				l = m + 1;
				idx = m;
			}
		}
		return idx;
	}
}