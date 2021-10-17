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
		String s = "a";
		char chars[] = s.toCharArray();
		int counter = 0;
		char prev = 0;
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (prev == c)
				counter++;

			else {
				if (prev != 0) {
					if (counter == 1)
						sb.append(prev);

					else if (counter > 9) {
						sb.append(prev);
						StringBuilder temp = new StringBuilder();
						while (counter > 0) {
							int d = counter % 10;
							temp.append(d);
							counter = counter / 10;
						}
						temp.reverse();
						sb.append(temp);
					}

					else
						sb.append(prev).append(counter);
				}
				prev = c;
				counter = 1;
			}
		}
		if (counter == 1)
			sb.append(prev);
		
		else if (counter > 9) {
			sb.append(prev);
			StringBuilder temp = new StringBuilder();
			while (counter > 0) {
				int d = counter % 10;
				temp.append(d);
				counter = counter / 10;
			}
			temp.reverse();
			sb.append(temp);
		}

		else
			sb.append(prev).append(counter);
		
		for(int i=0; i<sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
		
		System.out.println(sb.toString());
	}
}
