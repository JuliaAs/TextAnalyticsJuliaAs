package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.TrailingCharacterRemover;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.Dingstest;
import de.unidue.langtech.teaching.pp.example.MyReader;
import de.unidue.langtech.teaching.pp.example.SomeOtherExample;
import java.io.IOException;
import java.net.URL;



public class BasicPipeline
{
	public static String stringtest = "TEST***************************";	
	Dingstest d;    
    private static final URL STOPWORD_FILE = BasicPipeline.class.getClassLoader()
            .getResource("stopword.txt");
    private static final URL t = BasicPipeline.class.getClassLoader().getResource("input.txt");
    
    public BasicPipeline() throws ResourceInitializationException, UIMAException, IOException {
    	
    
    
    /**public static void main(String[] args)
        throws Exception
    {  */  	
        SimplePipeline.runPipeline(
                /**CollectionReaderFactory.createReader(
                        ReaderExample.class,
                        ReaderExample.PARAM_INPUT_FILE, "src/test/resources/test/input.txt"
                ),*/
        		CollectionReaderFactory.createReader(
                        MyReader.class,
                        MyReader.PARAM_INPUT_FILE, "src/test/resources/test/prepared1.txt"
                ),        		
        		AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
        		//AnalysisEngineFactory.createEngineDescription(ArktweetPosTagger.class, ArktweetPosTagger.PARAM_LANGUAGE, "en",
                 //		ArktweetPosTagger.PARAM_VARIANT, "default"),
        		//AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
        		AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),
        		AnalysisEngineFactory.createEngineDescription(StopWordRemover.class, 
        				StopWordRemover.PARAM_MODEL_LOCATION, 
        				STOPWORD_FILE),
        		
        		AnalysisEngineFactory.createEngineDescription(SomeOtherExample.class, 
						SomeOtherExample.PARAM_NUMBER_ITERATIONS_PER_DOCUMENT, 1,
						SomeOtherExample.PARAM_MESSAGE, "Hey!"),
        		//AnalysisEngineFactory.createEngineDescription(AnotherExample.class),
        		                        		
                AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)
              //AnalysisEngineFactory.createEngineDescription(Printer.class)     
                                                                                     
        );
        
    }
    public static void methode() {
    	System.out.println("Methode Basicpipeline");
    }
}
