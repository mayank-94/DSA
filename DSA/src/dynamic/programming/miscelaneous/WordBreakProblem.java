package dynamic.programming.miscelaneous;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	private static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		String[] wordDict = { "c", "od", "x", "e" };
		String s = "code";

		for (String word : wordDict)
			set.add(word);

		boolean isPossible = recursive(s);
		System.out.println(isPossible);

		boolean isPossibleDp = DP(s);
		System.out.println(isPossibleDp);
	}

	private static boolean DP(String s) {
		int n = s.length();
		boolean t[] = new boolean[n + 1];
		t[0] = true;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (set.contains(s.substring(j, i)) && t[j]) {
					t[i] = true;
					break;
				}
			}
		}

		return t[n];
	}

	private static boolean recursive(String s) {
		int n = s.length();
		if (n == 0)
			return true;

		for (int i = 1; i < n + 1; i++)
			if (set.contains(s.substring(0, i)) && recursive(s.substring(i, n)))
				return true;

		return false;
	}
}
