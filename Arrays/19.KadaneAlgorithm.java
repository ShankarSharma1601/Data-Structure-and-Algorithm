// Kadane's Algorithm
// Maximum Subarray Sum
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = nums[0] , max_sum = nums[0];
        for(int i = 1;i < nums.length;i++){
            curr_sum = Math.max(curr_sum + nums[i] , nums[i]);
            max_sum = Math.max(max_sum , curr_sum);
        }
        return max_sum;
    }
}