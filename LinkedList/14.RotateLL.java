// Rotate Linked List
// Time Complexity : O(n)
// Space COmplexity :O(1)
 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy,fast = dummy;
        dummy.next = head;
        int len = 0;
        while(fast.next!=null){
            fast = fast.next;
            len++;       // get length of linked list
        }
        for( int j = len - k%len;j>0;j--){
            slow = slow.next;
        }
       fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}

