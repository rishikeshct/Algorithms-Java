package LinkedList;

public class ReorderList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        ReorderListFunc(head);

    }

    private static void ReorderListFunc(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHead = reverse(slow.next);

        slow.next = null;
        Node currFirst = head;
        Node currSecond = secondHead;
        Node nextFirst;
        Node nextSecond;
        while (currFirst != null && currSecond != null) {
            nextFirst = currFirst.next;
            nextSecond = currSecond.next;
            currFirst.next = currSecond;
            currSecond.next = nextFirst;
            currFirst = nextFirst;
            currSecond = nextSecond;
        }

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
