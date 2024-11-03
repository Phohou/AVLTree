import java.lang.Math;

public class AVLTree{
	public int key;
	public AVLTree left;
	public AVLTree right;
	public int height;
	public String title;

	public AVLTree() {
		  int key;
		  AVLTree left;
		  AVLTree right;
		  int height;
		  String title;

		  
		}

		public AVLTree(int key) {
		    this.key = key;
		  }

	public int height(AVLTree x) {
		return x != null ? x.height : -1;
	}
	
	public void updateHeight(AVLTree x) {
		int leftChildHeight;
		int rightChildHeight;
		if (x.left == null) {
			leftChildHeight = 0;
			
		}
		if(x.right == null) {
			rightChildHeight = 0;
		}
		leftChildHeight = height(x.left);
		rightChildHeight = height(x.right);
		x.height = Math.max(leftChildHeight, rightChildHeight)+1;
	}
	
	public AVLTree rightRotation(AVLTree x) {
		AVLTree leftChild = x.left;
		AVLTree nodeTemp = leftChild.right;
		leftChild.right = x;
		x.left = nodeTemp;
		updateHeight(x);
		updateHeight(leftChild);
		return leftChild;
	}
	
	public AVLTree leftRotation(AVLTree x) {
		AVLTree rightChild = x.right;
		AVLTree nodeTemp = rightChild.left;
		rightChild.left = x;
		x.right = nodeTemp;
		updateHeight(x);
		updateHeight(rightChild);
		return rightChild;
	}
	
	public int getBalance(AVLTree x) {
		if (x == null) {
			return 0;
		}
		return height(x.left) - height(x.right);
	}
	
	public AVLTree rebalance(AVLTree x) {
		int balanceFactor = getBalance(x);
		  if (balanceFactor < -1) {
		    if (getBalance(x.left) <= 0) {    
		      x = rightRotation(x);
		    } else {                                
		      x.left = leftRotation(x.left);
		      x = rightRotation(x);
		    }
		  }


		  if (balanceFactor > 1) {
		    if (getBalance(x.right) >= 0) {    
		      x = leftRotation(x);
		    } else {                                 
		      x.right = rightRotation(x.right);
		      x = leftRotation(x);
		    }
		  }
		  return x;
	}
	
	public AVLTree addOrder(AVLTree x, int key, String title) {
		x = addOrder(x, key, title);
		updateHeight(x);
		return rebalance(x);
    }
	
	public AVLTree removeOrder(AVLTree x, int key) {
		x = removeOrder(x, key);
		if (x == null) {
			return x;
		}
		updateHeight(x);
		return rebalance(x);
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
	
	public AVLTree findOldest() {
		
	}
	
	public findLatest() {
		
	}
}
