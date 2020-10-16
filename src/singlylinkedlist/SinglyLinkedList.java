package singlylinkedlist;


public class SinglyLinkedList<T> {

	private Node<T> head = null;
	private int size =0;

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	// Return whether the list is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	// Return the size of the list
	public int size() {
		return size;
	}

	// Add an element to the beginning of the list
	public void addFirst(T elem) {
		Node<T> newNode;
		if (head == null) {
			head = new Node<T>(elem, null);
		} else {
			newNode = new Node<T>(elem, null);
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	// Add an element to the end of the list
	public void addLast(T elem) {
		if (head == null) {
			head = new Node<T>(elem, null);
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node<T>(elem, null);
		size++;
	}

	// Add an element to a specific location in the list
	public void addSpecific(T elem, int index) {
		Node<T> newNode = new Node<>(elem, null);
		int ind = 0;
		if (head == null) {
			head = new Node<T>(elem, null);
		} 
		if (index == 0) {
			addFirst(elem);
		} else if (index >= size()) {
			throw new RuntimeException("Invalid index. Index is larger than list.");
		}
		Node<T> current = head;
		while (current.next != null) {
			if (ind + 1 == index) {
				newNode.next = current.next;
				current.next = newNode;
			}
			current = current.next;
			ind++;
		}
		size++;
	}

	// Remove the first element of the list
	public T removeFirst() {
		if (head == null) {
			throw new RuntimeException("List is empty. Nothing to remove.");
		}
		T data = head.data;
		head = head.next;
		--size;
		return data;
	}

	// Remove the last element of the list
	public T removeLast() {
		if (head == null) {
			throw new RuntimeException("List is empty. Nothing to remove.");
		}
		Node<T> current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		T data = current.next.data;
		current.next = null;
		--size;
		return data;
	}

	// Remove a specific element from the list
	public T removeSpecific(T elem) {
		if (head == null) {
			throw new RuntimeException("List is empty. Nothing to remove.");
		} else if (head.data == elem) {
			head = head.next;
		}
		Node<T> current = head;
		while (current.next != null) {
			if (current.next.data.equals(elem)) {
				current.next = current.next.next;
			}
			current = current.next;
		}
		--size;
		return elem;
	}
	
	public static <T> Node reverseList(Node<T> head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node<T> reversedList = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reversedList;
	}

	// Return the first element of the list
	public Node<T> peekFirst() {
		if (head == null) {
			throw new RuntimeException("Nothing to return. List is empty.");
		}
		return head;
	}

	// Return the last element of the list
	public Node<T> peekLast() {
		if (head == null) {
			throw new RuntimeException("Nothing to return. List is empty.");
		}
		Node<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	public Node<T> poll() {
		if(head == null) {
			throw new RuntimeException("Nothing to return. List is empty.");
		}
		Node<T> current = head;
		head = head.next;
		
		return current;
	}

	// Return whether the list contains a specific element
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	// Return the index of a specific element in the list
	public int indexOf(Object obj) {
		int index = 0;
		Node<T> current = head;

		if (obj == null) {
			for (; current != null; current = current.next, index++) {
				if (current.data == null)
					return index;
			}
		} else
			for (; current != null; current = current.next, index++) {
				if (obj.equals(current.data)) {
					return index;
				}
			}
		return -1;
	}
	// Format toString for printing
	public String toString() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println("" + temp.getData());
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("List!");
		list.addFirst("Goodbye");
		list.addFirst("Hello");
		list.toString();
		System.out.println();
		list.addLast("Last");
		list.addLast("Last2");
		list.toString();
		System.out.println();
		list.removeFirst();
		list.removeLast();
		list.toString();
		System.out.println();
		//list.removeSpecific("Goodbye");
		list.addSpecific("TEST!", 2);
		list.toString();
		System.out.println();
		list.toString();
	}
}
