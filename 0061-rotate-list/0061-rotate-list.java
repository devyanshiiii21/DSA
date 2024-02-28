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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        
        if(k%len == 0)
            return head;
        
        k = k%len;
                
        temp.next = head;
        
        ListNode newLast = kthNode(head, len-k);
        head = newLast.next;
        newLast.next = null;
        
        return head;
        
    }
    
    private ListNode kthNode(ListNode head, int count){
        ListNode temp = head;
        count -= 1;
        while(count != 0){
            temp = temp.next;
            count--;
        }
        
        return temp;
    }
}