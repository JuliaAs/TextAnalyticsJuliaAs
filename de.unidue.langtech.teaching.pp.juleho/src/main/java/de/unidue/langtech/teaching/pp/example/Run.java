package de.unidue.langtech.teaching.pp.example;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;
import org.jfree.ui.RefineryUtilities;

import de.unidue.langtech.teaching.pp.example.pipeline.BasicPipeline;
import de.unidue.langtech.teaching.pp.util.Dater;
import de.unidue.langtech.teaching.pp.util.LineChart_AWT;

public class Run {
	static Dingstest d;
	static BasicPipeline bp;
	static ArrayList<String> al;
	static Dater date;
	static LineChart_AWT chart;

	public static void main(String[] args) throws ResourceInitializationException, UIMAException, IOException {
		// TODO Auto-generated method stub
		//d=new Dingstest();
		bp = new BasicPipeline();
		//BasicPipeline.methode();
		//SomeOtherExample.soemethode();
		//SomeOtherExample.setmethode();
		//SomeOtherExample.soemethode();
		System.out.println("Run " + SomeOtherExample.getList0());
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
		date = new Dater(SomeOtherExample.getList0());
		//al=new ArrayList<String>();
		//al.addAll(SomeOtherExample.getmethode());
		//System.out.println("run arrraylist" + al);
		//date=new Dater(al);
		
		/**
		chart = new LineChart_AWT(
		         "Häufigkeit Vs Zeit" ,
		         "Häufigkeiten der Wörter");
		chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	      */

	}

}
