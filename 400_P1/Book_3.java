// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

/**
 * placeholder class for book 3 - testing purpose
 * 
 * @author Huang Xiangyu
 *
 */
public class Book_3 implements IBook{

	/**
	 * get the title for this book
	 * 
	 * @return title "Title 3"
	 */
	@Override
	public String getTitle() {
		return "Title 3";
	}
	
	/**
	 * get the author for this book
	 * 
	 * @return author "Author 4, Author 5, Author 6"
	 */
	@Override
	public String getAuthors() {
		return "Author 4, Author 5, Author 6";
	}
	
	/**
	 * get the ISBN number for this book
	 * 
	 * @return ISBN number "1234227890333"
	 */
	@Override
	public String getISBN13() {
		return "1234227890333";
	}
	
}
