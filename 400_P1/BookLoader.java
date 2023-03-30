import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This method can be used to load book data from a CSV file.
 */
public class BookLoader implements IBookLoader {

    /**
     * This method loads the list of books from a CSV file.
     * @param filepathToCSV path to the CSV file relative to the executable
     * @return a list of book objects
     * @throws FileNotFoundException
     */
    @Override
    public List<IBook> loadBooks(String filepathToCSV) throws FileNotFoundException {
        
        String currLine;                        // stores current line of file
        String[] lineData = new String[12];     // array storing the columns of the current line
        boolean isEnclosed = false;             // whether currently within quotes
        int enclosedIndex = 0;                  // the begining index of a string within quotes
        int ldIndex = 0;                        // current index of lineData array
        int titleIndex = 1;                     // index which stores the title column
        int authorsIndex = 2;                   // index which stores the authors column
        int isbn13Index = 5;                    // index which stores the isbn13 column
                
        try {
            
            List<IBook> booksList = new ArrayList<IBook>();
            BufferedReader booksFile = new BufferedReader(new InputStreamReader(new FileInputStream(filepathToCSV), "UTF8")); 
            
            /*
             * Loops through each line of the file and copies each column to the LineData array
             * ensures handling of commas within quotes do not cause a split in the line
             */
            while ((currLine = booksFile.readLine()) != null) {
                ldIndex = 0;
                isEnclosed = false;
                enclosedIndex = 0;
                for (int j = 0; j < lineData.length; j++) {
                    lineData[j] = null;
                }
                for(int i = 0; i < currLine.length(); i++) {
                    if(currLine.charAt(i) == ',' && isEnclosed == false) {
                        lineData[ldIndex] = currLine.substring(enclosedIndex, i);
                        ++ldIndex;
                        enclosedIndex = i + 1;
                        if(currLine.charAt(i + 1) == '\"') {
                            isEnclosed = true;
                            i++;
                            continue;
                        }
                    }
                    if( i != 0) {
                        if((currLine.charAt(i) == '\"') && isEnclosed == true && (currLine.charAt(i - 1) != '\\')) {
                            isEnclosed = false;
                        }
                    }       
                }
                
                /*
                 * Constructs a book and stores the values for the title
                 * authors and isbn13 number
                 */
                Book newBook = new Book();
                newBook.setTitle(lineData[titleIndex]);
                newBook.setAuthors(lineData[authorsIndex]);
                newBook.setISBN13(lineData[isbn13Index]);
                booksList.add(newBook);
            }   
            booksList.remove(0);    // removes the first book which contains header information
            booksFile.close();      // closes file
            return booksList;
            
        }catch(Exception e) {
            throw new FileNotFoundException();
        }
    }

}
