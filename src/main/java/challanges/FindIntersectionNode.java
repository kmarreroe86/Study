package challanges;

public class FindIntersectionNode {

    public int getIntersectionNode(LinkedList.Node headA, LinkedList.Node headB) {
        LinkedList.Node pA = headA;
        LinkedList.Node pB = headB;
        while (pA.data != pB.data) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA.data;
    }



    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        // creating first linked list
        list.head1 = new LinkedList.Node(3);
        list.head1.next = new LinkedList.Node(15);
        list.head1.next.next = new LinkedList.Node(9);
        list.head1.next.next.next = new LinkedList.Node(6);
        list.head1.next.next.next.next = new LinkedList.Node(30);

        // creating second linked list
        list.head2 = new LinkedList.Node(10);
        list.head2.next = new LinkedList.Node(16);
        list.head2.next.next = new LinkedList.Node(30);

        var kaka = new FindIntersectionNode();
        System.out.println("The node of intersection is " + kaka.getIntersectionNode(list.head1, list.head2));
    }
}

class LinkedList {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}


