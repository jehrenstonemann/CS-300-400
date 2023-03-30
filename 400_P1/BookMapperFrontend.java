// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * front end implementation
 * 
 * @author Huang Xiangyu
 *
 */
public class BookMapperFrontend implements IBookMapperFrontend{

	private IBookMapperBackend backend;  // backend instance
	private Scanner scnr;				 // scanner to reach user input
	private IISBNValidator validator;    // validator instance
	private String input;				 // trace user input
	
	/**
	 * It takes the Scanner that will read user input as
     * a parameter as well as the backend and the ISBNnalidator.
     * 
	 * @param userInputScanner  user input await to be scanned
	 * @param backend  backend instance
	 * @param validator  validator instance
	 */
	public BookMapperFrontend(Scanner userInputScanner, IBookMapperBackend backend, IISBNValidator validator){
		scnr = new Scanner(System.in);
		this.backend = backend;
		this.validator = validator;
	}
	
	/**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
	@Override
	public void runCommandLoop() {
		System.out.println("Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n");
		displayMainMenu();
		this.input=scnr.nextLine();   // let user enter an input and utilize this input in further decision
		while(!input.equals("4")) {
			if(input.equals("1")) {
				isbnLookup();
				displayMainMenu();
//				this.input=scnr.nextLine();
			}
			if(input.equals("2")) {
				titleSearch();
				displayMainMenu();
//				this.input=scnr.nextLine();
			}
			if(input.equals("3")) {
				titleSearch();
				displayMainMenu();
//				this.input=scnr.nextLine();
			}
			
			//new added by Chengun Wu, Oct 11th
			
			this.input=scnr.nextLine();
		}
		System.out.println("Goodbye!");
	}

	/**
	 * prints command options to System.out
	 */
	@Override
	public void displayMainMenu() {
		String newline = System.lineSeparator();
		System.out.println("You are in the Main Menu:" + 
		newline + "          1) Lookup ISBN" + 
		newline + "          2) Search by Title Word" +
		newline + "          3) Set Author Name Filter" +
		newline + "          4) Exit Application");
	}

	/**
	 * displays a list of books
	 */
	@Override
	public void displayBooks(List<IBook> books) {
		for(int i =0; i<books.size();i++) {
			System.out.println((i+1)+". "+"\""+books.get(i).getTitle()+"\""+" by "+books.get(i).getAuthors()+", ISBN: "+books.get(i).getISBN13());
			System.out.println();
		}
	}

	/**
	 * reads word from System.in, displays results
	 */
	@Override
	public void isbnLookup() {
		System.out.print("You are in the Lookup ISBN Menu: \n          Enter ISBN to look up: ");
		this.input = scnr.nextLine();
		if(validator.validate(input)==true) {
			IBook res = this.backend.getByISBN(input);
			if(res == null) {
				System.out.println("Corresponding Book does NOT found");
			}
			else {
				displayBooks(Arrays.asList(new IBook[] {res}));
			}
		}
		if(validator.validate(input)==false) {
			System.out.println("!!!WARNING (invalid ISBN number)!!!");
		}
	}

	/**
	 * reads author name from System.in, displays results
	 */
	@Override
	public void titleSearch() {
		// if user input 3 set author
		if(this.input.equals("3")) {
			if(backend.getAuthorFilter()==null) {
				System.out.println("You are in the Set Author Filter Menu: \n          Author name must currently contain: none");
			}
			if(backend.getAuthorFilter()!=null) {
				System.out.println("You are in the Set Author Filter Menu: \n          Author name must currently contain: " + backend.getAuthorFilter());
			}
			System.out.print("Enter a new string for author names to contain (empty for any): ");
			this.input = scnr.nextLine();
			if(input!=null)
				backend.setAuthorFilter(input);
			if(input=="")
				backend.resetAuthorFilter();
		}
		// if user input 2
		if(this.input.equals("2")) {
			System.out.print("You are in the Search for Title Word Menu: \n          Enter a word to search for in book titles (empty for all books): ");
			this.input=scnr.nextLine();
			if(backend.getAuthorFilter()==null) {
				System.out.println("Matches (any author) "+backend.searchByTitleWord(this.input).size()+" of "+ backend.getNumberOfBooks()); 
			}
			if(backend.getAuthorFilter()!=null) {
				System.out.println("Matches (author filter: "+ backend.getAuthorFilter()+") "+backend.searchByTitleWord(this.input).size()+" of "+ backend.getNumberOfBooks());
			}
			List<IBook> res = this.backend.searchByTitleWord(input);
			displayBooks(res);
			if(backend.getAuthorFilter()==null) {
				System.out.println("Matches (any author) "+backend.searchByTitleWord(this.input).size()+" of "+ backend.getNumberOfBooks()); 
			}
			if(backend.getAuthorFilter()!=null) {
				System.out.println("Matches (author filter: "+ backend.getAuthorFilter()+") "+backend.searchByTitleWord(this.input).size()+" of "+ backend.getNumberOfBooks());
			}
		}
	}
}