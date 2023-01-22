// Symmetric Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    public static boolean isSymmetric(Node root){
        if(root== null) return true;
        return solve(root.left , root.right);
    }
    private static boolean solve(Node left , Node right){
        if(left == null || right == null) return left == right;
        return left.data == right.data && solve(left.left , right.right) && solve(left.right , right.left);
    }
}