/**This is the SplayTree Class
 * 
 * This is a top down splay tree.
 * 
 * The Class has the following operations. 
 * Insert, Delete, Find and InOrder.
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (November 2014)
 * Compiler Version Java 1.7
 */

public class SplayTree
{
    
    //Class fields
	private Node root;
	private int numberOfVertices;

	 // constructor
    public SplayTree() {
        root = null;
    }
    
    
	public int getNumberOfVertices() {
		return numberOfVertices;
	}


	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}
	
	public Node getRoot() {
		return root;
	}
    
	
    /**
     * Test if the tree is empty.
     */
    public boolean isTreeEmpty() {
        return root == null;
    }
    
    /**inserting into the Splay tree
    * 
    * java method chaining with one input, only the string value
    * 
    */	    
    		public void insert(String value){
    			 insert(value, root);
    		}

    /**
     * Insert into the tree method.
     * This method calls the splay method as well
     */
    public void insert(String key, Node newNode) {

    //checking if the tree is empty  
	if (isTreeEmpty()) {
	    root = new Node(key);
	    //counting the vertices of the tree
	    setNumberOfVertices(getNumberOfVertices() + 1);
	    return;
	}
	
	//calling the find method and splay the tree
	find(key);

		if ((key.compareTo(root.getKey())) == 0) {
			//Do nothing, it's already in the tree, duplicate value
			root.duplicate();
	        return;
	}
	//create a new Node with the new Key value
	newNode = new Node(key);
	setNumberOfVertices(getNumberOfVertices() + 1);

	 // Insert on Left Branch
	 // NewNode is left child of the root
	if (key.compareTo(root.getKey()) < 0) {
		
		// NewNode is left child of the root
	    newNode.setLeftChild(root.getLeftChild());
	    newNode.setRightChild(root);
	    
	    //clear the root to null
	    root.setLeftChild(null);
	    
	 // Insert on Right Branch
	} else {
		
		// NewNode is Right child of the root
	    newNode.setRightChild(root.getRightChild());
	    newNode.setLeftChild(root);
	    //clear the root to null
	    root.setRightChild(null);
	}
	  root = newNode;

    }

    /**
     * Find an item in the tree. And Splaying it to the root
     */
    public String find(String key) {
	if (isTreeEmpty()){ 
		System.out.println("The tree is empty!");
		return null;
	}
	splay(key);
        if(root.getKey().compareTo(key) != 0){ 
        //System.out.println("The key is not found!");
        	return null;
        }
        return root.getKey();
    }
    
    
    /**
     * Remove key from the tree, if the value is the equal the root
     * then its not in the tree.
     */
    public void delete(String key) {
	Node rightNodeTemp;
	
	//calling the find method and splay the tree
	find(key);
	
	if (key.compareTo(root.getKey()) != 0) {
		System.out.println("The key is not found!");
	    return;
	}
	
	//removing the root, setting setting to the Right Child 
	if (root.getLeftChild() == null) {
	    root = root.getRightChild();
	    //Subtracting one from the counter of NumberOfVertices  
	    setNumberOfVertices(getNumberOfVertices() - 1);
	    
	   
	} else {
	/*removing the root, using rightNodeTemp to hold the right side of the tree
	 * while the root increment to the leftside  */
		rightNodeTemp = root.getRightChild();
	    root = root.getLeftChild();

		//calling the find method and splay the tree
		find(key);
	    root.setRightChild(rightNodeTemp);
	  //Subtracting one from the counter of NumberOfVertices 
	    setNumberOfVertices(getNumberOfVertices() - 1);
	}
    }
    
    /**
     * Method to perform a top-down splay.
     * 
     * The method uses three sub trees
     * Two temporary sub trees
     * 
     * leftSubTreeMaxNodeTemp contains nodes smaller than the key
     * RightSubTreeMaxNodeTemp contains nodes larger than the key
     * 
     * The parentNode/root contains the value that's closest to the 
     * key. Once it's found it gets assemble.
     * 
     * parentNode left child points to leftSubTreeMaxNodeTemp
     * parentNode right child points to RightSubTreeMinNodeTemp
     * 
     * 
     * Code Referenced from:
     * 
     * I used part of the rotation algorithm idea on how to do the rotation
     *  for the Top down Splay from these sources 
     * 
     * http://users.cis.fiu.edu/~weiss/dsaajava/code/DataStructures/SplayTree.java
     *  
     * ftp://ftp.awl.com/cseng/authors/weiss/java2e/PowerPoint/PDF/Ch22_Weiss.pdf
     */

    private void splay(String key) {
    	
	Node leftSubTreeMaxNode, rightSubTreeMinNode, parentNode;
	
	//temporary sub trees
	Node leftSubTreeMaxNodeTemp = new Node(null);
	Node rightSubTreeMinNodeTemp = new Node(null);
	
	leftSubTreeMaxNode = leftSubTreeMaxNodeTemp;
	rightSubTreeMinNode = rightSubTreeMinNodeTemp;
	parentNode = root;
	

	while (true) {
		
		 // Checking what side of the tree to go to, Go to Left Branch if less than zero
	    if (key.compareTo(parentNode.getKey()) < 0) {
	    // If Parent has no left Children break
		if (parentNode.getLeftChild() == null){ 
			break;
		}
		//Go to Parent's left node left child 
		if (key.compareTo(parentNode.getLeftChild().getKey()) < 0) {
			
		      /* rotate right Zig*/		    
		      parentNode = singleRotateLeftToRight(parentNode);
		    
		    if (parentNode.getLeftChild() == null){ 
		    	break;
		    }
		}
		
		 /* link right */
		rightSubTreeMinNode.setLeftChild(parentNode);                              
		rightSubTreeMinNode = parentNode;
		  
		//Increment to the left side of the tree
		  parentNode = parentNode.getLeftChild();
		
		// Checking what sub tree to go to, Go to Right Branch if greater than zero
	    } else if (key.compareTo(parentNode.getKey()) > 0) {
	    // If Parent has no right Children break
		if (parentNode.getRightChild() == null){ 
			break;
		}
		
		//Checking if Parent's right child is greater than zero
		if (key.compareTo(parentNode.getRightChild().getKey()) > 0) {
			
              /* rotate left Zig*/		
		    parentNode = singleRotateRightToLeft(parentNode);
		    	    
		    if (parentNode.getRightChild() == null){
		    	break;
		    }
		}
		/* link left */
		leftSubTreeMaxNode.setRightChild(parentNode);                         
		leftSubTreeMaxNode = parentNode;
		
		//Increment to the right side of the tree
		parentNode = parentNode.getRightChild();
	    } else {
		break;
	    }
	}
	
	 /* assembling the two sub tree into one tree*/
	leftSubTreeMaxNode.setRightChild(parentNode.getLeftChild());                                 
	rightSubTreeMinNode.setLeftChild(parentNode.getRightChild());

	/*Parent Tree points to the left and right side of the temp subtree*/
	parentNode.setLeftChild(leftSubTreeMaxNodeTemp.getRightChild());
	parentNode.setRightChild(rightSubTreeMinNodeTemp.getLeftChild());
	
	
	
	root = parentNode;
    }
    
    /**The rotating method single right or life
	   I use this code from Dave's notes 
	   Code Referenced from: http://www.cosc.brocku.ca/~bockusd/2p03/Daves_Notes.doc
	   page 14 of the AVL tree notes*/
    
    
    //rotating left children of the parent to the right
    public Node singleRotateLeftToRight(Node k2){
    	
        Node k1; //temporary node for swapping
        k1 = k2.getLeftChild();
        k2.setLeftChild(k1.getRightChild());
        k1.setRightChild(k2);
        k2 = k1;
        
        return k2;
    }
    
    //rotating right children of the parent to the Left
    public Node singleRotateRightToLeft(Node k2){
	    
        Node k1;//temporary node for swapping
        k1 = k2.getRightChild();
        k2.setRightChild(k1.getLeftChild());
        k1.setLeftChild(k2);
        k2 = k1;
        
        return k2;
    }
    
    /**inOrder Traversal recursive Print
    * 
    * 1. Traverse the left subtree
    * 2. Visit the root	 * 
    * 3. Traverse the right subtree
    * */
    	    public void inOrderTraversal(Node node){
    	    	
    	    	 if(isTreeEmpty()){
    		            System.out.println("AVL Tree is empty ");
    		            return;
    		        }
    	    	
    	        if(node.getLeftChild() != null)
    	            inOrderTraversal(node.getLeftChild());
    	        
    	        System.out.print(node.getKey() + ": " + node.getDuplicate() + ", ");
      	       // System.out.print(node.getKey() + " ");
    	        
    	        
    	        if(node.getRightChild() != null)
    	            inOrderTraversal(node.getRightChild());
    	    }
    	    
    	    /**preOrder Traversal recursive Print
    	     * 
    	     * 1. Visit the root	 * 
    	     * 2. Traverse the left subtree
    	     * 3. Traverse the right subtree
    	     * */
    	     	    public void preOrderTraversal(Node node){
    	     	    	
    	     	    	 if(isTreeEmpty()){
    	     		            System.out.println("AVL Tree is empty ");
    	     		            return;
    	     		        }
    	     	    	 
    	     	    	 System.out.print(node.getKey() + ": " + node.getDuplicate() + ", ");
      	       	       // System.out.print(node.getKey() + " ");
    	     	    	
    	     	        if(node.getLeftChild() != null)
    	     	            inOrderTraversal(node.getLeftChild());
    	     	        
    	     	        
    	     	        if(node.getRightChild() != null)
    	     	            inOrderTraversal(node.getRightChild());
    	     	    }
    	    
    	    
    	    /**
    	     * 
    	     * deleting keys from the AVL tree, using only the 
    	     * a single character to match the first character of 
    	     * the key value.
    	     * 
    	     * java method chaining with one input
    	     * 
    	     */

    	    		public void deleteKeyStartsWith(char singleCharacter) {
    	    			deleteKeyStartsWith(singleCharacter, root);
    	    			
    	    		}


    	    		private void deleteKeyStartsWith(char singleCharacter, Node node) {
    	    			
    	    			// if the node is null, return null
    	    			 if(isTreeEmpty()){
    	    		            System.out.println("The Tree is empty ");
    	    		            return;
    	    		        }
    	    			 
    	    			 //if the character much the key first character call the delete method
    	    			 if(singleCharacter == node.getKey().charAt(0)){
    	    		            //System.out.println(c + " is the first letter of " + node.getKey());
    	    		            delete(node.getKey());
    	    		            return;
    	    		        }
    	    			 
    	    			 //go left recursively
    	    			 if(singleCharacter < node.getKey().charAt(0) && node.getLeftChild() != null){
    	    				 //System.out.println("Left " + c + " is the first letter of " + node.getKey());
    	    				 deleteKeyStartsWith(singleCharacter, node.getLeftChild());
    	    			 }
    	    			
    	    			 //go right recursively
    	    			   if(singleCharacter > node.getKey().charAt(0) && node.getRightChild() != null){
    	    				   //System.out.println("Right " + c + " is the first letter of " + node.getKey());
    	    				   deleteKeyStartsWith(singleCharacter, node.getRightChild());
    	    			   }
    	    			
    	    			
    	    		}





}

