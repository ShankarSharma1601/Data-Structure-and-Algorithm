// Kth Largest Element in BST
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> ans  = inorder(root, new ArrayList<Integer>());
        return ans.get(ans.size() - k);
    }
    private ArrayList<Integer> inorder(TreeNode root,  ArrayList<Integer> ans){
        if(root == null) return ans;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
        
        return ans;
    }
}


// Alternate Solution
class Solution {
    ArrayList<Integer> ans;
    public int KthLargestElement(Node root, int k) {
        ans = new ArrayList<>();
        solve(root , ans);
        if(ans.size() < k) return -1;
        return ans.get( k - 1);
    }
    public void  solve(Node root,ArrayList<Integer> ans ){
        
        if( root == null ) return ;
        solve(root.right, ans);
        ans.add(root.data);
        solve(root.left, ans);
        
    }
 }
 



// Alternate Solution
// Time Complexity: O(min(K,N))
// Space Complexity: O(min(K,N))
class Solution{
    public int KthLargestElement(TreeNode root, int k) {
        TreeNode small = kthlargest(root , new int[]{k});
        if(small == null) return -1;
        return small.data;
    }
    private Node kthlargest(Node root , int k[]){
        if(root == null)
        return null;
        
        Node right = kthlargest(root.right , k);
        if(right != null)
        return right;
        k[0]--;
        
        if(k[0] == 0)
        return root;
        
        return kthlargest(root.left , k);
    }
}