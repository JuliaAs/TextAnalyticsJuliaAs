

/* First created by JCasGen Mon Jan 01 23:59:25 CET 2018 */
package de.unidue.langtech.teaching.pp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Jan 02 00:00:53 CET 2018
 * XML source: C:/Users/Peixaton/Desktop/txtanalytics/GIT/de.unidue.langtech.teaching.pp.juleho/src/main/resources/desc/type/TweetTimeStamp.xml
 * @generated */
public class juleho extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(juleho.class);
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
  protected juleho() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public juleho(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public juleho(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public juleho(JCas jcas, int begin, int end) {
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
  //* Feature: tweetPostTime

  /** getter for tweetPostTime - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTweetPostTime() {
    if (juleho_Type.featOkTst && ((juleho_Type)jcasType).casFeat_tweetPostTime == null)
      jcasType.jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.juleho");
    return jcasType.ll_cas.ll_getStringValue(addr, ((juleho_Type)jcasType).casFeatCode_tweetPostTime);}
    
  /** setter for tweetPostTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTweetPostTime(String v) {
    if (juleho_Type.featOkTst && ((juleho_Type)jcasType).casFeat_tweetPostTime == null)
      jcasType.jcas.throwFeatMissing("tweetPostTime", "de.unidue.langtech.teaching.pp.juleho");
    jcasType.ll_cas.ll_setStringValue(addr, ((juleho_Type)jcasType).casFeatCode_tweetPostTime, v);}    
  }

    