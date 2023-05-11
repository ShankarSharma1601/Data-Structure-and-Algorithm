// Search in Rotated Sorted Array
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int start = 0 , end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return  mid;
            else if(nums[mid] > nums[end]){
                if(target >= nums[start] && target < nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
            else if(nums[mid] < nums[start]){
                if(target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
            else{
                if(target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return ans;
    }
}