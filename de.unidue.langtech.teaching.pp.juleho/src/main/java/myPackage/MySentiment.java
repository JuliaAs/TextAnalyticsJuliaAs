package myPackage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.DetectedLanguage;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;

public class MySentiment extends JCasAnnotator_ImplBase{
	
	public static final String PARAM_MODEL_LOCATION = "lexicon";
	@ConfigurationParameter(name = PARAM_MODEL_LOCATION, mandatory = true)
	private File lexicon;
	
	private List<String> lines1;
	private int currentLine1;
	private Map <String, Float> hm;
	
	@Override
	 public void initialize(UimaContext context)
		        throws ResourceInitializationException
		    {
		        super.initialize(context);
		        /**
		         * read lexicon split at space and puts into lexicon array
		         */
		        hm = new HashMap<String, Float>();
		        try {
					lines1 = FileUtils.readLines(lexicon);
					currentLine1=0;
					//System.out.println("initialize " + lines.size());
					for(String str: lines1) {
						//System.out.println("initialize : for loop");
						String[] parts = str.split("\\s+");
						hm.put(parts[1],Float.parseFloat(parts[0]));
						//System.out.println(hm);
					}
				 
				}catch (IOException e) {
		            throw new ResourceInitializationException(e);
		        }
		        //System.out.println(hm);
		    }
	 
	
	 
	

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		
		String[] parts = lines1.get(currentLine1).split("\\s+");
		
		float sentimentscore = 0;
		
		//iterate through each token
		for(Token t : JCasUtil.select(jcas, Token.class)){
			String tok = t.getCoveredText().toLowerCase();						
			
			
			//inner loop checks if lexicon contains a word / token that equals to a token
			for(Map.Entry<String, Float> str:hm.entrySet()) {
				
				
				//if lexicon finds match the value is added to sentimentscore 
				if(tok.equals(str.getKey())) {
					
					sentimentscore +=str.getValue();
					
				}
			}
			//puts score into jcas
			MySentimentScore mysa = JCasUtil.selectSingle(jcas, MySentimentScore.class);
			mysa.setSentimentScore(sentimentscore);
			mysa.removeFromIndexes();
			mysa.addToIndexes();
			
		}
		currentLine1++;
	}	

}
