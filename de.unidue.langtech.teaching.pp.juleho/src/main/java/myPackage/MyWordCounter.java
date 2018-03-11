package myPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

public class MyWordCounter extends JCasAnnotator_ImplBase{
	
	private static FrequencyDistribution<String> fd;
	private HashMap<String, Integer> listOfWords;	
	private static ArrayList<String> ei;	
	private TweetTimeStamp tt;
	private static ArrayList <String >tweet0;
	private static ArrayList <String >tweet1;
	private static ArrayList <String >tweet2;
	private static ArrayList <String >tweet3;
	private static ArrayList <String >tweet4;
	private static String name0;
	private static String name1;
	private static String name2;
	private static String name3;
	private static String name4;	
	private static String settest = "settest1";
	private static HashMap<String, ArrayList<String>> hash;
	private static ArrayList<String> seil;
	private static List<String> testdings;
	private static List<String> test;
	public static List<String> mostFrequentSamples;
	
	public void initialize(UimaContext context)
            throws ResourceInitializationException
            {
			super.initialize(context);			
			fd = new FrequencyDistribution<String>();
			listOfWords = new HashMap<String, Integer>();
			tweet0 = new ArrayList<String>();
			tweet1 = new ArrayList<String>();
			tweet2 = new ArrayList<String>();
			tweet3 = new ArrayList<String>();
			tweet4 = new ArrayList<String>();
			hash=new HashMap<String, ArrayList<String>>();
			seil=new ArrayList<>();
			ei = new ArrayList<>();
			testdings=new ArrayList<String>();
			test = new ArrayList<String>();
			name0=new String();
			name1=new String();
			name2=new String();
			name3=new String();
			name4=new String();
            }

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		//iterate through all tokens and add to array in lowercase		
				for(Token t : JCasUtil.select(jcas, Token.class)){
					String tok = t.getCoveredText().toLowerCase();						
					fd.addSample(tok, 1);
					
				}		
	}
	
	public void collectionProcessComplete() {
		mostFrequentSamples = fd.getMostFrequentSamples(5);
		System.out.println(fd.getMostFrequentSamples(5));
	}
	
	public static List<String> getMostFrequentSamples(){
		return mostFrequentSamples;
	}
	

}
