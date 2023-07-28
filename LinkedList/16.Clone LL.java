// Clone a Linked List with Random pointer
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        //insert new node in between
        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        
        //setting random pointer
        while(curr !=null){
            if(curr.next !=null){
                curr.next.random = (curr.random!=null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }
        
        //separating both linked list
        Node orignal = head, copy = head.next;
        Node temp = copy;
        while(orignal != null){
            orignal.next = orignal.next.next;
             copy.next = (copy.next!=null) ? copy.next.next : copy.next;
            orignal = orignal.next;
            copy = copy.next;
        }
        
        return temp;
        
        
        
    }
}