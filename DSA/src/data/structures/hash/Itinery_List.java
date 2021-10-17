/**
 * 
 */
package data.structures.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author mayankjain
 *
 */
public class Itinery_List {

	public static void main(String[] args) {
		Map<String, String> dataset = new HashMap<String, String>();
		dataset.put("Chennai", "Banglore");
		dataset.put("Mumbai", "Delhi");
		dataset.put("Goa", "Chennai");
		dataset.put("Delhi", "Goa");
		
		printItinery(dataset);
	}

	/**
	 * @param dataset
	 */
	private static void printItinery(Map<String, String> dataset) {
		Map<String, String> reverseDataset = new HashMap<String, String>();
		dataset.forEach((key, value) -> reverseDataset.put(value, key));
		String start = null;
		
		for(Entry<String, String> entry : dataset.entrySet()) {
			if(!reverseDataset.containsKey(entry.getKey())) {
				start = entry.getKey();
				break;
			}
		}
		
		while(dataset.size() > 0) {
			String value = dataset.get(start);
			System.out.println(start+"->"+value);
			dataset.remove(start);
			start = value;
		}
	}
}
