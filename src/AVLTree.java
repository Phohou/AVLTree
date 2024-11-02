import java.lang.Math;

public class AVLTree extends BookOrder{
	
	public class Node{
		int key;
		Node left;
		Node right;
		int height;
		
		public Node(int data) {
			key = data;
		}
	}
	
	public int height(Node x) {
		return x != null ? x.height : -1;
	}
	
	public void updateHeight(Node x) {
		int leftChildHeight = height(x.left);
		int rightChildHeight = height(x.right);
		x.height = Math.max(leftChildHeight, rightChildHeight)+1;
	}
	
	public Node rightRotation(Node x) {
		Node leftChild = x.left;
		Node nodeTemp = leftChild.right;
		leftChild.right = x;
		x.left = nodeTemp;
		updateHeight(x);
		updateHeight(leftChild);
		return leftChild;
	}
	
	public Node leftRotation(Node x) {
		Node rightChild = x.right;
		Node nodeTemp = rightChild.left;
		rightChild.left = x;
		x.right = nodeTemp;
		updateHeight(x);
		updateHeight(rightChild);
		return rightChild;
	}
	
	public int getBalance(Node x) {
		if (x == null) {
			return 0;
		}
		return height(x.left) - height(x.right);
	}
	
	public Node rebalance(Node x) {
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
	
	public Node addOrder(Node x, int key) {
		x = addOrder(x, key);
		updateHeight(x);
		return rebalance(x);
    }
	
	public Node removeOrder(Node x, int key) {
		x = removeOrder(x, key);
		if (x == null) {
			return x;
		}
		updateHeight(x);
		return rebalance(x);
	}
	
	public Node printTree(Node x) {
		if (x == null) {
			return x;
		}
		printTree(x.left);
	    printTree(x.right);
	}
	
	public findOrder() {
		
	}
	
	public findOldest() {
		
	}
	
	public findLatest() {
		
	}
}
