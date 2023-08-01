package LinkedList;

public class ReverseKgroup {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseKGroup(head, 3);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
    public static Node reverseKGroup(Node head, int k) {
        Node temp=head;
        for(int i=0;i<k;i++){
            if(temp==null){
                return head;
            }
            temp=temp.next;
        }
        Node sp=reverseKGroup(temp,k);
        Node prev=null;
        Node curr=head;
        for(int i=0;i<k;i++){
            Node after =curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        head.next=sp;
        return prev;
    }
}

