// Combination Sum III
// Time Complexity : O(k*9^k)
// Space Complexity : O(K)

class Solution {
    List<List<Integer>>ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        solve(new ArrayList<Integer>() , 1 , k  , n);
        return ans;
    }
    private void solve(List<Integer> temp , int start  , int k , int target){
        if(k == temp.size() && target == 0){
           ans.add(new ArrayList<>(temp));
            return ;
        }       
        for(int i = start;i <= 9;i++){
            temp.add(i);
            solve(temp , i + 1 , k  , target - i );
            temp.remove(temp.size() - 1);
        }
    }
}


