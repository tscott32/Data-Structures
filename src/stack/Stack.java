package stack;

public class Stack<T> {
	private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

	// Create an empty stack
	public Stack() {}
	
	// Create a stack with the first element
	public Stack(T firstElem) {
		push(firstElem);
	}
	
	// Return the size/number of elements in the stack
	public int size() {
		return list.size();
	}
	
	// Check if the stack is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	// Add an element to the top of the stack
	public void push(T elem) {
		list.addLast(elem);
	}
	
	// Remove the element at the top of the stack
	public T pop() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.removeLast();
	}
	
	// Return the element at the top of the stack
	public T peek() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.peekLast();
	}

}
