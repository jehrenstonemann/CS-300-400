import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMapperBackend implements IBookMapperBackend {


  private IterableHashtableMap database;
  private String authorFilter;


  public BookMapperBackend() { // initializes the fields to default values
    this.database = new IterableHashtableMap();
    this.authorFilter = null;
  }

  /**
   * Adds a new book to the backend's database and is stored in a hash table internally.
   * 
   * @param book the book to add
   */
  public void addBook(IBook book) {
    database.put(book.getISBN13(), book);
  }

  /**
   * Returns the number of books stored in the backend's database.
   * 
   * @return the number of books
   */
  public int getNumberOfBooks() {
    return database.size();
  }

  /**
   * This method can be used to set a filter for the author names contained in the search results. A
   * book is only returned as a result for a search by title, it is also contains the string
   * filterBy in the names of its authors.
   * 
   * @param filterBy the string that the book's author names must contain
   */
  public void setAuthorFilter(String filterBy) {
    this.authorFilter = filterBy;

  }

  /**
   * Returns the string used as the author filter, null if no author filter is currently s>
   * 
   * @return the author filter, or null if none is set
   */
  public String getAuthorFilter() {
    return this.authorFilter;
  }

  /**
   * Resets the author filter to null (no filter).
   */
  public void resetAuthorFilter() {
    this.authorFilter = null;
  }

  /**
   * Search through all the books in the title base and return books whose title contains the string
   * word (and that satisfies the author filter, if an author filter is set).
   * 
   * @param word word that must be contained in a book's title in result set
   * @return list of books found
   */
  public List<IBook> searchByTitleWord(String word) {
    List<IBook> retList = new ArrayList<IBook>();
    // if there is no filter dont check it
    if (this.authorFilter == null) {

      java.util.Iterator<Book> iterator = database.iterator();

      while (iterator.hasNext()) {
        Book nextBook = iterator.next();
        if (nextBook.getTitle().toLowerCase().contains(word.toLowerCase())) {
          retList.add(nextBook);
        }
      }
    }

    else {
      java.util.Iterator<Book> iterator = database.iterator();
      while (iterator.hasNext()) {
        Book nextBook = iterator.next();
        if (nextBook.getTitle().toLowerCase().contains(word.toLowerCase())
            && nextBook.getAuthors().toLowerCase().contains(this.authorFilter.toLowerCase())) {
          retList.add(nextBook);
        }
      }
    }
    
  

    return retList;

  }

  /**
   * Return the book uniquely identified by the ISBN, or null if ISBN is not present in th>
   * 
   * @param ISBN the book's ISBN number
   * @return the book identified by the ISBN, or null if ISBN not in database
   */
  public Book getByISBN(String ISBN) {
    Book retBook = null;
    if (database.containsKey(ISBN)) {
      retBook = (Book) database.get(ISBN);
    }
    return retBook;
  }

}
