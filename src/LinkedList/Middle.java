package LinkedList;

public class Middle {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,3,4,5});
        ListNode.print(middle(head));
    }
    static ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
