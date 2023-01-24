// Root to Leaf Path
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution{
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root , new ArrayList<Integer>());
        return ans;
    }
    private void dfs(Node root , ArrayList<Integer> temp){
        if(root == null) return ;
        
        temp.add(root.data);
        if(root.left ==  null && root.right == null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return ;
        }
        dfs(root.left , temp);
        
        dfs(root.right , temp);
        temp.remove(temp.size()-1);
    }
}