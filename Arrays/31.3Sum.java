// 3 Sum
// Time Complexity : O(n^2)
// Space Complexity : O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        if(nums.length == 0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-1;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) set.add(Arrays.asList(nums[i] , nums[j++], nums[k--]));
                if(sum > 0) k--;
                if(sum < 0) j++;
            }
        }
        return new ArrayList<>(set);
    }
}