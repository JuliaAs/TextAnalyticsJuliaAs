package myPackage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.RegexTokenFilter;
import de.tudarmstadt.ukp.dkpro.core.textnormalizer.annotations.TrailingCharacterRemover;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.MyReader;
import de.unidue.langtech.teaching.pp.example.SomeOtherExample;
import de.unidue.langtech.teaching.pp.example.pipeline.BasicPipeline;

public class MyPipeline {

	private static final URL STOPWORD_FILE = BasicPipeline.class.getClassLoader().getResource("stopword.txt");

	private static final String regex = "[a-zA-Z]+";
	private static List<String> mostFrequentSamples;

	public MyPipeline() throws ResourceInitializationException, UIMAException, IOException {

		SimplePipeline.runPipeline(

				CollectionReaderFactory.createReader(MyReader.class, MyReader.PARAM_INPUT_FILE,
						"src/test/resources/test/prepared.txt"),
				AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),

				AnalysisEngineFactory.createEngineDescription(RegexTokenFilter.class, RegexTokenFilter.PARAM_REGEX,
						regex, RegexTokenFilter.PARAM_MUST_MATCH, true),

				AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),

				AnalysisEngineFactory.createEngineDescription(StopWordRemover.class,
						StopWordRemover.PARAM_MODEL_LOCATION, STOPWORD_FILE),

				AnalysisEngineFactory.createEngineDescription(MyWordCounter.class),

				AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)

		);

	}

	public static void main(String[] args) throws Exception {
		{
			SimplePipeline.runPipeline(

					CollectionReaderFactory.createReader(MyReader.class, MyReader.PARAM_INPUT_FILE,
							"src/test/resources/test/prepared.txt"),
					AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
					AnalysisEngineFactory.createEngineDescription(RegexTokenFilter.class, RegexTokenFilter.PARAM_REGEX,
							regex, RegexTokenFilter.PARAM_MUST_MATCH, true),
					AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),
					AnalysisEngineFactory.createEngineDescription(StopWordRemover.class,
							StopWordRemover.PARAM_MODEL_LOCATION, STOPWORD_FILE),
					AnalysisEngineFactory.createEngineDescription(MyWordCounter.class),
					AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class));
			mostFrequentSamples = MyWordCounter.getMostFrequentSamples();
			System.out.println("Mypipeline" + mostFrequentSamples);
		}
		{
			SimplePipeline.runPipeline(

					CollectionReaderFactory.createReader(MyReader.class, MyReader.PARAM_INPUT_FILE,
							"src/test/resources/test/prepared.txt"),
					AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
					AnalysisEngineFactory.createEngineDescription(RegexTokenFilter.class, RegexTokenFilter.PARAM_REGEX,
							regex, RegexTokenFilter.PARAM_MUST_MATCH, true),
					AnalysisEngineFactory.createEngineDescription(TrailingCharacterRemover.class),
					AnalysisEngineFactory.createEngineDescription(StopWordRemover.class,
							StopWordRemover.PARAM_MODEL_LOCATION, STOPWORD_FILE),
					AnalysisEngineFactory.createEngineDescription(TweetTimeLookup.class),
					AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class));
		}
	}

}
