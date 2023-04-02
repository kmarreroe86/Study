package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println(list);

	}

}
