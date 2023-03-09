// Construct Binary Search Tree from Preorder Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)


class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder , Integer.MAX_VALUE );
    }
    private TreeNode solve(int []pre , int bound ){
        if(index == pre.length || pre[index] > bound)
            return null;
        
        TreeNode root = new TreeNode(pre[index++]);
        root.left = solve(pre , root.val);
        root.right = solve(pre , bound);
        return root;
    }
}