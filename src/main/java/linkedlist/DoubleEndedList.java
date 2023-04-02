package linkedlist;

public class DoubleEndedList {

	private Node head;
	
	private Node tail;
	
	public void addAtLast(int data) {
		Node n = new Node(data, null);
		if (this.head == null) {
			this.head = n;
		}
		
		if (this.tail != null)
			this.tail.setNext(n);
		this.tail = n;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.toString() + ",";
			current = current.getNext();
		}
		result = result.substring(0, result.length() - 1);
		return result + " }";
	}
}
