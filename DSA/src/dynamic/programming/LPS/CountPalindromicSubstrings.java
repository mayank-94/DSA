package dynamic.programming.LPS;

public class CountPalindromicSubstrings {
	public static void main(String[] args) {
		String a = "ababde";
		int x = a.length();
		boolean t[][] = new boolean[x][x];
		int counter = 0;
		
		for(int i=0; i<x; i++) {
			t[i][i] = true;
			counter++; //each character is a palindrome in itself
		}
		
		for(int i=x-2; i>=0; i--) {
			for(int j=i+1; j<x; j++) {
				if(a.charAt(i) == a.charAt(j)) {
					if(t[i+1][j-1] || j-i == 1) {
						t[i][j] = true;
						counter++;
					}
				}
			}
		}
		
		System.out.println(counter);
	}	
}
