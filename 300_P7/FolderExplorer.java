//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    FolderExplorer
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
// Persons:         Haixi Zhang
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * exploring the folder contents
 * <p>
 * @author Huang Xiangyu
 *
 */
public class FolderExplorer {

	/**
	 * get the names of all files and directories in
	 * 		the given folder currentDirectory
	 * <p>
	 * @param currentDirectory the given folder
	 * @return a list of the names of all files and directories in
	 * 		the given folder currentDirectory
	 * @throws NotDirectoryException when the provided 
	 * 		currentDirectory does not exist or if it is not a directory
	 */
	public static ArrayList<String> getContents(File currentDirectory)
		throws NotDirectoryException {
		//generates a list of names of all files and directories
		ArrayList<String> content = new ArrayList<String> ();
		if(currentDirectory.list()!= null 
				&& currentDirectory.list().length!=0){
            for(String name:currentDirectory.list())
            	content.add(name);
        }
		//throw a NotDirectoryException
		if(!currentDirectory.exists() || !currentDirectory.isDirectory()){
            throw new NotDirectoryException("provided file does not exist"
            		+ " or it is not a directory");
        }
		return content;
	}
	
	/**
	 * Recursive method that lists the names of 
	 * 		all the files (not directories)
	 * 		in the given directory and its sub-directories.
	 * <p>
	 * @param currentDirectory the given directory
	 * @return a list that contains all the name of all files
	 * @throws NotDirectoryException when the provided 
	 * 			currentDirectory does not exist 
	 * 			or if it is not a directory
	 */
	public static ArrayList<String> getDeepContents (File currentDirectory)
		throws NotDirectoryException {
		ArrayList<String> list = new ArrayList <String> ();
		if(currentDirectory.list()!= null 
				&& currentDirectory.list().length!=0){
			for(File file:currentDirectory.listFiles()){
                if(file.isFile()){
                    list.add(file.getName());
                }else{
                	list.addAll(getDeepContents(file));
                }
            }
        }
		if(!currentDirectory.exists() || !currentDirectory.isDirectory()){
            throw new NotDirectoryException("provided file does not exist"
            		+ " or it is not a directory");
        }
		return list;
	}
	
	/**
	 * private helper method for the lookupByName method
	 * <p>
	 * @param currentDirectory the provided folder
	 * @param fileName the name of the target file
	 * @return a string which is a path to the file
	 */
    private static String lookupByNameHelper(File currentDirectory, 
    		String fileName){
        String path = "";
        if(currentDirectory.listFiles() != null 
        		&& currentDirectory.listFiles().length != 0){
            for(File file:currentDirectory.listFiles()){
                if(file.isFile() && file.getName().equals(fileName)){
                    path = file.getPath();
                }
                if(file.isDirectory()){
                    path = lookupByNameHelper(file,fileName);
                }
                if(!"".equals(path)){
                    return path;
                }
            }
        }
        return path;
    }
    
	/**
	 * Searches the given directory and all of its sub-directories for
	 * 		an exact match to the provided fileName.
	 * <p>
	 * @param currentDirectory the provided directory
	 * @param fileName the name of the target file
	 * @return a path to the file, if it exists
	 * @throws NoSuchElementException when the search operation 
	 * 		returns with no results found (including when fileName 
	 *		is null or currentDirectory does not exist or was not a directory)
	 */
	public static String lookupByName (File currentDirectory, String fileName) 
			throws NoSuchElementException {
        ArrayList<String> list = new ArrayList<>();
        try {
            list = getDeepContents(currentDirectory);
        }catch (Exception e){
        	e.printStackTrace();
        }
        if(!list.contains(fileName) || (fileName == null) 
        		|| !currentDirectory.exists() 
        		|| !currentDirectory.isDirectory()){
            throw new NoSuchElementException("File does not exist");
        }
        String path = lookupByNameHelper(currentDirectory,fileName);
        return path;
	}
	
	/**
	 * Recursive method that searches the given folder and its sub-directories
	 * 		for ALL files that contain the given key in part of their name.
	 * <p>
	 * @param currentDirectory the provided directory
	 * @param key the given key
	 * @return an arrayList of all the names of files that match 
	 * 		or an empty arrayList
	 */
	public static ArrayList<String> lookupByKey (File currentDirectory, 
			String key) {
		ArrayList<String> fileList=new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		try {
			fileList.addAll(FolderExplorer.getDeepContents(currentDirectory));
			for(int i = 0; i<fileList.size(); i++){
				if(fileList.get(i).contains(key)){
					list.add(fileList.get(i));
				}
			}
		}catch (NotDirectoryException e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Recursive method that searches the given folder and its sub-directories
	 * 		for ALL files whose size is within 
	 * 		the given max and min values, inclusive.
	 * <p>
	 * @param currentDirectory the provided directory
	 * @param sizeMin minimum value for the size
	 * @param sizeMax maximum value for the size
	 * @return an array list of the names of all files or an empty arrayList
	 */
	public static ArrayList<String> lookupBySize(File currentDirectory, 
			long sizeMin, long sizeMax) {
		ArrayList<String> list = new ArrayList<>();
		if(currentDirectory.listFiles() != null 
				&& currentDirectory.listFiles().length != 0){
			for(File file:currentDirectory.listFiles()){
				if(file.isFile() && file.length() >= sizeMin 
						&& file.length() <= sizeMax){
					list.add(file.getName());
				}
				if(file.isDirectory()){
					list.addAll(lookupBySize(file,sizeMin,sizeMax));
				}
	        }
		}
		return list;
	}
}
