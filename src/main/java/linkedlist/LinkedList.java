package linkedlist;

public class LinkedList {

	private Node head;

	public void addAtHead(int data) {
		Node newNode = new Node(data, null);
		newNode.setNext(head);
		this.head = newNode;
	}

	public int length() {
		int len = 0;
		Node current = this.head;
		while (current != null) {
			len++;
			current = current.getNext();
		}

		return len;
	}

	public void deleteHead() {
		this.head = this.head.getNext();
	}

	public Node find(int element) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == element)
				return current;
			current = current.getNext();
		}
		
		return null;
	}
	
	public void insertInSortedList(int data) {
		Node n = new Node(data, null);
		
		if (this.head == null) {
			this.head = n;
			return;
		}
		
		if (this.head.getData() >= n.getData()) {
			n.setNext(this.head);
			this.head = n;
			return;
		}
		
		Node current = this.head;
		while(current.getNext() != null) {
			if (current.getNext().getData() > n.getData()) {
				n.setNext(current.getNext());
				current.setNext(n);
				return;
			} else {
				current = current.getNext();
			}
		}
		
		current.setNext(n);
	}

	public Node getHead() {
		return head;
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
