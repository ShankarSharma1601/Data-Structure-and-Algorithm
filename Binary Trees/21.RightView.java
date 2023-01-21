// Right View of a Binary Tree
// Time Complexity : O(N)
// Space Complexity : O(H)  H ---> Height of tree

class Solution{
    ArrayList<Integer> leftView(Node root){
      ArrayList<Integer> ans=new ArrayList<Integer>();
      recursion(root , 0 , ans);
      return ans;
    }
    
    private void recursion(Node root , int level , ArrayList<Integer>ans){
        
        if(root == null) return;
        if(ans.size() == level){
            ans.add(root.data);
        }
        recursion(root.right , level + 1 , ans);
        recursion(root.left , level + 1 , ans);
    }
}