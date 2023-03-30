// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

/**
 * placeholder class for book 1 - testing purpose
 * 
 * @author Huang Xiangyu
 *
 */
public class Book_1 implements IBook{

	/**
	 * get the title for this book
	 * 
	 * @return title "Title 1"
	 */
	@Override
	public String getTitle() {
		return "Title 1";
	}

	/**
	 * get the author for this book
	 * 
	 * @return author "Author 1, Author 2"
	 */
	@Override
	public String getAuthors() {
		return "Author 1, Author 2";
	}

	/**
	 * get the ISBN number for this book
	 * 
	 * @return ISBN "1234567890123"
	 */
	@Override
	public String getISBN13() {
		return "1234567890123";
	}
	
}
