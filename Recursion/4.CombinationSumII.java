// Combination Sum II
// Time Complexity : O(2^n)
// Space Complexity : O(n)

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates.length == 0) return ans;
        Arrays.sort(candidates);
        solve(candidates , target , 0 , 0 , new ArrayList<Integer>() , ans);
        return ans;
    }
    private void solve(int arr[] , int target , int ind , int sum ,List<Integer> temp ,List<List<Integer>> ans ){
        if(ind == arr.length){
            if(sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(sum < target){
            temp.add(arr[ind]);
            solve(arr , target , ind + 1 , sum + arr[ind] , temp , ans);
            temp.remove(temp.size() -1);
        }
        while(ind + 1 < arr.length && arr[ind] == arr[ind + 1]) ind++;
        solve(arr , target, ind + 1 , sum , temp , ans);
    }
}