/**This is the Binary Search Tree Class 
 * 
 * It has the method to add  elements to a node 
 * Methods to Traverse through the tree by 
 * preOrder, inOrder postOrder recursively.
 * 
 * It also has the method for inOrderTraversa with a Stack
 * traversing iterative using a while loop
 * 
 * 
 * @author Long Nguyen
 * 
 * @version 1.0 (October 2014)
 * Compiler Version Java 1.7
 */

public class BinarySearchTree {
	public Node root;
	
	/*Constructor*/
	public BinarySearchTree(){
		root = null;
	}
	
	public String visit(){
		return root.getData();
	}
	public void add(String value){
		root = insert(root, value);
	}
	
	//Adding values into the node
	private Node insert(Node root, String value){
		if(root == null){
			root = new Node(value);
			//comparing it by ASCII Table values
			
		}else if(root.getData().compareTo(value) ==  0){//greater than
			          root.count++;//counting duplicate values 
		}else if(root.getData().compareTo(value) > 0){//greater than
			root.leftChild = insert(root.leftChild, value);
		}else if(root.getData().compareTo(value) < 0){ //less than
			root.rightChild = insert(root.rightChild, value);
		}
		return root;
	}
	
	/**PreOrder: 
	 * 
	 * 1. Visit the root
	 * 2. Traverse the left subtree
	 * 3. Traverse the right subtree
	 * */
	public static void preOrderTraversal(Node root){
		if(root == null){
			return;
		}
		//System.out.print(root.getData() + ",  ");
		System.out.print(root.getData() + " : " + root.count + ",  ");
		preOrderTraversal(root.leftChild);
		preOrderTraversal(root.rightChild);
	}
	
	/**inOrder: 
	 * 
	 * 1. Traverse the left subtree
	 * 2. Visit the root	 * 
	 * 3. Traverse the right subtree
	 * */
	
	public static void inOrderTraversal(Node root){
		if(root == null){
			return;
		}
		inOrderTraversal(root.leftChild);
		//System.out.print(root.getData() + ",  ");
		System.out.print(root.getData() + " : " + root.count + ",  ");
		inOrderTraversal(root.rightChild);
	}
	
	/**inOrder:  Using Stack to hold the data
	 * 
	 * 1. Traverse the left subtree
	 * 2. Visit the root	 * 
	 * 3. Traverse the right subtree
	 * */
	
	public static Stack inOrderTraversaStack(Node root, Stack myStack){
	
		Node node = root;
		Stack<Node> treeStack = new Stack<Node>(myStack.maxSize);

		if(node == null){
			myStack = null;
			return myStack;
		}
		while(!treeStack.empty() || node != null){
			if(node != null){
				treeStack.push(node);
				node = node.leftChild;
			}else{
				 node =  treeStack.pop();
				 myStack.push(node.getData());
				 //System.out.println(node.getData());
                 node = node.rightChild;
			}
		}
		return myStack;
		
		
		
		/*	if(root == null){
			myStack = null;
			return myStack;
		}
		inOrderTraversaStack(root.leftChild, myStack);
		myStack.push(root.getData());
		inOrderTraversaStack(root.rightChild,myStack);
		return myStack;*/
	}
	
	
	/**PostOrder: 
	 * 
	 * 1. Traverse the left subtree
	 * 2. Traverse the right subtree
	 * 3. Visit the root	
	 * */
	
	public static void postOrderTraversal(Node root){
		if(root == null){
			return;
		}
		postOrderTraversal(root.leftChild);
		postOrderTraversal(root.rightChild);
		//System.out.print(root.getData() + ",  ");
		System.out.print(root.getData() + " : " + root.count + ",  ");
	}

}
