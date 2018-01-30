package de.unidue.langtech.teaching.pp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeSort {
	static TreeMap<String, Integer>tm;
	HashMap<String, Integer>hm;
	
	public TreeSort(Map<String, Integer> m) {
		tm = new TreeMap<String,Integer>();
		//hm = new HashMap<String, Integer>();
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
	
	public static void setArray(Map<String, Integer> m) {
		tm=(TreeMap<String, Integer>) m;
		System.out.println("teemapset" + tm);
	}
	public TreeMap<String,Integer> getTree(){
		//System.out.println("getTree " + tm);
		return tm;
		
	}

}
