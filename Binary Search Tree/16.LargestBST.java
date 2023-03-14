// Find the size of its largest subtree that is a Binary Search Tree.
// Here Size is equal to the number of nodes in the subtree.
// Time Complexity : O(n)
// Space Complexity : O(h)


class NodeValue{
    int minNode ,  maxNode , maxsize;
    NodeValue(int min , int max , int size){
        minNode = min;
        maxNode = max;
        maxsize = size;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root){
        return solve(root).maxsize;       
    }
    private static NodeValue solve(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }
        
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode){
            return new NodeValue(Math.min(root.data , left.minNode) , Math.max(root.data , right.maxNode) , left.maxsize + right.maxsize + 1);
        }
        else {
            return new NodeValue(Integer.MIN_VALUE , Integer.MAX_VALUE , Math.max(left.maxsize , right.maxsize));
        }
    }
}