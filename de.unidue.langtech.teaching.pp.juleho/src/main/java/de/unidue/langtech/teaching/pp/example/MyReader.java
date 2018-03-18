package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.io.ResourceCollectionReaderBase.Resource;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;
import de.unidue.langtech.teaching.type.MyRawTweet;
import de.unidue.langtech.teaching.type.RawTweet;

public class MyReader extends JCasCollectionReader_ImplBase {
	
	/**
     * Input file
     */
    public static final String PARAM_INPUT_FILE = "InputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    private File inputFile;    
    int currentReaderIdx = 0;
    
    private List<String> lines;
    private int currentLine;
    String line = null;
    static FileInputStream is;
    FileInputStream fis = null;
    BufferedReader reader = null;
    
    
    private static final String CREATE_MARKER = "\"created_at\":\"";
    private static final String TEXT_MARKER = "\"text\":\"";
    private static final String MARKER_END = "\",";

    
    /* 
     * initializes the reader
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        
        try {
        	
        	//reads file and uses utf8 encoding
           lines = FileUtils.readLines(inputFile, "UTF-8");
           currentLine = 0;
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }
    
    
    /* 
     * true, if there is a next document, false otherwise
     */
    public boolean hasNext()
        throws IOException, CollectionException
    {
        
    	return currentLine < lines.size();
    }

	public Progress[] getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void getNext(JCas jcas) throws IOException, CollectionException {
		
		String line = lines.get(currentLine);
		
		//check for valid lineformat
		if (!lines.get(currentLine).contains(CREATE_MARKER)) {
        throw new IOException("Wrong line format: " + lines.get(currentLine));
    }
		String xt = getExtract(line, CREATE_MARKER, MARKER_END);
    
		//adds timestamp from tweet to cas
        TweetTimeStamp ts = new TweetTimeStamp(jcas);
        ts.setTweetPostTime(xt);
        ts.addToIndexes();
        
        //set payload as the document text
        String extract = getExtract(line, TEXT_MARKER, MARKER_END);
        
        //adds the raw tweet to jcas
        MyRawTweet raw = new MyRawTweet(jcas);
        raw.setRawTweet(extract);
        raw.addToIndexes();

        //adds default sentiment score to jcas
        MySentimentScore ms = new MySentimentScore(jcas);        
        ms.setSentimentScore(100);
        ms.addToIndexes();

        //unescaping makes the unicode characters (\\uXXXX) readable
        jcas.setDocumentText(StringEscapeUtils.unescapeJava(extract));
        jcas.setDocumentLanguage("x-unspecified");
        
        currentLine++;
     
	}
	
	//get text between markers	
	static String getExtract(String rawText, final String START, final String END)
    {
        int idxStart = rawText.indexOf(START);
        int idxEnd = rawText.indexOf(END, idxStart + START.length());

        if (idxStart < 0 || idxEnd < 0) {
            logWarn("Extraction of begin: [" + START + "] end: [" + END + "] failed in raw: ["
                    + rawText + "]");
            return "";
        }

        String extract = rawText.substring(idxStart + START.length(), idxEnd);
        return extract;
    }

    private static void logWarn(String message)
    {
        Logger.getLogger(MyReader.class.getName()).warning(message);
    }

}
