
/* First created by JCasGen Tue Jan 02 00:03:21 CET 2018 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Jan 02 00:03:21 CET 2018
 * @generated */
public class TweetTimeStamp_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TweetTimeStamp.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.TweetTimeStamp");
 
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
      jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.type.TweetTimeStamp");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tweetPostTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTweetPostTime(int addr, String v) {
        if (featOkTst && casFeat_tweetPostTime == null)
      jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.type.TweetTimeStamp");
    ll_cas.ll_setStringValue(addr, casFeatCode_tweetPostTime, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TweetTimeStamp_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tweetPostTime = jcas.getRequiredFeatureDE(casType, "tweetPostTime", "uima.cas.String", featOkTst);
    casFeatCode_tweetPostTime  = (null == casFeat_tweetPostTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tweetPostTime).getCode();

  }
}



    