// Check Array Sorted
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        return solve(arr , 0 , n-1, n);
    }
    private boolean solve(int arr[] , int low , int high , int n){
        if(low > high) return true;
        int mid = low + ( high - low) / 2;
        if((mid - 1) >= 0 && arr[mid - 1] > arr[mid]){
            return false;
        }
        if(mid + 1 < n && arr[mid+1] < arr[mid]){
            return false;
        }
        
        return solve(arr , low , mid - 1 , n) && solve(arr , mid + 1 , high , n);
    } 
}


// Alternate Solution

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        for(int i = 0; i < n-1;i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}