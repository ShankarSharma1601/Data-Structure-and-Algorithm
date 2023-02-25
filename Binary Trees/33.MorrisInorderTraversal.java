// Morris Inorder Traversal
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        TreeNode curr = root; 
        while(curr != null) {
            if(curr.left == null) {
                inorder.add(curr.val); 
                curr = curr.right; 
            }
            else {
                TreeNode prev = curr.left; 
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left; 
                }
                else {
                    prev.right = null; 
                    inorder.add(curr.val); 
                    curr = curr.right; 
                }
            }
        }
        return inorder; 
    }
}
