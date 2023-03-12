// Merge Two BST
// Time Complexity : O(m + n)
// Space Complexity : O(h1 + h2 + (m + n)(for storing answer))


class Solution{
    public List<Integer> merge(Node root1,Node root2){
        List<Integer> ans = new ArrayList<>();
        solve(root1 , ans);
        solve(root2 , ans);
        Collections.sort(ans);
        return ans;
    }
    private void solve(Node root , List<Integer> arr){
        if(root == null) return ;
        solve(root.left , arr);
        arr.add(root.data);
        solve(root.right , arr);
    }
}