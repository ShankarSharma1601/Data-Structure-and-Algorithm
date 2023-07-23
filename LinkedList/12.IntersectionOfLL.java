// Intersection of Two Linked List
// Time Complexity : O(2*max(length of list1 , length of list 2))
// Space Complexity : O(1)

class Solution{
    public Node getIntersectionPointNode(Node headA , Node headB){
        Node a = headA ,b = headB;

        while(a != b){
            if(a == null) a = headB;
            else a = a.next;

            if(b == null) b = headA;
            else b = b.next;
        }

        return a;
    }
}