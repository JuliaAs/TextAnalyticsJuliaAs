package myTests;

import static org.junit.Assert.*;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.example.MyReader;
import de.unidue.langtech.teaching.pp.type.MySentimentScore;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

public class MyReaderTest {

	@Test
    public void testDocumentText()
        throws Exception
    {

        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(MyReader.class,
                MyReader.PARAM_INPUT_FILE, "src/test/resources/test/readertest.txt");
        
        

        int i = 0;
        for (JCas jcas : new JCasIterable(reader)) {
        	System.out.println(jcas.getDocumentText());
        	
            assertNotNull(jcas.getDocumentText());
            assertFalse(jcas.getDocumentText().isEmpty());
           if(i==0) {
        	   //we know the text in the first line
            assertEquals("reader test first line 123 hello",jcas.getDocumentText());
            TweetTimeStamp tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
            assertEquals("Thu Nov 23 16:59:48 +0000 2017",tt.getTweetPostTime());            
           
           }
           if(i==1) {
        	   //we know the text in the second line
        	   assertEquals("second line for reader test hello",jcas.getDocumentText());
           }
           //we know the the text in thethird line
           if(i==2) {
        	   assertEquals("third line what can i say",jcas.getDocumentText());
           }
            i++;
        }
       
    }	
	
}
