/**This is the Node Class 
 * 
 * Node fields has Leftchild, rightChild pointer
 * the field key is at as a string
 * 
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (November 2014)
 * Compiler Version Java 1.7
 */


public class Node
{

	//Class fields
    private String key;          // The data in the node
    private Node leftChild;         // Left child
    private Node rightChild;        // Right child
    private int duplicateCounter; //counting duplicate values 
    
    // constructor
    Node(String theKey) {
        this.key = theKey;
        this.leftChild = null;
        this.rightChild = null;
        this.duplicateCounter = 1;
    }
    
    //getters
    public String getKey(){
        return key;
    } 
    
    public Node getRightChild(){
        return rightChild;
    }
    
    public Node getLeftChild(){
        return leftChild;
    }
    
    public int getDuplicate(){
        return duplicateCounter;
    }
    //setters
    
    public void setKey(String key){
        this.key = key;
    }
    
    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }
    
    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }
    public void duplicate(){ //counting duplicate values 
    	duplicateCounter++;
    }
    
    
}
