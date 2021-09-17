package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Record{
	int key;
	String value;
	
	public Record(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {
	Deque<Record> deque = new LinkedList<>();
	Map<Integer, Record> hash = new HashMap<>();
	int CACHE_SIZE = 3;
	
	public String readCache(int key) {
		if(hash.containsKey(key)) {
			Record record = hash.get(key);
			deque.remove(record);
			deque.addFirst(record);
			return record.value;
		}
		return null; //Not in cache, fetch from DB
	}
	
	public void writeInCache(int key, String value) {
		if(hash.containsKey(key)) {
			Record record = hash.get(key);
			deque.remove(record);
		}else {
			if(deque.size() == CACHE_SIZE) {
				Record removed = deque.removeLast();
				hash.remove(removed.key);
			}
		}
		
		Record record = new Record(key, value);
		deque.addFirst(record);
		hash.put(key, record);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.writeInCache(1, "Product - 1");
		cache.writeInCache(2, "Product - 2");
		cache.writeInCache(3, "Product - 3");
		cache.writeInCache(4, "Product - 4");
		
		System.out.println(cache.readCache(1));
		System.out.println(cache.readCache(3));
	}
}
