// Find Minimum in Rotated Sorted Array
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int start = 0 , end = nums.length -1;
        while(start <= end){
            if(nums[start] < nums[end] ) return nums[start];
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid +1]) return nums[mid+ 1];
            else if(nums[mid] < nums[mid - 1]) return nums[mid];
            else if(nums[start] <= nums[mid]) start = mid + 1;
            else if(nums[mid] <= nums[end]) end = mid - 1;
        }
        
        return -1;
    }
}


//Alternate Solution

class Solution{
    public int findMin(int nums[]){
        int left = 0 , right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(left <= right){
            if(nums[left] < nums[right]){
                min = Math.min(min , nums[left]);
                break;
            }

            int mid = left + ( right - left ) / 2;

            if(nums[left] <= nums[mid]){
                min = Math.min(min , nums[left]);
                left = mid + 1;
            }
            else{
                min = Math.min(min , nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}