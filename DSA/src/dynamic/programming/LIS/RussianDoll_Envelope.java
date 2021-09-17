/**
 * 
 */
package dynamic.programming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mayankjain
 *
 */
public class RussianDoll_Envelope {
	public static void main(String[] args) {
		int[][] envelopes = {{5,4}, {6,4}, {6,7}, {2,3}};
		
		List<Dimensions> list = new ArrayList<>();
        for(int i=0; i< envelopes.length; i++){
            list.add(new Dimensions(envelopes[i][0], envelopes[i][1]));
        }
        
        Collections.sort(list, (x,y) -> (y.w*y.h - x.w*x.h));
        System.out.println(list);
        int  n = list.size();
        int t[] = new int[n];
        t[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(list.get(i).w < list.get(j).w  && 
                    list.get(i).h < list.get(j).h  && t[j] > max){
                    max = t[j];
                }
            }
            
            t[i] = 1 + max;
        }
        
        int max = Arrays.stream(t).max().getAsInt();
        System.out.println(max);
	}
}

class Dimensions{
    int w;
    int h;
    
    public Dimensions(int w, int h){
        this.w = w;
        this.h = h;
    }
    
    @Override
    public String toString(){
        return "{"+ w + "," + h + "}";
    }
}