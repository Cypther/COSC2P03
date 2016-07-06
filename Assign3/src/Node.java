/**This is the Node Class 
 * 
 * Node fields has Leftchild, rightChild pointer
 * the field key is at as a string
 * 
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */

public class Node {
    
    private String key;
    private int duplicateCounter; //counting duplicate values 
    private Node rightChild;
    private Node leftChild;
    private int height;
    
    
    /*Default Constructor*/
    public Node(){
        key = null;
        duplicateCounter = 1;
        rightChild = null;
        leftChild = null;
        height = 0;
    }
    
    /*Overloaded constructor*/
    public Node(String key){
        this.key = key;
        duplicateCounter = 1;
        rightChild = null;
        leftChild = null;
        height = 0;
    }
    
    /*Setters and getters*/
    
    //getters
    
    /*method to return the key value*/
    public String getKey(){
        return key;
    }
    
    public int getDuplicate(){
        return duplicateCounter;
    }
    
    public Node getRightChild(){
        return rightChild;
    }
    
    public Node getLeftChild(){
        return leftChild;
    }
    
    public int getHeight(){
        return height;
    }
    /////setters 
    /*method to set the value*/
    public void setKey(String key){
        this.key = key;
    }
    
    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }
    
    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public void duplicate(){ //counting duplicate values 
    	duplicateCounter++;
    }
    public void setDuplicate(int duplicate){
        this.duplicateCounter = duplicate;
    }
}