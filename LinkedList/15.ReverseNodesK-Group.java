// Reverse Nodes in K-Group
// Time Complexity : O(n/k*k) ==> O(n)
// Space Complexity : O(1)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        
        ListNode start = head , end = head;
        int move = k - 1;
        while(move-- > 0){
            end = end.next;
            if(end == null) return head;
        }
        
        ListNode nextHead = reverseKGroup(end.next , k);
        reverse(start , end);
        start.next = nextHead;
        return end;
    }
    private void reverse(ListNode start , ListNode end){
        ListNode prev = null , c = start , n = start.next;
        while(prev != end){
            c.next = prev;
            prev = c;
            c = n;
            if(n != null) n = n.next;
        }
    }
}