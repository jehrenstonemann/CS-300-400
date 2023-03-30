//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    FolderExplorerTester
// Course:   CS 300 Fall 2021
//
// Author:   Xiangyu Huang
// Email:    xhuang438@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:   
// Partner Email: 
// Partner Lecturer's Name:
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    Write-up states that pair programming is allowed for this assignment.
//    We have both read and understand the course Pair Programming Policy.
//    We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:        None
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.List;
import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tester for the FolderExplorer.java
 * <p>
 * @author Huang Xiangyu
 *
 */
public class FolderExplorerTester {
	
	/**
	 * test the getContents method, see if it works as expected
	 * <p>
	 * @param folder the folder used for testing
	 * @return true if getContents method is OK
	 */
	public static boolean testGetContents(File folder) {
		try {
			// Scenario 1
			// list the basic contents of the cs300 folder
			ArrayList<String> listContent = FolderExplorer.getContents(folder);
			// expected output must contain "exams preparation", "grades",
			// "lecture notes", "programs", "reading notes", "syllabus.txt",
			// and "todo.txt" only.
			String[] contents = new String[] {"exams preparation", "grades",
			"lecture notes", "programs", "reading notes", "syllabus.txt",
			"todo.txt"};
			List<String> expectedList = Arrays.asList(contents);
			// check the size and the contents of the output
			if (listContent.size() != 7) {
				System.out.println("Problem detected: "
						+ "cs300 folder must contain 7 elements.");
				return false;
			}
			for (int i = 0; i < expectedList.size(); i++) {
				if (!listContent.contains(expectedList.get(i))) {
					System.out.println("Problem detected: " + expectedList.get(i)
						+ " is missing from the output "
						+ "of the list contents of cs300 folder.");
					return false;
				}
			}
			
			// Scenario 2 - list the contents of the grades folder
			File f = new File(folder.getPath() + File.separator + "grades");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 0) {
				System.out.println("Problem detected: grades folder "
						+ "must be empty.");
				return false;
			}
			
			// Scenario 3 - list the contents of the p02 folder
			f = new File(folder.getPath() + File.separator + "programs" 
					+ File.separator + "p02");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
				System.out.println("Problem detected: p02 folder must contain only "
						+ "one file named FishTank.java.");
				return false;
			}
			
