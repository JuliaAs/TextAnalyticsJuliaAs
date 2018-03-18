package myTests;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import myPackage.MyWordCounter;

public class MyWordCounterTest {
	
	@Test
	public void testMyWordCounter() throws UIMAException {

	String text = "Peter Parker Peter Parker Peter Parker Peter Parker Peter Parker Peter Parker, "
			+ "peppers peppers peppers peppers . "
			+ "picked picked picked  , "
			+ "Piper Piper   ";

	// We don't have a pipeline here,
	// thus we create an empty document by hand,
	// the following utility-method call helps us
	JCas jcas = JCasFactory.createJCas();
	// We set the text to our empty document
	jcas.setDocumentText(text);
	jcas.setDocumentLanguage("en");

	// We just instantiate our annotator by hand and
	// call process() by-hand (in a pipeline, the framework does that for
	// us)

	// Do you remember, our wordcount need tokens - we have to do the
	// segmentation, too
	AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
	AnalysisEngine segEngine = createEngine(segmenter);
	segEngine.process(jcas);

	// Now we can let run our word count
	AnalysisEngineDescription wordCounter = createEngineDescription(MyWordCounter.class);
	AnalysisEngine wordCountEngine = createEngine(wordCounter);
	wordCountEngine.process(jcas);
	
	//we need to call collectionCompete because the arrays and maps are filled at the ende
	wordCountEngine.collectionProcessComplete();
	
	List<String> mostFrequentSamples=MyWordCounter.getMostFrequentSamples();
	//we know the first two most frequent words
	assertEquals("peter",mostFrequentSamples.get(0));
	assertEquals("parker",mostFrequentSamples.get(1));
	
	
	HashMap<String, Integer>bigramme = MyWordCounter.getMostBigrams();
	//5 most frequent bigrams
	assertEquals(5,bigramme.size());
	int i = 0;
	for(Entry<String, Integer> s:bigramme.entrySet()) {
		if(i==0) {
			/**
			 * we know parker peter is the first bigram
			 * and we know parker peter exist 5 times
			 */
			assertEquals(Integer.valueOf(5),s.getValue());
			assertEquals(String.valueOf("parker peter"),s.getKey());
		
		}
        i++;
        }	
}

}
