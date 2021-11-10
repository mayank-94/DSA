/**
 * 
 */
package data.structures.arrays;

/**
 * @author mayankjain
 *
 */
public class RunLength_Encoding {

	public static void main(String[] args) {
		String s = "aaabba";
		int counter = 0;
		char prev = 0;
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (prev == c)
				counter++;
			
			else {
				if(prev!=0) sb.append(counter).append(prev);
				
				prev = c;
				counter = 1;
			}		
		}
		sb.append(counter).append(prev);
		System.out.println(sb.toString());
	}
}
