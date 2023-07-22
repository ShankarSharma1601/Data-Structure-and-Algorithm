// Sort the Linked List
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution{
    public Node sortList(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null , slow = head , fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        Node l1 = sortList(head);
        Node l2 = sortList(slow);

        return merge(l1 , l2);
    }
    public Node merge(Node l1 , Node l2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tail.next = l2;
                l2 = l2.next;
            }
            else{
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }

        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }

        return dummy.next;
    }
}