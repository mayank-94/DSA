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
class Box{
    int l, w, h;
    
    public Box(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
}

public class BoxStackingProblem{ 
	public static void main(String[] args) {
		int n = 5;
		int height[] = {9, 9, 5, 2, 8};
		int width[] = {8, 4, 5, 4, 6};
		int length[] = {2, 3, 7, 5, 4};
		
		int maxHeight = maxHeight(height, width, length, n);
		System.out.println(maxHeight);
	}
	
	public static int maxHeight(int[] height, int[] width, int[] length, int n){
        List<Box> boxes = new ArrayList<>();
        for(int i=0; i<n; i++){
            Box b = new Box(length[i], width[i], height[i]);
            boxes.add(b);
        }
        
        List<Box> rotations = createRotations(boxes);
        Collections.sort(rotations, (x, y) -> ((y.l * y.w) - (x.l * x.w)));
        int t[] = new int[rotations.size()];
        for(int i=0; i<rotations.size(); i++) {
        	int max = 0;
        	for(int j=0; j<i; j++) {
        		if(rotations.get(i).l < rotations.get(j).l && 
        				rotations.get(i).w < rotations.get(j).w) {
        			max = Math.max(max, t[j]);
        		}
        	}
        	
        	t[i] = max + rotations.get(i).h;
        }
        return Arrays.stream(t).max().getAsInt();
    }

	private static List<Box> createRotations(List<Box> boxes) {
		List<Box> rotations = new ArrayList<Box>();
		for (Box box : boxes) {
			rotations.add(new Box(Math.max(box.l, box.w), Math.min(box.l, box.w), box.h));
			
			rotations.add(new Box(Math.max(box.l, box.h), Math.min(box.l, box.h), box.w));
			
			rotations.add(new Box(Math.max(box.w, box.h), Math.min(box.w, box.h), box.l));
		}
		return rotations;
	}
}
