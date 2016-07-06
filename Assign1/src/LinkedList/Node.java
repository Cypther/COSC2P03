/** This is the Node class, the fields are Strings, to hold the data value
 *  Node.next to point to the next node
 *  Node.down to point to the down node
 *  
 * @author Long Nguyen
 *
 *@version 1.0 (September 2014)
 *Compiler Version,Java 1.6
 */               

package LinkedList;


public class Node {
	
	/**
	 * Node attribute
	 * */
	
	public String element;
	public Node nextLink;  //pointing to next Node
	public Node downLink; //pointing down
	
	//constructor 
	public Node (String element){
		this.element  = element;
	}
	
	public void display(){
		System.out.println(element);
	}
	
	public String toString(){
		return element;
	}

}
