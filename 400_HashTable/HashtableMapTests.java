// --== CS400 Project One File Header ==--
// Name: Huang Xiangyu
// CSL Username: xiangyuh
// Email: xhuang438@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.NoSuchElementException;

/**
 * testing the functionality of HashtableMap class
 * 
 * @author Huang Xiangyu
 *
 */
public class HashtableMapTests {
	
	/**
	 * test constructor without capacity param behaves correctly
	 * put, size, clear methods behaves correctly
	 * either in a hashTable result in collision
	 * or in one do not collide
	 * 
	 * @return true if there's no bug; false otherwise
	 */
	public static boolean test1() {
		// case 1: hashNation1 is a non-collision hashTable
		HashtableMap<String, String> hashNation1 = new HashtableMap<String, String>(); //(default)capacity 15
		hashNation1.put("0", "America"); 
		hashNation1.put("1", "China");  
		hashNation1.put("2", "Russia"); 
		boolean result1 = hashNation1.put("0", "Korea");  // put an existed key
		boolean result2 = hashNation1.put(null, "Japan"); // put a null key
		if(result1)
			return false;
		if(result2)
			return false;
		if(hashNation1.size()!=3)
			return false;
		hashNation1.clear();
		if(hashNation1.size()!=0)
			return false;
		
		// case 2: hashNation2 is a collision hashTable
		HashtableMap<String, String> hashNation2 = new HashtableMap<String, String>(); //(default)capacity 15
		hashNation2.put("0", "America"); 
		hashNation2.put("1", "China");  
		hashNation2.put("5", "Russia"); //"5" hashCode % 15 = 8
		hashNation2.put("20", "Japan"); //"20" hashCode % 15 = 8
		boolean result3 = hashNation2.put("20", "Korea");  // put an existed key
		boolean result4 = hashNation2.put(null, "Sweden"); // put a null key
		if(result3)
			return false;
		if(result4)
			return false;
		if(hashNation2.size()!=4)
			return false;
		// test if chaining works correctly
		if(hashNation2.hashMap[8].size()!=2)
			return false;  
		if(!hashNation2.hashMap[8].get(1).getValue().equals("Japan"))
			return false;
		hashNation2.clear();
		if(hashNation2.size()!=0)
			return false;
		return true;
	}
	
	/**
	 * test constructor with capacity param behaves correctly
	 * get method behaves correctly (get a stored/non-stored keys)
	 * either in a hashTable result in collision
	 * or in one do not collide
	 * 
	 * @return true if there's no bug; false otherwise
	 */
	public static boolean test2() {
		// case 1: hashNation1 is a non-collision hashTable
		HashtableMap<String, String> hashNation1 = new HashtableMap<String, String>(10); //capacity 10
		hashNation1.put("0", "America"); 
		hashNation1.put("1", "China");  
		hashNation1.put("2", "Russia"); 
		// check whether get a stored key behaves correctly
		if(!hashNation1.get("2").equals("Russia"))
			return false;
		// check whether get a non-stored key behaves correctly(Exception being thrown)
		try {
			hashNation1.get("3");
			return false;
		}
		catch(NoSuchElementException e){
			
		}
		
		// case 2: hashNation2 is a collision hashTable
		HashtableMap<String, String> hashNation2 = new HashtableMap<String, String>(10); //capacity 10
		hashNation2.put("0", "America"); 
		hashNation2.put("1", "China");  
		hashNation2.put("5", "Russia"); //"5" hashCode % 15 = 8
		hashNation2.put("20", "Japan"); //"20" hashCode % 15 = 8
		// check whether get a stored key behaves correctly
		if(!hashNation2.get("5").equals("Russia"))
			return false;
		// check whether get a non-stored key behaves correctly(Exception being thrown)
		try {
			hashNation2.get("2");
			return false;
		}
		catch(NoSuchElementException e){
			
		}
		return true;
	}
	
