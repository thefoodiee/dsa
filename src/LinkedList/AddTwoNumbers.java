package LinkedList;

public class AddTwoNumbers {
    static void main() {
        ListNode head1 = ListNode.fromArray(new int[]{3,2,1});
        ListNode head2 = ListNode.fromArray(new int[]{3,2,1});

        ListNode.print(add(head1, head2));
    }
    static ListNode add(ListNode head1, ListNode head2){
        ListNode res = new ListNode(0);
        ListNode ptr = res;
        int carry = 0;

        while(head1 != null || head2 != null){
            int sum = carry;

            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }

            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }

            //partition the sum
            //get left digit in carry and right digit in sum vars

            carry = sum/10;
            sum = sum%10;

            //add sum to ll
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        // if carry remains
        if(carry ==1){
            ptr.next = new ListNode(carry);
        }

        return res.next;
    }
}
