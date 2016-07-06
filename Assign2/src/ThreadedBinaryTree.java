/**This is the ThreadedBinaryTree Class 
 *
 *It has the insert method
 *The method thread the tree as it inserts
 *
 *There are two display methods in ThreadedBinaryTree
 *
 *one uses recursion and the other does it with a while loop
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */


public class ThreadedBinaryTree {
	
	public Node root;
  
    /*Default Constructor*/
    public ThreadedBinaryTree () {
        root = new Node();
        root.rightChild  = root;
        root.leftChild = root;
        root.leftThread = true;
        root.setData("~"); //highest value of the ascii table
    }
    
    /**
     * Method to insert data in the 
     * Threaded Binary Tree, the method 
     * 
     * */
    
    public void insert(String key) {
        Node node = root;
        //System.out.println(p.key.compareTo(key));
        
        
        //Threading if the node has null pointers
        //loop infinitely until it hits a break
        while(true) {
            if (node.getData().compareTo(key) < 0) {
                if (node.rightThread){ //if the right is threaded break
                	break;
                }
                node = node.rightChild;
            } else if (node.getData().compareTo(key) > 0) {
                if (node.leftThread) { //if the right is threaded == true break
                	break;
                }
                node = node.leftChild; //if the left is threaded == true break
            } else {
            	node.count++; //counting duplicate values redundant key
                return;
            }
        }
        
        Node tempNode = new Node();
        tempNode.setData(key);
        tempNode.rightThread = true;
        tempNode.leftThread = true;
        
        if (node.getData().compareTo(key) < 0) { // insert to right side
            tempNode.rightChild = node.rightChild;
            tempNode.leftChild = node;
            node.rightChild = tempNode;
            node.rightThread = false;
        } else {
            tempNode.rightChild = node;
            tempNode.leftChild = node.leftChild;
            node.leftChild = tempNode;
            node.leftThread = false;
        }
    }
    
    
    /**Displaying the Threaded tree
     * Using recursion, in-order output
     * 
     * */
    
    public void printTree() {
        Node tempNode = root.leftChild;
        if (tempNode == root) 
        	return;
        print(tempNode);
        System.out.println(" ");
    }
    /*A Recursive In-Order Traversal.*/
    private void print(Node tempNode) {
        
        if (!tempNode.leftThread) 
        	print(tempNode.leftChild);
        
        //Printing out the keys and how many duplicate
        System.out.print(" "+tempNode.getData() + " : " + tempNode.count + ", ");
        
        if (!tempNode.rightThread) 
        	print(tempNode.rightChild);
        
    }
    
    
    /**Displaying the tree
     * 
     * iterative with a while loop
     * 
     * */
    public void displayTree() {
        Node tempNode = root;
        Node perviousNode = root;
        
        while(true) {
        	perviousNode = tempNode;
            tempNode = tempNode.rightChild;
            if (!perviousNode.rightThread) {
                while (!tempNode.leftThread) {
                    tempNode = tempNode.leftChild;
                }
            }
            if (tempNode == root) break;
            System.out.print(tempNode.getData()+" " + " : " + tempNode.count + ", ");
        }
        System.out.println();
    }
}