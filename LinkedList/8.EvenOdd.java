// Seggreate Even and Odd Nodes in a LinkedList
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head , even = head.next , evenhead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}