// Find the Smallest Divisor given a Threshold
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1 , high = nums[0];
        for(int val : nums){
            if(val > high){
                high = val;
            }
        }

        while(low < high){
            int mid = low + ( high - low)/2;
            if(valid(nums , mid , threshold)) high = mid;
            else low = mid + 1;
        }

        return low;
    }
    private boolean valid(int nums[] , int mid , int high){
        for(int val : nums){
            if((high -= (val + mid - 1)/mid) < 0) return false;
        }
        return true;
    }
}