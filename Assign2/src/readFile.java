/**This is the readFile Class 
 * 
 * This class reading in the input data 
 * and parse data files by removing the
 * punctuation, brackets, white space and hyphens
 * by using regex and returning the data as a string
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class readFile {
	
	 

	    public String readFile(){
	    	
	    	//reading in the file
	    	File file = new File("Data.txt");
	  	    FileInputStream fis = null;
	  	    BufferedInputStream bis = null;
	  	    DataInputStream dis = null;
	  	    String dataInput = "";

	    	
	    	
	    try {
	      fis = new FileInputStream(file);

	      // Here BufferedInputStream is added for fast reading.
	      bis = new BufferedInputStream(fis);
	      dis = new DataInputStream(bis);

	      // dis.available() returns 0 if the file does not have more lines.
	      while (dis.available() != 0) {

	      // this statement reads the line from the file and print it to
	        // the console.
	        //System.out.println(dis.readLine());
	        dataInput =  dataInput + dis.readLine() + " ";
	
	      }

	      // dispose all the resources after using them.
	      fis.close();
	      bis.close();
	      dis.close();

	      
	      //try catch for error handling
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	
	    //regex for only alphanumeric
		dataInput = dataInput.replaceAll("[^a-zA-Z0-9]", " ");
		  //regex for removing more than one white spaces
		dataInput = dataInput.replaceAll("\\s+", " ");
	    
		return dataInput;
	    }

}
