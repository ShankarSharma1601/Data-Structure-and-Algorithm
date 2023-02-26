// Count Complete Tree Node
// Time Complexity : O(log^2 N)
// Space Complexity : O(logN)


class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        if(left == right) return  ((2 << (left))  - 1);
        
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    private int getHeightLeft(TreeNode root){
        int ans = 0;
        while(root.left != null){
            ans++;
            root = root.left;
        }
        return ans;
    }
    private int getHeightRight(TreeNode root){
        int ans = 0;
        while(root.right != null){
            ans++;
            root = root.right;
        }
        return ans;
    }
}