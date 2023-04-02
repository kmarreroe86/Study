package linkedlist;

public class DoubleLinkedNode {

	private int data;
	
	private DoubleLinkedNode next;
	
	private DoubleLinkedNode previous;
	
	
	public DoubleLinkedNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleLinkedNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedNode next) {
		this.next = next;
	}

	public DoubleLinkedNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedNode previous) {
		this.previous = previous;
	}
	
	public String toString() {
		return " Data: " + this.data;
	}
}
