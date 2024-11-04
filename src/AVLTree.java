import java.lang.Math;

public class AVLTree{
	int nodes = 0;

	/*node class that holds the nodes and avl tree*/
    class Node {
        int key;
        Node left, right;
        int height;
        String title;
        public long time;
        
        //constructor method needed when creating a node//
        Node(int key, String title) {
            this.key = key;
            this.title = title;
            this.time = System.currentTimeMillis();
        }
    }

    private Node root;
    
	/*method that finds the height of a node, returns -1 if the node is null and uses the built in .height command 
	for existing nodes*/
	public int height(Node x) {
		return x != null ? x.height : -1;
	}
	
	/* method used for updating height of the avl tree, no return value since all it does is update existing
	 values*/
	public void updateHeight(Node x) {
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
	public Node rightRotation(Node x) {
		Node leftChild = x.left;
		Node nodeTemp = leftChild.right;
		leftChild.right = x;
		x.left = nodeTemp;
		updateHeight(x);
		updateHeight(leftChild);
		return leftChild;
	}
	/*method used for left rotations*/
	public Node leftRotation(Node x) {
		Node rightChild = x.right;
		Node nodeTemp = rightChild.left;
		rightChild.left = x;
		x.right = nodeTemp;
		updateHeight(x);
		updateHeight(rightChild);
		return rightChild;
	}
	/*method used to get the balance factor of a node*/
	public int getBalance(Node x) {
		if (x == null) {
			return 0;
		}
		return height(x.left) - height(x.right); //subtracts the height of the left subtree from the right to get bf
	}
	
	/*method used for balancing of the avl tree*/
	public Node rebalance(Node x) {
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
	
	/*helper method*/
	public void addOrder(int key, String title) {
		root = addOrder(root, key, title);
	}
	
	/*method used for adding an order to the avl tree*/
    public Node addOrder(Node node, int key, String title) {
        if (node == null) {		//if a node does exist create a new one with the given parameters
        	nodes++;
        	return new Node(key, title);
        }
        if (key < node.key) {
            node.left = addOrder(node.left, key, title);
        } else if (key > node.key) {
            node.right = addOrder(node.right, key, title);
        } else {
            return node;
        }
        updateHeight(node);
        System.out.println("Tree height after addition: " + root.height);
        return node;
        }
	
    /*helper method*/
    public void removeOrder(int key) {
        root = removeOrder(root, key);
    }
    
    /*method used for removing an order from the avl tree*/
    private Node removeOrder(Node node, int key) {
        if (node == null) {
            return null;
        }
        // Standard BST delete operation
        if (key < node.key) {
            node.left = removeOrder(node.left, key);
        } else if (key > node.key) {
            node.right = removeOrder(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
            	nodes--;
                return node.right;
            } else if (node.right == null) {
            	nodes--;
                return node.left;
            }
            Node temp = getMinValueNode(node.right);	//If a node has two children, then get the left child to follow in-order traversal//
            node.key = temp.key;
            node.right = removeOrder(node.right, temp.key);
        }
        updateHeight(node);
        System.out.println("Tree height after removal: " + (root != null ? root.height : 0));
        return rebalance(node);
    }

    /*helper method for removeOrder that gets the smaller value node*/
    private Node getMinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public void printTree() {
    	printTree(root);
    }
    
	/*method that prints the tree using in-order traversal*/
    public void printTree(Node x) {
        if (x != null) {
            printTree(x.left);
            System.out.print(x.title + ": ");
            System.out.println(x.key);
            printTree(x.right);
        }
    }
	
    /*helper method*/
    public String findOrder(int key) {
    	String result = findOrder(root, key);
    	return result;
    }
    
	public String findOrder(Node node, int key) {
	    if (node == null) {
	        return null;
	    }
	    // Traverse the tree
	    if (key < node.key) {
	        return findOrder(node.left, key); // Go left if the key is smaller
	    } else if (key > node.key) {
	        return findOrder(node.right, key); // Go right if the key is larger
	    } else {
	        return node.title; // Key found
	    }
	}
	
	public void findOldest() {
		findOldest(root);
	}
	public Node findOldest(Node root) {  
		Node oldest = root;
		if (oldest.left != null) {
			Node leftOldest = findOldest(oldest.left);
			if (leftOldest.time < oldest.time) {
				oldest = leftOldest;
			}
		}
		if (oldest.right != null) {
			Node rightOldest = findOldest(oldest.right);
			if (rightOldest.time < oldest.time) {
				oldest = rightOldest;
			}
		}
		System.out.println(oldest.title + ": " + oldest.key);
		return oldest;
	}
	
	public void findLatest() {
		findLatest(root);
	}
	
	public Node findLatest(Node root) {
		Node latest = root;
		if(latest.left != null) {
			Node leftLatest = findLatest(latest.left);
			if (leftLatest.time > latest.time) {
				latest = leftLatest;
		}
	}
		if (latest.right != null) {
			Node rightLatest = findLatest(latest.right);
			if (rightLatest.time > latest.time) {
				latest = rightLatest;
			}
		}
		System.out.println(latest.title + ": " + latest.key);
		return latest;
	}
	
	public int getNodes() {
		return nodes;
	}
}
