

/* First created by JCasGen Wed Mar 14 21:32:04 CET 2018 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Mar 14 21:32:04 CET 2018
 * XML source: C:/Users/Peixaton/Desktop/jsp/git/TextAnalyticsJuliaAsss/de.unidue.langtech.teaching.pp.juleho/src/main/resources/desc/type/MySentimentScore.xml
 * @generated */
public class MySentimentScore extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MySentimentScore.class);
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
  protected MySentimentScore() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public MySentimentScore(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public MySentimentScore(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public MySentimentScore(JCas jcas, int begin, int end) {
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
  //* Feature: sentimentScore

  /** getter for sentimentScore - gets 
   * @generated
   * @return value of the feature 
   */
  public float getSentimentScore() {
    if (MySentimentScore_Type.featOkTst && ((MySentimentScore_Type)jcasType).casFeat_sentimentScore == null)
      jcasType.jcas.throwFeatMissing("sentimentScore", "de.unidue.langtech.teaching.pp.type.MySentimentScore");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((MySentimentScore_Type)jcasType).casFeatCode_sentimentScore);}
    
  /** setter for sentimentScore - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentimentScore(float v) {
    if (MySentimentScore_Type.featOkTst && ((MySentimentScore_Type)jcasType).casFeat_sentimentScore == null)
      jcasType.jcas.throwFeatMissing("sentimentScore", "de.unidue.langtech.teaching.pp.type.MySentimentScore");
    jcasType.ll_cas.ll_setFloatValue(addr, ((MySentimentScore_Type)jcasType).casFeatCode_sentimentScore, v);}    
  }

    