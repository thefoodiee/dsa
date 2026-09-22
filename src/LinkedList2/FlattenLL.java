package LinkedList2;

class Node {
    int data;
    Node next, bottom;

    Node(int newData) {
        data = newData;
        next = bottom = null;
    }
}

public class FlattenLL {
    static void main() {

    }
    static Node flatten(Node head){
        if (head == null || head.next == null) return head;
        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }

    static Node merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node ans = dummy;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                ans.bottom = head1;
                head1 = head1.bottom;
            }
            else{
                ans.bottom = head2;
                head2 = head2.bottom;
            }
            ans = ans.bottom;
        }

        if(head1 != null){
            ans.bottom = head1;
        }
        if(head2 != null){
            ans.bottom = head2;
        }
        return dummy.bottom;
    }
}
