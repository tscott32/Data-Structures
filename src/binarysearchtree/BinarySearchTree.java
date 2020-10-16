package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node root = null;
	private int treeSize = 0;

	// Create an empty BST
	public BinarySearchTree() {
		root = null;
	}

	// Create a BST with the root node
	public BinarySearchTree(Node root) {
		this.root = root;
	}

	private class Node {
		private T data;
		private Node left, right;

		public Node(Node left, Node right, T data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}

	// Return the size/number of element in the tree
	public int size() {
		return treeSize;
	}

	// Check if the tree is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	// Add an element to the tree
	public void add(T elem) {
		root = add(root, elem);
	}

	// Recursive helper to add element to the tree
	public Node add(Node node, T elem) {
		if (node == null) {
			node = new Node(null, null, elem);
		} else {
			if (elem.compareTo(node.data) < 0) {
				node.left = add(node.left, elem);
			} else {
				node.right = add(node.right, elem);
			}
		}
		treeSize++;
		return node;
	}

	// Remove an element from the tree
	public boolean remove(T elem) {
		if (contains(elem)) {
			root = remove(root, elem);
			--treeSize;
			return true;
		}
		return false;
	}

	// Recursive helper to remove an element from the tree
	public Node remove(Node node, T elem) {
		if (node == null) {
			return null;
		}

		int compare = elem.compareTo(node.data);

		if (compare < 0) {
			node.left = remove(node.left, elem);
		} else if (compare > 0) {
			node.right = remove(node.right, elem);
		} else {
			if (node.left == null) {
				Node rightChild = node.right;
				node.data = null;
				node = null;
				return rightChild;
			} else if (node.right == null) {
				Node leftChild = node.left;
				node.data = null;
				node = null;
				return leftChild;
			} else {
				Node temp = findMin(node.right);
				node.data = temp.data;
				node.right = remove(node.right, temp.data);
			}
		}
		treeSize--;
		return node;
	}

	// Check if the tree contains a specific element
	public boolean contains(T elem) {
		return contains(root, elem);
	}

	// Recursive helper to find an element in the tre
	public boolean contains(Node node, T elem) {
		if (node == null) {
			return false;
		}
		if (elem.compareTo(node.data) < 0) {
			return contains(node.left, elem);
		} else if (elem.compareTo(node.data) > 0)
			return contains(node.right, elem);
		else
			return true;
	}

	// Compute the height of the tree
	public int height() {
		return height(root);
	}

	// Recursive helper to computer the height of the tree
	public int height(Node node) {
		if (root != null) {
			return Math.max(height(node.left), height(node.right) + 1);
		} else
			return 0;
	}

	// Find the leftmost or minimum value in the tree
	public Node findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	// Find the rightmost or maximum value in the tree
	public Node findMax(Node node) {
		while (node.right != null)
			node = node.right;
		return node;
	}

	public int isSubTree(Node root1, Node root2) {
		if (root1 == null)
			return -1;
		if (root2 == null)
			return 1;
		if(checkIfEqual(root1, root2))
			return 1;
		if (isSubTree(root1.left, root2) == 1 || isSubTree(root1.right, root2) == 1)
			return 1;
		return -1;
	}
	
	public boolean checkIfEqual(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data &&	
				checkIfEqual(root1.left, root2.left) && 
				checkIfEqual(root1.right, root2.right));
	}
	
    public String toString() {
	return toString(root);
    }

    protected String toString(Node node) {
	if (node == null) {
	    return "";
	}
	return node.data.toString() + "(" + toString(node.left) + ", " +
	    toString(node.right) + ")";
    }
    
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		bst.add(4);
		bst.add(5);
		bst.add(1);
		bst2.add(4);
		bst2.add(5);
		bst2.add(1);
		bst.add(10);
		bst.add(9);
		System.out.println(test.isSubTree(bst.root, bst2.root));
		System.out.println("BST1: " + bst.toString());
		System.out.println("BST2: " + bst2.toString());
	}
	
}
