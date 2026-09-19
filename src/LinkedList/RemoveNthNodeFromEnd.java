package LinkedList;

public class RemoveNthNodeFromEnd {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4,5});
        ListNode.print(remove(head, 2));
    }
    static ListNode remove(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
