import java.util.Scanner;


class Link {
    public String list;
    //public String element;
    public Link nextLink;
    public Link downLink; //pointing down
    
    //Link default constructor
    public Link() {
    	this. list = "";
	   //  this.element = "";
    }
    
    //Link constructor
    public Link(String  list) {
    	this. list = list;
    }
    

    //Link constructor
    public Link(String  list, String element) {
    	this. list = list;
	     //this.element = element;
    }

    //Print Link data
    public void printLink() {
	    //System.out.print("{" + list + ", " + element + "} ");
	     //System.out.print(list + " ");
    }
}

class LinkList {
	
	String word = ""; // building word variable
	
	String list = ""; // building word variable
	 public static int openBracketCount;
	
    private Link first;
    
    //getting firstLInk reference
    public Link getFirstLink(){
    	return first; 
    }


    //LinkList constructor
    public LinkList() {
	    first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return first == null;
    }

    /* Where the recurse call has to be done*/
    
    //Inserts a new Link at the first of the list
    //public void insert(String  list, String element) {
    
       public void insert(String  list) {
    	 
    	   //base  case 
    	   if ((list.charAt(0) == ')' && list.length() == 1)){
    		   
    		   Link link = new Link(list);
    		    link.nextLink = first;
    		    first = link;
    		   
    		   return; 
    	   }
    	   //else
    		//  list =  list.substring(0);
    		   
    		   //counting the open brackets 
    		   if(list.charAt(0) == '('){
				openBracketCount++;
    		   }
    		   
    	   //System.out.println(list.substring(1));
    	   //System.out.println();
    	   //Recursive call
    		   insert(list.substring(1));
    		   
    		   //building the string and adding it to the linked list
    		   if(list.charAt(0) != ' ' && list.charAt(0) != '('){
    			   word = list.substring(0, list.length()-list.length()+1) + word;
    			   //System.out.println("The word is " + word);
    			   //checking the elements for whitespace and brackets before creating the linkedlist
    		   } else if (list.charAt(0) == ' ' ||  list.charAt(0) == '('){
    			   //System.out.println(word);
    			   
    			    Link link = new Link(word);
    			    link.nextLink = first;
    			    first = link;
    			   
    			   word = "";
    			   
    		      } 
    		   //System.out.println("Firstlink " + first.list);
    		  
    		  // System.out.println("Firstlink " + first.list);
    		  // System.out.println(openBracketCount);
    		   if(list.charAt(0) == '(' && openBracketCount >1) {
    		    	  Link link = new Link("(");
    		    	  link.downLink = first; 
    		    	  //link.nextLink = first.nextLink; 
    		    	  //System.out.println("Firstlink " + first.list);
    		    	  
    		    	  //System.out.println("Downlink down " + link.downLink.list);
    		    	  
    		    	  if( link.downLink.nextLink != null){
    		    	    //System.out.println("Downlink next " + link.downLink.nextLink.list);
    		    	  } 
      			     // link.nextLink = first;
      			    first = link;
      			  openBracketCount--;
      			  //System.out.println("Firstlink " + first.downLink.nextLink.list);
      			 //System.out.println(openBracketCount);
    		      }
    		   if(list.charAt(0) == '(' && openBracketCount  == 1) {
    			   Link link = new Link("(");
 		    	  link.downLink = first; 
 		    	 first = link;
    		   }
    		   
    		   //System.out.println(openBracketCount);
 
    		   
    	      // System.out.println(list.substring(0, list.length()-list.length()+1));
    		   
	  /*  Link link = new Link(list.substring(0, list.length()-list.length()+1));
	    link.nextLink = first;
	    first = link;*/
    }

    //Deletes the link at the first of the list
    public Link delete() {
	    Link temp = first;
	    first = first.nextLink;
	    return temp;
    }

    //Prints list data
   /* public void printList() {
	    Link currentLink = first;
	    System.out.print("List: ");
	       while(currentLink != null) {
		    currentLink.printLink();
		    currentLink = currentLink.nextLink;
	    }
	    
	    
	    
	    System.out.println("");
    }*/
    
