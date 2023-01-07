// MAXIMUM PATH SUM
// PATH MAY START AND END AT ANY NODE 
// Time Complexity : O(n)
// Space Complexity : O(n)



//Function to return maximum path sum from any node in a tree.
class Solution{
    
    int ans = Integer.MIN_VALUE;
    int findMaxSum(Node node){
        solve(node);
        return ans;
    }
    private int solve(Node node){
        if(node == null) return 0;
        int left = Math.max(0 , solve(node.left));
        int right = Math.max(0 , solve(node.right));
        ans = Math.max(ans , node.data + left + right);
        return node.data + Math.max(left , right);
        
    }
}
