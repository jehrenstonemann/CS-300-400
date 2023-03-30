// --== CS400 Project One File Header ==--
// Name: Chengjun Wu
// CSL Username: chengjun
// Email: cwu372@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: None

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * This class creates HashtableMap which is used to store values according to their hashcode
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  protected LinkedList<KeyValuePair<KeyType, ValueType>>[] hashMap;
  private int size;
  private double load;

  /**
   * Constructor of HashtableMap with the input capacity
   * 
   * @param capacity length of array instance of HashtableMap
   */
  public HashtableMap(int capacity) {
    this.hashMap = new LinkedList[capacity];
    for (int i = 0; i < hashMap.length; i++) {
      hashMap[i] = new LinkedList<>();
    }
    this.size = 0;
    this.load = 0;
  }

  /**
   * Constructor of HashtableMap with default capacity
   */
  public HashtableMap() {
    // with default capacity = 15
    this.hashMap = new LinkedList[15];
    for (int i = 0; i < hashMap.length; i++) {
      hashMap[i] = new LinkedList<>();
    }
    this.size = 0;
    this.load = 0;
  }

  /**
   * Inserts a new (key, value) pair into the map if the map does not contain a value mapped to key
   * yet.
   * 
   * @param key   the key of the (key, value) pair to store
   * @param value the value that the key will map to
   * @return true if the (key, value) pair was inserted into the map, false if a mapping for key
   *         already exists and the new (key, value) pair could not be inserted
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    // TODO Auto-generated method stub
    if (key == null || containsKey(key)) {
      return false;
    }
    int index = absoluteHelper(key.hashCode()) % hashMap.length;
    KeyValuePair putPair = new KeyValuePair(key, value);
    if (hashMap[index] == null) {
      hashMap[index] = new LinkedList<>();
    }
    hashMap[index].add(putPair);
    size++;
    load = (double) size / hashMap.length;
    if (load >= 0.7) {
      doubleCapacity();
    }
    return true;
  }

  /**
   * Returns the value mapped to a key if the map contains such a mapping.
   * 
   * @param key the key for which to look up the value
   * @return the value mapped to the key
   * @throws NoSuchElementException if the map does not contain a mapping for the key
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (key == null) {
      throw new NoSuchElementException("No such key");
    }
    int index = absoluteHelper(key.hashCode()) % hashMap.length;
    for (int i = 0; i < hashMap[index].size(); i++) {
      if (hashMap[index].get(i).getKey().equals(key)) {
        return hashMap[index].get(i).getValue();
      }
    }
    throw new NoSuchElementException("No such key");
  }

  /**
   * Removes a key and its value from the map.
   * 
   * @param key the key for the (key, value) pair to remove
   * @return the value for the (key, value) pair that was removed, or null if the map did not
   *         contain a mapping for key
   */
  @Override
  public ValueType remove(KeyType key) {
    // TODO Auto-generated method stub
    if (key == null) {
      return null;
    }
    ValueType removed = null;
    int index = absoluteHelper(key.hashCode()) % hashMap.length;
    for (int i = 0; i < hashMap[index].size(); i++) {
      if (hashMap[index].get(i).getKey().equals(key)) {
        removed = hashMap[index].get(i).getValue();
        hashMap[index].remove(i);
        size--;
        load = (double) size / hashMap.length;
      }
    }
    return removed;
  }

  /**
   * Checks if a key is stored in the map.
   * 
   * @param key the key to check for
   * @return true if the key is stored (mapped to a value) by the map and false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    // TODO Auto-generated method stub
    if (key == null) {
      return false;
    }
    int index = absoluteHelper(key.hashCode()) % hashMap.length;
    if (hashMap[index] != null) {
      for (int i = 0; i < hashMap[index].size(); i++) {
        if (hashMap[index].get(i).getKey().equals(key)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Returns the number of (key, value) pairs stored in the map.
   * 
   * @return the number of (key, value) pairs stored in the map
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  /**
   * Removes all (key, value) pairs from the map.
   */
  @Override
  public void clear() {
    // TODO Auto-generated method stub
    for (int i = 0; i < hashMap.length; i++) {
      hashMap[i] = new LinkedList<>();
    }
    size = 0;
    load = 0.0;
  }

  /**
   * Calculate the absolute value of given hashcode
   * 
   * @param hashcode the hashcode needs to take adsolute value
   * @return the absolute value of given hashcode
   */
  private int absoluteHelper(int hashcode) {
    if (hashcode >= 0) {
      return hashcode;
    }
    return 0 - hashcode;
  }

  /**
   * Replace the original hashMap with a new array with double length, and rehash each element from
   * the old array into the new array
   */
  private void doubleCapacity() {
    LinkedList<KeyValuePair<KeyType, ValueType>>[] newHashMap = new LinkedList[2 * hashMap.length];
    for (int i = 0; i < newHashMap.length; i++) {
      newHashMap[i] = new LinkedList<>();
    }
    size = 0;
    load = 0.0;
    int index = -1;
    for (int i = 0; i < hashMap.length; i++) {
      if (hashMap[i] != null) {
        for (int j = 0; j < hashMap[i].size(); j++) {
          index = absoluteHelper(hashMap[i].get(j).getKey().hashCode()) % newHashMap.length;
          newHashMap[index].add(hashMap[i].get(j));
          size++;
          load = (double) size / newHashMap.length;
        }
      }
    }
    hashMap = newHashMap;
  }

}
