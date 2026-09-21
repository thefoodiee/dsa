package LinkedList2;

import LinkedList.ListNode;

public class DetectCycleTwo {
    static void main() {

    }

    static ListNode detect(ListNode head){
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast) break;
        }

        //handle loop break due to fast ptr
        if(fast == null || fast.next == null) return null;

        ListNode temp = head;

        while(slow != temp){
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }
}
