
/* First created by JCasGen Fri Dec 29 00:07:36 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Dec 29 00:11:27 CET 2017
 * @generated */
public class DingsType_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DingsType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.DingsType");
 
  /** @generated */
  final Feature casFeat_countLetterA;
  /** @generated */
  final int     casFeatCode_countLetterA;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountLetterA(int addr) {
        if (featOkTst && casFeat_countLetterA == null)
      jcas.throwFeatMissing("countLetterA", "de.unidue.langtech.teaching.pp.type.DingsType");
    return ll_cas.ll_getIntValue(addr, casFeatCode_countLetterA);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountLetterA(int addr, int v) {
        if (featOkTst && casFeat_countLetterA == null)
      jcas.throwFeatMissing("countLetterA", "de.unidue.langtech.teaching.pp.type.DingsType");
    ll_cas.ll_setIntValue(addr, casFeatCode_countLetterA, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public DingsType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_countLetterA = jcas.getRequiredFeatureDE(casType, "countLetterA", "uima.cas.Integer", featOkTst);
    casFeatCode_countLetterA  = (null == casFeat_countLetterA) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_countLetterA).getCode();

  }
}



    