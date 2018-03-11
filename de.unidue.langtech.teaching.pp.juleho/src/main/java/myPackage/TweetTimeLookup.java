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

public class TweetTimeLookup extends JCasAnnotator_ImplBase{
	
	private TweetTimeStamp tt;
	public static List<String> mostFrequentSamples;
	
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
	
	public void initialize(UimaContext context)
            throws ResourceInitializationException
            {
			super.initialize(context);			
			
			tweet0 = new ArrayList<String>();
			tweet1 = new ArrayList<String>();
			tweet2 = new ArrayList<String>();
			tweet3 = new ArrayList<String>();
			tweet4 = new ArrayList<String>();
			
			name0=new String();
			name1=new String();
			name2=new String();
			name3=new String();
			name4=new String();
			mostFrequentSamples=MyWordCounter.getMostFrequentSamples();
			System.out.println("Tweettimelookup" + mostFrequentSamples) ;
            }

	/**
	 * iterates through tokens and gets the tweet time from the most frequent samples
	 * and puts in array of sample 1-5
	 */
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		for(Token e : JCasUtil.select(jcas, Token.class)){
			
			String tk = e.getCoveredText().toLowerCase();
			
			if (tk.equals(mostFrequentSamples.get(0))) {				
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);							
				tweet0.add(tt.getTweetPostTime());					
			
			}else if(tk.equals(mostFrequentSamples.get(1))){				
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);							
				tweet1.add(tt.getTweetPostTime());				
				
			}else if(tk.equals(mostFrequentSamples.get(2))){				
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);							
				tweet2.add(tt.getTweetPostTime());				
				
			}else if(tk.equals(mostFrequentSamples.get(3))){				
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);							
				tweet3.add(tt.getTweetPostTime());				
				
			}else if(tk.equals(mostFrequentSamples.get(4))){				
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);								
				tweet4.add(tt.getTweetPostTime());
				
			}			
		}
		
	}
	
	public static ArrayList<String> getList0() {
		return tweet0;
	}
	public static ArrayList<String> getList1() {
		return tweet1;
	}
	public static ArrayList<String> getList2() {
		return tweet2;
	}
	public static ArrayList<String> getList3() {
		return tweet3;
	}
	public static ArrayList<String> getList4() {
		return tweet4;
	}
	public static String getName0() {
		return name0;
	}
	public static String getName1() {
		return name1;
	}
	public static String getName2() {
		return name2;
	}
	public static String getName3() {
		return name3;
	}
	public static String getName4() {
		return name4;
	}

}
