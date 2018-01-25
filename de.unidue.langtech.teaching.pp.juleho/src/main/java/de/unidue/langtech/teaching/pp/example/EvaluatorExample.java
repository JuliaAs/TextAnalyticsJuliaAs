package de.unidue.langtech.teaching.pp.example;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.DetectedLanguage;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.TweetTimeStamp;

public class EvaluatorExample
    extends JCasAnnotator_ImplBase
{

    private int correct;
    private int nrOfDocuments;
    
    /* 
     * This is called BEFORE any documents are processed.
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        correct = 0;
        nrOfDocuments = 0;
    }
    
    
    /* 
     * This is called ONCE for each document
     */
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        
        //TweetTimeStamp tt = JCasUtil.selectSingle(jcas, TweetTimeStamp.class);
        //System.out.println(tt.getTweetPostTime() + "*****Evaluator****");
    	DetectedLanguage detected = JCasUtil.selectSingle(jcas, DetectedLanguage.class);
        GoldLanguage actual = JCasUtil.selectSingle(jcas, GoldLanguage.class);

        System.out.println(actual.getLanguage() + " detected as " + detected.getLanguage());
        
        nrOfDocuments++;
        // FIXME: Keep track of correctly classified documents! 
    }


    /* 
     * This is called AFTER all documents have been processed.
     */
    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
        System.out.println(correct + " out of " + nrOfDocuments + " are correct.");
    }
}