/**This is the Stack Class 
 *
 *The Stack is a generic because 
 * I used this stack in my program 
 * for Nodes and Strings
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */

//Generic Stack
public class Stack<E> {
	
	int maxSize;
	int top;
	public E arr[];
	
	public Stack(int size){
		maxSize = size; 
		arr = (E[]) new Object [maxSize]; //casting generic 
		top = 0;
	}
	
	/**
	 * 
	 * Method for checking if the stack is empty
	 * 
	 * */
	
	public boolean empty(){
		if(top == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Method for adding data on the stack
	 * checking if the stack is not full
	 **/
	
	public void push(E data){
		if(top < maxSize){
		arr[top] = data;
		top++;
		}else{
			System.out.println("Stack Overflow!");
		}
	}
	
	/**
	 * Method for removing the top data off the stack
	 * checking if the stack is not empty
	 * */
	
	public E pop(){
		if(!this.empty()){
		E temp = (E) this.peek();
		arr[top-1] = null;
		top--;
		return temp;
		}else{
			return null;
		}
	}
	
	/**
	 * Method for looking for data on top of the  stack
	 * checking if the stack is not empty
	 * */
	public E peek(){
		if(!this.empty()){ //if the top is not empty!
		return  arr[top-1];
		}else{
			return null; 
		}
	}

}
