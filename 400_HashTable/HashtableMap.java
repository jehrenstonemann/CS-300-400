// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * implementation of a hashMap
 * 
 * @author Huang Xiangyu
 *
 * @param <KeyType> generic type for key
 * @param <ValueType> generic type for value
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

	private double load; // keep track of load factor
	private int size; // keep track of current size of the hashMap
	protected LinkedList<Pair<KeyType, ValueType>>[] hashMap; // create a linkedList of pairs
	
	/**
	 * constructing a hashMap with given capacity
	 * 
	 * @param capacity wished capacity of the hashMap
	 */
	public HashtableMap(int capacity) {
	    hashMap = new LinkedList[capacity];
	    for (int i = 0; i < hashMap.length; i++) {
	      hashMap[i] = new LinkedList<Pair<KeyType, ValueType>>();
	    }
	    size = 0;
	    load = 0;
	}

	/**
	 * constructing a hashMap with default capacity 15
	 */
	public HashtableMap() {
	    hashMap = new LinkedList[15];
	    for (int i = 0; i < hashMap.length; i++) {
	      hashMap[i] = new LinkedList<>();
	    }
	    size = 0;
	    load = 0;
	}

	/**
	 * helper method. It doubles the capacity and rehash when load >= 0.7
	 */
	private void grow() {
	    LinkedList<Pair<KeyType, ValueType>>[] newHashMap = new LinkedList[2 * hashMap.length];
	    for(int i = 0; i<newHashMap.length;i++) {
	    	newHashMap[i] = new LinkedList<>();
	    }
	    size = 0;
	    load = (double) size / hashMap.length;
	    int index = -1;
	    for(int i = 0; i<hashMap.length;i++) {
	    	if(hashMap[i] != null) {
	    		for (int j=0; j < hashMap[i].size();j++) {
	    			int hashValue = hashMap[i].get(j).getKey().hashCode();
	    			index = Math.abs(hashValue)% newHashMap.length;
	    			newHashMap[index].add(hashMap[i].get(j));
	    			size++;
	    			load=(double)size/newHashMap.length;
	    		}
	    	}
	    }
	    hashMap = newHashMap;
	  }

	/**
	 * Inserts a new (key, value) pair into the map if the map does not contain a
	 * value mapped to key yet.
	 * 
	 * @param key   the key of the (key, value) pair to store
	 * @param value the value that the key will map to
	 * @return true if the (key, value) pair was inserted into the map, false if a
	 *         mapping for key already exists and the new (key, value) pair could
	 *         not be inserted
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {
		if (containsKey(key)||key==null) {
			return false;
		}
		Pair<KeyType, ValueType> pair = new Pair<KeyType, ValueType>(key, value);
		int hashValue = key.hashCode();
		int index = Math.abs(hashValue) % hashMap.length;
		if(hashMap[index] == null) {
			hashMap[index] = new LinkedList<Pair<KeyType, ValueType>>();
		}
		hashMap[index].add(pair);
		size++;
		load = (double) size / hashMap.length;
		if (load >= 0.7) {
			grow();
		}
		return true;
	}

	/**
	 * Returns the value mapped to a key if the map contains such a mapping.
	 * 
	 * @param key the key for which to look up the value
	 * @return the value mapped to the key
	 * @throws NoSuchElementException if the map does not contain a mapping for the
	 *                                key
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		int hashValue = key.hashCode();
		int index = Math.abs(hashValue) % hashMap.length;
		for (int i = 0; i < hashMap[index].size(); i++) {
			if (hashMap[index].get(i).getKey().equals(key)) {
				return hashMap[index].get(i).getValue();
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Removes a key and its value from the map.
	 * 
	 * @param key the key for the (key, value) pair to remove
	 * @return the value for the (key, value) pair that was removed, or null if the
	 *         map did not contain a mapping for key
	 */
	@Override
	public ValueType remove(KeyType key) {
		if(!containsKey(key))
			return null;
		int hashValue = key.hashCode();
		int index = Math.abs(hashValue) % hashMap.length;
		ValueType result = null;
		for (int i = 0; i < hashMap[index].size(); i++) {
			if (hashMap[index].get(i).getKey().equals(key)) {
				result = hashMap[index].get(i).getValue(); //get(key)
				hashMap[index].remove(i);
				size--;
				load = (double) size / hashMap.length;
			}
		}
		return result;
	}

	/**
	 * Checks if a key is stored in the map.
	 * 
	 * @param key the key to check for
	 * @return true if the key is stored (mapped to a value) by the map and false
	 *         otherwise
	 */
	@Override
	public boolean containsKey(KeyType key) {
		if(key == null) {
			return false;
		}
		int hashValue = key.hashCode();
		int index = Math.abs(hashValue) % hashMap.length;
		if(hashMap[index]!=null) {
			for (int i = 0; i < hashMap[index].size(); i++) {
				if (hashMap[index].get(i).getKey().equals(key))
					return true;
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
		return size;
	}

	/**
	 * Removes all (key, value) pairs from the map.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < hashMap.length; i++) {
			hashMap[i] = new LinkedList<>();
		}
		size = 0;
		load = (double) size / hashMap.length;
	}

}
