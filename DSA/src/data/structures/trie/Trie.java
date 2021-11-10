/**
 * 
 */
package data.structures.trie;

/**
 * @author mayankjain
 *
 */
public class Trie {
	//considering lower case only
	private static final int ALPHABET_SIZE = 26;
	
	static class Node{
		Node[] children = new Node[ALPHABET_SIZE];
		boolean isWord;
		
		Node() {
			isWord = false;
			for(int i=0; i<ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}
	
	static Node root;
	
	static void insert(String key) {
		int n = key.length();
		int index;
		Node node = root;
		
		for(int i=0; i<n; i++) {
			index = key.charAt(i) - 'a';
			if(node.children[index] == null)
				node.children[index] = new Node();
			
			node = node.children[index];
		}
		node.isWord = true;
	}
	
	static boolean search(String key) {
		Node node = root;
		int index;
		int n = key.length();
		
		for(int i=0; i<n; i++) {
			index = key.charAt(i) - 'a';
			
			if(node.children[index] == null) return false;
			node = node.children[index];
		}
		
		return node.isWord;
	}
	
	public static void main(String[] args) {
		String words[] = {"answer", "any",
                "by"};
		root = new Node();
		
		for(String word : words)
			insert(word);
		
		System.out.println(search("answer"));
		System.out.println(search("hello"));
	}
}
