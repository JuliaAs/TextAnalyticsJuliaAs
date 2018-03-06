package de.unidue.langtech.teaching.pp.example;

import java.io.IOException;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.example.pipeline.BasicPipeline;

public class Starter {
	static BasicPipeline bp;
	public Starter() throws ResourceInitializationException, UIMAException, IOException {
		System.out.println("Starter");
		bp = new BasicPipeline();
	}

}
