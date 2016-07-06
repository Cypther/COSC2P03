/**This is the HashTable Class
 * 
 * It uses Double hashing.
 * 
 * The Class has the following methods
 * Insert, Delete, Find and display.
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (November 2014)
 * Compiler Version Java 1.7
 */

public class HashTable {
	
	//Class fields
	Word[] table; //The Table
	int tableSize; // Size of the Hash Table
	
	//HashTable constructor
	HashTable(int size) {

		tableSize = size;
		table = new Word[size];


	}
	
    /**inserting into the Hash Table
    * 
    * java method chaining with one input, only the string value
    * 
    */	
	
	public void insert(String word){		 
		
		insert(word, table);	
	}
	
	
    /**
     * The Insert method
     * This method calls the singleHashing 
     * and the Double Hashing method
     */
	public void insert(String word, Word[] theArray) {
		
		    //Finding the duplicate values 
		    //If there's a duplicate return instead of inserting
		     if(findKey(word) != -1){
		    	 
		    	 int index = findKey(word);
		    	 theArray[index].duplicate();
		    	 
		    	 System.out.println("The Key '" + theArray[index].key + "' is already in the Table!");
		    	 return;
		    	 
		     }
		
		     //Single Hashing method
             int hashIndex = hashFuction(word);
             //Second Hash method(double Hashing)
             int doubleHashIndex = DoubleHashFuction(hashIndex); 
             
             
             //Safely check just in case the table is full
             if(hashTableLoadFactor() == 0){
            	 System.out.println("Out of space in the Table!");
            	 return;
             }
                  	

			// Looping through the array until there's an empty space
			
			while (theArray[hashIndex] != null) {
				
				System.out.print("Collision at Index " + hashIndex);
				hashIndex = hashIndex + doubleHashIndex;

				 System.out.println(" try " + hashIndex + " instead");

				// If we get to the end of the array go back to index 0

				 hashIndex = hashIndex % tableSize;

			}
			
			//Inserting into the index
			Word newKey = new Word(word);
			System.out.println("Insert into key: '" + newKey.key + "' into Index : " + hashIndex);
			theArray[hashIndex] = newKey;

	}
	
	
    /**
     * Find the key in the table. Return -1 if the key is not found
     * Returns the key in the Double Hashed Hash Table
     */
	
		public int findKey(String key) {

			
			// Find the original hash key
			 int hashIndex = hashFuction(key);
			// Find the Double Hashing hash key
			 int doubleHashIndex = DoubleHashFuction(hashIndex); 


			while (table[hashIndex] != null) {

				if (table[hashIndex].key.compareTo(key) == 0) {

					// Found the key so return it
					//System.out.println(key + " was found in index " + hashIndex);
					
					return hashIndex;

				}

				// Look in the next index

				hashIndex = hashIndex + doubleHashIndex;

				// If we get to the end of the array go back to index 0

				hashIndex = hashIndex % tableSize;

			}

			// Couldn't locate the key
			//System.out.println(" Key was not found ");
			return -1;

		}
		
	// Returns the the single Hashed Hash value
		public int hashFuction(String wordToHash){
			
			int hashKeyValue = 0;
			
			for(int i = 0; i < wordToHash.length(); i++){
				int charASCIIvalue = (int)wordToHash.charAt(i);
				
				/*Getting a really good hash by multiplying by 127 plus the ASCII value, 
				 * Modulo a really big Prime Number(16908799) and Mod by the size of the table
				 * 
				 * Referenced idea from University of California, Berkeley lecture video
				 * 
				 * CS 61B Lecture 22 about hashing at 6:23 min, in the youtube video
				 * https://www.youtube.com/watch?v=LmkfLAPj5Xo
				 * 
				 * */
				hashKeyValue = ((127 * hashKeyValue + charASCIIvalue) % 16908799) % tableSize;
				
			}
			
			//System.out.println("The hash key is " + hashKeyValue );		
			hashKeyValue = Math.abs(hashKeyValue);
			
			return hashKeyValue;
			
		}
		