    //printing recursive 
    public String printList(Link referenceLink) {
	    //Link currentLink = referenceLink;
	    //System.out.print("List: ");
	    
	    if(referenceLink.downLink != null){
	    	printList(referenceLink.downLink);
	    	System.out.println(referenceLink.downLink.list);
	    	if(referenceLink.downLink.list == "(" || referenceLink.downLink.list == ")"){
	    		//System.out.print(referenceLink.downLink.list);
	    		list = referenceLink.downLink.list +  list;
	    	}else{
	    		//System.out.print(referenceLink.downLink.list);
	    		list = referenceLink.downLink.list +  " " + list;
	    	}
	    	
	    	//System.out.print(referenceLink.downLink.list);
	    }
	    
	    if(referenceLink.nextLink != null){
	    	printList(referenceLink.nextLink);
	    	//System.out.println(referenceLink.nextLink.list);
	    	 // list = referenceLink.nextLink.list + " " + list;
	    	if(referenceLink.nextLink.list == "(" || referenceLink.nextLink.list == ")"){
	    		list = referenceLink.nextLink.list +  list;
	    		//System.out.print(referenceLink.nextLink.list);
	    	}else{
	    		//System.out.print(referenceLink.nextLink.list);
	    		list = referenceLink.nextLink.list + " " +  list;
	    	}
	    	
	          //System.out.print(referenceLink.nextLink.list);
	    }
	    return list; 
	   // printList();
	    
	    /*while(currentLink != null) {
		    currentLink.printLink();
		    currentLink = currentLink.nextLink;
	    }*/
	    
	    
	    
	    //System.out.println("");
    }
    
}  

public class Assignment_1 {
    public static void main(String[] args) {
	    LinkList list = new LinkList();
	    
	    Scanner scannerUserInput = new Scanner(System.in);
	    
	    String input; 
	    String[] command; 
	    
	    System.out.print("setq or print or exit:" );
	    input = scannerUserInput.nextLine();
	    
	    //System.out.println(input);
	    command = input.split("\\s+");
	    
	    Link printlist = new Link();
	      printlist = list.getFirstLink();
	    
	    while(command[0].toString().compareTo("exit") != 0){
	    	
	        if(command[0].toString().equals("setq") ){
		    	System.out.println("Works!");
		    	  System.out.println("What is in here!" + input.substring(5, input.length()));
		    	  list.insert(input.substring(5, input.length()));
		    	  
		    	  printlist = list.getFirstLink();
		    	  
		    	  System.out.println("The list is " +printlist.list );
		    }
	        
	        if(command[0].toString().equals("print") ){
		    	System.out.println("print");
		    	
			     //Link printlist = new Link();
			      //printlist = list.getFirstLink();
			      
			     // System.out.println("I m the reference " +printlist.nextLink.downLink.list);
			      //getFirstLink(){
			      String  listGetter = ""; 
			      listGetter =  list.printList(printlist);
			    
			      System.out.println();
			    System.out.println(listGetter);
		    	
		    }
	        //getting user command again
	        
		    System.out.print("setq or print or exit:" );
		    input = scannerUserInput.nextLine();
		    
		    //System.out.println(input);
		    command = input.split("\\s+");
	        
	    	
	    }
	    
	    
	    //System.out.println(command[0].toString());
	    //System.out.println(input.subSequence(0, 4));
	    // input.substring(0, input.length());
	    //System.out.println("This is the output " + input);

	
	    
	    //input = args[0].toString();
	    
	    //System.out.println("the user input is " + args[0]);
	    
	    //String testData = "a '((apple orange) (plum lemon))";
	    //String testData = "(((((((((apple orange )))) bananan))))))))))))))))))))))))))))";
	   // String testData = "((a b c))";

	     
	      
	      
	     //  list.insert(2, 2.02);
	    //list.insert(3, 3.03);
	    //list.insert(4, 4.04);
	    //list.insert(5, 5.05);

	    //list.printList();

	/*    while(!list.isEmpty()) {
		    Link deletedLink = list.delete();
		    System.out.print("deleted: ");
		    deletedLink.printLink();
		    System.out.println("");
	    }*/
	      
    }
}