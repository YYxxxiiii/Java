class Solution{
    public ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode newHead(0);
        ListNode *pi = &newHead;
        while(l1 && l2) {
            if(l1->val > l2->val) swap(l1, l2);
            pi->next = l1;
            l1 = l1->next;
            pi = pi->next;
        }
        pi->next = l1 ? l1 : l2;
        return newHead.next;
    }
}