package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.collection.CollectionReaderDescription;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetPosTagger;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.tudarmstadt.ukp.dkpro.core.snowball.SnowballStemmer;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.TrailingCharacterRemover;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.MyReader;
import de.unidue.langtech.teaching.pp.example.ReaderExample;
import de.unidue.langtech.teaching.pp.example.SomeOtherExample;
import de.unidue.langtech.teaching.pp.example.TweetTime;
import de.unidue.langtech.teaching.pp.example.newType.LetterAnnotator;
import de.unidue.langtech.teaching.pp.example.newType.Printer;
import de.unidue.langtech.teaching.pp.type.MyType;
import de.unidue.langtech.teaching.seminar.*;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetPosTagger;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;

import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;


import java.io.IOException;
import java.net.URL;



public class BasicPipeline
{

	/* ignore all n-grams that occur less frequently */
    static final int MIN_COUNT = 3;

    /* lowercase all tokens. Important: set this parameter in the phrase annotator to the same value! */
    static boolean LOWERCASE = true;

    /* target file, compression is determined by the file name suffix */
    static String COUNTS_FILE = "target/counts.txt";
    
    private static final URL STOPWORD_FILE = BasicPipeline.class.getClassLoader()
            .getResource("stopword.txt");
    
    public static void main(String[] args)
        throws Exception
    {
        SimplePipeline.runPipeline(
                /**CollectionReaderFactory.createReader(
                        ReaderExample.class,
                        ReaderExample.PARAM_INPUT_FILE, "src/test/resources/test/input.txt"
                ),*/
        		CollectionReaderFactory.createReader(
                        MyReader.class,
                        MyReader.PARAM_INPUT_FILE, "src/test/resources/test/prepared.txt"
                ),
        		//AnalysisEngineFactory.createEngineDescription(LangDetectLanguageIdentifier.class),
        		//AnalysisEngineFactory.createEngineDescription(BaselineExample.class),
        		//AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),
        		//AnalysisEngineFactory.createEngineDescription(LanguageDetectorWeb1t.class),
        		AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
        		AnalysisEngineFactory.createEngineDescription(ArktweetPosTagger.class, ArktweetPosTagger.PARAM_LANGUAGE, "en",
                 		ArktweetPosTagger.PARAM_VARIANT, "default"),
        		//AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
        		AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),
        		AnalysisEngineFactory.createEngineDescription(StopWordRemover.class, 
        				StopWordRemover.PARAM_MODEL_LOCATION, 
        				STOPWORD_FILE),
        		
        		AnalysisEngineFactory.createEngineDescription(SomeOtherExample.class, 
						SomeOtherExample.PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, 1,
						SomeOtherExample.PARAM_MESSAGE, "Hey!"),
           		
        		
                /**AnalysisEngineFactory.createEngineDescription(TweetTime.class),
                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),
                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, 
                		SnowballStemmer.PARAM_LANGUAGE, "en"),
                		*/
        		
                AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)
              //AnalysisEngineFactory.createEngineDescription(Printer.class)
                
                
                
                
                
               /** AnalysisEngineFactory.createEngineDescription(BaselineExample.class),
                //AnalysisEngineFactory.createEngineDescription(LetterAnnotator.class),
                //AnalysisEngineFactory.createEngineDescription(Printer.class)
                AnalysisEngineFactory.createEngineDescription(SomeOtherExample.class, 
						SomeOtherExample.PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, 3,
						SomeOtherExample.PARAM_MESSAGE, "Hey!"),
                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),
                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, 
                		SnowballStemmer.PARAM_LANGUAGE, "en"),
                AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)
                
                */
                
                
        );
    }
	
	/**public static void main(String[] args)
			throws Exception
		{
			SimplePipeline.runPipeline(CollectionReaderFactory.createReader(
					ReaderExample.class, 
					ReaderExample.PARAM_INPUT_FILE, "src/test/resources/test/input.txt"),
					
					AnalysisEngineFactory.createEngineDescription(SomeOtherExample.class, 
							SomeOtherExample.PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, 3,
							SomeOtherExample.PARAM_MESSAGE, "Hey!")
					);
		}*/
}
