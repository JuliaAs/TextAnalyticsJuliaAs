package de.unidue.langtech.teaching.pp.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;
import de.unidue.langtech.teaching.type.RawTweet;

public class MyReader extends JCasCollectionReader_ImplBase {
	
	/**
     * Input file
     */
    public static final String PARAM_INPUT_FILE = "InputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    private File inputFile;    
    
    private List<String> lines;
    private int currentLine;
    private static String nextLine = null;
    
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
           lines = FileUtils.readLines(inputFile);
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
		// TODO Auto-generated method stub
		
        //String[] parts = lines.get(currentLine).split("#");
		String line = lines.get(currentLine);
		String xt = getExtract(line, CREATE_MARKER, MARKER_END);
		//String[] parts;
    
        TweetTimeStamp ts = new TweetTimeStamp(jcas);
        ts.setTweetPostTime(xt);
        ts.addToIndexes();
        
     // set payload as the document text
        String extract = getExtract(line, TEXT_MARKER, MARKER_END);
        
     // annotate raw-tweet in an own type we 
        RawTweet raw = new RawTweet(jcas);
        raw.setRawTweet(extract);
        raw.addToIndexes();

        

        //unescaping makes the unicode characters (\\uXXXX) readable
        jcas.setDocumentText(StringEscapeUtils.unescapeJava(extract));
        jcas.setDocumentLanguage("x-unspecified");
        
        currentLine++;
     
	}
	
	private boolean containsValidFields(String nextLine)
    {
        // we test for a 'text'-information and the 'created_at' information if we find both we
        // conclude that a line is an actual twitter message
        return nextLine.contains(CREATE_MARKER) && nextLine.contains(TEXT_MARKER);
    }
	
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
