// Diameter of a Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(h)

class Solution {
    
    int diameter=0;
    public int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter;
    }
    private int height(Node root){
        if(root==null) return 0;

        int leftheight=height(root.left);
        int rightheight=height(root.right);

        diameter = Math.max(diameter,leftheight+rightheight);
        return 1 + Math.max(leftheight,rightheight);
        
    }
}