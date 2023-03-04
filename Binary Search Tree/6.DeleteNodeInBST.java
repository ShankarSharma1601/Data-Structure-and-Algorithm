// Delete Node in a BST
// Time Complexity : O(h)
// Space Complexity : O(h)


class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return root;
        
        if(root.val == key){
            
            //0 child
            if(root.left == null && root.right == null) {
                return null;
            }
            
            
            //1 child
            //  |- left child
            
            if(root.left!=null && root.right == null){
                TreeNode temp = root.left;
                return temp;
            }
            
            //  |- right child
            
            if(root.left ==null && root.right != null){
                TreeNode temp = root.right;
                return temp;
            }
            
            
            //2 child
            if(root.left!=null && root.right!=null){
                int min = minval(root.right).val;
                root.val = min;
                root.right = deleteNode(root.right, min);
                return root;
            } 
        }
        else if(root.val > key){
           root.left =  deleteNode(root.left, key);
            return root;
        }
        else{
            root.right = deleteNode(root.right, key);
            return root;
        }
      return null;
    }
    public TreeNode minval(TreeNode root){
        
        TreeNode temp = root;
        while(temp.left!=null){
          temp = temp.left;
        }
        
        return temp;
        
    }
}