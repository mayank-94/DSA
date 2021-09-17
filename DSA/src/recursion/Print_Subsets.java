/**
 * 
 */
package recursion;

/**
 * @author mayankjain
 *
 */
public class Print_Subsets {

	public static void main(String[] args) {
		String input = "ABC";
		String output = "";
		
		subsets(input, output);
	}

	/**
	 * @param input
	 * @param output
	 */
	private static void subsets(String input, String output) {
		if(input.isEmpty() || input == "") {
			System.out.print("{"+output+"} ");
			return;
		}
		
		String op1 = output;
		String op2 = output;
		op2 = output + input.charAt(0);
		input = input.substring(1);
		
		subsets(input, op1);
		subsets(input, op2);
	}
}
