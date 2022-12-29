// Height of a Binary Tree
// Recursive Approach
// Time Complexity : O(n)
// Space Complexity : O(h)

class Solution{
    public int maxHeight(Node root){
        if(root == null) return 0;

        int left_height = maxHeight(root.left);
        int right_height = maxHeight(root.right);
        
        return 1 + Math.max(left_height , right_height);
    }
}