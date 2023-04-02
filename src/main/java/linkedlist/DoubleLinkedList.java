package linkedlist;

public class DoubleLinkedList {

	private DoubleLinkedNode head;	
	
	public void insertAtHead(int data) {
		DoubleLinkedNode n = new DoubleLinkedNode(data);
		n.setNext(this.head);
		
		if (this.head != null)
			this.head.setPrevious(n);
		
		this.head = n;		
	}
	
	public String toString() {
		String result = "{";
		DoubleLinkedNode current = this.head;
		while (current != null) {
			result += current.toString() + ",";
			current = current.getNext();
		}
		result = result.substring(0, result.length() - 1);
		return result + " }";
	}
}
