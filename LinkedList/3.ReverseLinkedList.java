// Reverse Linked List(iterative)
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode p = null,c = head,n = head.next;
        while(c != null){
            c.next = p;
            p = c;
            c = n;
            if(n != null) n = n.next;
        }
        return p;
    }
}