	/**
	 * containsKey method behaves correctly
	 * either in a hashTable result in collision
	 * or in one do not collide
	 * 
	 * @return true if there's no bug; false otherwise
	 */
	public static boolean test3() {
		// case 1: hashNation1 is a non-collision hashTable
		HashtableMap<String, String> hashNation1 = new HashtableMap<String, String>(10);
		hashNation1.put("0", "America"); //"0" hashCode % 15 = 3
		hashNation1.put("1", "China");  //"1" hashCode % 15 = 4
		hashNation1.put("2", "Russia"); //"2" hashCode % 15 = 5
		if(!hashNation1.containsKey("2"))
			return false;
		if(hashNation1.containsKey("3"))
			return false;
		
		// case 2: hashNation2 is a collision hashTable
		HashtableMap<String, String> hashNation2 = new HashtableMap<String, String>(10);
		hashNation2.put("0", "America"); //"0" hashCode % 15 = 3
		hashNation2.put("1", "China");  //"1" hashCode % 15 = 4
		hashNation2.put("5", "Russia"); //"5" hashCode % 15 = 8
		hashNation2.put("20", "Japan"); //"20" hashCode % 15 = 8
		if(!hashNation2.containsKey("5"))
			return false;
		if(hashNation2.containsKey("19"))
			return false;
		return true;
	}
	
	/**
	 * remove method behaves correctly
	 * either in a hashTable result in collision
	 * or in one do not collide
	 * 
	 * @return true if there's no bug; false otherwise
	 */
	public static boolean test4() {
		// case 1: hashNation1 is a non-collision hashTable
		HashtableMap<String, String> hashNation1 = new HashtableMap<String, String>(10);
		hashNation1.put("0", "America"); 
		hashNation1.put("1", "China");  
		hashNation1.put("2", "Russia"); 
		String removed1 = hashNation1.remove("0"); // remove a present key
		String removed3 = hashNation1.remove("3"); // remove a not found key
		if(hashNation1.containsKey("0"))
			return false;
		if(hashNation1.size()!=2)
			return false;
		if(!removed1.equals("America"))
			return false;
		if(removed3!=null)
			return false;
		try {
			hashNation1.get("0");
			return false;
		}
		catch(NoSuchElementException e){
			
		}
		
		// case 2: hashNation2 is a collision hashTable
		HashtableMap<String, String> hashNation2 = new HashtableMap<String, String>(10);
		hashNation2.put("0", "America"); 
		hashNation2.put("1", "China");  
		hashNation2.put("5", "Russia"); //"5" hashCode % 15 = 8
		hashNation2.put("20", "Japan"); //"20" hashCode % 15 = 8
		String removed2 = hashNation2.remove("20");
		String removed4 = hashNation2.remove("2"); // remove a not found key
		if(hashNation2.containsKey("20")==true)
			return false;
		if(hashNation2.size()!=3)
			return false;
		if(!removed2.equals("Japan"))
			return false;
		if(removed4!=null)
			return false;
		try {
			hashNation2.get("20");
			return false;
		}
		catch(NoSuchElementException e){
			
		}
		return true;
	}
	
	/**
	 * grow method behaves correctly
	 * 
	 * @return true if there's no bug; false otherwise
	 */
	public static boolean test5() {
		HashtableMap<String, String> hashNation = new HashtableMap<String, String>(5);
		hashNation.put("0", "America"); // at index 8
		hashNation.put("1", "China"); // at index 9
		hashNation.put("5", "Russia"); // at index 3
		hashNation.put("11", "Japan"); // at index 8 ; grow() happened here
		hashNation.put("12", "Korea"); // at index 9 
		hashNation.put("20", "Canada"); // at index 8
		if(!hashNation.hashMap[8].get(2).getValue().equals("Canada"))
			return false;
		if(!hashNation.hashMap[8].get(0).getValue().equals("America"))
			return false;
		if(!hashNation.hashMap[3].get(0).getValue().equals("Russia"))
			return false;
		if(!hashNation.hashMap[9].get(1).getValue().equals("Korea"))
			return false;
		if(hashNation.size()!=6)
			return false;
		if(hashNation.hashMap.length!=10)
			return false;
		return true;
	}
	
	/**
	 * test whether all tests return true
	 * 
	 * @return true if everything is fine; false otherwise
	 */
	public static boolean runAllTests() {
		return test1() && test2() && test3() && test4() && test5();
	}
	
	/**
	 * Main argument, print the result of the test
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println(runAllTests());
	}
}
