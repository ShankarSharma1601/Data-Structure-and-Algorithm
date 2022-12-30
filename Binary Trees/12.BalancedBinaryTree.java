// Check if the Binary Tree is Balanced or not
// Time Complexity : O(n)
// Space Complexity : O(h) Recursion Stack space

class Solution{
    public boolean isBalanced(Node root){
        return dfs(root) != -1;
    }
    private int dfs(Node root){
        if(root == null) return 0;

        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = dfs(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight , rightHeight);
    }
}