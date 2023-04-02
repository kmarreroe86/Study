package hackerrank;

public class SinglyLinkedListNode {

	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public String toString() {	
		return "data: " + data + " ";
	}

}
