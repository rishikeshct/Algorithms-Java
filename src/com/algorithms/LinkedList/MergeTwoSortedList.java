package LinkedList;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);


        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);

        MergeTwoSortedListFunc(head, head1);
    }

    private static void MergeTwoSortedListFunc(Node head, Node head1) {
        Node head2 =  null;
        Node first = null;
        while (head != null && head1 != null) {
            if (head.value <= head1.value) {
                if (head2 == null) {
                    head2 = new Node(head.value);
                    first = head2;
                } else  {
                    head2.next = new Node(head.value);
                    head2 = head2.next;
                }
                head = head.next;

            } else {
                if (head2 == null) {
                    head2 = new Node(head1.value);
                    first = head2;
                } else {
                    head2.next = new Node(head1.value);
                    head2 = head2.next;
                }
                head1 = head1.next;
            }
        }

        while (head != null) {
            head2.next = new Node(head.value);
            head = head.next;
            head2= head2.next;
        }
        while (head1 != null) {
            head2.next = new Node(head1.value);
            head1 = head1.next;
            head2= head2.next;
        }

        while (first != null) {
            System.out.println(first.value);
            first = first.next;
        }
    }
}
