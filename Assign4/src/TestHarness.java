/**This is the TestHarness Class 
 * 
 * This class test all the methods
 * of the splayTree class
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
		
		//instantiating AVL Tree
        SplayTree tree = new SplayTree();
        int numberofVertices; 
        
        //inserting into the tree
    	for(int i = 0; i< dataInput.length-1; i++){	
			  System.out.println("Inserting: "+ "'"+ dataInput[i]+"'");
		      tree.insert(dataInput[i]);			
			
		}
    	
    	//Displaying the tree in pre and in order after inserting 
    	System.out.println();
    	numberofVertices = tree.getNumberOfVertices(); 
    	System.out.println("The Number of vertices is : "+ numberofVertices);
    	
    	System.out.println();
    	System.out.println("inOrderTraversal of the tree: ");
    	tree.inOrderTraversal(tree.getRoot());
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("preOrderTraversal of the tree: ");
    	tree.preOrderTraversal(tree.getRoot());
    	
    	
    	System.out.println();
    	
    	
    	
    	 //deleting elements from d-n using ASCII values
		 System.out.println("Deleting keys start from r - t: ");
		 for(int i = 114; i < 117; i++){
			 char c = (char) i;
			 //System.out.println(c);
			  for(int j = 0; j < numberofVertices; j++){
		 
			 tree.deleteKeyStartsWith(c);
			 }
		 }
    	
    	
		//Displaying the tree in pre and in order after deleting from r - t 
		 System.out.println();
	    	numberofVertices = tree.getNumberOfVertices(); 
	    	System.out.println("The Number of vertices is : "+ numberofVertices);
	    	
	    	System.out.println();
	    	System.out.println("inOrderTraversal of the tree: ");
	    	tree.inOrderTraversal(tree.getRoot());
	    	
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("preOrderTraversal of the tree: ");
	    	tree.preOrderTraversal(tree.getRoot());
	    	
	    	
	    	System.out.println();
    	
    	System.out.println();
    	System.out.println("Deleting keys start from R - T: ");
		 for(int i = 82; i < 85; i++){
			 char c = (char) i;
			 //System.out.println(c);
			  for(int j = 0; j < numberofVertices; j++){
		 
			 tree.deleteKeyStartsWith(c);
			 }
		 }
   	
		//Displaying the tree in pre and in order after deleting from R - T
		 System.out.println();
	    	numberofVertices = tree.getNumberOfVertices(); 
	    	System.out.println("The Number of vertices is : "+ numberofVertices);
	    	
	    	System.out.println();
	    	System.out.println("inOrderTraversal of the tree: ");
	    	tree.inOrderTraversal(tree.getRoot());
	    	
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("preOrderTraversal of the tree: ");
	    	tree.preOrderTraversal(tree.getRoot());
	    	
	    	
	    	System.out.println();
 

	}

}
