package de.unidue.langtech.teaching.pp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * utility class to format the tweet time from string to a comparable date object
 * and count duplicate post time
 *
 */
public class Dater {

	public static SimpleDateFormat sdf;
	static ArrayList<String> raw;
	static String vorgabe = "Wed Jan 28 19:39:56 +0000 2015";
	static String vorgabe1 = "Wed Jan 28 19:39:59 +0000 2015";
	static String vorgabe2 = "Wed May 10 19:45:07 +0000 2017";
	static String vorgabe3 = "Wed May 10 19:45:16 +0000 2017";
	static ArrayList<Date> datelist;
	static ArrayList<Date> parseddate;
	static List<String> mystring;
	static Map<String, Integer> ergebnis;

	public Dater() {		

		datelist = new ArrayList<Date>();
		parseddate = new ArrayList<Date>();
		mystring = new ArrayList<>();

		
		sdf = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy", Locale.US);		

	}

	/**
	 * counts the duplicates of a sample for our chart
	 * eg. a tweet was posted 5 times at the same time
	 * 
	 */
	private static Map<String, Integer> countDuplicates(List<String> cd) {
		int dupCtr = 0;
		ergebnis = new HashMap<String, Integer>();

		// get unique elements using HashSet
		Set<String> as = new HashSet<String>(cd);		

		for (String setElement : as) {
			// returns the number of elements in the specified collection equal to the
			// specified object
			int elementCtr = Collections.frequency(cd, setElement);
			if (elementCtr > 1)
				dupCtr++;
			
			ergebnis.put(setElement, elementCtr);
		}
		

		return ergebnis;
	}

	public  Map<String, Integer> getList() {
		return ergebnis;
	}

	//check if date is legal
	static boolean isLegalDate(String s) {
		sdf = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy", Locale.US);
		sdf.setLenient(false);
		return sdf.parse(s, new ParsePosition(0)) != null;
	}

	public void setDater(ArrayList<String> al) {
		raw=al;

	}

	public static String getDater() {
		String abc = "get dater ";
		return abc;
	}
	
	/**
	 * check if timestamp are between set boundaries
	 * eg. posts between 9:45:30 and 9:50:00
	 */

	public void countDater() {
		try {
			for (String s : raw) {
				Date dp = sdf.parse(s);
				datelist.add(dp);				
			}

			Date vg = sdf.parse(vorgabe2);
			Date vg1 = sdf.parse(vorgabe3);

			for (Date a : datelist) {				
				if (a.compareTo(vg) >= 0 && a.compareTo(vg1) <= 0) {					
					parseddate.add(a);
				}
			}
			//gets the time information from date object e.g. '9:45:16'

			for (Date b : datelist) {
				mystring.add(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(b));

				
			}
			List<String> listToCount = mystring;			
			countDuplicates(listToCount);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}