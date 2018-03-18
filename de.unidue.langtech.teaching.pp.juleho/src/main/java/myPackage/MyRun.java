package myPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;
import org.jfree.ui.RefineryUtilities;

import de.unidue.langtech.teaching.pp.util.BarChart_AWT;
import de.unidue.langtech.teaching.pp.util.Dater;
import de.unidue.langtech.teaching.pp.util.LineChart_AWT;
import de.unidue.langtech.teaching.pp.util.TreeSort;

public class MyRun {
	
	static MyPipeline bp;
	static ArrayList<String> al;
	static Dater date;
	static LineChart_AWT chart;
	static BarChart_AWT bigramChart;
	static BarChart_AWT trigramChart;
	private static String unigramPath;
	private static String bigramPath;
	private static String trigramPath;
	private static Map<String,Float> sentimentResults;
	private static Map<String, Integer> bigramResults;
	private static Map<String, Integer> trigramResults;
	
	
	//constructor that is called from servlet
	public MyRun () throws ResourceInitializationException, UIMAException, IOException {
		
		//instantiates mypipeline
		bp = new MyPipeline();
		//call controller method
		runrun();
		
		
	}	

	public static void main(String[] args) throws ResourceInitializationException, UIMAException, IOException {
		
		
		bp = new MyPipeline();
		
		runrun();	

	}
	
	/**
	 * 
	 * this method is the controller and gets all the needed values to create charts
	 */
	
	public static void runrun() throws IOException {
		//create new utility class dater
		Dater date = new Dater();
		//gets the timestamdinformation from tweettimelookup and sets this list as working list
		date.setDater(TweetTimeLookup.getList0());
		//calls the method to start the count
		date.countDater();
		
		Map<String,Integer> m0 = new HashMap<String,Integer>();
		//retrieves the list from dater
		m0=date.getList();
		//create new class with retrieved list to sort the timestamps
		TreeSort ts0=new TreeSort(m0);
		TreeMap<String, Integer> tm0 = new TreeMap<String,Integer>();
		//get the sorted array from treesort
		tm0=ts0.getTree();
				
		Dater date1 = new Dater();
		date1.setDater(TweetTimeLookup.getList1());
		date1.countDater();		
		Map<String,Integer> m1 = new HashMap<String,Integer>();
		m1=date1.getList();
		TreeSort ts1=new TreeSort(m1);
		TreeMap<String, Integer> tm1 = new TreeMap<String,Integer>();
		tm1=ts1.getTree();		
				
		Dater date2 = new Dater();
		date2.setDater(TweetTimeLookup.getList2());
		date2.countDater();		
		Map<String,Integer> m2 = new HashMap<String,Integer>();
		m2=date2.getList();
		TreeSort ts2=new TreeSort(m2);
		TreeMap<String, Integer> tm2 = new TreeMap<String,Integer>();
		tm2=ts2.getTree();		
		
		Dater date3 = new Dater();
		date3.setDater(TweetTimeLookup.getList3());
		date3.countDater();		
		Map<String,Integer> m3 = new HashMap<String,Integer>();
		m3=date3.getList();
		TreeSort ts3=new TreeSort(m3);
		TreeMap<String, Integer> tm3 = new TreeMap<String,Integer>();
		tm3=ts3.getTree();
				
		Dater date4 = new Dater();
		date4.setDater(TweetTimeLookup.getList4());
		date4.countDater();		
		Map<String,Integer> m4 = new HashMap<String,Integer>();
		m4=date4.getList();
		TreeMap<String, Integer>tm4 = new TreeMap<String, Integer>();
		TreeSort ts4=new TreeSort(m4);
		tm4=ts4.getTree();						
		
		//create new linechart with 5 most frequent samples and the tweet timestamps for those samples
		chart = new LineChart_AWT(MyWordCounter.getName0(),MyWordCounter.getName1(),MyWordCounter.getName2(),
				MyWordCounter.getName3(),MyWordCounter.getName4(),tm0,tm1,tm2,tm3,tm4);
		
		//this is the path where the unigramchart was saves, need path for result page to display
		 unigramPath=chart.getFilePath();
		/**
		chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	      */
		 
		//gets the sentimentresults,bi,trigrams from pipeline and keeps them in	run maps
		 sentimentResults=new HashMap<>();
		 sentimentResults=MySentiEvaluator.getSentimentResults();
		 bigramResults=MyWordCounter.getMostBigrams();
		 trigramResults=MyWordCounter.getMostTrigrams();
		 
		 //create new barcharts with parameters for bigrams
		 bigramChart = new BarChart_AWT(bigramResults, "bigramme", "Häufigkeiten der Bigramme");
		 
		 //path for bigram file
	      bigramPath=bigramChart.getFilePath();
	      
	      //create barchart with parameter for trigrams
	      trigramChart = new BarChart_AWT(trigramResults, "trigramme", "Häufigkeiten der Trigramme");
	      
	      //path to trigramchart
	      trigramPath=trigramChart.getFilePath();
	      
	      /**
	       * for checking purposes, creates windows with bi and trigram
	    bigramChart.pack( );        
	      RefineryUtilities.centerFrameOnScreen( bigramChart );        
	      bigramChart.setVisible( true );
	    trigramChart.pack( );        
	      RefineryUtilities.centerFrameOnScreen( trigramChart );        
	      trigramChart.setVisible( true );
	       * 
	       */
	}
	public static String getdateipfad() {
		return unigramPath;
	}
	public static String getBigramPath() {
		return bigramPath;
	}
	
	public static String getTrigramPath() {
		return trigramPath;
	}
	
	public static Map<String, Float> getSentimentResults(){
		return sentimentResults;
	}
	
	public static Map<String, Integer> getBigramResults(){
		return bigramResults;
	}
	public static Map<String, Integer> getTrigramResults(){
		return trigramResults;
	}

}
