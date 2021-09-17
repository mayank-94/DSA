package dynamic.programming.LCS;

/*
 * String a = step, b = tea
 * 
 * Our aim is :  step -> tea, with minimum insertions and deletions
 * 
 * Strategy is to first find LCS i.e 2(te), now minimum insertions in a is 1(a) and minimum deletions
 * in a is 2(s,p).
 * 
 * Minimum insertions = b.length - LCS
 * Minimum deletions = a.length - LCS
 */
public class Min_Insert_DeleteToConvert_A_To_B {
	public static void main(String[] args) {
		String a = "geek", b = "gesek";
		int x = a.length(), y = b.length();
		int t[][] = new int[x+1][y+1];
		
		for(int i=0; i<x+1; i++) {
			for(int j=0; j<y+1; j++) {
				if(i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<x+1; i++) {
			for(int j=1; j<y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		System.out.println("Minimum insertions : "+(y - t[x][y]));
		System.out.println("Minimum deletions : "+(x - t[x][y]));
	}
}
