// Sum of Two Linked List
// Time Complexity : O(n + m)
// Space Complexity : O(1)


class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode tail = ans;

        ListNode l1 = list1 , l2 = list2;
        int carry = 0;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            int rem = sum % 10;
            ListNode new_node = new ListNode(rem);
            tail.next = new_node;
            tail = new_node;
            carry = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }

        if(carry != 0){
            tail.next = new ListNode(carry);
        }

        return ans.next;
    }
}