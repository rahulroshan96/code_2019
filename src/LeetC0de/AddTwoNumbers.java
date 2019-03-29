package LeetC0de;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

class AddTwoNumbers {

    public static void main(String args[]){
        AddTwoNumbers ff = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode result = ff.addTwoNumbers(l1,l2);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ref1 = null;
        ListNode ref2 = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ref1 = l1;
        ref2 = l2;
        ListNode result = null, head = null;
        int carry = 0;
        while(ref1!=null && ref2!=null){
            int sum = ref1.val + ref2.val+carry;
            if(sum>9){
                carry = sum/10;
                sum = sum%10;
            }else{
                carry=0;
            }
            if(result == null){ // first time
                result = new ListNode(sum);
                head = result;
                result.next = null;
            }else{
                result.next = new ListNode(sum);
                result = result.next;
            }
            ref1 = ref1.next;
            ref2 = ref2.next;
        }
        if(ref1 == null && ref2 == null){
            if(carry==0){
                return head;
            }else{
                result.next = new ListNode(carry);
                return head;
            }
        }
        if(ref1 == null){
            while(ref2!=null){
                int sum = ref2.val + carry;
                if(sum>9){
                    carry = sum/10;
                    sum = sum%10;
                }else{
                    carry = 0;
                }
                result.next = new ListNode(sum);
                result = result.next;
                ref2 = ref2.next;
            }
            if(carry!=0){
                result.next = new ListNode(carry);
                result = result.next;
                carry = 0;
            }
        }
        if(ref2 == null){
            while(ref1!=null){
                int sum = ref1.val + carry;
                if(sum>9){
                    carry = sum/10;
                    sum = sum%10;
                }else{
                    carry = 0;
                }
                result.next = new ListNode(sum);
                result = result.next;
                ref1 = ref1.next;
            }
            if(carry!=0){
                result.next = new ListNode(carry);
                result = result.next;
                carry = 0;
            }
        }
        result.next = null;
        return head;
    }
}
