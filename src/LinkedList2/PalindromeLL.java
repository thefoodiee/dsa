package LinkedList2;

import LinkedList.ListNode;

public class PalindromeLL {
    static void main() {
        ListNode head = ListNode.fromArray(new int[]{1,3,3,1});
        System.out.println(palindrome(head));
    }
    static boolean palindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //handling odd length lists
        if(fast != null){
            slow = slow.next;
        }
        //reverse
        slow = reverse(slow);

        ListNode dummy = head;
        while(slow != null){
            if(slow.val != dummy.val) return false;
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
