/**
 * 
 */
package dynamic.programming.mcm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class BooleanExpression {
	private static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		String str = "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T";
		int len = str.length();
		int i=0, j=len-1;
		boolean isTrue = true;
		
		int ways = maxWays(str, i, j, isTrue);
		System.out.println(ways);
	}

	private static int maxWays(String str, int i, int j, boolean isTrue) {
		String key = null;
		if(i > j) return 0;
		if(i == j) {
			if(isTrue == true) return str.charAt(i) == 'T' ? 1 : 0;
			else return str.charAt(i) == 'F' ? 1 : 0;
		}
		
		key = new StringBuilder()
				.append(i).append("_")
				.append(j).append("_")
				.append(isTrue).toString();
		if(map.containsKey(key)) return map.get(key);
		
		int result = 0;
		for(int k=i+1; k<=j-1; k=k+2) {
			int leftTrue = maxWays(str, i, k-1, true)%1003;
			int leftFalse = maxWays(str, i, k-1, false)%1003;
			int rightTrue = maxWays(str, k+1, j, true)%1003;
			int rightFalse = maxWays(str, k+1, j, false)%1003;
			
			if(str.charAt(k) == '&') {
				if(isTrue == true)
					result = (result + leftTrue * rightTrue)%1003;
				else
					result = (result + leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse)%1003;
			}
			else if(str.charAt(k) == '|') {
				if(isTrue == true)
					result = (result + leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue)%1003;
				else 
					result = (result + leftFalse * rightFalse)%1003;
			}
			else if(str.charAt(k) == '^') {
				if(isTrue == true)
					result = (result + leftTrue * rightFalse + leftFalse * rightTrue)%1003;
				else
					result = (result + leftTrue * rightTrue + leftFalse * rightFalse)%1003;
			}
		}
		key = new StringBuilder()
				.append(i).append("_")
				.append(j).append("_")
				.append(isTrue).toString();
		map.put(key, result);
		return result;
	}
}
