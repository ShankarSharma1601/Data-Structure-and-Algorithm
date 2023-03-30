// Linear Search in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    boolean search(int arr[] , int n , int key){
        for(int i = 0;i < n;i++){
            if(arr[i] == key){
                return true;
            }
        }
        return false;
    }
}