/**
 * 
 */
package design;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author mayankjain
 *
 */
public class HashMap_Design {

	public static void main(String[] args) {
		
	}
}

class HashNode<K, V>{
	K key;
	V value;
	final int hashcode;
	HashNode<K, V> next;
	
	public HashNode(K key, V value, int hashcode) {
		this.hashcode = hashcode;
		this.key = key;
		this.value = value;
	}
}

class Map<K, V>{
	private ArrayList<HashNode<K, V>> buckets;
	private int numBuckets;
	private int size;
	
	public Map() {
		buckets = new ArrayList<HashNode<K,V>>();
		size = 0;
		numBuckets = 5;
		
		for(int i=0; i<numBuckets; i++)
			buckets.add(null);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private final int hashcode(K key) {
		return Objects.hashCode(key);
	}
	
	private int getBucketIndex(K key) {
		int hashcode = hashcode(key);
		int index = hashcode % numBuckets;
		
		index = index < 0 ? index * -1 : index;
		return index;
	}
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashcode(key);
		
		HashNode<K, V> hashNode = buckets.get(bucketIndex);
		while(hashNode != null) {
			if(hashNode.key.equals(key) && hashNode.hashcode == hashcode)
				return hashNode.value;
			
			hashNode = hashNode.next;
		}
		
		return null;
	}
	
	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashcode(key);
		
		HashNode<K, V> hashNode = buckets.get(bucketIndex);
		while(hashNode != null) {
			if(hashNode.key.equals(key) && hashNode.hashcode == hashcode) {
				hashNode.value = value;
				return;
			}
			hashNode = hashNode.next; 
		}
		
		size++;
		hashNode = buckets.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashcode);
		newNode.next = hashNode;
		buckets.set(bucketIndex, newNode);
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashcode = hashcode(key);
		
		HashNode<K, V> hashNode = buckets.get(bucketIndex);
		HashNode<K, V> prev = null;
		while(hashNode != null) {
			if(hashNode.key.equals(key) && hashNode.hashcode == hashcode)
				break;
			
			prev = hashNode;
			hashNode = hashNode.next;
		}
		
		if(hashNode == null) return null;
		size--;
		
		if(prev != null) prev.next = hashNode.next;
		else buckets.set(bucketIndex, hashNode.next);
		
		return hashNode.value;
	}
}
