// Search in Rotated Sorted Array II
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    public boolean search(int[] nums, int target) {
        return binarysearch(nums, 0, nums.length-1, target);
    }
    public boolean binarysearch(int []arr, int start, int end, int target){
        
        if(start > end) return false;
        
        int mid = start + (end - start)/2;
        if(arr[mid] == target) return true;
        
        //duplicates
        if(arr[start] == arr[mid]  && arr[mid] == arr[end]){
            start++;
            end--;
            return binarysearch(arr, start, end, target);
        }
        //if left part is sorted
        else if(arr[start] <= arr[mid]){
            //if target lies in sorted part or not
            if(arr[start] <= target && target <= arr[mid]){
                return binarysearch(arr, start, mid-1, target);
            }
            else return binarysearch(arr, mid+1, end, target);
        }
        else if(target >= arr[mid] && target <= arr[end]){
            return binarysearch(arr, mid+1, end, target);
        }
        return binarysearch(arr,start, mid-1, target);
    }
}