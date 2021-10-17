/**
 * 
 */
package data.structures.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mayankjain
 *
 */
public class Employees_Under_Manager {
	static Map<String, Integer> result = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		populateResult(dataSet);
		System.out.println(result);
	}

	/**
	 * @param dataSet
	 */
	private static void populateResult(Map<String, String> dataSet) {
		Map<String, List<String>> managerEmp = new HashMap<String, List<String>>();
		
		dataSet.forEach((k, v) -> {
			if(!k.equals(v))
				managerEmp.computeIfAbsent(v, x -> new ArrayList<>()).add(k);
		});
		
		for(String mgr : dataSet.keySet())
			populateResultUtil(mgr, managerEmp);
	}

	/**
	 * @param mgr
	 * @param managerEmp
	 */
	private static int populateResultUtil(String mgr, Map<String, List<String>> managerEmp) {
		int count = 0;
		
		if(!managerEmp.containsKey(mgr)) {
			result.put(mgr, 0);
			return 0;
		}
		
		else if(result.containsKey(mgr)) count = result.get(mgr);
		
		else {
			List<String> directEmp = managerEmp.get(mgr);
			count = directEmp.size();
			for(String emp : directEmp)
				count+=populateResultUtil(emp, managerEmp);
			
			result.put(mgr, count);
		}
		return count;
	}
}
