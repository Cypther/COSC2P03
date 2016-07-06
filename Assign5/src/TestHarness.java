/**This is the TestHarness Class 
 * 
 * This class test all the methods
 * of the HashTable class
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (November 2014)
 * Compiler Version Java 1.7
 */


public class TestHarness {

	public static void main(String[] args) {
		
		/*reading in the file*/
		readFile read = new readFile();
		String[] dataInput;
		dataInput = read.readFile();
		
		//System.out.println(dataInput.length);
		
		
	/** 
	 * There are 188 words in the text files but I need to get rid of the duplicate words.
	 * 
	 * I'm using my assignment 3 to count the words that are
	 * in the AVL tree. So I don't count duplicate words 
	 * when I'm creating a Hash Table that needs to have an 80% load factor.
	 * 
	 * I can get how many words that are in the file without duplicate words
	 * by counting how many vertices in the AVL tree.
	 * 
	 * */	
		//instantiating AVL Tree
		AVLTree avlTree = new AVLTree();
		
		
		
		/*looping through the array and adding it to the AVL and 
		adding each string value in the array to the AVL Tree*/

		for(int i = 0; i< dataInput.length-1; i++){	
			  //System.out.println("Inserting: "+ "'"+ dataInput[i]+"'");
		      avlTree.insert(dataInput[i]);			
			
		}
		
		 //System.out.println(avlTree.numberOfVertices);
		
		/*Multiplying the numbers of vertices by 1.20 to make the table 20% bigger
		 * to get the table about 80% load factor
		 * */ 
		int tableSize =  (int) Math.floor(avlTree.numberOfVertices * 1.20);
		
		System.out.println("Table size is  "+ tableSize);
		
		//int tableSize =  (int) Math.floor(dataInput.length * 0.61);
		
		//int tableSize =  312;
		
		HashTable table = new HashTable(tableSize);
		
		for(int i = 0; i < dataInput.length-1; i++){
			
			table.insert(dataInput[i]);

			//System.out.println(dataInput.length);
		}
		
		//displaying hash table before deleting anything
		System.out.println();
		table.displayTable();
		
		//testing if find works
		//table.findKey("a");
		
		table.hashTableLoadFactor();
		
		//testing if delete method works
		//table.delete("good");
		
		 //deleting elements from d-n using ASCII values
		 System.out.println("Deleting keys start from d - m: ");
		 System.out.println();
		 for(int i = 100; i < 110; i++){
			 char c = (char) i;
			  //System.out.println(c);
			  for(int j = 0; j < tableSize; j++){
		 
			 table.deleteKeyStartsWith(c);
			 }
		 }
		
		 //printing out the table and load factor after deleting elements from D-M
		 table.displayTable();
		 table.hashTableLoadFactor();
		
		
		 //deleting elements from d-n using ASCII values
		 System.out.println("Deleting keys start from D - M: ");
		 System.out.println();
		 for(int i = 68; i < 78; i++){
			 char c = (char) i;
			  //System.out.println(c);
			  for(int j = 0; j < tableSize; j++){
		 
			 table.deleteKeyStartsWith(c);
			 }
		 }
		
		//printing out the table and load factor after deleting elements from d-n 
		table.displayTable();
		table.hashTableLoadFactor();

	}

}
