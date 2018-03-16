
/* First created by JCasGen Thu Sep 04 09:09:22 CEST 2014 */
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
 * Updated by JCasGen Wed Mar 14 21:28:56 CET 2018
 * @generated */
public class MyType_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MyType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.MyType");
 
  /** @generated */
  final Feature casFeat_MySentimentScore;
  /** @generated */
  final int     casFeatCode_MySentimentScore;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getMySentimentScore(int addr) {
        if (featOkTst && casFeat_MySentimentScore == null)
      jcas.throwFeatMissing("MySentimentScore", "de.unidue.langtech.teaching.pp.type.MyType");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_MySentimentScore);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMySentimentScore(int addr, float v) {
        if (featOkTst && casFeat_MySentimentScore == null)
      jcas.throwFeatMissing("MySentimentScore", "de.unidue.langtech.teaching.pp.type.MyType");
    ll_cas.ll_setFloatValue(addr, casFeatCode_MySentimentScore, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public MyType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_MySentimentScore = jcas.getRequiredFeatureDE(casType, "MySentimentScore", "uima.cas.Float", featOkTst);
    casFeatCode_MySentimentScore  = (null == casFeat_MySentimentScore) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_MySentimentScore).getCode();

  }
}



    