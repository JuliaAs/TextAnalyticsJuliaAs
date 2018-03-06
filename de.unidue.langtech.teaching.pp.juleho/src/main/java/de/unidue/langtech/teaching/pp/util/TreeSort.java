package de.unidue.langtech.teaching.pp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * this class sorts data consisting of a pair of elements
 * the pair of elements has to be made of a key and a value eg. (Int , String)
 * sorting is based on the key but have to be comparable
 */

public class TreeSort {
	static TreeMap<String, Integer>tm;
	HashMap<String, Integer>hm;
	
	//constructor with a map as a parameter
	public TreeSort(Map<String, Integer> m) {
		tm = new TreeMap<String,Integer>();
		
		tm.putAll(m);
		/**
		for (String elem : tm.keySet()) {
			System.out.println(elem + " - " + tm.get(elem));
		hm.put(elem,tm.get(elem));
		
		}*/
		//System.out.println("hm " + hm);
		//System.out.println("tm " + tm);
		//System.out.println("treesort m" + tm);		
		/**
		TreeMap<String, Integer>tm = new TreeMap<String,Integer>();
		tm.put("20:40:39",1);
		tm.put("20:39:39",5);
		tm.put("20:40:40",1);
		tm.put("20:41:39",2);
				for (String elem : tm.keySet())
					System.out.println(elem + " - " + tm.get(elem));
					*/
	}
	//set method
	public static void setArray(Map<String, Integer> m) {
		tm=(TreeMap<String, Integer>) m;		
	}
	//get method
	public TreeMap<String,Integer> getTree(){		
		return tm;
		
	}

}
