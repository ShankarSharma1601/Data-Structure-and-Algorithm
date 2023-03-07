// Lowest Common Ancestor of a Binary Search Tree
// Time Complexity : O(h)
// Space Complexity : O(h)



class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}