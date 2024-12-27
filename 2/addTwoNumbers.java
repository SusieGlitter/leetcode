
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode temp1=l1,temp2=l2,temp3=head;
        int sum=0,carry=0;
        while(temp1!=null&&temp2!=null)
        {
            temp3.next=new ListNode();
            temp3=temp3.next;
            sum=temp1.val+temp2.val+carry;
            carry=sum/10;
            sum%=10;
            temp3.val=sum;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp2!=null)
            temp1=temp2;
        while(temp1!=null)
        {
            temp3.next=new ListNode();
            temp3=temp3.next;
            sum=temp1.val+carry;
            carry=sum/10;
            sum%=10;
            temp3.val=sum;
            temp1=temp1.next;
        }
        if(carry!=0)
            temp3.next=new ListNode(carry);

        return head.next;
    }
}

public class addTwoNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = sol.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}