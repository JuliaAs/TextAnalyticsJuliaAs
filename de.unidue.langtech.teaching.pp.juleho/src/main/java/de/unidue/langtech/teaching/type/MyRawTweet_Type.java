
/* First created by JCasGen Fri Mar 16 17:49:47 CET 2018 */
package de.unidue.langtech.teaching.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Mar 16 17:49:47 CET 2018
 * @generated */
public class MyRawTweet_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MyRawTweet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.type.MyRawTweet");
 
  /** @generated */
  final Feature casFeat_rawTweet;
  /** @generated */
  final int     casFeatCode_rawTweet;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRawTweet(int addr) {
        if (featOkTst && casFeat_rawTweet == null)
      jcas.throwFeatMissing("rawTweet", "de.unidue.langtech.teaching.type.MyRawTweet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_rawTweet);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRawTweet(int addr, String v) {
        if (featOkTst && casFeat_rawTweet == null)
      jcas.throwFeatMissing("rawTweet", "de.unidue.langtech.teaching.type.MyRawTweet");
    ll_cas.ll_setStringValue(addr, casFeatCode_rawTweet, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public MyRawTweet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_rawTweet = jcas.getRequiredFeatureDE(casType, "rawTweet", "uima.cas.String", featOkTst);
    casFeatCode_rawTweet  = (null == casFeat_rawTweet) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rawTweet).getCode();

  }
}



    