   // Returns the the Double Hashed Hash value
		public int DoubleHashFuction(int KeyToHash){
			
			int doubleHashKeyValue = 7 - (KeyToHash % 7);
			
			return doubleHashKeyValue;
			
		}
		
		
		//A method for checking how much free space/load factor of the table
		public int hashTableLoadFactor(){
			
			int freeSpace = 0; 
			
			//counting the number of free space
			for(int i = 0; i < table.length; i++){
				
				if(table[i] == null){
					freeSpace++;
				}
				
			}
			
			double space = ((double)freeSpace/(double)tableSize);
			
			System.out.println();
			System.out.println("Hash Table size is " + tableSize);
			System.out.println("There are " + freeSpace  + " free space(s) left in the table!");
			System.out.println("The Table has % " + 100*space + " free space(s)");
			System.out.println("The Table is % " + (100-(100*space)) + " full" );
			
			
			return freeSpace;
		}
		
		
		/**
		 * This method delete the key by passing in the string
		 * to be deleted from the hash table
		 * 
		 * */
		
		public void delete(String word) {
			
			  if(findKey(word) != -1){
			    	 
			    	 int index = findKey(word);
			    	 
			    	 table[index] = null;
			    	 
			    	 System.out.println("Deleted at Key at index " + index);
			    	 return;
			    	 
			     }
			
		}
		
	
		 /**
	     * 
	     * deleting keys from the Hash Table, using only the 
	     * a single character to match the first character of 
	     * the key value.
	     * 
	     */


	    		void deleteKeyStartsWith(char singleCharacter) {
	    			
	    			
	    			for(int i = 0; i < table.length; i++){
	    				
	    				//System.out.println(theArray[i].key);
	    			 //if the character much the key first character call the delete method
	    			 if(table[i] != null){
	    				 
	    				 //if the first character match the first character of the key, set to null
	    			 if(singleCharacter == table[i].key.charAt(0)){
	    		            
	    				 table[i] = null;
	    		            
	    		          //  return;
	    		        }
	    			}
	    			 
	    			
	    			
	    		 }//end for loop
	    		}//end deleteKeyStartsWith method
		
		
	    		/**
	    		 * Displaying the hash table method using print formating
	    		 * 
	    		 * I used this page to help me with the formating
	    		 * http://alvinalexander.com/programming/printf-format-cheat-sheet
	    		 * */
		
		public void displayTable() {

			int increment = 0;
			
			//finding out how many rows need to be printed
			int numberOfRows = (tableSize / 10) + 1;
			
			//looping to print each row at a time
			for (int i = 0; i < numberOfRows; i++) {

				//Increase the counter by 10 every loop 
				increment = increment + 10;

				//printing out first star lines of Index
				for (int n = 0; n < 231; n++){
					System.out.print("*");
				}

				System.out.println();

				//printing out the Index location number, (not the actual hash location)
				//starting at 10 less than the increment counter
				for (int j = increment - 10; j < increment; j++) {
                    
					if(j <= tableSize){
					System.out.format("*      Index %3s" + "       ", j);
					}else{
					System.out.format("*            %3s", "          ");
					}

				}

				System.out.println("*");

				//printing out second star lines
				for (int n = 0; n < 231; n++){
					System.out.print("*");
				}

				System.out.println();

				
				//printing out the key and duplicates, and formating it in the correct index
				//starting at 10 less than the increment counter
				for (int n = increment - 10; n < increment; n++) {

					if (n >= tableSize){
						System.out.format("*%-22s", " ");

					}else if (table[n] == null){
						System.out.print(String.format("%-23s", "*"));
						//System.out.print("|                  ");

					}else{
						//printing out the key and duplicates in the hash table
						System.out.print(String.format("* %14s:%-6s", table[n].key,table[n].getDuplicate()));
					}
				}

				System.out.println("*");

				//printing out third star lines
				for (int n = 0; n < 231; n++){
					System.out.print("*");
				}
				System.out.println();
				System.out.println();

			}

		}
		


}
