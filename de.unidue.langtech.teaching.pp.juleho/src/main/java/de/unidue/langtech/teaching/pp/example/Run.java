package de.unidue.langtech.teaching.pp.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;
import org.jfree.ui.RefineryUtilities;

import de.unidue.langtech.teaching.pp.example.pipeline.BasicPipeline;
import de.unidue.langtech.teaching.pp.util.Dater;
import de.unidue.langtech.teaching.pp.util.LineChart_AWT;
import de.unidue.langtech.teaching.pp.util.TreeSort;

public class Run {
	static Dingstest d;
	static BasicPipeline bp;
	static ArrayList<String> al;
	static Dater date;
	static LineChart_AWT chart;
	
	public Run () {
		System.out.println("Run");
	}

	public static void main(String[] args) throws ResourceInitializationException, UIMAException, IOException {
		// TODO Auto-generated method stub
		//d=new Dingstest();
		System.out.println("Main Run");
		bp = new BasicPipeline();
		
		runrun();
		//System.out.println("Run " + SomeOtherExample.getList0());
		/**
		System.out.println("Run " + SomeOtherExample.getList0());
		System.out.println("Run " + SomeOtherExample.getList1());
		System.out.println("Run " + SomeOtherExample.getList2());
		System.out.println("Run " + SomeOtherExample.getList3());
		System.out.println("Run " + SomeOtherExample.getList4());
		System.out.println("Run " + SomeOtherExample.getName0());
		System.out.println("Run " + SomeOtherExample.getName1());
		System.out.println("Run " + SomeOtherExample.getName2());
		System.out.println("Run " + SomeOtherExample.getName3());		
		System.out.println("Run " + SomeOtherExample.getName4());
		*/
		
		
		//al=new ArrayList<String>();
		//al.addAll(SomeOtherExample.getmethode());
		//System.out.println("run arrraylist" + al);
		//date=new Dater(al);
		
		

	}
	public static void runrun() {
		Dater date = new Dater();
		//System.out.println("Run " + SomeOtherExample.getName0());
		date.setDater(SomeOtherExample.getList0());
		date.countDater();
		//System.out.println("counted result 0 " + date.getList());
		Map<String,Integer> m0 = new HashMap<String,Integer>();
		m0=date.getList();
		TreeSort ts0=new TreeSort(m0);
		TreeMap<String, Integer> tm0 = new TreeMap<String,Integer>();
		tm0=ts0.getTree();
		
		//System.out.println("run " + tm0);
		//m0.clear();
		//m0.putAll(ts0.getTree());
		//System.out.println("M0 TS " + m0);
		
		Dater date1 = new Dater();
		date1.setDater(SomeOtherExample.getList1());
		date1.countDater();
		//System.out.println("counted result 1 " + date1.getList());
		Map<String,Integer> m1 = new HashMap<String,Integer>();
		m1=date.getList();
		TreeSort ts1=new TreeSort(m1);
		TreeMap<String, Integer> tm1 = new TreeMap<String,Integer>();
		tm1=ts1.getTree();
		//m1.clear();
		//m1.putAll(ts1.getTree());
		
		Dater date2 = new Dater();
		date2.setDater(SomeOtherExample.getList2());
		date2.countDater();
		//System.out.println("counted result 2 " + date2.getList());
		Map<String,Integer> m2 = new HashMap<String,Integer>();
		m2=date.getList();
		TreeSort ts2=new TreeSort(m2);
		TreeMap<String, Integer> tm2 = new TreeMap<String,Integer>();
		tm2=ts2.getTree();
		//m2.clear();
		//m2.putAll(ts2.getTree());
		
		Dater date3 = new Dater();
		date3.setDater(SomeOtherExample.getList3());
		date3.countDater();
		//System.out.println("counted result 3 " + date3.getList());
		Map<String,Integer> m3 = new HashMap<String,Integer>();
		m3=date.getList();
		TreeSort ts3=new TreeSort(m3);
		TreeMap<String, Integer> tm3 = new TreeMap<String,Integer>();
		tm3=ts3.getTree();
		//m3.clear();
		//m3.putAll(ts3.getTree());
		//System.out.println("M3 " + m3);
		
		//System.out.println("LIST 4 " + SomeOtherExample.getList4());
		Dater date4 = new Dater();
		date4.setDater(SomeOtherExample.getList4());
		date4.countDater();
		//System.out.println("counted result 4 " + date4.getList());
		Map<String,Integer> m4 = new HashMap<String,Integer>();
		m4=date4.getList();
		TreeMap<String, Integer>tm4 = new TreeMap<String, Integer>();
		//tm4.putAll(m4);
		//System.out.println(m4);
		//System.out.println("M4 " + m4);
		TreeSort ts4=new TreeSort(m4);
		tm4=ts4.getTree();
		//m4.clear();
		//m4.putAll(ts4.getTree());
		//System.out.println("Tm4 clear " + tm4);
		
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
		
		
		chart = new LineChart_AWT(SomeOtherExample.getName0(),SomeOtherExample.getName1(),SomeOtherExample.getName2(),
				SomeOtherExample.getName3(),SomeOtherExample.getName4(),tm0,tm1,tm2,tm3,tm4);
		chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	      
		 
		 
	}

}
