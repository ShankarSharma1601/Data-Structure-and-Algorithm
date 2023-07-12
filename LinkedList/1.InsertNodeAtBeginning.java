// Insert Node in a Linked List
// Time Complexity : O(1)
// Space Complexity : O(1)


class Solution{
    public Node insertNode(Node head , int val){
        Node newnode = new Node(value);
        newnode.next = head;
        return newnode;
    }
}