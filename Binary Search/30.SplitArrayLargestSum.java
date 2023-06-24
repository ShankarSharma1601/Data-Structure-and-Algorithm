// Split Array Largest Sum
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution {
    public int splitArray(int[] nums, int m) {
                 
        int low = 0 , high = 0 , n = nums.length;
        for(int i = 0;i < n;i++){
            low = Math.max(low , nums[i]);
            high += nums[i];
        }
        
        int mid = 0 , ans = 0;
        
        while( low <= high){
            mid = low + (high - low)/2;
            int count = ispossible(nums , mid); // number of subarray possible if max sum is mid
            if(count <= m){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
    private int ispossible(int []nums , int mid){
        
        int count = 0 , tempsum = 0 , n = nums.length;
        for(int i = 0;i < n;i++){
            if(tempsum + nums[i] <= mid) {
                tempsum += nums[i];
            }
            else{
                count++;
                tempsum = nums[i];
            }
        }
        count++;
        return count;
    }
}