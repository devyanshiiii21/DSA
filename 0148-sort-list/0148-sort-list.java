/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode middle = findMiddle(head);
        ListNode leftNode = head;
        ListNode rightNode = middle.next;
        middle.next = null;
        
        ListNode left = sortList(leftNode);
        ListNode right = sortList(rightNode);
        ListNode ans = mergeList(left, right);
        return ans;
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
         fast = fast.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode mergeList(ListNode leftHead, ListNode rightHead){
        ListNode t1 = leftHead;
        ListNode t2 = rightHead;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;

            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
                
        }
        
        if(t1 != null) temp.next = t1;
        else
            temp.next = t2;
        return dummy.next;
    }
}