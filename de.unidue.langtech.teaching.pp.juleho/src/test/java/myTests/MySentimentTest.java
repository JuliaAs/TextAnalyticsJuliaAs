package myTests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.*;

import org.apache.ivy.plugins.lock.FileBasedLockStrategy.CreateFileLocker;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.type.DetectedLanguage;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;
import myPackage.MySentiment;

public class MySentimentTest {	

	@Test
	public void test() throws UIMAException {
		String text = "Peter loves Jane "
				+ "Hello Peter";
		
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		jcas.setDocumentLanguage("en");
		
		 MySentimentScore ms = new MySentimentScore(jcas);
	        //set default value 100 for sentiment score
	        ms.setSentimentScore(100);
	        ms.addToIndexes();
		
		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);
		
		AnalysisEngineDescription mySentiment = createEngineDescription(MySentiment.class,
				MySentiment.PARAM_MODEL_LOCATION, "src/test/resources/lexicon.txt");
		AnalysisEngine mySentimentEngine = createEngine(mySentiment);
		mySentimentEngine.process(jcas);
		
		MySentimentScore sentimentScore = JCasUtil.selectSingle(jcas,
				MySentimentScore.class);
		System.out.println(sentimentScore.getSentimentScore());
		
		assertEquals(0, Float.compare((float) 0.984, sentimentScore.getSentimentScore()));
	}

}
