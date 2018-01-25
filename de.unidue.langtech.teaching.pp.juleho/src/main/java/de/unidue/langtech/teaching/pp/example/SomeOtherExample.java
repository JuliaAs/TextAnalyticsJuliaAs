package de.unidue.langtech.teaching.pp.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.provider.FrequencyCountProvider;
import de.tudarmstadt.ukp.dkpro.core.api.frequency.provider.FrequencyCountProviderBase;
import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

public class SomeOtherExample 
extends JCasAnnotator_ImplBase{
	
	public static final String PARAM_NUMBER_ITERATIONS_PER_DOCUMENT = "PARAM_NUMBER_ITERATIONS_PER_DOCUMENT";
	@ConfigurationParameter(name = PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, mandatory = true)
	protected int numberIterations;
	
	public static final String PARAM_MESSAGE = "PARAM_MESSAGE";
	@ConfigurationParameter(name = PARAM_MESSAGE, mandatory = true, defaultValue = "Hello everyone")
	protected String message;
	
	private FrequencyDistribution<String> fd;
	
	private HashMap<String, Integer> listOfWords;
	
	private static ArrayList<String> ei;
	
	private TweetTimeStamp tt;
	private ArrayList <String >tweet;
	
	public void initialize(UimaContext context)
            throws ResourceInitializationException
            {
			super.initialize(context);
			fd = new FrequencyDistribution<String>();
			listOfWords = new HashMap<String, Integer>();
			tweet = new ArrayList<String>();
		
            }

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		/**for (int i = 0; i < numberIterations; i++) {
			System.out.println("Iteration: " + (i + 1)  + message);
		}
		*/
		
		
		for(Token t : JCasUtil.select(jcas, Token.class)){
			String tok = t.getCoveredText().toLowerCase();
			
			int countWord = 0;
	        if(!listOfWords.containsKey(tok))
	        {                             //add word if it isn't added already
	            listOfWords.put(tok, 1); //first occurance of this word
	            System.out.println("firstword");
	        }
	        else
	        {
	            countWord = listOfWords.get(tok) + 1; //get current count and increment
	            //now put the new value back in the HashMap
	            listOfWords.remove(tok); //first remove it (can't have duplicate keys)
	            listOfWords.put(tok, countWord); //now put it back with new value
	        }
			int i = 0;
			if (tok.contains("thanksgiving")) {
				i++;
				System.out.println("******************************");
			}
			
			fd.addSample(tok, 1);
			if (tok.equals("peter")) {
				System.out.println("String ist gleich hahahhaha");
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				System.out.println(tt.getTweetPostTime());
				
			}
			if (tok.equals("haus")) {
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				System.out.println("damina als token " + tt.getTweetPostTime());
				
			}
			
		}
		
		System.out.println("SomeOtherExample Method");
		System.out.println("getb " + fd.getB());
		System.out.println("getN " + fd.getN());
		System.out.println("getmaxfre " + fd.getMaxFreq());
		System.out.println("samplewithmaxfre " + fd.getSampleWithMaxFreq());
		System.out.println("mostfrequent Samples" + fd.getMostFrequentSamples(5));
		System.out.println("getkeys " + fd.getKeys());
		System.out.println("getcount " + fd.getCount("?"));
		System.out.println("getcount thanksgiving " + fd.getCount("haus"));		
		System.out.println("HASHMAP SIZE " + listOfWords.size());
		ei = new ArrayList<>();
		ei.addAll(fd.getMostFrequentSamples(5));
		System.out.println(ei);
		System.out.println(ei.get(0));
		System.out.println("Anzahl von " + ei.get(0) + " = "  + fd.getCount(ei.get(0)));
		
		for(Token e : JCasUtil.select(jcas, Token.class)){
			System.out.println("zweiter token" + ei.get(0));
			String tk = e.getCoveredText().toLowerCase();
			if (tk.equals(ei.get(0))) {
				System.out.println("String ist gleich " + ei.get(0));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				System.out.println(tt.getTweetPostTime());
				tweet.add(tt.getTweetPostTime());
				System.out.println(tweet.size());
			}
		}
			
	}
	
	public void collectionProcessComplete() {
		System.out.println("COLLECTION COMPLETE");
		System.out.println("mostfrequent Samples" + fd.getMostFrequentSamples(5));
		System.out.println("Anzahl von " + ei.get(0) + " = "  + fd.getCount(ei.get(0)));
		System.out.println("Anzahl von " + ei.get(1) + " = "  + fd.getCount(ei.get(1)));
		System.out.println("Anzahl von " + ei.get(2) + " = "  + fd.getCount(ei.get(2)));
		System.out.println("Anzahl von " + ei.get(3) + " = "  + fd.getCount(ei.get(3)));
		System.out.println("Anzahl von " + ei.get(4) + " = "  + fd.getCount(ei.get(4)));
		for(String li : tweet) {
			System.out.println(li);
			
		}
	}
	
	public String[] strg(){
		
		return null;
		
	}
	
	
}
