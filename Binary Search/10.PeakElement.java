// Peak Element
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2] ) return n-1;
        
        int start = 1 , end = n-2;
        while(start < end){
            int mid = start + ( end - start) /2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid + 1] > nums[ mid]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}