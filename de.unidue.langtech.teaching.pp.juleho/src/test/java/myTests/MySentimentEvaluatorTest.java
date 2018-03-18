package myTests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.*;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;
import myPackage.MySentiEvaluator;
import myPackage.MySentiment;
import myPackage.MyWordCounter;

public class MySentimentEvaluatorTest {

	@Test
	public void test() throws UIMAException {
		String text = "Peter loves Jane "
				+ "Hello Peter"
				+ "Hello bitches"
				+ "loves loves";
		
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		jcas.setDocumentLanguage("en");
		
		 MySentimentScore ms = new MySentimentScore(jcas);
	        //set default value 100 for sentiment score
	        ms.setSentimentScore(100);
	        ms.addToIndexes();
		
	    //we need tokens
		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);
		
		//we need to cound words for the evaluator
		AnalysisEngineDescription wordCount = createEngineDescription(MyWordCounter.class);
		AnalysisEngine wordCountEngine = createEngine(wordCount);
		wordCountEngine.process(jcas);
		wordCountEngine.collectionProcessComplete();
		
		//we need to set sentiment scores
		AnalysisEngineDescription mySentiment = createEngineDescription(MySentiment.class,
				MySentiment.PARAM_MODEL_LOCATION, "src/test/resources/test/lexicon.txt");
		AnalysisEngine mySentimentEngine = createEngine(mySentiment);
		mySentimentEngine.process(jcas);
		
		//retrieve the sentiment scores mathcing to the frequent words
		AnalysisEngineDescription mySentimentEval = createEngineDescription(MySentiEvaluator.class);
		AnalysisEngine mySentimentEvalEngine = createEngine(mySentimentEval);
		mySentimentEvalEngine.process(jcas);
		/**
		 * -0.984	bitches
		 * 0.984	loves
		 * 
		 */
		
		System.out.println(MySentiEvaluator.getSentimentResults());
	}

}
