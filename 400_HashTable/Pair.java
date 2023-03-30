// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

/**
 * creates a value pair with respective key and value
 * 
 * @author Huang Xiangyu
 *
 * @param <KeyType> generic type for key
 * @param <ValueType> generic type for value
 */
public class Pair <KeyType, ValueType>{
	
	private KeyType key;     // key of the pair
	private ValueType value; // value of the pair
	
	/**
	 * constructor of the pair
	 * 
	 * @param key key of the pair
	 * @param value value of the pair
	 */
	public Pair(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * getter method for pair's key
	 * 
	 * @return key of the pair
	 */
	public KeyType getKey() {
		return key;
	}
	
	/**
	 * getter method for pair's value
	 * 
	 * @return value of the pair
	 */
	public ValueType getValue() {
		return value;
	}
}
