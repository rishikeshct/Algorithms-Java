package LinkedList;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;
        RemoveNthFromEndFunc(head, n);
    }

    private static void RemoveNthFromEndFunc(Node head, int n) {

        Node p1 = head;

        while (n + 1> 0) {
            p1= p1.next;
            n = n - 1;
        }

        Node p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }


        p2.next =  p2.next.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
