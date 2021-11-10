/**
 * 
 */
package data.structures.trie;

/**
 * @author mayankjain
 *
 */
public class Word_Boggle {
	private final static int SIZE = 26;
	private static int m, n;
	
	static class Trie{
		Trie[] children = new Trie[SIZE];
		boolean isLeaf;
		
		Trie() {
			isLeaf = false;
			for(int i=0; i<SIZE; i++) {
				children[i] = null;
			}
		}
	}
	
	static void insert(Trie root, String key) {
		int n = key.length();
		int index;
		Trie node = root;
		
		for(int i=0; i<n; i++) {
			index = key.charAt(i) - 'A';
			if(node.children[index] == null)
				node.children[index] = new Trie();
			
			node = node.children[index];
		}
		node.isLeaf = true;
	}

	// T - O(4^(n^2))
	public static void main(String[] args) {
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GEE" };		 
        Trie root = new Trie();
 
        int len = dictionary.length;
        for (int i = 0; i < len; i++)
            insert(root, dictionary[i]);
        
        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };
        
        m = boggle.length;
        n = boggle[0].length;
        findWords(boggle, root);
	}

	/**
	 * @param boggle
	 * @param root
	 */
	private static void findWords(char[][] boggle, Trie root) {
		boolean[][] visited = new boolean[m][n];
		Trie node = root;
		String str = "";
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(node.children[boggle[i][j] - 'A'] != null) {
					str = str + boggle[i][j];
					searchWords(node.children[boggle[i][j] - 'A'], boggle, i, j, visited, str);
					str = "";
				}
			}
		}
	}

	/**
	 * @param node
	 * @param boggle
	 * @param i
	 * @param j
	 * @param visited
	 * @param str
	 */
	private static void searchWords(Trie node, char[][] boggle, int i, int j, boolean[][] visited, String str) {
		if(node.isLeaf)
			System.out.println(str);
		
		if(isSafe(i, j, visited))
			visited[i][j] = true;
		
		for(int k=0; k<SIZE; k++) {
			if(node.children[k] != null) {
				char ch = (char) (k + 'A');
				
				if(isSafe(i, j+1, visited) && boggle[i][j+1] == ch)
					searchWords(node.children[k], boggle, i, j+1, visited, str + ch);
				
				if(isSafe(i, j-1, visited) && boggle[i][j-1] == ch)
					searchWords(node.children[k], boggle, i, j-1, visited, str + ch);
				
				if(isSafe(i+1, j, visited) && boggle[i+1][j] == ch)
					searchWords(node.children[k], boggle, i+1, j, visited, str + ch);
				
				if(isSafe(i-1, j, visited) && boggle[i-1][j] == ch)
					searchWords(node.children[k], boggle, i-1, j, visited, str + ch);
				
				if(isSafe(i+1, j+1, visited) && boggle[i+1][j+1] == ch)
					searchWords(node.children[k], boggle, i+1, j+1, visited, str + ch);
				
				if(isSafe(i-1, j+1, visited) && boggle[i-1][j+1] == ch)
					searchWords(node.children[k], boggle, i-1, j+1, visited, str + ch);
				
				if(isSafe(i+1, j-1, visited) && boggle[i+1][j-1] == ch)
					searchWords(node.children[k], boggle, i+1, j-1, visited, str + ch);
				
				if(isSafe(i-1, j-1, visited) && boggle[i-1][j-1] == ch)
					searchWords(node.children[k], boggle, i-1, j-1, visited, str + ch);
			}
		}
		visited[i][j] = false;
	}

	/**
	 * @param i
	 * @param j
	 * @param visited
	 * @return
	 */
	private static boolean isSafe(int i, int j, boolean[][] visited) {
		if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) return true;
		return false;
	}
}
