/**
 * This is the LinkedList class, it has the methods 
 * 
 * insert = to add to the linked list
 * delete = to delete part of the linked list
 * display = to show the linked list
 * displayEveryThing = to show everything
 *  copy = to make a copy of a linked list
 *  
 * @author Long Nguyen
 * 
 * @version 1.0 (September 2014)
 * Compiler Version,Java 1.6
 * */

package LinkedList;


public class MyLinkedList {

	public Node head; // points to the beginning of the list
	public Node pervious; // pointing at the pervious node 
	public Node top; // pointing at the pervious node 
	 public static int openBracketCount;
	 public static int characters =1;// one extra because of the base case
	 String word = ""; // building word before inserting
	 String list = ""; // building word to print out
	 
	 static boolean apostrophe = false; 
	
	//default constructor setting the nodes to null; 
	MyLinkedList(){
		head = null;
		pervious = null;
		top = null;
	}
	
	  //getting firstLInk reference
    public Node getFirstLink(){
    	return head; 
    }
	
	//checking if the Linked list is empty
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * The insert method builds the list recursively by going to the end of the string 
	 *  and working backward to the beginning 
	 * **/
	
	public void  insert(String list) {
		
	 	   /************BASE CASE of the Recursion************/  
		   //checking to see if it's the last closing bracket
 	   if ((list.charAt(0) == ')' && list.length() == 1)){
 		 
 		   Node link = new Node(list);
 		    link.nextLink = head;
 		    head = link;
 		   
 		   return; 
 	   }
 	   
 	   //counting the open brackets 
	   if(list.charAt(0) == '('){
		openBracketCount++;
	   }
	   
	   characters++;//counting the characters in the string
	   
	   /***************Recursive call********************
	    *subtracting one from the string each time when calling the Recursion 
	    */
	   insert(list.substring(1)); 
	   
	   //decrementing the character of the string
	   characters--;
	   
	   //checking for apostrophe
		 if(list.charAt(0) == '\''){
	   apostrophe = true; 
      }
	   
	   //building the string before adding it to the linked list
	   if(list.charAt(0) != ' ' && list.charAt(0) != '(' && list.charAt(0) != ')' && list.charAt(0) != '\''){
		   word = list.substring(0, list.length()-list.length()+1) + word;
		    //System.out.println("The word is " + word);
	   } 
	   
	  /* checking if the string's character at index zero is either white space,
	   *  open, closing bracket or character is equal to one*/
	   if (list.charAt(0) == ' ' ||  list.charAt(0) == '(' || list.charAt(0) == ')' || list.charAt(0) == '\'' || characters == 1){
		   
	        //if the string is not empty 
		    if(!word.equals("")){
		    	//System.out.println("The word is " + word);
		    	if(list.charAt(0) == ')' && pervious != null ){
		    		//*****
			    	//System.out.println(word);
				    Node link = new Node(word);
				    pervious.nextLink = head;
				    pervious.downLink = link;
				    //link.nextLink = head;
				    head = link;	   
				   word = ""; //resetting the word back to empty
		    		
		    	}

		    	//if apostrophe is true then create the last value for the list
		    	  if(apostrophe ==  true){
		    		  //System.out.println("True!");
		   		   apostrophe =  false; // setting it back to false
		   		   
		   		   //adding an extra bracket 
		   		   if(openBracketCount == 0){
		   			Node link = new Node("(");
			    	  link.nextLink = head; 
			    	  head = link;
		   		   }

		   		   //creating the last value of the list, which is the first value of the list
		   		   Node link = new Node(word);	   
		   	    	  link.downLink = head; 
		   	    	  
		   	    	  //if top is null, then point top to the new created link
		   	    	  if(top == null){
		   	    		  top = link; 
		   	    	  }else{
		   	    		  //point the new created node next pointer to top
		   	    		  link.nextLink = top;
		   	    		  top = link;  // top is now pointing at link
		   	    	  }
		   	    	  //resetting all the values back to default
		   	    	  word = "";
		   	    	  head = null;
		   	    	  pervious = null;
		   	   }else{
		    	    //create the node normally with the string found
				    Node link = new Node(word);
				    link.nextLink = head;
				    head = link;	   
				   word = ""; //resetting the word back to empty
		    	}//end else
	
		    	
		    }
		   
	      }// end else if 
	   
	   //////////////closing bracket
	   if(list.charAt(0) == ')') {
		   Node link = new Node(")");
	    	  link.nextLink = head; 
	    	  head = link;
	    	  
	    	  //Previous node pointer
	   	   if(openBracketCount   < 1){
			   pervious = link; 
		   }
	   }
	   
	   //If there is an open bracket, it points down the linked list
	   if(list.charAt(0) == '(' && openBracketCount >1) {
		   
		   Node link = new Node("(");
		   
		   //if the bracket is greater than 1 than the head pointer will point to it
		   if(openBracketCount >1){
			   Node temp = head;
		    	  link.downLink = head; 
			    head = link;
			  openBracketCount--;
		   }
	
	      }
	   
	   //creating a new openBracket if open bracket is greater than 1
	   if(list.charAt(0) == '(' && openBracketCount  == 1) {
		   Node link = new Node("(");
	    	  link.downLink = head; 
	    	 head = link;
	    	 openBracketCount--;
	   }


	}//end of add method
	