			// Scenario 4 - List the contents of a file
			f = new File(folder.getPath() + File.separator + "todo.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Your "
						+ "FolderExplorer.getContents() must "
						+ "throw a NotDirectoryException if it is provided an input "
						+ "which is not a directory.");
				return false;
			} catch (NotDirectoryException e) { // catch only the expected exception
			// no problem detected
			}
			
			// Scenario 5 - List the contents of not found directory/file
			f = new File(folder.getPath() + File.separator + "music.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Your "
						+ "FolderExplorer.getContents() must "
						+ "throw a NotDirectoryException "
						+ "if the provided File does not exist.");
				return false;
			} catch (NotDirectoryException e) {
			// behavior expected
			}
		} 
		catch (Exception e) {
			System.out.println("Problem detected: Your "
					+ "FolderExplorer.getContents() has thrown"
					+ " a non expected exception.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * test the deepGetContents method's base case, see if it works as expected
	 * <p>
	 * @param folder the folder used for testing
	 * @return true if deepGetContents method's base case is OK
	 */
	public static boolean testDeepGetContentsBaseCase(File folder) {
		try {
			// list the deep contents of the cs300/lecture notes/unit1
			ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);
			// expected output must contain "ExceptionHandling.txt", 
			// "proceduralProgramming.txt","UsingObjects.txt"
			String[] contents = new String[] {"ExceptionHandling.txt",
					"proceduralProgramming.txt","UsingObjects.txt"};
			List<String> expectedList = Arrays.asList(contents);
			// check the size and the contents of the output
			if (listContent.size() != 3) {
				System.out.println("Problem detected: cs300/lecture notes/unit1 "
						+ "folder must contain 3 elements.");
				return false;
			}
			for (int i = 0; i < expectedList.size(); i++) {
				if (!listContent.contains(expectedList.get(i))) {
					System.out.println("Problem detected: " + expectedList.get(i)
					+ " is missing from the output of the list contents of "
					+ "cs300/lecture notes/unit1 folder.");
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println("Problem detected: Your FolderExplorer.getDeepContents() "
					+ "has thrown a non expected exception when concerning "
					+ "about its base case.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * test the deepGetContents method's recursive case, see if it works as expected
	 * <p>
	 * @param folder the folder used for testing
	 * @return true if deepGetContents method's recursive case works as intended
	 */
	public static boolean testDeepListRecursiveCase(File folder) {
		try {
			// list the deep contents of the cs300/programs
			ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);
			// expected output must contain "ClimbingTracker.java",
			// "ClimbingTrackerTester.java", "FishTank.java", "ExceptionalClimbing.java",
			// "ExceptionalClimbingTester.java","Program01.pdf","Program02.pdf", 
			// "Program03.pdf"
            String[] contents = new String[] {"ClimbingTracker.java",
            		"ClimbingTrackerTester.java",
                    "FishTank.java","ExceptionalClimbing.java", 
                    "ExceptionalClimbingTester.java","Program01.pdf",
                    "Program02.pdf","Program03.pdf"};
            List<String> expectedList = Arrays.asList(contents);
            //check the size and the contents of the output
            if (listContent.size() != 8) {
				System.out.println("Problem detected: cs300/programs "
						+ "folder must contain 8 elements.");
				return false;
			}
			for (int i = 0; i < expectedList.size(); i++) {
				if (!listContent.contains(expectedList.get(i))) {
					System.out.println("Problem detected: " + expectedList.get(i)
						+ " is missing from the output of the list contents of "
						+ "cs300/programs folder.");
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println("Problem detected: Your FolderExplorer.getDeepContents() "
					+ "has thrown a non expected exception when concerning "
					+ "about its recursive case.");
            e.printStackTrace();
            return false;
		}
		return true;
	}
	
	/**
	 * test the lookupByName method, see if it works as expected
	 * <p>
	 * @param folder the folder used for testing
	 * @return true if lookupByName method works as intended
	 */
	public static boolean testLookupByFileName(File folder) {
		try {
			String path = FolderExplorer.lookupByName(folder,"ClimbingTracker.java");
			if(!("cs300\\programs\\p01\\ClimbingTracker.java".equals(path))){
				return false;
			}
	    }catch (Exception e){
	        System.out.println("Problem detected: Your FolderExplorer.lookupByName() "
	        		+ "has thrown a non expected exception.");
	        e.printStackTrace();
	        return false;
	    }
		return true;
	}
	
	/**
	 * test the lookupByKey method's base case, see if it works as expected
	 * <p>
	 * @param folder the folder used for testing
	 * @return true if lookupByKey method's base case works as intended
	 */
	public static boolean testLookupByKeyBaseCase(File folder) {
		try {
			// list the contents which contains the key "bus.txt" of the cs300 folder
	        ArrayList<String> listContent = FolderExplorer.lookupByKey(folder,"bus.txt");
	        //expected output will be "syllabus.txt"
	        String[] contents = new String[] {"syllabus.txt"};
	        List<String> expectedList = Arrays.asList(contents);
	        //check the size and the content
	        if (listContent.size() != 1) {
	            System.out.println("Problem detected: cs300 folder must "
	            		+ "contain 1 corresponding elements.");
	            return false;
	        }
	        for (int i = 0; i < expectedList.size(); i++) {
	            if (!listContent.contains(expectedList.get(i))) {
	                System.out.println("Problem detected: " + expectedList.get(i)
	                        + " is missing from the expected output.");
	                return false;
	            }
	        }

	    }catch (Exception e){
	        System.out.println("Problem detected: Your FolderExplorer.lookupByKey() "
	        		+ "has thrown a non expected exception concerning its base case.");
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	
	/**
	 * This method prints out the test result
	 * <p>
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("testGetContents: " 
				+ testGetContents(new File("cs300")));
		System.out.println("testDeepGetContentsBaseCase: " 
				+ testDeepGetContentsBaseCase(new File("cs300/lecture notes/unit1")));
		System.out.println("testDeepListRecursiveCase: " 
				+ testDeepListRecursiveCase(new File("cs300/programs")));
		System.out.println("testLookupByFileName: " 
				+ testLookupByFileName(new File("cs300")));
		System.out.println("testLookupByKeyBaseCase: " 
				+ testLookupByKeyBaseCase(new File("cs300")));
	}
}