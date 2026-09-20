package LinkedList2;

import LinkedList.ListNode;

public class ReverseNodesInKGroup {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,2,3,4,5});
        ListNode.print(reverseK(head, 2));
    }
    static ListNode reverseK(ListNode head, int k){
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        while(true){
            ListNode kTh = getK(prev, k);
            if(kTh == null) break;
            ListNode next = kTh.next;

            ListNode temp = prev.next;

            //reverse LL
            reverseLL(temp, next);

            prev.next = kTh;
            temp.next = next;
            prev = temp;

        }


        return dummy.next;
    }

    static void reverseLL(ListNode start, ListNode end){
        ListNode prev = start, curr = start.next;

        while(curr != end){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    static ListNode getK(ListNode curr, int k){
        while(curr != null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
