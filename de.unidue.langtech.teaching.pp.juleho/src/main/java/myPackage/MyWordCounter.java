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
	static FrequencyDistribution<String> fd1;
	static FrequencyDistribution<String> fd2;
	
	List<String> mostBigrams;
	List<String> mostTrigrams;
	List<String> sentence;
	private String[] sentenceArray;
	static HashMap<String, Integer>hashMapBigram;
	static HashMap<String, Integer>hashMapTrigram;
	private static String name0;
	private static String name1;
	private static String name2;
	private static String name3;
	private static String name4;	
	
	
	public static List<String> mostUnigrams;
	
	public void initialize(UimaContext context)
            throws ResourceInitializationException
            {
		
			super.initialize(context);			
			fd = new FrequencyDistribution<String>();			
			name0=new String();
			name1=new String();
			name2=new String();
			name3=new String();
			name4=new String();
			fd1 = new FrequencyDistribution<String>();
			fd2 = new FrequencyDistribution<String>();
			sentence= new ArrayList<String>();			
			mostBigrams = new ArrayList<String>();
			mostTrigrams = new ArrayList<String>();
			hashMapBigram = new HashMap<String, Integer>();
			hashMapTrigram = new HashMap<String, Integer>();
            }

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		//iterate through all tokens and add to array in lowercase		
				for(Token t : JCasUtil.select(jcas, Token.class)){
					String tok = t.getCoveredText().toLowerCase();						
					fd.addSample(tok, 1);
					sentence.add(tok);
				}
				//create an sentence array to access tokens by index
				sentenceArray=new String[sentence.size()];
				//cast list to array
				sentenceArray=sentence.toArray(sentenceArray);
				
				/**
				 * iterate through all words of sentence
				 * check if next word is in boundary of array lenght
				 * if so get current word and next word and add to bigram
				 * or next word for trigram
				 */
				for(int i = 0; i<sentenceArray.length;i++) {
					if(i+1<sentenceArray.length) {
						String bigram = sentenceArray[i]+" " +sentenceArray[i+1];
						fd1.addSample(bigram,1);
							
				}
					if(i+2<sentenceArray.length) {
						String trigram = sentenceArray[i]+" " + sentenceArray[i+1] + " " + sentenceArray[i+2];
						fd2.addSample(trigram,1);
						
					}
			}
			//clear old sentence
			sentence.clear();
	}
	
	public void collectionProcessComplete() {
		mostUnigrams = fd.getMostFrequentSamples(5);
		name0=mostUnigrams.get(0);
		name1=mostUnigrams.get(1);
		name2=mostUnigrams.get(2);
		name3=mostUnigrams.get(3);
		name4=mostUnigrams.get(4);
		mostBigrams=fd1.getMostFrequentSamples(5);
		mostTrigrams=fd2.getMostFrequentSamples(5);
		
		//get 5 most frequent bigrams and put in new hashmap
		for(int i = 0; i<=4;i++) {
			hashMapBigram.put(mostBigrams.get(i),(int) fd1.getCount(mostBigrams.get(i)));
		}
		//get 5 most frequent trigrams and put in new hashmap
		for(int i = 0; i<=4;i++) {
			hashMapTrigram.put(mostTrigrams.get(i),(int) fd2.getCount(mostTrigrams.get(i)));
		}
		
		
	}
	
	public static List<String> getMostFrequentSamples(){
		return mostUnigrams;
	}
	
	public static  HashMap<String,Integer> getMostBigrams() {
		return hashMapBigram;
	}
	
	public static  HashMap<String,Integer> getMostTrigrams() {
		return hashMapTrigram;
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
