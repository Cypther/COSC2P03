/**This is the Node Class 
 * 
 * Node fields has Leftchild, rightChild pointer
 * the field key is at as a string
 * 
 * The boolean fields leftThread and rightThread
 * gets used by the Threaded Binary Tree class.
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */

public class Node {
	
	public Node leftChild;
	public Node rightChild;
	private String key;
	//public String key;
	public int count = 1;//counting duplicate values 
	
	boolean leftThread;
	boolean rightThread;
	
	/*Constructor*/
	public Node(){
		leftChild = null;
		rightChild = null;
		key = "";
	}
	/*Constructor*/
	public Node(String value){
		leftChild = null;
		rightChild = null;
		this.key = value;
	}
	
	/*method to get the get*/
	public void setData(String value){
		this.key = value;
	}
	/*method to return the key value*/
	public String getData(){
		return key;
	}

}
