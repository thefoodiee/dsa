package LinkedList;

public class ReverseLL {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4,5});
        ListNode.print(reverse(head));
    }
    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
