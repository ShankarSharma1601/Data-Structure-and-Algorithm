// If two Trees are identical or not
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    public boolean isIdentical(Node root1 , Node root2){
        if(root1 == null || root2 == null) return root1 == root2;
        return root1.data == root2.data && isIdentical(root1.left , root2.left) && isIdentical(root1.right , root2.right);
    }
}