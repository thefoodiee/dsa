package LLAndArrays;

import LinkedList.ListNode;

public class RotateLL {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{0,1,2});
        ListNode.print(rotate(head, 4));
    }

    static ListNode rotate(ListNode head, int k){
        if(head == null || head.next == null || k == 0) return head;

        //get length of list
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        k = k%len;
        if(k==0) return head;

        //make circular
        tail.next = head;

        //find new head
        ListNode dummy = head;
        int steps = len-k;
        for(int i = 1; i<steps; i++){
            dummy = dummy.next;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;

        return newHead;
    }
}