	/**
	 * This method will display a specific linked list 
	 * he user must input the reference of the node to be printed
	 * 
	 * */
	
	public String display(String print){
		
		Node perviousPointer = null; 
		Node referenceLink = top; 
		Node tempPointer = null;
		boolean found = false; 
		list = "";
		String  listGetter = ""; 
		
		//Going though the list will it's not null
		while(referenceLink!= null){
			
			//if the value data match the user's input
			if(referenceLink.element.equals(print)){
				found = true;
				//System.out.println("Found! ");
				tempPointer = referenceLink.downLink;
				//calling the recursive printList method 
				 listGetter = printList(tempPointer);
				 //printing out the linked list to be display
				 System.out.println("==> " + listGetter);
				break;
			}else{
			referenceLink = referenceLink.nextLink;
			//System.out.println("Not Found!");
			}
		}
		if(found == false){
			System.out.println("Not Found!");
			//System.out.println("==> NIL");
		}
		return listGetter;
		
	}
	
	/**
	 * This method will display everything in the linked list 
	 * if the user didn't specificize the node to be printed
	 * 
	 * */
	
	public void displayEveryThing(){
		
		Node perviousPointer = null; 
		Node referenceLink = top; 
		
		//Going though the list will it's not null
		while(referenceLink!= null){
			
			if(referenceLink.downLink != null){
				perviousPointer = referenceLink.downLink;
				 String  listGetter = "";  // clearing the string
				 list = "";  // clearing the string
				 //calling the recursive printList method 
				 listGetter = printList(perviousPointer);		 
				 System.out.println("==> " + listGetter);
			}else{
				//referenceLink = referenceLink.nextLink;
				//System.out.println("Not Found!");
				}
			referenceLink = referenceLink.nextLink; //incrementing to next link
		}
		
	}
	
	/**
	 * 
	 * This method delete a specific reference of the linked list 
	 *  the user input the value specific node to delete
	 * 
	 * */
	
	public void delete(String print){
	
		Node perviousPointer = top; 
		Node referenceLink = top; 
		boolean found = false; 
		
		while(referenceLink!= null){
			
			//deleting first node
			if(top.element.equals(print)){
				found = true;
				System.out.println("Deleted! ");
				top = top.nextLink;
				break;
			}
			//deleting after the first node
			if(referenceLink.element.equals(print)){
				found = true;
				System.out.println("Deleted! ");
				perviousPointer.nextLink = referenceLink.nextLink;
				break;
			}else{
				//Incrementing to the next linked list node
			perviousPointer = referenceLink;
			referenceLink = referenceLink.nextLink;
			}
		}
		//if the value that the user wants to delete is not found a message will display
		if(found == false){
			//System.out.println("Not Found!");
			System.out.println("==> NIL");
		}
		
	}
	
	/**
	 *  The printList method traversal though the linked recursively and finds all the data value 
	 *  in the node and returning it as a string 
	 * 
	 * 
	 * */
	
	
	public String printList(Node referenceLink) {
		
		   if(referenceLink.downLink != null){
			   //**********recursive call going down********//
		    	printList(referenceLink.downLink);
		    	if(referenceLink.downLink.equals("(") || referenceLink.downLink.equals(")")){
		    		list = referenceLink.downLink +  list; //adding to the string when the value data is found
		    	}else{
		    		list = referenceLink.downLink +  " " + list; //adding to the string when the value data is found
		    	}
		    }
		   
		    if(referenceLink.nextLink != null){
		    	//**********recursive call going next********//
		    	  printList(referenceLink.nextLink);
		    	if(referenceLink.nextLink.equals("(") || referenceLink.nextLink.equals("(")){
		    		list = referenceLink.nextLink +  list; //adding to the string when the value data is found
		    	}else{
		    		list = referenceLink.nextLink + " " +  list; //adding to the string when the value data is found
		    	}
		    }
		    return list;  //return the string after all the data is found
		
	}
	
	/**
	 * This method makes a copy of the representation node and assigning it to a new  newly created node
	 * by calling the print display and the insert method and adding it to the linked list
	 * 
	 * */
	
	public void makeCopy(String assign, String represents){
		
		String copyingList = "";
		String assignReference = assign;
		
		copyingList = display(represents);
		copyingList = assignReference +"'"+ copyingList.trim();
		
		//System.out.println("The copy is this "+copyingList);
		
		insert(copyingList);
		
	}

}
