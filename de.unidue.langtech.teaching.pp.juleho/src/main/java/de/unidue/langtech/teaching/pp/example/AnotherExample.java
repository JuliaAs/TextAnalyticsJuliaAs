package de.unidue.langtech.teaching.pp.example;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;

public class AnotherExample extends JCasAnnotator_ImplBase {
	
	private FrequencyDistribution<String> freq;

	public void initialize(UimaContext context) throws ResourceInitializationException {
		//SomeOtherExample.soemethode();
		//freq=SomeOtherExample.getmethode();
		//System.out.println(freq);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		//System.out.println("Anotherexample");
	}

	public void collectionProcessComplete() {

	}
}
