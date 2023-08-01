package LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        ReverseLinkedListFunc(head);

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void ReverseLinkedListFunc(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}


class Node {
    int value;

    Node next;

    Node random;

    public Node(int value) {
        this.value = value;
    }
}
