/**This is the TestHarness Class 
 *
 *This class test all the methods
 *for the BinarySearchTree and 
 *the Threaded Binary threaded tree
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
		
		/////////////////////////////////////
		//reading in the file 
		readFile read = new readFile();
		String dataInput = "";
		dataInput = read.readFile();
		//////////////////////////////////////
		
		//instantiating BinarySerachTree and ThreadedBinaryTree
		BinarySearchTree bst = new BinarySearchTree();
		ThreadedBinaryTree btThreaded = new ThreadedBinaryTree();
		
		
		//changing string to string Array by spiting it with white spaces
		String[] arrayString = dataInput.split("\\s",-1); 
		
		//looping through the array and adding it to the BST
		for(int i = 0; i< arrayString.length-1; i++){
			
			//adding each string in the array to the BST 
			bst.add(arrayString[i]);
		}
		
		//creating the stack with the size of the array length
		Stack<String> myStack = new Stack<String>(arrayString.length-1);
		
		//Calling the inOrderTraversaStack method 
		//This passes myStack object into the method
		//return the stack
		bst.inOrderTraversaStack(bst.root, myStack);
		 
		//poping each data off the stack to display the data
		 System.out.println("InOrder Traversal Stack");
		 for(int i = 0; i< arrayString.length-1; i++){
			 if(!myStack.empty()){
			   System.out.println("Poping Stack : " + myStack.pop());
			 }
		 }
		 
		 
		 /*This method calls the
		  * 
		  * BinarySearchTree method preOrderTraversal, inOrderTraversal
		  * and postOrderTraversal and it display the output
		  * 
		  * */
		 
		System.out.println();
		System.out.println("Preorder Traversal: ");
		bst.preOrderTraversal(bst.root);
		System.out.println();
		System.out.println();
		System.out.println("inorder Traversal: ");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		System.out.println();
		System.out.println("Postorder Traversal: ");
		bst.postOrderTraversal(bst.root);
		
		/*
		 *Adding the data in the ThreadedBinaryTree called btThreaded
		 *  by looping through the string array and adding it in
		 *  the threaded B tree
		 * */
		 
			for(int i = 0; i< arrayString.length-1; i++){
				//System.out.println(arrayString[i]);		
				btThreaded.insert(arrayString[i]);
			}
			
			
			 /*Calling the method for displaying it in-order recursive
			  * and iteratively 
			  * 
			  * and postOrderTraversal and it display the output
			  * 
			  * */
			System.out.println();
			System.out.println();
			System.out.println("Threaded Recursive In-Order Traversal");
			btThreaded.printTree();
		    System.out.println();
		    System.out.println("Threaded iterative In-Order Traversal");
		    btThreaded.displayTree();

	}

}
