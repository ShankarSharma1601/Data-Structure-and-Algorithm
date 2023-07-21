// Delete Middle Node of a Linked List
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode slow = head , fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}