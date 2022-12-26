// Preorder Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)


class Solution{
    public List<Integer> preOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        dfs(root , ans);
        return ans;
    }
    private void dfs(Node root , List<Integer> ans){
        if(root == null) return ;
        ans.add(root.data);
        dfs(root.left , ans);
        dfs(root.right , ans);
    }
}