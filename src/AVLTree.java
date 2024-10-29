import java.lang.Math;

public class AVLTree extends BookOrder{
	
	public class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public int height(Node x) {
		return x != null ? x.height : -1;
	}
	
	public void updateHeight(Node x) {
		int leftChildHeight = height(x.left);
		int rightChildHeight = height(x.right);
		x.height = Math.max(leftChildHeight, rightChildHeight) +1;
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
	
	public void addOrder() {
		
	}
	
	public void removeOrder() {
		
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
