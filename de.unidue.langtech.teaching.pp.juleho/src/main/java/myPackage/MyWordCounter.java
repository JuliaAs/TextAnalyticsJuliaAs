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
	
	
	private static String name0;
	private static String name1;
	private static String name2;
	private static String name3;
	private static String name4;	
	
	
	public static List<String> mostFrequentSamples;
	
	public void initialize(UimaContext context)
            throws ResourceInitializationException
            {
		System.out.println("MyWordCounter");
			super.initialize(context);			
			fd = new FrequencyDistribution<String>();			
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
		name0=mostFrequentSamples.get(0);
		name1=mostFrequentSamples.get(1);
		name2=mostFrequentSamples.get(2);
		name3=mostFrequentSamples.get(3);
		name4=mostFrequentSamples.get(4);
	}
	
	public static List<String> getMostFrequentSamples(){
		return mostFrequentSamples;
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
