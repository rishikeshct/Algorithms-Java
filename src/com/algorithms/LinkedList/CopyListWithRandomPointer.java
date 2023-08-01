package LinkedList;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        CopyListWithRandomPointerFunc(head);

    }

    private static void CopyListWithRandomPointerFunc(Node head) {

        Node curr = head;
        Node next;
        while (curr != null) {
            Node node = new Node(curr.value);
            next = curr.next;
            curr.next = node;
            node.next = next;
            curr = next;
        }

        curr = head;
        next = head.next;

        while (curr != null) {
            Node random = curr.random;
            if (random == null) {
                next.random = null;
            } else {
                next.random = curr.random.next;
            }
            curr = curr.next.next;
            if (next.next == null) {
                break;
            }
            next = next.next.next;
        }

        curr = head;
        next = curr.next;
        Node head2 = head.next;
        while (curr!=null) {
            curr.next = next.next;
            curr = next.next;
            if (curr == null) {
                break;
            }
            next.next = curr.next;
            next = curr.next;
        }

        while (head != null) {
            System.out.print("value - " + head.value);
            if (head.random != null) {
                System.out.print(" random - " + head.random.value);
            } else {
                System.out.print(" random - " + "null");
            }
            System.out.println();
            System.out.print("value - " + head2.value);
            if (head.random != null) {
                System.out.print(" random - " + head2.random.value);
            } else {
                System.out.print(" random - " + "null");
            }
            System.out.println();
            System.out.println("---------------------------------------------");

            head = head.next;
            head2 = head2.next;
        }

    }
}
