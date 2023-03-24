// Largest Element in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public int largest(int arr[], int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}