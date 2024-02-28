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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode newNode = null;
        ListNode prev = null;
        
        while(temp != null){
            ListNode kthNode = findKNode(temp, k);
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                    break;
                }
            }
            
            newNode = kthNode.next;
            kthNode.next = null;
            
            reverseLL(temp);
            if(temp == head)
                head = kthNode;
            else
                prev.next = kthNode;
            
            prev = temp;
            temp = newNode;
        }
        return head;
    }
    
    private ListNode findKNode(ListNode temp, int k){
        k -=1 ;
         while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        
        return temp;
        
    }
    
    private ListNode reverseLL(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode newNode = reverseLL(head.next);
        ListNode front = head.next;
        
        front.next = head;
        head.next = null;
        
        return newNode;
    }
}