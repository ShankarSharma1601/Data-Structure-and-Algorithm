// Recover BST | Correct BST with two nodes swaped
// Time Complexity : O(N)
// Space Complexity : O(1)


class Solution {
    private
    TreeNode first;
    TreeNode mid;
    TreeNode last;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);
        
        if(first != null && last !=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && mid != null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }  
    }
    public void inorder(TreeNode root){
        
        if(root == null) return ;
        
        inorder(root.left);
        
        if(prev != null && root.val < prev.val  ){
            if(first == null){
                first = prev;
                mid = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}