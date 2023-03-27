// Left Rotate an Array by One place
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution{
    public static void leftRotate(int arr[] , int n){
        int temp = arr[0];

        for(int i = 0;i < n-1;i++){
            arr[i] = arr[i+1];
        }

        arr[n-1] = temp;
    }
}