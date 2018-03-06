package de.unidue.langtech.teaching.pp.example;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.DetectedLanguage;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

/**
 * own type for the time information when a tweet was posted
 * 
 *
 */
public class TweetTime extends JCasAnnotator_ImplBase{

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		String str = jcas.getDocumentText();
		
		
		TweetTimeStamp ts = new TweetTimeStamp(jcas);
		ts.setTweetPostTime(str);
		ts.addToIndexes();
	}
	
	

	

}
