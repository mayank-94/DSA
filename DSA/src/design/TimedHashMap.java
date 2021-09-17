/**
 * 
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mayankjain
 *
 */
public class TimedHashMap {

	public static void main(String[] args) {
		TimeMap tm = new TimeMap();
		tm.set("foo", "bar", 1);
		System.out.println(tm.get("foo", 1));
		System.out.println(tm.get("foo", 3));
		tm.set("foo", "bar2", 4);
		System.out.println(tm.get("foo", 5));
	}
}

class TimeMap{
	Map<String, TreeMap<Integer, String>> tm;
	
	public TimeMap() {
		tm = new HashMap<>();
	}
	
	public void set(String key, String value, int timestamp) {
		tm.computeIfAbsent(key, x -> new TreeMap<Integer, String>());
		tm.get(key).put(timestamp, value);
	}
	
	public String get(String key, int timestamp) {
		if(!tm.containsKey(key)) return "";
		
		TreeMap<Integer, String> tree = tm.get(key);
		Integer t = tree.floorKey(timestamp);
		if(t == null) return "";
		
		return tree.get(t);
	}
}