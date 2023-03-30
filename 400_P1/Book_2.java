// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

/**
 * placeholder class for book 2 - testing purpose
 * 
 * @author Huang Xiangyu
 *
 */
public class Book_2 implements IBook{

	/**
	 * get the title for this book
	 * 
	 * @return title "Title 2"
	 */
	@Override
	public String getTitle() {
		return "Title 2";
	}
	
	/**
	 * get the author for this book
	 * 
	 * @return author "Author 3, Author 4"
	 */
	@Override
	public String getAuthors() {
		return "Author 3, Author 4";
	}
	
	/**
	 * get the ISBN number for this book
	 * 
	 * @return ISBN number "1234567890333"
	 */
	@Override
	public String getISBN13() {
		return "1234567890333";
	}
	
}
