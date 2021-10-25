/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class LongestSubstring_K_Repeating_Characters {

	public static void main(String[] args) {
		String s = "ababbcbbdadadee";
		int k = 2;
		System.out.println(longestSubstring(s, k, 0, s.length()));
	}

	/**
	 * @param s
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	private static int longestSubstring(String s, int k, int start, int end) {
		int left, right;
		int []count = new int[26];
		for(int i=start; i<end; i++)
			count[s.charAt(i) - 'a']++;
		
		for(int i=start; i<end; i++) {
			if(count[s.charAt(i) - 'a'] < k) {
				left = longestSubstring(s, k, start, i);
				
				right = longestSubstring(s, k, i + 1, end);
				
				return Math.max(left, right);
			}
		}
		
		return end - start;
	}
}
