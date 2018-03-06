package de.unidue.langtech.teaching.pp.util;

import org.jfree.chart.ChartPanel;

import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import de.unidue.langtech.teaching.pp.example.SomeOtherExample;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 
 * jfreechart to create a image with the 5 most frequent samples and timestamps
 *
 */
public class LineChart_AWT extends ApplicationFrame {
	
	Dater da;
	TreeSort ts;
	public static TreeMap<String,Integer> t0;
	public static TreeMap<String,Integer> t1;
	public static TreeMap<String,Integer> t2;
	public static TreeMap<String,Integer> t3;
	public static TreeMap<String,Integer> t4;
	private static String s0;
	public static String s1;
	public static String s2;
	public static String s3;
	public static String s4;
	static String applicationTitle = "dididdd";
	String chartTitle = "Häufigkeiten der Wörter";

	public  LineChart_AWT() {
		super(applicationTitle);
		
	}
	public  LineChart_AWT(String s, String string, String string2, String string3, String string4, TreeMap<String, Integer> tm0, TreeMap<String, Integer> tm1, TreeMap<String, Integer> tm2, TreeMap<String, Integer> tm3, TreeMap<String, Integer> tm4) {
		super(applicationTitle);
		s0=s;
		s1=string;
		s2=string2;
		s3=string3;
		s4=string4;
		t0=tm0;
		t1=tm1;
		t2=tm2;
		t3=tm3;
		t4=tm4;
		
		 JFreeChart lineChart = ChartFactory.createLineChart(
		         chartTitle,
		         "Zeit","Anzahl der Wörter",
		         createDataset(),
		         PlotOrientation.VERTICAL,
		         true,true,false);
		         
		      ChartPanel chartPanel = new ChartPanel( lineChart );
		      chartPanel.setPreferredSize( new java.awt.Dimension( 860 , 367 ) );
		      setContentPane( chartPanel ); 
	
	}
	
   public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);           
      
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Zeit","Anzahl der Wörter",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 367 ) );
      setContentPane( chartPanel );      
   }

   //add data to chart
   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
      /**
      dataset.addValue( 15 , "Erdbeben" , "19:30" );
      dataset.addValue( 30 , "Erdbeben" , "19:35" );
      dataset.addValue( 60 , "Erdbeben" ,  "19:40" );
      dataset.addValue( 120 , "Erdbeben" , "19:45" );
      dataset.addValue( 240 , "Erdbeben" , "19:50" );
      dataset.addValue( 300 , "Erdbeben" , "17:00" );
      */
      
      for (String elem : t0.keySet()) {
			
		dataset.addValue(t0.get(elem), s0, elem);		
		}
      for (String elem : t1.keySet()) {
			
		dataset.addValue(t1.get(elem), s1, elem);		
		}
      
      for (String elem : t2.keySet()) {
			
		dataset.addValue(t2.get(elem), s2, elem);		
		}
      
      for (String elem : t3.keySet()) {
			
		dataset.addValue(t3.get(elem), s3, elem);		
		}
      
      for (String elem : t4.keySet()) {
			
		dataset.addValue(t4.get(elem), s4, elem);		
		}
      
      return dataset;
   }
   public  void setTm0 (TreeMap<String,Integer> t) {
	   t0=t;
	  
   }
   public  void setTm1 (TreeMap<String,Integer> t) {
	   t1=t;
	   
   }
   public  void setTm2 (TreeMap<String,Integer> t) {
	   t2=t;
	   
   }
   public  void setTm3 (TreeMap<String,Integer> t) {
	   t3=t;
	
   }
   public  void setTm4 (TreeMap<String,Integer> t) {
	   t4=t;
	   
   }
   public void setN0 (String s) {
	  s0=s;
	  
   }
   public void setN1 (String s) {
	   s1=s;
	   
   }
   public void setN2 (String s) {
	   s2=s;
	   
   }
   public void setN3 (String s) {
	   s3=s;
	  
   } public void setN4 (String s) {
	   s4=s;
	   
   }
   public void charter() {
	   System.out.println("charter" + s0);
   }
   
}