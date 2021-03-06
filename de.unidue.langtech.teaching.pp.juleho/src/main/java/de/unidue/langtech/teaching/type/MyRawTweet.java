

/* First created by JCasGen Fri Mar 16 17:49:47 CET 2018 */
package de.unidue.langtech.teaching.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Mar 16 17:49:47 CET 2018
 * XML source: C:/Users/Peixaton/Desktop/jsp/git/TextAnalyticsJuliaAsss/de.unidue.langtech.teaching.pp.juleho/src/main/resources/desc/type/MyRawTweet.xml
 * @generated */
public class MyRawTweet extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MyRawTweet.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected MyRawTweet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public MyRawTweet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public MyRawTweet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public MyRawTweet(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: rawTweet

  /** getter for rawTweet - gets 
   * @generated
   * @return value of the feature 
   */
  public String getRawTweet() {
    if (MyRawTweet_Type.featOkTst && ((MyRawTweet_Type)jcasType).casFeat_rawTweet == null)
      jcasType.jcas.throwFeatMissing("rawTweet", "de.unidue.langtech.teaching.type.MyRawTweet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MyRawTweet_Type)jcasType).casFeatCode_rawTweet);}
    
  /** setter for rawTweet - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRawTweet(String v) {
    if (MyRawTweet_Type.featOkTst && ((MyRawTweet_Type)jcasType).casFeat_rawTweet == null)
      jcasType.jcas.throwFeatMissing("rawTweet", "de.unidue.langtech.teaching.type.MyRawTweet");
    jcasType.ll_cas.ll_setStringValue(addr, ((MyRawTweet_Type)jcasType).casFeatCode_rawTweet, v);}    
  }

    