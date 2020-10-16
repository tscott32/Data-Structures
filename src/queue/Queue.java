package queue;

public class Queue<T> {
	private java.util.LinkedList<T> list = new java.util.LinkedList<T>();
	
	// Create an empty queue
	public Queue() {}

	// Create a queue with the first element
	public Queue(T firstElem) {
		offer(firstElem);
	}
	
	// Return the size/number of elements in the queue
	public int size() {
		return list.size();
	}
	
	// Check if queue is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	// Return the element at the front of the queue
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Nothing to return. Queue is empty.");
		return list.peek();
	}
	
	// Return the element at the back of the queue
	public T poll() {
		if (isEmpty())
			throw new RuntimeException("Nothing to return. Queue is empty.");
		return list.poll();
	}
	
	// Add and element to the back of the queue
	public void offer(T elem) {
		list.addLast(elem);
	}
}
