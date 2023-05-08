// Last Occurence of element in Sorted Array
// Time Complexity : O(logn)
// Space COmplexity : O(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //last postion
        int last = lastposition(nums , target , 0 , nums.length - 1);

        return last;
        
    }
    
    private int lastposition(int arr[] , int target , int low , int high){
        
        int ans = -1;
        while(low <= high){
            int mid = low + ( high - low)/2;
            if(arr[mid] == target){
                low = mid + 1;
                ans = mid;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}