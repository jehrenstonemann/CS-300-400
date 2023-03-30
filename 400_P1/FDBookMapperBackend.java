// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

import java.util.Arrays;
import java.util.List;

/**
 * Placeholder for backend implementation
 * 
 * @author Huang Xiangyu
 *
 */
public class FDBookMapperBackend implements IBookMapperBackend{

	private String authorFilter;   // store authorFilter
	
	/**
	 * is not required as a placeholder for FD
	 */
	@Override
	public void addBook(IBook book) {
		// unimplemented	
	}

	/**
	 * 3 books stored in the backend's database
	 * hard-coded for testing purpose
	 * 
	 * @return 3
	 */
	@Override
	public int getNumberOfBooks() {
		return 3;
	}

	/**
	 * set the author filter
	 * hard-coded for testing purpose
	 */
	@Override
	public void setAuthorFilter(String filterBy) {
		authorFilter=filterBy;
		
	}

	/**
	 * get the author filter
	 * hard-coded for testing purpose
	 * 
	 * @return current authorFilter
	 */
	@Override
	public String getAuthorFilter() {
		return authorFilter;
	}

	/**
	 * set author filter to null
	 * hard-coded for testing purpose
	 */
	@Override
	public void resetAuthorFilter() {
		authorFilter=null;
	}

	/**
	 * return two books #1 #3
	 * hard-coded for testing purpose
	 * 
	 * @return a list of book satisfy the search by word
	 */
	@Override
	public List<IBook> searchByTitleWord(String word) {
		return Arrays.asList(new IBook[]{new Book_1(), new Book_3()});
	}

	/**
	 * return book #2
	 * hard-coded for testing purpose
	 * 
	 * @return book 2
	 */
	@Override
	public IBook getByISBN(String ISBN) {
		return new Book_2();
	}

}
