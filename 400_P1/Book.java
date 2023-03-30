/**
 * This class provides getter methods for each book's data attributes
 * and represents a book and its associated data.
 */
public class Book implements IBook {
    
    private String title;       // title of book
    private String authors;     // authors of the book
    private String isbn13;      // isbn13 number of book
    
    /**
     * This method allows the title to be updated
     * with a String value
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * This method allows authors to be updated
     * with a String value
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    
    /**
     * This method allows the isbn13 to be updated
     * with a String value
     * @param isbn13
     */
    public void setISBN13(String isbn13) {
        this.isbn13 = isbn13;
    }
    /**
     * Returns the title of the book.
     * @return title title of the book
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns a string that contains the authors of the book
     * as a single string with different authors separated by /.
     * @return authors author names as single string
     */
    @Override
    public String getAuthors() {

        return this.authors;
    }

    /**
     * Returns the 13 digit ISBN (ISBN13) that uniquely identifies this book.
     * @return isbn13 ISBN number of book
     */
    @Override
    public String getISBN13() {
        // TODO Auto-generated method stub
        return this.isbn13;
    }

}
