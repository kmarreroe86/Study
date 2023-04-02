package linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addAtHead(5);
		list.addAtHead(10);
		list.addAtHead(2);
		list.addAtHead(12);
		list.addAtHead(19);
		list.addAtHead(20);

		System.out.println(list.toString());
		System.out.println("Length: " + list.length());

		System.out.println("\nAfter delete head:");
		list.deleteHead();
		System.out.println(list.toString());
		System.out.println("Length: " + list.length());
		
		System.out.println("\nFind element(2)");
		Node el = list.find(2);
		System.out.println("Found " + el);
		
		System.out.println("-------------------------------");
		System.out.println("\nInserting in sorted list");
		
		LinkedList list2 = new LinkedList();		
		list2.addAtHead(20);
		list2.addAtHead(19);		
		list2.addAtHead(12);
		list2.addAtHead(10);
		list2.addAtHead(5);
		list2.addAtHead(2);
		System.out.println(list2.toString());
		
		list2.insertInSortedList(1);
		list2.insertInSortedList(21);
		list2.insertInSortedList(15);		
		System.out.println(list2.toString());
		

	}

}
