package myPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;

public class MySentiEvaluator extends JCasAnnotator_ImplBase {

	private static Map<String, Float> senti;
	private static List<String> unigramsfromwordcount;
	private boolean myflag;
	public static String a;
	public static Float b;
	private static Map<String,Float> sentimentAndText;

	/*
	 * This is called BEFORE any documents are processed.
	 */
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		senti = new HashMap<String, Float>();
		unigramsfromwordcount=MyWordCounter.getMostFrequentSamples();
		sentimentAndText=new HashMap<String,Float>();
		myflag=false;

	}

	/*
	 * iterate through tokens and finds matching document text and sentiment score to the 5 most frequent unigrams
	 */
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		MySentimentScore ms = JCasUtil.selectSingle(jcas, MySentimentScore.class);
		
		for(Token t : JCasUtil.select(jcas, Token.class)){
			String tok = t.getCoveredText().toLowerCase();	
			if(tok.equals(unigramsfromwordcount.get(0))) {
				sentimentAndText.put(jcas.getDocumentText(), ms.getSentimentScore());				
			}
			if(tok.equals(unigramsfromwordcount.get(1))) {
				sentimentAndText.put(jcas.getDocumentText(), ms.getSentimentScore());				
			}
			if(tok.equals(unigramsfromwordcount.get(2))) {
				sentimentAndText.put(jcas.getDocumentText(), ms.getSentimentScore());				
			}
			if(tok.equals(unigramsfromwordcount.get(3))) {
				sentimentAndText.put(jcas.getDocumentText(), ms.getSentimentScore());				
			}
			if(tok.equals(unigramsfromwordcount.get(4))) {
				sentimentAndText.put(jcas.getDocumentText(), ms.getSentimentScore());				
			}
			
		}

		int a = Float.compare(ms.getSentimentScore(), (float) 0.0);
		senti.put(jcas.getDocumentText(), ms.getSentimentScore());
		if (a == 0) {
			System.out.println(jcas.getDocumentText() + " " + ms.getSentimentScore());
		} else if (a > 0) {
			System.out.println("compare > 0");
		} else if (a < 0) {
			System.out.println("compare < 0");
		}

	}

	/*
	 * This is called AFTER all documents have been processed.
	 */
	@Override
	public void collectionProcessComplete() throws AnalysisEngineProcessException {
		super.collectionProcessComplete();
		
	}
	public static Map<String, Float> getSentimentResults(){
	return sentimentAndText;
	}
}