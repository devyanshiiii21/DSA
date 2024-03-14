/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void solve(ListNode* ptr,ListNode* l1,ListNode* l2){
        if(l1==NULL) {ptr->next=l2; return;}
        if(l2==NULL) {ptr->next=l1;  return;}
        
        if(l1->val<=l2->val){
            ptr->next=l1; 
            l1=l1->next;
            ptr=ptr->next;
            
            solve(ptr,l1,l2);
        }else{
            ptr->next=l2; 
            l2=l2->next;
            ptr=ptr->next;
            
            solve(ptr,l1,l2);
        }
    }
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *dummy=new ListNode(-1); 
        ListNode *ptr=dummy;
        
        solve(ptr,list1,list2);
        
        return dummy->next;
    }
};