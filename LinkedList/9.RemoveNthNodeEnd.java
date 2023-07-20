// Remove Nth Node from End of List
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newList = new ListNode(0);
        newList.next = head;
        ListNode slow = newList, fast = newList;
        for(int i = 1;i <= n;i++){
            if(fast == null) return null;
            fast = fast.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return newList.next;
        
    }
}