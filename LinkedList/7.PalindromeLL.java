// Palindrome Linked List
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public ListNode reverse(ListNode head){
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        ListNode start = head,mid = slow.next;
        while(mid != null){
            if(mid.val != start.val) return false;
            start = start.next;
            mid = mid.next;
        }
        return true;
    }
}