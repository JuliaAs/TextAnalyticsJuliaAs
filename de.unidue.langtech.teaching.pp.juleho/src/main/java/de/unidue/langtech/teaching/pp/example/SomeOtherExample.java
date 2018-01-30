package de.unidue.langtech.teaching.pp.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
import de.unidue.langtech.teaching.pp.example.pipeline.BasicPipeline;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

public class SomeOtherExample 
extends JCasAnnotator_ImplBase{
	
	public static final String PARAM_NUMBER_ITERATIONS_PER_DOCUMENT = "PARAM_NUMBER_ITERATIONS_PER_DOCUMENT";
	@ConfigurationParameter(name = PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, mandatory = true)
	protected int numberIterations;
	
	public static final String PARAM_MESSAGE = "PARAM_MESSAGE";
	@ConfigurationParameter(name = PARAM_MESSAGE, mandatory = true, defaultValue = "Hello everyone")
	protected String message;
	
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
	Dingstest d;
	private static String settest = "settest1";
	private static HashMap<String, ArrayList<String>> hash;
	private static ArrayList<String> seil;
	private static List<String> testdings;
	private static List<String> test;
	
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
		
				
		for(Token t : JCasUtil.select(jcas, Token.class)){
			String tok = t.getCoveredText().toLowerCase();						
			fd.addSample(tok, 1);			
		}
		List<String> idiot = fd.getMostFrequentSamples(5);
		
		/**
		int a =idiot.size();
		for(int i=0;i<= a-1;i++) {
		System.out.println(idiot.get(i));
	}*/
		
		for(Token e : JCasUtil.select(jcas, Token.class)){
			//System.out.println("zweiter token " + idiot.get(0));
			String tk = e.getCoveredText().toLowerCase();
			
			if (tk.equals(idiot.get(0))) {
				
				//System.out.println("String ist gleich+++ " + idiot.get(0));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				//System.out.println(tt.getTweetPostTime());				
				tweet0.add(tt.getTweetPostTime());
				//System.out.println(tweet0.size());
			
			}else if(tk.equals(idiot.get(1))){
				
				//System.out.println("String ist gleich+++ " + idiot.get(1));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				//System.out.println(tt.getTweetPostTime());				
				tweet1.add(tt.getTweetPostTime());
				//System.out.println(tweet1.size());
				
			}else if(tk.equals(idiot.get(2))){
				
				//System.out.println("String ist gleich+++ " + idiot.get(2));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				//System.out.println(tt.getTweetPostTime());				
				tweet2.add(tt.getTweetPostTime());
				//System.out.println(tweet2.size());
				
			}else if(tk.equals(idiot.get(3))){
				
				//System.out.println("String ist gleich+++ " + idiot.get(3));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				//System.out.println(tt.getTweetPostTime());				
				tweet3.add(tt.getTweetPostTime());
				//System.out.println(tweet1.size());
				
			}else if(tk.equals(idiot.get(4))){
				
				//System.out.println("idiotget " +idiot.get(4));
				//System.out.println("NAME 4" + name4);
				//System.out.println("String ist gleich+++ " + idiot.get(4));
				tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
				//System.out.println(tt.getTweetPostTime());				
				tweet4.add(tt.getTweetPostTime());
				//System.out.println(tweet4.size());
			}			
		}
			
	}
	
	public void collectionProcessComplete() {
		System.out.println("COLLECTION COMPLETE");
		
		List<String> bums = fd.getMostFrequentSamples(5);
		name0=bums.get(0);
		name1=bums.get(1);
		name2=bums.get(2);
		name3=bums.get(3);
		name4=bums.get(4);
		/**
		System.out.println(test);
		for(String li : tweet1) {			
			System.out.println(li);			
		}	
		System.out.println("-----------");
		for(String li : tweet0) {			
			System.out.println(li);			
		}
		System.out.println("-----------");
		for(String li : tweet2) {			
			System.out.println(li);			
		}
		System.out.println("-----------");
		for(String li : tweet3) {			
			System.out.println(li);			
		}
		System.out.println("-----------");
		for(String li : tweet4) {			
			System.out.println(li);			
		}*/
		//List<String> idiot =fd.getMostFrequentSamples(5);
		//System.out.println("IDIOT " + idiot);
		//System.out.println("IDIOT " + idiot.size());
		//int a =idiot.size();
		/**for(int i=0;i<= a-1;i++) {
			System.out.println(idiot.get(i));
		}*/
		//ei.addAll(fd.getMostFrequentSamples(5));
		//System.out.println("EI " + ei);
		//System.out.println(ei.get(0));
		//System.out.println("Anzahl von EI " + ei.get(0) + " = "  + fd.getCount(ei.get(0)));
		
		//System.out.println("SomeOtherExample Method");
		//System.out.println("getb " + fd.getB());
		//System.out.println("getN " + fd.getN());
		//System.out.println("getmaxfre " + fd.getMaxFreq());
		//System.out.println("samplewithmaxfre " + fd.getSampleWithMaxFreq());
		System.out.println("mostfrequent Samples" + fd.getMostFrequentSamples(5));
		//System.out.println("getkeys " + fd.getKeys());
		//System.out.println("getcount " + fd.getCount("?"));
		//System.out.println("getcount thanksgiving " + fd.getCount("haus"));		
		/**
		System.out.println("HASHMAP SIZE " + listOfWords.size());
		
		
		System.out.println("mostfrequent Samples" + fd.getMostFrequentSamples(5));
		System.out.println("Anzahl von " + ei.get(0) + " = "  + fd.getCount(ei.get(0)));
		System.out.println("Anzahl von " + ei.get(1) + " = "  + fd.getCount(ei.get(1)));
		System.out.println("Anzahl von " + ei.get(2) + " = "  + fd.getCount(ei.get(2)));
		System.out.println("Anzahl von " + ei.get(3) + " = "  + fd.getCount(ei.get(3)));
		System.out.println("Anzahl von " + ei.get(4) + " = "  + fd.getCount(ei.get(4)));
		
		hash.put(ei.get(0), tweet);
		System.out.println("GesamtHash");
		System.out.println(hash.size());
		Set ob = hash.entrySet();
		System.out.println("DINGS" + ob);
		System.out.println("DINGS" + hash);
		System.out.println("DINGS" + hash.get(ei.get(0)));
		seil.addAll(hash.get(ei.get(0)));
		System.out.println("seil " + seil);
		if(hash.get(ei.get(1))==null) {
			System.out.println("ei null");
		}
		System.out.println(ei.get(1));
		System.out.println(ei.get(2));
		System.out.println(ei.get(3));
		System.out.println(ei.get(4));
		System.out.println(ei.size());
		*/
	}
	public static void soemethode() {
		System.out.println("methode soe");
		System.out.println(settest);
	}
	public static void setmethode() {
		settest="settest2";
	}
	public static  FrequencyDistribution<String> getmethode() {
		return fd;
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
