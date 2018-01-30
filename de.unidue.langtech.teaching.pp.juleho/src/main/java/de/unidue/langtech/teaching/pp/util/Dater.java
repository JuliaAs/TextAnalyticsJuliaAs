package de.unidue.langtech.teaching.pp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

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
		// TODO Auto-generated constructor stub

		datelist = new ArrayList<Date>();
		parseddate = new ArrayList<Date>();
		mystring = new ArrayList<>();

		// System.out.println("DATER" + al);
		sdf = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy", Locale.US);

		// SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss", Locale.US);

		// String datum = "Wed Jan 28 19:39:54 +0000 2015";
		// String datum1 = "Tue Jan 28 19:39:54 +0000 2015";
		// String datum2 = "Thu Jan 29 19:39:54 +0000 2015";

		

	}

	private static Map<String, Integer> countDuplicates(List<String> cd) {
		int dupCtr = 0;
		ergebnis = new HashMap<String, Integer>();

		// get unique elements using HashSet
		Set<String> as = new HashSet<String>(cd);
		// System.out.println("Unique: " + as.toString());

		for (String setElement : as) {
			// returns the number of elements in the specified collection equal to the
			// specified object
			int elementCtr = Collections.frequency(cd, setElement);
			if (elementCtr > 1)
				dupCtr++;
			// System.out.println(setElement + ": " + elementCtr);
			ergebnis.put(setElement, elementCtr);
		}
		// System.out.println("ergebnismap " + ergebnis);

		return ergebnis;
	}

	public  Map<String, Integer> getList() {
		return ergebnis;
	}

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

	public void countDater() {
		try {

			for (String s : raw) {
				Date dp = sdf.parse(s);
				datelist.add(dp);
				// System.out.println("*****************************" + al);
			}

			Date vg = sdf.parse(vorgabe2);
			Date vg1 = sdf.parse(vorgabe3);

			for (Date a : datelist) {
				// System.out.println(a);
				// System.out.println(a.compareTo(vg));
				if (a.compareTo(vg) >= 0 && a.compareTo(vg1) <= 0) {
					// System.out.println("zwischen " + a);
					parseddate.add(a);
				}
			}

			for (Date b : datelist) {

				mystring.add(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(b));

				// System.out.println(mystring);
			}
			List<String> listToCount = mystring;
			// System.out.println("listToCount elements " + listToCount);
			//System.out.println(countDuplicates(listToCount));
			countDuplicates(listToCount);
			// int bibi = countDuplicates(listToCount);
			// System.out.println("Duplicates: " + bibi);
			/**
			 * 
			 * Date parse = sdf.parse(datum); Date ps = sdf.parse(datum2);
			 * 
			 * System.out.println(parse); System.out.println("Date : " + sdf.format(parse));
			 * 
			 * System.out.println(ps.compareTo(parse));
			 * System.out.println(parse.compareTo(ps));
			 * 
			 * System.out.println("datum legal? = " + isLegalDate(datum));
			 * System.out.println("datum 1 legal? = " + isLegalDate(datum1));
			 */

			// Date dt = sdf1.parse(datum);
			// System.out.println("Date : " + sdf1.format(dt));

			// System.out.println(" 6. " +
			// DateFormat.getTimeInstance(DateFormat.MEDIUM).format(parse));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}