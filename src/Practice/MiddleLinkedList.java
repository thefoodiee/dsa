package Practice;

import LinkedList.ListNode;

public class MiddleLinkedList {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4});
        System.out.println(middle(head).val);
    }
    static ListNode middle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
