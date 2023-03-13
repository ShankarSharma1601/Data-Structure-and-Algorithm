// Two Sum in BST | Check if there exists a pair with sum k
// Time Complexity : O(n)
// Space Complexity : O(h)


class Solution{
    public int isPairPresent(Node root, int target){
        ArrayList<Integer> arr = new ArrayList<>();
        solve(root , arr);
        int start = 0 , end = arr.size()-1;
        while(start < end){
            int sum = arr.get(start) + arr.get(end);
            if(sum == target) return 1;
            else if(sum > target) end--;
            else start++;
        }
        return 0;
    }
    private void solve(Node root , ArrayList<Integer> arr){
        if(root == null) return ;
        solve(root.left , arr);
        arr.add(root.data);
        solve(root.right , arr);
    }
}