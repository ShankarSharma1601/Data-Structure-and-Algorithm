// Subsets
// Time Complexity : O(2^n)
// Space Complexity : O(n)

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(nums, new ArrayList<Integer>() , 0);
        return ans;
    }
    private void solve(int nums[] , List<Integer> temp , int ind){
        if(ind == nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        
        temp.add(nums[ind]);
        solve(nums , temp , ind + 1);
        temp.remove(temp.size() - 1);
        solve(nums , temp , ind+1);
    }
}