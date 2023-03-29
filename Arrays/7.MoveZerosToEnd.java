// Move all Zeros to end of Array
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    void pushZerosToEnd(int arr[] , int n){
        int start = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] != 0){
                swap(arr , i , start);
                start++;
            }
        }
    }
    private void swap(int arr[] , int ele1 , int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}