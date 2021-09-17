/**
 * 
 */
package data.structures.sorting;

/**
 * @author mayankjain
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {4, 1, 3, 9, 17, 12, 15, 23, 20, 5, 11, 21, 25, 65, 43, 23, 54, 19};
		int low = 0;
		int high = arr.length - 1;
		System.out.println(System.currentTimeMillis());
		mergeSort(low, high, arr);
		System.out.println(System.currentTimeMillis());
		for (int x : arr) {
			System.out.print(x+" ");
		}
	}

	/**
	 * @param low
	 * @param high
	 * @param arr
	 */
	private static void mergeSort(int low, int high, int[] arr) {
		if(low == high) 
			return;
		
		int mid = low + (high - low) / 2;
		
		Thread t1 = new Thread(() -> {
			mergeSort(low, mid, arr);
		});
		
		Thread t2 = new Thread(() -> {
			mergeSort(mid+1, high, arr);
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		merge(low, mid, high, arr);
		
	}

	/**
	 * @param low
	 * @param mid
	 * @param high
	 * @param arr
	 */
	private static void merge(int low, int mid, int high, int[] arr) {
		int m = mid - low + 1, n = high - mid;
		int c1[] = new int[m];
		for(int i=0; i<m; i++)
			c1[i] = arr[low + i];
		
		int c2[] = new int[n];
		for(int i=0; i<n; i++) 
			c2[i] = arr[mid + 1 + i];
		
		int i=0, j=0, k=low;
		while(i < m && j < n) {
			if(c1[i] < c2[j]) {
				arr[k] = c1[i];
				i++;
				k++;
			}else {
				arr[k] = c2[j];
				j++;
				k++;
			}
		}
		
		while(i < m) {
			arr[k] = c1[i];
			i++;
			k++;
		}
		
		while(j < n) {
			arr[k] = c2[j];
			j++;
			k++;
		}
		
	}
}
