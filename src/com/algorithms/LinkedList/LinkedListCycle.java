package LinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        if(head==null || head.next==null) return false;

        while(true){
            if(fast.next==null || fast.next.next==null) break;
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
