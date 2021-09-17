/**
 * 
 */
package recursion;

/**
 * @author mayankjain
 *
 */
public class Letter_Case_Permutation {

	public static void main(String[] args) {
		String input = "a1b";
		String output = "";
		
		permutations(input, output);
	}

	private static void permutations(String input, String output) {
		if(input.isEmpty() || input == "") {
			System.out.print(output+" ");
			return;
		}
		
		int n = input.charAt(0);
		if(n >= 48 && n <= 57) {
			String op1 = output;
			op1 = output + input.charAt(0);
			input = input.substring(1);
			permutations(input, op1);
		}else {
			String op1 = output;
			String op2 = output;
			String c = "" + input.charAt(0);
			op1 = op1 + c.toLowerCase();
			op2 = op2 + c.toUpperCase();
			input = input.substring(1);
			permutations(input, op1);
			permutations(input, op2);
		}
	}
}
