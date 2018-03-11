package de.unidue.langtech.teaching.pp.example.pipeline;

import java.io.IOException;
import java.net.URL;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetPosTagger;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.RegexTokenFilter;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.TrailingCharacterRemover;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.MyReader;
import de.unidue.langtech.teaching.pp.example.ReaderExample;
import de.unidue.langtech.teaching.pp.example.SomeOtherExample;

public class ExtendedPipeline
{
	private static final URL STOPWORD_FILE = BasicPipeline.class.getClassLoader()
            .getResource("stopword.txt");
	private static final String regex = "[a-zA-Z]";
	
	public ExtendedPipeline() throws ResourceInitializationException, UIMAException, IOException {
		SimplePipeline.runPipeline(
        		CollectionReaderFactory.createReader(
                        MyReader.class,
                        MyReader.PARAM_INPUT_FILE, "src/test/resources/test/prepared1.txt"
                ),
        		AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
        		 AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class));
	}

    public static void main(String[] args)
        throws Exception
    {
        SimplePipeline.runPipeline(
        		CollectionReaderFactory.createReader(
                        MyReader.class,
                        MyReader.PARAM_INPUT_FILE, "src/test/resources/test/prepared1.txt"
                ),   
        		
        		AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
        		AnalysisEngineFactory.createEngineDescription(ArktweetPosTagger.class, ArktweetPosTagger.PARAM_LANGUAGE, "en",
                 		ArktweetPosTagger.PARAM_VARIANT, "default"),
                 		
        		//AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
        		/**
        		AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),
        		AnalysisEngineFactory.createEngineDescription(StopWordRemover.class, 
        				StopWordRemover.PARAM_MODEL_LOCATION, 
        				STOPWORD_FILE),
        				*/
        		
        		AnalysisEngineFactory.createEngineDescription(RegexTokenFilter.class,
        				RegexTokenFilter.PARAM_REGEX,regex,
        				RegexTokenFilter.PARAM_MUST_MATCH, true),
        		
        		/**
        		AnalysisEngineFactory.createEngineDescription(SomeOtherExample.class, 
						SomeOtherExample.PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, 1,
						SomeOtherExample.PARAM_MESSAGE, "Hey!"),
        		//AnalysisEngineFactory.createEngineDescription(AnotherExample.class),
        		AnalysisEngineFactory.createEngineDescription(RegexTokenFilter.class,
        				RegexTokenFilter.PARAM_REGEX,regex,
        				RegexTokenFilter.PARAM_MUST_MATCH, true),
        				*/
        		                        		
                AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class));
    }
}