
/* First created by JCasGen Mon Jan 01 23:59:25 CET 2018 */
package de.unidue.langtech.teaching.pp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Jan 02 00:00:53 CET 2018
 * @generated */
public class juleho_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = juleho.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.juleho");
 
  /** @generated */
  final Feature casFeat_tweetPostTime;
  /** @generated */
  final int     casFeatCode_tweetPostTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTweetPostTime(int addr) {
        if (featOkTst && casFeat_tweetPostTime == null)
      jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.juleho");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tweetPostTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTweetPostTime(int addr, String v) {
        if (featOkTst && casFeat_tweetPostTime == null)
      jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.juleho");
    ll_cas.ll_setStringValue(addr, casFeatCode_tweetPostTime, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public juleho_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tweetPostTime = jcas.getRequiredFeatureDE(casType, "tweetPostTime", "uima.cas.String", featOkTst);
    casFeatCode_tweetPostTime  = (null == casFeat_tweetPostTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tweetPostTime).getCode();

  }
}



    