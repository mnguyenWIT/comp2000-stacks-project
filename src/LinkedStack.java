
public class LinkedStack<T> implements StackInterface<T> {
	private class Node {
		private T data;
		private Node next;
		
		public Node() {
			this(null);
		}
		public Node (T anEntry) {
			data = anEntry;
			next = null;
		}
		public void setData(T dataPortion) {
			data = dataPortion;
		}
		public T getData() {
			return data;
		}
		public void setNext(Node nextNode) {
			next = nextNode;
		}
		public Node getNext() {
			return next;
		}
	}
	private Node firstNode;
	public LinkedStack() {
		firstNode = null;
	}
	public void push(T anEntry) {
		Node dataNode = new Node(anEntry);
		dataNode.setNext(firstNode);
		firstNode = dataNode;
	}
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = firstNode.getData();
		firstNode = firstNode.getNext();
		return outData;
	}
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return firstNode.getData();
	}
	public boolean isEmpty() {
		return (firstNode == null);
	}
	public void clear() {
		firstNode = null;
	}
	public T peek2() {
		if (firstNode.getNext()==null) {
			throw new EmptyStackException();
		}
		return firstNode.getNext().getData();
	}
}
