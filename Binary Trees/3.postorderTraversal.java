// PostOrder Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution{
    public List<Integer> postorder(Node root){
        List<Integer> ans = new ArrayList<>();
        dfs(root , ans);
        return ans;
    }
    private void dfs(Node root , List<Integer> ans){
        if(root == null) return ;
        dfs(root.left , ans);
        dfs(root.right , ans);
        ans.add(root.data);
    }
}