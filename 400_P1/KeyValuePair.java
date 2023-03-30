// --== CS400 Project One File Header ==--
// Name: Chengjun Wu
// CSL Username: chengjun
// Email: cwu372@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: None

/**
 * This class creates pairs of key and value to be used in HashtableMap
 */
public class KeyValuePair<KeyType, ValueType> {
  
  private KeyType key;
  private ValueType value;
  private KeyValuePair<KeyType, ValueType> next;
  
  /**
   * Create a pair of key and value
   * 
   * @param key key be put in the pair
   * @param value value be put in the pair
   */
  public KeyValuePair(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }
  
  /**
   * return the key of the KeyValue pair 
   * 
   * @return key of the pair
   */
  public KeyType getKey() {
    return key;
  }
 
  /**
   * return the value of the KeyValue pair 
   * 
   * @return value of the pair
   */
  public ValueType getValue() {
    return value;
  }
 
}
