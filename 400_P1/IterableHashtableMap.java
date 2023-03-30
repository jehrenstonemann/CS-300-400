import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates HashtableMap which could be iterated by a iterator
 */
public class IterableHashtableMap<KeyType, ValueType> extends HashtableMap<KeyType, ValueType>
    implements IterableMapADT<KeyType, ValueType> {

  /**
   * Constructor of IterableHashtableMap with default capacity
   */
  public IterableHashtableMap() {
    super();
  }

  /**
   * Constructor of IterableHashtableMap with the input capacity
   * 
   * @param capacity length of array instance of IteratorHashtableMap
   */
  public IterableHashtableMap(int capacity) {
    super(capacity);
  }

  /**
   * create a iterator to iterate through a IterableHashtableMap
   * 
   * @return a iterator to iterate through a IterableHashtableMap
   */
  @Override
  public Iterator<ValueType> iterator() {
    return new HashtableMapIterator();
  }

  /**
   * This class is used to build a HashtableMapIterator which helps iterate through all valueType
   * value stored in a IterableHashtableMap
   */
  class HashtableMapIterator implements Iterator<ValueType> {

    public int arrayIndex = 0;
    public int linkedListIndex = -1;
    public int amount = 0;

    /**
     * Check where the iterator has next thing to iterate
     * 
     * @return true of has next thing to iterate, and false otherwise
     */
    @Override
    public boolean hasNext() {
      return amount < size();
    }
    
    /**
     * Return the next ValueType value
     * 
     * @return the next ValueType value
     */
    @Override
    public ValueType next() throws NoSuchElementException {
      if (hasNext()) {
        linkedListIndex++;
        amount++;
        while (hashMap[arrayIndex] != null && linkedListIndex >= hashMap[arrayIndex].size()) {
          linkedListIndex = 0;
          arrayIndex++;
        }
        return hashMap[arrayIndex].get(linkedListIndex).getValue();
      }
      throw new NoSuchElementException("no more to iterate");
    }

  }

}
