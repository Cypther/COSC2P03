/**This is the TestHarness Class 
 *
 *This class test all the methods
 *for the AVL tree and 
 *and displaying the output
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


public class TestHarness {

	public static void main(String[] args) {
		
		/*reading in the file*/
		readFile read = new readFile();
		String[] dataInput;
		dataInput = read.readFile();
		
		//instantiating AVL Tree
		AVLTree avlTree = new AVLTree();
		
		
		
		/*looping through the array and adding it to the AVL and 
		adding each string value in the array to the AVL Tree*/
		System.out.println("Testing insert method: ");
		for(int i = 0; i< dataInput.length-1; i++){	
			  System.out.println("Inserting: "+ "'"+ dataInput[i]+"'");
		      avlTree.insert(dataInput[i]);			
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Numbers of Nodes in the tree " + avlTree.numberOfVertices);
		System.out.println();
		
		 System.out.println();
		 System.out.println("AVL Tree keys are: ");
		 avlTree.inOrderTraversal(avlTree.root);
		 System.out.println();
		 System.out.println();
		 
		 //deleting elements from d-n using ASCII values
		 System.out.println("Deleting keys start from D-N: ");
		 for(int i = 68; i < 79; i++){
			 char c = (char) i;
			 //System.out.println(c);
			  for(int j = 0; j < avlTree.numberOfVertices; j++){
		 
			 avlTree.deleteKeyStartsWith(c);
			 }
		 }
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("Numbers of Nodes in the tree " + avlTree.numberOfVertices);
		 System.out.println();
		 
		 System.out.println();
		 System.out.println("AVL Tree keys after deletion of D-N characters");
		 avlTree.inOrderTraversal(avlTree.root);
		 System.out.println();
		 System.out.println();
		 
		 //deleting elements from d-n using ASCII values
		 System.out.println("Deleting keys start from d-n: ");
		 for(int i = 100; i < 111; i++){
			 char c = (char) i;
			 //System.out.println(c);
			 for(int j = 0; j < avlTree.numberOfVertices; j++){
			 avlTree.deleteKeyStartsWith(c);
			 }
		 }
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("Numbers of Nodes in the tree " + avlTree.numberOfVertices);
		 System.out.println();
		 
		 System.out.println();
		 System.out.println("AVL Tree keys after deletion of d-n characters");
		 avlTree.inOrderTraversal(avlTree.root);
		 System.out.println();
		 
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("Testing Deletion method");
		 System.out.println("The root of the tree is: " + "'" + avlTree.root.getKey() + "'");
		 avlTree.delete(avlTree.root.getKey());
		 System.out.println("The new root of the tree is: " + "'" + avlTree.root.getKey() + "'");
		 System.out.println();
		 System.out.println();
		 System.out.println("AVL Tree keys after deletion of the root");
		 avlTree.inOrderTraversal(avlTree.root);
	
		

	}

}
