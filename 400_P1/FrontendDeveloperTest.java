// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: 

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * tester for frontend implementation
 * 
 * @author Huang Xiangyu
 *
 */
public class FrontendDeveloperTest {
	
	/**
	 * welcome menu -> Lookup ISBN -> Goodbye
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test1() {
		TextUITester temp = new TextUITester("1\n1235475869361\n4");
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		String output = temp.checkOutput();
		
		// contains "Welcome ..."        -- Welcome Menu      displays correctly
		// contains "Main Menu:"         -- Main Menu         displays correctly
		// contains "Goodbye!"           -- Ending            displays correctly
		
		// contains Book 2               -- Lookup ISBN Menu  displays correctly
		// contains "Lookup ISBN Menu:"  -- Lookup ISBN Menu  displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") && 
			output.contains("Main Menu:") && output.contains("Goodbye!") && 
			output.contains("1. \"Title 2\" by Author 3, Author 4, ISBN: 1234567890333") && output.contains("Lookup ISBN Menu:"))
			return true;
		return false;
	}
	
	/**
	 * welcome menu -> Set Author Filter(current: none) -> Goodbye
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test2() {
		TextUITester temp = new TextUITester("3\nJames Joyce\n4");
		
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		
		String output = temp.checkOutput();
		
		// contains "Welcome ..."              -- Welcome                 displays correctly
		// contains "Main Menu:"               -- Main Menu               displays correctly
		// contains "Goodbye!"                 -- Ending                  displays correctly
		
		// contains "contain: none"            -- Set Author Filter Menu  displays correctly
		// contains "Set Author Filter Menu:"  -- Set Author Filter Menu  displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") &&
			output.contains("Main Menu:") && output.contains("Goodbye!") &&
			output.contains("contain: none") && output.contains("Set Author Filter Menu:"))
			return true;
		return false;
	}
	
	/**
	 * welcome menu -> Set Author Filter(current: James Joyce) -> Goodbye
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test3() {
		TextUITester temp = new TextUITester("3\nJames Joyce\n3\n\n4");
		
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		
		String output = temp.checkOutput();
		
		// contains "Welcome ..."              -- Welcome                 displays correctly
		// contains "Main Menu:"               -- Main Menu               displays correctly
		// contains "Goodbye!"                 -- Ending                  displays correctly
		
		// contains "contain: none"            -- Set Author Filter Menu  displays correctly
		// contains "Set Author Filter Menu:"  -- Set Author Filter Menu  displays correctly
		// contains "contain: James Joyce"     -- Set Author Filter Menu  displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") &&
			output.contains("Main Menu:") && output.contains("Goodbye!") &&
			output.contains("contain: none") && output.contains("Set Author Filter Menu:") &&
			output.contains("contain: James Joyce"))
			return true;
		return false;
	}
	
	/**
	 * welcome menu -> Title Word Menu(anyAuthor) -> Goodbye
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test4() {
		TextUITester temp = new TextUITester("2\nBook Title\n4");
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		String output = temp.checkOutput();
		
		// contains "Welcome ..."                   -- Welcome                 displays correctly
		// contains "Main Menu:"                    -- Main Menu               displays correctly
		// contains "Goodbye!"                      -- Ending                  displays correctly

		// contains "Matches (any author)"          -- Title Word Menu         displays correctly
		// contains "Title Word Menu:"              -- Title Word Menu         displays correctly
		// contains "2 of 3"                        -- Title Word Menu         displays correctly
		// contains "Title 1"                       -- Title Word Menu         displays correctly
		// contains "Author 6"                      -- Title Word Menu         displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") &&
			output.contains("Main Menu:") && output.contains("Goodbye!") &&
			output.contains("Matches (any author)") && output.contains("Title Word Menu:") &&
			output.contains("2 of 3") && 
			output.contains("Title 1") && output.contains("Author 6"))
			return true;
		return false;
	}
	
	/**
	 * welcome menu -> Title Word Menu(author filter: James Joyce) -> Goodbye
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test5() {
		TextUITester temp = new TextUITester("3\nJames Joyce\n2\nhitchhiker\n4");
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		String output = temp.checkOutput();
		
		// contains "Welcome ..."                   -- Welcome                 displays correctly
		// contains "Main Menu:"                    -- Main Menu               displays correctly
		// contains "Goodbye!"                      -- Ending                  displays correctly
		
		// contains "none"                          -- Set Author Filter Menu  displays correctly
		// contains "Set Author Filter Menu:"       -- Set Author Filter Menu  displays correctly
		
		// contains "(author filter: James Joyce)"  -- Title Word Menu         displays correctly
		// contains "Title Word Menu:"              -- Title Word Menu         displays correctly
		// contains "2"                             -- Title Word Menu         displays correctly
		// contains "3"                             -- Title Word Menu         displays correctly
		// contains "Title 1"                       -- Title Word Menu         displays correctly
		// contains "Author 6"                      -- Title Word Menu         displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") &&
			output.contains("Main Menu:") && output.contains("Goodbye!") &&
			output.contains("none") && output.contains("Set Author Filter Menu:") &&
			output.contains("Matches (author filter: James Joyce)") && output.contains("Title Word Menu:") &&
			output.contains("2") && output.contains("3") && 
			output.contains("Title 1") && output.contains("Author 6"))
			return true;
		return false;
		
	}
	
	/**
	 * simulate sample output in Proposal
	 * welcome menu -> Lookup ISBN Menu -> Set Author Filter(current: none) -->
	 * Title Word Menu(author filter: James Joyce) --> Set Author Filter(current: James Joyce) -->
	 * Title Word Menu(any author) --> Set Author Filter(current: none) -->
	 * Title Word Menu(author filter: Douglas Adams) --> Goodbye!
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test6() {
		TextUITester temp = new TextUITester("1\n1234567890123\n3\nJames Joyce\n2\n\n3\n\n2\nsteam\n3\nDouglas Adams\n2\nhitchhiker\n4");
		BookMapperFrontend tester = new BookMapperFrontend(new Scanner(System.in), new FDBookMapperBackend(), new FDISBNValidator());
		tester.runCommandLoop();
		String output = temp.checkOutput();
		
		// contains "Welcome ..."                           -- Welcome                 displays correctly
		// contains "Main Menu:"                            -- Main Menu               displays correctly
		// contains "Goodbye!"                              -- Ending                  displays correctly
		
		// contains "contain: none"                         -- Set Author Filter Menu  displays correctly
		// contains "contain: James Joyce"                  -- Set Author Filter Menu  displays correctly
		// contains "Set Author Filter Menu:"               -- Set Author Filter Menu  displays correctly
		
		// contains "Matches (author filter: James Joyce)"  -- Title Word Menu         displays correctly
		// contains "Matches (any author)"                  -- Title Word Menu         displays correctly
		// contains "Title Word Menu:"                      -- Title Word Menu         displays correctly
		// contains "2"                                     -- Title Word Menu         displays correctly
		// contains "3"                                     -- Title Word Menu         displays correctly
		// contains "Title 1"                               -- Title Word Menu         displays correctly
		// contains "Author 6"                              -- Title Word Menu         displays correctly
		if(output.startsWith("Welcome to the Book Mapper Application!") &&
			output.contains("Main Menu:") && output.contains("Goodbye!") &&
			output.contains("contain: none") && output.contains("Set Author Filter Menu:") && output.contains("contain: James Joyce") &&
			output.contains("Matches (author filter: James Joyce)") && output.contains("Matches (any author)") &&
			output.contains("Title Word Menu:") &&
			output.contains("2") && output.contains("3") && 
			output.contains("Title 1") && output.contains("Author 6"))
			return true;
		return false;
	}
	
	/**
	 * after integration, test whether frontend methods behave correctly
	 * video demonstration test
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test7() {
	    List<IBook> books;
	    try {
	    	books = (new BookLoader()).loadBooks("books.csv");
	    } catch (FileNotFoundException e) {
	    	return false;
	    }
	    IBookMapperBackend backend = new BookMapperBackend();
	    for (IBook book : books) {
	    	backend.addBook(book);
	    }
	    TextUITester test = new TextUITester("1\n9780330491198\n4");
	    BookMapperFrontend front =
	        new BookMapperFrontend(new Scanner(System.in), backend, new ISBNValidator());
	    front.runCommandLoop();
	    String output = test.checkOutput();
	    if (output.contains("Welcome to the Book Mapper Application!")
	        && output.contains("You are in the Lookup ISBN Menu:")
	        && output.contains("You are in the Main Menu:")
	        && output.contains("The Hitchhiker's Guide to the Galaxy")
	        && output.contains("Douglas Adams, ISBN: 9780330491198")
	        && output.contains("Goodbye!")) {
	    	return true;
	    }
		return false;
	}
	
	/**
	 * after integration, test whether frontend methods behave correctly
	 * Google Doc simulation
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test8() {
	    List<IBook> books;
	    try {
	    	books = (new BookLoader()).loadBooks("books.csv");
	    } catch (FileNotFoundException e) {
	    	return false;
	    }
	    IBookMapperBackend backend = new BookMapperBackend();
	    for (IBook book : books) {
	    	backend.addBook(book);
	    }
	    TextUITester test = new TextUITester("1\n9780330491198\n3\nJames Joyce\n2\n\n3\n\n2\nsteam\n3\nDouglas Adams\n2\nhitchhiker\n4");
	    BookMapperFrontend front =
	        new BookMapperFrontend(new Scanner(System.in), backend, new ISBNValidator());
	    front.runCommandLoop();
	    String output = test.checkOutput();
	    if (output.contains("Welcome to the Book Mapper Application!")
	        && output.contains("You are in the Lookup ISBN Menu:")
	        && output.contains("You are in the Set Author Filter Menu:")
	        && output.contains("You are in the Main Menu:")
	        && output.contains("The Hitchhiker's Guide to the Galaxy")
	        && output.contains("Douglas Adams, ISBN: 9780330491198")
	        && output.contains("contain: none")
	        && output.contains("James Joyce")
	        && output.contains("James Joyce/Jim Norton")
	        && output.contains("any author")
	        && output.contains("Full Steam Ahead!: Unleash the Power of Vision in Your Work and Your Life")
	        && output.contains("12")
	        && output.contains("Douglas Adams")
	        && output.contains("9780330491235")
	        && output.contains("Goodbye!")) {
	    	return true;
	    }
		return false;
	}
	
	/**
	 * test AE's isbn validator works correctly
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test9() {
	    List<IBook> books;
	    try {
	    	books = (new BookLoader()).loadBooks("books.csv");
	    } catch (FileNotFoundException e) {
	    	return false;
	    }
	    IBookMapperBackend backend = new BookMapperBackend();
	    for (IBook book : books) {
	    	backend.addBook(book);
	    }
	    TextUITester test = new TextUITester("1\n1111111111111\n4");
	    BookMapperFrontend front =
	        new BookMapperFrontend(new Scanner(System.in), backend, new ISBNValidator());
	    front.runCommandLoop();
	    String output = test.checkOutput();
	    if (output.contains("!!!WARNING (invalid ISBN number)!!!")){
	    	return true;
	    }
	    return false;
	}
	
	/**
	 * test AE's iterator works correctly
	 * 
	 * @return true if no bug; false otherwise
	 */
	public static boolean test10() {
	    BookMapperBackend back = new BookMapperBackend();
	    Book book1 = new Book();
	    Book book2 = new Book();
	    Book book3 = new Book();
	    book1.setTitle("Book 1");
	    book1.setAuthors("Author 1");
	    book1.setISBN13("ISBN 1");
	    book2.setTitle("Book 21");
	    book2.setAuthors("Author 2");
	    book2.setISBN13("ISBN 2");
	    book3.setTitle("Book 3");
	    book3.setAuthors("Author 3");
	    book3.setISBN13("ISBN 3");
	    back.addBook(book1);
	    back.addBook(book2);
	    back.addBook(book3);
	    List<IBook> list = back.searchByTitleWord("1");
	    if (list.size() == 2) {
	      return true;
	    }
	    if (list.get(0).getAuthors().equals("Author 1")) {
	      return true;
	    }
	    if (list.get(0).getTitle().equals("Book 1")) {
	      return true;
	    }
	    if (list.get(1).getAuthors().equals("Author 2")) {
	      return true;
	    }
	    if (list.get(1).getTitle().equals("Book 21")) {
	      return true;
	    }

	    List<IBook> temp = back.searchByTitleWord("DNE");
	    if (temp.size() == 0) {
	      return true;
	    }
	    return false;
	}
	
