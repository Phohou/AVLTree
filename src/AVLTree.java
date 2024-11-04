import java.lang.Math;

public class AVLTree{
	public int key;
	public AVLTree left;
	public AVLTree right;
	public int height;
	public String title;

	//class that sets up and holds the avl tree//
	public AVLTree() {
		  int key;
		  AVLTree left;
		  AVLTree right;
		  int height;
		  String title;
		}
	//constructor for when making a node with a key
		public AVLTree(int key) {
		    this.key = key;
		  }
	/*method that finds the height of a node, returns -1 if the node is null and uses the built in .height command 
	for existing nodes*/
	public int height(AVLTree x) {
		return x != null ? x.height : -1;
	}
	
	/* method used for updating height of the avl tree, no return value since all it does is update existing
	 values*/
	public void updateHeight(AVLTree x) {
		int leftChildHeight;
		int rightChildHeight;
		if (x.left == null) {
			leftChildHeight = 0;
			
		}
		if(x.right == null) {
			rightChildHeight = 0;
		}
		leftChildHeight = height(x.left); //sets the left tree height
		rightChildHeight = height(x.right); //sets the right tree height
		x.height = Math.max(leftChildHeight, rightChildHeight)+1; /*returns the higher value of either the 
												left or right subtree and adds 1 to account for the root*/
	}
	
	/* method used for right rotations*/
	public AVLTree rightRotation(AVLTree x) {
		AVLTree leftChild = x.left;
		AVLTree nodeTemp = leftChild.right;
		leftChild.right = x;
		x.left = nodeTemp;
		updateHeight(x);
		updateHeight(leftChild);
		return leftChild;
	}
	/*method used for left rotations*/
	public AVLTree leftRotation(AVLTree x) {
		AVLTree rightChild = x.right;
		AVLTree nodeTemp = rightChild.left;
		rightChild.left = x;
		x.right = nodeTemp;
		updateHeight(x);
		updateHeight(rightChild);
		return rightChild;
	}
	/*method used to get the balance factor of a node*/
	public int getBalance(AVLTree x) {
		if (x == null) {
			return 0;
		}
		return height(x.left) - height(x.right); //subtracts the height of the left subtree from the right to get bf
	}
	
	/*method used for balancing of the avl tree*/
	public AVLTree rebalance(AVLTree x) {
		int balanceFactor = getBalance(x);
		  if (balanceFactor < -1) {  // >-1 balance factor calls for a rotation and tells us the tree is left heavy
		    if (getBalance(x.left) <= 0) {    //if left side is balanced rotation right
		      x = rightRotation(x);
		    } else {                          //otherwise do a left right rotation
		      x.left = leftRotation(x.left);
		      x = rightRotation(x);
		    }
		  }


		  if (balanceFactor > 1) {  // <1 balance factor calls for a rotation and tells us the tree is right heavy
		    if (getBalance(x.right) >= 0) {    //if right side is balanced rotate left
		      x = leftRotation(x);
		    } else {                                 //otherwise do a right left rotation
		      x.right = rightRotation(x.right);
		      x = leftRotation(x);
		    }
		  }
		  return x;
	}
	
	/*method used for adding an order to the avl tree*/
	public AVLTree addOrder(AVLTree x, int key, String title) {
		x = addOrder(x, key, title); //creates a new node with the parameters
		updateHeight(x); //updates the height of the tree
		return rebalance(x); //rebalances the tree with the new given node
    }
	
	/*method used for removing an order from the tree*/
	public AVLTree removeOrder(AVLTree x, int key) {
		x = removeOrder(x, key); //creates a node with the given
		if (x == null) {  //if the node doesn't exist 
			return x;
		}
		updateHeight(x);  //updates the height of the tree
		return rebalance(x); //rebalances the tree
	}
	
	public void printTree(AVLTree x) {
		if (x == null) {
			return;
		}
		printTree(x.left);
		printTree(x);
	    printTree(x.right);
	}
	
	public int findOrder(int key) {
		return key;
	}
	
	public AVLTree findOldest(AVLTree x) {
		return x;
	}
	
	public AVLTree findLatest(AVLTree x) {
		return x;
	}
}
