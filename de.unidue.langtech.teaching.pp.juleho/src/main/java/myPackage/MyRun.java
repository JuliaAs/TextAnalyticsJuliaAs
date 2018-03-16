package myPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;
import org.jfree.ui.RefineryUtilities;

import de.unidue.langtech.teaching.pp.util.Dater;
import de.unidue.langtech.teaching.pp.util.LineChart_AWT;
import de.unidue.langtech.teaching.pp.util.TreeSort;

public class MyRun {
	
	static MyPipeline bp;
	static ArrayList<String> al;
	static Dater date;
	static LineChart_AWT chart;
	
	public MyRun () throws ResourceInitializationException, UIMAException, IOException {
		
		bp = new MyPipeline();
		runrun();
		
		
	}

	public static void main(String[] args) throws ResourceInitializationException, UIMAException, IOException {
		
		
		bp = new MyPipeline();
		
		runrun();	

	}
	
	
	
	public static void runrun() {
		
		Dater date = new Dater();
		
		date.setDater(TweetTimeLookup.getList0());
		date.countDater();
		
		Map<String,Integer> m0 = new HashMap<String,Integer>();
		m0=date.getList();
		TreeSort ts0=new TreeSort(m0);
		TreeMap<String, Integer> tm0 = new TreeMap<String,Integer>();
		tm0=ts0.getTree();
		//System.out.println(m0);
		System.out.println(tm0);
		
		//m0.clear();
		//m0.putAll(ts0.getTree());
		
		
		Dater date1 = new Dater();
		date1.setDater(TweetTimeLookup.getList1());
		date1.countDater();
		
		Map<String,Integer> m1 = new HashMap<String,Integer>();
		m1=date.getList();
		TreeSort ts1=new TreeSort(m1);
		TreeMap<String, Integer> tm1 = new TreeMap<String,Integer>();
		tm1=ts1.getTree();
		//System.out.println(m1);
		System.out.println(tm1);
		//m1.clear();
		//m1.putAll(ts1.getTree());
		
		Dater date2 = new Dater();
		date2.setDater(TweetTimeLookup.getList2());
		date2.countDater();
		
		Map<String,Integer> m2 = new HashMap<String,Integer>();
		m2=date.getList();
		TreeSort ts2=new TreeSort(m2);
		TreeMap<String, Integer> tm2 = new TreeMap<String,Integer>();
		tm2=ts2.getTree();
		//System.out.println(m2);
		System.out.println(tm2);
		//m2.clear();
		//m2.putAll(ts2.getTree());
		
		Dater date3 = new Dater();
		date3.setDater(TweetTimeLookup.getList3());
		date3.countDater();
		
		Map<String,Integer> m3 = new HashMap<String,Integer>();
		m3=date.getList();
		TreeSort ts3=new TreeSort(m3);
		TreeMap<String, Integer> tm3 = new TreeMap<String,Integer>();
		tm3=ts3.getTree();
		//System.out.println(m3);
		System.out.println(tm3);
		//m3.clear();
		//m3.putAll(ts3.getTree());
		
		
		
		Dater date4 = new Dater();
		date4.setDater(TweetTimeLookup.getList4());
		date4.countDater();
		
		Map<String,Integer> m4 = new HashMap<String,Integer>();
		m4=date4.getList();
		TreeMap<String, Integer>tm4 = new TreeMap<String, Integer>();
		//tm4.putAll(m4);
		
		TreeSort ts4=new TreeSort(m4);
		tm4=ts4.getTree();
		//System.out.println(m4);
		System.out.println(tm4);
		//m4.clear();
		//m4.putAll(ts4.getTree());
		System.out.println(MyWordCounter.getName0());
		System.out.println(MyWordCounter.getName1());
		System.out.println(MyWordCounter.getName2());
		System.out.println(MyWordCounter.getName3());
		System.out.println(MyWordCounter.getName4());
		
		/**
		chart = new LineChart_AWT(
		         "Häufigkeit Vs Zeit" ,
		         "Häufigkeiten der Wörter");
		         */
		 
		/**
		chart.setTm0(tm0);
		chart.setTm1(tm1);
		chart.setTm2(tm2);
		chart.setTm3(tm3);
		chart.setTm4(tm4);
		chart.setN0(SomeOtherExample.getName0());
		chart.setN1(SomeOtherExample.getName1());
		chart.setN2(SomeOtherExample.getName2());
		chart.setN3(SomeOtherExample.getName3());
		chart.setN4(SomeOtherExample.getName4());
		*/
		
		
		chart = new LineChart_AWT(MyWordCounter.getName0(),MyWordCounter.getName1(),MyWordCounter.getName2(),
				MyWordCounter.getName3(),MyWordCounter.getName4(),tm0,tm1,tm2,tm3,tm4);
		chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	      
		 
		 
	}	

}
