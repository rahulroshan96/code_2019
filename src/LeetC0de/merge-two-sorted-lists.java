/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = null;
        if(l1==null && l2==null) return result;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                if(result==null){ // first time
                    result = new ListNode(temp1.val);
                    head = result;
                    temp1=temp1.next;
                }else{
                    result.next = new ListNode(temp1.val);
                    result=result.next;
                    temp1=temp1.next;
                }
            }else{
                if(result==null){ // first time
                    result = new ListNode(temp2.val);
                    head = result;
                    temp2=temp2.next;
                }else{
                    result.next = new ListNode(temp2.val);
                    result=result.next;
                    temp2=temp2.next;
                }
            }
        }
        if(temp1==null&&temp2==null) return head;
        if(temp1==null){
            while(temp2!=null){
                result.next = new ListNode(temp2.val);
                result=result.next;
                temp2=temp2.next;
            }
        }else{
            while(temp1!=null){
                result.next = new ListNode(temp1.val);
                result=result.next;
                temp1=temp1.next;
            }
        }
        return head;
    }
}