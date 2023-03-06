// Validate a Binary Search Tree
// Time Complexity : O(n)
// Space Complexity : O(h)


class Solution {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return solve(root , min , max);
    }
    private boolean solve(TreeNode root , long min , long max){
        if(root == null) return true;
        
        return ( root.val < max && root.val > min && solve(root.left , min , root.val) && solve(root.right , root.val , max) );
    }
}