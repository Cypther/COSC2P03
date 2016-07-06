/**This is the Word Class 
 * 
 * Word fields has key and duplicate counter
 * the field key is at as a string
 * 
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (November 2014)
 * Compiler Version Java 1.7
 */

public class Word {
	
	public String key;          // The data in the node
	int duplicateCounter = 1; //counting duplicate values 
	
	//constructor
	public Word(String word){
		this.key = word;	
	}
	
	//getters
	   public int getDuplicate(){
	        return duplicateCounter;
	    }
	   
	 //setters
	    public void duplicate(){ //counting duplicate values 
	    	duplicateCounter++;
	    }

}
