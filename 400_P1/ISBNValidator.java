/**
 * This class help check whether a given isbn13 is valid
 */
public class ISBNValidator implements IISBNValidator {

  /**
   * Check whether the given isbn13 is valid
   * 
   * @param isbn13 a String input may be a isbn13
   * @return true if it is a valid isbn13, and false otherwise
   */
  @Override
  public boolean validate(String isbn13) {
    if (isbn13 == null || isbn13.length() != 13) {
      return false;
    }
    int sum = 0;
    for (int i = 0; i < isbn13.length(); i++) {
      try {
        sum += (2 * (i % 2) + 1) * Integer.parseInt(isbn13.substring(i, i + 1));
      } catch (Exception e) {
        return false;
      }
    }
    if (sum % 10 != 0) {
      return false;
    }
    return true;
  }
  
}
