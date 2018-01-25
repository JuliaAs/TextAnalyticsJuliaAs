
/* First created by JCasGen Tue Oct 15 15:43:58 CEST 2013 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Jan 01 23:59:25 CET 2018
 * @generated */
public class DetectedLanguage_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DetectedLanguage.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.DetectedLanguage");
 
  /** @generated */
  final Feature casFeat_language;
  /** @generated */
  final int     casFeatCode_language;
  /** @generated */ 
  public String getLanguage(int addr) {
        if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "de.unidue.langtech.teaching.pp.type.DetectedLanguage");
    return ll_cas.ll_getStringValue(addr, casFeatCode_language);
  }
  /** @generated */    
  public void setLanguage(int addr, String v) {
        if (featOkTst && casFeat_language == null)
      jcas.throwFeatMissing("language", "de.unidue.langtech.teaching.pp.type.DetectedLanguage");
    ll_cas.ll_setStringValue(addr, casFeatCode_language, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DetectedLanguage_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_language = jcas.getRequiredFeatureDE(casType, "language", "uima.cas.String", featOkTst);
    casFeatCode_language  = (null == casFeat_language) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_language).getCode();

  }
}



    