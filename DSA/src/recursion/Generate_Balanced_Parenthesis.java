/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class Generate_Balanced_Parenthesis {

	public static void main(String[] args) {
		int n = 3;
		int open = n, closed = n;
		List<String> list = new ArrayList<>();
		String output = "";
		
		generateParen(open, closed, output, list);
		System.out.println(list);
	}

	/**
	 * @param open
	 * @param closed
	 * @param output
	 * @param list
	 */
	private static void generateParen(int open, int closed, String output, List<String> list) {
		if(open == 0 && closed == 0) {
			list.add(output);
			return;
		}
		
		if(open != 0) {
			String output2 = output;
			output2 = output2 + "(";
			generateParen(open - 1, closed, output2, list);
		}
		
		if(closed > open) {
			String output2 = output;
			output2 = output2 + ")";
			generateParen(open, closed - 1, output2, list);
		}
	}
}
