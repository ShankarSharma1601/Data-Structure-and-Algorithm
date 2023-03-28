// Left Rotate an Array by D Places
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    public void rotate(int[] nums, int k) {
       k = k % nums.length;
       reverse(nums, 0, nums.length-1);
       reverse(nums, 0 , k-1);
       reverse(nums, k , nums.length-1);
       
    }
    private void reverse(int arr[] , int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }
}