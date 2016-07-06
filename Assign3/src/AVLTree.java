/**This is the AVL Tree Class 
 * 
 * Methods to Traverse through the tree by 
 * inOrder recursively displaying the values.
 * 
 * The AVL tree class has deletion and insertion with is AVL compliance
 * by checking the height of the right and left side
 * 
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */
	public class AVLTree {
	    
	    public Node root;
	    public int numberOfVertices;
	    
		/*Constructor*/
		public AVLTree(){
			root = null;
		}
	    

/**inOrder Traversal recursive Print
* 
* 1. Traverse the left subtree
* 2. Visit the root	 * 
* 3. Traverse the right subtree
* */
	    public void inOrderTraversal(Node node){
	    	
	    	 if(node == null){
		            System.out.println("AVL Tree is empty ");
		            return;
		        }
	    	
	        if(node.getLeftChild() != null)
	            inOrderTraversal(node.getLeftChild());
	        
	        System.out.print(node.getKey() + ": " + node.getDuplicate() + ", ");
	        
	        if(node.getRightChild() != null)
	            inOrderTraversal(node.getRightChild());
	    }  
	    
/**inserting into the AVL tree
* 
* java method chaining with one input, only the string value
* 
*/	    
		public void insert(String value){
			root = insert(value, root);
		}
	    
/**inserting into the AVL tree
* 
* This method inserts data into the AVL tree
* check for AVL compliance by calling the
* IsAVL method to check the height on the rigth and 
* left side of the node
* 
*/		
	    public Node insert(String element, Node node){
	    	
	    	
	        //if node is null insert new node
	        if(node == null){
	            node = new Node();
	            node.setKey(element);
	            numberOfVertices++;
	            //System.out.println("Inserted " + element);
	        }
	        
	        // Insert on Left Branch
	        else if(element.compareTo(node.getKey()) < 0){
	            node.setLeftChild(insert(element, node.getLeftChild()));
	            
	            //checking for AVL compliance

	            if(IsAVL(node) == false){//calling the method if it's AVL
	            	 //Left sub-tree out of balance
	            	//single rotating Left to Right 
	            	System.out.println("Left Sub Tree of: " + "'"+ node.getKey() + "'" + " is not AVL compliance! ");
	                if(element.compareTo(node.getLeftChild().getKey()) < 0){
	                	System.out.println("Single rotation Left to Right: " + "'"+node.getKey() + "'");
	                    node = singleRotateLeftToRight(node);
	                }else{      
	                	//Double rotating Left to Right
	                	System.out.println("Double rotation Left to Right: " + "'"+node.getKey() + "'");
	                    node = doubleRotateLeftToRight(node);
	                }
	            }
	            else{
	            	//setting the height of the tree, find the max side of each side and returning the largest value plus one
	            	//I use a bit of this code from Dave's notes
	            	//Code Referenced from: http://www.cosc.brocku.ca/~bockusd/2p03/Daves_Notes.doc
	            	//page 13 of the AVL tree notes
	            	node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	            	
	            	            	
	            }
	        }
	        
	        // Insert on Right Branch
	        else if(element.compareTo(node.getKey()) > 0){
	            node.setRightChild(insert(element, node.getRightChild()));
	                    
	            //check for AVL compliance
	            if(IsAVL(node) == false){
	            	//Left sub-tree out of balance
	            	System.out.println("Right Sub Tree of: " + "'"+ node.getKey() + "'" + " is not AVL compliance! ");
	                if(element.compareTo(node.getRightChild().getKey()) > 0){ 
	                	//Single rotating Right to left
	                	System.out.println("Single rotation Right to Left: " + "'"+node.getKey() + "'");
	                    node = singleRotateRightToLeft(node);
	                }else{
	                	//Double rotating Right to left
	                	System.out.println("Double rotation Right to Left: " + "'"+node.getKey() + "'");
	                    node = doubleRotateRightToLeft(node);
	                }
	            }
	            else{
	            	node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	                	                 	                                
	            }
	        }
	        else{
	            node.duplicate();//// Do nothing, it's already in the tree
	            
	        }
	        return node;
	    }
	    
	    //getting the height of the tree
	    public int height(Node node){
	        if(node == null)
	            return -1;
	        else
	            return node.getHeight();
	    }
	    
/**deleting keys from the AVL tree
* 
* java method chaining with one input, only the string value
* 
*/	 	
	    public void delete(String value){
			root = delete(value, root);
		}
	    
/**deleting keys from the AVL tree
* 
* This method deletes keys from the AVL tree
* check forAVL compliance by calling the
* IsAVL method to check the height on the rigth and 
* left side of the node
* 
*/		    
	    public Node delete(String element, Node node){
	        
	    	// Base case: key doesn't exist.
	        if(node == null)
	            return node;
	        
	       // If it's in the left sub-tree, go left.
	        if(element.compareTo(node.getKey()) < 0){
	            node.setLeftChild(delete(element, node.getLeftChild()));
	            //check for AVL compliance
	            if(IsAVL(node) == false){
	            	 //Left sub-tree out of balance
	            	System.out.println("Left Sub Tree of: " + "'"+ node.getKey() + "'" + " is not AVL compliance! ");
	
	            	//single rotating Right to left 
	            	if(node.getRightChild().getRightChild() != null) {
	                	System.out.println("Single rotation Right to left: " + "'"+node.getKey() + "'");
	                      //node = sRotateLeftToRight(node);
	                	 node = singleRotateRightToLeft(node);
	                  
	                }else{
	                	//Double rotating Right to left 
	                	System.out.println("Double rotation Right to left: " + "'" +node.getKey() + "'");
	                	node = doubleRotateRightToLeft(node);
	                }
	            }
	            else{
	                node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	            }
	        }
	        
	     // If it's in the right sub-tree, go right.
	        else if(element.compareTo(node.getKey()) > 0){
	            node.setRightChild(delete(element, node.getRightChild()));
	            //checking for AVL compliance
	            if(IsAVL(node) == false){
	            	
	            	 //Right sub-tree out of balance
	            	System.out.println("Right Sub Tree of: " + "'"+ node.getKey() + "'" + " is not AVL compliance! ");

	            	//Single rotating left to right
	            	    if(node.getLeftChild().getLeftChild()!= null){
	                	System.out.println("Single rotation Left to Right: " + "'"+ node.getKey() + "'");
	                    node = singleRotateLeftToRight(node);
	                    
	                }else{    
	                	//Double rotating left to right
	                	System.out.println("Double rotation Left to Right: " + "'"+ node.getKey() + "'");
	                     node = doubleRotateLeftToRight(node);
	                }
	            }
	            else{
	                node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
	            }
	        }
	        //Case 1: Deleting leaf node No Children
	        else if(node.getLeftChild() == null && node.getRightChild() == null){
	            System.out.println("Case 1 Deletion: " + "'" + node.getKey() + "'");
	            node.setRightChild(delete(node.getKey(), node.getRightChild()));
	            numberOfVertices--;
	            node = null;
	        }
	        
	        //Case 3: Deleting Node with two Children
	        else if(node.getLeftChild() != null && node.getRightChild() != null){
	            System.out.println("Case 3 Deletion: " + "'" + node.getKey() + "'");
	            //Coping the value of the successor in node
	            String value;
	            value = (successor(node));
	            node.setKey(value);
	            //System.out.println("The Successor is  " + node.getKey());
	            numberOfVertices--;
	            node.setRightChild(delete(node.getKey(), node.getRightChild()));
	        }
	        //Case 2 Deleting Node with one Child
	        else{
	            if(node.getLeftChild() != null && node.getRightChild() == null){
	                numberOfVertices--;
	                System.out.println("Case 2 Deletion: " + "'" + node.getKey() + "'");
	                node = node.getLeftChild();
	            }
	            else if (node.getLeftChild() == null && node.getRightChild() != null){
	                numberOfVertices--;
	                System.out.println("Case 2 Deletion: " + "'" + node.getKey() + "'");
	                node = node.getRightChild();             
	            }
	        }
	        
	        return node;
	    }
	    
	    
/**
 * This method find the successor of the right sub tree
 * Minimum value and returning that value.
 * 
 * This method is only used for Case 3 of deletion with parent having
 * two children.
 */
	    public String successor(Node node){
	        
	        node = node.getRightChild();
	        String value; 
	        //getting the minimum value in the right sub tree
	        while(node.getLeftChild() != null){
	            node = node.getLeftChild();
	        }
	        
	        value = node.getKey();
	        
	        return value;
	    }
	    
	    /**The rotating method single right or life and double right or left
 	   I use this code from Dave's notes 
 	   Code Referenced from: http://www.cosc.brocku.ca/~bockusd/2p03/Daves_Notes.doc
 	   page 14 of the AVL tree notes*/
	    
	    public Node singleRotateLeftToRight(Node k2){
	        Node k1;
	        k1 = k2.getLeftChild();
	        k2.setLeftChild(k1.getRightChild());
	        k1.setRightChild(k2);
	        
	        k2.setHeight(1 + Math.max(height(k2.getLeftChild()), height(k2.getRightChild())));
	        k1.setHeight(Math.max(height(k1.getLeftChild()), k2.getHeight()) + 1);
	        k2 = k1;
	        
	        return k2;
	    }
	    
	    public Node singleRotateRightToLeft(Node k2){
	    
	        Node k1;
	        k1 = k2.getRightChild();
	        k2.setRightChild(k1.getLeftChild());
	        k1.setLeftChild(k2);
	        
	        k2.setHeight(1 + Math.max(height(k2.getRightChild()), height(k2.getLeftChild())));
	        k1.setHeight(Math.max(height(k1.getRightChild()), k2.getHeight()) + 1);
	        k2 = k1;
	        
	        return k2;
	    }
	    
	    public Node doubleRotateLeftToRight(Node k3){
	        k3.setLeftChild(singleRotateRightToLeft(k3.getLeftChild()));
	        k3 = singleRotateLeftToRight(k3);
	        return k3;
	    }
	    
	    public Node doubleRotateRightToLeft(Node k3){
	        k3.setRightChild(singleRotateLeftToRight(k3.getRightChild()));
	        k3 = singleRotateRightToLeft(k3);
	        return k3;
	    }
	    
	    
	    
	    
/**getting the height of the left and right side 
 * checking for AVL compliance
 * 
 * If the left or right side is equal to 2 then return false
 * 
 * */
	    public boolean IsAVL(Node node){
	    	
	    	if(height(node.getLeftChild()) - height(node.getRightChild()) == 2 || height(node.getRightChild()) - height(node.getLeftChild()) == 2){
	    		//return false if it's not AVL
	    		return false; 
	    	}else{
	    		//return true if it's AVL
	    		//System.out.println("Tree is AVL compliance!");
	    		return true;	
	    	}
	    	
	    	
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
			 if(node == null){
		            System.out.println("AVL Tree is empty ");
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
