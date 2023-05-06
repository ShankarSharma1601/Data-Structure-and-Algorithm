// First Occurence of element in Sorted Array
// Time Complexity : O(logn)
// Space COmplexity : O(1)

class Solution {
    public int searchRange(int[] nums, int target) {
        
        //first position
        int first = firstposition(nums , target , 0 , nums.length - 1);

        return first;
        
    }
    private int firstposition(int arr[] , int target , int low , int high){
        
        int ans = -1;
        while(low <= high){
            int mid = low + ( high - low)/2;
            if(arr[mid] == target){
                high = mid - 1;
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