	/**
	 * Main argument, print the result of the test
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		if(test1()) {
			System.out.println("Frontend Individual Test 1: passed");
		}else {
			System.out.println("Frontend Individual Test 1: failed");
		}
		if(test2()) {
			System.out.println("Frontend Individual Test 2: passed");
		}else {
			System.out.println("Frontend Individual Test 2: failed");
		}
		if(test3()) {
			System.out.println("Frontend Individual Test 3: passed");
		}else {
			System.out.println("Frontend Individual Test 3: failed");
		}
		if(test4()) {
			System.out.println("Frontend Individual Test 4: passed");
		}else {
			System.out.println("Frontend Individual Test 4: failed");
		}
		if(test5()) {
			System.out.println("Frontend Individual Test 5: passed");
		}else {
			System.out.println("Frontend Individual Test 5: failed");
		}
		if(test6()) {
			System.out.println("Frontend Individual Test 6: passed");
		}else {
			System.out.println("Frontend Individual Test 6: failed");
		}
		if(test7()) {
			System.out.println("Frontend Integration Test 1: passed");
		}else {
		System.out.println("Frontend Integration Test 1: failed");
		}
		if(test8()) {
			System.out.println("Frontend Integration Test 2: passed");
		}else {
		System.out.println("Frontend Integration Test 2: failed");
		}
		if(test9()) {
			System.out.println("Frontend Partner (AlgorithmEngineer) Test 1: passed");
		}else {
		System.out.println("Frontend Partner (AlgorithmEngineer) Test 1: failed");
		}
		if(test10()) {
			System.out.println("Frontend Partner (AlgorithmEngineer) Test 2: passed");
		}else {
		System.out.println("Frontend Partner (AlgorithmEngineer) Test 2: failed");
		}
	}
}
