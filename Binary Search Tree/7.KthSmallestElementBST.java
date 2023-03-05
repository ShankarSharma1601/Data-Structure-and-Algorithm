// Kth Smallest Element in BST
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans  = inorder(root, new ArrayList<Integer>());
        return ans.get(k-1);
        
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
// Time Complexity: O(min(K,N))
// Space Complexity: O(min(K,N))
class Solution{
    public int kthSmallest(TreeNode root, int k) {
        TreeNode small = kthsmallestEle(root , new int[]{k});
        if(small == null) return -1;
        return small.data;
    }
    private Node kthsmallestEle(Node root , int k[]){
        if(root == null) return null;
        
        Node left = kthsmallestEle(root.left , k);

        if(left != null) return left;
        k[0]--;
        if(k[0] == 0) return root;

        return kthsmallestEle(root.right , k);
    }
}