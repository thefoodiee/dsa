package LinkedList2;

import LinkedList.ListNode;

public class FindIntersection {
    static void main() {

    }
    static ListNode find(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null) return null;
        ListNode a = head1;
        ListNode b = head2;
        while(a != b){
            if(a == null) a = head2;
            else a = a.next;
            if(b == null) b = head2;
            else b = b.next;
        }
        return a;
    }
}
