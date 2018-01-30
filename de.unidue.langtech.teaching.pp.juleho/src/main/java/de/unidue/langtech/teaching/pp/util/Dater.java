package de.unidue.langtech.teaching.pp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dater {

	public static SimpleDateFormat sdf;
	static ArrayList<String> al;
	static String vorgabe = "Wed Jan 28 19:39:56 +0000 2015";
	static String vorgabe1 = "Wed Jan 28 19:39:59 +0000 2015";
	static ArrayList <Date>datelist;
	static ArrayList <Date>parseddate;
	static List<String> mystring;

	public Dater(ArrayList<String> al) {
		// TODO Auto-generated constructor stub
		al = al;
		datelist=new ArrayList <Date>();
		parseddate=new ArrayList <Date>();
		mystring=new ArrayList<>();
		// System.out.println("DATER" + al);
		sdf = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy", Locale.US);

		// SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss", Locale.US);

		String datum = "Wed Jan 28 19:39:54 +0000 2015";
		String datum1 = "Tue Jan 28 19:39:54 +0000 2015";
		String datum2 = "Thu Jan 29 19:39:54 +0000 2015";

		try {
			
			for(String s:al) {
	    		Date dp = sdf.parse(s);
	    		datelist.add(dp);
	    		//System.out.println("*****************************" + al);
	    	}
			
			Date vg = sdf.parse(vorgabe);
	    	Date vg1 = sdf.parse(vorgabe1);
	    	
	    	for(Date a: datelist) {
	    		//System.out.println(a);
	    		//System.out.println(a.compareTo(vg));
	    		if(a.compareTo(vg)>=0 && a.compareTo(vg1)<=0){
	    			//System.out.println("zwischen " + a);
	    			parseddate.add(a);
	    		}}
	    		
	    		for(Date b: datelist) {
	    			
	                mystring.add(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(b));
	              
	     			//System.out.println(mystring);
	     		}
	    		List<String> animallist = mystring;
	        	System.out.println("animallist " + animallist);
	        	int bibi = countDuplicates(animallist);
	        	System.out.println("Duplicates: " + bibi);
	    		/**

			Date parse = sdf.parse(datum);
			Date ps = sdf.parse(datum2);

			System.out.println(parse);
			System.out.println("Date : " + sdf.format(parse));

			System.out.println(ps.compareTo(parse));
			System.out.println(parse.compareTo(ps));

			System.out.println("datum legal? = " + isLegalDate(datum));
			System.out.println("datum 1 legal? = " + isLegalDate(datum1));
			*/

			// Date dt = sdf1.parse(datum);
			// System.out.println("Date : " + sdf1.format(dt));

			//System.out.println(" 6. " + DateFormat.getTimeInstance(DateFormat.MEDIUM).format(parse));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static int countDuplicates(List<String> cd) {
		int dupCtr = 0;

		// get unique elements using HashSet
		Set<String> as = new HashSet<String>(cd);
		System.out.println("Unique: " + as.toString());

		for (String setElement : as) {
			// returns the number of elements in the specified collection equal to the
			// specified object
			int elementCtr = Collections.frequency(cd, setElement);
			if (elementCtr > 1)
				dupCtr++;
			System.out.println(setElement + ": " + elementCtr);
		}

		return dupCtr;
	}

	static boolean isLegalDate(String s) {
		sdf = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy", Locale.US);
		sdf.setLenient(false);
		return sdf.parse(s, new ParsePosition(0)) != null;
	}

}