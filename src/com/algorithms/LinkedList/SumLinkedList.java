package LinkedList;

public class SumLinkedList {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);


        Node head1 = new Node(1);
//        head1.next = new Node(6);
//        head1.next.next = new Node(4);

//        SumLinkedListFunc(head, head1);
        SumLinkedListFunc2(head, head1);


    }

    private static void SumLinkedListFunc(Node head, Node head1) {
        Node sum =  null;
        int carry = 0;
        int reminder = 0;
        boolean isCarryRequired = false;
        Node ans = null;
        while (head1 != null && head != null) {
            int a = head1.value + head.value + reminder;
            reminder = 0;
            if (a > 9) {
                carry = a % 10;
                reminder = a/10;
                isCarryRequired = true;
            } else  {
                isCarryRequired = false;
            }
            if (sum == null) {
                if (isCarryRequired) {
                    sum = new Node(carry);
                    ans = sum;
                } else {
                    sum = new Node(a);
                    ans = sum;
                }
            } else {
                Node node;
                if (isCarryRequired) {
                    node = new Node(carry);
                } else {
                    node = new Node(a);
                }
                sum.next = node;
                sum = sum.next;
            }
            head = head.next;
            head1 = head1.next;
        }

        while (head != null || head1 != null) {
            int a = 0;
            if (head != null) {
                 a = head.value + reminder;
                head = head.next;
            } else if (head1 != null) {
                a = head1.value + reminder;
                head1 = head1.next;
            }
            if (a > 9) {
                carry = a % 10;
                reminder = a/10;
                isCarryRequired = true;
            } else  {
                isCarryRequired = false;
            }

            if (isCarryRequired) {
                sum.next = new Node(carry);
                sum = sum.next;
            } else {
                reminder = 0;
                sum.next = new Node(a);
            }
        }

        if (reminder > 0) {
            sum.next = new Node(reminder);
        }

        while (ans != null) {
            System.out.println(ans.value);
            ans= ans.next;
        }
    }

    private static void SumLinkedListFunc2(Node head, Node head1) {
        int carry = 0;
        Node ans = new Node(0);
        Node sum = ans;
        while (head != null || head1 != null) {
            if (head != null) {
                carry += head.value;
                head = head.next;
            }
            if (head1 != null) {
                carry += head1.value;
                head1 = head1.next;
            }

            ans.next = new Node(carry % 10);
            ans = ans.next;
            carry /= 10;
        }

        if (carry == 1) {
            ans.next = new Node(carry);
        }

        sum = sum.next;
        while (sum != null) {
            System.out.println(sum.value);
            sum= sum.next;
        }
    }
}
