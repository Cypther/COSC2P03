/**
 * This is the LinkedListTest class, 
 * 
 * This test all the methods of the class to check if everything is working
 * The program simulate a LISP program
 * asking the user to setq, print or delete
 *  
 * @author Long Nguyen
 * 
 * @version 1.0 (September 2014)
 * Compiler Version,Java 1.6
 * */

package LinkedList;

import java.util.Scanner;

public class TestHarness {
	
 public TestHarness(){
	MyLinkedList list =  new MyLinkedList();
	Scanner scannerUserInput = new Scanner(System.in);// getting the user put
	String input = ""; 
	boolean validInPut = false;
	
	
	  System.out.print("setq or print or delete or copy or exit: " );
	  input = scannerUserInput.nextLine();
	  
	  input.trim();//triming the white space at the end 
	  //////////////////////////
	  //checking for valid input, if there are the same opening and closing brackets 
	  
	  String checking = "";
	  int openBracket = 0, closingBracket =0;
	  for(int i =0; i <input.length()-1; i++ ){
		  
		  checking = input.substring(i,input.length()-1);
		  if(checking.equals('(')){
			  openBracket++;
		  }
		  if(checking.equals(')')){
			  closingBracket++;
		  }
	  }
	  if(openBracket == closingBracket){
		  //System.out.println("True! had the same brackets number");
		  validInPut = true;
	  }else{
		  //System.out.println("False! doesn't have the same brackets numbers");
		  validInPut = false;
	  }
	  //////////////////////////
	 
	  String[] command = input.split("\\s+");//split the string by white spaces
	  String[] listData = input.split("'");//breaking the string from apostrophe
	  input =  listData[1] ; //adding the string from apostrophe to n-1
	   input =  command[1].substring(0,1) +"'"+  input ; //adding the first variable to the beginning of the string

	  
	while(command[0].toString().compareTo("exit") != 0){
		  
		//System.out.println("The size is " + command.length);
	        if(command[0].toString().equals("setq") && command[2].substring(0,1).equals("'") && validInPut == true){
                  //Checking if there's a bracket at the end of the string
	        	if(input.subSequence(input.length()-1, input.length()).equals(")")){
		    	  list.insert(input);
	        	}else{
	        		System.out.println("In valid input!");
	        	}
		    }
		  	  
	        //print out the listed list
	        if(command[0].toString().equals("print") ){
	        	System.out.println("The size is " + command.length);
		    	//If the user didn't have a specific value to display
	        	if(command.length == 1){
	        		 list.displayEveryThing();
	        	}else{
			    	String x = command[1];
						list.display(x); 	
	        	}
		    }
	        
	        //To make a copy of a list
	        if(command[0].toString().equals("setq") &&  !command[2].toString().equals("nil") && !command[2].substring(0,1).equals("'")){
	        	System.out.println("The size is " + command.length);
	        	System.out.println( command[1] + " " + command[2]);
	        	 list.makeCopy( command[1], command[2]);
				    }
	        
	        //To delete a specific linked list
	        if(command[0].toString().equals("setq") &&  command[2].toString().equals("nil")){
				    	String userPut = command[1];
				    	list.delete(userPut);
				    }
		  
		  
		    System.out.print("setq or print or delete or copy or exit: " );
		    input = scannerUserInput.nextLine();
		    
		    input.trim();//triming the white space at the end 
			  //////////////////////////
			  //checking for valid input, if there are the same opening and closing brackets 
			  
			  checking = "";
			  openBracket = 0;
			  closingBracket =0;
			  for(int i =0; i <input.length()-1; i++ ){
				  
				  checking = input.substring(i,input.length()-1);
				  if(checking.equals('(')){
					  openBracket++;
				  }
				  if(checking.equals(')')){
					  closingBracket++;
				  }
			  }
			  if(openBracket == closingBracket){
				 // System.out.println("True! had the same brackets number");
				  validInPut = true;
			  }else{
				  //System.out.println("False! doesn't have the same brackets numbers");
				  validInPut = false;
			  }
			  //////////////////////////
		    
		    //System.out.println(input);
		    command = input.split("\\s+");
	  }//end while loop
 }
	

	public static void main(String[] args) {
		
		
		//Asking if the user wants to be in commend line mode or test mode
		Scanner scannerUserInput = new Scanner(System.in);// getting the user put
		String input = ""; 
		
		System.out.println("Test mode for push: 0" );
		System.out.println("Commend line mode for push: 1" );
		input = scannerUserInput.nextLine();
		
		/**
		 * Test hardHarness with the commend line user interface
		 * Where the user have to input the values
		 * */
		if(input.equals("1")){
		new TestHarness(); // new instance of Testharness 
		}
		
		if(input.equals("0")){
			
		/**
		 * Testing each methods without the commend line
		 * predefined test data that test each methods
		 * testing the insert, delete, display, copying method
		 * */
		MyLinkedList list =  new MyLinkedList();
		
		System.out.println("Setq x'((apple orange) (plum lemon))");
		String testData1 = "x'((apple orange) (plum lemon))";
		list.insert(testData1);
		
		System.out.println("Setq y'(a (b c))");
		String testData2 = "y'(a (b c))";
		 list.insert(testData2);
		 
		System.out.println("Setq xy'(m n o p)");
		String testData3 = "xy'(m n o p)";
		list.insert(testData3);
		
		System.out.println("Setq z'(((((b)))))");
		String testData4 = "z'(((((b)))))";	  
	    list.insert(testData4);

	    System.out.println(" ");
	    System.out.println("print");
	    list.displayEveryThing();
	    System.out.println(" ");
	    
	    System.out.println("print x");
	    list.display("x"); 	
	    System.out.println("print y");
	    list.display("y"); 	
	    System.out.println("print xy");
	    list.display("xy"); 	
	    System.out.println("print z");
	    list.display("z"); 	
		 
	    System.out.println(" ");
	       System.out.println("setq e  x");
		   list.makeCopy("e", "z");
		   System.out.println("print e");
		   list.display("e"); 
		
		  System.out.println(" ");
		  System.out.println("setq x nil");
		  list.delete("x");
		  System.out.println("setq y nil");
		  list.delete("y");
		  System.out.println("setq xy nil");
		  list.delete("xy");
		  System.out.println("setq z nil");
		  list.delete("z");
		  
		  System.out.println("");
		  System.out.println("print");
		  list.displayEveryThing();
		  System.out.println("setq e nil");
		  list.delete("e");
		}else{
			System.out.println("In valid input choice!");
		}

	}

}
