
/* First created by JCasGen Wed Mar 14 21:32:04 CET 2018 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Mar 14 21:32:04 CET 2018
 * @generated */
public class MySentimentScore_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MySentimentScore.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.MySentimentScore");
 
  /** @generated */
  final Feature casFeat_sentimentScore;
  /** @generated */
  final int     casFeatCode_sentimentScore;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getSentimentScore(int addr) {
        if (featOkTst && casFeat_sentimentScore == null)
      jcas.throwFeatMissing("sentimentScore", "de.unidue.langtech.teaching.pp.type.MySentimentScore");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_sentimentScore);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentimentScore(int addr, float v) {
        if (featOkTst && casFeat_sentimentScore == null)
      jcas.throwFeatMissing("sentimentScore", "de.unidue.langtech.teaching.pp.type.MySentimentScore");
    ll_cas.ll_setFloatValue(addr, casFeatCode_sentimentScore, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public MySentimentScore_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentimentScore = jcas.getRequiredFeatureDE(casType, "sentimentScore", "uima.cas.Float", featOkTst);
    casFeatCode_sentimentScore  = (null == casFeat_sentimentScore) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentimentScore).getCode();

  }
}



    