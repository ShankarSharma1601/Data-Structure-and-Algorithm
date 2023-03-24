// Check if Array is Sorted and Rotated
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
}