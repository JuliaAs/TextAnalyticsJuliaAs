package de.unidue.langtech.teaching.pp.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame {
	
	static String applicationTitle = "Bigram";
	String chartTitle = "Häufigkeiten der Bigramme";
	static Map<String,Integer> Map;
	static String titel;
	private static String filePath;
   
   public BarChart_AWT( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Anzahl",            
         "Samples",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   public BarChart_AWT(Map<String, Integer> bigramResults, String name, String chartTitle) throws IOException {
	   super( applicationTitle );
	   Map=bigramResults;
	   JFreeChart barChart = ChartFactory.createBarChart(
		         chartTitle,           
		         titel=name,            
		         "Anzahl",            
		         createDataset(),          
		         PlotOrientation.VERTICAL,           
		         true, true, false);
		         
		      ChartPanel chartPanel = new ChartPanel( barChart );        
		      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		      setContentPane( chartPanel );
		      String extension = ".png";
		      String filename = name;
		      File myFile = new File ( filename+extension);
		      
		      ChartUtilities.saveChartAsPNG(myFile, barChart, 640, 480);
		      String sRootPath = new File("").getAbsolutePath();
		      filePath = sRootPath + "\\"+filename+extension;
	  
}

private CategoryDataset createDataset( ) {
      final String sample = "Sample";        
      
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );
      
      for(Entry<String, Integer> s:Map.entrySet()) {
    	  dataset.addValue( s.getValue() , s.getKey() , sample );
          
          }

      

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics", 
         "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
   public String getFilePath() {
	   return filePath;
   }
}